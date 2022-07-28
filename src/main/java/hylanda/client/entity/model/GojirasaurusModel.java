package hylanda.client.entity.model;

import hylanda.HylandaMod;
import hylanda.server.entity.Gojirasaurus;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GojirasaurusModel extends AnimatedGeoModel<Gojirasaurus> {
	private static final ResourceLocation MODEL = HylandaMod.rL("geo/gojirasaurus.geo.json");
	private static final ResourceLocation TEXTURE = HylandaMod.rL("textures/model/entity/gojirasaurus/texture.png");
	private static final ResourceLocation ANIMATION = HylandaMod.rL("animations/gojirasaurus.animations.json");

	@Override
	public ResourceLocation getModelLocation(Gojirasaurus object) {
		return MODEL;
	}

	@Override
	public ResourceLocation getTextureLocation(Gojirasaurus object) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(Gojirasaurus animatable) {
		return ANIMATION;
	}

	@Override
	public void setLivingAnimations(Gojirasaurus entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
