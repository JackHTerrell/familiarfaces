package io.github.itskilerluc.familiarfaces.server.entities;

import io.github.itskilerluc.familiarfaces.server.init.EntityTypeRegistry;
import io.github.itskilerluc.familiarfaces.server.init.ParticleTypeRegistry;
import io.github.itskilerluc.familiarfaces.server.init.SoundEventRegistry;
import io.github.itskilerluc.familiarfaces.server.util.AdvancedExplosion;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BreezeWindCharge extends AbstractWindCharge {
    private static final float RADIUS = 3.0F;

    public BreezeWindCharge(EntityType<? extends AbstractWindCharge> entityType, Level level) {
        super(entityType, level);
    }

    public BreezeWindCharge(Breeze breeze, Level level) {
        super(EntityTypeRegistry.BREEZE_WIND_CHARGE.get(), level, breeze, breeze.getX(), breeze.getEyeY() - 0.4, breeze.getZ());
    }

    @Override
    protected void explode(Vec3 pos) {
        AdvancedExplosion.explode(
                level(),
                this,
                null,
                EXPLOSION_DAMAGE_CALCULATOR,
                pos.x(),
                pos.y(),
                pos.z(),
                3.0F,
                false,
                Level.ExplosionInteraction.NONE,
                true,
                ParticleTypeRegistry.GUST_EMITTER_SMALL.get(),
                ParticleTypeRegistry.GUST_EMITTER_LARGE.get(),
                SoundEventRegistry.BREEZE_WIND_CHARGE_BURST.get()
        );
    }

    @Override
    protected float getEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return 0;
    }
}
