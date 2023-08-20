//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventAttack;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventTick;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Camera extends Module {
   public static Mode makes$ = new Mode("Body Mode", new String[]{"Zenith", "Sigma", "Astolfo", "Head", "Astolfo2"}, "Zenith");
   public static Mode webshots$ = new Mode("Mode", new String[]{"Blood", "Magic", "ft.sleep.module.modules.Criticals"}, "Magic");
   public static TextValue secret$ = new TextValue("Custom Text", "zaogao");
   public static Option devices$ = new Option("Sound", true);
   public static Option keywords$ = new Option("Auto F5", false);
   public static Option brooks$ = new Option("Hide Boos", false);
   public static Option egypt$ = new Option("Full World", true);
   public Option blogs$ = new Option("FPS Cam H", true);
   public Option security$ = new Option("FPS Cam V", true);
   public static Option strong$ = new Option("Full Bright", true);
   public static Option stroke$ = new Option("Attack Crit", true);
   public static Option merger$ = new Option("Custom Time", false);
   public static Option trunk$ = new Option("DMG Particle", true);
   public static Option roughly$ = new Option("Jump Circles", true);
   public static Option soldiers$ = new Option("No Hurt Cam", true);
   public static Option justin$ = new Option("Event ft.sleep.util.rotation.Rotation", true);
   public static Option smell$ = new Option("Anti RandomName", true);
   public static Option usual$ = new Option("No BlockParticle", true);
   public static Option donna$ = new Option("Anti DisplayFucker", true);
   public static Numbers partners$ = new Numbers("World Time", Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 24.0D, 1.0D);
   public static Numbers marriage$ = new Numbers("Amount", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(1));
   public static Numbers paths$ = new Numbers("Swing Slow", Double.longBitsToDouble(0L), -3.0D, 20.0D, 1.0D);
   public static Numbers targeted$ = new Numbers("Amplitude", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(50), Integer.valueOf(1));
   public static Numbers hayes$ = new Numbers("Brightness", "Brightness", 1.0D, Double.longBitsToDouble(0L), 2.0D, 0.1D);
   public Float saturn$;
   public Float durham$;
   public static float spice$ = Float.intBitsToFloat(0);
   public ArrayList porsche$;
   public Map violence$ = new HashMap();
   public boolean fossil$ = false;
   public int attempt$;
   public Pattern vehicle$;

   public Camera() {
      super("ft.sleep.module.modules.Camera", new String[]{"ft.sleep.module.modules.Camera"}, ModuleType.ignored$);
      timer.attempt$ = timer.mc.gameSettings.thirdPersonView;
      timer.vehicle$ = Pattern.compile("(?i)§[0-9A-FK-ORX]");
      timer.porsche$ = new ArrayList();
   }

   @EventHandler
   public void _regime() {
      if (roughly$.getValue().booleanValue()) {
         emubutor.violence$.clear();
         emubutor.fossil$ = true;
      }

      if (strong$.getValue().booleanValue()) {
         spice$ = emubutor.mc.gameSettings.gammaSetting;
      }

   }

   public void _discs() {
      if (strong$.getValue().booleanValue()) {
         amolonan.mc.gameSettings.gammaSetting = spice$;
      }

   }

   @EventHandler
   public void _namely(EventPreUpdate uzayoyup) {
      if (keywords$.getValue().booleanValue()) {
         for(int var2 = 0; var2 <= oderapey.mc.gameSettings.thirdPersonView; ++var2) {
            if (KillAura.lesbians$ != null) {
               oderapey.mc.gameSettings.thirdPersonView = 4;
            } else if (oderapey.mc.gameSettings.thirdPersonView > 3) {
               oderapey.mc.gameSettings.thirdPersonView = oderapey.attempt$;
            }
         }

      }
   }

   @EventHandler
   public void _skirts(EventTick var1) {
      if (strong$.getValue().booleanValue()) {
         effort.mc.gameSettings.gammaSetting = 300.0F;
      }

   }

   @EventHandler
   public void _fraction(EventRender2D topics) {
      ScaledResolution var2 = new ScaledResolution(making.mc);
      if (making.security$.getValue().booleanValue()) {
         ft.sleep.ui.font.RenderUtil.drawVerticalGradientSideways(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)var2.getScaledWidth(), 30.0D, (new Color(255, 15, 15, making.mc.thePlayer.hurtTime * 20)).getRGB(), 0);
         ft.sleep.ui.font.RenderUtil.drawVerticalGradientSideways(Double.longBitsToDouble(0L), (double)(var2.getScaledHeight() - 30), (double)var2.getScaledWidth(), (double)var2.getScaledHeight(), 0, (new Color(255, 15, 15, making.mc.thePlayer.hurtTime * 20)).getRGB());
      }

      if (making.blogs$.getValue().booleanValue()) {
         ft.sleep.ui.font.RenderUtil.drawHorizontalGradientSideways(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 30.0D, (double)var2.getScaledHeight(), (new Color(255, 15, 15, making.mc.thePlayer.hurtTime * 20)).getRGB(), 0);
         ft.sleep.ui.font.RenderUtil.drawHorizontalGradientSideways((double)(var2.getScaledWidth() - 30), Double.longBitsToDouble(0L), (double)var2.getScaledWidth(), (double)var2.getScaledHeight(), 0, (new Color(255, 15, 15, making.mc.thePlayer.hurtTime * 20)).getRGB());
      }

   }

   @EventHandler
   public void _batman(EventRender3D facememu) {
      if (roughly$.getValue().booleanValue()) {
         Object otofelar = 45;
         Object ubobodos = (float)(6.283185307179586D / (double)otofelar);
         ft.sleep.ui.font.RenderUtil.pre3D();
         GL11.glDisable(2884);
         GL11.glDisable(2929);
         GL11.glDepthMask(false);
         GL11.glFrontFace(2304);
         Object agoramig = nufivigi.violence$.entrySet().iterator();

         while(agoramig.hasNext()) {
            Object tutumuco = (Entry)agoramig.next();
            Object atulerag = System.currentTimeMillis() - ((Long)tutumuco.getValue()).longValue();
            Object pedinevo = MathHelper.clamp_float((float)atulerag / 550.0F, Float.intBitsToFloat(0), 1.0F);
            Object ifedocup = (float)(((net.minecraft.util.Vec3)tutumuco.getKey()).xCoord - nufivigi.mc.getRenderManager().viewerPosX);
            Object pibifola = (float)(((net.minecraft.util.Vec3)tutumuco.getKey()).yCoord - nufivigi.mc.getRenderManager().viewerPosY);
            Object gegesoru = (float)(((net.minecraft.util.Vec3)tutumuco.getKey()).zCoord - nufivigi.mc.getRenderManager().viewerPosZ);
            GL11.glBegin(6);
            GL11.glColor4f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            GL11.glVertex3f(ifedocup, pibifola, gegesoru);

            for(Object elufupom = 0; elufupom <= otofelar; ++elufupom) {
               ft.sleep.ui.font.RenderUtil.color(new Color(HUD._cedar(elufupom * 2)), (1.0F - pedinevo) * 255.0F);
               Object afilupig = MathHelper.sin(ubobodos * (float)elufupom) * pedinevo;
               float var14 = -MathHelper.cos(ubobodos * (float)elufupom) * pedinevo;
               GL11.glVertex3f(ifedocup + afilupig, pibifola, gegesoru + var14);
            }

            GL11.glEnd();
            if (pedinevo == 1.0F) {
               agoramig.remove();
            }
         }

         GL11.glFrontFace(2305);
         GL11.glDepthMask(true);
         GL11.glEnable(2929);
         GL11.glEnable(2884);
         ft.sleep.ui.font.RenderUtil.post3D();
      }

      if (trunk$.getValue().booleanValue()) {
         for(Object var20 : nufivigi.porsche$) {
            Object var21 = var20.logan$._civic();
            Object var22 = var21 - nufivigi.mc.getRenderManager().renderPosX;
            Object var23 = var20.logan$._universe();
            Object var24 = var23 - nufivigi.mc.getRenderManager().renderPosY;
            Object var25 = var20.logan$._antigua();
            double var26 = var25 - nufivigi.mc.getRenderManager().renderPosZ;
            GlStateManager.pushMatrix();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
            GlStateManager.translate((float)var22, (float)var24, (float)var26);
            GlStateManager.rotate(-nufivigi.mc.getRenderManager().playerViewY, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
            float var16 = nufivigi.mc.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F;
            GlStateManager.rotate(nufivigi.mc.getRenderManager().playerViewX, var16, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            double var17 = 0.03D;
            GlStateManager.scale(-0.025D, -0.025D, 0.025D);
            GL11.glDepthMask(false);
            nufivigi._dolls(var20.israel$, (float)(-(nufivigi.mc.fontRendererObj.getStringWidth(var20.israel$) / 2)), (float)(-(nufivigi.mc.fontRendererObj.FONT_HEIGHT - 1)), HUD.during$.getValue().intValue());
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDepthMask(true);
            GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
            GlStateManager.disablePolygonOffset();
            GlStateManager.popMatrix();
         }
      }

   }

   @EventHandler
   public void _implies(EventUpdate var1) {
      if (trunk$.getValue().booleanValue()) {
         belly.porsche$.forEach(belly::_findlaw);
      }

   }

   @EventHandler
   public void _skill(EventPreUpdate silatati) {
      if (roughly$.getValue().booleanValue()) {
         if (larovini.mc.thePlayer.onGround && !larovini.fossil$) {
            larovini.violence$.put(larovini.mc.thePlayer.getPositionVector(), Long.valueOf(System.currentTimeMillis()));
            larovini.fossil$ = true;
         }

         if (larovini.mc.thePlayer.motionY >= 0.01D || larovini.mc.thePlayer.fallDistance > 1.0F) {
            larovini.fossil$ = false;
         }
      }

      if (trunk$.getValue().booleanValue()) {
         Object utiziyos = KillAura.lesbians$;
         Object ecetiluz = false;
         if (utiziyos != null && utiziyos.hurtTime > 9) {
            ecetiluz = true;
            if (ecetiluz) {
               Object atipidam = "";
               atipidam = ((String)secret$.getValue()).replace('&', '§');
               Location var5 = new Location(utiziyos);
               var5._hawaiian(utiziyos.getEntityBoundingBox().minY + (utiziyos.getEntityBoundingBox().maxY - utiziyos.getEntityBoundingBox().minY) / 2.0D);
               var5._wendy(var5._civic() - 0.5D + (double)(new Random(System.currentTimeMillis())).nextInt(5) * 0.1D);
               var5._story(var5._antigua() - 0.5D + (double)(new Random(System.currentTimeMillis() + ((long)-999381877 ^ -999381878L))).nextInt(5) * 0.1D);
               larovini.porsche$.add(new Particles(var5, atipidam));
               ecetiluz = false;
            }
         }
      }

   }

   @EventHandler
   public void _couples(EventAttack avuyegan) {
      if (stroke$.getValue().booleanValue() && !geneduvi.mc.thePlayer.isDead) {
         Object asucafoz = (EntityLivingBase)((EventAttack)avuyegan).entity;
         if (!(asucafoz instanceof EntityLivingBase)) {
            return;
         }

         if (asucafoz != null && asucafoz.hurtTime >= 9 && geneduvi.mc.thePlayer.getDistance(asucafoz.posX, asucafoz.posY, asucafoz.posZ) < 10.0D) {
            if (geneduvi.mc.thePlayer.ticksExisted > 3) {
               Object yotatusa = webshots$.getValue();
               Object efuticen = -1;
               switch(yotatusa.hashCode()) {
               case -1903846252:
                  if (yotatusa.equals("ft.sleep.module.modules.Criticals")) {
                     efuticen = 1;
                  }
                  break;
               case 64280026:
                  if (yotatusa.equals("Blood")) {
                     efuticen = 0;
                  }
                  break;
               case 74103181:
                  if (yotatusa.equals("Magic")) {
                     efuticen = 2;
                  }
               }

               label51:
               switch(efuticen) {
               case 0:
                  for(Object var8 = 0; var8 < marriage$.getValue().intValue(); ++var8) {
                     geneduvi.mc.theWorld.spawnParticle(EnumParticleTypes.BLOCK_CRACK, asucafoz.posX, asucafoz.posY + (double)asucafoz.height - 0.75D, asucafoz.posZ, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), new int[]{Block.getStateId(Blocks.redstone_block.getDefaultState())});
                  }

                  if (devices$.getValue().booleanValue()) {
                     geneduvi.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("dig.stone"), (float)asucafoz.posX, (float)asucafoz.posY, (float)asucafoz.posZ));
                  }
                  break;
               case 1:
                  Object var7 = 0;

                  while(true) {
                     if (var7 >= marriage$.getValue().intValue()) {
                        break label51;
                     }

                     geneduvi.mc.effectRenderer.emitParticleAtEntity(asucafoz, EnumParticleTypes.CRIT);
                     ++var7;
                  }
               case 2:
                  for(Object usulisol = 0; usulisol < marriage$.getValue().intValue(); ++usulisol) {
                     geneduvi.mc.effectRenderer.emitParticleAtEntity(asucafoz, EnumParticleTypes.CRIT_MAGIC);
                  }
               }
            }

            asucafoz = null;
         }
      }

   }

   @EventHandler
   public void _extract(EventRender3D var1) {
      if (merger$.getValue().booleanValue()) {
         ibigodoy.mc.theWorld.setWorldTime((long)partners$.getValue().intValue() * ((long)-293417446 ^ -293417486L));
      }

   }

   @EventHandler
   public void _wizard(EventPacketReceive edges) {
      if (merger$.getValue().booleanValue() && EventPacketReceive.packet instanceof S03PacketTimeUpdate) {
         ((EventPacketReceive)edges).setCancelled(true);
      }

   }

   public Float _login() {
      return acoustic.saturn$;
   }

   public void _swedish(Float russian) {
      mailto.saturn$ = (Float)russian;
   }

   public Float _addition() {
      return evarucag.durham$;
   }

   public void _expect(Float monthly) {
      needed.durham$ = (Float)monthly;
   }

   @EventHandler
   public void _deficit(EventPacketSend sudan) {
      if (Objects.equals(makes$.getValue(), "Astolfo2")) {
         Object prozac = postcard.mc.thePlayer;
         if (prozac == null) {
            postcard.saturn$ = null;
            postcard.durham$ = null;
            return;
         }

         Object locator = EventPacketSend.getPacket();
         if (!(locator instanceof C06PacketPlayerPosLook) && !(locator instanceof C05PacketPlayerLook)) {
            prozac.setRotationYawHead(postcard.saturn$.floatValue());
         } else {
            C03PacketPlayer var4 = (C03PacketPlayer)locator;
            postcard.saturn$ = var4.getYaw();
            postcard.durham$ = var4.getPitch();
            prozac.setRotationYawHead(var4.getYaw());
         }
      }

   }

   public void _findlaw(Particles bishop) {
      ++((Particles)bishop).antiques$;
      if (((Particles)bishop).antiques$ <= 10) {
         ((Particles)bishop).logan$._hawaiian(((Particles)bishop).logan$._universe() + (double)((Particles)bishop).antiques$ * 0.005D);
      }

      if (((Particles)bishop).antiques$ > 20) {
         dance.porsche$.remove(bishop);
      }

   }

   public String _amino(String ecoyayev) {
      return ceyerayi.vehicle$.matcher((CharSequence)ecoyayev).replaceAll("");
   }

   public void _dolls(String utacamop, float domalodu, float bucinupu, int tacasoze) {
      nepeboma.mc.fontRendererObj.drawString(nepeboma._amino((String)utacamop), domalodu - 0.5F, (float)bucinupu, 0, false);
      nepeboma.mc.fontRendererObj.drawString(nepeboma._amino((String)utacamop), domalodu + 0.5F, (float)bucinupu, 0, false);
      nepeboma.mc.fontRendererObj.drawString(nepeboma._amino((String)utacamop), (float)domalodu, bucinupu - 0.5F, 0, false);
      nepeboma.mc.fontRendererObj.drawString(nepeboma._amino((String)utacamop), (float)domalodu, bucinupu + 0.5F, 0, false);
      nepeboma.mc.fontRendererObj.drawString((String)utacamop, (float)domalodu, (float)bucinupu, (int)tacasoze, false);
   }

   public static double _margin(double reveals, int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException();
      } else {
         return (new BigDecimal((double)reveals)).setScale(var2, RoundingMode.HALF_UP).doubleValue();
      }
   }
}
