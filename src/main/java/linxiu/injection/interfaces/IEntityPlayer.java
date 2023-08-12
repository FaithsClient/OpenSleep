package linxiu.injection.interfaces;

public interface IEntityPlayer {
    void setItemInUseCount(int i);
    
    void setSpeedInAir(float i);

    float getSpeedInAir();

	boolean isAllowEdit();

}
