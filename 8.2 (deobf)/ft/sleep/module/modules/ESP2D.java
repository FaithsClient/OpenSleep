//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;

public class ESP2D extends Module {
   public Mode emission$ = new Mode("2D Mode", new String[]{"Fill", "Box", "Corners 1", "Corners 2", "Split", "Arad"}, "Fill");
   public static Mode placed$ = new Mode("Color Mode", new String[]{"Astolfo", "Rainbow", "Christmas"}, "Astolfo");
   public Numbers unique$ = new Numbers("Line Width", Integer.valueOf(1), 0.5D, Integer.valueOf(10), 0.5D);
   public Option promises$ = new Option("Border", true);
   public List monthly$ = new ArrayList();
   public Option could$ = new Option("Players", true);
   public Option peoples$ = new Option("Mobs", false);
   public Option sized$ = new Option("Invisible", false);
   public Option trust$ = new Option("Animals", false);
   public Option insulin$ = new Option("Dead", false);
   public static int reviewer$;

   public ESP2D() {
      super("ft.sleep.module.modules.ESP2D", new String[]{"ft.sleep.module.modules.ESP2D"}, ModuleType.ignored$);
   }

   @EventHandler
   public void _steven(EventRender2D ovuyutem) {
      Object ayoludap = rirugudo.unique$.getValue().doubleValue();
      Object damizose = rirugudo.promises$.getValue().booleanValue();

      for(Object liyezeti : rirugudo._election()) {
         Object erepazev = RenderUtils._kijiji(liyezeti.posX, liyezeti.lastTickPosX, ((EventRender2D)ovuyutem).getPartialTicks());
         Object yezoyimi = RenderUtils._kijiji(liyezeti.posY, liyezeti.lastTickPosY, ((EventRender2D)ovuyutem).getPartialTicks()) - 0.1D;
         Object nuremati = RenderUtils._kijiji(liyezeti.posZ, liyezeti.lastTickPosZ, ((EventRender2D)ovuyutem).getPartialTicks());
         Object mugacena = (double)liyezeti.width / 1.5D;
         Object ugubapif = (double)liyezeti.getEyeHeight() * 1.3185D;
         Object vudelesa = null;
         AxisAlignedBB var19 = new AxisAlignedBB(erepazev - mugacena, yezoyimi, nuremati - mugacena, erepazev + mugacena, yezoyimi + ugubapif, nuremati + mugacena);
         List var20 = Arrays.asList(new Vector3d(var19.minX, var19.minY, var19.minZ), new Vector3d(var19.minX, var19.maxY, var19.minZ), new Vector3d(var19.maxX, var19.minY, var19.minZ), new Vector3d(var19.maxX, var19.maxY, var19.minZ), new Vector3d(var19.minX, var19.minY, var19.maxZ), new Vector3d(var19.minX, var19.maxY, var19.maxZ), new Vector3d(var19.maxX, var19.minY, var19.maxZ), new Vector3d(var19.maxX, var19.maxY, var19.maxZ));
         rirugudo.mc.entityRenderer.setupCameraTransform(((EventRender2D)ovuyutem).getPartialTicks(), 0);

         for(Vector3d var22 : var20) {
            var22 = RenderUtils._istanbul(var22.x - rirugudo.mc.getRenderManager().viewerPosX, var22.y - rirugudo.mc.getRenderManager().viewerPosY, var22.z - rirugudo.mc.getRenderManager().viewerPosZ);
            if (var22 != null && var22.z >= Double.longBitsToDouble(0L) && var22.z < 1.0D) {
               if (vudelesa == null) {
                  vudelesa = new Vector4d(var22.x, var22.y, var22.z, Double.longBitsToDouble(0L));
               }

               vudelesa.x = Math.min(var22.x, vudelesa.x);
               vudelesa.y = Math.min(var22.y, vudelesa.y);
               vudelesa.z = Math.max(var22.x, vudelesa.z);
               vudelesa.w = Math.max(var22.y, vudelesa.w);
            }
         }

         rirugudo.mc.entityRenderer.setupOverlayRendering();
         if (vudelesa != null && vudelesa.z >= 1.0D) {
            int var26 = _practice(12.0F, 0.7F, 1.0F, (long)-1685882563 ^ -1685882563L);
            vudelesa.y -= (double)(rirugudo.mc.thePlayer.getDistanceToEntity(liyezeti) / 50.0F);
            String var28 = rirugudo.emission$.getValue();
            int var23 = -1;
            switch(var28.hashCode()) {
            case 66987:
               if (var28.equals("Box")) {
                  var23 = 2;
               }
               break;
            case 2049076:
               if (var28.equals("Arad")) {
                  var23 = 1;
               }
               break;
            case 2189731:
               if (var28.equals("Fill")) {
                  var23 = 0;
               }
               break;
            case 80095994:
               if (var28.equals("Split")) {
                  var23 = 3;
               }
            }

            switch(var23) {
            case 0:
               if (damizose) {
                  RenderUtils._illness(vudelesa.x - 0.5D, vudelesa.y - 0.5D + ugubapif, vudelesa.z + 0.5D, vudelesa.w + 0.5D, (new Color(0, 0, 0, 70)).getRGB());
               }

               RenderUtils._illness(vudelesa.x, vudelesa.y + ugubapif, vudelesa.z, vudelesa.w, (new Color(0, 0, 0, 70)).getRGB());
               break;
            case 1:
               GlStateManager.color(1.0F, 1.0F, 1.0F);
               rirugudo.mc.getTextureManager().bindTexture(new ResourceLocation("sleep/esp2d.jpg"));
               Gui.drawModalRectWithCustomSizedTexture((int)Math.round(vudelesa.x), (int)Math.round(vudelesa.y), Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)Math.round(vudelesa.z - vudelesa.x), (int)Math.round(vudelesa.w - vudelesa.y), (float)((int)Math.round(vudelesa.x - vudelesa.z)), (float)((int)Math.round(vudelesa.w - vudelesa.y)));
               break;
            case 2:
               if (damizose) {
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.w - ayoludap - 0.5D, vudelesa.z + ayoludap + 0.5D, vudelesa.w + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.y + ugubapif - 0.5D, vudelesa.z + ayoludap + 0.5D, vudelesa.y + ugubapif + ayoludap + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.y + ugubapif, vudelesa.x + 0.5D, vudelesa.w, -16777216);
                  RenderUtils._illness(vudelesa.z - 0.5D, vudelesa.y + ugubapif, vudelesa.z + ayoludap + 0.5D, vudelesa.w, -16777216);
               }

               RenderUtils._illness(vudelesa.x, vudelesa.y + ugubapif, vudelesa.z, vudelesa.y + ugubapif + ayoludap, var26);
               RenderUtils._illness(vudelesa.x, vudelesa.w - ayoludap, vudelesa.z, vudelesa.w, var26);
               RenderUtils._illness(vudelesa.z, vudelesa.y + ugubapif, vudelesa.z + ayoludap, vudelesa.w, var26);
               RenderUtils._illness(vudelesa.x - ayoludap, vudelesa.y + ugubapif, vudelesa.x, vudelesa.w, var26);
               break;
            case 3:
               double var24 = (vudelesa.z - vudelesa.x) / 4.0D;
               if (damizose) {
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.w - ayoludap - 0.5D, vudelesa.x + var24 + 0.5D, vudelesa.w + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.y + ugubapif - 0.5D, vudelesa.x + var24 + 0.5D, vudelesa.y + ugubapif + ayoludap + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.z + ayoludap + 0.5D, vudelesa.w - ayoludap - 0.5D, vudelesa.z - var24 - 0.5D, vudelesa.w + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.z + ayoludap + 0.5D, vudelesa.y + ugubapif - 0.5D, vudelesa.z - var24 - 0.5D, vudelesa.y + ugubapif + ayoludap + 0.5D, -16777216);
                  RenderUtils._illness(vudelesa.x - ayoludap - 0.5D, vudelesa.y + ugubapif, vudelesa.x + 0.5D, vudelesa.w, -16777216);
                  RenderUtils._illness(vudelesa.z - 0.5D, vudelesa.y + ugubapif, vudelesa.z + ayoludap + 0.5D, vudelesa.w, -16777216);
               }

               RenderUtils._illness(vudelesa.x, vudelesa.y + ugubapif, vudelesa.x + var24, vudelesa.y + ugubapif + ayoludap, var26);
               RenderUtils._illness(vudelesa.x, vudelesa.w - ayoludap, vudelesa.x + var24, vudelesa.w, var26);
               RenderUtils._illness(vudelesa.z, vudelesa.y + ugubapif, vudelesa.z - var24, vudelesa.y + ugubapif + ayoludap, var26);
               RenderUtils._illness(vudelesa.z, vudelesa.w - ayoludap, vudelesa.z - var24, vudelesa.w, var26);
               RenderUtils._illness(vudelesa.z, vudelesa.y + ugubapif, vudelesa.z + ayoludap, vudelesa.w, var26);
               RenderUtils._illness(vudelesa.x - ayoludap, vudelesa.y + ugubapif, vudelesa.x, vudelesa.w, var26);
            }

            float var29 = 2.0F;
            var29 = var29 * liyezeti.getHealth() * 8.0F;
            var29 = var29 * 0.001F;
            var23 = Color.HSBtoRGB(var29, 1.0F, 1.0F);
            float var33 = liyezeti.getHealth() / liyezeti.getMaxHealth();
            if (damizose) {
               RenderUtils._illness(vudelesa.x - ayoludap - 3.0D, vudelesa.y + (vudelesa.y - vudelesa.w) * (double)var33 - (vudelesa.y - vudelesa.w) + ugubapif - 0.5D, vudelesa.x - 2.0D + 0.5D, vudelesa.w + 0.5D, -16777216);
            }

            RenderUtils._illness(vudelesa.x - ayoludap - 2.5D, vudelesa.y + (vudelesa.y - vudelesa.w) * (double)var33 - (vudelesa.y - vudelesa.w) + ugubapif, vudelesa.x - 2.0D, vudelesa.w, var23);
         }
      }

   }

   public List _election() {
      if (!numbers._central()) {
         return new ArrayList();
      } else {
         numbers.monthly$ = new ArrayList();
         Stream var10000 = numbers.mc.theWorld.loadedEntityList.stream();
         EntityLivingBase.class.getClass();

         for(Object fellow : (List)var10000.filter(EntityLivingBase.class::isInstance).collect(Collectors.toList())) {
            Object outcome = (EntityLivingBase)fellow;
            if (outcome != numbers.mc.thePlayer && (numbers.sized$.getValue().booleanValue() || !outcome.isInvisible()) && (numbers.peoples$.getValue().booleanValue() || !(outcome instanceof EntityMob) && !(outcome instanceof EntityArmorStand) && !(outcome instanceof EntityVillager)) && (numbers.trust$.getValue().booleanValue() || !(outcome instanceof EntityAnimal) && !(outcome instanceof EntityBat)) && (numbers.could$.getValue().booleanValue() || !(outcome instanceof EntityPlayer)) && (numbers.insulin$.getValue().booleanValue() || !outcome.isDead && outcome.getHealth() > Float.intBitsToFloat(0))) {
               numbers.monthly$.add(outcome);
            }
         }

         return numbers.monthly$;
      }
   }

   public static int _practice(float habits, float delivery, float vermont, long total) {
      if (Objects.equals(placed$.getValue(), "Astolfo")) {
         return _reliance((float)habits, (float)delivery, (float)vermont, (long)total);
      } else if (Objects.equals(placed$.getValue(), "Rainbow")) {
         return _mutual((float)habits, (float)delivery, (float)vermont, (long)total);
      } else {
         return Objects.equals(placed$.getValue(), "Christmas") ? _visits((float)habits, (float)delivery, (long)total) : -16777216;
      }
   }

   public static int _mutual(float nilumebi, float oyutorit, float ilobizov, long rinaseva) {
      Object sagoyozo = (float)((System.currentTimeMillis() + rinaseva) % (long)((int)(nilumebi * 1000.0F))) / (nilumebi * 1000.0F);
      int var6 = Color.HSBtoRGB(sagoyozo, (float)oyutorit, (float)ilobizov);
      return var6;
   }

   public static int _visits(float uzolitod, float utimadec, long nesevala) {
      if (nesevala > ((long)1834437610 ^ 1834437600L)) {
         uzolitod = (float)((double)uzolitod * 0.5D);
      }

      Object asisopop = (float)((System.currentTimeMillis() + nesevala) % (long)((int)(uzolitod * 1000.0F))) / (uzolitod * 1000.0F);
      float var5 = Float.intBitsToFloat(0);
      if ((double)asisopop >= 0.5D) {
         asisopop = 1.0F - asisopop;
      }

      asisopop = asisopop * 2.0F;
      int var6 = Color.HSBtoRGB(var5, asisopop, 1.0F);
      return var6;
   }

   public static int _reliance(float votuvobi, float lutasozi, float ovoyarop, long iyifarad) {
      Object fibiteyo = (float)((System.currentTimeMillis() + iyifarad) % (long)((int)(votuvobi * 1000.0F))) / (votuvobi * 1000.0F);
      if ((double)fibiteyo >= 0.5D) {
         fibiteyo = 0.5F + (1.0F - fibiteyo);
      } else if ((double)fibiteyo < 0.5D) {
         fibiteyo = (float)((double)fibiteyo + 0.5D);
      }

      int var6 = Color.HSBtoRGB(fibiteyo, (float)lutasozi, (float)ovoyarop);
      return var6;
   }
}
