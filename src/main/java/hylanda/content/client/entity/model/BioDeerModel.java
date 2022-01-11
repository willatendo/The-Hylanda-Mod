package hylanda.content.client.entity.model;

import hylanda.library.entity.BioDeerEntity;
import hylanda.library.util.ModUtils;
import net.minecraft.resources.ResourceLocation;
import tyrannotitanlib.library.tyrannomation.core.event.predicate.TyrannomationEvent;
import tyrannotitanlib.library.tyrannomation.core.processor.IBone;
import tyrannotitanlib.library.tyrannomation.model.TyrannomatedTyrannomationModel;
import tyrannotitanlib.library.tyrannomation.model.provider.data.EntityModelData;

public class BioDeerModel extends TyrannomatedTyrannomationModel<BioDeerEntity> {
	private static final ResourceLocation MODEL = new ResourceLocation(ModUtils.ID, "geo/bio_deer.geo.json");
	private static final ResourceLocation MALE = new ResourceLocation(ModUtils.ID, "textures/model/entity/bio_deer/male.png");
	private static final ResourceLocation FEMALE = new ResourceLocation(ModUtils.ID, "textures/model/entity/bio_deer/female.png");
	private static final ResourceLocation ANIMATION = new ResourceLocation(ModUtils.ID, "animations/bio_deer.animations.json");
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
	public void setLivingAnimations(BioDeerEntity entity, Integer uniqueID, TyrannomationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		if (entity.getSex() == 1) {
			texture = FEMALE;
		} else {
			texture = MALE;
		}

		if (customPredicate == null) {
			return;
		}

		EntityModelData extraData = getExtraData(customPredicate, EntityModelData.class);

		IBone head = this.getAnimationProcessor().getBone("head");
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
	}

	private static <T> T getExtraData(TyrannomationEvent customPredicate, Class<T> clazz) {
		return (T) customPredicate.getExtraDataOfType(clazz).get(0);
	}
}
