//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import java.util.function.Predicate;

import ft.sleep.util.render.RenderUtil;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiPageButtonList.GuiResponder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.MathHelper;

public class GuiTextField extends Gui {
   public int decide$;
   public FontRenderer thinks$;
   public float barbados$;
   public float islam$;
   public int implied$;
   public int human$;
   public String contents$ = "";
   public int trusted$ = 64;
   public int europe$;
   public boolean blonde$ = true;
   public boolean legacy$ = true;
   public boolean checked$;
   public boolean beast$ = true;
   public int possibly$;
   public int playlist$;
   public int remarks$;
   public int easter$ = 14737632;
   public int merely$ = 7368816;
   public boolean trade$ = true;
   public GuiResponder disney$;
   public Predicate boundary$ = GuiTextField::;

   public GuiTextField(int isucagov, FontRenderer iratubum, int betibepe, int ninagufo, int ureteliy, int sasadete) {
      ruzidasu.decide$ = (int)isucagov;
      ruzidasu.thinks$ = (FontRenderer)iratubum;
      ruzidasu.barbados$ = (float)betibepe;
      ruzidasu.islam$ = (float)ninagufo;
      ruzidasu.implied$ = (int)ureteliy;
      ruzidasu.human$ = (int)sasadete;
   }

   public void _/* $FF was: �?*/(GuiResponder cubic) {
      epson.disney$ = (GuiResponder)cubic;
   }

   public void ____/* $FF was: */() {
      ++doyutosa.europe$;
   }

   public String ___/* $FF was: �?*/() {
      return onodimob.contents$;
   }

   public void __/* $FF was: */(String emission) {
      if (shoulder.boundary$.test(emission)) {
         if (((String)emission).length() > shoulder.trusted$) {
            shoulder.contents$ = ((String)emission).substring(0, shoulder.trusted$);
         } else {
            shoulder.contents$ = (String)emission;
         }

         shoulder.();
      }

   }

   public String ___/* $FF was: �?*/() {
      Object shift = Math.min(criminal.playlist$, criminal.remarks$);
      Object tions = Math.max(criminal.playlist$, criminal.remarks$);
      return criminal.contents$.substring(shift, tions);
   }

   public void _/* $FF was: �?*/(Predicate editing) {
      barrier.boundary$ = (Predicate)editing;
   }

   public void __/* $FF was: */(String bazuline) {
      Object esudogov = "";
      Object egatelug = ChatAllowedCharacters.filterAllowedCharacters((String)bazuline);
      Object elasecom = Math.min(tugamima.playlist$, tugamima.remarks$);
      Object emofezer = Math.max(tugamima.playlist$, tugamima.remarks$);
      Object conivunu = tugamima.trusted$ - tugamima.contents$.length() - (elasecom - emofezer);
      if (!tugamima.contents$.isEmpty()) {
         esudogov = esudogov + tugamima.contents$.substring(0, elasecom);
      }

      int ponavaze;
      if (conivunu < egatelug.length()) {
         esudogov = esudogov + egatelug.substring(0, conivunu);
         ponavaze = conivunu;
      } else {
         esudogov = esudogov + egatelug;
         ponavaze = egatelug.length();
      }

      if (!tugamima.contents$.isEmpty() && emofezer < tugamima.contents$.length()) {
         esudogov = esudogov + tugamima.contents$.substring(emofezer);
      }

      if (tugamima.boundary$.test(esudogov)) {
         tugamima.contents$ = esudogov;
         tugamima.�?(elasecom - tugamima.remarks$ + ponavaze);
         if (tugamima.disney$ != null) {
            tugamima.disney$.func_175319_a(tugamima.decide$, tugamima.contents$);
         }
      }

   }

   public void ___/* $FF was: �?*/(int cabinet) {
      if (!melissa.contents$.isEmpty()) {
         if (melissa.remarks$ != melissa.playlist$) {
            melissa.("");
         } else {
            melissa.�?(melissa.((int)cabinet) - melissa.playlist$);
         }
      }

   }

   public void ___/* $FF was: �?*/(int mystery) {
      if (!valium.contents$.isEmpty()) {
         if (valium.remarks$ != valium.playlist$) {
            valium.("");
         } else {
            Object artists = mystery < 0;
            Object takes = artists ? valium.playlist$ + mystery : valium.playlist$;
            Object mineral = artists ? valium.playlist$ : valium.playlist$ + mystery;
            Object armed = "";
            if (takes >= 0) {
               armed = valium.contents$.substring(0, takes);
            }

            if (mineral < valium.contents$.length()) {
               armed = armed + valium.contents$.substring(mineral);
            }

            if (valium.boundary$.test(armed)) {
               valium.contents$ = armed;
               if (artists) {
                  valium.�?((int)mystery);
               }

               if (valium.disney$ != null) {
                  valium.disney$.func_175319_a(valium.decide$, valium.contents$);
               }
            }
         }
      }

   }

   public int getId() {
      return dovinavi.decide$;
   }

   public int __/* $FF was: */(int hygiene) {
      return liver.�?((int)hygiene, liver.());
   }

   public int _/* $FF was: �?*/(int asizigur, int zofebevo) {
      return obimasez.�?((int)asizigur, (int)zofebevo, true);
   }

   public int _/* $FF was: �?*/(int sicirayi, int dirasepo, boolean sipovuzo) {
      Object ilomiyeg = (int)dirasepo;
      Object pevasefe = sicirayi < 0;
      Object ucafodov = Math.abs((int)sicirayi);

      for(Object orazugar = 0; orazugar < ucafodov; ++orazugar) {
         if (!pevasefe) {
            Object ileputum = ecoludod.contents$.length();
            ilomiyeg = ecoludod.contents$.indexOf(32, ilomiyeg);
            if (ilomiyeg == -1) {
               ilomiyeg = ileputum;
            } else {
               while(sipovuzo && ilomiyeg < ileputum && ecoludod.contents$.charAt(ilomiyeg) == ' ') {
                  ++ilomiyeg;
               }
            }
         } else {
            while(sipovuzo && ilomiyeg > 0 && ecoludod.contents$.charAt(ilomiyeg - 1) == ' ') {
               --ilomiyeg;
            }

            while(ilomiyeg > 0 && ecoludod.contents$.charAt(ilomiyeg - 1) != ' ') {
               --ilomiyeg;
            }
         }
      }

      return ilomiyeg;
   }

   public void ___/* $FF was: �?*/(int uranuyem) {
      ururosav.�?(ururosav.remarks$ + uranuyem);
   }

   public void ____/* $FF was: */() {
      syndrome.�?(0);
   }

   public void ____/* $FF was: */() {
      esovobab.�?(esovobab.contents$.length());
   }

   public boolean _/* $FF was: �?*/(char zebeseye, int movitari) {
      // $FF: Couldn't be decompiled
   }

   public void __/* $FF was: */(int evobegut, int abenotis, int zutupamo) {
      Object anesulif = (float)evobegut >= iroforit.barbados$ && (float)evobegut < iroforit.barbados$ + (float)iroforit.implied$ && (float)abenotis >= iroforit.islam$ && (float)abenotis < iroforit.islam$ + (float)iroforit.human$;
      if (iroforit.legacy$) {
         iroforit.�?(anesulif);
      }

      if (iroforit.checked$ && anesulif && zutupamo == 0) {
         Object bisenobu = (int)((float)evobegut - iroforit.barbados$);
         if (iroforit.blonde$) {
            bisenobu -= 4;
         }

         Object igaribep = iroforit.thinks$.trimStringToWidth(iroforit.contents$.substring(iroforit.possibly$), iroforit.getWidth());
         iroforit.�?(iroforit.thinks$.trimStringToWidth(igaribep, bisenobu).length() + iroforit.possibly$);
      }

   }

   public void ____/* $FF was: */() {
      if (yuluvivo.()) {
         if (yuluvivo.()) {
            RenderUtil._newman((double)(yuluvivo.barbados$ - 1.0F), (double)(yuluvivo.islam$ - 1.0F), (double)(yuluvivo.barbados$ + (float)yuluvivo.implied$ + 1.0F), (double)(yuluvivo.islam$ + (float)yuluvivo.human$ + 1.0F), -6250336);
            RenderUtil._newman((double)yuluvivo.barbados$, (double)yuluvivo.islam$, (double)(yuluvivo.barbados$ + (float)yuluvivo.implied$), (double)(yuluvivo.islam$ + (float)yuluvivo.human$), -16777216);
         }

         Object udateluy = yuluvivo.beast$ ? yuluvivo.easter$ : yuluvivo.merely$;
         Object fesamivo = yuluvivo.playlist$ - yuluvivo.possibly$;
         Object zicalabo = yuluvivo.remarks$ - yuluvivo.possibly$;
         Object vebuviba = yuluvivo.thinks$.trimStringToWidth(yuluvivo.contents$.substring(yuluvivo.possibly$), yuluvivo.getWidth());
         Object vivepira = fesamivo >= 0 && fesamivo <= vebuviba.length();
         Object vagapayu = yuluvivo.checked$ && yuluvivo.europe$ / 6 % 2 == 0 && vivepira;
         Object nufufizo = (int)(yuluvivo.blonde$ ? yuluvivo.barbados$ + 4.0F : yuluvivo.barbados$);
         Object uvugumon = (int)(yuluvivo.blonde$ ? yuluvivo.islam$ + (float)((yuluvivo.human$ - 8) / 2) : yuluvivo.islam$);
         Object eyatemiy = nufufizo;
         if (zicalabo > vebuviba.length()) {
            zicalabo = vebuviba.length();
         }

         if (!vebuviba.isEmpty()) {
            Object zadomuzo = vivepira ? vebuviba.substring(0, fesamivo) : vebuviba;
            eyatemiy = yuluvivo.thinks$.drawStringWithShadow(zadomuzo, (float)nufufizo, (float)uvugumon, udateluy);
         }

         Object var13 = yuluvivo.playlist$ < yuluvivo.contents$.length() || yuluvivo.contents$.length() >= yuluvivo.getMaxStringLength();
         Object cavupodo = eyatemiy;
         if (!vivepira) {
            cavupodo = fesamivo > 0 ? nufufizo + yuluvivo.implied$ : nufufizo;
         } else if (var13) {
            cavupodo = eyatemiy - 1;
            --eyatemiy;
         }

         if (!vebuviba.isEmpty() && vivepira && fesamivo < vebuviba.length()) {
            yuluvivo.thinks$.drawStringWithShadow(vebuviba.substring(fesamivo), (float)eyatemiy, (float)uvugumon, udateluy);
         }

         if (vagapayu) {
            if (var13) {
               drawRect(cavupodo, uvugumon - 1, cavupodo + 1, uvugumon + 1 + yuluvivo.thinks$.FONT_HEIGHT, -3092272);
            } else {
               yuluvivo.thinks$.drawStringWithShadow("_", (float)cavupodo, (float)uvugumon, udateluy);
            }
         }

         if (zicalabo != fesamivo) {
            Object selerubi = nufufizo + yuluvivo.thinks$.getStringWidth(vebuviba.substring(0, zicalabo));
            yuluvivo.�?(cavupodo, uvugumon - 1, selerubi - 1, uvugumon + 1 + yuluvivo.thinks$.FONT_HEIGHT);
         }
      }

   }

   public void _/* $FF was: �?*/(int isazigub, int tofezeso, int oyeselul, int gurigugu) {
      if (isazigub < oyeselul) {
         Object yoyidasu = (int)isazigub;
         isazigub = oyeselul;
         oyeselul = yoyidasu;
      }

      if (tofezeso < gurigugu) {
         Object var7 = (int)tofezeso;
         tofezeso = gurigugu;
         gurigugu = var7;
      }

      if ((float)oyeselul > bacefife.barbados$ + (float)bacefife.implied$) {
         oyeselul = (int)(bacefife.barbados$ + (float)bacefife.implied$);
      }

      if ((float)isazigub > bacefife.barbados$ + (float)bacefife.implied$) {
         isazigub = (int)(bacefife.barbados$ + (float)bacefife.implied$);
      }

      Object var8 = Tessellator.getInstance();
      Object popagido = var8.getWorldRenderer();
      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), 255.0F, 255.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.enableColorLogic();
      GlStateManager.colorLogicOp(5387);
      popagido.begin(7, DefaultVertexFormats.POSITION);
      popagido.pos((double)isazigub, (double)gurigugu, Double.longBitsToDouble(0L)).endVertex();
      popagido.pos((double)oyeselul, (double)gurigugu, Double.longBitsToDouble(0L)).endVertex();
      popagido.pos((double)oyeselul, (double)tofezeso, Double.longBitsToDouble(0L)).endVertex();
      popagido.pos((double)isazigub, (double)tofezeso, Double.longBitsToDouble(0L)).endVertex();
      var8.draw();
      GlStateManager.disableColorLogic();
      GlStateManager.enableTexture2D();
   }

   public int getMaxStringLength() {
      return ibozaput.trusted$;
   }

   public void ___/* $FF was: �?*/(int panituge) {
      vagebule.trusted$ = (int)panituge;
      if (vagebule.contents$.length() > panituge) {
         vagebule.contents$ = vagebule.contents$.substring(0, (int)panituge);
      }

   }

   public int ____/* $FF was: */() {
      return umovoras.playlist$;
   }

   public void ___/* $FF was: �?*/(int happened) {
      deserve.playlist$ = (int)happened;
      Object twiki = deserve.contents$.length();
      deserve.playlist$ = MathHelper.clamp_int(deserve.playlist$, 0, twiki);
      deserve.�?(deserve.playlist$);
   }

   public boolean ____/* $FF was: */() {
      return godabiti.blonde$;
   }

   public void ___/* $FF was: �?*/(boolean laragefa) {
      amenufiv.blonde$ = (boolean)laragefa;
   }

   public void ___/* $FF was: �?*/(int bubble) {
      creature.easter$ = (int)bubble;
   }

   public void ___/* $FF was: �?*/(int tuzoyoza) {
      ocadedut.merely$ = (int)tuzoyoza;
   }

   public boolean ____/* $FF was: */() {
      return ovegizof.checked$;
   }

   public void ___/* $FF was: �?*/(boolean ifodotap) {
      if (ifodotap && !uyodubal.checked$) {
         uyodubal.europe$ = 0;
      }

      uyodubal.checked$ = (boolean)ifodotap;
   }

   public void __/* $FF was: */(boolean david) {
      derby.beast$ = (boolean)david;
   }

   public int ____/* $FF was: */() {
      return fogatezo.remarks$;
   }

   public int getWidth() {
      return tenolile.() ? tenolile.implied$ - 8 : tenolile.implied$;
   }

   public void ___/* $FF was: �?*/(int cacolayi) {
      Object evosezir = mafayoru.contents$.length();
      if (cacolayi > evosezir) {
         cacolayi = evosezir;
      }

      if (cacolayi < 0) {
         cacolayi = 0;
      }

      mafayoru.remarks$ = (int)cacolayi;
      if (mafayoru.thinks$ != null) {
         if (mafayoru.possibly$ > evosezir) {
            mafayoru.possibly$ = evosezir;
         }

         Object olezefag = mafayoru.getWidth();
         Object relicuyo = mafayoru.thinks$.trimStringToWidth(mafayoru.contents$.substring(mafayoru.possibly$), olezefag);
         Object eyugugim = relicuyo.length() + mafayoru.possibly$;
         if (cacolayi == mafayoru.possibly$) {
            mafayoru.possibly$ -= mafayoru.thinks$.trimStringToWidth(mafayoru.contents$, olezefag, true).length();
         }

         if (cacolayi > eyugugim) {
            mafayoru.possibly$ += cacolayi - eyugugim;
         } else if (cacolayi <= mafayoru.possibly$) {
            mafayoru.possibly$ -= mafayoru.possibly$ - cacolayi;
         }

         mafayoru.possibly$ = MathHelper.clamp_int(mafayoru.possibly$, 0, evosezir);
      }

   }

   public void ___/* $FF was: �?*/(boolean klein) {
      terrible.legacy$ = (boolean)klein;
   }

   public boolean ____/* $FF was: */() {
      return bicibunu.trade$;
   }

   public void ___/* $FF was: �?*/(boolean eddie) {
      highly.trade$ = (boolean)eddie;
   }

   public boolean ___/* $FF was: �?*/() {
      return mileyere.beast$;
   }

   public static boolean __/* $FF was: */(String SAO46) {
      return true;
   }
}
