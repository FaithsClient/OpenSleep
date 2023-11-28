package rip.sleep.module.modules;

import rip.sleep.injection.in.IMixinMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.MouseUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class AutoClicker extends Module {
   public NumberValue<Number> c64659 = new NumberValue<Number>("Min CPS", 9.0D, 1.0D, 20.0D, 1.0D);
   public NumberValue<Number> c9568 = new NumberValue<Number>("Max CPS", 13.0D, 1.0D, 20.0D, 1.0D);
   public NumberValue<Number> c21715 = new NumberValue<Number>("Min BHPS", () -> {
      return c42435.c1473();
   }, 5.0D, 0.1D, 12.0D, 0.1D);
   public NumberValue<Number> c37816 = new NumberValue<Number>("Max BHPS", () -> {
      return c42435.c1473();
   }, 6.0D, 0.1D, 12.0D, 0.1D);
   private final NumberValue<Number> c79196 = new NumberValue<Number>("Jitter", 0.0D, 0.0D, 1.0D, 0.01D);
   public BooleanValue c60569 = new BooleanValue("With KillAura", false);
   public static BooleanValue c42435 = new BooleanValue("Block Hit", true);
   public BooleanValue c53740 = new BooleanValue("Break Blocks", true);
   public BooleanValue c48798 = new BooleanValue("No 1.8 Delay", false);
   public BooleanValue c98771 = new BooleanValue("Hand", false);
   public BooleanValue c34923 = new BooleanValue("Swords", true);
   public BooleanValue c98018 = new BooleanValue("Axes", false);
   public BooleanValue c68171 = new BooleanValue("Pickaxes", false);
   public BooleanValue c34074 = new BooleanValue("Shovels", false);
   private long c92329;
   private long c55558;
   private long c42097;
   private long c82483;
   private long c25500;
   private long c59436;
   private double c75264;
   private boolean c49507;
   private boolean c18429;

   public AutoClicker() {
      super("Auto Clicker", new String[]{"ac", "AutoClicker"}, ModuleType.c13050, ModuleType.c21190.c28329);
   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Value.c27574();
      this.c2159("CPS:" + this.c64659.c53968() + "-" + this.c9568.c53968());
      if (this.c64659.c53968().doubleValue() > this.c9568.c53968().doubleValue()) {
         this.c9568.c70375(Double.valueOf(this.c64659.c53968().doubleValue()));
      }

      if (this.c21715.c53968().doubleValue() > this.c37816.c53968().doubleValue()) {
         this.c37816.c70375(Double.valueOf(this.c21715.c53968().doubleValue()));
      }

      if (!mc.thePlayer.isUsingItem() || (mc.thePlayer.getHeldItem().getItem() == null || !(mc.thePlayer.getHeldItem().getItem() instanceof ItemFood)) && !(mc.thePlayer.getHeldItem().getItem() instanceof ItemPotion) && !(mc.thePlayer.getHeldItem().getItem() instanceof ItemBucketMilk) && !(mc.thePlayer.getHeldItem().getItem() instanceof ItemBow)) {
         if (mc.currentScreen == null && this.c61982()) {
            Mouse.poll();
            if (Mouse.isButtonDown(0) && (!this.c53740.c1473().booleanValue() || !mc.playerController.getIsHittingBlock())) {
               if ((double)this.c79196.c53968().floatValue() > 0.0D && c65742.nextDouble() > 0.65D) {
                  float var3 = this.c79196.c53968().floatValue() * 0.5F;
                  EntityPlayerSP var4 = mc.thePlayer;
                  if (c65742.nextBoolean()) {
                     float var5 = var4.rotationYaw += c65742.nextFloat() * var3;
                  }

                  float var6 = var4.rotationYaw -= c65742.nextFloat() * var3;
                  var4.rotationYaw = var6;
                  var4.rotationPitch = c65742.nextBoolean() ? (float)((double)var4.rotationPitch + (double)c65742.nextFloat() * (double)var3 * 0.75D) : (float)((double)var4.rotationPitch - (double)c65742.nextFloat() * (double)var3 * 0.75D);
               }

               label77: {
                  if (this.c55558 > 0L && this.c92329 > 0L) {
                     if (System.currentTimeMillis() > this.c55558) {
                        if (this.c48798.c1473().booleanValue()) {
                           ((IMixinMinecraft) mc).setClickCounter(0);
                        }

                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                        KeyBinding.onTick(mc.gameSettings.keyBindAttack.getKeyCode());
                        MouseUtil.c22690(new Object[]{Integer.valueOf(0), true});
                        this.c4972();
                     }

                     if (System.currentTimeMillis() > this.c92329) {
                        break label77;
                     }

                     KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                     MouseUtil.c22690(new Object[]{Integer.valueOf(0), false});
                  }

                  this.c4972();
               }

               if (c42435.c1473().booleanValue() && Mouse.isButtonDown(1)) {
                  if (this.c82483 <= 0L || this.c42097 <= 0L) {
                     return;
                  }

                  if (System.currentTimeMillis() > this.c82483) {
                     KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                     KeyBinding.onTick(mc.gameSettings.keyBindUseItem.getKeyCode());
                     MouseUtil.c22690(new Object[]{Integer.valueOf(1), true});
                     this.c48098();
                  }

                  if (System.currentTimeMillis() <= this.c42097) {
                     return;
                  }

                  KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                  MouseUtil.c22690(new Object[]{Integer.valueOf(1), false});
               }

               this.c48098();
            }

            this.c42097 = 0L;
            this.c82483 = 0L;
            this.c92329 = 0L;
            this.c55558 = 0L;
         }

      }
   }

   public boolean c77227() {
      Module[] var1 = Value.c27574();
      if (this.c53740.c1473().booleanValue() && mc.objectMouseOver != null) {
         BlockPos var2 = mc.objectMouseOver.getBlockPos();
         Block var3 = mc.theWorld.getBlockState(var2).getBlock();
         if (var3 != Blocks.air && !(var3 instanceof BlockLiquid)) {
            if (!this.c18429) {
               int var4 = mc.gameSettings.keyBindAttack.getKeyCode();
               KeyBinding.setKeyBindState(var4, true);
               KeyBinding.onTick(var4);
               this.c18429 = true;
            }

            return true;
         }

         if (this.c18429) {
            this.c18429 = false;
         }
      }

      return false;
   }

   public boolean c61982() {
      ItemStack var2 = mc.thePlayer.getHeldItem();
      Sleep.getInstance();
      Value.c27574();
      Sleep.c33759();
      if (ModuleManager.c25475(KillAura.class).c24622()) {
         return this.c60569.c1473().booleanValue();
      } else if (var2 == null) {
         return this.c98771.c1473().booleanValue();
      } else {
         if (var2 != null) {
            if (var2.getItem() instanceof ItemSword) {
               return this.c34923.c1473().booleanValue();
            }

            if (var2.getItem() instanceof ItemAxe) {
               return this.c98018.c1473().booleanValue();
            }

            if (var2.getItem() instanceof ItemPickaxe) {
               return this.c68171.c1473().booleanValue();
            }

            if (var2.getItem() instanceof ItemSpade) {
               return this.c34074.c1473().booleanValue();
            }
         }

         return false;
      }
   }

   public void c4972() {
      Value.c27574();
      long var2 = (long)((int)Math.round(this.c64659.c53968().doubleValue() + (this.c9568.c53968().doubleValue() - this.c64659.c53968().doubleValue()) * c65742.nextDouble()));
      long var4 = (long)((int)Math.round(1000.0D / (double)var2));
      if (System.currentTimeMillis() > this.c25500) {
         if (!this.c49507 && c65742.nextInt(100) >= 85) {
            this.c49507 = true;
            this.c75264 = 1.1D + c65742.nextDouble() * 0.15D;
         }

         this.c49507 = false;
         this.c25500 = System.currentTimeMillis() + 500L + (long)c65742.nextInt(1500);
      }

      if (this.c49507) {
         var4 *= (long)this.c75264;
      }

      if (System.currentTimeMillis() > this.c59436) {
         if (c65742.nextInt(100) >= 80) {
            var4 += 50L + (long)c65742.nextInt(150);
         }

         this.c59436 = System.currentTimeMillis() + 500L + (long)c65742.nextInt(1500);
      }

      this.c55558 = System.currentTimeMillis() + var4;
      this.c92329 = System.currentTimeMillis() + var4 / 2L - (long)c65742.nextInt(10);
   }

   private void c48098() {
      this.c82483 = System.currentTimeMillis() + (long)((int)Math.round(1000.0D / (this.c21715.c53968().doubleValue() + (this.c37816.c53968().doubleValue() - this.c21715.c53968().doubleValue()) * c65742.nextDouble())));
      this.c42097 = System.currentTimeMillis() + 20L + (long)c65742.nextInt(30);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
