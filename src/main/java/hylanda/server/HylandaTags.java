package hylanda.server;

import hylanda.HylandaMod;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HylandaTags {
	public static class Items {
		public static final TagKey<Item> BIO_DEER_ANTLERS = tag("bio_deer_antlers");
		
		private static TagKey<Item> tag(String name) {
			return ItemTags.create(HylandaMod.rL(name));
		}
	}
}
