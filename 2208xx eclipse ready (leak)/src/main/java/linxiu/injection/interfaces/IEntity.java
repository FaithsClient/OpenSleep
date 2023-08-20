package linxiu.injection.interfaces;

import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public interface IEntity {

	int getNextStepDistance();

    void setNextStepDistance(int distance);

    int getFire();

    void setFire(int i);

    AxisAlignedBB getBoundingBox();

    boolean isOverOfMaterial(Material materialOver);

    Vec3 getVectorForRotation(float pitch, float yaw);

	float getCameraYaw();

	float getCameraPitch();
}
