package hylanda.client.entity.render;

import hylanda.HylandaMod;
import hylanda.client.entity.model.DetectedOreBlockModel;
import hylanda.server.entity.DetectedOreBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DetectedOreBlockRender extends MobRenderer<DetectedOreBlock, DetectedOreBlockModel> {
	public static final ResourceLocation TEXTURE = HylandaMod.rL("textures/model/entity/detected_ore_block.png");
	public static final ResourceLocation OUTLINE = HylandaMod.rL("textures/model/entity/detected_ore_block_outline.png");

	public DetectedOreBlockRender(EntityRendererProvider.Context context) {
		super(context, new DetectedOreBlockModel(context.bakeLayer(DetectedOreBlockModel.LAYER_LOCATION)), 0.0F);
	}

	@Override
	protected RenderType getRenderType(DetectedOreBlock detectedOreBlock, boolean isBodyVisable, boolean isVisableToPlayer, boolean glowing) {
		return RenderType.outline(OUTLINE);
	}

	@Override
	public ResourceLocation getTextureLocation(DetectedOreBlock detectedOreBlock) {
		return TEXTURE;
	}
}
