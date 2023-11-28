package rip.sleep.module.modules;

import java.util.Map;
import java.util.WeakHashMap;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RenderUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class Skeletal extends Module {
   private static final Map<EntityPlayer, float[][]> c10185 = new WeakHashMap();
   private final NumberValue<Number> c72491 = new NumberValue<Number>("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   private final NumberValue<Number> c83488 = new NumberValue<Number>("Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   private final NumberValue<Number> c4944 = new NumberValue<Number>("Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   private final NumberValue<Number> c85218 = new NumberValue<Number>("Width", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(5), 0.1D);
   private final BooleanValue c31311 = new BooleanValue("SmoothLines", false);

   public Skeletal() {
      super("Skeletal", new String[]{"Skeletal"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   public static void c42040(EntityPlayer var0, ModelPlayer var1) {
      c10185.put(var0, new float[][]{{var1.field_78116_c.rotateAngleX, var1.field_78116_c.rotateAngleY, var1.field_78116_c.rotateAngleZ}, {var1.field_178723_h.rotateAngleX, var1.field_178723_h.rotateAngleY, var1.field_178723_h.rotateAngleZ}, {var1.field_178724_i.rotateAngleX, var1.field_178724_i.rotateAngleY, var1.field_178724_i.rotateAngleZ}, {var1.field_178721_j.rotateAngleX, var1.field_178721_j.rotateAngleY, var1.field_178721_j.rotateAngleZ}, {var1.field_178722_k.rotateAngleX, var1.field_178722_k.rotateAngleY, var1.field_178722_k.rotateAngleZ}});
   }

   @EventTarget
   public void c78334(Render3DEvent var1) {
      this.c97590(true);
      Value.c27574();
      GL11.glEnable(2903);
      GL11.glDisable(2848);
      c10185.keySet().removeIf((var1x) -> {
         return this.c42548(var1x);
      });
      Map var3 = c10185;
      Object[] var4 = var3.keySet().toArray();
      int var5 = var4.length;
      int var6 = 0;
      if (var6 < var5) {
         EntityPlayer var7 = (EntityPlayer)var4[var6];
         float[][] var8 = (float[][])var3.get(var7);
         if (var7.getEntityId() != -1488 && var7.isEntityAlive() && RenderUtilD.c29156(var7) && !var7.isDead && var7 != mc.thePlayer && !var7.isPlayerSleeping()) {
            if (var7.isInvisible()) {
               ;
            }

            GL11.glPushMatrix();
            float[][] var9 = (float[][])var3.get(var7);
            GL11.glLineWidth(this.c85218.c53968().floatValue());
            GL11.glColor4f(this.c72491.c53968().floatValue() / 255.0F, this.c83488.c53968().floatValue() / 255.0F, this.c4944.c53968().floatValue() / 255.0F, 1.0F);
            double var10 = c10143(var7.posX, var7.lastTickPosX, (double)var1.c36064()) - mc.getRenderManager().renderPosX;
            double var12 = c10143(var7.posY, var7.lastTickPosY, (double)var1.c36064()) - mc.getRenderManager().renderPosY;
            double var14 = c10143(var7.posZ, var7.lastTickPosZ, (double)var1.c36064()) - mc.getRenderManager().renderPosZ;
            GL11.glTranslated(var10, var12, var14);
            float var16 = var7.prevRenderYawOffset + (var7.renderYawOffset - var7.prevRenderYawOffset) * mc.timer.renderPartialTicks;
            GL11.glRotatef(-var16, 0.0F, 1.0F, 0.0F);
            GL11.glTranslated(0.0D, 0.0D, var7.isSneaking() ? -0.235D : 0.0D);
            float var17 = var7.isSneaking() ? 0.6F : 0.75F;
            GL11.glPushMatrix();
            GL11.glTranslated(-0.125D, (double)var17, 0.0D);
            if (var9[3][0] != 0.0F) {
               GL11.glRotatef(var9[3][0] * 57.29578F, 1.0F, 0.0F, 0.0F);
            }

            if (var9[3][1] != 0.0F) {
               GL11.glRotatef(var9[3][1] * 57.29578F, 0.0F, 1.0F, 0.0F);
            }

            if (var9[3][2] != 0.0F) {
               GL11.glRotatef(var9[3][2] * 57.29578F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, (double)(-var17), 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.125D, (double)var17, 0.0D);
            if (var9[4][0] != 0.0F) {
               GL11.glRotatef(var9[4][0] * 57.29578F, 1.0F, 0.0F, 0.0F);
            }

            if (var9[4][1] != 0.0F) {
               GL11.glRotatef(var9[4][1] * 57.29578F, 0.0F, 1.0F, 0.0F);
            }

            if (var9[4][2] != 0.0F) {
               GL11.glRotatef(var9[4][2] * 57.29578F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, (double)(-var17), 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glTranslated(0.0D, 0.0D, var7.isSneaking() ? 0.25D : 0.0D);
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, var7.isSneaking() ? -0.05D : 0.0D, var7.isSneaking() ? -0.01725D : 0.0D);
            GL11.glPushMatrix();
            GL11.glTranslated(-0.375D, (double)var17 + 0.55D, 0.0D);
            if (var9[1][0] != 0.0F) {
               GL11.glRotatef(var9[1][0] * 57.29578F, 1.0F, 0.0F, 0.0F);
            }

            if (var9[1][1] != 0.0F) {
               GL11.glRotatef(var9[1][1] * 57.29578F, 0.0F, 1.0F, 0.0F);
            }

            if (var9[1][2] != 0.0F) {
               GL11.glRotatef(-var9[1][2] * 57.29578F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, -0.5D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.375D, (double)var17 + 0.55D, 0.0D);
            if (var9[2][0] != 0.0F) {
               GL11.glRotatef(var9[2][0] * 57.29578F, 1.0F, 0.0F, 0.0F);
            }

            if (var9[2][1] != 0.0F) {
               GL11.glRotatef(var9[2][1] * 57.29578F, 0.0F, 1.0F, 0.0F);
            }

            if (var9[2][2] != 0.0F) {
               GL11.glRotatef(-var9[2][2] * 57.29578F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, -0.5D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glRotatef(var16 - var7.rotationYawHead, 0.0F, 1.0F, 0.0F);
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, (double)var17 + 0.55D, 0.0D);
            if (var9[0][0] != 0.0F) {
               GL11.glRotatef(var9[0][0] * 57.29578F, 1.0F, 0.0F, 0.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, 0.3D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glRotatef(var7.isSneaking() ? 25.0F : 0.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslated(0.0D, var7.isSneaking() ? -0.16175D : 0.0D, var7.isSneaking() ? -0.48025D : 0.0D);
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, (double)var17, 0.0D);
            GL11.glBegin(3);
            GL11.glVertex3d(-0.125D, 0.0D, 0.0D);
            GL11.glVertex3d(0.125D, 0.0D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, (double)var17, 0.0D);
            GL11.glBegin(3);
            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
            GL11.glVertex3d(0.0D, 0.55D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, (double)var17 + 0.55D, 0.0D);
            GL11.glBegin(3);
            GL11.glVertex3d(-0.375D, 0.0D, 0.0D);
            GL11.glVertex3d(0.375D, 0.0D, 0.0D);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
         }

         ++var6;
      }

      this.c97590(false);
   }

   private void c97590(boolean var1) {
      Value.c27574();
      boolean var3 = this.c31311.c1473().booleanValue();
      if (var1) {
         if (var3) {
            RenderUtilD.c20367();
         }

         GL11.glDisable(2848);
         GL11.glDisable(2929);
         GL11.glDisable(3553);
      }

      GL11.glEnable(3553);
      GL11.glEnable(2929);
      if (var3) {
         RenderUtilD.c60785();
      }

      GL11.glDepthMask(!var1);
   }

   private boolean c42548(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return !mc.theWorld.playerEntities.contains(var1);
   }

   public static double c10143(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
