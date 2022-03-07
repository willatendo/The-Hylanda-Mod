package hylanda.content;

import hylanda.content.client.setup.ClientSetup;
import hylanda.content.server.init.HylandaBlocks;
import hylanda.content.server.init.HylandaEntities;
import hylanda.content.server.init.HylandaItems;
import hylanda.library.tab.ModTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.library.block.TyrannoSignManager;

@Mod(Util.HYLANDA_ID)
public class HylandaMod {
	public static final ModTab ITEMS = new ModTab("items");
	public static final ModTab BLOCKS = new ModTab("blocks");
	public static final ModTab TOOLS = new ModTab("tools");
	public static final ModTab WEAPONS = new ModTab("weapons");
	public static final ModTab SPAWN_EGGS = new ModTab("spawn_eggs");

	public HylandaMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);

		HylandaItems.init(bus);
		HylandaBlocks.init(bus);
		HylandaEntities.init(bus);

		TyrannoSignManager.registerSignBlock(() -> HylandaBlocks.BIOQUOIA_SIGN.get());
		TyrannoSignManager.registerSignBlock(() -> HylandaBlocks.BIOQUOIA_WALL_SIGN.get());
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		BLOCKS.setIcon(HylandaBlocks.SMITHY.get().asItem().getDefaultInstance());
		ITEMS.setIcon(HylandaItems.BEEF_AND_VEGETABLES.get().getDefaultInstance());
		SPAWN_EGGS.setIcon(HylandaItems.BIO_DEER_SPAWN_EGG.get().getDefaultInstance());
		TOOLS.setIcon(HylandaItems.ENERGISED_HATCHET.get().getDefaultInstance());
		WEAPONS.setIcon(HylandaItems.ENERGISED_SPEAR.get().getDefaultInstance());
	}

	private void clientSetup(FMLClientSetupEvent event) {
		ClientSetup.itemColourSetup();
		ClientSetup.setupBlock();
		ClientSetup.setupEntity();
	}
}
