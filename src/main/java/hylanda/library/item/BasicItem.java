package hylanda.library.item;

import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModUtils;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BasicItem extends Item {
	public BasicItem() {
		super(new Properties().tab(ModUtils.ITEMS));
	}

	public static Item create(String id) {
		return ItemInit.register(id, new BasicItem());
	}

	public static Item create(String id, Item item) {
		return ItemInit.register(id, item);
	}

	public static Item create(String id, Properties properties) {
		return ItemInit.register(id, new Item(properties));
	}

	public static Item create(String id, FoodProperties food) {
		return ItemInit.register(id, new Item(new Properties().tab(ModUtils.ITEMS).food(food)));
	}

	public static Item create(String id, Properties properties, FoodProperties food) {
		return ItemInit.register(id, new Item(properties.food(food)));
	}
}
