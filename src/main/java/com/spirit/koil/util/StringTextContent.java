package com.spirit.koil.util;

import net.minecraft.text.TextContent;
import net.minecraft.text.Style;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

public class StringTextContent implements TextContent {
    private final String content;

    public StringTextContent(String content) {
        this.content = content;
    }

    @Override
    public <T> Optional<T> visit(StringVisitable.StyledVisitor<T> visitor, Style style) {
        return Optional.empty();
    }

    @Override
    public <T> Optional<T> visit(StringVisitable.Visitor<T> visitor) {
        return Optional.empty();
    }

    @Override
    public MutableText parse(@Nullable ServerCommandSource source, @Nullable Entity sender, int depth) {
        return MutableText.of(this); // Assumes MutableText.of() exists in your version
    }

    @Override
    public String toString() {
        return content;
    }

}
