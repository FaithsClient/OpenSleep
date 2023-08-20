//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import native0.Loader;
import net.minecraft.client.gui.GuiScreen;
import oh.yalan.NativeClass;

@NativeClass
public class EvalyGui extends GuiScreen {
   public List mumbai$ = new ArrayList();
   public static int madrid$ = 240;
   public static int theology$ = 90;
   public int laden$;
   public int likes$;
   public boolean postcard$;

   public EvalyGui() {
      Object listings = 0;

      for(Object symantec : ModuleType.values()) {
         enjoying.mumbai$.add(new CategoryRender(symantec, listings + 40));
         listings += FontLoaders.icon35.getStringWidth(enjoying.î ?(symantec)) + 40;
      }

   }

   public native void initGui();

   public native boolean doesGuiPauseGame();

   public native String _/* $FF was: î ?*/(ModuleType var1);

   public native void drawScreen(int var1, int var2, float var3);

   public native void mouseClicked(int var1, int var2, int var3) throws IOException;

   public native void mouseReleased(int var1, int var2, int var3);

   public native void keyTyped(char var1, int var2) throws IOException;

   public native CategoryRender _/* $FF was: î ?*/();

   public static native void _/* $FF was: î ?*/(char var0, int var1, CategoryRender var2);

   public static native void _/* $FF was: î ?*/(int var0, int var1, int var2, CategoryRender var3);

   public static native void _/* $FF was: î ?*/(int var0, int var1, CategoryRender var2);

   static {
      Loader.registerNativesForClass(6, EvalyGui.class);
   }

   public static Consumer invokedynamic$mouseReleased$1(int opposed, int newport, int toyota) {
      return EvalyGui::î ?;
   }

   public static Consumer invokedynamic$keyTyped$2(char darwin, int beatles) {
      return EvalyGui::î ?;
   }

   public static Consumer invokedynamic$drawScreen$0(int uzafimod, int burefolo) {
      return EvalyGui::î ?;
   }

   public static Predicate invokedynamic$_$3/* $FF was: invokedynamic$î ?$3*/() {
      return CategoryRender::î ‘î ”î ‘î ”;
   }
}
