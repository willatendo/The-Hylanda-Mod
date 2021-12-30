package hylanda.content.server.init;

import hylanda.library.item.DyeableBioDeerArmour;
import hylanda.library.item.ItemBuilder;
import hylanda.library.item.ModSpawnEggItem;
import hylanda.library.util.ModRegistry;
import hylanda.library.util.ModUtils;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemInit 
{
	public static final Item BIO_DEER_PSEUDO_ANTLERS = ItemBuilder.create("bio_deer_pseudo_antlers");
	public static final Item BIO_DEER_ANTLERS = ItemBuilder.create("bio_deer_antlers");
	public static final Item RADIANT_HIDE = ItemBuilder.create("radiant_hide");
	public static final Item BIO_HIDE = ItemBuilder.create("bio_hide");
	public static final Item CAVE_SALAMANDER_EGG = ItemBuilder.create("cave_salamander_egg");
	public static final Item BLUE_CORNIGERSUCHUS_CREST = ItemBuilder.create("blue_cornigersuchus_crest");
	public static final Item ORANGE_CORNIGERSUCHUS_CREST = ItemBuilder.create("orange_cornigersuchus_crest");
	public static final Item PURPLE_CORNIGERSUCHUS_CREST = ItemBuilder.create("purple_cornigersuchus_crest");
	public static final Item RED_CORNIGERSUCHUS_CREST = ItemBuilder.create("red_cornigersuchus_crest");
	public static final Item GOJIRASAURUS_DORSAL_PLATE = ItemBuilder.create("gojirasaurus_dorsal_plate");
	public static final Item GOLDEN_SCALE = ItemBuilder.create("golden_scale");
	public static final Item SLITHER_GEM = ItemBuilder.create("slither_gem");
	public static final Item LEOSAURUS_CLAW = ItemBuilder.create("leosaurus_claw");
	public static final Item RAW_VENISON = ItemBuilder.create("raw_venison");
	public static final Item COOKED_VENISON = ItemBuilder.create("cooked_venison");
	public static final Item WITHER_BONE = ItemBuilder.create("wither_bone");
	public static final Item GUIDE_BOOK = ItemBuilder.create("guide_book");
	public static final Item OLD_BOOK = ItemBuilder.create("old_book");

	public static final Item BEEF_AND_VEGETABLES = ItemBuilder.create("beef_and_vegetables", new Food.Builder().nutrition(10).saturationMod(10.0F).effect(new EffectInstance(Effects.POISON, 600, 0), 0.4F).build());

	public static final Item ENERGISED_SPEAR = ItemBuilder.create("energised_spear", new Properties().tab(ModUtils.WEPONDS).stacksTo(1));
	public static final Item ENERGISED_HATCHET = ItemBuilder.create("energised_hatchet", new Properties().tab(ModUtils.TOOLS).stacksTo(1));
	public static final Item ORE_FINDER = ItemBuilder.create("ore_finder", new Properties().tab(ModUtils.TOOLS).stacksTo(1));
	
	public static final Item FLEEING_CAP = ItemBuilder.create("fleeing_cap", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item HUNTERS_CAP = ItemBuilder.create("hunters_cap", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	
	public static final Item GLIDING_SUIT = ItemBuilder.create("gliding_suit", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	
	public static final Item LEATHER_GOJIRASAURUS_ARMOUR = ItemBuilder.create("leather_gojirasaurus_armour", new DyeableBioDeerArmour(new Properties().tab(ModUtils.ITEMS).stacksTo(1)));
	public static final Item IRON_GOJIRASAURUS_ARMOUR = ItemBuilder.create("iron_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item GOLD_GOJIRASAURUS_ARMOUR = ItemBuilder.create("gold_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item DIAMOND_GOJIRASAURUS_ARMOUR = ItemBuilder.create("diamond_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item NETHERITE_GOJIRASAURUS_ARMOUR = ItemBuilder.create("netherite_gojirasaurus_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item BIO_DEER_SADDLE = ItemBuilder.create("bio_deer_saddle", new Properties().tab(ModUtils.ITEMS).stacksTo(1));

	public static final Item LEATHER_BIO_DEER_ARMOUR = ItemBuilder.create("leather_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item IRON_BIO_DEER_ARMOUR = ItemBuilder.create("iron_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item GOLD_BIO_DEER_ARMOUR = ItemBuilder.create("gold_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item DIAMOND_BIO_DEER_ARMOUR = ItemBuilder.create("diamond_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	public static final Item NETHERITE_BIO_DEER_ARMOUR = ItemBuilder.create("netherite_bio_deer_armour", new Properties().tab(ModUtils.ITEMS).stacksTo(1));
	
	public static final Item GOJIRASAURUS_SPAWN_EGG = ModRegistry.register("gojirasaurus_spawn_egg", new ModSpawnEggItem(() -> EntityInit.GOJIRASAURUS, 0x1e1e1c, 0x5d1311, new Item.Properties().tab(ModUtils.SPAWN_EGGS)));
	public static final Item BIO_DEER_SPAWN_EGG = ModRegistry.register("bio_deer_spawn_egg", new ModSpawnEggItem(() -> EntityInit.BIO_DEER, 0x5cab9f, 0xb26d43, new Item.Properties().tab(ModUtils.SPAWN_EGGS)));
	
	public static void init() { }
}
