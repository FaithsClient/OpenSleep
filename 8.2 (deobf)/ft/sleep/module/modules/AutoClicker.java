//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IMixinMinecraft;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import org.lwjgl.input.Mouse;

public class AutoClicker extends Module {
   public Numbers unsigned$ = new Numbers("Min CPS", 9.0D, 1.0D, 20.0D, 1.0D);
   public Numbers seminars$ = new Numbers("Max CPS", 13.0D, 1.0D, 20.0D, 1.0D);
   public Numbers mobile$ = new Numbers("Min BHPS", 5.0D, 0.1D, 12.0D, 0.1D);
   public Numbers acids$ = new Numbers("Max BHPS", 6.0D, 0.1D, 12.0D, 0.1D);
   public Numbers fitness$ = new Numbers("Jitter", Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 1.0D, 0.01D);
   public Option cases$ = new Option("With ft.sleep.module.modules.KillAura", false);
   public Option safety$ = new Option("Block Hit", true);
   public Option traffic$ = new Option("Break Blocks", true);
   public Option built$ = new Option("No 1.8 Delay", false);
   public Option klein$ = new Option("Hand", false);
   public Option summary$ = new Option("Swords", true);
   public Option olympics$ = new Option("Axes", false);
   public Option mouse$ = new Option("Pickaxes", false);
   public Option trees$ = new Option("Shovels", false);
   public long energy$;
   public long gamma$;
   public long guide$;
   public long within$;
   public long employer$;
   public long marker$;
   public double elvis$;
   public boolean filename$;
   public boolean waste$;

   public AutoClicker() {
      super("ft.sleep.module.modules.AutoClicker", new String[]{"ac", "ft.sleep.module.modules.AutoClicker"}, ModuleType.rolls$);
   }

   @EventHandler
   public void _spanking(EventTick povufunu) {
      epuvitur._infants("CPS:" + epuvitur.unsigned$.getValue() + "-" + epuvitur.seminars$.getValue());
      if (epuvitur.unsigned$.getValue().doubleValue() > epuvitur.seminars$.getValue().doubleValue()) {
         epuvitur.seminars$.setValue(Double.valueOf(epuvitur.unsigned$.getValue().doubleValue()));
      }

      if (epuvitur.mobile$.getValue().doubleValue() > epuvitur.acids$.getValue().doubleValue()) {
         epuvitur.acids$.setValue(Double.valueOf(epuvitur.mobile$.getValue().doubleValue()));
      }

      if (!epuvitur.mc.thePlayer.isUsingItem() || (epuvitur.mc.thePlayer.getHeldItem().getItem() == null || !(epuvitur.mc.thePlayer.getHeldItem().getItem() instanceof ItemFood)) && !(epuvitur.mc.thePlayer.getHeldItem().getItem() instanceof ItemPotion) && !(epuvitur.mc.thePlayer.getHeldItem().getItem() instanceof ItemBucketMilk) && !(epuvitur.mc.thePlayer.getHeldItem().getItem() instanceof ItemBow)) {
         if (epuvitur.mc.currentScreen == null && epuvitur._postal()) {
            Mouse.poll();
            if (Mouse.isButtonDown(0) && (!epuvitur.traffic$.getValue().booleanValue() || epuvitur.mc.playerController.getIsHittingBlock())) {
               if ((double)epuvitur.fitness$.getValue().floatValue() > Double.longBitsToDouble(0L) && î ?.nextDouble() > 0.65D) {
                  Object ovusenoz = epuvitur.fitness$.getValue().floatValue() * 0.5F;
                  Object fosogezi = epuvitur.mc.thePlayer;
                  float var4;
                  if (î ?.nextBoolean()) {
                     var4 = fosogezi.rotationYaw += î ?.nextFloat() * ovusenoz;
                  } else {
                     var4 = fosogezi.rotationYaw -= î ?.nextFloat() * ovusenoz;
                  }

                  fosogezi.rotationYaw = var4;
                  fosogezi.rotationPitch = î ?.nextBoolean() ? (float)((double)fosogezi.rotationPitch + (double)î ?.nextFloat() * (double)ovusenoz * 0.75D) : (float)((double)fosogezi.rotationPitch - (double)î ?.nextFloat() * (double)ovusenoz * 0.75D);
               }

               if (epuvitur.gamma$ > ((long)1900384959 ^ 1900384959L) && epuvitur.energy$ > ((long)-279217101 ^ -279217101L)) {
                  if (System.currentTimeMillis() > epuvitur.gamma$) {
                     if (epuvitur.built$.getValue().booleanValue()) {
                        ((IMixinMinecraft)epuvitur.mc).setClickCounter(0);
                     }

                     KeyBinding.setKeyBindState(epuvitur.mc.gameSettings.keyBindAttack.getKeyCode(), true);
                     KeyBinding.onTick(epuvitur.mc.gameSettings.keyBindAttack.getKeyCode());
                     MouseUtils._courts(new Object[]{Integer.valueOf(0), true});
                     epuvitur._demands();
                  }

                  if (System.currentTimeMillis() <= epuvitur.energy$) {
                     KeyBinding.setKeyBindState(epuvitur.mc.gameSettings.keyBindAttack.getKeyCode(), false);
                     MouseUtils._courts(new Object[]{Integer.valueOf(0), false});
                  }
               } else {
                  epuvitur._demands();
               }

               if (epuvitur.safety$.getValue().booleanValue() && Mouse.isButtonDown(1)) {
                  if (epuvitur.within$ > ((long)-1449946670 ^ -1449946670L) && epuvitur.guide$ > ((long)-1072344582 ^ -1072344582L)) {
                     if (System.currentTimeMillis() > epuvitur.within$) {
                        KeyBinding.setKeyBindState(epuvitur.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                        KeyBinding.onTick(epuvitur.mc.gameSettings.keyBindUseItem.getKeyCode());
                        MouseUtils._courts(new Object[]{Integer.valueOf(1), true});
                        epuvitur._drums();
                     }

                     if (System.currentTimeMillis() <= epuvitur.guide$) {
                        return;
                     }

                     KeyBinding.setKeyBindState(epuvitur.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                     MouseUtils._courts(new Object[]{Integer.valueOf(1), false});
                  }
               } else {
                  epuvitur._drums();
               }
            } else {
               epuvitur.guide$ = (long)-210400435 ^ -210400435L;
               epuvitur.within$ = (long)1267059060 ^ 1267059060L;
               epuvitur.energy$ = (long)1264516398 ^ 1264516398L;
               epuvitur.gamma$ = (long)-84459106 ^ -84459106L;
            }
         }

      }
   }

   public boolean _illinois() {
      if (unable.traffic$.getValue().booleanValue() && unable.mc.objectMouseOver != null) {
         Object triumph = unable.mc.objectMouseOver.getBlockPos();
         if (triumph != null) {
            Object utility = unable.mc.theWorld.getBlockState(triumph).getBlock();
            if (utility != Blocks.air && !(utility instanceof BlockLiquid)) {
               if (!unable.waste$) {
                  Object muslim = unable.mc.gameSettings.keyBindAttack.getKeyCode();
                  KeyBinding.setKeyBindState(muslim, true);
                  KeyBinding.onTick(muslim);
                  unable.waste$ = true;
               }

               return true;
            }

            if (unable.waste$) {
               unable.waste$ = false;
            }
         }
      }

      return false;
   }

   public boolean _postal() {
      Object books = entered.mc.thePlayer.getHeldItem();
      Client2.î ?();
      Client2.î ?();
      if (ModuleManager._herbs(KillAura.class)._central()) {
         return entered.cases$.getValue().booleanValue();
      } else if (books == null) {
         return entered.klein$.getValue().booleanValue();
      } else {
         if (books != null) {
            if (books.getItem() instanceof ItemSword) {
               return entered.summary$.getValue().booleanValue();
            }

            if (books.getItem() instanceof ItemAxe) {
               return entered.olympics$.getValue().booleanValue();
            }

            if (books.getItem() instanceof ItemPickaxe) {
               return entered.mouse$.getValue().booleanValue();
            }

            if (books.getItem() instanceof ItemSpade) {
               return entered.trees$.getValue().booleanValue();
            }
         }

         return true;
      }
   }

   public void _demands() {
      Object upututib = (long)((int)Math.round(idomebop.unsigned$.getValue().doubleValue() + (idomebop.seminars$.getValue().doubleValue() - idomebop.unsigned$.getValue().doubleValue()) * î ?.nextDouble()));
      long var3 = (long)((int)Math.round(1000.0D / (double)upututib));
      if (System.currentTimeMillis() > idomebop.employer$) {
         if (!idomebop.filename$ && î ?.nextInt(100) >= 85) {
            idomebop.filename$ = true;
            idomebop.elvis$ = 1.1D + î ?.nextDouble() * 0.15D;
         }

         idomebop.filename$ = false;
         idomebop.employer$ = System.currentTimeMillis() + ((long)1332452770 ^ 1332452438L) + (long)î ?.nextInt(1500);
      }

      if (idomebop.filename$) {
         var3 *= (long)idomebop.elvis$;
      }

      if (System.currentTimeMillis() > idomebop.marker$) {
         if (î ?.nextInt(100) >= 80) {
            var3 += ((long)1376571866 ^ 1376571880L) + (long)î ?.nextInt(150);
         }

         idomebop.marker$ = System.currentTimeMillis() + ((long)1016552699 ^ 1016552719L) + (long)î ?.nextInt(1500);
      }

      idomebop.gamma$ = System.currentTimeMillis() + var3;
      idomebop.energy$ = System.currentTimeMillis() + var3 / ((long)-816729653 ^ -816729655L) - (long)î ?.nextInt(10);
   }

   public void _drums() {
      asset.within$ = System.currentTimeMillis() + (long)((int)Math.round(1000.0D / (asset.mobile$.getValue().doubleValue() + (asset.acids$.getValue().doubleValue() - asset.mobile$.getValue().doubleValue()) * î ?.nextDouble())));
      asset.guide$ = System.currentTimeMillis() + ((long)1991442389 ^ 1991442369L) + (long)î ?.nextInt(30);
   }
}
