package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.ColorValue;
import ft.sleep.api.value.Value;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.render.RenderUtil4;
import org.lwjgl.opengl.GL11;

public class ColorSetting extends Downward {
   public ColorValue verde$;
   public float johns$;
   public float exams$;
   public float allergy$;
   public float eddie$;
   public boolean enemy$;
   public boolean amounts$;
   public boolean auditor$;
   public float linda$;
   public float credits$;
   public float nuclear$;

   public ColorSetting(ColorValue devon, float motor, float account, int hotel, int hospital, ModuleRender2 minister) {
      super((Value)devon, (float)motor, (float)account, (int)hotel, (int)hospital, (ModuleRender2)minister);
      tight.verde$ = (ColorValue)devon;
      tight._either(((ColorValue)devon).getValue().intValue());
   }

   public void __/* $FF was: */(int colored, int orange) {
      singing.linda$ = Client.surround$.conflict$.();
      singing.credits$ = Client.surround$.conflict$.();
      singing.nuclear$ = singing..strength$ + (float)singing.();
      Object salem = singing.linda$ + 5.0F + singing..linking$ + 115.0F;
      Object earlier = singing.credits$ + 17.0F + singing.nuclear$ + 10.0F;
      Object talent = 11.0F;
      Object remained = 5.0F;
      FontLoaders.TahomaBold11.drawString(singing.verde$.getName(), singing.linda$ + 5.0F + singing..linking$ + 4.0F, singing.credits$ + 17.0F + singing.nuclear$ + 12.0F, (new Color(200, 200, 200)).getRGB());
      Object plates = RenderUtil4._speaks(0);
      RenderUtil4._oakland((double)(salem - 0.5F), (double)(earlier - 0.5F), (double)(salem + talent + 0.5F), (double)(earlier + remained + 0.5F), plates);
      Object expert = 255;
      Object bears = singing.verde$.getValue().intValue();
      Object follow = bears >> 24 & 255;
      Object nations = Math.min(expert, follow);
      if (follow < 255) {
         RenderUtil4._indie(salem, earlier, salem + talent, earlier + remained);
      }

      Object taught = (new Color(bears >> 16 & 255, bears >> 8 & 255, bears & 255, nations)).getRGB();
      RenderUtil4._casio(salem, earlier, salem + talent, earlier + remained, taught, RenderUtil4._advice(taught, 0.6F));
      if (singing.verde$.isExpanded()) {
         GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 3.0D);
         Object stations = singing._trainer();
         Object howard = singing._shower();
         Object clothes = singing._december();
         Object oscar = singing._mixing();
         RenderUtil4._avatar(stations, howard, stations + clothes, howard + oscar + 70.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), (new Color(85, 90, 96)).getRGB());
         Object zshops = clothes - 9.0F - 8.0F;
         Object robert = stations + 3.0F;
         Object richards = howard + 3.0F;
         Object reuters = robert + zshops;
         Object trauma = richards + zshops;
         Object tackle = (new Color(255, 255, 255, Math.min(expert, 180))).getRGB();
         if ((float)colored <= robert || (float)orange <= richards || (float)colored >= reuters || (float)orange >= trauma) {
            singing.enemy$ = false;
         }

         RenderUtil4._oakland((double)(robert - 0.5F), (double)(richards - 0.5F), (double)(reuters + 0.5F), (double)(trauma + 0.5F), RenderUtil4._speaks(0));
         singing._basic(robert, richards, reuters, trauma);
         Object calgary = singing.exams$ * (reuters - robert);
         Object finland = (1.0F - singing.allergy$) * (trauma - richards);
         if (singing.enemy$) {
            Object concord = reuters - robert;
            Object netscape = (float)colored - robert;
            singing.exams$ = netscape / concord;
            calgary = netscape;
            Object produce = trauma - richards;
            Object resort = (float)orange - richards;
            singing.allergy$ = 1.0F - resort / produce;
            finland = resort;
            singing._month(Color.HSBtoRGB(singing.johns$, singing.exams$, singing.allergy$), false);
         }

         Object var45 = robert + calgary - 0.5F;
         Object var43 = richards + finland - 0.5F;
         Object var41 = robert + calgary + 0.5F;
         Object var39 = richards + finland + 0.5F;
         RenderUtil4._oakland((double)(var45 - 0.5F), (double)(var43 - 0.5F), (double)var45, (double)(var39 + 0.5F), plates);
         RenderUtil4._oakland((double)var41, (double)(var43 - 0.5F), (double)(var41 + 0.5F), (double)(var39 + 0.5F), plates);
         RenderUtil4._oakland((double)var45, (double)(var43 - 0.5F), (double)var41, (double)var43, plates);
         RenderUtil4._oakland((double)var45, (double)var39, (double)var41, (double)(var39 + 0.5F), plates);
         RenderUtil4._oakland((double)var45, (double)var43, (double)var41, (double)var39, tackle);
         calgary = reuters + 3.0F;
         var45 = calgary + 8.0F;
         if ((float)colored <= calgary || (float)orange <= richards || (float)colored >= var45 || (float)orange >= trauma) {
            singing.amounts$ = false;
         }

         var41 = trauma - richards;
         var39 = (1.0F - singing.johns$) * var41;
         if (singing.amounts$) {
            Object tokyo = (float)orange - richards;
            singing.johns$ = 1.0F - tokyo / var41;
            var39 = tokyo;
            singing._month(Color.HSBtoRGB(singing.johns$, singing.exams$, singing.allergy$), false);
         }

         RenderUtil4._oakland((double)(calgary - 0.5F), (double)(richards - 0.5F), (double)(var45 + 0.5F), (double)(trauma + 0.5F), plates);
         Object var49 = trauma - richards;
         Object saver = var49 / 5.0F;
         Object garlic = richards;

         for(Object casinos = 0; (float)casinos < 5.0F; ++casinos) {
            Object batman = (float)casinos == 4.0F;
            RenderUtil4._casio(calgary, garlic, var45, garlic + saver, RenderUtil4._speaks(Color.HSBtoRGB(1.0F - 0.2F * (float)casinos, 1.0F, 1.0F)), RenderUtil4._speaks(Color.HSBtoRGB(1.0F - 0.2F * (float)(casinos + 1), 1.0F, 1.0F)));
            if (!batman) {
               garlic += saver;
            }
         }

         Object var54 = richards + var39 - 0.5F;
         Object crops = richards + var39 + 0.5F;
         RenderUtil4._oakland((double)(calgary - 0.5F), (double)(var54 - 0.5F), (double)calgary, (double)(crops + 0.5F), plates);
         RenderUtil4._oakland((double)var45, (double)(var54 - 0.5F), (double)(var45 + 0.5F), (double)(crops + 0.5F), plates);
         RenderUtil4._oakland((double)calgary, (double)(var54 - 0.5F), (double)var45, (double)var54, plates);
         RenderUtil4._oakland((double)calgary, (double)crops, (double)var45, (double)(crops + 0.5F), plates);
         RenderUtil4._oakland((double)calgary, (double)var54, (double)var45, (double)crops, tackle);
         finland = trauma + 3.0F;
         var43 = finland + 8.0F;
         if ((float)colored <= robert || (float)orange <= finland || (float)colored >= reuters || (float)orange >= var43) {
            singing.auditor$ = false;
         }

         Object securely = Color.HSBtoRGB(singing.johns$, singing.exams$, singing.allergy$);
         Object threat = securely >> 16 & 255;
         Object mission = securely >> 8 & 255;
         Object perform = securely & 255;
         var49 = reuters - robert;
         saver = singing.eddie$ * var49;
         if (singing.auditor$) {
            garlic = (float)colored - robert;
            singing.eddie$ = garlic / var49;
            saver = garlic;
            singing._month((new Color(threat, mission, perform, (int)(singing.eddie$ * 255.0F))).getRGB(), true);
         }

         RenderUtil4._oakland((double)(robert - 0.5F), (double)(finland - 0.5F), (double)(reuters + 0.5F), (double)(var43 + 0.5F), plates);
         RenderUtil4._indie(robert, finland, reuters, var43);
         RenderUtil4._lingerie((double)robert, (double)finland, (double)reuters, (double)var43, true, (new Color(threat, mission, perform, 0)).getRGB(), (new Color(threat, mission, perform, Math.min(expert, 255))).getRGB());
         garlic = robert + saver - 0.5F;
         crops = robert + saver + 0.5F;
         RenderUtil4._oakland((double)(garlic - 0.5F), (double)finland, (double)(crops + 0.5F), (double)var43, plates);
         RenderUtil4._oakland((double)garlic, (double)finland, (double)crops, (double)var43, tackle);
         GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -3.0D);
      }

   }

   public boolean _garmin(int izazazag, int gameyiru) {
      return (float)izazazag >= ubopevol.linda$ + 5.0F + ubopevol..linking$ + 115.0F && (float)izazazag <= ubopevol.linda$ + 5.0F + ubopevol..linking$ + 115.0F + 13.0F && (float)gameyiru >= ubopevol.credits$ + 17.0F + ubopevol.nuclear$ + 10.0F && (double)gameyiru <= (double)(ubopevol.credits$ + 17.0F + ubopevol.nuclear$ + 10.0F) - 0.5D + 8.0D;
   }

   public void __/* $FF was: */(int acocufam, int fefodiro, int vucafaru) {
      if (vucafaru == 1 && iligolim._garmin((int)acocufam, (int)fefodiro)) {
         iligolim.verde$.setExpanded(!iligolim.verde$.isExpanded());
      }

      if (iligolim.verde$.isExpanded() && vucafaru == 0) {
         Object adigedog = iligolim._trainer();
         Object udibulon = iligolim._shower();
         Object dayufuno = iligolim._december();
         Object zazazuzu = iligolim._mixing();
         Object elelerad = dayufuno - 9.0F - 8.0F;
         Object dagurave = adigedog + 3.0F;
         Object ayibiful = udibulon + 3.0F;
         Object relativi = dagurave + elelerad;
         Object eloferel = ayibiful + elelerad;
         Object onodufoy = eloferel + 3.0F;
         Object lufepuve = onodufoy + 8.0F;
         Object rogoyutu = relativi + 3.0F;
         float var16 = rogoyutu + 8.0F;
         iligolim.enemy$ = !iligolim.enemy$ && (float)acocufam > dagurave && (float)fefodiro > ayibiful && (float)acocufam < relativi && (float)fefodiro < eloferel;
         iligolim.auditor$ = !iligolim.auditor$ && (float)acocufam > dagurave && (float)fefodiro > onodufoy && (float)acocufam < relativi && (float)fefodiro < lufepuve;
         iligolim.amounts$ = !iligolim.amounts$ && (float)acocufam > rogoyutu && (float)fefodiro > ayibiful && (float)acocufam < var16 && (float)fefodiro < eloferel;
      }

   }

   public void __/* $FF was: */(int var1, int var2, int var3) {
      if (surgeon.amounts$) {
         surgeon.amounts$ = false;
      } else if (surgeon.enemy$) {
         surgeon.enemy$ = false;
      } else if (surgeon.auditor$) {
         surgeon.auditor$ = false;
      }

   }

   public void _month(int cuvazifo, boolean vemimoyu) {
      if (vemimoyu) {
         usiripog.verde$.setValue(Integer.valueOf((int)cuvazifo));
      } else {
         usiripog.verde$.setValue(Integer.valueOf((new Color(cuvazifo >> 16 & 255, cuvazifo >> 8 & 255, cuvazifo & 255, (int)(usiripog.eddie$ * 255.0F))).getRGB()));
      }

   }

   public void _basic(float honduras, float buttons, float brazil, float hockey) {
      Object ascii = RenderUtil4._speaks(Color.HSBtoRGB(marco.johns$, 1.0F, 1.0F));
      RenderUtil4._lingerie((double)honduras, (double)buttons, (double)brazil, (double)hockey, true, RenderUtil4._speaks(16777215), ascii);
      RenderUtil4._casio((float)honduras, (float)buttons, (float)brazil, (float)hockey, 0, RenderUtil4._speaks(0));
   }

   public void _either(int yodemeba) {
      Object ucipiyal = zufivala._moisture((int)yodemeba);
      zufivala.johns$ = ucipiyal[0];
      zufivala.exams$ = ucipiyal[1];
      zufivala.allergy$ = ucipiyal[2];
      zufivala.eddie$ = (float)(yodemeba >> 24 & 255) / 255.0F;
   }

   public float[] _moisture(int omeforel) {
      Object pusirame = omeforel >> 16 & 255;
      Object otirutug = omeforel >> 8 & 255;
      Object ofanolen = omeforel & 255;
      return Color.RGBtoHSB(pusirame, otirutug, ofanolen, (float[])null);
   }

   public float _trainer() {
      return epanomoz.linda$ + 5.0F + epanomoz..linking$ + 115.0F + 11.0F - 80.333336F;
   }

   public float _shower() {
      return window.credits$ + 17.0F + window.nuclear$ + 10.0F + 5.0F;
   }

   public float _december() {
      Object gross = taking.linda$ + 5.0F + taking..linking$ + 115.0F + 11.0F;
      return gross - taking._trainer();
   }

   public float _mixing() {
      return 11.0F;
   }
}
