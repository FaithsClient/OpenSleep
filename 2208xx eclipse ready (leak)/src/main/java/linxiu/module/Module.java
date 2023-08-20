package linxiu.module;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.Value;
import linxiu.command.Command;
import linxiu.injection.interfaces.INetworkManager;
import linxiu.module.modules.render.HUD;
import linxiu.ui.notification.Notification;
import linxiu.utils.Helper;
import linxiu.utils.PlayMusic;
import linxiu.utils.math.MathUtil;
import linxiu.utils.render.Animation;
import linxiu.utils.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import java.util.*;

public class Module {
	public String name;
	private String suffix;
	private int color;
	private final String[] alias;
	private boolean enabled;
	public boolean enabledOnStartup = false;
	public int key;
	public List<Value> values;
	public ModuleType type;
	private boolean removed;
	public Animation animation = new Animation();
	public Minecraft mc = Minecraft.getMinecraft();
	public static Random random = new Random();
	private String cusname;
	public float animx = 0;
	public float animy = 0;
	public boolean arraylistremove = true;
	public float optionAnim = 0;// present
	public float optionAnimNow = 0;// present

	public Module(String name, String[] alias, ModuleType type) {
		this.name = name;
		this.alias = alias;
		this.type = type;
		this.suffix = "";
		this.key = 0;
		this.removed = false;
		this.enabled = false;
		this.cusname = null;
		this.values = new ArrayList();
	}

	// Called when you toggle
	public void startAnimation() {
		animation.setReverse(!enabled);
		animation.setSpeed(0.2);
		animation.setAmount(50);
		animation.start();
	}

	// Call when rendering module in hud
	public void updateRender() {
		animation.updateAnimation();
	}

	// If should count as toggled
	public boolean isAnimating() {
		return !animation.hasFinished();
	}

	public String getName() {
		if (HUD.wasLower.getValue().booleanValue()) {
			return this.name.toLowerCase();
		} else {
			return this.name;
		}
	}

	public void makeCommand() {
		if (this.values.size() > 0) {
			String options = "";
			String other = "";
			Iterator var4 = this.values.iterator();

			Value v;
			while (var4.hasNext()) {
				v = (Value) var4.next();
				if (!(v instanceof Mode)) {
					if (options.isEmpty()) {
						options = String.valueOf(options) + v.getName();
					} else {
						options = String.valueOf(options) + String.format(", %s", new Object[] { v.getName() });
					}
				}
			}

			var4 = this.values.iterator();

			while (true) {
				do {
					if (!var4.hasNext()) {
						Client.getINSTANCE().getCommandManager()
								.add(new Module$1(this, this.name, this.alias,
										String.format("%s%s", new Object[] {
												options.isEmpty() ? "" : String.format("%s,", new Object[] { options }),
												other.isEmpty() ? "" : String.format("%s", new Object[] { other }) }),
										"Setup this module"));
						return;
					}

					v = (Value) var4.next();
				} while (!(v instanceof Mode));

				Mode mode = (Mode) v;
				for (int i = 0; i < mode.getModes().length; ++i) {
					if (other.isEmpty()) {
						other = String.valueOf(other) + mode.getName().toLowerCase();
					} else {
						other = String.valueOf(other)
								+ String.format(", %s", new Object[] { mode.getName().toLowerCase() });
					}
				}
			}
		}
	}

	public void toggle() {
		if (isEnabled()) {
			onDisable();
		} else {
			onEnable();
		}
		setEnabled(!isEnabled());
	}

	public String[] getAlias() {
		return this.alias;
	}

	public ModuleType getType() {
		return this.type;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public boolean wasRemoved() {
		return this.removed;
	}

	public void addValue(Value<?> value) {
		this.values.add(value);
	}

	public void sendPacketNoEvent(Packet<?> packet) {
		if (mc.thePlayer != null) {
			((INetworkManager) mc.thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent(packet);
		}
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(Object obj) {
		String suffix = obj.toString();
		if (suffix.isEmpty()) {
			this.suffix = suffix;
		} else {
			if (Objects.equals(HUD.Tags.getValue(), "Empty")) {
				this.suffix = suffix.isEmpty() ? suffix : "";
			}
			if (Objects.equals(HUD.Tags.getValue(), "Box")) {
				this.suffix = suffix.isEmpty() ? suffix
						: String.format("%s", EnumChatFormatting.GRAY + "[" + suffix + "]");
			}
			if (Objects.equals(HUD.Tags.getValue(), "None")) {
				this.suffix = suffix.isEmpty() ? suffix : String.format("%s", EnumChatFormatting.GRAY + suffix);
			}
			if (Objects.equals(HUD.Tags.getValue(), "Null")) {
				this.suffix = suffix.isEmpty() ? suffix
						: String.format("%s", EnumChatFormatting.GRAY + "(" + suffix + ")");
			}
			if (Objects.equals(HUD.Tags.getValue(), "Hyphen")) {
				this.suffix = suffix.isEmpty() ? suffix : String.format("%s", EnumChatFormatting.GRAY + "- " + suffix);
			}
		}
	}

	public void setEnabled(boolean state) {
		this.enabled = state;
		if (enabled)
			enable();
		else
			disable();
		if (Client.getINSTANCE().getFileManager() != null)
			Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().configs);
	}

	public final void enable() {
		EventBus.getInstance().register(this);
		try {
			onEnable();
		} catch (Exception exception) {
			if (mc.thePlayer != null)
				exception.printStackTrace();
		}
		if (mc.thePlayer != null) {
			if (!this.getName().equals("ClickGUI") && !this.getName().equals("HUD")) {
				if (HUD.wav.getValue()) {
					PlayMusic.playSound("on.wav", -9);
				}
			}
			if (HUD.enableNotifications.getValue()) {
				Client.getINSTANCE().getNotificationManager().getNotifications()
						.add(new Notification(this.getName() + " was Enabled"));
			}
		}
	}

	public final void disable() {
		EventBus.getInstance().unregister(this);
		try {
			onDisable();
		} catch (Exception exception) {
			if (mc.thePlayer != null)
				exception.printStackTrace();
		}
		if (mc.thePlayer != null) {
			if (!this.getName().equals("ClickGUI") && !this.getName().equals("HUD")) {
				if (HUD.wav.getValue()) {
					PlayMusic.playSound("off.wav", -9);
				}
			}
			if (HUD.enableNotifications.getValue()) {
				Client.getINSTANCE().getNotificationManager().getNotifications()
						.add(new Notification(this.getName() + " was Disabled"));
			}
		}
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getColor() {
		return this.color;
	}

	public void addValues(Value... values) {
		Value[] var5 = values;
		int var4 = values.length;

		this.values.addAll(Arrays.asList(var5).subList(0, var4));

	}

	public List<Value> getValues() {
		return this.values;
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
		if (Client.getINSTANCE().getFileManager() != null)
			Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().configs);
	}

	public void onEnable() {
	}

	public void onDisable() {
	}

	public String getCustomName() {
		return this.cusname;
	}

	public void setCustomName(String name) {
		this.cusname = name;
		if (Client.getINSTANCE().getFileManager() != null)
			Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().configs);
	}

	public void setAnimx(float aanimx) {
		this.animx = aanimx;
	}

	public float getAnimY() {
		return this.animy;
	}

	public void setAnimy(float aanimx) {
		this.animy = aanimx;
	}

	public boolean wasArrayRemoved() {
		return this.arraylistremove;
	}

	public void setArrayRemoved(boolean arraylistremove) {
		this.arraylistremove = arraylistremove;
	}

	public double getAnimationState(double animation, double finalState, double speed) {
		float add = (float) (RenderUtil.delta * speed);
		if (animation < finalState) {
			if (animation + add < finalState)
				animation += add;
			else
				animation = finalState;
		} else {
			if (animation - add > finalState)
				animation -= add;
			else
				animation = finalState;
		}
		return animation;
	}

	public float getAnimx() {
		return this.animx;
	}
}

class Module$1 extends Command {
	private final Module m;
	final Module this$0;

	Module$1(Module var1, String $anonymous0, String[] $anonymous1, String $anonymous2, String $anonymous3) {
		super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
		this.this$0 = var1;
		this.m = var1;
	}

	public String execute(String[] args) {
		Option option;
		if (args.length >= 2) {
			option = null;
			Numbers fuck = null;
			Mode xd = null;
			Iterator var6 = this.m.values.iterator();

			Value v;
			while (var6.hasNext()) {
				v = (Value) var6.next();
				if (v instanceof Option && v.getName().equalsIgnoreCase(args[0])) {
					option = (Option) v;
				}
			}

			if (option != null) {
				option.setValue(Boolean.valueOf(!((Boolean) option.getValue()).booleanValue()));
				Helper.sendMessage(String.format("> %s has been set to %s", option.getName(), option.getValue()));
			} else {
				var6 = this.m.values.iterator();

				while (var6.hasNext()) {
					v = (Value) var6.next();
					if (v instanceof Numbers && v.getName().equalsIgnoreCase(args[0])) {
						fuck = (Numbers) v;
					}
				}

				if (fuck != null) {
					if (MathUtil.parsable(args[1], (byte) 4)) {
						double v1 = MathUtil.round(Double.parseDouble(args[1]), 1);
						fuck.setValue(Double
								.valueOf(v1 > fuck.getMaximum().doubleValue() ? fuck.getMaximum().doubleValue() : v1));
						Helper.sendMessage(String.format("> %s has been set to %s", fuck.getName(), fuck.getValue()));
					} else {
						Helper.sendMessage("> " + args[1] + " is not a number");
					}
				}

				var6 = this.m.values.iterator();

				while (var6.hasNext()) {
					v = (Value) var6.next();
					if (args[0].equalsIgnoreCase(v.getName()) && v instanceof Mode) {
						xd = (Mode) v;
					}
				}

				if (xd != null) {
					if (xd.isValid(args[1])) {
						xd.setMode(args[1]);
						Helper.sendMessage(String.format("> %s set to %s", xd.getName(), xd.getModeAsString()));
					} else {
						Helper.sendMessage("> " + args[1] + " is an invalid mode");
					}
				}
			}

			if (fuck == null && option == null && xd == null) {
				this.syntaxError("Valid .<module> <setting> <mode if needed>");
			}
		} else if (args.length >= 1) {
			option = null;
			Iterator xd1 = this.m.values.iterator();

			while (xd1.hasNext()) {
				Value fuck1 = (Value) xd1.next();
				if (fuck1 instanceof Option && fuck1.getName().equalsIgnoreCase(args[0])) {
					option = (Option) fuck1;
				}
			}

			if (option != null) {
				option.setValue(Boolean.valueOf(!((Boolean) option.getValue()).booleanValue()));
				String fuck2 = option.getName().substring(1);
				String xd2 = option.getName().substring(0, 1).toUpperCase();
				if (((Boolean) option.getValue()).booleanValue()) {
					Helper.sendMessage(String.format("> %s has been set to \u00a7a%s", xd2 + fuck2, option.getValue()));
				} else {
					Helper.sendMessage(String.format("> %s has been set to \u00a7c%s", xd2 + fuck2, option.getValue()));
				}
			} else {
				this.syntaxError("Valid .<module> <setting> <mode if needed>");
			}
		} else {
			Helper.sendMessage(String.format("%s Values: \n %s",
					this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1).toLowerCase(),
					this.getSyntax(), "false"));
		}

		return null;
	}
}
