package hylanda.content.client.setup;

import hylanda.content.client.entity.render.BioDeerRender;
import hylanda.content.client.entity.render.GojirasaurusRender;
import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.EntityInit;
import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.BIOQUOIA_LEAVES, RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BIOQUOIA_SAPLING, RenderType.cutout());

		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GOJIRASAURUS, manager -> new GojirasaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.BIO_DEER, manager -> new BioDeerRender(manager));
	}

	public static ItemColors itemColourSetup() {
		ItemColors itemcolours = new ItemColors();
		itemcolours.register((stack, dye) -> {
			return dye > 0 ? -1 : ((IDyeableArmorItem) stack.getItem()).getColor(stack);
		}, ItemInit.LEATHER_BIO_DEER_ARMOUR);
		return itemcolours;
	}
}
