package hylanda.library.util;

import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static Item register(String id, Item item)
	{
		TyrannoRegister.registerItem(id, item);
		return item;
	}
	
	public static Block register(String id, Block block)
	{
		TyrannoRegister.registerBlock(id, block);
		return block;
	}
	
	public static <T extends Entity> EntityType<T> register(String id, IFactory<T> factory, EntityClassification classification, float width, float height)
	{
		EntityType<T> entityType = EntityType.Builder.of(factory, classification).sized(width, height).build(id);
		entityType.setRegistryName(ModUtils.rL(id));
		ForgeRegistries.ENTITIES.register(entityType);
		return entityType;
	}
	
	public static void registry()
	{
		ItemInit.init();
		BlockInit.init();
	} 
}
