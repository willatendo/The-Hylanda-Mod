package hylanda.server.item;

import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;

import hylanda.HylandaMod;
import hylanda.server.HylandaTags;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class HylandaItems {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate().creativeModeTab(() -> HylandaMod.ITEMS, "Items");

	public static final ItemEntry<Item> BIO_DEER_PSEUDO_ANTLERS = REGISTRATE.item("bio_deer_pseudo_antlers", Item::new).tag(HylandaTags.Items.BIO_DEER_ANTLERS).register();
	public static final ItemEntry<Item> BIO_DEER_ANTLERS = REGISTRATE.item("bio_deer_antlers", Item::new).tag(HylandaTags.Items.BIO_DEER_ANTLERS).register();
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
	public static final ItemEntry<Item> STEEL_INGOT = REGISTRATE.item("steel_ingot", Item::new).recipe((item, provider) -> provider.smeltingAndBlasting(DataIngredient.items(Items.IRON_INGOT), item, 0.7F)).register();
	public static final ItemEntry<Item> STEEL_ROD = REGISTRATE.item("steel_rod", Item::new).recipe((item, provider) -> ShapedRecipeBuilder.shaped(item.get()).pattern("#").pattern("#").define('#', HylandaItems.STEEL_INGOT.get()).unlockedBy("has_item", provider.has(HylandaItems.STEEL_INGOT.get())).save(provider)).model((item, provider) -> provider.handheld(item)).register();

	public static final ItemEntry<Item> BEEF_AND_VEGETABLES = REGISTRATE.item("beef_and_vegetables", Item::new).properties(properties -> properties.food(new FoodProperties.Builder().nutrition(10).saturationMod(10.0F).meat().effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.4F).build())).register();

	static {
		REGISTRATE.creativeModeTab(() -> HylandaMod.WEAPONS, "Weapons");
	}

	public static final ItemEntry<Item> ENERGISED_SPEAR = REGISTRATE.item("energised_spear", Item::new).properties(properties -> properties.stacksTo(1)).recipe((item, provider) -> ShapedRecipeBuilder.shaped(item.get()).pattern(" $%").pattern(" @$").pattern("@  ").define('@', HylandaItems.STEEL_ROD.get()).define('$', HylandaItems.STEEL_INGOT.get()).define('%', HylandaItems.GOJIRASAURUS_DORSAL_PLATE.get()).unlockedBy("has_item", provider.has(HylandaItems.GOJIRASAURUS_DORSAL_PLATE.get())).save(provider)).register();

	static {
		REGISTRATE.creativeModeTab(() -> HylandaMod.TOOLS, "Tools");
	}

	public static final ItemEntry<Item> ENERGISED_HATCHET = REGISTRATE.item("energised_hatchet", Item::new).properties(properties -> properties.stacksTo(1)).recipe((item, provider) -> ShapedRecipeBuilder.shaped(item.get()).pattern("%$%").pattern(" @ ").pattern(" @ ").define('@', HylandaItems.STEEL_ROD.get()).define('$', HylandaItems.STEEL_INGOT.get()).define('%', HylandaItems.GOJIRASAURUS_DORSAL_PLATE.get()).unlockedBy("has_item", provider.has(HylandaItems.GOJIRASAURUS_DORSAL_PLATE.get())).save(provider)).register();
	public static final ItemEntry<OreFinderItem> ORE_FINDER = REGISTRATE.item("ore_finder", OreFinderItem::new).properties(properties -> properties.stacksTo(1)).recipe((item, provider) -> ShapedRecipeBuilder.shaped(item.get()).pattern("#%%").pattern("$!$").pattern("$&$").define('#', Items.REDSTONE_TORCH).define('%', Items.TINTED_GLASS).define('$', HylandaItems.GOLDEN_SCALE.get()).define('!', HylandaItems.SLITHER_GEM.get()).define('&', Items.GOLD_BLOCK).unlockedBy("has_item", provider.has(HylandaItems.STEEL_INGOT.get())).save(provider)).register();

	public static final ItemEntry<Item> FLEEING_CAP = REGISTRATE.item("fleeing_cap", Item::new).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<Item> HUNTERS_CAP = REGISTRATE.item("hunters_cap", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<DyeableGojirasaurusArmourItem> LEATHER_GOJIRASAURUS_ARMOUR = REGISTRATE.item("leather_gojirasaurus_armor", p -> new DyeableGojirasaurusArmourItem(3, "leather", p)).properties(properties -> properties.stacksTo(1)).color(() -> () -> new ItemColor() {
		@Override
		public int getColor(ItemStack itemStack, int layer) {
			return layer > 0 ? -1 : ((DyeableLeatherItem) itemStack.getItem()).getColor(itemStack);
		}
	}).register();
	public static final ItemEntry<GojirasaurusArmourItem> IRON_GOJIRASAURUS_ARMOUR = REGISTRATE.item("iron_gojirasaurus_armor", p -> new GojirasaurusArmourItem(5, "iron", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<GojirasaurusArmourItem> GOLD_GOJIRASAURUS_ARMOUR = REGISTRATE.item("gold_gojirasaurus_armor", p -> new GojirasaurusArmourItem(7, "gold", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<GojirasaurusArmourItem> DIAMOND_GOJIRASAURUS_ARMOUR = REGISTRATE.item("diamond_gojirasaurus_armor", p -> new GojirasaurusArmourItem(11, "diamond", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<GojirasaurusArmourItem> NETHERITE_GOJIRASAURUS_ARMOUR = REGISTRATE.item("netherite_gojirasaurus_armor", p -> new GojirasaurusArmourItem(17, "netherite", p)).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<Item> BIO_DEER_SADDLE = REGISTRATE.item("bio_deer_saddle", Item::new).properties(properties -> properties.stacksTo(1)).register();

	public static final ItemEntry<DyeableBioDeerArmour> LEATHER_BIO_DEER_ARMOUR = REGISTRATE.item("leather_bio_deer_armor", p -> new DyeableBioDeerArmour(3, "leather", p)).properties(properties -> properties.stacksTo(1)).color(() -> () -> new ItemColor() {
		@Override
		public int getColor(ItemStack itemStack, int layer) {
			return layer > 0 ? -1 : ((DyeableLeatherItem) itemStack.getItem()).getColor(itemStack);
		}
	}).recipe((item, provider) -> ShapedRecipeBuilder.shaped(item.get()).pattern("#$#").pattern("###").pattern("# #").define('#', Items.LEATHER).define('$', HylandaTags.Items.BIO_DEER_ANTLERS).unlockedBy("has_item", provider.has(HylandaTags.Items.BIO_DEER_ANTLERS)).save(provider)).register();
	public static final ItemEntry<BioDeerArmourItem> IRON_BIO_DEER_ARMOUR = REGISTRATE.item("iron_bio_deer_armor", p -> new BioDeerArmourItem(5, "iron", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<BioDeerArmourItem> GOLD_BIO_DEER_ARMOUR = REGISTRATE.item("gold_bio_deer_armor", p -> new BioDeerArmourItem(7, "gold", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<BioDeerArmourItem> DIAMOND_BIO_DEER_ARMOUR = REGISTRATE.item("diamond_bio_deer_armor", p -> new BioDeerArmourItem(11, "iron", p)).properties(properties -> properties.stacksTo(1)).register();
	public static final ItemEntry<BioDeerArmourItem> NETHERITE_BIO_DEER_ARMOUR = REGISTRATE.item("netherite_bio_deer_armor", p -> new BioDeerArmourItem(17, "netherite", p)).properties(properties -> properties.stacksTo(1)).register();

	public static void init() {
	}
}
