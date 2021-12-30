package hylanda.library.item;

import hylanda.library.util.ModRegistry;
import hylanda.library.util.ModUtils;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemBuilder extends Item
{
	protected ItemBuilder() 
	{
		super(new Properties().tab(ModUtils.ITEMS));
	}

	public static Item create(String id)
	{
		return ModRegistry.register(id, new ItemBuilder());
	}
	
	public static Item create(String id, Item item)
	{
		return ModRegistry.register(id, item);
	}
	
	public static Item create(String id, Properties properties)
	{
		return ModRegistry.register(id, new Item(properties));
	}
	
	public static Item create(String id, Food food)
	{
		return ModRegistry.register(id, new Item(new Properties().tab(ModUtils.ITEMS).food(food)));
	}
	
	public static Item create(String id, Properties properties, Food food)
	{
		return ModRegistry.register(id, new Item(properties.food(food)));
	}
}
