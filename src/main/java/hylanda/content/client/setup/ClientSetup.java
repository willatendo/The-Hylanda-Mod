package hylanda.content.client.setup;

import hylanda.content.client.entity.render.BioDeerRender;
import hylanda.content.client.entity.render.GojirasaurusRender;
import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.EntityInit;
import hylanda.content.server.init.ItemInit;
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
		}, ItemInit.LEATHER_BIO_DEER_ARMOUR);
		return itemcolours;
	}
	
	public static void setupBlock() {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIOQUOIA_LEAVES, RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIOQUOIA_SAPLING, RenderType.cutout());
	}
	
	public static void setupEntity() {
		EntityRenderers.register(EntityInit.GOJIRASAURUS, manager -> new GojirasaurusRender(manager));
		EntityRenderers.register(EntityInit.BIO_DEER, manager -> new BioDeerRender(manager));
	}
}
