//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IEntityPlayer;
import ft.sleep.injection.interfaces.IRenderManager;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.PlayerUtils;
import ft.sleep.util.render.RenderUtil5;
import ft.sleep.util.render.RenderUtils;
import ft.sleep.util.rotation.RotationUtil;
import ft.sleep.util.rotation.RotationUtils6;
import ft.sleep.util.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class KillAura extends Module {
   public static EntityLivingBase lesbians$;
   public static EntityLivingBase arabic$;
   public static EntityLivingBase sentence$;
   public static boolean humanity$ = false;
   public static float minor$;
   public static float telling$;
   public static float female$ = Float.intBitsToFloat(0);
   public TimeHelper lodging$ = new TimeHelper();
   public NewTimer hilton$ = new NewTimer();
   public TimeHelper mentor$ = new TimeHelper();
   public TimeHelper perth$ = new TimeHelper();
   public ArrayList briefs$ = new ArrayList();
   public int compete$;
   public long dentists$;
   public long returned$;
   public long justice$;
   public boolean egyptian$;
   public double copper$;
   public boolean stories$ = false;
   public float famous$;
   public float lasting$;
   public float diana$;
   public float singh$;
   public Random choir$ = new Random();
   public Mode tuition$ = new Mode("Mode", new String[]{"Switch", "Single"}, "Switch");
   public Mode versions$ = new Mode("Priority", new String[]{"Fov", "Range", "Angle", "Armor", "Health", "HurtTime"}, "Fov");
   public Mode sequence$ = new Mode("ESP Mode", new String[]{"None", "Vape", "Box", "Jello", "Normal"}, "None");
   public static Mode gender$ = new Mode("Rotate Mode", new String[]{"Smart", "Zenith", "None"}, "Zenith");
   public static Numbers informed$ = new Numbers("Fov", "Fov", 180.0D, 10.0D, 360.0D, 10.0D);
   public static Numbers formula$ = new Numbers("Range", "Range", 4.2D, 1.0D, 20.0D, 0.05D);
   public static Numbers nathan$ = new Numbers("Max APS", "Max APS", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(1));
   public static Numbers analyze$ = new Numbers("Min APS", "Min APS", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(1));
   public static Numbers spirit$ = new Numbers("Eye Height", "Eye Height", 1.2D, Integer.valueOf(0), 1.5D, 0.1D);
   public static Numbers cattle$ = new Numbers("Wall Range", "Wall Range", 4.2D, 1.0D, 5.0D, 0.05D);
   public static Numbers struck$ = new Numbers("Swing Fov", "Swing Fov", 180.0D, 10.0D, 360.0D, 10.0D);
   public static Numbers clips$ = new Numbers("Swing Range", "Swing Range", 5.0D, 1.0D, 15.0D, 0.05D);
   public static Numbers wedding$ = new Numbers("Max ft.sleep.module.modules.Target", "Max ft.sleep.module.modules.Target", 1.0D, 1.0D, 50.0D, 1.0D);
   public static Numbers discrete$ = new Numbers("Switch Delay", "Switch Delay", 15.0D, Double.longBitsToDouble(0L), 20.0D, 0.5D);
   public static Numbers scanned$ = new Numbers("Hit Expand", "Hit Expand", 0.4D, Double.longBitsToDouble(0L), 2.0D, 0.05D);
   public static Numbers tomorrow$ = new Numbers("Yaw ft.sleep.module.modules.Speed", "Yaw ft.sleep.module.modules.Speed", 180.0D, Double.longBitsToDouble(0L), 360.0D, 1.0D);
   public static Numbers extended$ = new Numbers("Yaw randomize", "Yaw randomize", 6.0D, Double.longBitsToDouble(0L), 25.0D, 1.0D);
   public ft.sleep.api.value.MultiOptionValue anyway$ = new ft.sleep.api.value.MultiOptionValue("ft.sleep.module.modules.Target", new Option[]{new Option("Player", true), new Option("Animal", false), new Option("Monster", false), new Option("Neutral", false), new Option("Prefer", false), new Option("Invisible", false)});
   public ft.sleep.api.value.MultiOptionValue pilot$ = new ft.sleep.api.value.MultiOptionValue("Blatant", new Option[]{new Option("Multi", false), new Option("RayCast", false), new Option("SmoothAim", false), new Option("onlySword", false), new Option("BlockEnd", false), new Option("ReuseMouse", false), new Option("AutoBlock", false), new Option("ThroughWall", false)});
   public static Option design$ = new Option("Lock View", "Lock View", true);
   public static Option latvia$ = new Option("Death", "Death", true);
   public static Option sellers$ = new Option("New Suffix", "New Suffix", true);
   public static Option invest$ = new Option("Both Attack", "Both Attack", false);
   public static Option florence$ = new Option("Auto ft.sleep.module.modules.Target", "Auto ft.sleep.module.modules.Target", false);
   public static Option vendors$ = new Option("ESP Rainbow", "ESP Rainbow", true);

   public KillAura() {
      super("Kill Aura", new String[]{"ka", "aura", "killa"}, ModuleType.updates$);
      purple._piece((new Color(226, 54, 30)).getRGB());
   }

   public void _regime() {
      super._regime();
      leisure.briefs$.clear();
      lesbians$ = null;
      sentence$ = null;
      leisure.diana$ = leisure.famous$ = leisure.mc.thePlayer.rotationYaw;
      leisure.singh$ = leisure.lasting$ = leisure.mc.thePlayer.rotationPitch;
      if (leisure.mc.thePlayer != null) {
         if (Objects.equals(gender$.getValue(), "Zenith")) {
            minor$ = leisure.mc.thePlayer.rotationYaw;
            telling$ = leisure.mc.thePlayer.rotationPitch;
         }
      } else {
         minor$ = Float.intBitsToFloat(0);
         telling$ = Float.intBitsToFloat(0);
      }

      leisure.stories$ = false;
      leisure.dentists$ = (long)220768550 ^ 220768550L;
      leisure.compete$ = 0;
      leisure.lodging$._silent();
      leisure.perth$._silent();
      leisure.mentor$._silent();
      leisure.hilton$._painted();
   }

   public void _discs() {
      super._discs();
      uyecepoz.diana$ = uyecepoz.famous$ = uyecepoz.mc.thePlayer.rotationYaw;
      uyecepoz.singh$ = uyecepoz.lasting$ = uyecepoz.mc.thePlayer.rotationPitch;
      uyecepoz.briefs$.clear();
      lesbians$ = null;
      sentence$ = null;
      humanity$ = false;
      if (uyecepoz.pilot$.getSetting("AutoBlock").getValue().booleanValue()) {
         uyecepoz._argue(true);
      }

   }

   @EventHandler
   public void _wages(EventPreUpdate etaparer) {
      if ((!yabudeyu.pilot$.getSetting("onlySword").getValue().booleanValue() || yabudeyu._morrison(yabudeyu.mc.thePlayer)) && (!yabudeyu.pilot$.getSetting("ReuseMouse").getValue().booleanValue() || Mouse.isButtonDown(0))) {
         Client.î ?();
         Client.î ?();
         if (ModuleManager._herbs(Scaffold.class)._central()) {
            return;
         }

         sentence$ = null;

         for(Object nabipogo : yabudeyu.mc.theWorld.getLoadedEntityList()) {
            if (nabipogo instanceof EntityLivingBase) {
               EntityLivingBase var4 = (EntityLivingBase)nabipogo;
               if (yabudeyu._cookbook(var4)) {
                  sentence$ = var4;
                  break;
               }
            }
         }

         if (florence$.getValue().booleanValue()) {
            for(Object var9 : yabudeyu.briefs$) {
               if (var9 instanceof EntityPlayer && PlayerManager._pension(var9) && ((double)yabudeyu.mc.thePlayer.getDistanceToEntity(var9) >= (double)formula$.getValue().floatValue() || var9.isDead) && !Teams._issued(var9)) {
                  Client.surround$.î ?().targetConfig.removeTarget(var9.getName());
               }
            }
         }

         lesbians$ = null;
         yabudeyu.briefs$.clear();

         for(Object var10 : yabudeyu.mc.theWorld.getLoadedEntityList()) {
            if (var10 instanceof EntityLivingBase) {
               EntityLivingBase var13 = (EntityLivingBase)var10;
               if (yabudeyu._accident(var13)) {
                  if (PlayerManager._pension(var10)) {
                     yabudeyu.briefs$.clear();
                     yabudeyu.briefs$.add(var13);
                  }

                  sentence$ = null;
                  yabudeyu.briefs$.add(var13);
                  if (Objects.equals(yabudeyu.versions$.getValue(), "Armor")) {
                     yabudeyu.briefs$.sort(Comparator.comparingInt(KillAura::_attempts));
                  } else if (Objects.equals(yabudeyu.versions$.getValue(), "Range")) {
                     yabudeyu.briefs$.sort(yabudeyu::_coupon);
                  } else if (Objects.equals(yabudeyu.versions$.getValue(), "Fov")) {
                     yabudeyu.briefs$.sort(Comparator.comparingDouble(yabudeyu::_mardi));
                  } else if (Objects.equals(yabudeyu.versions$.getValue(), "HurtTime")) {
                     yabudeyu.briefs$.sort(Comparator.comparingInt(KillAura::_sharon));
                  } else if (Objects.equals(yabudeyu.versions$.getValue(), "Angle")) {
                     yabudeyu.briefs$.sort(yabudeyu::_sight);
                  } else if (Objects.equals(yabudeyu.versions$.getValue(), "Health")) {
                     yabudeyu.briefs$.sort(KillAura::_homework);
                  }
               }
            }
         }

         if (yabudeyu.anyway$.getSetting("Prefer").getValue().booleanValue()) {
            for(Object var11 : yabudeyu.briefs$) {
               if (var11 instanceof EntityWither) {
                  yabudeyu.briefs$.clear();
                  yabudeyu.briefs$.add(var11);
                  break;
               }
            }
         }

         if (florence$.getValue().booleanValue()) {
            for(Object var12 : yabudeyu.briefs$) {
               if (var12 instanceof EntityPlayer && yabudeyu._accident(var12) && !PlayerManager._pension(var12) && var12.getHealth() < 13.0F && !Teams._issued(var12)) {
                  Client.surround$.î ?().targetConfig.addTarget(var12.getName());
                  PlayerUtils._snake("Add Low ft.sleep.module.modules.Target : " + var12.getName());
                  Client.surround$.î ?()._arabia().add(new Notification("Add Low target " + var12.getName()));
               }
            }
         }

         if (yabudeyu.lodging$._cornwall((long)discrete$.getValue().intValue() * ((long)-1068136635 ^ -1068136671L)) && yabudeyu.briefs$.size() > 1) {
            yabudeyu.lodging$._silent();
            ++yabudeyu.compete$;
         }

         if (!yabudeyu.briefs$.isEmpty() && yabudeyu.compete$ >= yabudeyu.briefs$.size()) {
            yabudeyu.compete$ = 0;
         }

         if (!yabudeyu.briefs$.isEmpty()) {
            lesbians$ = (EntityLivingBase)yabudeyu.briefs$.get(Objects.equals(yabudeyu.tuition$.getValue(), "Switch") ? yabudeyu.compete$ : 0);
         }

         if (yabudeyu.pilot$.getSetting("AutoBlock").getValue().booleanValue()) {
            if (lesbians$ != null) {
               if (!yabudeyu._morrison(yabudeyu.mc.thePlayer) && humanity$) {
                  yabudeyu._argue(true);
               }
            } else if (humanity$) {
               yabudeyu._argue(true);
            }
         }
      }

      if (yabudeyu.pilot$.getSetting("onlySword").getValue().booleanValue() && !yabudeyu._morrison(yabudeyu.mc.thePlayer)) {
         if (yabudeyu.pilot$.getSetting("AutoBlock").getValue().booleanValue() && humanity$) {
            yabudeyu._argue(true);
         }

         sentence$ = null;
         lesbians$ = null;
         yabudeyu.briefs$.clear();
         yabudeyu.stories$ = false;
      }

      if (yabudeyu.pilot$.getSetting("ReuseMouse").getValue().booleanValue() && !Mouse.isButtonDown(0)) {
         if (yabudeyu.pilot$.getSetting("AutoBlock").getValue().booleanValue() && humanity$) {
            yabudeyu._argue(true);
         }

         sentence$ = null;
         lesbians$ = null;
         yabudeyu.briefs$.clear();
         yabudeyu.stories$ = false;
      }

   }

   public void _engaged() {
      Object pebacedo = 1000.0D;
      Object efosorun = MathUtil._austin(analyze$.getValue().doubleValue(), nathan$.getValue().doubleValue()) + 1.5D - Math.random() * 12.0D;
      if (efosorun < 1.0D) {
         efosorun = 1.0D;
      }

      if (Math.random() > 0.5D) {
         pebacedo = (1000.0D - Math.random() * 500.0D) / efosorun;
      } else {
         pebacedo = (1000.0D + Math.random() * 500.0D) / efosorun;
      }

      pebacedo = (pebacedo + MathUtil._austin(analyze$.getValue().doubleValue(), nathan$.getValue().doubleValue())) / 2.0D;
      if (!ofalerog.pilot$.getSetting("RayCast").getValue().booleanValue() || sentence$ != null || _baking(lesbians$, (double)formula$.getValue().floatValue())) {
         if (lesbians$ != null && ofalerog.hilton$._womens((long)pebacedo, false)) {
            if (ofalerog.pilot$.getSetting("Multi").getValue().booleanValue()) {
               Object afopupeg = 0;

               for(EntityLivingBase var7 : ofalerog.briefs$) {
                  if (ofalerog._accident(var7)) {
                     int var8 = wedding$.getValue().intValue();
                     if (ofalerog.pilot$.getSetting("Multi").getValue().booleanValue() && ofalerog.briefs$.size() > var8) {
                        ofalerog.briefs$.subList(var8, ofalerog.briefs$.size()).clear();
                     }

                     ofalerog.mc.thePlayer.swingItem();
                     PacketUtils._gratis(new C02PacketUseEntity(var7, Action.ATTACK));
                     ++afopupeg;
                  }
               }
            } else {
               ofalerog.mc.thePlayer.swingItem();
               ofalerog.mc.playerController.attackEntity(ofalerog.mc.thePlayer, lesbians$);
            }

            ofalerog.hilton$._painted();
         }

      }
   }

   @EventHandler
   public void _triumph(EventPreUpdate var1) {
      if ((!pepatata.pilot$.getSetting("BlockEnd").getValue().booleanValue() || !pepatata.mc.thePlayer.isBlocking()) && (!pepatata.pilot$.getSetting("onlySword").getValue().booleanValue() || pepatata._morrison(pepatata.mc.thePlayer)) && (!pepatata.pilot$.getSetting("ReuseMouse").getValue().booleanValue() || Mouse.isButtonDown(0))) {
         Client.î ?();
         Client.î ?();
         if (ModuleManager._herbs(Scaffold.class)._central()) {
            return;
         }

         pepatata._engaged();
      }

   }

   @EventHandler
   public void _budgets(EventPostUpdate elerigaz) {
      if ((!olazomil.pilot$.getSetting("BlockEnd").getValue().booleanValue() || !olazomil.mc.thePlayer.isBlocking()) && (!olazomil.pilot$.getSetting("onlySword").getValue().booleanValue() || olazomil._morrison(olazomil.mc.thePlayer)) && (!olazomil.pilot$.getSetting("ReuseMouse").getValue().booleanValue() || Mouse.isButtonDown(0))) {
         Object tocomele = 1000.0D;
         double var4 = MathUtil._austin(analyze$.getValue().doubleValue(), nathan$.getValue().doubleValue()) + 1.5D - Math.random() * 12.0D;
         if (var4 < 1.0D) {
            var4 = 1.0D;
         }

         if (Math.random() > 0.5D) {
            tocomele = (1000.0D - Math.random() * 500.0D) / var4;
         } else {
            tocomele = (1000.0D + Math.random() * 500.0D) / var4;
         }

         tocomele = (tocomele + MathUtil._austin(analyze$.getValue().doubleValue(), nathan$.getValue().doubleValue())) / 2.0D;
         Client.î ?();
         Client.î ?();
         if (ModuleManager._herbs(Scaffold.class)._central()) {
            return;
         }

         if (invest$.getValue().booleanValue()) {
            olazomil._engaged();
         }

         if (lesbians$ != null && olazomil.pilot$.getSetting("AutoBlock").getValue().booleanValue() && olazomil._morrison(olazomil.mc.thePlayer)) {
            ((IEntityPlayer)olazomil.mc.thePlayer).setItemInUseCount(olazomil.mc.thePlayer.getHeldItem().getMaxItemUseDuration());
            humanity$ = true;
         }

         if (!olazomil.pilot$.getSetting("AutoBlock").getValue().booleanValue() && sentence$ != null && olazomil.hilton$._womens((long)tocomele, false)) {
            olazomil.mc.thePlayer.swingItem();
            olazomil.hilton$._painted();
         }
      }

   }

   @EventHandler
   public void _brakes(EventPreUpdate nidivegi) {
      if ((!edosunaf.pilot$.getSetting("onlySword").getValue().booleanValue() || edosunaf._morrison(edosunaf.mc.thePlayer)) && (!edosunaf.pilot$.getSetting("ReuseMouse").getValue().booleanValue() || Mouse.isButtonDown(0))) {
         Client.î ?();
         Client.î ?();
         if (ModuleManager._herbs(Scaffold.class)._central()) {
            return;
         }

         if (lesbians$ != null && (edosunaf._airlines(edosunaf.mc.thePlayer) || !edosunaf._morrison(edosunaf.mc.thePlayer) && edosunaf.mc.playerController.getIsHittingBlock())) {
            return;
         }

         if (Objects.equals(gender$.getValue(), "None") && lesbians$ != null) {
            ;
         }

         if (Objects.equals(gender$.getValue(), "Custom")) {
            ;
         }

         if (Objects.equals(gender$.getValue(), "Smart") && lesbians$ != null && _count(lesbians$, 100.0F)) {
            if (edosunaf.perth$._cornwall((long)_tribes(150, 250))) {
               female$ = (float)_chronic((double)(-extended$.getValue().floatValue()), (double)extended$.getValue().floatValue());
               edosunaf.perth$._silent();
            }

            if (edosunaf.briefs$.isEmpty()) {
               lesbians$ = null;
               if (edosunaf.mentor$._ascii((long)1801645932 ^ 1801646074L) && !edosunaf.mentor$._ascii((long)-1107108879 ^ -1107109201L) && edosunaf.pilot$.getSetting("SmoothAim").getValue().booleanValue() && !ModuleManager._herbs(Scaffold.class)._central()) {
                  Object iderodef = new float[]{minor$, telling$};
                  Object yitulaba = new float[]{edosunaf.mc.thePlayer.rotationYaw, Math.max(Math.min(edosunaf.mc.thePlayer.rotationPitch, 90.0F), -90.0F)};
                  Object tifonali = edosunaf._drinking(yitulaba, iderodef);
                  minor$ = tifonali[0];
                  telling$ = Math.max(Math.min(tifonali[1], 90.0F), -90.0F);
               }
            }

            if (!edosunaf.briefs$.isEmpty() && lesbians$ != null) {
               edosunaf.mentor$._silent();
               Object zonubefa = edosunaf._census(lesbians$);
               Object var8 = MathHelper.wrapAngleTo180_float(zonubefa[0] + female$ - minor$);
               if (edosunaf.pilot$.getSetting("SmoothAim").getValue().booleanValue()) {
                  Object var11 = new float[]{minor$, telling$};
                  Object var14 = new float[]{minor$ + var8, Math.max(Math.min(zonubefa[1], 90.0F), -90.0F)};
                  Object vupifeno = edosunaf._drinking(var14, var11);
                  minor$ = vupifeno[0];
                  telling$ = Math.max(Math.min(vupifeno[1], 90.0F), -90.0F);
               } else {
                  minor$ = (float)((double)(minor$ + var8) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
                  telling$ = (float)Math.max(Math.min((double)zonubefa[1] + ThreadLocalRandom.current().nextGaussian(), 90.0D), -90.0D);
               }
            }

            if (!edosunaf.mentor$._cornwall((long)-875348247 ^ -875348041L)) {
               if (design$.getValue().booleanValue()) {
                  edosunaf.mc.thePlayer.rotationYaw = minor$;
                  edosunaf.mc.thePlayer.rotationPitch = telling$;
               } else {
                  ((EventPreUpdate)nidivegi).setYaw(minor$);
                  ((EventPreUpdate)nidivegi).setPitch(telling$);
               }
            } else {
               minor$ = edosunaf.mc.thePlayer.rotationYaw;
               telling$ = edosunaf.mc.thePlayer.rotationPitch;
            }
         }

         if (Objects.equals(gender$.getValue(), "Zenith")) {
            if (edosunaf.perth$._cornwall((long)_tribes(150, 250))) {
               female$ = (float)_chronic((double)(-extended$.getValue().floatValue()), (double)extended$.getValue().floatValue());
               edosunaf.perth$._silent();
            }

            if (edosunaf.briefs$.isEmpty()) {
               lesbians$ = null;
               if (edosunaf.mentor$._ascii((long)-1344706800 ^ -1344706682L) && !edosunaf.mentor$._ascii((long)637141973 ^ 637141643L) && edosunaf.pilot$.getSetting("SmoothAim").getValue().booleanValue() && !ModuleManager._herbs(Scaffold.class)._central()) {
                  Object var9 = new float[]{minor$, telling$};
                  Object var12 = new float[]{edosunaf.mc.thePlayer.rotationYaw, Math.max(Math.min(edosunaf.mc.thePlayer.rotationPitch, 90.0F), -90.0F)};
                  Object var15 = edosunaf._drinking(var12, var9);
                  minor$ = var15[0];
                  telling$ = Math.max(Math.min(var15[1], 90.0F), -90.0F);
               }
            }

            if (!edosunaf.briefs$.isEmpty() && lesbians$ != null) {
               edosunaf.mentor$._silent();
               Object var7 = edosunaf._census(lesbians$);
               Object var10 = MathHelper.wrapAngleTo180_float(var7[0] + female$ - minor$);
               if (edosunaf.pilot$.getSetting("SmoothAim").getValue().booleanValue()) {
                  Object var13 = new float[]{minor$, telling$};
                  Object var16 = new float[]{minor$ + var10, Math.max(Math.min(var7[1], 90.0F), -90.0F)};
                  Object var17 = edosunaf._drinking(var16, var13);
                  minor$ = var17[0];
                  telling$ = Math.max(Math.min(var17[1], 90.0F), -90.0F);
               } else {
                  minor$ = (float)((double)(minor$ + var10) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
                  telling$ = (float)Math.max(Math.min((double)var7[1] + ThreadLocalRandom.current().nextGaussian(), 90.0D), -90.0D);
               }
            }

            if (!edosunaf.mentor$._cornwall((long)-343635598 ^ -343635924L)) {
               if (design$.getValue().booleanValue()) {
                  edosunaf.mc.thePlayer.rotationYaw = minor$;
                  edosunaf.mc.thePlayer.rotationPitch = telling$;
               } else {
                  ((EventPreUpdate)nidivegi).setYaw(minor$);
                  ((EventPreUpdate)nidivegi).setPitch(telling$);
               }
            } else {
               minor$ = edosunaf.mc.thePlayer.rotationYaw;
               telling$ = edosunaf.mc.thePlayer.rotationPitch;
            }
         }
      }

   }

   @EventHandler
   public void _speaker(EventUpdate create) {
      if (analyze$.getValue().doubleValue() > nathan$.getValue().doubleValue()) {
         nathan$.setValue(Double.valueOf(analyze$.getValue().doubleValue()));
      }

      if (funding.mc.currentScreen == null && funding._morrison(funding.mc.thePlayer) && !funding.pilot$.getSetting("AutoBlock").getValue().booleanValue()) {
         Client.î ?();
         if (!ModuleManager._herbs(NoSlow.class)._central()) {
            Mouse.poll();
            if (Mouse.isButtonDown(1)) {
               KeyBinding.setKeyBindState(funding.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
               KeyBinding.onTick(funding.mc.gameSettings.keyBindUseItem.getKeyCode());
               MouseUtils._courts(new Object[]{Integer.valueOf(1), true});
            }
         }
      }

      if (lesbians$ != null && funding.mc.thePlayer.getHeldItem() != null && funding.mc.thePlayer.getHeldItem().getDisplayName().contains("Chest")) {
         funding._myanmar();
         Client.î ?().î ?()._arabia().add(new Notification("Check Chest AutoToggle ft.sleep.module.modules.KillAura", (long)-360612092 ^ -360614724L));
      }

      if (sellers$.getValue().booleanValue()) {
         funding._infants("Priority");
      } else {
         if (lesbians$ == null) {
            funding._infants("0 (0%)");
         }

         Object whose = 0;

         for(Object sticks = 0; sticks < 101; whose = sticks++) {
            ;
         }

         Object var9 = analyze$.getValue().intValue() > nathan$.getValue().intValue();
         if (analyze$.getValue() != nathan$.getValue() && nathan$.getValue() != analyze$.getValue()) {
            boolean var11 = false;
         } else {
            boolean var10000 = true;
         }

         Object staying = RandomUtil._april(analyze$.getValue().doubleValue(), nathan$.getValue().doubleValue());
         int var7 = 0;

         for(int var8 = 0; (double)var8 < staying; var7 = var8++) {
            ;
         }

         if (lesbians$ != null) {
            int var10 = lesbians$.hurtTime > 8 ? whose : _tribes(40, 90);
            if (funding.mc.thePlayer.ticksExisted % HUD.select$.getValue().intValue() == 0) {
               funding._infants(var7 + " [" + var10 + "%]");
            }
         }
      }

   }

   @EventHandler
   public void _logging(EventRender3D muyefuse) {
      if ((!efeyetad.pilot$.getSetting("onlySword").getValue().booleanValue() || efeyetad._morrison(efeyetad.mc.thePlayer)) && (!efeyetad.pilot$.getSetting("ReuseMouse").getValue().booleanValue() || Mouse.isButtonDown(0))) {
         if (lesbians$ != null && Objects.equals(efeyetad.sequence$.getValue(), "Normal")) {
            Object tutizifo = new Color(200, 255, 100, 75);
            if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue()) {
               for(Object umucuvob : efeyetad.briefs$) {
                  Object vimalefo = wedding$.getValue().intValue();
                  if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue() && efeyetad.briefs$.size() > vimalefo) {
                     efeyetad.briefs$.subList(vimalefo, efeyetad.briefs$.size()).clear();
                  }

                  RenderUtils._refuse(umucuvob, umucuvob.hurtTime > 3 ? tutizifo : new Color(235, 40, 40, 75));
               }
            } else {
               Object epidegas = lesbians$;
               RenderUtils._refuse(epidegas, epidegas.hurtTime > 3 ? tutizifo : new Color(235, 40, 40, 75));
            }
         }

         if (lesbians$ != null && Objects.equals(efeyetad.sequence$.getValue(), "Jello")) {
            if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue()) {
               for(Object var26 : efeyetad.briefs$) {
                  Object var31 = wedding$.getValue().intValue();
                  if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue() && efeyetad.briefs$.size() > var31) {
                     efeyetad.briefs$.subList(var31, efeyetad.briefs$.size()).clear();
                  }

                  efeyetad._enzyme(var26, 0.67D, (new Color(HUD.during$.getValue().intValue())).getRGB(), true);
               }
            } else {
               Object var20 = lesbians$;
               efeyetad._enzyme(var20, 0.67D, (new Color(HUD.during$.getValue().intValue())).getRGB(), true);
            }
         }

         if (lesbians$ != null && Objects.equals(efeyetad.sequence$.getValue(), "Box")) {
            Object var22 = new Color(200, 255, 100, 75);
            if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue()) {
               for(Object var32 : efeyetad.briefs$) {
                  Object var34 = wedding$.getValue().intValue();
                  if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue() && efeyetad.briefs$.size() > var34) {
                     efeyetad.briefs$.subList(var34, efeyetad.briefs$.size()).clear();
                  }

                  RenderUtils._adelaide(var32, var32.hurtTime >= 1 ? var22 : new Color(235, 40, 40, 75));
               }
            } else {
               Object var27 = lesbians$;
               RenderUtils._adelaide(var27, var27.hurtTime >= 1 ? var22 : new Color(235, 40, 40, 75));
            }
         }

         if (lesbians$ != null && Objects.equals(efeyetad.sequence$.getValue(), "Vape")) {
            if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue()) {
               for(Object var29 : efeyetad.briefs$) {
                  Object var33 = var29.lastTickPosX + (var29.posX - var29.lastTickPosX) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosX();
                  Object yopanizu = var29.lastTickPosY + (var29.posY - var29.lastTickPosY) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosY();
                  Object eruzodep = var29.lastTickPosZ + (var29.posZ - var29.lastTickPosZ) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosZ();
                  Object uboludab = var29.getEntityBoundingBox().maxX - var29.getEntityBoundingBox().minX - 0.2D;
                  Object ziyazeda = var29.getEntityBoundingBox().maxY - var29.getEntityBoundingBox().minY + 0.15D;
                  Object yizipuzi = 10.0F - (float)(var29.hurtTime * 5) / 255.0F;
                  Object yupuvede = (float)(var29.hurtTime * 10) / 255.0F;
                  Object alevesiv = (float)(var29.hurtTime * 2) / 255.0F;
                  Object susasayo = (float)(80 + var29.hurtTime * 10) / 350.0F;
                  Object perigeni = (float)(80 + var29.hurtTime * 10) / 500.0F;
                  int var19 = wedding$.getValue().intValue();
                  if (efeyetad.pilot$.getSetting("Multi").getValue().booleanValue() && efeyetad.briefs$.size() > var19) {
                     efeyetad.briefs$.subList(var19, efeyetad.briefs$.size()).clear();
                  }

                  if (var29.hurtTime >= 1) {
                     RenderUtil5._tourism(var33, yopanizu, eruzodep, uboludab, ziyazeda, yizipuzi, yupuvede, alevesiv, susasayo, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
                  } else {
                     RenderUtil5._tourism(var33, yopanizu, eruzodep, uboludab, ziyazeda, yizipuzi, yupuvede, alevesiv, perigeni, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
                  }
               }
            } else {
               Object var24 = lesbians$;
               Object var30 = var24.lastTickPosX + (var24.posX - var24.lastTickPosX) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosX();
               Object var35 = var24.lastTickPosY + (var24.posY - var24.lastTickPosY) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosY();
               Object dulayuma = var24.lastTickPosZ + (var24.posZ - var24.lastTickPosZ) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)efeyetad.mc.getRenderManager()).getRenderPosZ();
               Object bamituna = var24.getEntityBoundingBox().maxX - var24.getEntityBoundingBox().minX - 0.2D;
               Object lezasugi = var24.getEntityBoundingBox().maxY - var24.getEntityBoundingBox().minY + 0.15D;
               Object atufapiv = 10.0F - (float)(var24.hurtTime * 5) / 255.0F;
               Object var36 = (float)(var24.hurtTime * 10) / 255.0F;
               Object var37 = (float)(var24.hurtTime * 2) / 255.0F;
               Object var38 = (float)(80 + var24.hurtTime * 10) / 350.0F;
               Object var39 = (float)(80 + var24.hurtTime * 10) / 500.0F;
               if (var24.hurtTime >= 1) {
                  RenderUtil5._tourism(var30, var35, dulayuma, bamituna, lezasugi, atufapiv, var36, var37, var38, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
               } else {
                  RenderUtil5._tourism(var30, var35, dulayuma, bamituna, lezasugi, atufapiv, var36, var37, var39, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
               }
            }
         }
      }

   }

   @EventHandler
   public void _later(EventPreUpdate var1) {
      if (movoyilo.mc.thePlayer.ticksExisted <= 1 && latvia$.getValue().booleanValue()) {
         Client.î ?().î ?()._arabia().add(new Notification("Disabled aura due to death", (long)-1281441717 ^ -1281438733L));
         movoyilo._serial(false);
      }

   }

   public double _turned(Random classics) {
      return analyze$.getValue().doubleValue() == nathan$.getValue().doubleValue() ? analyze$.getValue().doubleValue() : analyze$.getValue().doubleValue() + ((Random)classics).nextDouble() * (nathan$.getValue().doubleValue() - analyze$.getValue().doubleValue());
   }

   public void _inter() {
      Object bopazevi = Math.round(1000.0D / ((double)analyze$.getValue().longValue() + (double)(nathan$.getValue().longValue() - analyze$.getValue().longValue()) * ayusecaf.choir$.nextDouble()));
      if (System.currentTimeMillis() > ayusecaf.justice$) {
         if (!ayusecaf.egyptian$ && ayusecaf.choir$.nextInt(100) >= 85) {
            ayusecaf.egyptian$ = true;
            ayusecaf.copper$ = 1.1D + ayusecaf.choir$.nextDouble() * 0.15D;
         } else {
            ayusecaf.egyptian$ = false;
         }

         ayusecaf.justice$ = System.currentTimeMillis() + ((long)-2088343 ^ -2088035L) + (long)ayusecaf.choir$.nextInt(1500);
      }

      if (ayusecaf.egyptian$) {
         bopazevi = (long)((double)bopazevi * ayusecaf.copper$);
      }

      if (System.currentTimeMillis() > ayusecaf.returned$) {
         if (ayusecaf.choir$.nextInt(100) >= 80) {
            bopazevi += ((long)-727747530 ^ -727747580L) + (long)ayusecaf.choir$.nextInt(100);
         }

         ayusecaf.returned$ = System.currentTimeMillis() + ((long)1882094661 ^ 1882095025L) + (long)ayusecaf.choir$.nextInt(1500);
      }

      ayusecaf.dentists$ = System.currentTimeMillis() + bopazevi;
   }

   public static boolean _count(Entity notutino, float omebiyas) {
      return (Math.abs(_reload((Entity)notutino)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(_reload((Entity)notutino)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F : Math.abs(_reload((Entity)notutino)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F) >= omebiyas;
   }

   public void _argue(boolean var1) {
      ((IEntityPlayer)iyisevev.mc.thePlayer).setItemInUseCount(0);
      humanity$ = false;
   }

   public float[] _census(EntityLivingBase cubalinu) {
      Object yamiyope = ((EntityLivingBase)cubalinu).posX;
      double var6 = ((EntityLivingBase)cubalinu).posZ;
      double ovivedan;
      if (cubalinu instanceof EntityEnderman) {
         ovivedan = ((EntityLivingBase)cubalinu).posY - butufudi.mc.thePlayer.posY;
      } else {
         double var8 = (double)butufudi.mc.thePlayer.getEyeHeight() - (1.65D + spirit$.getValue().doubleValue());
         ovivedan = ((EntityLivingBase)cubalinu).posY + (double)((EntityLivingBase)cubalinu).getEyeHeight() - 1.5D < butufudi.mc.thePlayer.posY + var8 ? ((EntityLivingBase)cubalinu).posY + (double)((EntityLivingBase)cubalinu).getEyeHeight() - butufudi.mc.thePlayer.posY + ((double)butufudi.mc.thePlayer.getEyeHeight() - 3.0D) : (((EntityLivingBase)cubalinu).posY - 1.5D > butufudi.mc.thePlayer.posY + var8 ? ((EntityLivingBase)cubalinu).posY - 3.0D - butufudi.mc.thePlayer.posY + (double)butufudi.mc.thePlayer.getEyeHeight() : var8);
      }

      return butufudi._trans(yamiyope, var6, ovivedan);
   }

   public float[] _trans(double sorted, double personal, double patents) {
      Object bradford = sorted - adams.mc.thePlayer.posX;
      double var9 = personal - adams.mc.thePlayer.posZ;
      double var11 = (double)MathHelper.sqrt_double(bradford * bradford + var9 * var9);
      float var13 = (float)(Math.atan2(var9, bradford) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(-(Math.atan2((double)patents, var11) * 180.0D / 3.141592653589793D));
      return new float[]{var13, var14};
   }

   public double _mardi(EntityLivingBase ebamegap) {
      Object ifusuboc = ((EntityLivingBase)ebamegap).getPositionVector().addVector(Double.longBitsToDouble(0L), (double)(((EntityLivingBase)ebamegap).getEyeHeight() / 2.0F), Double.longBitsToDouble(0L)).subtract(ifuzirop.mc.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double)ifuzirop.mc.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)));
      Object itabelar = Math.abs((double)ifuzirop.mc.thePlayer.rotationYaw - (Math.toDegrees(Math.atan2(ifusuboc.zCoord, ifusuboc.xCoord)) - 90.0D)) % 360.0D;
      return itabelar > 180.0D ? 360.0D - itabelar : itabelar;
   }

   public float[] _drinking(float[] ifebacoc, float[] sufezale) {
      Object bomepude = _grants(new float[]{(float)(((Object[])sufezale)[0] - ((Object[])ifebacoc)[0]), (float)(((Object[])sufezale)[1] - ((Object[])ifebacoc)[1])});
      Object amigavif = MathUtils._minus(tomorrow$.getValue().floatValue() - 20.0F, tomorrow$.getValue().floatValue() - 10.0F);
      Object omubilez = MathUtils._minus(tomorrow$.getValue().floatValue() - 10.0F, tomorrow$.getValue().floatValue());
      if (lesbians$ != null) {
         for(Object yayupefo : duratote._delay((float)((Object[])sufezale)[0], (float)((Object[])sufezale)[1])) {
            if (yayupefo.entityHit != null && yayupefo.entityHit != duratote.mc.thePlayer && duratote._accident((EntityLivingBase)yayupefo.entityHit)) {
               omubilez = (float)((double)omubilez * 0.3D);
               break;
            }
         }
      }

      bomepude[0] = ((Object[])sufezale)[0] - bomepude[0] / 180.0F * (amigavif / 2.0F);
      bomepude[1] = (float)((Object[])sufezale)[1];
      bomepude[0] = RotationUtil._retreat(bomepude[0], (float)((Object[])ifebacoc)[0], amigavif);
      bomepude[1] = RotationUtil._retreat(bomepude[1], Math.max(Math.min((float)((Object[])ifebacoc)[1], 90.0F), -90.0F), omubilez);
      return bomepude;
   }

   public static boolean _baking(Entity preview, double content) {
      return RaycastUtils._walking((double)content, KillAura::_disabled) != null;
   }

   public List _delay(float fetish, float finish) {
      Object expires = new ArrayList();
      Object copying = slovak.mc.getRenderViewEntity();
      if (copying != null && slovak.mc.theWorld != null) {
         Object surplus = lesbians$.getCollisionBorderSize();
         Object diverse = 1.0F;
         Object purchase = copying.getPositionEyes(1.0F);
         Object shell = RotationUtils6._centers((float)fetish, (float)finish);
         Object leone = purchase.addVector(shell.xCoord * (double)surplus, shell.yCoord * (double)surplus, shell.zCoord * (double)surplus);

         for(Object settle : slovak.mc.theWorld.getEntitiesInAABBexcluding(copying, copying.getEntityBoundingBox().addCoord(shell.xCoord * (double)surplus, shell.yCoord * (double)surplus, shell.zCoord * (double)surplus).expand((double)diverse, (double)diverse, (double)diverse), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith))) {
            Object phantom = settle.getCollisionBorderSize();
            Object beijing = settle.getEntityBoundingBox().expand((double)phantom, (double)phantom, (double)phantom);
            Object shaped = beijing.calculateIntercept(purchase, leone);
            if (shaped != null) {
               shaped.entityHit = settle;
               expires.add(new MovingObjectPosition(settle, shaped.hitVec));
            }
         }
      }

      if (copying != null) {
         expires.sort(KillAura::_drunk);
      }

      return expires;
   }

   public static float[] _grants(float[] esetofem) {
      ((Object[])esetofem)[0] %= 360.0F;

      for(((Object[])esetofem)[1] %= 360.0F; ((Object[])esetofem)[0] <= -180.0F; ((Object[])esetofem)[0] += 360.0F) {
         ;
      }

      while(((Object[])esetofem)[1] <= -180.0F) {
         ((Object[])esetofem)[1] += 360.0F;
      }

      while(((Object[])esetofem)[0] > 180.0F) {
         ((Object[])esetofem)[0] -= 360.0F;
      }

      while(((Object[])esetofem)[1] > 180.0F) {
         ((Object[])esetofem)[1] -= 360.0F;
      }

      return (float[])esetofem;
   }

   public boolean _possible(Entity cinema) {
      if (cinema instanceof EntityAnimal) {
         return dozens.anyway$.getSetting("Animal").getValue().booleanValue();
      } else if (cinema instanceof EntityMob) {
         return dozens.anyway$.getSetting("Monster").getValue().booleanValue();
      } else {
         return !(cinema instanceof EntityVillager) && !(cinema instanceof EntityIronGolem) && !(cinema instanceof EntitySnowman) ? true : dozens.anyway$.getSetting("Neutral").getValue().booleanValue();
      }
   }

   public static float[] _reload(Entity epepimib) {
      if (epepimib == null) {
         return null;
      } else {
         Object litagosu = ((Entity)epepimib).posX - Minecraft.getMinecraft().thePlayer.posX;
         Object ezesirap = ((Entity)epepimib).posZ - Minecraft.getMinecraft().thePlayer.posZ;
         double lepivuzo;
         if (epepimib instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)epepimib;
            lepivuzo = var7.posY + (double)var7.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         } else {
            lepivuzo = (((Entity)epepimib).getEntityBoundingBox().minY + ((Entity)epepimib).getEntityBoundingBox().maxY) / 2.0D - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(litagosu * litagosu + ezesirap * ezesirap);
         float var9 = (float)(Math.atan2(ezesirap, litagosu) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-(Math.atan2(lepivuzo, var11) * 180.0D / 3.141592653589793D));
         return new float[]{var9, var10};
      }
   }

   public void _enzyme(Entity upicomoc, double ufivunuc, int evufabut, boolean isafezoc) {
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glHint(3153, 4354);
      GL11.glDepthMask(false);
      GlStateManager.alphaFunc(516, Float.intBitsToFloat(0));
      if (isafezoc) {
         GL11.glShadeModel(7425);
      }

      GlStateManager.disableCull();
      GL11.glBegin(5);
      Object upazubiz = ((Entity)upicomoc).lastTickPosX + (((Entity)upicomoc).posX - ((Entity)upicomoc).lastTickPosX) * (double)eturudom.mc.timer.renderPartialTicks;
      eturudom.mc.getRenderManager();
      Object nasoyabu = upazubiz - ((IRenderManager)eturudom.mc.getRenderManager()).getRenderPosX();
      upazubiz = ((Entity)upicomoc).lastTickPosY + (((Entity)upicomoc).posY - ((Entity)upicomoc).lastTickPosY) * (double)eturudom.mc.timer.renderPartialTicks;
      eturudom.mc.getRenderManager();
      Object mocanavo = upazubiz - ((IRenderManager)eturudom.mc.getRenderManager()).getRenderPosY() + Math.sin((double)System.currentTimeMillis() / 200.0D) + 1.0D;
      upazubiz = ((Entity)upicomoc).lastTickPosZ + (((Entity)upicomoc).posZ - ((Entity)upicomoc).lastTickPosZ) * (double)eturudom.mc.timer.renderPartialTicks;
      eturudom.mc.getRenderManager();
      double var12 = upazubiz - ((IRenderManager)eturudom.mc.getRenderManager()).getRenderPosZ();

      for(float var14 = Float.intBitsToFloat(0); (double)var14 < 6.283185307179586D; var14 = (float)((double)var14 + 0.09817477042468103D)) {
         double var15 = nasoyabu + ufivunuc * Math.cos((double)var14);
         double var17 = var12 + ufivunuc * Math.sin((double)var14);
         Color var19 = new Color(HUD.during$.getValue().intValue());
         if (isafezoc) {
            GL11.glColor4f((float)var19.getRed() / 255.0F, (float)var19.getGreen() / 255.0F, (float)var19.getBlue() / 255.0F, Float.intBitsToFloat(0));
            GL11.glVertex3d(var15, mocanavo - Math.cos((double)System.currentTimeMillis() / 200.0D) / 2.0D, var17);
            GL11.glColor4f((float)var19.getRed() / 255.0F, (float)var19.getGreen() / 255.0F, (float)var19.getBlue() / 255.0F, 0.65F);
         }

         GL11.glVertex3d(var15, mocanavo, var17);
      }

      GL11.glEnd();
      if (isafezoc) {
         GL11.glShadeModel(7424);
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableCull();
      GL11.glDisable(2848);
      GL11.glDisable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
      GL11.glColor3f(255.0F, 255.0F, 255.0F);
   }

   public boolean _boston() {
      Object somerset = indie.mc.thePlayer.getHeldItem().getDisplayName();
      return somerset != null && somerset.matches(".*Sword.*");
   }

   public static double _tions(double rofenode, double var2) {
      return Math.random() * (1000.0D / rofenode - 1000.0D / var2 + 1.0D) + 1000.0D / var2;
   }

   public static float[] _burke(Entity align, float exchange, float payday, float division) {
      Object drain = Minecraft.getMinecraft().thePlayer;
      Object bound = ((Entity)align).posX - drain.posX;
      Object pleased = ((Entity)align).posZ - drain.posZ;
      Object cookbook = ((Entity)align).posY - drain.posY;
      double var13 = StrictMath.sqrt(bound * bound + pleased * pleased);
      AxisAlignedBB var15 = ((Entity)align).getEntityBoundingBox().expand(0.10000000149011612D, 0.10000000149011612D, 0.10000000149011612D);
      double var16 = drain.posY + (double)drain.getEyeHeight();
      boolean var18 = var13 < 3.0D && Math.abs(cookbook) < 3.0D;
      Object cooling = var13 < 1.0D && Math.abs(cookbook) < 1.0D;
      float floating;
      if (var18 && var16 > var15.minY) {
         floating = cooling && var16 > var15.minY ? 90.0F : 60.0F;
      } else {
         cookbook = var16 > var15.maxY ? var15.maxY - var16 : (var16 < var15.minY ? var15.minY - var16 : Double.longBitsToDouble(0L));
         floating = (float)(-(StrictMath.atan2(cookbook, var13) * 57.29577951308232D));
      }

      float var20 = (float)(StrictMath.atan2(pleased, bound) * 57.29577951308232D) - 90.0F;
      if (var18 && cooling) {
         int var21 = var13 < 1.0D ? 180 : 90;
         var20 = (float)(Math.round(var20 / (float)var21) * var21);
      }

      return new float[]{var20, floating};
   }

   public static float _words(float igusoday, float zosododu, float utogepen) {
      Object eboresur = MathHelper.wrapAngleTo180_float((float)(zosododu - igusoday));
      if (eboresur > utogepen) {
         eboresur = (float)utogepen;
      }

      if (eboresur < -utogepen) {
         eboresur = (float)(-utogepen);
      }

      return igusoday + eboresur;
   }

   public boolean _cookbook(EntityLivingBase leyepuye) {
      Object atudofur = iradopod.mc.thePlayer.posX - ((EntityLivingBase)leyepuye).posX;
      Object ozubarab = iradopod.mc.thePlayer.posZ - ((EntityLivingBase)leyepuye).posZ;
      boolean var6 = (double)MathHelper.sqrt_double(atudofur * atudofur + ozubarab * ozubarab) <= scanned$.getValue().doubleValue();
      Teams var7 = (Teams)ModuleManager._herbs(Teams.class);
      AntiBot var8 = (AntiBot)ModuleManager._herbs(AntiBot.class);
      if (!iradopod._results((Entity)leyepuye, struck$.getValue().floatValue()) && !var6) {
         return false;
      } else if (iradopod.mc.thePlayer.isEntityAlive() && !iradopod.mc.thePlayer.isPlayerSleeping() && !iradopod.mc.thePlayer.isDead && iradopod.mc.thePlayer.getHealth() > Float.intBitsToFloat(0) && !Teams._issued((EntityLivingBase)leyepuye) && (double)iradopod.mc.thePlayer.getDistanceToEntity((Entity)leyepuye) < (double)clips$.getValue().floatValue() && ((EntityLivingBase)leyepuye).isEntityAlive() && !((EntityLivingBase)leyepuye).isDead && ((EntityLivingBase)leyepuye).getHealth() > Float.intBitsToFloat(0) && !(leyepuye instanceof EntityArmorStand) && !AntiBot._remind((Entity)leyepuye) && leyepuye != iradopod.mc.thePlayer) {
         if (leyepuye instanceof EntityPlayer) {
            EntityPlayer var9 = (EntityPlayer)leyepuye;
            if (var9.getDisplayName().getFormattedText().contains("[NPC]")) {
               return false;
            }

            if (Client.î ?().î ?().friendsConfig.isFriend(var9.getName())) {
               return false;
            }

            if (!iradopod.anyway$.getSetting("Player").getValue().booleanValue()) {
               return false;
            }

            if (var9.isPlayerSleeping()) {
               return false;
            }

            if (var9.isPotionActive(Potion.invisibility) && !iradopod.anyway$.getSetting("Invisible").getValue().booleanValue()) {
               return false;
            }
         }

         return iradopod._possible((Entity)leyepuye);
      } else {
         return false;
      }
   }

   public boolean _accident(EntityLivingBase tires) {
      Object maritime = cloth.mc.thePlayer.posX - ((EntityLivingBase)tires).posX;
      Object malta = cloth.mc.thePlayer.posZ - ((EntityLivingBase)tires).posZ;
      Object amend = (double)MathHelper.sqrt_double(maritime * maritime + malta * malta) <= scanned$.getValue().doubleValue();
      if (!cloth._results((Entity)tires, informed$.getValue().floatValue()) && !amend) {
         return false;
      } else if (cloth.mc.thePlayer.isEntityAlive() && !cloth.mc.thePlayer.isPlayerSleeping() && !cloth.mc.thePlayer.isDead && cloth.mc.thePlayer.getHealth() > Float.intBitsToFloat(0) && !Teams._issued((EntityLivingBase)tires) && (double)cloth.mc.thePlayer.getDistanceToEntity((Entity)tires) < (double)formula$.getValue().floatValue() && ((EntityLivingBase)tires).isEntityAlive() && !((EntityLivingBase)tires).isDead && ((EntityLivingBase)tires).getHealth() > Float.intBitsToFloat(0) && !(tires instanceof EntityArmorStand) && !AntiBot._remind((Entity)tires) && tires != cloth.mc.thePlayer) {
         if (tires instanceof EntityPlayer) {
            EntityPlayer var7 = (EntityPlayer)tires;
            if (var7.getDisplayName().getFormattedText().contains("[NPC]")) {
               return false;
            }

            if (Client.î ?().î ?().friendsConfig.isFriend(var7.getName())) {
               return false;
            }

            if (!cloth.anyway$.getSetting("Player").getValue().booleanValue()) {
               return false;
            }

            if (var7.isPlayerSleeping()) {
               return false;
            }

            boolean var8 = !cloth.pilot$.getSetting("ThroughWall").getValue().booleanValue() || (double)cloth.mc.thePlayer.getDistanceToEntity(var7) >= (double)cattle$.getValue().floatValue();
            if (!RotationUtil._pocket(var7) && var8) {
               return false;
            }

            if (var7.isPotionActive(Potion.invisibility) && !cloth.anyway$.getSetting("Invisible").getValue().booleanValue()) {
               return false;
            }
         }

         return cloth._possible((Entity)tires);
      } else {
         return false;
      }
   }

   public boolean _desire(Entity gizecubi) {
      if (!anegebol._results((Entity)gizecubi, informed$.getValue().floatValue())) {
         return false;
      } else if (anegebol.mc.thePlayer.isEntityAlive() && !anegebol.mc.thePlayer.isPlayerSleeping() && !anegebol.mc.thePlayer.isDead && anegebol.mc.thePlayer.getHealth() > Float.intBitsToFloat(0) && !Teams._exposure((Entity)gizecubi) && ((Entity)gizecubi).isEntityAlive() && !((Entity)gizecubi).isDead && !(gizecubi instanceof EntityArmorStand) && !AntiBot._remind((Entity)gizecubi) && gizecubi != anegebol.mc.thePlayer) {
         if (gizecubi instanceof EntityPlayer) {
            Object urevumuc = (EntityPlayer)gizecubi;
            if (urevumuc.getDisplayName().getFormattedText().contains("[NPC]")) {
               return false;
            }

            if (Client.î ?().î ?().friendsConfig.isFriend(urevumuc.getName())) {
               return false;
            }

            if (!anegebol.anyway$.getSetting("Player").getValue().booleanValue()) {
               return false;
            }

            if (urevumuc.isPlayerSleeping()) {
               return false;
            }

            Object riselesa = humanity$ && (!anegebol.pilot$.getSetting("ThroughWall").getValue().booleanValue() || (double)anegebol.mc.thePlayer.getDistanceToEntity(urevumuc) >= (double)cattle$.getValue().floatValue());
            if (!RotationUtil._pocket(urevumuc) && riselesa) {
               return false;
            }

            if (urevumuc.isPotionActive(Potion.invisibility) && !anegebol.anyway$.getSetting("Invisible").getValue().booleanValue()) {
               return false;
            }
         }

         return anegebol._possible((Entity)gizecubi);
      } else {
         return false;
      }
   }

   public boolean _morrison(EntityPlayer pafebefo) {
      return ((EntityPlayer)pafebefo).inventory.getCurrentItem() != null && ((EntityPlayer)pafebefo).inventory.getCurrentItem().getItem() instanceof ItemSword;
   }

   public boolean _cameras(EntityPlayer mozalegi) {
      return ((EntityPlayer)mozalegi).inventory.getCurrentItem() != null && ((EntityPlayer)mozalegi).inventory.getCurrentItem().getItem() instanceof ItemAxe;
   }

   public boolean _airlines(EntityPlayer itumiyam) {
      return ((EntityPlayer)itumiyam).inventory.getCurrentItem() != null && ((EntityPlayer)itumiyam).inventory.getCurrentItem().getItem() instanceof ItemBlock;
   }

   public boolean _trauma(Entity drama) {
      return Math.abs(RotationUtil._locked(kingdom.mc.thePlayer.rotationYaw, ((Entity)drama).posX, ((Entity)drama).posY, ((Entity)drama).posZ)) > 100.0F;
   }

   public boolean _results(Entity lusiyoge, float iyanafic) {
      iyanafic = (float)((double)iyanafic * 0.5D);
      Object sazelula = ((double)(tuyemune.mc.thePlayer.rotationYaw - tuyemune._sunshine((Entity)lusiyoge)) % 360.0D + 540.0D) % 360.0D - 180.0D;
      return sazelula > Double.longBitsToDouble(0L) && sazelula < (double)iyanafic || (double)(-iyanafic) < sazelula && sazelula < Double.longBitsToDouble(0L);
   }

   public static double _chronic(double vasitopa, double vupeyimi) {
      Object obisurur = new Random();
      Object nifuduve = (double)(vupeyimi - vasitopa);
      double var7 = obisurur.nextDouble() * nifuduve;
      if (var7 > vupeyimi) {
         var7 = (double)vupeyimi;
      }

      double var9 = var7 + vasitopa;
      if (var9 > vupeyimi) {
         var9 = (double)vupeyimi;
      }

      return var9;
   }

   public static int _tribes(int separate, int choose) {
      Object harvey = new Random();
      Object summer = harvey.nextInt(choose - separate + 1) + separate;
      return summer;
   }

   public float _sunshine(Entity agiyadin) {
      Object vutabomo = ((Entity)agiyadin).posX - ucaroriv.mc.thePlayer.posX;
      Object ogepubay = ((Entity)agiyadin).posZ - ucaroriv.mc.thePlayer.posZ;
      double var6 = Math.atan2(vutabomo, ogepubay) * 57.2957795D;
      return (float)(var6 * -1.0D);
   }

   public static EntityLivingBase _versus() {
      return lesbians$;
   }

   public static int _drunk(Entity yotinedo, MovingObjectPosition coyotaca, MovingObjectPosition lofimovi) {
      Object fadonela = ((Entity)yotinedo).getPositionEyes(1.0F);
      return (int)((fadonela.distanceTo(((MovingObjectPosition)coyotaca).hitVec) - fadonela.distanceTo(((MovingObjectPosition)lofimovi).hitVec)) * 100.0D);
   }

   public static boolean _disabled(Entity mibapidu, Entity nifociyo) {
      return mibapidu != null && ((Entity)mibapidu).equals(nifociyo);
   }

   public static int _homework(EntityLivingBase cuziyezu, EntityLivingBase nibunumi) {
      return (int)(((EntityLivingBase)cuziyezu).getHealth() - ((EntityLivingBase)nibunumi).getHealth());
   }

   public int _sight(EntityLivingBase pipopigo, EntityLivingBase fodiculi) {
      Object lunapedo = _reload((Entity)pipopigo);
      Object fimuleti = _reload((Entity)fodiculi);
      return (int)(mecosasa.mc.thePlayer.rotationYaw - lunapedo[0] - (mecosasa.mc.thePlayer.rotationYaw - fimuleti[0]));
   }

   public static int _sharon(EntityLivingBase uteyerun) {
      return 20 - ((EntityLivingBase)uteyerun).hurtResistantTime;
   }

   public int _coupon(EntityLivingBase broader, EntityLivingBase entering) {
      return (int)(((EntityLivingBase)broader).getDistanceToEntity(gifts.mc.thePlayer) - ((EntityLivingBase)entering).getDistanceToEntity(gifts.mc.thePlayer));
   }

   public static int _attempts(EntityLivingBase guyaresi) {
      return guyaresi instanceof EntityPlayer ? ((EntityPlayer)guyaresi).inventory.getTotalArmorValue() : (int)((EntityLivingBase)guyaresi).getHealth();
   }
}
