package hylanda.library.item;

import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModUtils;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

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

	public static Item create(String id, Food food) {
		return ItemInit.register(id, new Item(new Properties().tab(ModUtils.ITEMS).food(food)));
	}

	public static Item create(String id, Properties properties, Food food) {
		return ItemInit.register(id, new Item(properties.food(food)));
	}
}
