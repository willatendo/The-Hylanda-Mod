package hylanda.content.client.entity.model;

import hylanda.library.entity.GojirasaurusEntity;
import net.minecraft.resources.ResourceLocation;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.tyrannimation.core.event.predicate.AnimationEvent;
import tyrannotitanlib.tyrannimation.core.processor.IAnimatedBone;
import tyrannotitanlib.tyrannimation.model.AnimatedModel;
import tyrannotitanlib.tyrannimation.model.provider.data.EntityModelData;

public class GojirasaurusModel extends AnimatedModel<GojirasaurusEntity> {
	private static final ResourceLocation MODEL = Util.HYLANDA_UTILS.resource("geo/gojirasaurus.geo.json");
	private static final ResourceLocation TEXTURE = Util.HYLANDA_UTILS.resource("textures/model/entity/gojirasaurus/texture.png");
	private static final ResourceLocation ANIMATION = Util.HYLANDA_UTILS.resource("animations/gojirasaurus.animations.json");

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

	@Override
	public void setLivingAnimations(GojirasaurusEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		IAnimatedBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
