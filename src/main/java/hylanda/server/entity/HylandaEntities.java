package hylanda.server.entity;

import com.tterrag.registrate.util.entry.EntityEntry;

import hylanda.HylandaMod;
import hylanda.client.entity.render.BioDeerRender;
import hylanda.client.entity.render.GojirasaurusRender;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.world.entity.MobCategory;

public class HylandaEntities {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.CENTRAL_REGISTRATE.get().creativeModeTab(() -> HylandaMod.SPAWN_EGGS);

	public static final EntityEntry<Gojirasaurus> GOJIRASAURUS = REGISTRATE.entity("gojirasaurus", Gojirasaurus::new, MobCategory.CREATURE).properties(builder -> builder.sized(1.5F, 3.0F)).attributes(Gojirasaurus::makeAttributes).renderer(() -> GojirasaurusRender::new).defaultSpawnEgg(0x1e1e1c, 0x5d1311).register();
	public static final EntityEntry<BioDeer> BIO_DEER = REGISTRATE.entity("bio_deer", BioDeer::new, MobCategory.CREATURE).properties(builder -> builder.sized(0.75F, 2.0F)).attributes(BioDeer::makeAttributes).renderer(() -> BioDeerRender::new).defaultSpawnEgg(0x5cab9f, 0xb26d43).register();

	public static void init() {
	}
}
