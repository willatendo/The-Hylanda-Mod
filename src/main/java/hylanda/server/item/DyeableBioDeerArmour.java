package hylanda.server.item;

import net.minecraft.world.item.DyeableLeatherItem;

public class DyeableBioDeerArmour extends BioDeerArmourItem implements DyeableLeatherItem {
	public DyeableBioDeerArmour(int protection, String texture, Properties properties) {
		super(protection, texture, properties);
	}
}
