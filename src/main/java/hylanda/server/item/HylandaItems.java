package hylanda.server.item;

import com.tterrag.registrate.util.entry.ItemEntry;

import hylanda.HylandaMod;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HylandaItems {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate().creativeModeTab(() -> HylandaMod.ITEMS, "Items");

	public static final ItemEntry<Item> BIO_DEER_PSEUDO_ANTLERS = REGISTRATE.item("bio_deer_pseudo_antlers", Item::new).register();
	public static final ItemEntry<Item> BIO_DEER_ANTLERS = REGISTRATE.item("bio_deer_antlers", Item::new).register();
	public static final ItemEntry<Item> DOE_BIO_HIDE = REGISTRATE.item("doe_bio_hide", Item::new).register();
	public static final ItemEntry<Item> BUCK_BIO_HIDE = REGISTRATE.item("buck_bio_hide", Item::new).register();
	public static final ItemEntry<Item> CAVE_SALAMANDER_EGG = REGISTRATE.item("cave_salamander_egg", Item::new).register();
	public static final ItemEntry<Item> BLUE_CORNIGERSUCHUS_CREST = REGISTRATE.item("blue_cornigersuchus_crest", Item::new).register();
	public static final ItemEntry<Item> ORANGE_CORNIGERSUCHUS_CREST = REGISTRATE.item("orange_cornigersuchus_crest", Item::new).register();
	public static final ItemEntry<Item> PURPLE_CORNIGERSUCHUS_CREST = REGISTRATE.item("purple_cornigersuchus_crest", Item::new).register();
	public static final ItemEntry<Item> RED_CORNIGERSUCHUS_CREST = REGISTRATE.item("red_cornigersuchus_crest", Item::new).register();
	public static final ItemEntry<Item> GOJIRASAURUS_DORSAL_PLATE = REGISTRATE.item("gojirasaurus_dorsal_plate", Item::new).register();
	public static final ItemEntry<Item> GOLDEN_SCALE = REGISTRATE.item("golden_scales", Item::new).register();
	public static final ItemEntry<Item> SLITHER_GEM = REGISTRATE.item("slither_gem", Item::new).register();
	public static final ItemEntry<Item> LEOSAURUS_CLAW = REGISTRATE.item("leosaurus_claw", Item::new).register();
	public static final ItemEntry<Item> RAW_VENISON = REGISTRATE.item("raw_venison", Item::new).properties(properties -> properties.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).meat().build())).register();
	public static final ItemEntry<Item> COOKED_VENISON = REGISTRATE.item("cooked_venison", Item::new).properties(properties -> properties.food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).meat().build())).register();
	public static final ItemEntry<Item> WITHER_BONE = REGISTRATE.item("wither_bone", Item::new).register();
	public static final ItemEntry<Item> GUIDE_BOOK = REGISTRATE.item("guide_book", Item::new).register();
	public static final ItemEntry<Item> OLD_BOOK = REGISTRATE.item("old_book", Item::new).register();

	public static final ItemEntry<Item> BEEF_AND_VEGETABLES = REGISTRATE.item("beef_and_vegetables", Item::new).properties(properties -> properties.food(new FoodProperties.Builder().nutrition(10).saturationMod(10.0F).meat().effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.4F).build())).register();

	static {
		REGISTRATE.creativeModeTab(() -> HylandaMod.WEAPONS, "Weapons");
	}

	public static final ItemEntry<Item> ENERGISED_SPEAR = REGISTRATE.item("energised_spear", Item::new).properties(properties -> properties.stacksTo(1)).register();

	static {
		REGISTRATE.creativeModeTab(() -> HylandaMod.TOOLS, "Tools");
	}

	public static final ItemEntry<Item> ENERGISED_HATCHET = REGISTRATE.item("energised_hatchet", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<OreFinderItem> ORE_FINDER = REGISTRATE.item("ore_finder", OreFinderItem::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<Item> FLEEING_CAP = REGISTRATE.item("fleeing_cap", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> HUNTERS_CAP = REGISTRATE.item("hunters_cap", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<Item> GLIDING_SUIT = REGISTRATE.item("gliding_suit", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<DyeableBioDeerArmour> LEATHER_GOJIRASAURUS_ARMOUR = REGISTRATE.item("leather_gojirasaurus_armor", DyeableBioDeerArmour::new).properties(properties -> properties.stacksTo(1)).color(() -> () -> new ItemColor() {
		@Override
		public int getColor(ItemStack itemStack, int layer) {
			return layer > 0 ? -1 : ((DyeableLeatherItem) itemStack.getItem()).getColor(itemStack);
		}
	}).register();
	public static final ItemEntry<Item> IRON_GOJIRASAURUS_ARMOUR = REGISTRATE.item("iron_gojirasaurus_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> GOLD_GOJIRASAURUS_ARMOUR = REGISTRATE.item("gold_gojirasaurus_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> DIAMOND_GOJIRASAURUS_ARMOUR = REGISTRATE.item("diamond_gojirasaurus_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> NETHERITE_GOJIRASAURUS_ARMOUR = REGISTRATE.item("netherite_gojirasaurus_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<Item> BIO_DEER_SADDLE = REGISTRATE.item("bio_deer_saddle", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<DyeableBioDeerArmour> LEATHER_BIO_DEER_ARMOUR = REGISTRATE.item("leather_bio_deer_armor", DyeableBioDeerArmour::new).properties(properties -> properties.stacksTo(1)).color(() -> () -> new ItemColor() {
		@Override
		public int getColor(ItemStack itemStack, int layer) {
			return layer > 0 ? -1 : ((DyeableLeatherItem) itemStack.getItem()).getColor(itemStack);
		}
	}).register();
	public static final ItemEntry<Item> IRON_BIO_DEER_ARMOUR = REGISTRATE.item("iron_bio_deer_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> GOLD_BIO_DEER_ARMOUR = REGISTRATE.item("gold_bio_deer_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> DIAMOND_BIO_DEER_ARMOUR = REGISTRATE.item("diamond_bio_deer_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> NETHERITE_BIO_DEER_ARMOUR = REGISTRATE.item("netherite_bio_deer_armor", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static void init() {
	}
}
