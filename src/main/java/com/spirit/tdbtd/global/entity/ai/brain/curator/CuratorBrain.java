package com.spirit.tdbtd.global.entity.ai.brain.curator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Dynamic;
import com.spirit.tdbtd.global.entity.custom.CuratorEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.BlockPosLookTarget;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class CuratorBrain {
	private static final float STROLL_SPEED = 0.5F;
	private static final float CELEBRATE_TIME = 0.7F;
	private static final float RANGED_APPROACH_SPEED = 1.2F;
	private static final int MELEE_ATTACK_INTERVAL = 18;
	private static final int DIG_DURATION = MathHelper.ceil(100.0F);
	public static final int EMERGE_DURATION = MathHelper.ceil(133.59999F);
	public static final int ROAR_DURATION = MathHelper.ceil(84.0F);
	private static final int SNIFF_DURATION = MathHelper.ceil(83.2F);
	public static final int DIG_COOLDOWN = 1200;
	private static final int field_38181 = 100;
	private static final List<SensorType<? extends Sensor<? super CuratorEntity>>> SENSORS;
	private static final List<MemoryModuleType<?>> MEMORY_MODULES;
	//private static final SingleTickTask RESET_DIG_COOLDOWN_TASK;

	public static void updateActivities(CuratorEntity curator) {
		curator.getBrain().resetPossibleActivities((List)ImmutableList.of(Activity.EMERGE, Activity.DIG, Activity.ROAR, Activity.FIGHT, Activity.INVESTIGATE, Activity.SNIFF, Activity.IDLE));
	}

	public static Brain<?> create(CuratorEntity curator, Dynamic<?> dynamic) {
		Brain.Profile<CuratorEntity> profile = Brain.createProfile(MEMORY_MODULES, SENSORS);
		Brain<CuratorEntity> brain = profile.deserialize(dynamic);
		/*
		addCoreActivities(brain);
		addEmergeActivities(brain);
		addDigActivities(brain);
		addIdleActivities(brain);
		addRoarActivities(brain);
		addFightActivities(curator, brain);
		addInvestigateActivities(brain);
		addSniffActivities(brain);
		 */
		brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
		brain.setDefaultActivity(Activity.IDLE);
		brain.resetPossibleActivities();
		return brain;
	}

	/*
	private static void addCoreActivities(Brain<CuratorEntity> brain) {
		brain.setTaskList(Activity.CORE, 0, ImmutableList.of(new StayAboveWaterTask(0.8F), LookAtDisturbanceTask.create(), new LookAroundTask(45, 90), new WanderAroundTask()));
	}

	private static void addEmergeActivities(Brain<CuratorEntity> brain) {
		brain.setTaskList(Activity.EMERGE, 5, (ImmutableList<? extends Task<? super CuratorEntity>>) ImmutableList.of(new EmergeTask(EMERGE_DURATION)), MemoryModuleType.IS_EMERGING);
	}

	private static void addDigActivities(Brain<CuratorEntity> brain) {
		brain.setTaskList(Activity.DIG, ImmutableList.of(Pair.of(0, new DismountVehicleTask()), Pair.of(1, new DigTask(DIG_DURATION))), ImmutableSet.of(Pair.of(MemoryModuleType.ROAR_TARGET, MemoryModuleState.VALUE_ABSENT), Pair.of(MemoryModuleType.DIG_COOLDOWN, MemoryModuleState.VALUE_ABSENT)));
	}

	private static void addCustomActivities(Brain<CuratorEntity> brain, Activity activity, int priority, List<Task<? super CuratorEntity>> tasks) {
		brain.setTaskList(activity, priority, ImmutableList.copyOf(tasks));
	}

	private static void addIdleActivities(Brain<CuratorEntity> brain) {
		ImmutableList idleTasks = ImmutableList.of(
				StartSniffingTask.create(),
				new RandomTask(ImmutableMap.of(MemoryModuleType.IS_SNIFFING, MemoryModuleState.VALUE_ABSENT), ImmutableList.of(
						Pair.of(StrollTask.create(0.5F), 2),
						Pair.of(new WaitTask(30, 60), 1)
				))
		);

		addCustomActivities(brain, Activity.IDLE, 10, idleTasks);
	}

	private static void addInvestigateActivities(Brain<CuratorEntity> brain) {
		List<Task<? super CuratorEntity>> investigateTasks = ImmutableList.of(
				WalkTowardsPosTask.create(MemoryModuleType.DISTURBANCE_LOCATION, 2, 0.7F)
		);

		addCustomActivities(brain, Activity.INVESTIGATE, 5, investigateTasks);
	}

	private static void addSniffActivities(Brain<CuratorEntity> brain) {
		List<Task<? super CuratorEntity>> sniffTasks = ImmutableList.of(
				new SniffTask(SNIFF_DURATION)
		);

		addCustomActivities(brain, Activity.SNIFF, 5, sniffTasks);
	}
	 */

/*
	private static void addRoarActivities(Brain<CuratorEntity> brain) {
		brain.setTaskList(Activity.ROAR, 10, (ImmutableList<? extends Task<? super CuratorEntity>>) ImmutableList.of(new RoarTask()), MemoryModuleType.ROAR_TARGET);
	}

	private static void addFightActivities(CuratorEntity curator, Brain<CuratorEntity> brain) {
		brain.setTaskList(Activity.FIGHT, 10, (ImmutableList<? extends Task<? super CuratorEntity>>) ImmutableList.of(RESET_DIG_COOLDOWN_TASK, ForgetAttackTargetTask.create((entity) -> {
			return !curator.getAngriness().isAngry() || !curator.isValidTarget(entity);
		}, CuratorBrain::removeDeadSuspect, false), LookAtMobTask.create((entity) -> {
			return isTargeting(curator, entity);
		}, (float)curator.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE)), RangedApproachTask.create(1.2F), new SonicBoomTask(), MeleeAttackTask.create(18)), MemoryModuleType.ATTACK_TARGET);
	}

	private static boolean isTargeting(CuratorEntity curator, LivingEntity entity) {
		return curator.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).filter((entityx) -> {
			return entityx == entity;
		}).isPresent();
	}


 */
	private static void removeDeadSuspect(CuratorEntity curator, LivingEntity suspect) {
		if (!curator.isValidTarget(suspect)) {
			curator.removeSuspect(suspect);
		}

		resetDigCooldownOne(curator);
	}

	public static void resetDigCooldown(VibrationCallback curator) {
		if (curator.getBrain().hasMemoryModule(MemoryModuleType.DIG_COOLDOWN)) {
			curator.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 1200L);
		}
	}

	public static void resetDigCooldownOne(CuratorEntity curator) {
		if (curator.getBrain().hasMemoryModule(MemoryModuleType.DIG_COOLDOWN)) {
			curator.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 1200L);
		}
	}

	public static void lookAtDisturbance(VibrationCallback curator, BlockPos pos) {
		if (curator.getWorld().getWorldBorder().contains(pos) && !curator.getPrimeSuspect().isPresent() && !curator.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).isPresent()) {
			resetDigCooldown(curator);
			curator.getBrain().remember(MemoryModuleType.SNIFF_COOLDOWN, Unit.INSTANCE, 100L);
			curator.getBrain().remember(MemoryModuleType.LOOK_TARGET, new BlockPosLookTarget(pos), 100L);
			curator.getBrain().remember(MemoryModuleType.DISTURBANCE_LOCATION, pos, 100L);
			curator.getBrain().forget(MemoryModuleType.WALK_TARGET);
		}
	}


	static {
		SENSORS = List.of(
				(SensorType<? extends Sensor<? super CuratorEntity>>) SensorType.NEAREST_LIVING_ENTITIES
		);

		MEMORY_MODULES = List.of(
				MemoryModuleType.MOBS,
				MemoryModuleType.VISIBLE_MOBS,
				MemoryModuleType.NEAREST_VISIBLE_PLAYER,
				MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER,
				MemoryModuleType.NEAREST_VISIBLE_NEMESIS,
				MemoryModuleType.LOOK_TARGET,
				MemoryModuleType.WALK_TARGET,
				MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
				MemoryModuleType.PATH,
				MemoryModuleType.ATTACK_TARGET,
				MemoryModuleType.ATTACK_COOLING_DOWN,
				MemoryModuleType.NEAREST_ATTACKABLE,
				MemoryModuleType.ROAR_TARGET,
				MemoryModuleType.DISTURBANCE_LOCATION,
				MemoryModuleType.RECENT_PROJECTILE,
				MemoryModuleType.IS_SNIFFING,
				MemoryModuleType.IS_EMERGING,
				MemoryModuleType.ROAR_SOUND_DELAY,
				MemoryModuleType.DIG_COOLDOWN,
				MemoryModuleType.ROAR_SOUND_COOLDOWN,
				MemoryModuleType.SNIFF_COOLDOWN,
				MemoryModuleType.TOUCH_COOLDOWN,
				MemoryModuleType.VIBRATION_COOLDOWN,
				MemoryModuleType.SONIC_BOOM_COOLDOWN,
				MemoryModuleType.SONIC_BOOM_SOUND_COOLDOWN,
				MemoryModuleType.SONIC_BOOM_SOUND_DELAY);
	}
}