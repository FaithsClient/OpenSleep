//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventJump;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.events.world.SafeWalkEvent;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IEntityPlayer;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.input.Keyboard;

public class Scaffold extends Module {
   public Scaffold3 broad$;
   public int money$;
   public int purpose$;
   public long wires$ = (long)846724316 ^ 846724316L;
   public MSTimer rehab$ = new MSTimer();
   public double guard$;
   public MoveUtil anderson$ = new MoveUtil();
   public Numbers vatican$ = new Numbers("Max Delay", Integer.valueOf(33), Integer.valueOf(0), Integer.valueOf(1000), 1.0D);
   public Numbers idaho$ = new Numbers("Min Delay", Integer.valueOf(33), Integer.valueOf(0), Integer.valueOf(1000), 1.0D);
   public Numbers moved$ = new Numbers("Multiplier", 0.6D, Double.longBitsToDouble(0L), 1.0D, 0.01D);
   public static Option horrible$ = new Option("TowerMove", false);
   public static Option chicago$ = new Option("Spoof", false);
   public static Option visitors$ = new Option("RotJump", true);
   public static Option facts$ = new Option("Safe Walk", true);
   public static Option examine$ = new Option("ft.sleep.module.modules.Sprint", true);
   public static Option ericsson$ = new Option("Swing", true);
   public static Option concerts$ = new Option("AutoBlock", true);
   public static Option stats$ = new Option("Tower", true);
   public static Option olympic$ = new Option("Eagle", false);
   public static List football$ = Arrays.asList(Blocks.air, Blocks.water, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava, Blocks.enchanting_table, Blocks.ender_chest, Blocks.sand, Blocks.tnt, Blocks.yellow_flower, Blocks.carpet, Blocks.glass_pane, Blocks.stained_glass_pane, Blocks.iron_bars, Blocks.crafting_table, Blocks.snow_layer, Blocks.packed_ice, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.chest, Blocks.torch, Blocks.stone_slab, Blocks.wooden_slab, Blocks.stone_slab2, Blocks.double_stone_slab2, Blocks.double_wooden_slab, Blocks.anvil, Blocks.trapped_chest, Blocks.noteblock, Blocks.gold_ore, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.redstone_ore, Blocks.wooden_pressure_plate, Blocks.stone_pressure_plate, Blocks.light_weighted_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.stone_button, Blocks.wooden_button, Blocks.cactus, Blocks.oak_stairs, Blocks.stone_brick_stairs, Blocks.nether_brick_stairs, Blocks.stone_stairs, Blocks.brick_stairs, Blocks.sandstone_stairs, Blocks.lever, Blocks.activator_rail, Blocks.rail, Blocks.spruce_stairs, Blocks.detector_rail, Blocks.golden_rail, Blocks.furnace, Blocks.ladder, Blocks.acacia_stairs, Blocks.double_stone_slab2, Blocks.dark_oak_stairs, Blocks.birch_stairs, Blocks.jungle_stairs, Blocks.quartz_stairs, Blocks.oak_fence, Blocks.redstone_torch, Blocks.iron_trapdoor, Blocks.trapdoor, Blocks.tripwire_hook, Blocks.hopper, Blocks.acacia_fence_gate, Blocks.birch_fence_gate, Blocks.dark_oak_fence_gate, Blocks.jungle_fence_gate, Blocks.spruce_fence_gate, Blocks.oak_fence_gate, Blocks.dispenser, Blocks.sapling, Blocks.tallgrass, Blocks.deadbush, Blocks.web, Blocks.red_flower, Blocks.red_mushroom, Blocks.brown_mushroom, Blocks.nether_brick_fence, Blocks.vine, Blocks.double_plant, Blocks.flower_pot, Blocks.beacon, Blocks.pumpkin, Blocks.lit_pumpkin);
   public int oscar$ = 0;
   public boolean opening$ = false;
   public int brian$;
   public int workout$;
   public boolean august$ = false;
   public boolean diffs$ = false;
   public float antique$;

   public Scaffold() {
      super("ft.sleep.module.modules.Scaffold", new String[]{"magiccarpet", "blockplacer", "airwalk"}, ModuleType.Movement);
   }

   public void _regime() {
      super._regime();
      studio.broad$ = null;
      studio.money$ = studio.mc.thePlayer.inventory.currentItem;
      studio.rehab$._access();
      studio.guard$ = (double)MathHelper.floor_double(studio.mc.thePlayer.posY);
      studio.purpose$ = studio.mc.thePlayer.inventory.currentItem;
      studio.brian$ = studio.vatican$.getValue().intValue();
      studio.workout$ = studio.idaho$.getValue().intValue();
      studio.antique$ = 80.0F;
      studio.august$ = true;
      studio.diffs$ = true;
   }

   public void _discs() {
      super._discs();
      rosivebi.mc.thePlayer.inventory.currentItem = rosivebi.purpose$;
      rosivebi.mc.thePlayer.motionX *= 1.0D;
      rosivebi.mc.thePlayer.motionZ *= 1.0D;
      rosivebi.mc.timer.timerSpeed = 1.0F;
      if (concerts$.getValue().booleanValue()) {
         ((IEntityPlayer)rosivebi.mc.thePlayer).setItemInUseCount(0);
      }

      if (rosivebi.money$ != rosivebi.mc.thePlayer.inventory.currentItem) {
         rosivebi.mc.getNetHandler().addToSendQueue(new C09PacketHeldItemChange(rosivebi.mc.thePlayer.inventory.currentItem));
      }

      if (olympic$.getValue().booleanValue()) {
         rosivebi.mc.gameSettings.keyBindSneak.pressed = Keyboard.isKeyDown(rosivebi.mc.gameSettings.keyBindSneak.getKeyCode());
      }

   }

   @EventHandler
   public void _rwanda(EventPreUpdate var1) {
      if (!examine$.getValue().booleanValue() && reliance.mc.thePlayer.onGround && !reliance._kuwait()) {
         reliance.mc.thePlayer.motionX *= reliance.mc.thePlayer.isPotionActive(Potion.moveSpeed) ? 0.8D : reliance.moved$.getValue().doubleValue();
         reliance.mc.thePlayer.motionZ *= reliance.mc.thePlayer.isPotionActive(Potion.moveSpeed) ? 0.8D : reliance.moved$.getValue().doubleValue();
      }

   }

   @EventHandler
   public void _plasma(EventUpdate var1) {
      if (examine$.getValue().booleanValue() && serum.mc.thePlayer.onGround && !serum._kuwait()) {
         serum.mc.thePlayer.setSprinting(false);
         if (serum.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
            serum.mc.thePlayer.motionX *= 0.8D;
            serum.mc.thePlayer.motionZ *= 0.8D;
         } else {
            serum.mc.thePlayer.motionX *= 0.8D;
            serum.mc.thePlayer.motionZ *= 0.8D;
         }
      }

   }

   @EventHandler
   public void _against(EventPreUpdate zigafeya) {
      onoputuc._infants("" + onoputuc._rally());
      if (concerts$.getValue().booleanValue()) {
         if (onoputuc.broad$ != null && MoveUtils._saddam()) {
            onoputuc.diffs$ = false;
         } else if (!onoputuc.diffs$) {
            ((IEntityPlayer)onoputuc.mc.thePlayer).setItemInUseCount(0);
            onoputuc.diffs$ = true;
         }
      }

      if (examine$.getValue().booleanValue() && onoputuc.mc.thePlayer.onGround && !onoputuc.mc.gameSettings.keyBindJump.isKeyDown()) {
         onoputuc._aerial(0.11D + onoputuc._veterans() * 0.01D);
      }

      if (onoputuc._rally() > 0) {
         if (!MovementUtils._bumper() && onoputuc._checks() <= 0) {
            Object yiyupeni = onoputuc._warrant();
            onoputuc._compiled(yiyupeni);
         }

         onoputuc.broad$ = onoputuc._corpus(new BlockPos(onoputuc.mc.thePlayer.posX, onoputuc.mc.thePlayer.posY - 1.0D, onoputuc.mc.thePlayer.posZ)) == null ? onoputuc._corpus((new BlockPos(onoputuc.mc.thePlayer.posX, onoputuc.mc.thePlayer.posY - 1.0D, onoputuc.mc.thePlayer.posZ)).down(1)) : onoputuc._corpus(new BlockPos(onoputuc.mc.thePlayer.posX, onoputuc.mc.thePlayer.posY - 1.0D, onoputuc.mc.thePlayer.posZ));
         if (onoputuc.broad$ != null) {
            if (visitors$.getValue().booleanValue() || !onoputuc.mc.gameSettings.keyBindJump.isKeyDown()) {
               Object var4 = 87.0F;
               Object puneguca = onoputuc.mc.thePlayer.rotationYaw - 180.0F;
               if (!onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && !onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && !onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw;
               }

               if (onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && !onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && !onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 135.0F;
               }

               if (!onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && !onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && !onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 90.0F;
               }

               if (!onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && !onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 45.0F;
               }

               if (onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && !onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && !onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 225.0F;
               }

               if (!onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && !onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && !onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 270.0F;
               }

               if (!onoputuc.mc.gameSettings.keyBindForward.isKeyDown() && !onoputuc.mc.gameSettings.keyBindRight.isKeyDown() && onoputuc.mc.gameSettings.keyBindLeft.isKeyDown() && onoputuc.mc.gameSettings.keyBindBack.isKeyDown()) {
                  puneguca = onoputuc.mc.thePlayer.rotationYaw - 315.0F;
               }

               ((EventPreUpdate)zigafeya).setYaw(puneguca);
               ((EventPreUpdate)zigafeya).setPitch(var4);
            }

            if (onoputuc._kuwait()) {
               onoputuc.august$ = false;
               if (MovementUtils._bumper() && !onoputuc._slight() && !onoputuc._estate()) {
                  if (!onoputuc.mc.theWorld.getCollidingBoundingBoxes(onoputuc.mc.thePlayer, onoputuc.mc.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), -0.01D, Double.longBitsToDouble(0L))).isEmpty() && onoputuc.mc.thePlayer.onGround && onoputuc.mc.thePlayer.isCollidedVertically) {
                     onoputuc.oscar$ = 0;
                     onoputuc.opening$ = true;
                  }

                  if (onoputuc.opening$) {
                     MovementUtils._parallel(MovementUtils._pulse() * 0.92F);
                     onoputuc.vatican$.value = Integer.valueOf(0);
                     onoputuc.idaho$.value = Integer.valueOf(0);
                     switch(onoputuc.oscar$) {
                     case 0:
                        onoputuc._guest();
                        onoputuc.mc.thePlayer.motionY = 0.41999998688697815D;
                        ++onoputuc.oscar$;
                        break;
                     case 1:
                        ++onoputuc.oscar$;
                        break;
                     case 2:
                        ++onoputuc.oscar$;
                        break;
                     case 3:
                        EventPreUpdate.ground = true;
                        onoputuc.mc.thePlayer.motionY = Double.longBitsToDouble(0L);
                        ++onoputuc.oscar$;
                        break;
                     case 4:
                        ++onoputuc.oscar$;
                     }

                     onoputuc.opening$ = false;
                  }

                  onoputuc.opening$ = true;
               } else if (onoputuc.mc.thePlayer.onGround && onoputuc.rehab$._nitrogen((long)1815044523 ^ 1815044522L)) {
                  onoputuc._guest();
                  onoputuc.mc.thePlayer.motionY = 0.41999998688698D;
                  onoputuc.rehab$._access();
               }
            }

            if ((!onoputuc.mc.gameSettings.keyBindJump.isKeyDown() || !MovementUtils._bumper()) && !onoputuc.august$) {
               onoputuc.vatican$.value = onoputuc.brian$;
               onoputuc.idaho$.value = onoputuc.workout$;
               onoputuc.august$ = true;
            }

            if (olympic$.getValue().booleanValue()) {
               onoputuc.mc.gameSettings.keyBindSneak.pressed = PlayerUtil._triangle(onoputuc.mc.thePlayer);
            }

         }
      }
   }

   @EventHandler
   public void _records(EventPostUpdate var1) {
      local._although();
   }

   public double _veterans() {
      return (double)(esomodap.mc.thePlayer.isPotionActive(Potion.moveSpeed) ? esomodap.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0);
   }

   public void _aerial(double bazupave) {
      float var3 = fufimemu._portugal();
      if (fufimemu.mc.thePlayer.moveForward != Float.intBitsToFloat(0) || fufimemu.mc.thePlayer.moveStrafing != Float.intBitsToFloat(0)) {
         fufimemu.mc.thePlayer.motionX = -Math.sin(Math.toRadians((double)var3)) * bazupave;
         fufimemu.mc.thePlayer.motionZ = Math.cos(Math.toRadians((double)var3)) * bazupave;
      }

   }

   public float _portugal() {
      Object rankings = boating.mc.thePlayer.rotationYaw;
      if (boating.mc.thePlayer.moveForward != Float.intBitsToFloat(0) && boating.mc.thePlayer.moveStrafing == Float.intBitsToFloat(0)) {
         rankings += boating.mc.thePlayer.moveForward > Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : 180.0F;
      } else if (boating.mc.thePlayer.moveForward != Float.intBitsToFloat(0) && boating.mc.thePlayer.moveStrafing != Float.intBitsToFloat(0)) {
         if (boating.mc.thePlayer.moveForward > Float.intBitsToFloat(0)) {
            rankings = rankings + (boating.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -45.0F : 45.0F);
         } else {
            rankings = rankings - (boating.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -45.0F : 45.0F);
         }

         rankings = rankings + (boating.mc.thePlayer.moveForward > Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : 180.0F);
      } else if (boating.mc.thePlayer.moveStrafing != Float.intBitsToFloat(0) && boating.mc.thePlayer.moveForward == Float.intBitsToFloat(0)) {
         rankings += boating.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -90.0F : 90.0F;
      }

      return rankings;
   }

   @EventHandler
   public void _talent(EventPacketSend coupled) {
      if (missed.mc.thePlayer != null) {
         Object hammer = EventPacketSend.packet;
         if (hammer instanceof C09PacketHeldItemChange) {
            Object clone = (C09PacketHeldItemChange)EventPacketSend.getPacket();
            if (clone.getSlotId() == missed.money$) {
               ((EventPacketSend)coupled).cancel();
            } else {
               missed.money$ = clone.getSlotId();
            }
         }

      }
   }

   @EventHandler
   public void _robert(EventJump eduyafac) {
      if (tubunezo._kuwait()) {
         ((EventJump)eduyafac).cancel();
      }

   }

   public void _although() {
      if (!vonemeze._kuwait()) {
         vonemeze.oscar$ = 0;
      }

      if (vonemeze.broad$ == null) {
         vonemeze.rehab$._access();
      } else if (vonemeze.rehab$._nitrogen(vonemeze.wires$)) {
         Object oradupuz = -1;
         Object lopumugo = vonemeze.mc.thePlayer.getHeldItem();
         if (vonemeze.mc.thePlayer.getHeldItem() == null || !(vonemeze.mc.thePlayer.getHeldItem().getItem() instanceof ItemBlock)) {
            oradupuz = InventoryUtils._renew();
            if (oradupuz == -1) {
               return;
            }

            if (chicago$.getValue().booleanValue()) {
               PacketUtils._payroll(new C09PacketHeldItemChange(oradupuz - 36));
            } else {
               vonemeze.mc.thePlayer.inventory.currentItem = oradupuz - 36;
            }

            lopumugo = vonemeze.mc.thePlayer.inventoryContainer.getSlot(oradupuz).getStack();
         }

         if (vonemeze.mc.playerController.onPlayerRightClick(vonemeze.mc.thePlayer, vonemeze.mc.theWorld, lopumugo, vonemeze.broad$._train(), vonemeze.broad$._happen(), vonemeze.broad$._concert())) {
            vonemeze.rehab$._access();
            vonemeze.wires$ = MathUtils._trailer(vonemeze.idaho$.getValue().intValue(), vonemeze.vatican$.getValue().intValue());
            vonemeze.antique$ = MathUtils._minus(79.5F, 83.5F);
            if (concerts$.getValue().booleanValue() && PlayerUtils._wherever()) {
               ((IEntityPlayer)vonemeze.mc.thePlayer).setItemInUseCount(vonemeze.mc.thePlayer.getHeldItem().getMaxItemUseDuration());
            }

            if (ericsson$.getValue().booleanValue()) {
               vonemeze.mc.thePlayer.swingItem();
            } else {
               PacketUtils._payroll(new C0APacketAnimation());
            }
         }

      }
   }

   public void _guest() {
      rimonini.mc.thePlayer.isAirBorne = true;
      rimonini.mc.thePlayer.triggerAchievement(StatList.jumpStat);
   }

   @EventHandler
   public void _lifetime(EventRender2D efumolov) {
      Object efagovey = Colors._nickname(255, 0, 0, 150);
      if (reruyimo._checks() >= 64 && 128 > reruyimo._checks()) {
         efagovey = Colors._nickname(255, 255, 0, 150);
      } else if (reruyimo._checks() >= 128) {
         efagovey = Colors._nickname(0, 255, 0, 150);
      }

      Object gedulefi = new ScaledResolution(reruyimo.mc);
      String var4 = "" + reruyimo._checks();
      GlStateManager.enableBlend();
      Nametags var5 = (Nametags) ModuleManager._herbs(Nametags.class);
      reruyimo.mc.fontRendererObj.drawStringWithShadow("§fNMSL:" + EnumChatFormatting.RESET + var4, (float)gedulefi.getScaledWidth() / 2.0F - (float)reruyimo.mc.fontRendererObj.getStringWidth(var4) / 2.0F - 7.0F, (float)gedulefi.getScaledHeight() / 2.0F - 100.0F, efagovey);
      GlStateManager.disableBlend();
   }

   @EventHandler
   public void _rocks(SafeWalkEvent stops) {
      if ((facts$.getValue().booleanValue() || poland._cells() <= 0) && !Keyboard.isKeyDown(42)) {
         ((SafeWalkEvent)stops).setCancelled(true);
      }
   }

   public boolean _kuwait() {
      return stats$.getValue().booleanValue() && gitesulu.mc.gameSettings.keyBindJump.isKeyDown() && (!horrible$.getValue().booleanValue() || horrible$.getValue().booleanValue() && !MovementUtils._bumper());
   }

   public int _proved() {
      for(Object zeleyedu = 0; zeleyedu < 9; ++zeleyedu) {
         if (tayulovo.mc.thePlayer.inventory.getStackInSlot(zeleyedu) != null && tayulovo.mc.thePlayer.inventory.getStackInSlot(zeleyedu).stackSize != 0) {
            Object luyemoyo = tayulovo.mc.thePlayer.inventory.getStackInSlot(zeleyedu).getItem();
            if (tayulovo._seeker(luyemoyo)) {
               return zeleyedu;
            }
         }
      }

      return tayulovo.mc.thePlayer.inventory.currentItem;
   }

   public static double _pictures(double ediyival, double var2) {
      return Math.random() * (ediyival - var2) + var2;
   }

   public static void _pills(net.minecraft.util.Timer adapters, float surface) {
      ((net.minecraft.util.Timer)adapters).timerSpeed = (float)surface;
   }

   public long _suffered(int adidas, int flesh) {
      return (long)RandomUtils.nextInt((int)adidas, (int)flesh);
   }

   public long _goods(int advisory, int tyler) {
      return (long)(Math.random() * (double)(1000 / advisory - 1000 / tyler + 1) + (double)(1000 / tyler));
   }

   public boolean _revision(Block eceputad) {
      if (!((Block)eceputad).getMaterial().isReplaceable()) {
         return false;
      } else {
         return !(eceputad instanceof BlockSnow) || ((Block)eceputad).getBlockBoundsMaxY() <= 0.125D;
      }
   }

   public boolean _seeker(Item opamilab) {
      if (!(opamilab instanceof ItemBlock)) {
         return false;
      } else {
         Object vazucudi = (ItemBlock)opamilab;
         Object ogavomug = vazucudi.getBlock();
         return !football$.contains(ogavomug);
      }
   }

   public int _cells() {
      for(Object ranazogi = 0; ranazogi < 9; ++ranazogi) {
         if (afagizev.mc.thePlayer.inventoryContainer.getSlot(ranazogi + 36).getHasStack() && afagizev.mc.thePlayer.inventoryContainer.getSlot(ranazogi + 36).getStack().getItem() instanceof ItemBlock && !football$.contains(((ItemBlock)afagizev.mc.thePlayer.inventoryContainer.getSlot(ranazogi + 36).getStack().getItem()).getBlock())) {
            return ranazogi;
         }
      }

      return -1;
   }

   public int _rally() {
      Object ebonopup = 0;

      for(Object uzugalay = 0; uzugalay < 45; ++uzugalay) {
         ebonopup += ivegamir.mc.thePlayer.inventoryContainer.getSlot(uzugalay).getHasStack() && ivegamir.mc.thePlayer.inventoryContainer.getSlot(uzugalay).getStack().getItem() instanceof ItemBlock ? ivegamir.mc.thePlayer.inventoryContainer.getSlot(uzugalay).getStack().stackSize : 0;
      }

      return ebonopup;
   }

   public int _night() {
      Object graphic = 0;

      for(Object border = 36; border < 45; ++border) {
         graphic += lyric.mc.thePlayer.inventoryContainer.getSlot(border).getHasStack() && lyric.mc.thePlayer.inventoryContainer.getSlot(border).getStack().getItem() instanceof ItemBlock ? lyric.mc.thePlayer.inventoryContainer.getSlot(border).getStack().stackSize : 0;
      }

      return graphic;
   }

   public void _distance(int quarters, int forms) {
      testing.mc.playerController.windowClick(testing.mc.thePlayer.inventoryContainer.windowId, (int)quarters, (int)forms, 2, testing.mc.thePlayer);
   }

   public void _compiled(int physics) {
      for(Object ferrari = 9; ferrari < 45; ++ferrari) {
         if (valve.mc.thePlayer.inventoryContainer.getSlot(ferrari).getHasStack() && (valve.mc.currentScreen == null || valve.mc.currentScreen instanceof GuiInventory)) {
            Object duncan = valve.mc.thePlayer.inventoryContainer.getSlot(ferrari).getStack();
            Object spencer = duncan.getItem();
            if (duncan.getItem() instanceof ItemBlock) {
               ItemBlock var5 = (ItemBlock)duncan.getItem();
               if (valve._seeker(var5)) {
                  if (36 + physics != ferrari) {
                     valve._distance(ferrari, (int)physics);
                  }
                  break;
               }
            }
         }
      }

   }

   public int _checks() {
      Object cicopaca = 0;

      for(Object megefusu = 36; megefusu < 45; ++megefusu) {
         if (nodirabi.mc.thePlayer.inventoryContainer.getSlot(megefusu).getHasStack()) {
            Object bifelula = nodirabi.mc.thePlayer.inventoryContainer.getSlot(megefusu).getStack();
            Object edevereb = bifelula.getItem();
            if (bifelula.getItem() instanceof ItemBlock && !football$.contains(((ItemBlock)edevereb).getBlock())) {
               cicopaca += bifelula.stackSize;
            }
         }
      }

      return cicopaca;
   }

   public int _warrant() {
      Object isosabif = 5;

      for(Object oyecuref = 36; oyecuref < 45; ++oyecuref) {
         if (!sulasesa.mc.thePlayer.inventoryContainer.getSlot(oyecuref).getHasStack()) {
            isosabif = oyecuref - 36;
            break;
         }
      }

      return isosabif;
   }

   public int _founder() {
      Object disagree = -1;
      Object watch = 0;
      if (senior._rally() == 0) {
         return -1;
      } else {
         for(Object passive = 9; passive < 36; ++passive) {
            Object monica = senior.mc.thePlayer.inventoryContainer.getSlot(passive);
            if (monica.getHasStack()) {
               Object pants = monica.getStack().getItem();
               Object relevant = monica.getStack();
               if (pants instanceof ItemBlock && senior._seeker(pants) && relevant.stackSize > watch) {
                  watch = relevant.stackSize;
                  disagree = passive;
               }
            }
         }

         return disagree;
      }
   }

   public static net.minecraft.util.Vec3 _active(BlockPos atlanta, EnumFacing needle) {
      Object walking = (double)((BlockPos)atlanta).getX() + 0.5D;
      Object greene = (double)((BlockPos)atlanta).getY() + 0.5D;
      double var6 = (double)((BlockPos)atlanta).getZ() + 0.5D;
      if (needle != EnumFacing.UP && needle != EnumFacing.DOWN) {
         greene += _pictures(0.3D, -0.3D);
      } else {
         walking += _pictures(0.3D, -0.3D);
         var6 += _pictures(0.3D, -0.3D);
      }

      if (needle == EnumFacing.WEST || needle == EnumFacing.EAST) {
         var6 += _pictures(0.3D, -0.3D);
      }

      if (needle == EnumFacing.SOUTH || needle == EnumFacing.NORTH) {
         walking += _pictures(0.3D, -0.3D);
      }

      return new net.minecraft.util.Vec3(walking, greene, var6);
   }

   public float[] _matrix(net.minecraft.util.Vec3 lions) {
      Object offered = ((net.minecraft.util.Vec3)lions).xCoord - power.mc.thePlayer.posX;
      Object broke = ((net.minecraft.util.Vec3)lions).zCoord - power.mc.thePlayer.posZ;
      Object unity = ((net.minecraft.util.Vec3)lions).yCoord;
      Object marshall = power.mc.thePlayer.posY + (double)power.mc.thePlayer.getEyeHeight() - unity;
      double var10 = (double)MathHelper.sqrt_double(offered * offered + broke * broke);
      float var12 = (float)(Math.atan2(broke, offered) * 180.0D / 3.141592653589793D) - 90.0F;
      float var13 = (float)(Math.atan2(marshall, var10) * 180.0D / 3.141592653589793D);
      if (var12 < Float.intBitsToFloat(0)) {
         var12 += 360.0F;
      }

      return new float[]{var12, var13};
   }

   public float[] _mapping(BlockPos ovenonoz, EnumFacing irebucec) {
      Object ililolub = (double)((BlockPos)ovenonoz).getX() + 0.5D - uyigeciz.mc.thePlayer.posX + (double)((EnumFacing)irebucec).getFrontOffsetX() / 2.0D;
      Object usayayom = (double)((BlockPos)ovenonoz).getZ() + 0.5D - uyigeciz.mc.thePlayer.posZ + (double)((EnumFacing)irebucec).getFrontOffsetZ() / 2.0D;
      Object apuyepis = (double)((BlockPos)ovenonoz).getY() + 0.5D;
      Object irolepay = uyigeciz.mc.thePlayer.posY + (double)uyigeciz.mc.thePlayer.getEyeHeight() - apuyepis;
      double var11 = (double)MathHelper.sqrt_double(ililolub * ililolub + usayayom * usayayom);
      float var13 = (float)(Math.atan2(usayayom, ililolub) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(Math.atan2(irolepay, var11) * 180.0D / 3.141592653589793D);
      if (var13 < Float.intBitsToFloat(0)) {
         var13 += 360.0F;
      }

      return new float[]{var13, var14};
   }

   public int _walter() {
      Object omatelig = -1;
      Object putupome = 0;

      for(Object mometise = 36; mometise < 45; ++mometise) {
         if (comafasi.mc.thePlayer.inventoryContainer.getSlot(mometise).getHasStack()) {
            Object zapecebe = comafasi.mc.thePlayer.inventoryContainer.getSlot(mometise).getStack().getItem();
            Object zupigoco = comafasi.mc.thePlayer.inventoryContainer.getSlot(mometise).getStack();
            if (zapecebe instanceof ItemBlock && comafasi._seeker(zapecebe) && zupigoco.stackSize > putupome) {
               putupome = zupigoco.stackSize;
               omatelig = mometise;
            }
         }
      }

      return omatelig;
   }

   public Material _elected(BlockPos sunny) {
      return extent._intend((BlockPos)sunny).getMaterial();
   }

   public Block _intend(BlockPos bamamiba) {
      return yosusiri._ranger((BlockPos)bamamiba).getBlock();
   }

   public IBlockState _ranger(BlockPos ibinayun) {
      return visoyuye.mc.theWorld.getBlockState((BlockPos)ibinayun);
   }

   public int _boxing() {
      Object worried = -1;
      Object dicke = 0;

      for(Object british = 9; british < 36; ++british) {
         if (waters.mc.thePlayer.inventoryContainer.getSlot(british).getHasStack()) {
            Object neighbor = waters.mc.thePlayer.inventoryContainer.getSlot(british).getStack().getItem();
            Object brand = waters.mc.thePlayer.inventoryContainer.getSlot(british).getStack();
            if (neighbor instanceof ItemBlock && waters._seeker(neighbor) && brand.stackSize > dicke) {
               dicke = brand.stackSize;
               worried = british;
            }
         }
      }

      return worried;
   }

   public boolean _slight() {
      return mebigobu.mc.theWorld.getBlockState(new BlockPos(mebigobu.mc.thePlayer.posX, mebigobu.mc.thePlayer.posY - 1.0D, mebigobu.mc.thePlayer.posZ)).getBlock() instanceof BlockStairs;
   }

   public boolean _estate() {
      return prince.mc.theWorld.getBlockState(new BlockPos(prince.mc.thePlayer.posX, prince.mc.thePlayer.posY - 0.1D, prince.mc.thePlayer.posZ)).getBlock() instanceof BlockSlab && Math.floor(prince.mc.thePlayer.posY) != prince.mc.thePlayer.posY;
   }

   public Scaffold3 _corpus(BlockPos ruyiseda) {
      if (fayomabo._lighter(((BlockPos)ruyiseda).add(0, -1, 0))) {
         return new Scaffold3(((BlockPos)ruyiseda).add(0, -1, 0), EnumFacing.UP);
      } else if (fayomabo._lighter(((BlockPos)ruyiseda).add(-1, 0, 0))) {
         return new Scaffold3(((BlockPos)ruyiseda).add(-1, 0, 0), EnumFacing.EAST);
      } else if (fayomabo._lighter(((BlockPos)ruyiseda).add(1, 0, 0))) {
         return new Scaffold3(((BlockPos)ruyiseda).add(1, 0, 0), EnumFacing.WEST);
      } else if (fayomabo._lighter(((BlockPos)ruyiseda).add(0, 0, 1))) {
         return new Scaffold3(((BlockPos)ruyiseda).add(0, 0, 1), EnumFacing.NORTH);
      } else if (fayomabo._lighter(((BlockPos)ruyiseda).add(0, 0, -1))) {
         return new Scaffold3(((BlockPos)ruyiseda).add(0, 0, -1), EnumFacing.SOUTH);
      } else {
         Object yadigose = ((BlockPos)ruyiseda).add(-1, 0, 0);
         if (fayomabo._lighter(yadigose.add(0, -1, 0))) {
            return new Scaffold3(yadigose.add(0, -1, 0), EnumFacing.UP);
         } else if (fayomabo._lighter(yadigose.add(-1, 0, 0))) {
            return new Scaffold3(yadigose.add(-1, 0, 0), EnumFacing.EAST);
         } else if (fayomabo._lighter(yadigose.add(1, 0, 0))) {
            return new Scaffold3(yadigose.add(1, 0, 0), EnumFacing.WEST);
         } else if (fayomabo._lighter(yadigose.add(0, 0, 1))) {
            return new Scaffold3(yadigose.add(0, 0, 1), EnumFacing.NORTH);
         } else if (fayomabo._lighter(yadigose.add(0, 0, -1))) {
            return new Scaffold3(yadigose.add(0, 0, -1), EnumFacing.SOUTH);
         } else {
            Object elazafus = ((BlockPos)ruyiseda).add(1, 0, 0);
            if (fayomabo._lighter(elazafus.add(0, -1, 0))) {
               return new Scaffold3(elazafus.add(0, -1, 0), EnumFacing.UP);
            } else if (fayomabo._lighter(elazafus.add(-1, 0, 0))) {
               return new Scaffold3(elazafus.add(-1, 0, 0), EnumFacing.EAST);
            } else if (fayomabo._lighter(elazafus.add(1, 0, 0))) {
               return new Scaffold3(elazafus.add(1, 0, 0), EnumFacing.WEST);
            } else if (fayomabo._lighter(elazafus.add(0, 0, 1))) {
               return new Scaffold3(elazafus.add(0, 0, 1), EnumFacing.NORTH);
            } else if (fayomabo._lighter(elazafus.add(0, 0, -1))) {
               return new Scaffold3(elazafus.add(0, 0, -1), EnumFacing.SOUTH);
            } else {
               Object ufenilaz = ((BlockPos)ruyiseda).add(0, 0, 1);
               if (fayomabo._lighter(ufenilaz.add(0, -1, 0))) {
                  return new Scaffold3(ufenilaz.add(0, -1, 0), EnumFacing.UP);
               } else if (fayomabo._lighter(ufenilaz.add(-1, 0, 0))) {
                  return new Scaffold3(ufenilaz.add(-1, 0, 0), EnumFacing.EAST);
               } else if (fayomabo._lighter(ufenilaz.add(1, 0, 0))) {
                  return new Scaffold3(ufenilaz.add(1, 0, 0), EnumFacing.WEST);
               } else if (fayomabo._lighter(ufenilaz.add(0, 0, 1))) {
                  return new Scaffold3(ufenilaz.add(0, 0, 1), EnumFacing.NORTH);
               } else if (fayomabo._lighter(ufenilaz.add(0, 0, -1))) {
                  return new Scaffold3(ufenilaz.add(0, 0, -1), EnumFacing.SOUTH);
               } else {
                  Object ozocaloz = ((BlockPos)ruyiseda).add(0, 0, -1);
                  if (fayomabo._lighter(ozocaloz.add(0, -1, 0))) {
                     return new Scaffold3(ozocaloz.add(0, -1, 0), EnumFacing.UP);
                  } else if (fayomabo._lighter(ozocaloz.add(-1, 0, 0))) {
                     return new Scaffold3(ozocaloz.add(-1, 0, 0), EnumFacing.EAST);
                  } else if (fayomabo._lighter(ozocaloz.add(1, 0, 0))) {
                     return new Scaffold3(ozocaloz.add(1, 0, 0), EnumFacing.WEST);
                  } else if (fayomabo._lighter(ozocaloz.add(0, 0, 1))) {
                     return new Scaffold3(ozocaloz.add(0, 0, 1), EnumFacing.NORTH);
                  } else if (fayomabo._lighter(ozocaloz.add(0, 0, -1))) {
                     return new Scaffold3(ozocaloz.add(0, 0, -1), EnumFacing.SOUTH);
                  } else {
                     ((BlockPos)ruyiseda).add(-2, 0, 0);
                     if (fayomabo._lighter(yadigose.add(0, -1, 0))) {
                        return new Scaffold3(yadigose.add(0, -1, 0), EnumFacing.UP);
                     } else if (fayomabo._lighter(yadigose.add(-1, 0, 0))) {
                        return new Scaffold3(yadigose.add(-1, 0, 0), EnumFacing.EAST);
                     } else if (fayomabo._lighter(yadigose.add(1, 0, 0))) {
                        return new Scaffold3(yadigose.add(1, 0, 0), EnumFacing.WEST);
                     } else if (fayomabo._lighter(yadigose.add(0, 0, 1))) {
                        return new Scaffold3(yadigose.add(0, 0, 1), EnumFacing.NORTH);
                     } else if (fayomabo._lighter(yadigose.add(0, 0, -1))) {
                        return new Scaffold3(yadigose.add(0, 0, -1), EnumFacing.SOUTH);
                     } else {
                        ((BlockPos)ruyiseda).add(2, 0, 0);
                        if (fayomabo._lighter(elazafus.add(0, -1, 0))) {
                           return new Scaffold3(elazafus.add(0, -1, 0), EnumFacing.UP);
                        } else if (fayomabo._lighter(elazafus.add(-1, 0, 0))) {
                           return new Scaffold3(elazafus.add(-1, 0, 0), EnumFacing.EAST);
                        } else if (fayomabo._lighter(elazafus.add(1, 0, 0))) {
                           return new Scaffold3(elazafus.add(1, 0, 0), EnumFacing.WEST);
                        } else if (fayomabo._lighter(elazafus.add(0, 0, 1))) {
                           return new Scaffold3(elazafus.add(0, 0, 1), EnumFacing.NORTH);
                        } else if (fayomabo._lighter(elazafus.add(0, 0, -1))) {
                           return new Scaffold3(elazafus.add(0, 0, -1), EnumFacing.SOUTH);
                        } else {
                           ((BlockPos)ruyiseda).add(0, 0, 2);
                           if (fayomabo._lighter(ufenilaz.add(0, -1, 0))) {
                              return new Scaffold3(ufenilaz.add(0, -1, 0), EnumFacing.UP);
                           } else if (fayomabo._lighter(ufenilaz.add(-1, 0, 0))) {
                              return new Scaffold3(ufenilaz.add(-1, 0, 0), EnumFacing.EAST);
                           } else if (fayomabo._lighter(ufenilaz.add(1, 0, 0))) {
                              return new Scaffold3(ufenilaz.add(1, 0, 0), EnumFacing.WEST);
                           } else if (fayomabo._lighter(ufenilaz.add(0, 0, 1))) {
                              return new Scaffold3(ufenilaz.add(0, 0, 1), EnumFacing.NORTH);
                           } else if (fayomabo._lighter(ufenilaz.add(0, 0, -1))) {
                              return new Scaffold3(ufenilaz.add(0, 0, -1), EnumFacing.SOUTH);
                           } else {
                              ((BlockPos)ruyiseda).add(0, 0, -2);
                              if (fayomabo._lighter(ozocaloz.add(0, -1, 0))) {
                                 return new Scaffold3(ozocaloz.add(0, -1, 0), EnumFacing.UP);
                              } else if (fayomabo._lighter(ozocaloz.add(-1, 0, 0))) {
                                 return new Scaffold3(ozocaloz.add(-1, 0, 0), EnumFacing.EAST);
                              } else if (fayomabo._lighter(ozocaloz.add(1, 0, 0))) {
                                 return new Scaffold3(ozocaloz.add(1, 0, 0), EnumFacing.WEST);
                              } else if (fayomabo._lighter(ozocaloz.add(0, 0, 1))) {
                                 return new Scaffold3(ozocaloz.add(0, 0, 1), EnumFacing.NORTH);
                              } else if (fayomabo._lighter(ozocaloz.add(0, 0, -1))) {
                                 return new Scaffold3(ozocaloz.add(0, 0, -1), EnumFacing.SOUTH);
                              } else {
                                 Object atifotav = ((BlockPos)ruyiseda).add(0, -1, 0);
                                 if (fayomabo._lighter(atifotav.add(0, -1, 0))) {
                                    return new Scaffold3(atifotav.add(0, -1, 0), EnumFacing.UP);
                                 } else if (fayomabo._lighter(atifotav.add(-1, 0, 0))) {
                                    return new Scaffold3(atifotav.add(-1, 0, 0), EnumFacing.EAST);
                                 } else if (fayomabo._lighter(atifotav.add(1, 0, 0))) {
                                    return new Scaffold3(atifotav.add(1, 0, 0), EnumFacing.WEST);
                                 } else if (fayomabo._lighter(atifotav.add(0, 0, 1))) {
                                    return new Scaffold3(atifotav.add(0, 0, 1), EnumFacing.NORTH);
                                 } else if (fayomabo._lighter(atifotav.add(0, 0, -1))) {
                                    return new Scaffold3(atifotav.add(0, 0, -1), EnumFacing.SOUTH);
                                 } else {
                                    Object uzanagam = atifotav.add(1, 0, 0);
                                    if (fayomabo._lighter(uzanagam.add(0, -1, 0))) {
                                       return new Scaffold3(uzanagam.add(0, -1, 0), EnumFacing.UP);
                                    } else if (fayomabo._lighter(uzanagam.add(-1, 0, 0))) {
                                       return new Scaffold3(uzanagam.add(-1, 0, 0), EnumFacing.EAST);
                                    } else if (fayomabo._lighter(uzanagam.add(1, 0, 0))) {
                                       return new Scaffold3(uzanagam.add(1, 0, 0), EnumFacing.WEST);
                                    } else if (fayomabo._lighter(uzanagam.add(0, 0, 1))) {
                                       return new Scaffold3(uzanagam.add(0, 0, 1), EnumFacing.NORTH);
                                    } else if (fayomabo._lighter(uzanagam.add(0, 0, -1))) {
                                       return new Scaffold3(uzanagam.add(0, 0, -1), EnumFacing.SOUTH);
                                    } else {
                                       Object nagedadi = atifotav.add(-1, 0, 0);
                                       if (fayomabo._lighter(nagedadi.add(0, -1, 0))) {
                                          return new Scaffold3(nagedadi.add(0, -1, 0), EnumFacing.UP);
                                       } else if (fayomabo._lighter(nagedadi.add(-1, 0, 0))) {
                                          return new Scaffold3(nagedadi.add(-1, 0, 0), EnumFacing.EAST);
                                       } else if (fayomabo._lighter(nagedadi.add(1, 0, 0))) {
                                          return new Scaffold3(nagedadi.add(1, 0, 0), EnumFacing.WEST);
                                       } else if (fayomabo._lighter(nagedadi.add(0, 0, 1))) {
                                          return new Scaffold3(nagedadi.add(0, 0, 1), EnumFacing.NORTH);
                                       } else if (fayomabo._lighter(nagedadi.add(0, 0, -1))) {
                                          return new Scaffold3(nagedadi.add(0, 0, -1), EnumFacing.SOUTH);
                                       } else {
                                          Object abecoful = atifotav.add(0, 0, 1);
                                          if (fayomabo._lighter(abecoful.add(0, -1, 0))) {
                                             return new Scaffold3(abecoful.add(0, -1, 0), EnumFacing.UP);
                                          } else if (fayomabo._lighter(abecoful.add(-1, 0, 0))) {
                                             return new Scaffold3(abecoful.add(-1, 0, 0), EnumFacing.EAST);
                                          } else if (fayomabo._lighter(abecoful.add(1, 0, 0))) {
                                             return new Scaffold3(abecoful.add(1, 0, 0), EnumFacing.WEST);
                                          } else if (fayomabo._lighter(abecoful.add(0, 0, 1))) {
                                             return new Scaffold3(abecoful.add(0, 0, 1), EnumFacing.NORTH);
                                          } else if (fayomabo._lighter(abecoful.add(0, 0, -1))) {
                                             return new Scaffold3(abecoful.add(0, 0, -1), EnumFacing.SOUTH);
                                          } else {
                                             Object abifuvob = atifotav.add(0, 0, -1);
                                             if (fayomabo._lighter(abifuvob.add(0, -1, 0))) {
                                                return new Scaffold3(abifuvob.add(0, -1, 0), EnumFacing.UP);
                                             } else if (fayomabo._lighter(abifuvob.add(-1, 0, 0))) {
                                                return new Scaffold3(abifuvob.add(-1, 0, 0), EnumFacing.EAST);
                                             } else if (fayomabo._lighter(abifuvob.add(1, 0, 0))) {
                                                return new Scaffold3(abifuvob.add(1, 0, 0), EnumFacing.WEST);
                                             } else if (fayomabo._lighter(abifuvob.add(0, 0, 1))) {
                                                return new Scaffold3(abifuvob.add(0, 0, 1), EnumFacing.NORTH);
                                             } else {
                                                return fayomabo._lighter(abifuvob.add(0, 0, -1)) ? new Scaffold3(abifuvob.add(0, 0, -1), EnumFacing.SOUTH) : null;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static net.minecraft.util.Vec3 _segments(Scaffold3 suffer) {
      Object ribbon = Scaffold3._viking((Scaffold3)suffer);
      Object ethical = Scaffold3._narrow((Scaffold3)suffer);
      Object nursing = (double)ribbon.getX() + 0.5D;
      Object motel = (double)ribbon.getY() + 0.5D;
      double var7 = (double)ribbon.getZ() + 0.5D;
      if (ethical != EnumFacing.UP && ethical != EnumFacing.DOWN) {
         motel += 0.5D;
      } else {
         nursing += 0.3D;
         var7 += 0.3D;
      }

      if (ethical == EnumFacing.WEST || ethical == EnumFacing.EAST) {
         var7 += 0.15D;
      }

      if (ethical == EnumFacing.SOUTH || ethical == EnumFacing.NORTH) {
         nursing += 0.15D;
      }

      return new net.minecraft.util.Vec3(nursing, motel, var7);
   }

   public boolean _lighter(BlockPos medal) {
      Object formula = bloggers.mc.theWorld.getBlockState((BlockPos)medal).getBlock();
      return (formula.getMaterial().isSolid() || !formula.isTranslucent() || formula.isVisuallyOpaque() || formula instanceof BlockLadder || formula instanceof BlockCarpet || formula instanceof BlockSnow || formula instanceof BlockSkull) && !formula.getMaterial().isLiquid() && !(formula instanceof BlockContainer);
   }

   public float _dress() {
      Object holland = nintendo.mc.thePlayer.rotationYaw;
      if (nintendo.mc.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         holland += 180.0F;
      }

      Object facility = 1.0F;
      if (nintendo.mc.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         facility = -0.5F;
      } else if (nintendo.mc.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         facility = 0.5F;
      }

      if (nintendo.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         holland -= 90.0F * facility;
      }

      if (nintendo.mc.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         holland += 90.0F * facility;
      }

      holland = (float)((double)holland * 0.017453292D);
      return holland;
   }

   public static double _images() {
      Object killing = new SecureRandom();
      Object paypal = killing.nextDouble() * (1.0D / (double)System.currentTimeMillis());

      for(int var3 = 0; var3 < MathUtil._samuel(MathUtil._samuel(4, 6), MathUtil._samuel(8, 20)); ++var3) {
         paypal *= 1.0D / (double)System.currentTimeMillis();
      }

      return paypal;
   }

   public double[] _requires(float prime, double features) {
      return new double[]{(double)(-MathHelper.sin((float)prime)) * features, (double)MathHelper.cos((float)prime) * features};
   }
}
