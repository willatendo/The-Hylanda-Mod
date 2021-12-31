package hylanda.library.util;

import hylanda.content.server.init.BlockInit;
import hylanda.content.server.init.EntityInit;
import hylanda.content.server.init.ItemInit;

public class ModRegistry {
	public static void registry() {
		BlockInit.init();
		ItemInit.init();
		EntityInit.init();
	}
}
