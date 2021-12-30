package hylanda.content.server.init;

import hylanda.library.entity.BioDeerEntity;
import hylanda.library.entity.GojirasaurusEntity;
import hylanda.library.util.ModRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class EntityInit
{
	public static final EntityType<GojirasaurusEntity> GOJIRASAURUS = ModRegistry.register("gojirasaurus", GojirasaurusEntity::new, EntityClassification.CREATURE, 1.5F, 3.0F);
	public static final EntityType<BioDeerEntity> BIO_DEER = ModRegistry.register("bio_deet", BioDeerEntity::new, EntityClassification.CREATURE, 0.75F, 2.0F);
	
	public static void initializeAttributes() 
	{
		GlobalEntityTypeAttributes.put(GOJIRASAURUS, GojirasaurusEntity.makeAttributes().build());
		GlobalEntityTypeAttributes.put(BIO_DEER, BioDeerEntity.makeAttributes().build());
	}
}
