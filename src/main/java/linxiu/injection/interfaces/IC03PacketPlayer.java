package linxiu.injection.interfaces;

public interface IC03PacketPlayer {
    boolean isOnGround();

    void setOnGround(boolean b);

    boolean ismoving();

    void setmoving(boolean b);

    void setPosY(double y2);

    void setYaw(float f);

    float getYaw();

    void setPitch(float f);

    float getPitch();

    void setRotate(boolean b);
	boolean getRotate();
}
