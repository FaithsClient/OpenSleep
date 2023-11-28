package rip.sleep.ui.font;

import rip.sleep.interfaces.IFont;
import rip.sleep.interfaces.IFontProvider;
import rip.sleep.unmap.c39350;
import rip.sleep.util.UtilityClass;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;

public final class FontProvider implements IFontProvider {
   private static final String c12522 = "sleep/fonts/";
   private final FontProvider.c59782 c7974 = new FontProvider.c59782();

   public static IFontProvider c85881() {
      return new FontProvider();
   }

   public IFont c89238(Fonts var1) {
      return this.c7974.c97532(var1);
   }

   private static final class c59782 extends EnumMap<Fonts, IFont> {
      private c59782() {
         super(Fonts.class);
      }

      private IFont c97532(Fonts var1) {
         return (IFont)this.computeIfAbsent(var1, (var1x) -> {
            Fonts var10000 = var1;
            Fonts var10001 = var1;

            try {
               return c39350.c53445(var10000, c95275(var10001));
            } catch (IOException var3) {
               throw UtilityClass.c77957(var3);
            }
         });
      }

      private static Font c95275(Fonts param0) throws IOException {
         // $FF: Couldn't be decompiled
      }

      private static Font c21956(InputStream var0) {
         byte var10000 = 0;
         InputStream var10001 = var0;

         try {
            Font var1 = Font.createFont(var10000, var10001);
            return var1;
         } catch (FontFormatException var3) {
            throw new RuntimeException("Resource does not contain the required font tables for the specified format", var3);
         } catch (IOException var4) {
            throw new RuntimeException("Couldn't completely read font resource", var4);
         }
      }

      private static IOException c69909(IOException var0) {
         return var0;
      }
   }
}
