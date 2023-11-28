package rip.sleep.module.modules;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.*;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.PositionStructB;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class LightingTrack extends Module {
   public static BooleanValue c39585 = new BooleanValue("Render", true);
   public static BooleanValue c35878 = new BooleanValue("Only Text", true);
   public static BooleanValue c72653 = new BooleanValue("Noti Render", true);
   public static NumberValue<Number> c72313 = new NumberValue<Number>("Remove Time", 4.0D, 1.0D, 60.0D, 1.0D);
   private final TimerUtilF c30332 = new TimerUtilF();
   public final ArrayList<PositionStructB> c16199 = new ArrayList();
   private final List<LightingNode> c59363 = new ArrayList();

   public LightingTrack() {
      super("Lightning Track", new String[]{"LightningTrack"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public void c83205() {
      super.c83205();
      this.c30332.c99119();
      this.c16199.clear();
      this.c59363.clear();
   }

   public void c71897() {
      super.c83205();
      this.c30332.c99119();
      this.c16199.clear();
      this.c59363.clear();
   }

   @EventTarget
   public void c72757(WorldEvent var1) {
      if (c39585.c1473().booleanValue()) {
         this.c59363.clear();
      }

   }

   @EventTarget
   public void c82872(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      if (c39585.c1473().booleanValue()) {
         Iterator var3 = this.c59363.iterator();
         if (var3.hasNext()) {
            LightingNode var4 = (LightingNode)var3.next();
            if (var4.c14170(180.0F)) {
               var4.c80700();
            }
         }
      }

   }

   @EventTarget
   public void c41033(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (c39585.c1473().booleanValue()) {
         Iterator var3 = this.c59363.iterator();
         if (var3.hasNext()) {
            LightingNode var4 = (LightingNode)var3.next();
            float var5 = (float)((double)((float)var4.c35458() + 0.0F * var1.c36064()) - mc.getRenderManager().renderPosX);
            float var6 = (float)((double)((float)var4.c40782() + 0.0F * var1.c36064()) - mc.getRenderManager().renderPosY);
            float var7 = (float)((double)((float)var4.c12683() + 0.0F * var1.c36064()) - mc.getRenderManager().renderPosZ);
            var4.c62584(var4.c20520((double)var5, (double)var6, (double)var7));
         }
      }

   }

   @EventTarget
   public void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c39585.c1473().booleanValue() && this.c30332.c87813(200.0D)) {
         this.c30332.c99119();
      }

   }

   private boolean c78135(PositionStructB var1, PositionStructB var2) {
      Module[] var3 = Value.c27574();
      return MathHelper.floor_double(var1.c29088()) == MathHelper.floor_double(var2.c29088()) && MathHelper.floor_double(var1.c14827()) == MathHelper.floor_double(var2.c14827()) && MathHelper.floor_double(var1.c35042()) == MathHelper.floor_double(var2.c35042());
   }

   @EventTarget
   public void c93300(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (!ServerUtilA.c92750() && PacketReceiveEvent.getPacket() instanceof S2CPacketSpawnGlobalEntity) {
         S2CPacketSpawnGlobalEntity var3 = (S2CPacketSpawnGlobalEntity) PacketReceiveEvent.getPacket();
         if (var3.func_149053_g() == 1) {
            int var4 = var3.func_149051_d() / 32;
            int var5 = var3.func_149050_e() / 32;
            int var6 = var3.func_149049_f() / 32;
            PositionStructB var7 = new PositionStructB((double)var4, (double)var5, (double)var6);
            boolean var8 = true;
            Iterator var9 = this.c16199.iterator();
            if (var9.hasNext()) {
               PositionStructB var10 = (PositionStructB)var9.next();
               if (this.c78135(var10, var7)) {
                  var8 = false;
               }
            }

            if (!var8) {
               return;
            }

            this.c16199.add(var7);
            PlayerUtilG.c11143(String.format("Lightning Struck (%s, %s, %s)", var7.c29088(), var7.c14827(), var7.c35042()));
            Sleep.getInstance().c83083().c43114().add(new Notification(String.format("Lightning Struck (%s, %s, %s)", var7.c29088(), var7.c14827(), var7.c35042()), 2000L));
            if (c39585.c1473().booleanValue()) {
               EnumChatFormatting[] var14 = new EnumChatFormatting[]{EnumChatFormatting.BLACK, EnumChatFormatting.DARK_BLUE, EnumChatFormatting.DARK_GREEN, EnumChatFormatting.DARK_AQUA, EnumChatFormatting.DARK_RED, EnumChatFormatting.DARK_PURPLE, EnumChatFormatting.GOLD, EnumChatFormatting.GRAY, EnumChatFormatting.DARK_GRAY, EnumChatFormatting.BLUE, EnumChatFormatting.GREEN, EnumChatFormatting.AQUA, EnumChatFormatting.RED, EnumChatFormatting.LIGHT_PURPLE, EnumChatFormatting.YELLOW, EnumChatFormatting.WHITE};
               Random var15 = new Random();
               int var11 = var15.nextInt(var14.length);
               EnumChatFormatting var12 = var14[var11];
               int var13 = this.c59363.size() + 1;
               this.c80187(new LightingNode(var12 + "[" + var13 + "] Lighting", (int)var7.c29088(), (int)var7.c14827(), (int)var7.c35042()));
            }

            if (c72653.c1473().booleanValue()) {
               Sleep.getInstance().c83083().c43114().add(new Notification(String.format("Remove Lightning Struck (%s, %s, %s)", var7.c29088(), var7.c14827(), var7.c35042()), 1000L * c72313.c53968().longValue()));
            }
         }
      }

   }

   public void c80187(LightingNode var1) {
      this.c59363.add(var1);
      (new Thread(() -> {
         long var10000 = 1000L;
         NumberValue var10001 = c72313;

         try {
            Thread.sleep(var10000 * var10001.c53968().longValue());
         } catch (InterruptedException var3) {
            var3.printStackTrace();
         }

         this.c59363.remove(var1);
      })).start();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   public static final class LightingNode {
      private final String c40030;
      private final int c89002;
      private final int c83644;
      private final int c36238;
      private transient double[] c7981 = new double[]{0.0D, 0.0D, 0.0D};

      public LightingNode(String var1, int var2, int var3, int var4) {
         this.c40030 = var1;
         this.c89002 = var2;
         this.c83644 = var3;
         this.c36238 = var4;
      }

      public static LightingNode c14568(String var0, int var1, int var2, int var3) {
         return new LightingNode(var0, var1, var2, var3);
      }

      public void c80700() {
         ScaledResolution var2 = new ScaledResolution(Minecraft.getMinecraft());
         Value.c27574();
         GL11.glPushMatrix();
         GL11.glTranslated(this.c7981[0] / (double)var2.getScaleFactor(), this.c7981[1] / (double)var2.getScaleFactor(), this.c7981[2] / (double)var2.getScaleFactor());
         GlStateManager.translate(0.0D, -2.5D, 0.0D);
         GlStateManager.disableDepth();
         if (!LightingTrack.c35878.c1473().booleanValue()) {
            ShaderUtilB.c25830((float)(-(Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.c40030 + " " + this.c83960() + "m") / 2) - 3), -5.0F, (float)(Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.c40030 + " " + this.c83960() + "m") / 2) + 45.5F + (this.c83960() >= 100 && this.c83960() <= 999 ? 1.5F : -0.5F), 14.0F, 3.0F, new Color(0, 0, 0, 70));
            RenderUtilD.c15402((float)(-(Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.c40030 + " " + this.c83960() + "m") / 2) - 3), -5.0F, (float)(Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.c40030 + " " + this.c83960() + "m") / 2) + 45.5F + (this.c83960() >= 100 && this.c83960() <= 999 ? 1.5F : -0.5F), 14.0F, 10, new Color(0, 0, 0, 80));
         }

         Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.c40030 + " " + EnumChatFormatting.GRAY + this.c83960() + "m", (float)((int)(-((float)Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.c40030 + " " + this.c83960() + "m") / 2.0F))) + (this.c83960() >= 100 && this.c83960() <= 999 ? -0.5F : 0.5F), -1.5F, -1);
         GlStateManager.enableDepth();
         GL11.glPopMatrix();
      }

      public int c83960() {
         int var1 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posX - (double)this.c35458());
         int var2 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posY - (double)this.c40782());
         int var3 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posZ - (double)this.c12683());
         return (int)Math.sqrt((double)(var1 * var1 + var2 * var2 + var3 * var3));
      }

      public boolean c14170(float var1) {
         Value.c27574();
         var1 = (float)((double)var1 * 0.5D);
         double var3 = ((double)(Minecraft.getMinecraft().thePlayer.rotationYaw - this.c56533()) % 360.0D + 540.0D) % 360.0D - 180.0D;
         return var3 > 0.0D && var3 < (double)var1 || (double)(-var1) < var3 && var3 < 0.0D;
      }

      public float c56533() {
         double var1 = (double)this.c35458() - Minecraft.getMinecraft().thePlayer.posX;
         double var3 = (double)this.c12683() - Minecraft.getMinecraft().thePlayer.posZ;
         double var5 = Math.atan2(var1, var3) * 57.2957795D;
         var5 = -var5;
         return (float)var5;
      }

      public double[] c20520(double var1, double var3, double var5) {
         FloatBuffer var8 = BufferUtils.createFloatBuffer(3);
         FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
         Value.c27574();
         FloatBuffer var10 = BufferUtils.createFloatBuffer(16);
         IntBuffer var11 = BufferUtils.createIntBuffer(16);
         GL11.glGetFloat(2982, var9);
         GL11.glGetFloat(2983, var10);
         GL11.glGetInteger(2978, var11);
         boolean var12 = GLU.gluProject((float)var1, (float)var3, (float)var5, var9, var10, var11, var8);
         return var12 ? new double[]{(double)var8.get(0), (double)((float)Display.getHeight() - var8.get(1)), (double)var8.get(2)} : null;
      }

      public void c62584(double[] var1) {
         this.c7981 = var1;
      }

      public String getName() {
         return this.c40030;
      }

      public int c35458() {
         return this.c89002;
      }

      public int c40782() {
         return this.c83644;
      }

      public int c12683() {
         return this.c36238;
      }

      private static JSONException c22745(JSONException var0) {
         return var0;
      }
   }
}
