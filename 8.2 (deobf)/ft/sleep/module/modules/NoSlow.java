//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.events.world.SlowdownEvent;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IEntityPlayer;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.KillAura;
import ft.sleep.util.packet.PacketUtils;
import ft.sleep.util.player.PlayerUtils;
import ft.sleep.util.timer.MSTimer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Mouse;

public class NoSlow extends Module {
   public Mode outline$ = new Mode("Mode", new String[]{"Vanilla", "Hypixel"}, "Hypixel");
   public Numbers progress$ = new Numbers("Time", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(50), 0.5D);
   public Option province$ = new Option("Eat", false);
   public Option costs$ = new Option("Test", false);
   public Option vital$ = new Option("Test Debug", false);
   public Numbers lending$ = new Numbers("BlockForward", 1.0D, 0.2D, 1.0D, 0.01D);
   public Numbers welcome$ = new Numbers("BlockStrafe", 1.0D, 0.2D, 1.0D, 0.01D);
   public Numbers lions$ = new Numbers("ConsumeForward", 1.0D, 0.2D, 1.0D, 0.01D);
   public Numbers comics$ = new Numbers("ConsumeStrafe", 1.0D, 0.2D, 1.0D, 0.01D);
   public Numbers thing$ = new Numbers("BowForward", 0.2F, 0.2D, 1.0D, 0.01D);
   public Numbers really$ = new Numbers("BowStrafe", 0.2F, 0.2D, 1.0D, 0.01D);
   public boolean reviews$ = false;
   public MSTimer lonely$ = new MSTimer();
   public LinkedList server$ = new LinkedList();
   public boolean caused$ = false;
   public boolean became$ = false;
   public boolean sports$ = false;
   public boolean restore$ = false;
   public boolean thinking$ = false;

   public NoSlow() {
      super("No SlowDown", new String[]{"noslowdown", "noslow"}, ModuleType.Movement);
      barrel._piece((new Color(216, 253, 100)).getRGB());
   }

   public void _regime() {
      worship.restore$ = false;
      worship.sports$ = false;
      worship.lonely$._access();
      worship.server$.clear();
      worship.caused$ = false;
   }

   public void _discs() {
      zigadini.sports$ = false;
      zigadini.restore$ = false;
      zigadini.lonely$._access();
      zigadini.server$.clear();
      zigadini.caused$ = false;
   }

   @EventHandler
   public void _desktop(EventPacketSend goguyuya) {
      Object utuzugaf = iyanofuv.outline$.getValue();
      Object afilipay = EventPacketSend.getPacket();
      if (Objects.equals(utuzugaf, "Hypixel") && iyanofuv.caused$) {
         if ((afilipay instanceof C07PacketPlayerDigging || afilipay instanceof C08PacketPlayerBlockPlacement) && iyanofuv._promo()) {
            ((EventPacketSend)goguyuya).cancel();
         } else if (afilipay instanceof C03PacketPlayer || afilipay instanceof C0BPacketEntityAction || afilipay instanceof C07PacketPlayerDigging || afilipay instanceof C08PacketPlayerBlockPlacement) {
            iyanofuv.server$.add(afilipay);
            ((EventPacketSend)goguyuya).cancel();
         }
      }

      if (iyanofuv.province$.getValue().booleanValue() && iyanofuv._daughter(iyanofuv.mc.thePlayer.inventory.getCurrentItem())) {
         if (afilipay instanceof C07PacketPlayerDigging) {
            ((EventPacketSend)goguyuya).cancel();
         } else if (Mouse.isButtonDown(1) && !iyanofuv.restore$ && EventPacketSend.getPacket() instanceof C08PacketPlayerBlockPlacement) {
            ((EventPacketSend)goguyuya).cancel();
         }
      }

   }

   @EventHandler
   public void _inbox(EventUpdate allowing) {
      Object periods = updates.outline$.getValue();
      updates._infants(periods);
      if (updates.mc.thePlayer != null && updates.mc.theWorld != null) {
         if (Objects.equals(periods, "Hypixel") && (updates.became$ || updates._promo())) {
            if (updates.lonely$._nitrogen((long)(10 * updates.progress$.getValue().intValue())) && updates.caused$) {
               updates.caused$ = false;
               PacketUtils._gratis(new C09PacketHeldItemChange(updates.mc.thePlayer.inventory.currentItem % 8 + 1));
               PacketUtils._gratis(new C09PacketHeldItemChange(updates.mc.thePlayer.inventory.currentItem));
               if (!updates.server$.isEmpty()) {
                  Object comply = false;

                  for(Packet var5 : updates.server$) {
                     if (var5 instanceof C03PacketPlayer) {
                        comply = true;
                     }

                     if (!(var5 instanceof C02PacketUseEntity) && !(var5 instanceof C0APacketAnimation) || comply) {
                        PacketUtils._gratis(var5);
                     }
                  }

                  updates.server$.clear();
               }
            }

            if (!updates.caused$) {
               updates.became$ = updates._promo();
               if (!updates._promo()) {
                  return;
               }

               updates.caused$ = true;
               PacketUtils._gratis(new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 255, updates.mc.thePlayer.inventory.getCurrentItem(), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0)));
               updates.lonely$._access();
            }
         }

      }
   }

   @EventHandler
   public void _raised(EventPostUpdate ultimate) {
      String var2 = missions.outline$.getValue();
      if (Objects.equals(var2, "Hypixel")) {
         if (missions._promo()) {
            if (missions.reviews$ && missions.costs$.getValue().booleanValue()) {
               if (missions.vital$.getValue().booleanValue()) {
                  PlayerUtils._snake("Send Packet");
               }

               PacketUtils._gratis(new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 255, missions.mc.thePlayer.inventory.getCurrentItem(), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0)));
            }

            missions.reviews$ = false;
         } else if (!missions.reviews$) {
            PacketUtils._payroll(new C09PacketHeldItemChange(missions.mc.thePlayer.inventory.currentItem % 8 + 1));
            PacketUtils._payroll(new C09PacketHeldItemChange(missions.mc.thePlayer.inventory.currentItem));
            missions.reviews$ = true;
         }
      }

   }

   @EventHandler
   public void _women(EventPreUpdate ezumavop) {
      if (lezoceci.province$.getValue().booleanValue()) {
         if (lezoceci.mc.thePlayer == null || lezoceci.mc.thePlayer == null) {
            return;
         }

         new MovingObjectPosition(new net.minecraft.util.Vec3(lezoceci.mc.thePlayer.posX, lezoceci.mc.thePlayer.posY, lezoceci.mc.thePlayer.posZ), EnumFacing.DOWN);
         if (lezoceci.sports$) {
            ((EventPreUpdate)ezumavop).setPitch(90.0F);
            Object eyacomig = lezoceci._sampling();
            Object fogagepu = (float)(eyacomig.hitVec.xCoord - (double)eyacomig.getBlockPos().getX());
            Object opesefos = (float)(eyacomig.hitVec.yCoord - (double)eyacomig.getBlockPos().getY());
            Object podoyoto = (float)(eyacomig.hitVec.zCoord - (double)eyacomig.getBlockPos().getZ());
            PacketUtils._gratis(new C08PacketPlayerBlockPlacement(eyacomig.getBlockPos(), eyacomig.sideHit.getIndex(), lezoceci.mc.thePlayer.inventory.getCurrentItem(), fogagepu, opesefos, podoyoto));
            lezoceci.sports$ = false;
         } else if (!lezoceci.restore$ && ((IEntityPlayer)lezoceci.mc.thePlayer).isFood() && lezoceci._daughter(lezoceci.mc.thePlayer.inventory.getCurrentItem())) {
            lezoceci.restore$ = true;
            Object var6 = lezoceci.mc.objectMouseOver;
            if (var6 != null && lezoceci.mc.theWorld.getBlockState(var6.getBlockPos()).getBlock() != null && lezoceci.mc.theWorld.getBlockState(var6.getBlockPos()).getBlock() != Blocks.air) {
               Object var7 = (float)(var6.hitVec.xCoord - (double)var6.getBlockPos().getX());
               Object var8 = (float)(var6.hitVec.yCoord - (double)var6.getBlockPos().getY());
               Object var9 = (float)(var6.hitVec.zCoord - (double)var6.getBlockPos().getZ());
               PacketUtils._gratis(new C08PacketPlayerBlockPlacement(var6.getBlockPos(), var6.sideHit.getIndex(), lezoceci.mc.thePlayer.inventory.getCurrentItem(), var7, var8, var9));
            } else {
               ((EventPreUpdate)ezumavop).setPitch(90.0F);
               lezoceci.sports$ = true;
            }
         } else if (lezoceci.restore$ && !((IEntityPlayer)lezoceci.mc.thePlayer).isFood()) {
            lezoceci.restore$ = false;
         }
      }

   }

   public boolean _daughter(ItemStack ofupevog) {
      if (ofupevog == null) {
         return false;
      } else if (((ItemStack)ofupevog).getItem() instanceof ItemSword) {
         return false;
      } else if (((ItemStack)ofupevog).getItem() instanceof ItemBow) {
         return false;
      } else {
         return ((ItemStack)ofupevog).getItem() instanceof ItemFood || ((ItemStack)ofupevog).getItem() instanceof ItemPotion || ((ItemStack)ofupevog).getItem() instanceof ItemBucketMilk;
      }
   }

   public boolean _promo() {
      return (Mouse.isButtonDown(1) || KillAura.humanity$) && odiderof.mc.thePlayer.getHeldItem() != null && odiderof.mc.thePlayer.getHeldItem().getItem() instanceof ItemSword;
   }

   public net.minecraft.util.Vec3 _baptist(float humanity, float austria) {
      Object several = MathHelper.cos((float)(Math.toRadians((double)(-austria)) - 3.1415927410125732D));
      Object belarus = MathHelper.sin((float)(Math.toRadians((double)(-austria)) - 3.1415927410125732D));
      Object bedrooms = -MathHelper.cos((float)Math.toRadians((double)(-humanity)));
      Object namely = MathHelper.sin((float)Math.toRadians((double)(-humanity)));
      return new net.minecraft.util.Vec3((double)(belarus * bedrooms), (double)namely, (double)(several * bedrooms));
   }

   public net.minecraft.util.Vec3 _wheel() {
      return new net.minecraft.util.Vec3(rebipayo.mc.thePlayer.posX, rebipayo.mc.thePlayer.posY + (double)rebipayo.mc.thePlayer.getEyeHeight(), rebipayo.mc.thePlayer.posZ);
   }

   public MovingObjectPosition _sampling() {
      Object zegifare = zilacufu._wheel();
      Object lipatobi = zilacufu._baptist(90.0F, zilacufu.mc.thePlayer.rotationYaw);
      Object yunimore = zegifare.addVector(lipatobi.xCoord * 4.5D, lipatobi.yCoord * 4.5D, lipatobi.zCoord * 4.5D);
      return zilacufu.mc.thePlayer.worldObj.rayTraceBlocks(zegifare, yunimore, false, false, true);
   }

   @EventHandler
   public void _whale(SlowdownEvent starring) {
      Object council = stack.mc.thePlayer.getHeldItem().getItem();
      ((SlowdownEvent)starring).forward = stack._online(council, true);
      ((SlowdownEvent)starring).strafe = stack._online(council, false);
   }

   public float _online(Item minolta, boolean heard) {
      Object attempt = 0.2F;
      if (minolta instanceof ItemFood || minolta instanceof ItemPotion || minolta instanceof ItemBucketMilk) {
         if (heard) {
            attempt = freeze.lions$.getValue().floatValue();
         } else {
            attempt = freeze.comics$.getValue().floatValue();
         }
      }

      if (minolta instanceof ItemSword) {
         if (heard) {
            attempt = freeze.lending$.getValue().floatValue();
         } else {
            attempt = freeze.welcome$.getValue().floatValue();
         }
      }

      if (minolta instanceof ItemBow) {
         if (heard) {
            attempt = freeze.thing$.getValue().floatValue();
         } else {
            attempt = freeze.really$.getValue().floatValue();
         }
      }

      return attempt;
   }
}
