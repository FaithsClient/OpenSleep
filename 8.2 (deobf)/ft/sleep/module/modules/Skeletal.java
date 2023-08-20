//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.util.Map;
import java.util.WeakHashMap;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class Skeletal extends Module {
   public static Map allows$ = new WeakHashMap();
   public Numbers relax$ = new Numbers("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   public Numbers perhaps$ = new Numbers("Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   public Numbers searched$ = new Numbers("Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(1));
   public Numbers brussels$ = new Numbers("Width", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(5), 0.1D);
   public Option starter$ = new Option("SmoothLines", false);

   public Skeletal() {
      super("ft.sleep.module.modules.Skeletal", new String[]{"ft.sleep.module.modules.Skeletal"}, ModuleType.ignored$);
   }

   public static void _tales(EntityPlayer ebony, ModelPlayer antibody) {
      allows$.put(ebony, new float[][]{{((ModelPlayer)antibody).bipedHead.rotateAngleX, ((ModelPlayer)antibody).bipedHead.rotateAngleY, ((ModelPlayer)antibody).bipedHead.rotateAngleZ}, {((ModelPlayer)antibody).bipedRightArm.rotateAngleX, ((ModelPlayer)antibody).bipedRightArm.rotateAngleY, ((ModelPlayer)antibody).bipedRightArm.rotateAngleZ}, {((ModelPlayer)antibody).bipedLeftArm.rotateAngleX, ((ModelPlayer)antibody).bipedLeftArm.rotateAngleY, ((ModelPlayer)antibody).bipedLeftArm.rotateAngleZ}, {((ModelPlayer)antibody).bipedRightLeg.rotateAngleX, ((ModelPlayer)antibody).bipedRightLeg.rotateAngleY, ((ModelPlayer)antibody).bipedRightLeg.rotateAngleZ}, {((ModelPlayer)antibody).bipedLeftLeg.rotateAngleX, ((ModelPlayer)antibody).bipedLeftLeg.rotateAngleY, ((ModelPlayer)antibody).bipedLeftLeg.rotateAngleZ}});
   }

   @EventHandler
   public void _swiss(EventRender3D cazirori) {
      anefaduy._permit(true);
      GL11.glEnable(2903);
      GL11.glDisable(2848);
      allows$.keySet().removeIf(anefaduy::_compound);
      Object foyadebi = allows$;
      Object vomanuyu = anefaduy.mc.theWorld.playerEntities;
      Object yiliboze = foyadebi.keySet().toArray();
      Object runecube = yiliboze.length;

      for(Object ulovuyif = 0; ulovuyif < runecube; ++ulovuyif) {
         Object aloyulib = (EntityPlayer)yiliboze[ulovuyif];
         Object zatomusu = (float[][])foyadebi.get(aloyulib);
         if (zatomusu != null && aloyulib.getEntityId() != -1488 && aloyulib.isEntityAlive() && RenderUtils._multi(aloyulib) && !aloyulib.isDead && aloyulib != anefaduy.mc.thePlayer && !aloyulib.isPlayerSleeping() && !aloyulib.isInvisible()) {
            GL11.glPushMatrix();
            Object azuliguy = (float[][])foyadebi.get(aloyulib);
            GL11.glLineWidth(anefaduy.brussels$.getValue().floatValue());
            GL11.glColor4f(anefaduy.relax$.getValue().floatValue() / 255.0F, anefaduy.perhaps$.getValue().floatValue() / 255.0F, anefaduy.searched$.getValue().floatValue() / 255.0F, 1.0F);
            Object onulevaf = _foster(aloyulib.posX, aloyulib.lastTickPosX, (double)((EventRender3D)cazirori).getPartialTicks()) - anefaduy.mc.getRenderManager().renderPosX;
            Object sumaguga = _foster(aloyulib.posY, aloyulib.lastTickPosY, (double)((EventRender3D)cazirori).getPartialTicks()) - anefaduy.mc.getRenderManager().renderPosY;
            double var14 = _foster(aloyulib.posZ, aloyulib.lastTickPosZ, (double)((EventRender3D)cazirori).getPartialTicks()) - anefaduy.mc.getRenderManager().renderPosZ;
            GL11.glTranslated(onulevaf, sumaguga, var14);
            float var16 = aloyulib.prevRenderYawOffset + (aloyulib.renderYawOffset - aloyulib.prevRenderYawOffset) * anefaduy.mc.timer.renderPartialTicks;
            GL11.glRotatef(-var16, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), aloyulib.isSneaking() ? -0.235D : Double.longBitsToDouble(0L));
            float var17 = aloyulib.isSneaking() ? 0.6F : 0.75F;
            float var18 = 57.29578F;
            GL11.glPushMatrix();
            GL11.glTranslated(-0.125D, (double)var17, Double.longBitsToDouble(0L));
            if (azuliguy[3][0] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[3][0] * 57.29578F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            if (azuliguy[3][1] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[3][1] * 57.29578F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            }

            if (azuliguy[3][2] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[3][2] * 57.29578F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), (double)(-var17), Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.125D, (double)var17, Double.longBitsToDouble(0L));
            if (azuliguy[4][0] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[4][0] * 57.29578F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            if (azuliguy[4][1] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[4][1] * 57.29578F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            }

            if (azuliguy[4][2] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[4][2] * 57.29578F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), (double)(-var17), Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), aloyulib.isSneaking() ? 0.25D : Double.longBitsToDouble(0L));
            GL11.glPushMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), aloyulib.isSneaking() ? -0.05D : Double.longBitsToDouble(0L), aloyulib.isSneaking() ? -0.01725D : Double.longBitsToDouble(0L));
            GL11.glPushMatrix();
            GL11.glTranslated(-0.375D, (double)var17 + 0.55D, Double.longBitsToDouble(0L));
            if (azuliguy[1][0] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[1][0] * 57.29578F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            if (azuliguy[1][1] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[1][1] * 57.29578F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            }

            if (azuliguy[1][2] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(-azuliguy[1][2] * 57.29578F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), -0.5D, Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(0.375D, (double)var17 + 0.55D, Double.longBitsToDouble(0L));
            if (azuliguy[2][0] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[2][0] * 57.29578F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            if (azuliguy[2][1] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[2][1] * 57.29578F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            }

            if (azuliguy[2][2] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(-azuliguy[2][2] * 57.29578F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
            }

            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), -0.5D, Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glRotatef(var16 - aloyulib.rotationYawHead, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            GL11.glPushMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), (double)var17 + 0.55D, Double.longBitsToDouble(0L));
            if (azuliguy[0][0] != Float.intBitsToFloat(0)) {
               GL11.glRotatef(azuliguy[0][0] * 57.29578F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), 0.3D, Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glRotatef(aloyulib.isSneaking() ? 25.0F : Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            GL11.glTranslated(Double.longBitsToDouble(0L), aloyulib.isSneaking() ? -0.16175D : Double.longBitsToDouble(0L), aloyulib.isSneaking() ? -0.48025D : Double.longBitsToDouble(0L));
            GL11.glPushMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), (double)var17, Double.longBitsToDouble(0L));
            GL11.glBegin(3);
            GL11.glVertex3d(-0.125D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(0.125D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), (double)var17, Double.longBitsToDouble(0L));
            GL11.glBegin(3);
            GL11.glVertex3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(Double.longBitsToDouble(0L), 0.55D, Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(Double.longBitsToDouble(0L), (double)var17 + 0.55D, Double.longBitsToDouble(0L));
            GL11.glBegin(3);
            GL11.glVertex3d(-0.375D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glVertex3d(0.375D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
         }
      }

      anefaduy._permit(false);
   }

   public void _permit(boolean commonly) {
      Object tulsa = virus.starter$.getValue().booleanValue();
      if (commonly) {
         if (tulsa) {
            RenderUtils._motel();
         } else {
            GL11.glDisable(2848);
         }

         GL11.glDisable(2929);
         GL11.glDisable(3553);
      } else {
         GL11.glEnable(3553);
         GL11.glEnable(2929);
         if (tulsa) {
            RenderUtils._reads();
         }
      }

      GL11.glDepthMask(!commonly);
   }

   public boolean _former(EntityPlayer algeria) {
      return !nikon.mc.theWorld.playerEntities.contains(algeria);
   }

   public static double _foster(double ecosasep, double mocubufi, double var4) {
      return mocubufi + (ecosasep - mocubufi) * var4;
   }

   public boolean _compound(Object combat) {
      return courtesy._former((EntityPlayer)combat);
   }
}
