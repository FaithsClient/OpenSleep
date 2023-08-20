package linxiu.injection.interfaces;

import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;

public interface IEntityRenderer {
	void runorientCamera(float partialTicks);

	void runSetupCameraTransform(float partialTicks, int pass);
	
	void loadShader2(ResourceLocation resourceLocationIn);

	ShaderGroup getTheShaderGroup();
}
