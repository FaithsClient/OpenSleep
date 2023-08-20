//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class AutoTool extends Module {
   public Option panama$ = new Option("Sword-Swap", false);
   public Option devel$ = new Option("Hold-Check", false);
   public static Option montana$ = new Option("Auto-Pick", false);

   public AutoTool() {
      super("ft.sleep.module.modules.AutoTool", new String[]{"ft.sleep.module.modules.AutoTool"}, ModuleType.Player);
      super._bosnia(true);
   }

   public Entity _merge(double dapidipe) {
      Object inigofub = null;
      Object evapemog = (double)dapidipe;

      for(Entity var7 : icecesur.mc.theWorld.loadedEntityList) {
         if (icecesur.mc.thePlayer.onGround && icecesur.mc.thePlayer.isCollidedVertically && var7 instanceof EntityItem) {
            double var8 = (double)icecesur.mc.thePlayer.getDistanceToEntity(var7);
            if (var8 <= evapemog) {
               evapemog = var8;
               inigofub = var7;
            }
         }
      }

      return inigofub;
   }

   @EventHandler
   public void _zshops(EventPacketSend curve) {
      if (EventPacketSend.getPacket() instanceof C02PacketUseEntity && ((C02PacketUseEntity)EventPacketSend.getPacket()).getAction().equals(Action.ATTACK)) {
         Object cabin = !lunch.mc.thePlayer.isEating();
         if (cabin && lunch.panama$.getValue().booleanValue()) {
            lunch._hence();
         }
      }

      if (EventPacketSend.getPacket() instanceof C07PacketPlayerDigging) {
         Object var4 = (C07PacketPlayerDigging)EventPacketSend.getPacket();
         if (var4.getStatus() == net.minecraft.network.play.client.C07PacketPlayerDigging.Action.START_DESTROY_BLOCK && (lunch.mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK || !lunch.devel$.getValue().booleanValue()) && !lunch.mc.thePlayer.capabilities.isCreativeMode) {
            BlockPos var3 = lunch.devel$.getValue().booleanValue() ? lunch.mc.objectMouseOver.getBlockPos() : var4.getPosition();
            if (var3 != null || !lunch.devel$.getValue().booleanValue()) {
               lunch.mc.thePlayer.inventory.currentItem = lunch._xanax(var3);
               lunch.mc.playerController.updateController();
            }
         }
      }

   }

   public void _hence() {
      Object esafevir = 0;
      Object ebisogef = -1.0D;

      for(Object ugosezay = 36; ugosezay < 45; ++ugosezay) {
         if (azuzomuv.mc.thePlayer.inventoryContainer.inventorySlots.toArray()[ugosezay] != null) {
            Object aledomiy = azuzomuv.mc.thePlayer.inventoryContainer.getSlot(ugosezay).getStack();
            if (aledomiy != null && aledomiy.getItem() instanceof ItemSword) {
               double var6 = ((AttributeModifier)aledomiy.getAttributeModifiers().get("generic.attackDamage").toArray()[0]).getAmount() + (double) InvUtils._sorted(aledomiy, Enchantment.sharpness) * 1.25D + (double) InvUtils._sorted(aledomiy, Enchantment.fireAspect);
               if (var6 > ebisogef) {
                  esafevir = ugosezay - 36;
                  ebisogef = var6;
               }
            }
         }
      }

      if (ebisogef > -1.0D) {
         azuzomuv.mc.thePlayer.inventory.currentItem = esafevir;
         azuzomuv.mc.playerController.updateController();
      }

   }

   public int _again(Item cattle) {
      Object pasta = 0;
      Object roger = -1;

      for(Object clouds = 36; clouds < 45; ++clouds) {
         Object medicaid = venture.mc.thePlayer.inventoryContainer.getSlot(clouds).getStack();
         if (medicaid != null && medicaid.getItem() == cattle) {
            Object vessel = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, medicaid);
            if (vessel > pasta) {
               pasta = vessel;
               roger = clouds - 36;
            }
         }
      }

      if (roger >= 0) {
         return roger;
      } else {
         return -1;
      }
   }

   public int _xanax(BlockPos yesucezo) {
      Object imosumar = buzobinu.mc.theWorld.getBlockState((BlockPos)yesucezo).getBlock();
      Object mozoyuyo = 0;
      Object cozurifi = 0.1F;

      for(Object fisepusu = 36; fisepusu < 45; ++fisepusu) {
         Object faruleru = buzobinu.mc.thePlayer.inventoryContainer.getSlot(fisepusu).getStack();
         if (faruleru != null && imosumar != null && faruleru.getItem().getStrVsBlock(faruleru, imosumar) > cozurifi) {
            mozoyuyo = fisepusu - 36;
            cozurifi = faruleru.getItem().getStrVsBlock(faruleru, imosumar);
         }
      }

      if (buzobinu._again(Items.stone_pickaxe) != -1 && (buzobinu.mc.theWorld.getBlockState(buzobinu.mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.coal_ore || buzobinu.mc.theWorld.getBlockState(buzobinu.mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.lapis_ore || buzobinu.mc.theWorld.getBlockState(buzobinu.mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.iron_ore || buzobinu.mc.theWorld.getBlockState(buzobinu.mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.stone)) {
         mozoyuyo = buzobinu._again(Items.stone_pickaxe);
         if ((float)mozoyuyo > 0.1F) {
            return mozoyuyo;
         }
      } else if (cozurifi > 0.1F) {
         return mozoyuyo;
      }

      return buzobinu.mc.thePlayer.inventory.currentItem;
   }
}
