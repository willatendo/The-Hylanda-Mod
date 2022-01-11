package hylanda.content;

import hylanda.content.client.setup.ClientSetup;
import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModRegistry;
import hylanda.library.util.ModUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tyrannotitanlib.library.base.block.TyrannoSignManager;

@Mod(ModUtils.ID)
public class HylandaMod {
	public HylandaMod() {
		ModUtils.LOGGER.debug("Starting: Hylanda Registry");

		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);

		ModRegistry.registry();
		
		TyrannoSignManager.registerSignBlock(() -> BlockInit.BIOQUOIA_SIGN);
		TyrannoSignManager.registerSignBlock(() -> BlockInit.BIOQUOIA_WALL_SIGN);

		ModUtils.LOGGER.debug("Finished: Hylanda Registry");
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		ModUtils.BLOCKS.setIcon(BlockInit.SMITHY.asItem().getDefaultInstance());
		ModUtils.ITEMS.setIcon(ItemInit.BEEF_AND_VEGETABLES.asItem().getDefaultInstance());
		ModUtils.SPAWN_EGGS.setIcon(ItemInit.BIO_DEER_SPAWN_EGG.asItem().getDefaultInstance());
		ModUtils.TOOLS.setIcon(ItemInit.ENERGISED_HATCHET.asItem().getDefaultInstance());
		ModUtils.WEAPONS.setIcon(ItemInit.ENERGISED_SPEAR.asItem().getDefaultInstance());
	}

	private void clientSetup(FMLClientSetupEvent event) {
		ClientSetup.itemColourSetup();
		ClientSetup.setupBlock();
		ClientSetup.setupEntity();
	}
}
