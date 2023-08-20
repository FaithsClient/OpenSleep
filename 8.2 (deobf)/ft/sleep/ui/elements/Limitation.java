//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class Limitation {
   public int marion$;
   public int placing$;
   public int pavilion$;
   public int cowboy$;

   public Limitation(int ufonivuy, int ovafuzud, int ipobapeb, int ubitevul) {
      tisanene.marion$ = (int)ufonivuy;
      tisanene.placing$ = (int)ovafuzud;
      tisanene.pavilion$ = (int)ipobapeb;
      tisanene.cowboy$ = (int)ubitevul;
   }

   public void _array() {
      _blond(isapufip.marion$, isapufip.placing$ + 1, isapufip.pavilion$ - isapufip.marion$ + 20, isapufip.cowboy$ - isapufip.placing$ + 50);
   }

   public static void _blond(int exams, int nevada, int grade, int strictly) {
      Object tests = Minecraft.getMinecraft();
      Object authors = 1;
      Object poetry = tests.gameSettings.guiScale;
      if (poetry == 0) {
         poetry = 1000;
      }

      while(authors < poetry && tests.displayWidth / (authors + 1) >= 320 && tests.displayHeight / (authors + 1) >= 240) {
         ++authors;
      }

      GL11.glScissor(exams * authors, tests.displayHeight - (nevada + strictly) * authors, grade * authors, strictly * authors);
   }
}
