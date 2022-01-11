package hylanda.content.server.init;

import hylanda.library.block.BioquoiaGrassBlock;
import hylanda.library.block.SmithyBlock;
import hylanda.library.block.builder.BlockAndItemBuilder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
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
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SignItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import tyrannotitanlib.library.base.block.TyrannoStandingSignBlock;
import tyrannotitanlib.library.base.block.TyrannoWallSignBlock;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class BlockInit {
	private static final WoodType BIOQUOIA = WoodType.register(WoodType.create("bioquoia"));

	public static final Block GOLDEN_BRICKS = BlockAndItemBuilder.create("golden_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
	public static final Block STEEL_BLOCK = BlockAndItemBuilder.create("steel_block", new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

	public static final Block SMITHY = BlockAndItemBuilder.create("smithy", new SmithyBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

	public static final Block BIOQUOIA_GRASS = BlockAndItemBuilder.create("bioquoia_grass", new BioquoiaGrassBlock());

	public static final Block BIOQUOIA_LOG = BlockAndItemBuilder.create("bioquoia_log", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_BIOQUOIA_LOG = BlockAndItemBuilder.create("stripped_bioquoia_log", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_WOOD = BlockAndItemBuilder.create("bioquoia_wood", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_BIOQUOIA_WOOD = BlockAndItemBuilder.create("stripped_bioquoia_wood", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_LEAVES = BlockAndItemBuilder.create("bioquoia_leaves", new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockInit::ocelotOrParrot).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)));
	public static final Block BIOQUOIA_SAPLING = BlockAndItemBuilder.create("bioquoia_sapling", new SaplingBlock(null, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final Block BIOQUOIA_PLANKS = BlockAndItemBuilder.create("bioquoia_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_STAIRS = BlockAndItemBuilder.create("bioquoia_stairs", new StairBlock(BlockInit.BIOQUOIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_SLAB = BlockAndItemBuilder.create("bioquoia_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_FENCE = BlockAndItemBuilder.create("bioquoia_fence", new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_FENCE_GATE = BlockAndItemBuilder.create("bioquoia_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_BUTTON = BlockAndItemBuilder.create("bioquoia_button", new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_PRESSURE_PLATE = BlockAndItemBuilder.create("bioquoia_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_DOOR = BlockAndItemBuilder.create("bioquoia_door", new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_TRAPDOOR = BlockAndItemBuilder.create("bioquoia_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_SIGN = register("bioquoia_sign", new TyrannoStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), BIOQUOIA));
	public static final Block BIOQUOIA_WALL_SIGN = register("bioquoia_wall_sign", new TyrannoWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(BlockInit.BIOQUOIA_SIGN), BIOQUOIA));
	public static final Item BIOQUOIA_SIGN_ITEM = register("bioquoia_sign", new SignItem(new Properties().tab(CreativeModeTab.TAB_MISC), BlockInit.BIOQUOIA_SIGN, BlockInit.BIOQUOIA_WALL_SIGN));

	private static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
		return false;
	}

	private static Boolean ocelotOrParrot(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	public static void init() {
	}

	public static Item register(String id, Item item) {
		TyrannoRegister.registerItem(id, item);
		return item;
	}

	public static Block register(String id, Block block) {
		TyrannoRegister.registerBlock(id, block);
		return block;
	}
}
