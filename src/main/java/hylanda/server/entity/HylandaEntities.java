package hylanda.server.entity;

import com.tterrag.registrate.util.entry.EntityEntry;

import hylanda.HylandaMod;
import hylanda.client.entity.render.BioDeerRender;
import hylanda.client.entity.render.DetectedOreBlockRender;
import hylanda.client.entity.render.GojirasaurusRender;
import hylanda.server.item.HylandaItems;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class HylandaEntities {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate().creativeModeTab(() -> HylandaMod.SPAWN_EGGS, "Spawn Eggs");

	public static final EntityEntry<DetectedOreBlock> DETECTED_ORE_BLOCK = REGISTRATE.entity("detected_ore_block", DetectedOreBlock::new, MobCategory.MISC).properties(builder -> builder.sized(1.0F, 1.0F)).attributes(DetectedOreBlock::makeAttributes).renderer(() -> DetectedOreBlockRender::new).register();

	public static final EntityEntry<Gojirasaurus> GOJIRASAURUS = REGISTRATE.entity("gojirasaurus", Gojirasaurus::new, MobCategory.CREATURE).properties(builder -> builder.sized(1.5F, 3.0F)).attributes(Gojirasaurus::makeAttributes).renderer(() -> GojirasaurusRender::new).defaultSpawnEgg(0x1e1e1c, 0x5d1311).loot((registrate, entity) -> registrate.add(entity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(HylandaItems.GOJIRASAURUS_DORSAL_PLATE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))))).register();
	public static final EntityEntry<BioDeer> BIO_DEER = REGISTRATE.entity("bio_deer", BioDeer::new, MobCategory.CREATURE).properties(builder -> builder.sized(0.75F, 2.0F)).attributes(BioDeer::makeAttributes).renderer(() -> BioDeerRender::new).defaultSpawnEgg(0x5cab9f, 0xb26d43).loot((registrate, entity) -> registrate.add(entity, LootTable.lootTable())).register();

	public static void init() {
	}
}
