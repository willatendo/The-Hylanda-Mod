package hylanda.content.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import hylanda.content.client.entity.model.BioDeerModel;
import hylanda.library.entity.BioDeerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import tyrannotitanlib.library.tyrannomation.renderers.TyrannomationEntityRenderer;

public class BioDeerRender extends TyrannomationEntityRenderer<BioDeerEntity> 
{
	public BioDeerRender(EntityRendererManager renderManager) 
	{
		super(renderManager, new BioDeerModel());
		this.shadowRadius = 0.6F;
	}

	@Override
	public RenderType getRenderType(BioDeerEntity entity, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		if(entity.isBaby())
		{
			stack.scale(0.3F, 0.3F, 0.3F);
		}
		else
		{
			stack.scale(1.0F, 1.0F, 1.0F);
		}
		
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}	
}
