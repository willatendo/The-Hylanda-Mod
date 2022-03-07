package hylanda.content.client.setup;

import hylanda.content.client.entity.render.BioDeerRender;
import hylanda.content.client.entity.render.GojirasaurusRender;
import hylanda.content.server.init.HylandaBlocks;
import hylanda.content.server.init.HylandaEntities;
import hylanda.content.server.init.HylandaItems;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
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

	public static void setupEntity() {
		EntityRenderers.register(HylandaEntities.GOJIRASAURUS.get(), context -> new GojirasaurusRender(context));
		EntityRenderers.register(HylandaEntities.BIO_DEER.get(), context -> new BioDeerRender(context));
	}
}
