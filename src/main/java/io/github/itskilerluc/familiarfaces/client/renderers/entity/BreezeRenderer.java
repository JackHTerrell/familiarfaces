package io.github.itskilerluc.familiarfaces.client.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.itskilerluc.familiarfaces.FamiliarFaces;
import io.github.itskilerluc.familiarfaces.client.models.entity.BreezeModel;
import io.github.itskilerluc.familiarfaces.server.entities.Breeze;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BreezeRenderer extends MobRenderer<Breeze, BreezeModel<Breeze>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(FamiliarFaces.MODID, "textures/entity/breeze/breeze.png");

    public BreezeRenderer(EntityRendererProvider.Context p_312679_) {
        super(p_312679_, new BreezeModel<>(p_312679_.bakeLayer(BreezeModel.BREEZE)), 0.5F);
        this.addLayer(new BreezeWindLayer(p_312679_, this));
        this.addLayer(new BreezeEyesLayer(this));
    }

    public void render(Breeze entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        BreezeModel<Breeze> breezemodel = this.getModel();
        enable(breezemodel, breezemodel.head(), breezemodel.rods());
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Breeze entity) {
        return TEXTURE_LOCATION;
    }

    public static BreezeModel<Breeze> enable(BreezeModel<Breeze> model, ModelPart... parts) {
        model.head().visible = false;
        model.eyes().visible = false;
        model.rods().visible = false;
        model.wind().visible = false;

        for (ModelPart modelpart : parts) {
            modelpart.visible = true;
        }

        return model;
    }
}
