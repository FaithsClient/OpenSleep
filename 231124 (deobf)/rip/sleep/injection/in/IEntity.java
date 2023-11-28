package rip.sleep.injection.in;

import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public interface IEntity {
   int getNextStepDistance();

   void setNextStepDistance(int var1);

   int getFire();

   void setFire(int var1);

   AxisAlignedBB getBoundingBox();

   boolean isOverOfMaterial(Material var1);

   Vec3 getVectorForRotation(float var1, float var2);

   float getCameraYaw();

   float getCameraPitch();
}
