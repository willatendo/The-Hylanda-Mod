package hylanda.content.client.entity.model;

import hylanda.library.entity.GojirasaurusEntity;
import hylanda.library.util.ModUtils;
import net.minecraft.resources.ResourceLocation;
import tyrannotitanlib.library.tyrannomation.model.TyrannomatedTyrannomationModel;

public class GojirasaurusModel extends TyrannomatedTyrannomationModel<GojirasaurusEntity> {
	private static final ResourceLocation MODEL = new ResourceLocation(ModUtils.ID, "geo/gojirasaurus.geo.json");
	private static final ResourceLocation TEXTURE = new ResourceLocation(ModUtils.ID, "textures/model/entity/gojirasaurus/texture.png");
	private static final ResourceLocation ANIMATION = new ResourceLocation(ModUtils.ID, "animations/gojirasaurus.animations.json");

	@Override
	public ResourceLocation getModelLocation(GojirasaurusEntity object) {
		return MODEL;
	}

	@Override
	public ResourceLocation getTextureLocation(GojirasaurusEntity object) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(GojirasaurusEntity animatable) {
		return ANIMATION;
	}

//	@Override
//	public void setLivingAnimations(GojirasaurusEntity entity, Integer uniqueID, TyrannomationEvent customPredicate) {
//		super.setLivingAnimations(entity, uniqueID, customPredicate);
//		IBone head = this.getBone("neck");
//
//		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
//		if (head != null) {
//			head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
//			head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//		}
//	}
}
