package rip.sleep.interfaces;

import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.ui.font.Fonts;
import rip.sleep.interfaces.IFont;

@FunctionalInterface
public interface IFontProvider {
   IFont c89238(Fonts var1);

   default IFontRenderer c64239(Fonts var1, int var2) {
      return this.c89238(var1).c38814(var2);
   }
}
