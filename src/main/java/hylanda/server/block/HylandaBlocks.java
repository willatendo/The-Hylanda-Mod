package hylanda.server.block;

import hylanda.HylandaMod;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tyrannotitanlib.library.block.TyrannoStandingSignBlock;
import tyrannotitanlib.library.block.TyrannoWallSignBlock;

public class HylandaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HylandaMod.ID);
	public static final HylandaRegistrate REGISTRATE = HylandaMod.CENTRAL_REGISTRATE.get();

	private static final WoodType BIOQUOIA = WoodType.register(WoodType.create("bioquoia"));

	public static final RegistryObject<Block> GOLDEN_BRICKS = BLOCKS.register("golden_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

	public static final RegistryObject<Block> SMITHY = BLOCKS.register("smithy", () -> new SmithyBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<Block> BIOQUOIA_GRASS = BLOCKS.register("bioquoia_grass", () -> new BioquoiaGrassBlock());

	public static final RegistryObject<Block> BIOQUOIA_LOG = BLOCKS.register("bioquoia_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_BIOQUOIA_LOG = BLOCKS.register("stripped_bioquoia_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_WOOD = BLOCKS.register("bioquoia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_BIOQUOIA_WOOD = BLOCKS.register("stripped_bioquoia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_LEAVES = BLOCKS.register("bioquoia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(HylandaBlocks::ocelotOrParrot).isSuffocating(HylandaBlocks::never).isViewBlocking(HylandaBlocks::never)));
	public static final RegistryObject<Block> BIOQUOIA_SAPLING = BLOCKS.register("bioquoia_sapling", () -> new SaplingBlock(null, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BIOQUOIA_PLANKS = BLOCKS.register("bioquoia_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_STAIRS = BLOCKS.register("bioquoia_stairs", () -> new StairBlock(() -> HylandaBlocks.BIOQUOIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_SLAB = BLOCKS.register("bioquoia_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_FENCE = BLOCKS.register("bioquoia_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_FENCE_GATE = BLOCKS.register("bioquoia_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIOQUOIA_BUTTON = BLOCKS.register("bioquoia_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final RegistryObject<Block> BIOQUOIA_PRESSURE_PLATE = BLOCKS.register("bioquoia_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final RegistryObject<Block> BIOQUOIA_DOOR = BLOCKS.register("bioquoia_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final RegistryObject<Block> BIOQUOIA_TRAPDOOR = BLOCKS.register("bioquoia_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final RegistryObject<Block> BIOQUOIA_SIGN = BLOCKS.register("bioquoia_sign", () -> new TyrannoStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), HylandaBlocks.BIOQUOIA));
	public static final RegistryObject<Block> BIOQUOIA_WALL_SIGN = BLOCKS.register("bioquoia_wall_sign", () -> new TyrannoWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(() -> HylandaBlocks.BIOQUOIA_SIGN.get()), HylandaBlocks.BIOQUOIA));

	private static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
		return false;
	}

	private static Boolean ocelotOrParrot(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	public static void init(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
