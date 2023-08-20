package ft.sleep.injection.interfaces;

import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;

public interface IEntityRenderer {
   void runorientCamera(float var1);

   void runSetupCameraTransform(float var1, int var2);

   void loadShader2(ResourceLocation var1);

   ShaderGroup getTheShaderGroup();
}
