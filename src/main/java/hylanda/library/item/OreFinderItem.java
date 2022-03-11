package hylanda.library.item;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OreFinderItem extends Item {
	public OreFinderItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (!player.isSecondaryUseActive()) {
			ItemStack stack = player.getItemInHand(hand);
			Predicate<Block> detectableOres = (block) -> {
				return block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE || block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.NETHER_GOLD_ORE || block == Blocks.NETHER_QUARTZ_ORE;
			};
			ArrayList<Block> blocks = Lists.newArrayList();

			if (blocks.stream().anyMatch(detectableOres)) {
				
			}

			InteractionResultHolder.success(stack);
		}

		return super.use(level, player, hand);
	}
}
