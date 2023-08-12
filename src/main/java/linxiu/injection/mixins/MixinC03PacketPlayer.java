package linxiu.injection.mixins;


import linxiu.injection.interfaces.IC03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(C03PacketPlayer.class)
public class MixinC03PacketPlayer implements IC03PacketPlayer {

    @Shadow
    protected boolean onGround;

    @Shadow
    protected double y;

    @Shadow
    protected float yaw;
    @Shadow
    protected float pitch;
    @Shadow
    protected boolean rotating;
    @Shadow
    protected boolean moving;

    @Override
    public boolean ismoving() {
        return moving;
    }

    @Override
    public void setmoving(boolean b) {
        moving = b;
    }


    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public void setOnGround(boolean b) {
        onGround = b;
    }

	@Override
	public void setPosY(double y2) {
		this.y = y2;
	}

	@Override
	public void setYaw(float f) {
		yaw = f;
		
	}

	@Override
	public float getYaw() {
		// TODO Auto-generated method stub
		return yaw;
	}

	@Override
	public void setPitch(float f) {
		pitch = f;
		
	}

	@Override
	public float getPitch() {
		// TODO Auto-generated method stub
		return pitch;
	}

	@Override
	public void setRotate(boolean b) {
		// TODO Auto-generated method stub
		rotating = b;
	}

	@Override
	public boolean getRotate() {
		// TODO Auto-generated method stub
		return rotating;
	}

}
