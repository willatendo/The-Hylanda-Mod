package hylanda.server.item;

import hylanda.HylandaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class GojirasaurusArmourItem extends Item {
	private final int protection;
	private final ResourceLocation texture;

	public GojirasaurusArmourItem(int protection, String texture, Properties properties) {
		super(properties);
		this.protection = protection;
		this.texture = HylandaMod.rL("textures/model/entity/gojirasaurus/" + texture + ".png");
	}

	public int getProtection() {
		return this.protection;
	}

	public ResourceLocation getTexture() {
		return this.texture;
	}
}
