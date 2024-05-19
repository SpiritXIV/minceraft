package com.spirit.mixin;

import com.spirit.koil.accessor.LivingEntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements LivingEntityAccessor
{
	@Shadow public abstract boolean isPushable();

	@Shadow public abstract void updateLimbs(boolean flutter);
	
	@Shadow public abstract boolean isAlive();

	@Shadow public abstract float getHealth();

	@Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

	float punchProgress, prevPunchProgress;


	boolean punching;

	public LivingEntityMixin(EntityType<?> type, World world)
	{
		super(type, world);
	}


	@Override
	public float getPunchProgress(float tickDelta)
	{
		float f = punchProgress - prevPunchProgress;
		if (f < 0f)
			++f;
		return prevPunchProgress + f * tickDelta;
	}

	@Override
	public boolean IsPunching()
	{
		return punching;
	}

}