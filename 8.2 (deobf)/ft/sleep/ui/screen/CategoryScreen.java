package ft.sleep.ui.screen;

import ft.sleep.Client;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ft.sleep.util.animation.Animation;
import ft.sleep.util.data.Position;
import ft.sleep.util.math.MathUtil;
import ft.sleep.util.render.RenderUtil4;
import ft.sleep.util.render.RoundedUtil;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class CategoryScreen {
   public float tanzania$ = Float.MAX_VALUE;
   public float cadillac$ = Float.intBitsToFloat(0);
   public float slowly$;
   public float planners$;
   public Position world$;
   public ModuleType calgary$;
   public float parker$;
   public float bingo$;
   public float attend$;
   public boolean looks$;
   public List cialis$ = new CopyOnWriteArrayList();
   public Animation fotos$ = new SmoothStepAnimation(0, Double.longBitsToDouble(0L), Direction.posted$);

   public CategoryScreen(ModuleType pofimosi, float ilavutel) {
      zunebegi.calgary$ = (ModuleType)pofimosi;
      zunebegi.parker$ = (float)ilavutel;
      zunebegi.world$ = new Position(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object vicudono = 0;
      Object igamuguf = 0;
      Object zuvovida = 0;

      for(Object pivomuzo : ModuleManager._trick()) {
         if (pivomuzo._bennett().equals(zunebegi.calgary$)) {
            Object oravumof = Float.intBitsToFloat(0);
            Object urefecic = zunebegi.world$.linking$ + (float)(vicudono % 2 == 0 ? 0 : 145);
            Object lenabobo = zunebegi.world$.strength$ + (float)(vicudono % 2 == 0 ? igamuguf : zuvovida);
            Object azazinam = new Position(urefecic, lenabobo, oravumof, 30.0F);
            Object onutezip = new ModuleRender2(pivomuzo, azazinam.linking$, azazinam.strength$, azazinam.error$, azazinam.shuttle$);
            azazinam.shuttle$ = (float)onutezip.travis$;
            if (vicudono % 2 == 0) {
               igamuguf = (int)((float)igamuguf + azazinam.shuttle$ + 20.0F);
            } else {
               zuvovida = (int)((float)zuvovida + azazinam.shuttle$ + 20.0F);
            }

            zunebegi.cialis$.add(onutezip);
            ++vicudono;
         }
      }

   }

   public String _voting(ModuleType apamusig) {
      if (((ModuleType)apamusig).name().equals("Combat")) {
         return "combat";
      } else if (((ModuleType)apamusig).name().equals("Player")) {
         return "player";
      } else if (((ModuleType)apamusig).name().equals("Movement")) {
         return "move";
      } else if (((ModuleType)apamusig).name().equals("Render")) {
         return "visuals";
      } else {
         return ((ModuleType)apamusig).name().equals("Legit") ? "legit" : "";
      }
   }

   public void _worse(int mirasefe, int abiyabay) {
      oyevapac.bingo$ = Client.surround$.conflict$.();
      oyevapac.attend$ = Client.surround$.conflict$.();
      if (oyevapac.looks$) {
         Object bulenogu = (double)oyevapac._midwest();

         for(ModuleRender2 var6 : oyevapac.cialis$) {
            var6.validity$ = (int) MathUtil._charms(bulenogu);
         }

         oyevapac._tennis(30);
         oyevapac.tanzania$ = Math.max(Float.intBitsToFloat(0), ((ModuleRender2)oyevapac.cialis$.get(oyevapac.cialis$.size() - 1))._terrace() + (float)(((ModuleRender2)oyevapac.cialis$.get(oyevapac.cialis$.size() - 1)).travis$ * 2) + 15.0F);
      }

      FontLoaders.TahomaBold13.drawString(oyevapac._voting(oyevapac.calgary$), oyevapac.parker$ + oyevapac.bingo$ + 77.0F, oyevapac.attend$ - 17.0F, -1);
      if (oyevapac.looks$) {
         RoundedUtil._ticket(oyevapac.parker$ + oyevapac.bingo$ + 76.0F, oyevapac.attend$ - 17.0F - 3.0F, (float)(FontLoaders.TahomaBold12.getStringWidth(oyevapac._voting(oyevapac.calgary$)) + 3), 9.0F, 1.0F, new Color(255, 255, 255, 44));
         GL11.glPushMatrix();
         RenderUtil4._admit(Double.longBitsToDouble(0L), (double) Client.surround$.conflict$.(), 1920.0D, 300.0D);
         GL11.glEnable(3089);
         oyevapac.cialis$.stream().sorted(CategoryScreen::_ground).forEach(CategoryScreen::_applied);
         GL11.glDisable(3089);
         GL11.glPopMatrix();
      }

      if (oyevapac._thompson((int)mirasefe, (int)abiyabay)) {
         RoundedUtil._ticket(oyevapac.parker$ + oyevapac.bingo$ + 76.0F, oyevapac.attend$ - 17.0F - 3.0F, (float)(FontLoaders.TahomaBold13.getStringWidth(oyevapac._voting(oyevapac.calgary$)) + 2), 9.0F, 1.0F, new Color(255, 255, 255, 44));
      }

   }

   public void _tennis(int metavipu) {
      omiratod.planners$ = (float)((double)omiratod.slowly$ - omiratod.fotos$._bloggers());
      Object ipumapas = Float.intBitsToFloat(0);
      if (omiratod.calgary$.name().equals("Combat")) {
         ipumapas = 600.0F;
      } else if (omiratod.calgary$.name().equals("Player")) {
         ipumapas = 70.0F;
      } else if (omiratod.calgary$.name().equals("Movement")) {
         ipumapas = -100.0F;
      } else if (omiratod.calgary$.name().equals("Render")) {
         ipumapas = 680.0F;
      } else if (omiratod.calgary$.name().equals("Legit")) {
         ipumapas = 50.0F;
      }

      omiratod.slowly$ += (float)Mouse.getDWheel() / 4.0F;
      omiratod.slowly$ = Math.max(Math.min(omiratod.cadillac$, omiratod.slowly$), -omiratod.tanzania$ - ipumapas);
      omiratod.fotos$ = new SmoothStepAnimation((int)metavipu, (double)(omiratod.slowly$ - omiratod.planners$), Direction.posted$);
   }

   public float _midwest() {
      adilusim.planners$ = (float)((double)adilusim.slowly$ - adilusim.fotos$._bloggers());
      return adilusim.planners$;
   }

   public boolean _thompson(int mubudeto, int devisolo) {
      return (float)mubudeto >= gupapiza.parker$ + gupapiza.bingo$ + 76.0F && (float)mubudeto <= gupapiza.parker$ + gupapiza.bingo$ + 76.0F + (float)FontLoaders.TahomaBold13.getStringWidth(gupapiza._voting(gupapiza.calgary$)) + 2.0F && (float)devisolo >= gupapiza.attend$ - 17.0F - 2.0F && (float)devisolo <= gupapiza.attend$ - 17.0F - 3.0F + 9.0F;
   }

   public void _belongs(int convert, int cleanup, int surgical) {
      apply.cialis$.forEach(CategoryScreen::_kodak);
   }

   public void _samsung(int scott, int remedies, int really) {
      isolated.cialis$.forEach(CategoryScreen::_wellness);
   }

   public void _surprise(char outreach, int creating) {
      entries.cialis$.forEach(CategoryScreen::_nodes);
   }

   public void _divide(boolean replied) {
      kijiji.looks$ = (boolean)replied;
   }

   public boolean _particle() {
      return ledosidu.looks$;
   }

   public static void _nodes(char fuzzy, int serve, ModuleRender2 funeral) {
      ((ModuleRender2)funeral)._muslim((char)fuzzy, (int)serve);
   }

   public static void _wellness(int narolipi, int sibevuga, int bazodilo, ModuleRender2 alayibop) {
      ((ModuleRender2)alayibop)._mortgage((int)narolipi, (int)sibevuga, (int)bazodilo);
   }

   public static void _kodak(int utitavim, int pebolisi, int ipipamad, ModuleRender2 azipocaz) {
      ((ModuleRender2)azipocaz)._buttons((int)utitavim, (int)pebolisi, (int)ipipamad);
   }

   public static void _applied(int tiyefipu, int utudimuy, ModuleRender2 bayomela) {
      ((ModuleRender2)bayomela)._units((int)tiyefipu, (int)utudimuy);
   }

   public static int _ground(ModuleRender2 ninotema, ModuleRender2 asigagep) {
      return Boolean.compare(((ModuleRender2)ninotema)._returns(), ((ModuleRender2)asigagep)._returns());
   }
}
