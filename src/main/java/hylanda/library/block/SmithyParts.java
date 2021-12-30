package hylanda.library.block;

import net.minecraft.util.IStringSerializable;

public enum SmithyParts implements IStringSerializable
{
	RIGHT("right"),
	LEFT("left");	
	private final String id;

	private SmithyParts(String id) 
	{
		this.id = id;
	}
	
	@Override
	public String getSerializedName() 
	{
		return this.id;
	}
}
