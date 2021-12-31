package hylanda.library.block.builder;

import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModUtils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Properties;

public class BlockAndItemBuilder {
	public static Block create(String id, Block block) {
		BlockItem item = new BlockItem(block, new Properties().tab(ModUtils.BLOCKS));
		BlockInit.register(id, block);
		ItemInit.register(id, item);
		return block;
	}
}
