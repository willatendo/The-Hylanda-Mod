package hylanda.content.server.init;

import hylanda.content.HylandaMod;
import hylanda.library.item.DyeableBioDeerArmour;
import hylanda.library.item.OreFinderItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tyrannotitanlib.core.content.Util;

public class HylandaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Util.HYLANDA_ID);

	public static final RegistryObject<Item> BIO_DEER_PSEUDO_ANTLERS = ITEMS.register("bio_deer_pseudo_antlers", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> BIO_DEER_ANTLERS = ITEMS.register("bio_deer_antlers", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> DOE_BIO_HIDE = ITEMS.register("doe_bio_hide", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> BUCK_BIO_HIDE = ITEMS.register("buck_bio_hide", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> CAVE_SALAMANDER_EGG = ITEMS.register("cave_salamander_egg", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> BLUE_CORNIGERSUCHUS_CREST = ITEMS.register("blue_cornigersuchus_crest", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> ORANGE_CORNIGERSUCHUS_CREST = ITEMS.register("orange_cornigersuchus_crest", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> PURPLE_CORNIGERSUCHUS_CREST = ITEMS.register("purple_cornigersuchus_crest", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> RED_CORNIGERSUCHUS_CREST = ITEMS.register("red_cornigersuchus_crest", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> GOJIRASAURUS_DORSAL_PLATE = ITEMS.register("gojirasaurus_dorsal_plate", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> GOLDEN_SCALE = ITEMS.register("golden_scales", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> SLITHER_GEM = ITEMS.register("slither_gem", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> LEOSAURUS_CLAW = ITEMS.register("leosaurus_claw", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> RAW_VENISON = ITEMS.register("raw_venison", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> COOKED_VENISON = ITEMS.register("cooked_venison", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> GUIDE_BOOK = ITEMS.register("guide_book", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));
	public static final RegistryObject<Item> OLD_BOOK = ITEMS.register("old_book", () -> new Item(new Properties().tab(HylandaMod.ITEMS)));

	private static final FoodProperties BEEF_AND_VEGETABLES_FOOD = new FoodProperties.Builder().nutrition(10).saturationMod(10.0F).effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.4F).build();
	public static final RegistryObject<Item> BEEF_AND_VEGETABLES = ITEMS.register("beef_and_vegetables", () -> new Item(new Properties().food(BEEF_AND_VEGETABLES_FOOD).tab(HylandaMod.ITEMS)));

	public static final RegistryObject<Item> ENERGISED_SPEAR = ITEMS.register("energised_spear", () -> new Item(new Properties().stacksTo(1).tab(HylandaMod.WEAPONS)));
	public static final RegistryObject<Item> ENERGISED_HATCHET = ITEMS.register("energised_hatchet", () -> new Item(new Properties().stacksTo(1).tab(HylandaMod.TOOLS)));
	public static final RegistryObject<Item> ORE_FINDER = ITEMS.register("ore_finder", () -> new OreFinderItem(new Properties().stacksTo(1).tab(HylandaMod.TOOLS)));

	public static final RegistryObject<Item> FLEEING_CAP = ITEMS.register("fleeing_cap", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> HUNTERS_CAP = ITEMS.register("hunters_cap", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));

	public static final RegistryObject<Item> GLIDING_SUIT = ITEMS.register("gliding_suit", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));

	public static final RegistryObject<Item> LEATHER_GOJIRASAURUS_ARMOUR = ITEMS.register("leather_gojirasaurus_armour", () -> new DyeableBioDeerArmour(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> IRON_GOJIRASAURUS_ARMOUR = ITEMS.register("iron_gojirasaurus_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> GOLD_GOJIRASAURUS_ARMOUR = ITEMS.register("gold_gojirasaurus_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> DIAMOND_GOJIRASAURUS_ARMOUR = ITEMS.register("diamond_gojirasaurus_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> NETHERITE_GOJIRASAURUS_ARMOUR = ITEMS.register("netherite_gojirasaurus_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));

	public static final RegistryObject<Item> BIO_DEER_SADDLE = ITEMS.register("bio_deer_saddle", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));

	public static final RegistryObject<Item> LEATHER_BIO_DEER_ARMOUR = ITEMS.register("leather_bio_deer_armour", () -> new DyeableBioDeerArmour(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> IRON_BIO_DEER_ARMOUR = ITEMS.register("iron_bio_deer_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> GOLD_BIO_DEER_ARMOUR = ITEMS.register("gold_bio_deer_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> DIAMOND_BIO_DEER_ARMOUR = ITEMS.register("diamond_bio_deer_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));
	public static final RegistryObject<Item> NETHERITE_BIO_DEER_ARMOUR = ITEMS.register("netherite_bio_deer_armour", () -> new Item(new Properties().tab(HylandaMod.ITEMS).stacksTo(1)));

	public static final RegistryObject<Item> GOJIRASAURUS_SPAWN_EGG = ITEMS.register("gojirasaurus_spawn_egg", () -> new ForgeSpawnEggItem(() -> HylandaEntities.GOJIRASAURUS.get(), 0x1e1e1c, 0x5d1311, new Item.Properties().tab(HylandaMod.SPAWN_EGGS)));
	public static final RegistryObject<Item> BIO_DEER_SPAWN_EGG = ITEMS.register("bio_deer_spawn_egg", () -> new ForgeSpawnEggItem(() -> HylandaEntities.BIO_DEER.get(), 0x5cab9f, 0xb26d43, new Item.Properties().tab(HylandaMod.SPAWN_EGGS)));

	public static void init(IEventBus bus) {
		ITEMS.register(bus);
	}
}
