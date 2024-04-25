package com.spirit.koil.api.bukkit.command;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.spirit.koil.api.bukkit.Bukkit;
import com.spirit.koil.api.bukkit.ChatColor;
import com.spirit.koil.api.bukkit.Location;
import com.spirit.koil.api.bukkit.Server;
import com.spirit.koil.api.bukkit.command.defaults.*;
import com.spirit.koil.api.bukkit.entity.Player;
import com.spirit.koil.api.bukkit.event.Event;
import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.plugin.Plugin;
import com.spirit.koil.api.bukkit.plugin.RegisteredListener;
import com.spirit.koil.api.bukkit.plugin.TimedRegisteredListener;
import com.spirit.koil.api.bukkit.util.StringUtil;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.world.SaveProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static com.spirit.koil.api.bukkit.command.Command.broadcastCommandMessage;
import static net.minecraft.server.command.ReloadCommand.tryReloadDataPacks;

public class SimpleCommandMap implements CommandMap {
    protected final Map<String, Command> knownCommands = new HashMap<String, Command>();
    @NotNull
    static String[] args = new String[0];
    static boolean separate = "separate".equalsIgnoreCase(args[0]);

    private final Server server;

    public static class BukkitCommand {
        public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
            dispatcher.register(CommandManager.literal("bukkit")
                    .then(CommandManager.literal("version")
                            .executes(BukkitCommand::executeVersion))
                    .then(CommandManager.literal("reload")
                            .executes(BukkitCommand::executeReload))
                    .then(CommandManager.literal("plugins")
                            .executes(BukkitCommand::executePlugins))
                    .then(CommandManager.literal("timings")
                            .then(CommandManager.literal("reset")
                                    .executes(BukkitCommand::executeTimingsreset))
                            .then(CommandManager.literal("merged")
                                    .executes(BukkitCommand::executeTimingsmerged))
                            .then(CommandManager.literal("separate")
                                    .executes(BukkitCommand::executeTimingsseparate))
                            .executes(BukkitCommand::executeTimings))
                    .executes(BukkitCommand::executeBukkit)
            );
            dispatcher.register(CommandManager.literal("plugins")
                    .executes(BukkitCommand::executePlugins)
            );
        }

        private static int executeVersion(CommandContext<ServerCommandSource> context) {
            context.getSource().sendMessage(Text.literal("This server is running " + Bukkit.getName() + " version " + Bukkit.getVersion() + " (Implementing API version " + Bukkit.getBukkitVersion() + ")"));
            return 1;
        }

        private static Collection<String> findNewDataPacks(ResourcePackManager dataPackManager, SaveProperties saveProperties, Collection<String> enabledDataPacks) {
            dataPackManager.scanPacks();
            Collection<String> collection = Lists.newArrayList(enabledDataPacks);
            Collection<String> collection2 = saveProperties.getDataConfiguration().dataPacks().getDisabled();
            Iterator var5 = dataPackManager.getNames().iterator();

            while(var5.hasNext()) {
                String string = (String)var5.next();
                if (!collection2.contains(string) && !collection.contains(string)) {
                    collection.add(string);
                }
            }

            return collection;
        }

        private static int executeReload(CommandContext<ServerCommandSource> context) {
            ServerCommandSource serverCommandSource = context.getSource();
            MinecraftServer minecraftServer = serverCommandSource.getServer();
            ResourcePackManager resourcePackManager = minecraftServer.getDataPackManager();
            SaveProperties saveProperties = minecraftServer.getSaveProperties();
            Collection<String> collection = resourcePackManager.getEnabledNames();
            Collection<String> collection2 = findNewDataPacks(resourcePackManager, saveProperties, collection);
            serverCommandSource.sendFeedback(() -> {
                return Text.literal("Reloading!");
            }, true);
            tryReloadDataPacks(collection2, serverCommandSource);

            broadcastCommandMessage((CommandSender) context, ChatColor.RED + "Please note that this command is not supported and may cause issues when using some plugins.");
            broadcastCommandMessage((CommandSender) context, ChatColor.RED + "If you encounter any issues please use the /stop command to restart your server.");
            Bukkit.reload();
            broadcastCommandMessage((CommandSender) context, ChatColor.GREEN + "Reload complete.");

            return 0;
        }

        private static int executePlugins(CommandContext<ServerCommandSource> context) {
            @NotNull Plugin owner = (Plugin) context.getSource();

            @NotNull String commandLabel = null;
            if (!owner.isEnabled()) {
                throw new CommandException("Cannot execute command '" + commandLabel + "' in plugin " + owner.getDescription().getFullName() + " - plugin is disabled.");
            }

            try {
            } catch (Throwable ex) {
                throw new CommandException("Unhandled exception executing command '" + commandLabel + "' in plugin " + owner.getDescription().getFullName(), ex);
            }
            return 1;
        }
        private static int executeTimings(CommandContext<ServerCommandSource> context) {
            if (args.length != 1) {
                context.getSource().sendMessage(Text.of(ChatColor.RED + "Usage: "));
                return 0;
            }
            if (!Bukkit.getPluginManager().useTimings()) {
                context.getSource().sendMessage(Text.of("Please enable timings by setting \"settings.plugin-profiling\" to true in bukkit.yml"));
                return 1;
            }

            else {
                context.getSource().sendMessage(Text.of(ChatColor.RED + "Usage: " + "/"));
                return 0;
            }
        }

        private static int executeTimingsreset(CommandContext<ServerCommandSource> context) {
            if ("reset".equalsIgnoreCase(args[0])) {
                for (HandlerList handlerList : HandlerList.getHandlerLists()) {
                    for (RegisteredListener listener : handlerList.getRegisteredListeners()) {
                        if (listener instanceof TimedRegisteredListener) {
                            ((TimedRegisteredListener) listener).reset();
                        }
                    }
                }
                context.getSource().sendMessage(Text.of("Timings reset"));
            }
            return 1;
        }

        private static int executeTimingsmerged(CommandContext<ServerCommandSource> context) {
                int index = 0;
                int pluginIdx = 0;
                File timingFolder = new File("timings");
                timingFolder.mkdirs();
                File timings = new File(timingFolder, "timings.txt");
                File names = null;
                while (timings.exists()) timings = new File(timingFolder, "timings" + (++index) + ".txt");
                PrintStream fileTimings = null;
                PrintStream fileNames = null;
                try {
                    fileTimings = new PrintStream(timings);
                    if (separate) {
                        names = new File(timingFolder, "names" + index + ".txt");
                        fileNames = new PrintStream(names);
                    }
                    for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                        pluginIdx++;
                        long totalTime = 0;
                        if (separate) {
                            fileNames.println(pluginIdx + " " + plugin.getDescription().getFullName());
                            fileTimings.println("Plugin " + pluginIdx);
                        } else {
                            fileTimings.println(plugin.getDescription().getFullName());
                        }
                        for (RegisteredListener listener : HandlerList.getRegisteredListeners(plugin)) {
                            if (listener instanceof TimedRegisteredListener) {
                                TimedRegisteredListener trl = (TimedRegisteredListener) listener;
                                long time = trl.getTotalTime();
                                int count = trl.getCount();
                                if (count == 0) continue;
                                long avg = time / count;
                                totalTime += time;
                                Class<? extends Event> eventClass = trl.getEventClass();
                                if (count > 0 && eventClass != null) {
                                    fileTimings.println("    " + eventClass.getSimpleName() + (trl.hasMultiple() ? " (and sub-classes)" : "") + " Time: " + time + " Count: " + count + " Avg: " + avg);
                                }
                            }
                        }
                        fileTimings.println("    Total time " + totalTime + " (" + totalTime / 1000000000 + "s)");
                    }
                    context.getSource().sendMessage(Text.of("Timings written to " + timings.getPath()));
                    if (separate) context.getSource().sendMessage(Text.of("Names written to " + names.getPath()));
                } catch (IOException e) {
                } finally {
                    if (fileTimings != null) {
                        fileTimings.close();
                    }
                    if (fileNames != null) {
                        fileNames.close();
                    }
                }
            return 1;
        }

        private static int executeTimingsseparate(CommandContext<ServerCommandSource> context) {
            context.getSource().sendMessage(Text.literal(""));
            return 1;
        }

        private static int executeBukkit(CommandContext<ServerCommandSource> context) {
            context.getSource().sendMessage(Text.literal(ChatColor.RED + "Unknown or incomplete command, see below for error\n" + ChatColor.GRAY + "bukkit" + ChatColor.RED + "<--[HERE]"));
            return 1;
        }
    }


    //-===========================================================-


    public SimpleCommandMap(@NotNull final Server server) {
        this.server = server;
        setDefaultCommands();
    }

    private void setDefaultCommands() {
        register("bukkit", new VersionCommand("version"));
        register("bukkit", new ReloadCommand("reload"));
        register("bukkit", new PluginsCommand("plugins"));
        register("bukkit", new TimingsCommand("timings"));
    }

    public void setFallbackCommands() {
        register("bukkit", new HelpCommand());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerAll(@NotNull String fallbackPrefix, @NotNull List<Command> commands) {
        if (commands != null) {
            for (Command c : commands) {
                register(fallbackPrefix, c);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean register(@NotNull String fallbackPrefix, @NotNull Command command) {
        return register(command.getName(), fallbackPrefix, command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean register(@NotNull String label, @NotNull String fallbackPrefix, @NotNull Command command) {
        label = label.toLowerCase(java.util.Locale.ENGLISH).trim();
        fallbackPrefix = fallbackPrefix.toLowerCase(java.util.Locale.ENGLISH).trim();
        boolean registered = register(label, command, false, fallbackPrefix);

        Iterator<String> iterator = command.getAliases().iterator();
        while (iterator.hasNext()) {
            if (!register(iterator.next(), command, true, fallbackPrefix)) {
                iterator.remove();
            }
        }

        // If we failed to register under the real name, we need to set the command label to the direct address
        if (!registered) {
            command.setLabel(fallbackPrefix + ":" + label);
        }

        // Register to us so further updates of the commands label and aliases are postponed until its reregistered
        command.register(this);

        return registered;
    }

    /**
     * Registers a command with the given name is possible. Also uses
     * fallbackPrefix to create a unique name.
     *
     * @param label the name of the command, without the '/'-prefix.
     * @param command the command to register
     * @param isAlias whether the command is an alias
     * @param fallbackPrefix a prefix which is prepended to the command for a
     *     unique address
     * @return true if command was registered, false otherwise.
     */
    private synchronized boolean register(@NotNull String label, @NotNull Command command, boolean isAlias, @NotNull String fallbackPrefix) {
        knownCommands.put(fallbackPrefix + ":" + label, command);
        if (isAlias && knownCommands.containsKey(label)) {
            // Request is for an alias/fallback command and it conflicts with
            // a existing command or previous alias ignore it
            // Note: This will mean it gets removed from the commands list of active aliases
            return false;
        }

        boolean registered = true;

        // If the command exists but is an alias we overwrite it, otherwise we return
        Command conflict = knownCommands.get(label);
        if (conflict != null && conflict.getLabel().equals(label)) {
            return false;
        }

        if (!isAlias) {
            command.setLabel(label);
        }
        knownCommands.put(label, command);

        return registered;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean dispatch(@NotNull CommandSender sender, @NotNull String commandLine) throws CommandException {
        String[] args = commandLine.split(" ");

        if (args.length == 0) {
            return false;
        }

        String sentCommandLabel = args[0].toLowerCase(java.util.Locale.ENGLISH);
        Command target = getCommand(sentCommandLabel);

        if (target == null) {
            return false;
        }

        try {
            // Note: we don't return the result of target.execute as thats success / failure, we return handled (true) or not handled (false)
            target.execute(sender, sentCommandLabel, Arrays.copyOfRange(args, 1, args.length));
        } catch (CommandException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new CommandException("Unhandled exception executing '" + commandLine + "' in " + target, ex);
        }

        // return true as command was handled
        return true;
    }

    @Override
    public synchronized void clearCommands() {
        for (Map.Entry<String, Command> entry : knownCommands.entrySet()) {
            entry.getValue().unregister(this);
        }
        knownCommands.clear();
        setDefaultCommands();
    }

    @Override
    @Nullable
    public Command getCommand(@NotNull String name) {
        Command target = knownCommands.get(name.toLowerCase(java.util.Locale.ENGLISH));
        return target;
    }

    @Override
    @Nullable
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String cmdLine) {
        return tabComplete(sender, cmdLine, null);
    }

    @Override
    @Nullable
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String cmdLine, @Nullable Location location) {
        Preconditions.checkArgument(sender != null, "Sender cannot be null");
        Preconditions.checkArgument(cmdLine != null, "Command line cannot null");

        int spaceIndex = cmdLine.indexOf(' ');

        if (spaceIndex == -1) {
            ArrayList<String> completions = new ArrayList<String>();
            Map<String, Command> knownCommands = this.knownCommands;

            final String prefix = (sender instanceof Player ? "/" : "");

            for (Map.Entry<String, Command> commandEntry : knownCommands.entrySet()) {
                Command command = commandEntry.getValue();

                if (!command.testPermissionSilent(sender)) {
                    continue;
                }

                String name = commandEntry.getKey(); // Use the alias, not command name

                if (StringUtil.startsWithIgnoreCase(name, cmdLine)) {
                    completions.add(prefix + name);
                }
            }

            Collections.sort(completions, String.CASE_INSENSITIVE_ORDER);
            return completions;
        }

        String commandName = cmdLine.substring(0, spaceIndex);
        Command target = getCommand(commandName);

        if (target == null) {
            return null;
        }

        if (!target.testPermissionSilent(sender)) {
            return null;
        }

        String[] args = cmdLine.substring(spaceIndex + 1, cmdLine.length()).split(" ", -1);

        try {
            return target.tabComplete(sender, commandName, args, location);
        } catch (CommandException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new CommandException("Unhandled exception executing tab-completer for '" + cmdLine + "' in " + target, ex);
        }
    }

    @NotNull
    public Collection<Command> getCommands() {
        return Collections.unmodifiableCollection(knownCommands.values());
    }

    public void registerServerAliases() {
        Map<String, String[]> values = server.getCommandAliases();

        for (Map.Entry<String, String[]> entry : values.entrySet()) {
            String alias = entry.getKey();
            if (alias.contains(" ")) {
                server.getLogger().warning("Could not register alias " + alias + " because it contains illegal characters");
                continue;
            }

            String[] commandStrings = entry.getValue();
            List<String> targets = new ArrayList<String>();
            StringBuilder bad = new StringBuilder();

            for (String commandString : commandStrings) {
                String[] commandArgs = commandString.split(" ");
                Command command = getCommand(commandArgs[0]);

                if (command == null) {
                    if (bad.length() > 0) {
                        bad.append(", ");
                    }
                    bad.append(commandString);
                } else {
                    targets.add(commandString);
                }
            }

            if (bad.length() > 0) {
                server.getLogger().warning("Could not register alias " + alias + " because it contains commands that do not exist: " + bad);
                continue;
            }

            // We register these as commands so they have absolute priority.
            if (targets.size() > 0) {
                knownCommands.put(alias.toLowerCase(java.util.Locale.ENGLISH), new FormattedCommandAlias(alias.toLowerCase(java.util.Locale.ENGLISH), targets.toArray(new String[targets.size()])));
            } else {
                knownCommands.remove(alias.toLowerCase(java.util.Locale.ENGLISH));
            }
        }
    }
}
