package hylanda.client.entity.model;

import hylanda.HylandaMod;
import hylanda.server.entity.BioDeer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BioDeerModel extends AnimatedGeoModel<BioDeer> {
	private static final ResourceLocation MODEL = HylandaMod.rL("geo/bio_deer.geo.json");
	private static final ResourceLocation MALE = HylandaMod.rL("textures/model/entity/bio_deer/male.png");
	private static final ResourceLocation FEMALE = HylandaMod.rL("textures/model/entity/bio_deer/female.png");
	private static final ResourceLocation ANIMATION = HylandaMod.rL("animations/bio_deer.animations.json");
	private static ResourceLocation texture;

	@Override
	public ResourceLocation getModelLocation(BioDeer object) {
		return MODEL;
	}

	@Override
	public ResourceLocation getTextureLocation(BioDeer object) {
		return texture;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BioDeer animatable) {
		return ANIMATION;
	}

	@Override
	public void setLivingAnimations(BioDeer entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		if (entity.getSex() == 1) {
			texture = FEMALE;
		} else {
			texture = MALE;
		}

		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
