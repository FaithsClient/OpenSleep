package linxiu.utils.targeth;

import net.minecraft.entity.EntityLivingBase;

import java.util.ArrayList;

public class TargetHud {

	public EntityLivingBase entityLivingBase;

	public Translate background = new Translate();
	public Translate hptranslate = new Translate();

	public boolean initialize = false;
	public boolean remove = false;

	public ArrayList<Translate> translates = new ArrayList<>();
	public TargetHud(EntityLivingBase entityLivingBase) {
		this.entityLivingBase = entityLivingBase;
		for(int i = 0; i < 10; i++) {
			Translate translate1 = new Translate();
			translates.add(translate1);
		}
	}

}
