package hylanda.client.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import hylanda.client.entity.model.BioDeerModel;
import hylanda.server.entity.BioDeer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BioDeerRender extends GeoEntityRenderer<BioDeer> {
	public BioDeerRender(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BioDeerModel());
		this.shadowRadius = 0.6F;
	}

	@Override
	public RenderType getRenderType(BioDeer entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		if (entity.isBaby()) {
			stack.scale(0.3F, 0.3F, 0.3F);
		} else {
			stack.scale(1.0F, 1.0F, 1.0F);
		}

		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
