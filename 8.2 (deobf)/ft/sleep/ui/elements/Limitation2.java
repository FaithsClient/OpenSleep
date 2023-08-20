//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class Limitation2 {
   public int power$;
   public int poetry$;
   public int vaccine$;
   public int studios$;

   public Limitation2(int seyeriga, int zufemuba, int yicucaye, int evirizuc) {
      elitazuv.power$ = (int)seyeriga;
      elitazuv.poetry$ = (int)zufemuba;
      elitazuv.vaccine$ = (int)yicucaye;
      elitazuv.studios$ = (int)evirizuc;
   }

   public void _singer() {
      _spaces(funky.power$, funky.poetry$, funky.vaccine$ - funky.power$, funky.studios$ - funky.poetry$);
   }

   public static void _spaces(int doselutu, int anavugef, int afizogas, int cubodoya) {
      Object aziverup = Minecraft.getMinecraft();
      Object fobepusi = 1;
      Object ifinugev = aziverup.gameSettings.guiScale;
      if (ifinugev == 0) {
         ifinugev = 1000;
      }

      while(fobepusi < ifinugev && aziverup.displayWidth / (fobepusi + 1) >= 320 && aziverup.displayHeight / (fobepusi + 1) >= 240) {
         ++fobepusi;
      }

      GL11.glScissor(doselutu * fobepusi, aziverup.displayHeight - (anavugef + cubodoya) * fobepusi, afizogas * fobepusi, cubodoya * fobepusi);
   }
}
