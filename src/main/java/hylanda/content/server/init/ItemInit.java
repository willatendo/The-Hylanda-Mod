package hylanda.content.server.init;

import hylanda.library.item.BasicItem;
import hylanda.library.item.DyeableBioDeerArmour;
import hylanda.library.util.ModUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.common.ForgeSpawnEggItem;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ItemInit {
	public static final Item BIO_DEER_PSEUDO_ANTLERS = BasicItem.create("bio_deer_pseudo_antlers");
	public static final Item BIO_DEER_ANTLERS = BasicItem.create("bio_deer_antlers");
	public static final Item DOE_BIO_HIDE = BasicItem.create("doe_bio_hide");
	public static final Item BUCK_BIO_HIDE = BasicItem.create("buck_bio_hide");
	public static final Item CAVE_SALAMANDER_EGG = BasicItem.create("cave_salamander_egg");
	public static final Item BLUE_CORNIGERSUCHUS_CREST = BasicItem.create("blue_cornigersuchus_crest");
	public static final Item ORANGE_CORNIGERSUCHUS_CREST = BasicItem.create("orange_cornigersuchus_crest");
	public static final Item PURPLE_CORNIGERSUCHUS_CREST = BasicItem.create("purple_cornigersuchus_crest");
	public static final Item RED_CORNIGERSUCHUS_CREST = BasicItem.create("red_cornigersuchus_crest");
	public static final Item GOJIRASAURUS_DORSAL_PLATE = BasicItem.create("gojirasaurus_dorsal_plate");
	public static final Item GOLDEN_SCALE = BasicItem.create("golden_scales");
	public static final Item SLITHER_GEM = BasicItem.create("slither_gem");
	public static final Item LEOSAURUS_CLAW = BasicItem.create("leosaurus_claw");
	public static final Item RAW_VENISON = BasicItem.create("raw_venison");
	public static final Item COOKED_VENISON = BasicItem.create("cooked_venison");
	public static final Item WITHER_BONE = BasicItem.create("wither_bone");
	public static final Item GUIDE_BOOK = BasicItem.create("guide_book");
	public static final Item OLD_BOOK = BasicItem.create("old_book");

	public static final Item BEEF_AND_VEGETABLES = BasicItem.create("beef_and_vegetables", new FoodProperties.Builder().nutrition(10).saturationMod(10.0F).effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.4F).build());

	public static final Item ENERGISED_SPEAR = BasicItem.create("energised_spear", new Properties().tab(ModUtils.WEAPONS).stacksTo(1));
	public static final Item ENERGISED_HATCHET = BasicItem.create("energised_hatchet", new Properties().tab(ModUtils.TOOLS).stacksTo(1));
	public static final Item ORE_FINDER = BasicItem.create("ore_finder", new Properties().tab(ModUtils.TOOLS).stacksTo(1));

	public static final Item FLEEING_CAP = BasicItem.create("fleeing_cap", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item HUNTERS_CAP = BasicItem.create("hunters_cap", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item GLIDING_SUIT = BasicItem.create("gliding_suit", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item LEATHER_GOJIRASAURUS_ARMOUR = BasicItem.create("leather_gojirasaurus_armour", new DyeableBioDeerArmour(new Properties().tab(ModUtils.ITEMS).stacksTo(1)));
	public static final Item IRON_GOJIRASAURUS_ARMOUR = BasicItem.create("iron_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item GOLD_GOJIRASAURUS_ARMOUR = BasicItem.create("gold_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item DIAMOND_GOJIRASAURUS_ARMOUR = BasicItem.create("diamond_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item NETHERITE_GOJIRASAURUS_ARMOUR = BasicItem.create("netherite_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item BIO_DEER_SADDLE = BasicItem.create("bio_deer_saddle", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item LEATHER_BIO_DEER_ARMOUR = BasicItem.create("leather_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item IRON_BIO_DEER_ARMOUR = BasicItem.create("iron_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item GOLD_BIO_DEER_ARMOUR = BasicItem.create("gold_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item DIAMOND_BIO_DEER_ARMOUR = BasicItem.create("diamond_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item NETHERITE_BIO_DEER_ARMOUR = BasicItem.create("netherite_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item GOJIRASAURUS_SPAWN_EGG = register("gojirasaurus_spawn_egg", new ForgeSpawnEggItem(() -> EntityInit.GOJIRASAURUS, 0x1e1e1c, 0x5d1311, new Item.Properties().tab(ModUtils.SPAWN_EGGS)));
	public static final Item BIO_DEER_SPAWN_EGG = register("bio_deer_spawn_egg", new ForgeSpawnEggItem(() -> EntityInit.BIO_DEER, 0x5cab9f, 0xb26d43, new Item.Properties().tab(ModUtils.SPAWN_EGGS)));

	public static void init() {
	}

	public static Item register(String id, Item item) {
		TyrannoRegister.registerItem(id, item);
		return item;
	}
}
