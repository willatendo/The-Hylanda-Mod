package hylanda.client.setup;

import hylanda.server.block.HylandaBlocks;
import hylanda.server.item.HylandaItems;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeableLeatherItem;

public class ClientSetup {
	public static ItemColors itemColourSetup() {
		ItemColors itemcolours = new ItemColors();
		itemcolours.register((stack, dye) -> {
			return dye > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack);
		}, HylandaItems.LEATHER_BIO_DEER_ARMOUR.get(), HylandaItems.LEATHER_GOJIRASAURUS_ARMOUR.get());
		return itemcolours;
	}

	public static void setupBlock() {
		ItemBlockRenderTypes.setRenderLayer(HylandaBlocks.BIOQUOIA_LEAVES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HylandaBlocks.BIOQUOIA_SAPLING.get(), RenderType.cutout());
	}
}
