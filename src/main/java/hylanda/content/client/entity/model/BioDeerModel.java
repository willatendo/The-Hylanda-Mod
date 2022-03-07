package hylanda.content.client.entity.model;

import hylanda.library.entity.BioDeerEntity;
import net.minecraft.resources.ResourceLocation;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.tyrannimation.core.event.predicate.AnimationEvent;
import tyrannotitanlib.tyrannimation.core.processor.IAnimatedBone;
import tyrannotitanlib.tyrannimation.model.AnimatedModel;
import tyrannotitanlib.tyrannimation.model.provider.data.EntityModelData;

public class BioDeerModel extends AnimatedModel<BioDeerEntity> {
	private static final ResourceLocation MODEL = Util.HYLANDA_UTILS.resource("geo/bio_deer.geo.json");
	private static final ResourceLocation MALE = Util.HYLANDA_UTILS.resource("textures/model/entity/bio_deer/male.png");
	private static final ResourceLocation FEMALE = Util.HYLANDA_UTILS.resource("textures/model/entity/bio_deer/female.png");
	private static final ResourceLocation ANIMATION = Util.HYLANDA_UTILS.resource("animations/bio_deer.animations.json");
	private static ResourceLocation texture;

	@Override
	public ResourceLocation getModelLocation(BioDeerEntity object) {
		return MODEL;
	}

	@Override
	public ResourceLocation getTextureLocation(BioDeerEntity object) {
		return texture;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BioDeerEntity animatable) {
		return ANIMATION;
	}

	@Override
	public void setLivingAnimations(BioDeerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		if (entity.getSex() == 1) {
			texture = FEMALE;
		} else {
			texture = MALE;
		}

		IAnimatedBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
