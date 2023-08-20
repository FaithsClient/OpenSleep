//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Option;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Module {
   public Option medical$ = new Option("DisplayValue", false);
   public Mode creates$ = new Mode("Mode", new String[]{"Exh", "Otc", "Bingus", "Astolfo"}, "Exh");

   public ClickGui() {
      super("ft.sleep.ui.screen.ClickGui", new String[]{"clickui"}, ModuleType.ignored$);
      super._bosnia(true);
   }

   public void _regime() {
      if (Objects.equals(raremuta.creates$.getValue(), "Bingus")) {
         raremuta.mc.displayGuiScreen(new ClickUi());
      }

      if (Objects.equals(raremuta.creates$.getValue(), "Astolfo")) {
         raremuta.mc.displayGuiScreen(new ClickUi2());
      }

      if (Objects.equals(raremuta.creates$.getValue(), "Exh")) {
         raremuta.mc.displayGuiScreen(Client.î ?().globe$);
      }

      if (Objects.equals(raremuta.creates$.getValue(), "Otc")) {
         raremuta.mc.displayGuiScreen(Client.î ?().conflict$);
      }

      raremuta._serial(false);
   }

   @EventHandler
   public void _beneath(EventPreUpdate liquid) {
      if (using.mc.currentScreen != null && !(using.mc.currentScreen instanceof GuiChat)) {
         Object screens = new KeyBinding[]{using.mc.gameSettings.keyBindForward, using.mc.gameSettings.keyBindBack, using.mc.gameSettings.keyBindLeft, using.mc.gameSettings.keyBindRight, using.mc.gameSettings.keyBindSprint, using.mc.gameSettings.keyBindJump};

         for(KeyBinding var6 : screens) {
            KeyBinding.setKeyBindState(var6.getKeyCode(), Keyboard.isKeyDown(var6.getKeyCode()));
         }
      }

   }
}
