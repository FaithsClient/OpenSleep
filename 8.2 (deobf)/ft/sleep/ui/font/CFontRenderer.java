//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.font;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class CFontRenderer extends CFont {
   private static final int RANDOM_OFFSET = 1;
   protected CFont.CharData[] boldChars = new CFont.CharData[256];
   protected CFont.CharData[] italicChars = new CFont.CharData[256];
   protected CFont.CharData[] boldItalicChars = new CFont.CharData[256];
   private final int[] colorCode = new int[32];
   private final String colorcodeIdentifiers = "0123456789abcdefklmnor";
   protected DynamicTexture texBold;
   protected DynamicTexture texItalic;
   protected DynamicTexture texItalicBold;
   private final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public CFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
      super(font, antiAlias, fractionalMetrics);
      this.setupMinecraftColorcodes();
      this.setupBoldItalicIDs();
   }

   public void drawStringWithShadow(String text, double x, double y2, int color) {
      GL11.glTranslated(0.5D, 0.5D, 0.0D);
      this.drawString(text, x, y2, color, true);
      GL11.glTranslated(-0.5D, -0.5D, 0.0D);
      this.drawString(text, x, y2, color, false);
   }

   public String stripColorCodes(String input) {
      return this.STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
   }

   public void drawStringWithOutline(String text, double x, double y, int internalCol) {
      this.drawString(this.stripColorCodes(text), x - 0.5D, y, 0, false);
      this.drawString(this.stripColorCodes(text), x + 0.5D, y, 0, false);
      this.drawString(this.stripColorCodes(text), x, y - 0.5D, 0, false);
      this.drawString(this.stripColorCodes(text), x, y + 0.5D, 0, false);
      this.drawString(text, x, y, internalCol, false);
   }

   public void drawString(String text, float x, float y, int color) {
      this.drawString(text, (double)x, (double)y, color, false);
   }

   public void drawCenteredString(String text, float x, float y, int color) {
      this.drawString(text, x - (float)(this.getStringWidth(text) / 2) - 1.0F, y, color);
   }

   public void drawCenteredStringWithShadow(String text, float x, float y, int color) {
      this.drawStringWithShadow(text, (double)(x - (float)(this.getStringWidth(text) / 2) - 1.0F), (double)y, color);
   }

   public void drawCenteredStringWithShadow(String text, double x, double y, int color) {
      this.drawStringWithShadow(text, x - (double)(this.getStringWidth(text) / 2) - 1.0D, y, color);
   }

   public void drawString(String text, double x, double y, int color, boolean shadow) {
      --x;
      if (text != "" && text.length() != 0) {
         if (color == 553648127) {
            color = 16777215;
         }

         if ((color & -67108864) == 0) {
            color |= -16777216;
         }

         if (shadow) {
            color = (color & 16579836) >> 2 | color & -16777216;
         }

         CFont.CharData[] currentData = this.charData;
         float alpha = (float)(color >> 24 & 255) / 255.0F;
         boolean randomCase = false;
         boolean bold = false;
         boolean italic = false;
         boolean strikethrough = false;
         boolean underline = false;
         boolean render = true;
         x = x * 2.0D;
         y = (y - 3.0D) * 2.0D;
         GL11.glPushMatrix();
         GlStateManager.scale(0.5D, 0.5D, 1.0D);
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(770, 771);
         GlStateManager.color((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F, alpha);
         GlStateManager.enableTexture2D();
         GlStateManager.bindTexture(this.tex.getGlTextureId());
         GL11.glBindTexture(3553, this.tex.getGlTextureId());

         for(int index = 0; index < text.length(); ++index) {
            char character = text.charAt(index);
            int previous = index > 0 ? text.charAt(index - 1) : 46;
            if (previous != 167) {
               if (character == 167 && index < text.length()) {
                  int colorIndex = "0123456789abcdefklmnor".indexOf(text.toLowerCase(Locale.ENGLISH).charAt(index + 1));
                  if (colorIndex < 16) {
                     bold = false;
                     italic = false;
                     randomCase = false;
                     underline = false;
                     strikethrough = false;
                     GlStateManager.bindTexture(this.tex.getGlTextureId());
                     currentData = this.charData;
                     if (colorIndex < 0 || colorIndex > 15) {
                        colorIndex = 15;
                     }

                     if (shadow) {
                        colorIndex += 16;
                     }

                     int colorcode = this.colorCode[colorIndex];
                     GlStateManager.color((float)(colorcode >> 16 & 255) / 255.0F, (float)(colorcode >> 8 & 255) / 255.0F, (float)(colorcode & 255) / 255.0F, alpha);
                  } else if (colorIndex == 16) {
                     randomCase = true;
                  } else if (colorIndex == 17) {
                     bold = true;
                     if (italic) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        currentData = this.boldItalicChars;
                     } else {
                        GlStateManager.bindTexture(this.texBold.getGlTextureId());
                        currentData = this.boldChars;
                     }
                  } else if (colorIndex == 18) {
                     strikethrough = true;
                  } else if (colorIndex == 19) {
                     underline = true;
                  } else if (colorIndex == 20) {
                     italic = true;
                     if (bold) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        currentData = this.boldItalicChars;
                     } else {
                        GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                        currentData = this.italicChars;
                     }
                  } else {
                     bold = false;
                     italic = false;
                     randomCase = false;
                     underline = false;
                     strikethrough = false;
                     GlStateManager.color((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F, alpha);
                     GlStateManager.bindTexture(this.tex.getGlTextureId());
                     currentData = this.charData;
                  }

                  ++index;
               } else if (character < currentData.length && character <= 255) {
                  if (randomCase) {
                     ++character;
                  }

                  GL11.glBegin(4);
                  this.drawChar(currentData, character, (float)x, (float)y);
                  GL11.glEnd();
                  if (strikethrough) {
                     this.drawLine(x + 0.0D, y + (double)(currentData[character].height / 2), x + (double)currentData[character].width, y + (double)(currentData[character].height / 2), 3.0F);
                  }

                  if (underline) {
                     this.drawLine(x + 0.0D, y + (double)currentData[character].height - 15.0D, x + (double)currentData[character].width, y + (double)currentData[character].height - 15.0D, 1.0F);
                  }

                  x += (double)currentData[character].width - 8.0D + (double)this.charOffset;
               }
            }
         }

         GL11.glPopMatrix();
         GlStateManager.disableBlend();
         GlStateManager.bindTexture(0);
      }
   }

   public int getStringWidth(String text) {
      if (text == null) {
         return 0;
      } else {
         int width = 0;
         CFont.CharData[] currentData = this.charData;
         boolean bold = false;
         boolean italic = false;

         for(int index = 0; index < text.length(); ++index) {
            char character = text.charAt(index);
            int previous = index > 0 ? text.charAt(index - 1) : 46;
            if (previous != 167) {
               if (character == 167 && index < text.length()) {
                  int colorIndex = "0123456789abcdefklmnor".indexOf(text.toLowerCase(Locale.ENGLISH).charAt(index + 1));
                  if (colorIndex < 16) {
                     bold = false;
                     italic = false;
                  } else if (colorIndex == 17) {
                     bold = true;
                     currentData = italic ? this.boldItalicChars : this.boldChars;
                  } else if (colorIndex == 20) {
                     italic = true;
                     currentData = bold ? this.boldItalicChars : this.italicChars;
                  } else if (colorIndex == 21) {
                     bold = false;
                     italic = false;
                     currentData = this.charData;
                  }

                  ++index;
               } else if (character < currentData.length) {
                  width += currentData[character].width - 8 + this.charOffset;
               }
            }
         }

         return width / 2;
      }
   }

   public void setFont(Font font) {
      super.setFont(font);
      this.setupBoldItalicIDs();
   }

   public void setAntiAlias(boolean antiAlias) {
      super.setAntiAlias(antiAlias);
      this.setupBoldItalicIDs();
   }

   public void setFractionalMetrics(boolean fractionalMetrics) {
      super.setFractionalMetrics(fractionalMetrics);
      this.setupBoldItalicIDs();
   }

   private void setupBoldItalicIDs() {
      this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
      this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
      this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
   }

   private void drawLine(double x, double y, double x1, double y1, float width) {
      GL11.glDisable(3553);
      GL11.glLineWidth(width);
      GL11.glBegin(1);
      GL11.glVertex2d(x, y);
      GL11.glVertex2d(x1, y1);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public List wrapWords(String text, double width) {
      ArrayList finalWords = new ArrayList();
      if ((double)this.getStringWidth(text) > width) {
         String[] words = text.split(" ");
         StringBuilder currentWord = new StringBuilder();
         char lastColorCode = '\uffff';

         for(String word : words) {
            for(int innerIndex = 0; innerIndex < word.toCharArray().length; ++innerIndex) {
               char c = word.toCharArray()[innerIndex];
               if (c == 167 && innerIndex < word.toCharArray().length - 1) {
                  lastColorCode = word.toCharArray()[innerIndex + 1];
               }
            }

            if ((double)this.getStringWidth(currentWord + word + " ") < width) {
               currentWord.append(word).append(" ");
            } else {
               finalWords.add(currentWord.toString());
               currentWord = new StringBuilder("§" + lastColorCode + word + " ");
            }
         }

         if (currentWord.length() > 0) {
            if ((double)this.getStringWidth(currentWord.toString()) < width) {
               finalWords.add("§" + lastColorCode + currentWord + " ");
               new StringBuilder();
            } else {
               finalWords.addAll(this.formatString(currentWord.toString(), width));
            }
         }
      } else {
         finalWords.add(text);
      }

      return finalWords;
   }

   public List formatString(String string, double width) {
      ArrayList finalWords = new ArrayList();
      StringBuilder currentWord = new StringBuilder();
      char lastColorCode = '\uffff';
      char[] chars = string.toCharArray();

      for(int index = 0; index < chars.length; ++index) {
         char c = chars[index];
         if (c == 167 && index < chars.length - 1) {
            lastColorCode = chars[index + 1];
         }

         if ((double)this.getStringWidth(currentWord.toString() + c) < width) {
            currentWord.append(c);
         } else {
            finalWords.add(currentWord.toString());
            currentWord = new StringBuilder("§" + lastColorCode + c);
         }
      }

      if (currentWord.length() > 0) {
         finalWords.add(currentWord.toString());
      }

      return finalWords;
   }

   private void setupMinecraftColorcodes() {
      for(int index = 0; index < 32; ++index) {
         int noClue = (index >> 3 & 1) * 85;
         int red = (index >> 2 & 1) * 170 + noClue;
         int green = (index >> 1 & 1) * 170 + noClue;
         int blue = (index & 1) * 170 + noClue;
         if (index == 6) {
            red += 85;
         }

         if (index >= 16) {
            red /= 4;
            green /= 4;
            blue /= 4;
         }

         this.colorCode[index] = (red & 255) << 16 | (green & 255) << 8 | blue & 255;
      }

   }

   public String trimStringToWidth(String text, int width) {
      return this.trimStringToWidth(text, width, false);
   }

   public String trimStringToWidthPassword(String text, int width, boolean custom) {
      text = text.replaceAll(".", ".");
      return this.trimStringToWidth(text, width, custom);
   }

   private float getCharWidthFloat(char c) {
      if (c == 167) {
         return -1.0F;
      } else if (c == ' ') {
         return 2.0F;
      } else {
         int var2 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├�?┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐�?αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(c);
         if (c > 0 && var2 != -1) {
            return (float)this.charData[var2].width / 2.0F - 4.0F;
         } else if ((float)this.charData[c].width / 2.0F - 4.0F != 0.0F) {
            int var3 = (int)((float)this.charData[c].width / 2.0F - 4.0F) >>> 4;
            int var4 = (int)((float)this.charData[c].width / 2.0F - 4.0F) & 15;
            var3 = var3 & 15;
            ++var4;
            return (float)((var4 - var3) / 2 + 1);
         } else {
            return 0.0F;
         }
      }
   }

   public String trimStringToWidth(String text, int width, boolean custom) {
      StringBuilder buffer = new StringBuilder();
      float lineWidth = 0.0F;
      int offset = custom ? text.length() - 1 : 0;
      int increment = custom ? -1 : 1;
      boolean var8 = false;
      boolean var9 = false;

      for(int index = offset; index >= 0 && index < text.length() && lineWidth < (float)width; index += increment) {
         char character = text.charAt(index);
         float charWidth = this.getCharWidthFloat(character);
         if (var8) {
            var8 = false;
            if (character != 'l' && character != 'L') {
               if (character == 'r' || character == 'R') {
                  var9 = false;
               }
            } else {
               var9 = true;
            }
         } else if (charWidth < 0.0F) {
            var8 = true;
         } else {
            lineWidth += charWidth;
            if (var9) {
               ++lineWidth;
            }
         }

         if (lineWidth > (float)width) {
            break;
         }

         if (custom) {
            buffer.insert(0, character);
         } else {
            buffer.append(character);
         }
      }

      return buffer.toString();
   }
}
