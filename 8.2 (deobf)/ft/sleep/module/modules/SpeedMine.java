//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventDamageBlock;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class SpeedMine extends Module {
   public Mode phrases$ = new Mode("Mode", new String[]{"FastPacket", "Packet"}, "FastPacket");
   public Numbers joseph$ = new Numbers("ft.sleep.module.modules.SpeedMine", 1.4D, Double.longBitsToDouble(0L), 3.0D, 0.05D);
   public boolean roland$ = true;
   public boolean guided$ = true;
   public boolean middle$ = false;
   public float eastern$ = Float.intBitsToFloat(0);
   public BlockPos agents$;
   public EnumFacing moment$;
   public C07PacketPlayerDigging officers$;

   public SpeedMine() {
      super("ft.sleep.module.modules.SpeedMine", new String[]{"ft.sleep.module.modules.SpeedMine", "fastmine"}, ModuleType.updates$);
   }

   public void _regime() {
   }

   @EventHandler
   public void _pledge(EventPacketSend derived) {
      if (Objects.equals(acquire.phrases$.getValue(), "Packet") && EventPacketSend.packet instanceof C07PacketPlayerDigging && EventPacketSend.getPacket() != acquire.officers$ && !acquire.mc.playerController.extendedReach() && acquire.mc.playerController != null) {
         C07PacketPlayerDigging var2 = (C07PacketPlayerDigging)EventPacketSend.packet;
         if (var2.getStatus() == Action.START_DESTROY_BLOCK) {
            acquire.middle$ = true;
            acquire.agents$ = var2.getPosition();
            acquire.moment$ = var2.getFacing();
            acquire.eastern$ = Float.intBitsToFloat(0);
         } else if (var2.getStatus() == Action.ABORT_DESTROY_BLOCK || var2.getStatus() == Action.STOP_DESTROY_BLOCK) {
            acquire.middle$ = false;
            acquire.agents$ = null;
            acquire.moment$ = null;
         }
      }

   }

   @EventHandler
   public void _fleece(EventDamageBlock bodies) {
      if (Objects.equals(swingers.phrases$.getValue(), "FastPacket")) {
         Object circuits = swingers.mc.theWorld.getBlockState(((EventDamageBlock)bodies).getPos()).getBlock();
         Object married = Block.getIdFromBlock(circuits);
         swingers.mc.playerController.blockHitDelay = 0;
         if (married != 7) {
            PacketUtils._payroll(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, ((EventDamageBlock)bodies).getPos(), ((EventDamageBlock)bodies).getFac()));
            PacketUtils._payroll(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, ((EventDamageBlock)bodies).getPos(), ((EventDamageBlock)bodies).getFac()));
         }
      }

   }

   @EventHandler
   public void _offense(EventUpdate juvenile) {
      tomatoes._infants(tomatoes.phrases$.getValue());
      if (Objects.equals(tomatoes.phrases$.getValue(), "Packet")) {
         if (tomatoes.mc.playerController.extendedReach()) {
            tomatoes.mc.playerController.blockHitDelay = 0;
         } else if (tomatoes.middle$) {
            Object number = tomatoes.mc.theWorld.getBlockState(tomatoes.agents$).getBlock();
            int var3 = Block.getIdFromBlock(number);
            tomatoes.eastern$ = (float)((double)tomatoes.eastern$ + (double)number.getPlayerRelativeBlockHardness(tomatoes.mc.thePlayer, tomatoes.mc.theWorld, tomatoes.agents$) * (double)tomatoes.joseph$.getValue().floatValue());
            if (tomatoes.eastern$ >= 1.0F) {
               tomatoes.mc.theWorld.setBlockState(tomatoes.agents$, Blocks.air.getDefaultState(), 11);
               C07PacketPlayerDigging var4 = new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, tomatoes.agents$, tomatoes.moment$);
               tomatoes.officers$ = var4;
               PacketUtils._gratis(var4);
               tomatoes.eastern$ = Float.intBitsToFloat(0);
               tomatoes.middle$ = false;
            }
         }
      }

   }
}
