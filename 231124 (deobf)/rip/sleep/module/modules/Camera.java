package rip.sleep.module.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.*;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.unmap.c9902;
import rip.sleep.util.RenderUtilC;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.value.values.StringValue;
import wdm.*;

public class Camera extends Module {
   public static BooleanValue c88102 = new BooleanValue("Event Rotation", true);
   public static ModeValue c94474 = new ModeValue("Body Mode", () -> {
      return c88102.c1473();
   }, new String[]{"Zenith", "Sigma", "Astolfo", "Head", "Astolfo2"}, "Zenith");
   public static NumberValue<Number> c42900 = new NumberValue<Number>("Amplitude", () -> {
      Module[] var0 = Value.c27574();
      return c94474.c54460().equalsIgnoreCase("Zenith") || c94474.c54460().equalsIgnoreCase("Astolfo");
   }, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(50), Integer.valueOf(1));
   public static BooleanValue c11866 = new BooleanValue("Attack Crit", true);
   public static NumberValue<Number> c50222 = new NumberValue<Number>("Amount", () -> {
      return c11866.c1473();
   }, Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(1));
   public static ModeValue c64015 = new ModeValue("Mode", () -> {
      return c11866.c1473();
   }, new String[]{"Blood", "Magic", "Criticals"}, "Magic");
   public static BooleanValue c58084 = new BooleanValue("Sound", () -> {
      return c64015.c54460().equalsIgnoreCase("Blood");
   }, true);
   public static BooleanValue c85807 = new BooleanValue("DMG Particle", true);
   public static StringValue c40412 = new StringValue("Custom Text", () -> {
      return c85807.c1473();
   }, "zaogao");
   public static BooleanValue c77072 = new BooleanValue("Hight Bright", true);
   public static NumberValue<Number> c10369 = new NumberValue<Number>("Brightness", "Brightness", () -> {
      return c77072.c1473();
   }, 1.0D, 0.0D, 2.0D, 0.1D);
   public static BooleanValue c99553 = new BooleanValue("Auto F5", false);
   public static BooleanValue c22415 = new BooleanValue("Hide Boos", false);
   public static BooleanValue c96352 = new BooleanValue("FPS Cam H", true);
   public static BooleanValue c39762 = new BooleanValue("FPS Cam V", true);
   public static BooleanValue c11513 = new BooleanValue("Jump Circles", true);
   public static BooleanValue c96195 = new BooleanValue("No Hurt Cam", true);
   public static NumberValue<Number> c88109 = new NumberValue<Number>("Swing Slow", 0.0D, -3.0D, 20.0D, 1.0D);
   private Float c48796;
   private Float c73331;
   public static float c22729 = 0.0F;
   public ArrayList<c9902> c88945;
   public final Map<Vec3, Long> c48466 = new HashMap();
   public boolean c67920 = false;
   private int c70810;
   private final Pattern c23535;

   public Camera() {
      super("Camera", new String[]{"Camera"}, ModuleType.c12482, ModuleType.c21190.c94221);
      this.c70810 = mc.gameSettings.thirdPersonView;
      this.c23535 = Pattern.compile("(?i)§[0-9A-FK-ORX]");
      this.c88945 = new ArrayList();
   }

   @EventTarget
   public void c83205() {
      Module[] var1 = Value.c27574();
      if (c11513.c1473().booleanValue()) {
         this.c48466.clear();
         this.c67920 = true;
      }

      mc.gameSettings.gammaSetting = 300.0F;
   }

   public void c71897() {
   }

   @EventTarget
   void c95126(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c99553.c1473().booleanValue()) {
         int var3 = 0;
         if (var3 <= mc.gameSettings.thirdPersonView) {
            if (KillAura.c19685 != null) {
               mc.gameSettings.thirdPersonView = 4;
            }

            if (mc.gameSettings.thirdPersonView > 3) {
               mc.gameSettings.thirdPersonView = this.c70810;
            }

            ++var3;
         }

      }
   }

   @EventTarget
   public void c44340(Render2DEventA var1) {
      Value.c27574();
      ScaledResolution var3 = new ScaledResolution(mc);
      if (c39762.c1473().booleanValue()) {
         RenderUtilC.c71699(0.0D, 0.0D, (double)var3.getScaledWidth(), 30.0D, (new Color(255, 15, 15, mc.thePlayer.hurtTime * 20)).getRGB(), 0);
         RenderUtilC.c71699(0.0D, (double)(var3.getScaledHeight() - 30), (double)var3.getScaledWidth(), (double)var3.getScaledHeight(), 0, (new Color(255, 15, 15, mc.thePlayer.hurtTime * 20)).getRGB());
      }

      if (c96352.c1473().booleanValue()) {
         RenderUtilC.c65465(0.0D, 0.0D, 30.0D, (double)var3.getScaledHeight(), (new Color(255, 15, 15, mc.thePlayer.hurtTime * 20)).getRGB(), 0);
         RenderUtilC.c65465((double)(var3.getScaledWidth() - 30), 0.0D, (double)var3.getScaledWidth(), (double)var3.getScaledHeight(), 0, (new Color(255, 15, 15, mc.thePlayer.hurtTime * 20)).getRGB());
      }

   }

   @EventTarget
   public void c78334(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (c11513.c1473().booleanValue()) {
         byte var3 = 45;
         float var4 = (float)(6.283185307179586D / (double)var3);
         RenderUtilC.c61860();
         GL11.glDisable(2884);
         GL11.glDisable(2929);
         GL11.glDepthMask(false);
         GL11.glFrontFace(2304);
         Iterator var5 = this.c48466.entrySet().iterator();
         if (var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            long var7 = System.currentTimeMillis() - ((Long)var6.getValue()).longValue();
            float var9 = MathHelper.clamp_float((float)var7 / 550.0F, 0.0F, 1.0F);
            float var10 = (float)(((Vec3)var6.getKey()).xCoord - mc.getRenderManager().viewerPosX);
            float var11 = (float)(((Vec3)var6.getKey()).yCoord - mc.getRenderManager().viewerPosY);
            float var12 = (float)(((Vec3)var6.getKey()).zCoord - mc.getRenderManager().viewerPosZ);
            GL11.glBegin(6);
            GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glVertex3f(var10, var11, var12);
            int var13 = 0;
            if (var13 <= var3) {
               RenderUtilC.c29244(new Color(HUD.c79151(var13 * 2)), (1.0F - var9) * 255.0F);
               float var14 = MathHelper.sin(var4 * (float)var13) * var9;
               float var15 = -MathHelper.cos(var4 * (float)var13) * var9;
               GL11.glVertex3f(var10 + var14, var11, var12 + var15);
               ++var13;
            }

            GL11.glEnd();
            if (var9 == 1.0F) {
               var5.remove();
            }
         }

         GL11.glFrontFace(2305);
         GL11.glDepthMask(true);
         GL11.glEnable(2929);
         GL11.glEnable(2884);
         RenderUtilC.c67477();
      }

      if (c85807.c1473().booleanValue()) {
         Iterator var20 = this.c88945.iterator();
         if (var20.hasNext()) {
            c9902 var21 = (c9902)var20.next();
            double var22 = var21.c94023.c28806();
            double var23 = var22 - mc.getRenderManager().renderPosX;
            double var24 = var21.c94023.c79185();
            double var25 = var24 - mc.getRenderManager().renderPosY;
            double var27 = var21.c94023.c58984();
            double var28 = var27 - mc.getRenderManager().renderPosZ;
            GlStateManager.pushMatrix();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
            GlStateManager.translate((float)var23, (float)var25, (float)var28);
            GlStateManager.rotate(-mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
            float var17 = mc.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F;
            GlStateManager.rotate(mc.getRenderManager().playerViewX, var17, 0.0F, 0.0F);
            double var18 = 0.03D;
            GlStateManager.scale(-0.025D, -0.025D, 0.025D);
            GL11.glDepthMask(false);
            mc.fontRendererObj.drawStringWithShadow(var21.c86930, (float)(-(mc.fontRendererObj.getStringWidth(var21.c86930) / 2)), (float)(-(mc.fontRendererObj.FONT_HEIGHT - 1)), HUD.c64734.c41161().intValue());
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDepthMask(true);
            GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
            GlStateManager.disablePolygonOffset();
            GlStateManager.popMatrix();
         }
      }

   }

   @EventTarget
   public void c91823(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c85807.c1473().booleanValue()) {
         ArrayList var10000 = this.c88945;
         Camera var10001 = this;

         try {
            var10000.forEach(var10001::c16532);
         } catch (ConcurrentModificationException var4) {
            ;
         }
      }

   }

   @EventTarget
   public void c39065(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c11513.c1473().booleanValue()) {
         if (mc.thePlayer.onGround && !this.c67920) {
            this.c48466.put(mc.thePlayer.getPositionVector(), Long.valueOf(System.currentTimeMillis()));
            this.c67920 = true;
         }

         if (mc.thePlayer.motionY >= 0.01D || mc.thePlayer.fallDistance > 1.0F) {
            this.c67920 = false;
         }
      }

      if (c85807.c1473().booleanValue()) {
         EntityLivingBase var3 = KillAura.c19685;
         boolean var4 = false;
         if (var3 != null && var3.hurtTime > 9) {
            var4 = true;
            if (var4) {
               String var5 = "";
               var5 = ((String)c40412.c36545()).replace('&', '§');
               Position var6 = new Position(var3);
               var6.c67177(var3.getEntityBoundingBox().minY + (var3.getEntityBoundingBox().maxY - var3.getEntityBoundingBox().minY) / 2.0D);
               var6.c70759(var6.c28806() - 0.5D + (double)(new Random(System.currentTimeMillis())).nextInt(5) * 0.1D);
               var6.c65291(var6.c58984() - 0.5D + (double)(new Random(System.currentTimeMillis() + 1L)).nextInt(5) * 0.1D);
               this.c88945.add(new c9902(var6, var5));
               var4 = false;
            }
         }
      }

   }

   @EventTarget
   public void c47492(AttackEntityEvent var1) {
      Module[] var2 = Value.c27574();
      if (c11866.c1473().booleanValue() && !mc.thePlayer.isDead) {
         EntityLivingBase var3 = (EntityLivingBase)var1.c73001;
         if (!(var3 instanceof EntityLivingBase)) {
            return;
         }

         if (var3 != null && var3.hurtTime >= 9 && mc.thePlayer.getDistance(var3.posX, var3.posY, var3.posZ) < 10.0D) {
            if (mc.thePlayer.ticksExisted > 3) {
               String var4 = c64015.c54460();
               byte var5 = -1;
               switch(var4.hashCode()) {
               case 64280026:
                  if (!var4.equals("Blood")) {
                     break;
                  }

                  var5 = 0;
               case -1903846252:
                  if (!var4.equals("Criticals")) {
                     break;
                  }

                  var5 = 1;
               case 74103181:
                  if (var4.equals("Magic")) {
                     var5 = 2;
                  }
               }

               switch(var5) {
               case 0:
                  int var6 = 0;
                  if (var6 < c50222.c53968().intValue()) {
                     mc.theWorld.spawnParticle(EnumParticleTypes.BLOCK_CRACK, var3.posX, var3.posY + (double)var3.height - 0.75D, var3.posZ, 0.0D, 0.0D, 0.0D, new int[]{Block.getStateId(Blocks.redstone_block.getDefaultState())});
                     ++var6;
                  }

                  if (!c58084.c1473().booleanValue()) {
                     break;
                  }

                  mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("dig.stone"), (float)var3.posX, (float)var3.posY, (float)var3.posZ));
               case 1:
                  int var9 = 0;
                  if (var9 < c50222.c53968().intValue()) {
                     mc.effectRenderer.emitParticleAtEntity(var3, EnumParticleTypes.CRIT);
                     ++var9;
                  }
               case 2:
                  int var11 = 0;
                  if (var11 < c50222.c53968().intValue()) {
                     mc.effectRenderer.emitParticleAtEntity(var3, EnumParticleTypes.CRIT_MAGIC);
                     ++var11;
                  }
               }
            }

            var3 = null;
         }
      }

   }

   public final Float c45000() {
      return this.c48796;
   }

   public final void c28344(Float var1) {
      this.c48796 = var1;
   }

   public final Float c8703() {
      return this.c73331;
   }

   public final void c33021(Float var1) {
      this.c73331 = var1;
   }

   @EventTarget
   public final void c55634(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (Objects.equals(c94474.c54460(), "Astolfo2")) {
         EntityPlayerSP var3 = mc.thePlayer;
         this.c48796 = null;
         this.c73331 = null;
      }
   }

   private void c16532(c9902 var1) {
      Value.c27574();
      ++var1.c65360;
      if (var1.c65360 <= 10) {
         var1.c94023.c67177(var1.c94023.c79185() + (double)var1.c65360 * 0.005D);
      }

      if (var1.c65360 > 20) {
         this.c88945.remove(var1);
      }

   }

   public String c75596(String var1) {
      return this.c23535.matcher(var1).replaceAll("");
   }

   public void c68564(String var1, float var2, float var3, int var4) {
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 + 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 - 0.5F, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 + 0.5F, 0, false);
      mc.fontRendererObj.drawString(var1, var2, var3, var4, false);
   }

   public static double c38782(double var0, int var2) {
      throw new IllegalArgumentException();
   }

   private static RuntimeException c92174(RuntimeException var0) {
      return var0;
   }
}
