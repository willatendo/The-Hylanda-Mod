package hylanda;

import com.tterrag.registrate.util.nullness.NonNullSupplier;

import hylanda.client.setup.ClientSetup;
import hylanda.server.block.HylandaBlocks;
import hylanda.server.entity.HylandaEntities;
import hylanda.server.item.HylandaItems;
import hylanda.server.tab.ModTab;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import tyrannotitanlib.core.content.UtilitiesRegistry;
import tyrannotitanlib.library.block.TyrannoSignManager;

@Mod(HylandaMod.ID)
public class HylandaMod {
	public static final String ID = "hylanda";
	public static final UtilitiesRegistry UTILITES = new UtilitiesRegistry(ID);
	public static final NonNullSupplier<HylandaRegistrate> CENTRAL_REGISTRATE = HylandaRegistrate.lazy(ID);

	public static final ModTab ITEMS = new ModTab("items");
	public static final ModTab BLOCKS = new ModTab("blocks");
	public static final ModTab TOOLS = new ModTab("tools");
	public static final ModTab WEAPONS = new ModTab("weapons");
	public static final ModTab SPAWN_EGGS = new ModTab("spawn_eggs");

	public HylandaMod() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);

		GeckoLib.initialize();

		HylandaItems.init(bus);
		HylandaBlocks.init(bus);
		HylandaEntities.init();

		TyrannoSignManager.registerSignBlock(() -> HylandaBlocks.BIOQUOIA_SIGN.get());
		TyrannoSignManager.registerSignBlock(() -> HylandaBlocks.BIOQUOIA_WALL_SIGN.get());
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		BLOCKS.setIcon(HylandaBlocks.SMITHY.get().asItem().getDefaultInstance());
		ITEMS.setIcon(HylandaItems.BEEF_AND_VEGETABLES.get().getDefaultInstance());
		SPAWN_EGGS.setIcon(Items.WANDERING_TRADER_SPAWN_EGG.getDefaultInstance());
		TOOLS.setIcon(HylandaItems.ENERGISED_HATCHET.get().getDefaultInstance());
		WEAPONS.setIcon(HylandaItems.ENERGISED_SPEAR.get().getDefaultInstance());
	}

	private void clientSetup(FMLClientSetupEvent event) {
		ClientSetup.itemColourSetup();
		ClientSetup.setupBlock();
	}
}
