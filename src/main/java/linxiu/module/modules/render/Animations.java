package linxiu.module.modules.render;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventAttack;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;

public class Animations extends Module {
	public static Mode modeValue = new Mode("BlockMode",
			new String[] { "Stella", "Fathum", "Vanilla", "Old", "Swing", "Exhi", "Exhi2", "Shred", "Smooth", "Sigma" },
			"Old");
	public final Option AttackCrit = new Option("AttackCrit", "AttackCrit", false);
	private final Numbers<Number> crack = new Numbers("CrackSize", "CrackSize", 1.0, 0.0, 10.0, 1.0);
	public Numbers<Number> swingSlowValue = new Numbers<>("Swing", "Swing", 0.0, -3.0, 15.0, 1.0);
	public Numbers<Number> posX = new Numbers<>("ItemPosX", "ItemPosX", 0.0, -1.0, 1.0, 0.05);
	public Numbers<Number> posY = new Numbers<>("ItemPosY", "ItemPosY", 0.0, -1.0, 1.0, 0.05);
	public Numbers<Number> posZ = new Numbers<>("ItemPosZ", "ItemPosZ", 0.0, -1.0, 1.0, 0.05);

	public Animations() {
		super("Animations", new String[] { "OldHitting" }, ModuleType.Render);
	}

	@EventHandler
	public void onAttack(EventAttack event) {
		if (AttackCrit.getValue() && !mc.thePlayer.isDead) {
			Entity entity = event.entity;
			if (!(entity instanceof EntityLivingBase)) {
				return;
			}
			int i2 = 0;
			while (i2 < crack.getValue().intValue()) {
				this.mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT_MAGIC);
				i2++;
			}
		}
	}
}
