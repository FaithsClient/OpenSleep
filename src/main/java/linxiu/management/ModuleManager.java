/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package linxiu.management;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventKey;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.Value;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.*;
import linxiu.module.modules.ghost.*;
import linxiu.module.modules.megawalls.*;
import linxiu.module.modules.movement.*;
import linxiu.module.modules.player.*;
import linxiu.module.modules.render.*;
import linxiu.module.modules.uhc.*;
import linxiu.ui.font.CFontRenderer;
import linxiu.utils.SystemUtils;
import linxiu.utils.render.gl.GLUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;

import java.awt.AWTException;
import java.awt.TrayIcon;
import java.lang.reflect.Field;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModuleManager implements Manager {
    private static ArrayList<Module> modules = new ArrayList<>();

	@Override
	public void init() {
		addModule(new HUD());
		addModule(new KillAura());
		addModule(new BowAimBot());
		addModule(new KeepSprint());
		addModule(new AutoTool());
		addModule(new AntiDisplayFucker());
		addModule(new Animations());
		addModule(new LegitSpeed());
		addModule(new Freecam());
		addModule(new MiniMap());
		addModule(new IRC());
		addModule(new TargetList());
		addModule(new Scaffold());
		addModule(new Nuker());
		addModule(new Cape());
		addModule(new ChestStealer());
		addModule(new Speed());
		addModule(new Deobfuscator());
		addModule(new TPSChecker());
		addModule(new ESP2D());
		addModule(new SafeWalk());
		addModule(new AimAssist());
		addModule(new TimeChanger());
		addModule(new TunnelMiner());
		addModule(new TargetStrafe());
		addModule(new AutoArmor());
		addModule(new InvCleaner());
		addModule(new Phase());
		addModule(new AutoRejoin());
		addModule(new GameSpeed());
		addModule(new AntiKB());
		addModule(new BlockHitbox());
		addModule(new ClickGui());
		addModule(new ItemTag());
		addModule(new Chams());
		addModule(new Hitbox());
		addModule(new Criticals());
		addModule(new TargetHUD());
		addModule(new NoFall());
		addModule(new Disabler());
		addModule(new FastPlace());
		addModule(new UhcHelper());
		addModule(new AutoClicker());
		addModule(new SpeedMine());
		addModule(new NoSlow());
		addModule(new NoJumpDelay());
		addModule(new Sprint());
		addModule(new AntiBot());
		addModule(new MCF());
		addModule(new Nametags());
		addModule(new Reach());
		addModule(new Velocity());
		addModule(new AutoKill());
		addModule(new MwHelper());
		addModule(new ViewClip());
		addModule(new Blink());
		addModule(new Xray());
		addModule(new HackerDetector());
		addModule(new InvMove());
		addModule(new Teams());

		for (Module m : modules) {
			m.makeCommand();
		}
		EventBus.getInstance().register(this);
	}

	public static ArrayList<Module> getModules() {
		return modules;
	}
	
    public Module getModule(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }
    
	public void addModule(Module mod) {
		for (Field field : mod.getClass().getDeclaredFields()) {
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			Object obj;
			try {
				if ((obj = field.get(mod)) instanceof Value) {
					mod.addValue((Value<?>) obj);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		modules.add(mod);
	}

	public static Module getModuleByClass(Class<? extends Module> cls) {
		for (Module m : modules) {
			if (m.getClass() != cls)
				continue;
			return m;
		}
		return null;
	}

	public static Module getModuleByName(String name) {
		for (Module m : modules) {
			if (!m.getName().equalsIgnoreCase(name))
				continue;
			return m;
		}
		return null;
	}

	public Module getAlias(String name) {
		for (Module f : modules) {
			if (f.getName().equalsIgnoreCase(name)) {
				return f;
			}
			String[] alias = f.getAlias();
			int length = alias.length;
			int i = 0;
			while (i < length) {
				String s = alias[i];
				if (s.equalsIgnoreCase(name)) {
					return f;
				}
				++i;
			}
		}
		return null;
	}

	public List<Module> getModulesInType(ModuleType t) {
		ArrayList<Module> output = new ArrayList<Module>();
		for (Module m : modules) {
			if (m.getType() != t)
				continue;
			output.add(m);
		}
		return output;
	}

	@EventHandler
	private void onKeyPress(EventKey e) {
		for (Module m : modules) {
			if (m.getKey() == e.getKey())
				m.toggle();
		}
	}

	public ArrayList<Module> sortedLength(CFontRenderer font) {
		ArrayList<Module> sorted = new ArrayList<Module>();
		Client.getModuleManager();
		try {
			if (HUD.hideVisuals.getValue()) {
				sorted.removeIf(m -> m.getType() == ModuleType.Render);
			}
		} catch (Exception ignored) {
		}
		if (HUD.customfont.getValue()) {
			sorted.sort((o1,
					o2) -> font
							.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
									: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
							- font.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
									: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
		} else {
			sorted.sort((o1,
					o2) -> Minecraft.getMinecraft().fontRendererObj
							.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
									: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
							- Minecraft.getMinecraft().fontRendererObj
									.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
											: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
		}
		return sorted;
	}
}
