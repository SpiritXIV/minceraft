package com.spirit.mixin;

        import com.spirit.tdbtd.global.entity.TDBTDEntities;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.mob.WardenEntity;
        import net.minecraft.predicate.entity.EntityPredicates;
        import org.spongepowered.asm.mixin.Mixin;
        import org.spongepowered.asm.mixin.injection.At;
        import org.spongepowered.asm.mixin.injection.Inject;
        import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WardenEntity.class)
public abstract class WardenPassiveToEntityMixin {

    @Inject(method = "isValidTarget", at = @At("HEAD"), cancellable = true)
    private void onisValidTarget(Entity entity, CallbackInfoReturnable<Boolean> info) {
        if (entity instanceof LivingEntity livingEntity) {
            if (entity.getEntityWorld() != null &&
                    EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity) &&
                    livingEntity.getType() != TDBTDEntities.ABYSSOFIN &&
                    livingEntity.getType() != TDBTDEntities.APERTURENTEETH &&
                    livingEntity.getType() != TDBTDEntities.CODELAING &&
                    livingEntity.getType() != TDBTDEntities.CONTRIVANCEPOLLA &&
                    livingEntity.getType() != TDBTDEntities.CONTRIVANCEPOLLOONE &&
                    livingEntity.getType() != TDBTDEntities.CURATOR &&
                    livingEntity.getType() != TDBTDEntities.DEVASTADOR_CUR &&
                    livingEntity.getType() != TDBTDEntities.DEVASTADOR_HOUND &&
                    livingEntity.getType() != TDBTDEntities.DEVASTADOR_PUP &&
                    livingEntity.getType() != TDBTDEntities.ENGUIA &&
                    livingEntity.getType() != TDBTDEntities.KREDA &&
                    livingEntity.getType() != TDBTDEntities.MALDININKAS &&
                    livingEntity.getType() != TDBTDEntities.MIJAPENDRA &&
                    livingEntity.getType() != TDBTDEntities.NIDIVER &&
                    livingEntity.getType() != TDBTDEntities.PERICARPIUM &&
                    livingEntity.getType() != TDBTDEntities.SCUTLEON &&
                    livingEntity.getType() != TDBTDEntities.STURGO &&
                    livingEntity.getType() != TDBTDEntities.TENEBROUS_NIBBLER &&
                    !livingEntity.isInvulnerable() &&
                    entity.getEntityWorld().getWorldBorder().contains(livingEntity.getBoundingBox())) {
                info.setReturnValue(true);
            }
        }
        info.setReturnValue(false);
    }
}
