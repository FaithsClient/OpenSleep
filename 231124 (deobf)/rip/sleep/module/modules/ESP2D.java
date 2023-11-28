package rip.sleep.module.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RenderUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class ESP2D extends Module {
   public ModeValue c33966 = new ModeValue("2D Mode", new String[]{"Fill", "Box", "Corners 1", "Corners 2", "Split", "Arad"}, "Fill");
   public static ModeValue c53161 = new ModeValue("Color Mode", new String[]{"Astolfo", "Rainbow", "Christmas"}, "Astolfo");
   public NumberValue<Number> c15765 = new NumberValue<Number>("Line Width", () -> {
      Module[] var1 = Value.c27574();
      return this.c33966.c54460().equalsIgnoreCase("Box") || this.c33966.c54460().equalsIgnoreCase("Split");
   }, Integer.valueOf(1), 0.5D, Integer.valueOf(10), 0.5D);
   public BooleanValue c59055 = new BooleanValue("Border", () -> {
      Module[] var1 = Value.c27574();
      return this.c33966.c54460().equalsIgnoreCase("Fill") || this.c33966.c54460().equalsIgnoreCase("Box") || this.c33966.c54460().equalsIgnoreCase("Split");
   }, true);
   public List<EntityLivingBase> c49736 = new ArrayList();
   public BooleanValue c84080 = new BooleanValue("Players", true);
   public BooleanValue c18519 = new BooleanValue("Mobs", false);
   public BooleanValue c22290 = new BooleanValue("Invisible", false);
   public BooleanValue c7993 = new BooleanValue("Animals", false);
   public BooleanValue c62646 = new BooleanValue("Dead", false);
   public static int c75842;

   public ESP2D() {
      super("ESP 2D", new String[]{"ESP2D"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   @EventTarget
   public void c74427(Render2DEventA var1) {
      Value.c27574();
      double var3 = this.c15765.c53968().doubleValue();
      boolean var5 = this.c59055.c1473().booleanValue();
      List var6 = this.c72256();
      Iterator var7 = var6.iterator();
      if (var7.hasNext()) {
         EntityLivingBase var8 = (EntityLivingBase)var7.next();
         double var9 = RenderUtilD.c86345(var8.posX, var8.lastTickPosX, var1.c36064());
         double var11 = RenderUtilD.c86345(var8.posY, var8.lastTickPosY, var1.c36064()) - 0.1D;
         double var13 = RenderUtilD.c86345(var8.posZ, var8.lastTickPosZ, var1.c36064());
         double var15 = (double)var8.width / 1.5D;
         double var17 = (double)var8.getEyeHeight() * 1.3185D;
         Vector4d var19 = null;
         AxisAlignedBB var20 = new AxisAlignedBB(var9 - var15, var11, var13 - var15, var9 + var15, var11 + var17, var13 + var15);
         List var21 = Arrays.asList(new Vector3d(var20.minX, var20.minY, var20.minZ), new Vector3d(var20.minX, var20.maxY, var20.minZ), new Vector3d(var20.maxX, var20.minY, var20.minZ), new Vector3d(var20.maxX, var20.maxY, var20.minZ), new Vector3d(var20.minX, var20.minY, var20.maxZ), new Vector3d(var20.minX, var20.maxY, var20.maxZ), new Vector3d(var20.maxX, var20.minY, var20.maxZ), new Vector3d(var20.maxX, var20.maxY, var20.maxZ));
         mc.entityRenderer.setupCameraTransform(var1.c36064(), 0);
         Iterator var22 = var21.iterator();
         if (var22.hasNext()) {
            Vector3d var23 = (Vector3d)var22.next();
            var23 = RenderUtilD.c46412(var1.c26056(), var23.x - mc.getRenderManager().viewerPosX, var23.y - mc.getRenderManager().viewerPosY, var23.z - mc.getRenderManager().viewerPosZ);
            if (var23 != null && var23.z >= 0.0D && var23.z < 1.0D) {
               if (var19 == null) {
                  var19 = new Vector4d(var23.x, var23.y, var23.z, 0.0D);
               }

               var19.x = Math.min(var23.x, var19.x);
               var19.y = Math.min(var23.y, var19.y);
               var19.z = Math.max(var23.x, var19.z);
               var19.w = Math.max(var23.y, var19.w);
            }
         }

         mc.entityRenderer.setupOverlayRendering();
         if (var19 != null && var19.z >= 1.0D) {
            int var27 = c1331(12.0F, 0.7F, 1.0F, 0L);
            var19.y -= (double)(mc.thePlayer.getDistanceToEntity(var8) / 50.0F);
            String var29 = this.c33966.c54460();
            int var24 = -1;
            switch(var29.hashCode()) {
            case 2189731:
               if (!var29.equals("Fill")) {
                  break;
               }

               var24 = 0;
            case 2049076:
               if (!var29.equals("Arad")) {
                  break;
               }

               var24 = 1;
            case 66987:
               if (!var29.equals("Box")) {
                  break;
               }

               var24 = 2;
            case 80095994:
               if (var29.equals("Split")) {
                  var24 = 3;
               }
            }

            switch(var24) {
            case 0:
               if (var5) {
                  RenderUtilD.c24215(var19.x - 0.5D, var19.y - 0.5D + var17, var19.z + 0.5D, var19.w + 0.5D, (new Color(0, 0, 0, 70)).getRGB());
               }

               RenderUtilD.c24215(var19.x, var19.y + var17, var19.z, var19.w, (new Color(0, 0, 0, 70)).getRGB());
            case 1:
               GlStateManager.color(1.0F, 1.0F, 1.0F);
               mc.getTextureManager().bindTexture(new ResourceLocation("sleep/esp2d.jpg"));
               Gui.drawModalRectWithCustomSizedTexture((int)Math.round(var19.x), (int)Math.round(var19.y), 0.0F, 0.0F, (int)Math.round(var19.z - var19.x), (int)Math.round(var19.w - var19.y), (float)((int)Math.round(var19.x - var19.z)), (float)((int)Math.round(var19.w - var19.y)));
            case 2:
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.w - var3 - 0.5D, var19.z + var3 + 0.5D, var19.w + 0.5D, -16777216);
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.y + var17 - 0.5D, var19.z + var3 + 0.5D, var19.y + var17 + var3 + 0.5D, -16777216);
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.y + var17, var19.x + 0.5D, var19.w, -16777216);
               RenderUtilD.c24215(var19.z - 0.5D, var19.y + var17, var19.z + var3 + 0.5D, var19.w, -16777216);
               RenderUtilD.c24215(var19.x, var19.y + var17, var19.z, var19.y + var17 + var3, var27);
               RenderUtilD.c24215(var19.x, var19.w - var3, var19.z, var19.w, var27);
               RenderUtilD.c24215(var19.z, var19.y + var17, var19.z + var3, var19.w, var27);
               RenderUtilD.c24215(var19.x - var3, var19.y + var17, var19.x, var19.w, var27);
            case 3:
               double var25 = (var19.z - var19.x) / 4.0D;
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.w - var3 - 0.5D, var19.x + var25 + 0.5D, var19.w + 0.5D, -16777216);
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.y + var17 - 0.5D, var19.x + var25 + 0.5D, var19.y + var17 + var3 + 0.5D, -16777216);
               RenderUtilD.c24215(var19.z + var3 + 0.5D, var19.w - var3 - 0.5D, var19.z - var25 - 0.5D, var19.w + 0.5D, -16777216);
               RenderUtilD.c24215(var19.z + var3 + 0.5D, var19.y + var17 - 0.5D, var19.z - var25 - 0.5D, var19.y + var17 + var3 + 0.5D, -16777216);
               RenderUtilD.c24215(var19.x - var3 - 0.5D, var19.y + var17, var19.x + 0.5D, var19.w, -16777216);
               RenderUtilD.c24215(var19.z - 0.5D, var19.y + var17, var19.z + var3 + 0.5D, var19.w, -16777216);
               RenderUtilD.c24215(var19.x, var19.y + var17, var19.x + var25, var19.y + var17 + var3, var27);
               RenderUtilD.c24215(var19.x, var19.w - var3, var19.x + var25, var19.w, var27);
               RenderUtilD.c24215(var19.z, var19.y + var17, var19.z - var25, var19.y + var17 + var3, var27);
               RenderUtilD.c24215(var19.z, var19.w - var3, var19.z - var25, var19.w, var27);
               RenderUtilD.c24215(var19.z, var19.y + var17, var19.z + var3, var19.w, var27);
               RenderUtilD.c24215(var19.x - var3, var19.y + var17, var19.x, var19.w, var27);
            default:
               float var30 = 2.0F;
               var30 = var30 * var8.getHealth() * 8.0F;
               var30 = var30 * 0.001F;
               var24 = Color.HSBtoRGB(var30, 1.0F, 1.0F);
               float var34 = var8.getHealth() / var8.getMaxHealth();
               RenderUtilD.c24215(var19.x - var3 - 3.0D, var19.y + (var19.y - var19.w) * (double)var34 - (var19.y - var19.w) + var17 - 0.5D, var19.x - 2.0D + 0.5D, var19.w + 0.5D, -16777216);
               RenderUtilD.c24215(var19.x - var3 - 2.5D, var19.y + (var19.y - var19.w) * (double)var34 - (var19.y - var19.w) + var17, var19.x - 2.0D, var19.w, var24);
            }
         }
      }

   }

   public List<EntityLivingBase> c72256() {
      Module[] var1 = Value.c27574();
      if (!this.c24622()) {
         return new ArrayList();
      } else {
         this.c49736 = new ArrayList();
         Stream var10000 = mc.theWorld.loadedEntityList.stream();
         EntityLivingBase.class.getClass();
         Iterator var2 = ((List)var10000.filter(EntityLivingBase.class::isInstance).collect(Collectors.toList())).iterator();
         if (var2.hasNext()) {
            Entity var3 = (Entity)var2.next();
            EntityLivingBase var4 = (EntityLivingBase)var3;
            if (var4 != mc.thePlayer && (this.c22290.c1473().booleanValue() || !var4.isInvisible()) && (this.c18519.c1473().booleanValue() || !(var4 instanceof EntityMob) && !(var4 instanceof EntityArmorStand) && !(var4 instanceof EntityVillager)) && (this.c7993.c1473().booleanValue() || !(var4 instanceof EntityAnimal) && !(var4 instanceof EntityBat)) && (this.c84080.c1473().booleanValue() || !(var4 instanceof EntityPlayer)) && (this.c62646.c1473().booleanValue() || !var4.isDead && var4.getHealth() > 0.0F)) {
               this.c49736.add(var4);
            }
         }

         return this.c49736;
      }
   }

   public static int c1331(float var0, float var1, float var2, long var3) {
      Module[] var5 = Value.c27574();
      if (Objects.equals(c53161.c54460(), "Astolfo")) {
         return c60596(var0, var1, var2, var3);
      } else if (Objects.equals(c53161.c54460(), "Rainbow")) {
         return c49591(var0, var1, var2, var3);
      } else {
         return Objects.equals(c53161.c54460(), "Christmas") ? c83707(var0, var1, var3) : -16777216;
      }
   }

   public static int c49591(float var0, float var1, float var2, long var3) {
      float var5 = (float)((System.currentTimeMillis() + var3) % (long)((int)(var0 * 1000.0F))) / (var0 * 1000.0F);
      int var6 = Color.HSBtoRGB(var5, var1, var2);
      return var6;
   }

   public static int c83707(float var0, float var1, long var2) {
      Module[] var4 = Value.c27574();
      if (var2 > 10L) {
         var0 = (float)((double)var0 * 0.5D);
      }

      float var5 = (float)((System.currentTimeMillis() + var2) % (long)((int)(var0 * 1000.0F))) / (var0 * 1000.0F);
      float var6 = 0.0F;
      if ((double)var5 >= 0.5D) {
         var5 = 1.0F - var5;
      }

      var5 = var5 * 2.0F;
      int var7 = Color.HSBtoRGB(var6, var5, 1.0F);
      return var7;
   }

   public static int c60596(float var0, float var1, float var2, long var3) {
      Value.c27574();
      float var6 = (float)((System.currentTimeMillis() + var3) % (long)((int)(var0 * 1000.0F))) / (var0 * 1000.0F);
      if ((double)var6 >= 0.5D) {
         var6 = 0.5F + (1.0F - var6);
      }

      if ((double)var6 < 0.5D) {
         var6 = (float)((double)var6 + 0.5D);
      }

      int var7 = Color.HSBtoRGB(var6, var1, var2);
      return var7;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
