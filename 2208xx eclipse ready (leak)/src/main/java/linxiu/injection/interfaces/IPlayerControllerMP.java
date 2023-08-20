package linxiu.injection.interfaces;

public interface IPlayerControllerMP {
	float getCurBlockDamageMP();
	
	void setCurBlockDamageMP(float f);
	
	void setBlockHitDelay(int i);

	int getBlockDELAY();

	void runsyncCurrentPlayItem();
}
