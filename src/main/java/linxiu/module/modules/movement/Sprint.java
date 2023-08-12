package linxiu.module.modules.movement;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventJump;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.events.world.LivingUpdateEvent;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IKeyBinding;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.Helper;
import linxiu.utils.MoveUtils;
import linxiu.utils.MovementUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.PlayerUtils;
import linxiu.utils.RotationUtils;
import linxiu.utils.RotationUtils.Rotation;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public final class Sprint extends Module {
	public static Option MultiDirection = new Option("MultiDir", true);
	private boolean wasDown = false;
	private boolean jump = false;

	public Sprint() {
		super("Sprint", new String[] { "Sprint" }, ModuleType.Movement);
	}

	@Override
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
		super.onDisable();
	}

	@EventHandler
	public void onUpdateEvent(LivingUpdateEvent event) {
		if (!MovementUtils.isMoving() || mc.thePlayer.isSneaking()
				|| (mc.thePlayer.moveForward < 0.8F && !MultiDirection.getValue())) {
			mc.thePlayer.setSprinting(false);
			return;
		}

		if (MultiDirection.getValue() || mc.thePlayer.movementInput.moveForward >= 0.8f) {
			mc.thePlayer.setSprinting(true);
		}
	}
}
