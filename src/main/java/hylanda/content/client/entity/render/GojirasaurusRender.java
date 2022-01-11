package hylanda.content.client.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import hylanda.content.client.entity.model.GojirasaurusModel;
import hylanda.library.entity.GojirasaurusEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tyrannotitanlib.library.tyrannomation.renderers.TyrannomationEntityRenderer;

public class GojirasaurusRender extends TyrannomationEntityRenderer<GojirasaurusEntity> {
	public GojirasaurusRender(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GojirasaurusModel());
		this.shadowRadius = 1.0F;
	}

	@Override
	public RenderType getRenderType(GojirasaurusEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		if (entity.isBaby()) {
			stack.scale(0.3F, 0.3F, 0.3F);
		} else {
			stack.scale(1.0F, 1.0F, 1.0F);
		}

		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
