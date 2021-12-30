package hylanda.content.server.init;

import hylanda.library.block.BioquoiaGrassBlock;
import hylanda.library.block.SmithyBlock;
import hylanda.library.block.builder.BlockAndItemBuilder;
import hylanda.library.util.ModRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import tyrannotitanlib.library.base.block.TyrannoStandingSignBlock;
import tyrannotitanlib.library.base.block.TyrannoWallSignBlock;

public class BlockInit 
{
	private static final WoodType BIOQUOIA = WoodType.register(WoodType.create("bioquoia"));
	
	public static final Block GOLDEN_BRICKS = BlockAndItemBuilder.create("golden_bricks", new Block(AbstractBlock.Properties.copy(Blocks.BEDROCK)));
	public static final Block STEEL_BLOCK = BlockAndItemBuilder.create("steel_block", new Block(AbstractBlock.Properties.copy(Blocks.BEDROCK)));

	public static final Block SMITHY = BlockAndItemBuilder.create("smithy", new SmithyBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

	public static final Block BIOQUOIA_GRASS = BlockAndItemBuilder.create("bioquoia_grass", new BioquoiaGrassBlock());

	public static final Block BIOQUOIA_LOG = BlockAndItemBuilder.create("bioquoia_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_BIOQUOIA_LOG = BlockAndItemBuilder.create("stripped_bioquoia_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_WOOD = BlockAndItemBuilder.create("bioquoia_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_BIOQUOIA_WOOD = BlockAndItemBuilder.create("stripped_bioquoia_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_LEAVES = BlockAndItemBuilder.create("bioquoia_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockInit::ocelotOrParrot).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)));
	public static final Block BIOQUOIA_SAPLING = BlockAndItemBuilder.create("bioquoia_sapling", new SaplingBlock(null, AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final Block BIOQUOIA_PLANKS = BlockAndItemBuilder.create("bioquoia_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_STAIRS = BlockAndItemBuilder.create("bioquoia_stairs", new StairsBlock(BlockInit.BIOQUOIA_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_SLAB = BlockAndItemBuilder.create("bioquoia_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_FENCE = BlockAndItemBuilder.create("bioquoia_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_FENCE_GATE = BlockAndItemBuilder.create("bioquoia_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final Block BIOQUOIA_BUTTON = BlockAndItemBuilder.create("bioquoia_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_PRESSURE_PLATE = BlockAndItemBuilder.create("bioquoia_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_DOOR = BlockAndItemBuilder.create("bioquoia_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_TRAPDOOR = BlockAndItemBuilder.create("bioquoia_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
	public static final Block BIOQUOIA_SIGN = ModRegistry.register("bioquoia_sign", new TyrannoStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), BIOQUOIA));
	public static final Block BIOQUOIA_WALL_SIGN = ModRegistry.register("bioquoia_wall_sign", new TyrannoWallSignBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(BlockInit.BIOQUOIA_SIGN), BIOQUOIA));
	public static final Item BIOQUOIA_SIGN_ITEM = ModRegistry.register("bioquoia_sign", new SignItem(new Properties().tab(ItemGroup.TAB_MISC), BlockInit.BIOQUOIA_SIGN, BlockInit.BIOQUOIA_WALL_SIGN));
	
	private static boolean never(BlockState state, IBlockReader reader, BlockPos pos) 
	{
		return false;
	}
	
	private static Boolean ocelotOrParrot(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) 
	{
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}
	
	public static void init() { }
}
