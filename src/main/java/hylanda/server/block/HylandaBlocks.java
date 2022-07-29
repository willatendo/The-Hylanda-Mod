package hylanda.server.block;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;

import hylanda.HylandaMod;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.ConfiguredModel;

public class HylandaBlocks {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate().creativeModeTab(() -> HylandaMod.BLOCKS, "Blocks");

	private static final WoodType BIOQUOIA = WoodType.register(WoodType.create("bioquoia"));

	public static final BlockEntry<Block> GOLDEN_BRICKS = REGISTRATE.block("golden_bricks", Block::new).properties(properties -> properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops()).simpleItem().register();
	public static final BlockEntry<Block> STEEL_BLOCK = REGISTRATE.block("steel_block", Block::new).properties(properties -> properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)).simpleItem().register();

	public static final BlockEntry<SmithyBlock> SMITHY = REGISTRATE.block("smithy", SmithyBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()).blockstate((block, provider) -> provider.horizontalBlock(block.get(), state -> provider.models().withExistingParent("smithy_" + state.getValue(SmithyBlock.PARTS).toString(), HylandaMod.rL("block/" + state.getValue(SmithyBlock.PARTS).toString() + "_smithy")))).loot((provider, block) -> provider.add(block, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SmithyBlock.PARTS, SmithyParts.LEFT)))).when(ExplosionCondition.survivesExplosion())))).item().model((item, provider) -> provider.withExistingParent("smithy", HylandaMod.rL("block/smithy_inventory"))).build().register();

	public static final BlockEntry<BioquoiaGrassBlock> BIOQUOIA_GRASS = REGISTRATE.block("bioquoia_grass", BioquoiaGrassBlock::new).properties(properites -> properites.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).randomTicks().sound(SoundType.GRAVEL)).blockstate((block, provider) -> provider.getVariantBuilder(block.get()).partialState().addModels(new ConfiguredModel(provider.models().withExistingParent("bioquoia_grass", new ResourceLocation("block/cube_bottom_top")).texture("top", HylandaMod.rL("block/bioquoia_grass_top")).texture("bottom", new ResourceLocation("block/dirt")).texture("side", HylandaMod.rL("block/bioquoia_grass_side"))))).loot((provider, block) -> provider.add(block, provider.createSingleItemTableWithSilkTouch(block, Blocks.DIRT))).simpleItem().register();

	public static final BlockEntry<RotatedPillarBlock> BIOQUOIA_LOG = REGISTRATE.block("bioquoia_log", RotatedPillarBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.logBlock(block.get())).simpleItem().register();
	public static final BlockEntry<RotatedPillarBlock> STRIPPED_BIOQUOIA_LOG = REGISTRATE.block("stripped_bioquoia_log", RotatedPillarBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)).setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop()).item().setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop()).build().register();
	public static final BlockEntry<RotatedPillarBlock> BIOQUOIA_WOOD = REGISTRATE.block("bioquoia_wood", RotatedPillarBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.axisBlock(block.get(), HylandaMod.rL("block/bioquoia_log"), HylandaMod.rL("block/bioquoia_log"))).simpleItem().register();
	public static final BlockEntry<RotatedPillarBlock> STRIPPED_BIOQUOIA_WOOD = REGISTRATE.block("stripped_bioquoia_wood", RotatedPillarBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)).setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop()).item().setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop()).build().register();
	public static final BlockEntry<LeavesBlock> BIOQUOIA_LEAVES = REGISTRATE.block("bioquoia_leaves", LeavesBlock::new).properties(properties -> properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(HylandaBlocks::ocelotOrParrot).isSuffocating(HylandaBlocks::never).isViewBlocking(HylandaBlocks::never)).addLayer(() -> RenderType::cutout).simpleItem().register();
	public static final BlockEntry<SaplingBlock> BIOQUOIA_SAPLING = REGISTRATE.block("bioquoia_sapling", p -> new SaplingBlock(null, p)).properties(properties -> properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)).blockstate((block, provider) -> provider.getVariantBuilder(block.get()).partialState().addModels(new ConfiguredModel(provider.models().cross("bioquoia_sapling", HylandaMod.rL("block/bioquoia_sapling"))))).item().model((item, provider) -> provider.generated(item, HylandaMod.rL("block/bioquoia_sapling"))).build().addLayer(() -> RenderType::cutout).register();
	public static final BlockEntry<Block> BIOQUOIA_PLANKS = REGISTRATE.block("bioquoia_planks", Block::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)).simpleItem().register();
	public static final BlockEntry<StairBlock> BIOQUOIA_STAIRS = REGISTRATE.block("bioquoia_stairs", p -> new StairBlock(() -> HylandaBlocks.BIOQUOIA_PLANKS.get().defaultBlockState(), p)).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.stairsBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"))).simpleItem().register();
	public static final BlockEntry<SlabBlock> BIOQUOIA_SLAB = REGISTRATE.block("bioquoia_slab", SlabBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.slabBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"), HylandaMod.rL("block/bioquoia_planks"))).simpleItem().register();
	public static final BlockEntry<FenceBlock> BIOQUOIA_FENCE = REGISTRATE.block("bioquoia_fence", FenceBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.fenceBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"))).item().model((item, provider) -> provider.withExistingParent("bioquoia_fence", new ResourceLocation("block/fence_inventory")).texture("texture", HylandaMod.rL("block/bioquoia_planks"))).build().register();
	public static final BlockEntry<FenceGateBlock> BIOQUOIA_FENCE_GATE = REGISTRATE.block("bioquoia_fence_gate", FenceGateBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)).blockstate((block, provider) -> provider.fenceGateBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"))).simpleItem().register();
	public static final BlockEntry<WoodButtonBlock> BIOQUOIA_BUTTON = REGISTRATE.block("bioquoia_button", WoodButtonBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()).blockstate((block, provider) -> provider.buttonBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"))).item().model((item, provider) -> provider.withExistingParent("bioquoia_button", new ResourceLocation("block/button_inventory")).texture("texture", HylandaMod.rL("block/bioquoia_planks"))).build().register();
	public static final BlockEntry<PressurePlateBlock> BIOQUOIA_PRESSURE_PLATE = REGISTRATE.block("bioquoia_pressure_plate", p -> new PressurePlateBlock(Sensitivity.EVERYTHING, p)).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()).blockstate((block, provider) -> provider.pressurePlateBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"))).simpleItem().register();
	public static final BlockEntry<DoorBlock> BIOQUOIA_DOOR = REGISTRATE.block("bioquoia_door", DoorBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()).blockstate((block, provider) -> provider.doorBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"), HylandaMod.rL("block/bioquoia_planks"))).item().model((item, provider) -> provider.generated(item, HylandaMod.rL("block/bioquoia_planks"))).build().register();
	public static final BlockEntry<TrapDoorBlock> BIOQUOIA_TRAPDOOR = REGISTRATE.block("bioquoia_trapdoor", TrapDoorBlock::new).properties(properties -> properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()).blockstate((block, provider) -> provider.trapdoorBlock(block.get(), HylandaMod.rL("block/bioquoia_planks"), true)).item().model((item, provider) -> provider.withExistingParent("bioquoia_trapdoor", HylandaMod.rL("block/bioquoia_trapdoor_bottom"))).build().register();
	public static final BlockEntry<HylandaStandingSignBlock> BIOQUOIA_SIGN = REGISTRATE.block("bioquoia_sign", p -> new HylandaStandingSignBlock(HylandaBlocks.BIOQUOIA, p)).properties(properties -> properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD)).setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop()).setData(ProviderType.LANG, NonNullBiConsumer.noop()).register();
	public static final BlockEntry<HylandaWallSignBlock> BIOQUOIA_WALL_SIGN = REGISTRATE.block("bioquoia_wall_sign", p -> new HylandaWallSignBlock(HylandaBlocks.BIOQUOIA, p)).properties(properties -> properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(() -> HylandaBlocks.BIOQUOIA_SIGN.get())).blockstate((block, provider) -> provider.signBlock(HylandaBlocks.BIOQUOIA_SIGN.get(), block.get(), HylandaMod.rL("block/bioquoia_planks"))).setData(ProviderType.LANG, NonNullBiConsumer.noop()).register();
	public static final ItemEntry<SignItem> BIOQUOIA_SIGN_ITEM = REGISTRATE.item("bioquoia_sign", p -> new SignItem(p, HylandaBlocks.BIOQUOIA_SIGN.get(), HylandaBlocks.BIOQUOIA_WALL_SIGN.get())).properties(properties -> properties.stacksTo(16)).register();

	private static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
		return false;
	}

	private static Boolean ocelotOrParrot(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	public static void init() {
	}
}
