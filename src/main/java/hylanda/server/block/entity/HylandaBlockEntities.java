package hylanda.server.block.entity;

import com.tterrag.registrate.util.entry.BlockEntityEntry;

import hylanda.HylandaMod;
import hylanda.server.block.HylandaBlocks;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class HylandaBlockEntities {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate();

	public static final BlockEntityEntry<HylandaSignBlockEntity> SIGN = REGISTRATE.blockEntity("sign", HylandaSignBlockEntity::new).renderer(() -> SignRenderer::new).validBlocks(HylandaBlocks.BIOQUOIA_SIGN, HylandaBlocks.BIOQUOIA_WALL_SIGN).register();

	public static void init() {
	}
}
