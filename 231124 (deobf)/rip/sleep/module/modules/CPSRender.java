package rip.sleep.module.modules;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.AttackEntityEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class CPSRender extends Module {
   public static BooleanValue c3098 = new BooleanValue("Reset XY", false);
   private boolean c58476 = false;
   private boolean c89496 = false;
   private final Deque<Long> c71817 = new LinkedList();
   private final Deque<Long> c19157 = new LinkedList();
   private long c4604 = 0L;
   private String c97689 = "";
   public static int c45886 = 0;
   private int c49719 = 0;

   public CPSRender() {
      super("CPS Render", new String[]{"CPSRender"}, ModuleType.c12482, ModuleType.c21190.c94221);
      ScheduledExecutorService var1 = Executors.newSingleThreadScheduledExecutor();
      var1.scheduleAtFixedRate(this::c93970, 0L, 50L, TimeUnit.MILLISECONDS);
   }

   @EventTarget
   private void c14172(Render2DEventA var1) {
      Value.c27574();
      ScaledResolution var3 = new ScaledResolution(mc);
      if (c3098.c1473().booleanValue()) {
         c45886 = 0;
         this.c49719 = 0;
         this.c71817.clear();
         this.c19157.clear();
      }

      this.c632("", c45886 + " | " + this.c49719 + " CPS");
      if (System.currentTimeMillis() - this.c4604 > 2000L) {
         this.c97689 = "0.00 blocks";
      }

      if (HUD.c27960.c1473().booleanValue()) {
         int var4 = HUD.c34359.c65036(this.c97689) + 3;
         HUD.c34359.c17470(this.c97689, (double)((float)var3.getScaledWidth() / 2.0F - 25.5F), (double)((float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F - 22.0F)), HUD.c64734.c41161().intValue());
      }

      int var5 = mc.fontRendererObj.getStringWidth(this.c97689) + 3;
      mc.fontRendererObj.drawStringWithShadow(this.c97689, (float)var3.getScaledWidth() / 2.0F - 25.5F, (float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F - 22.0F), HUD.c64734.c41161().intValue());
   }

   private void c93970() {
      Value.c27574();
      long var2 = System.currentTimeMillis();
      if (!this.c71817.isEmpty() && var2 - ((Long)this.c71817.getFirst()).longValue() > 1000L) {
         this.c71817.pollFirst();
      }

      if (!this.c19157.isEmpty() && var2 - ((Long)this.c19157.getFirst()).longValue() > 1000L) {
         this.c19157.pollFirst();
      }

      c45886 = this.c71817.size();
      this.c49719 = this.c19157.size();
      this.c58476 = false;
      this.c89496 = false;
   }

   public void c15675() {
      this.c71817.addLast(Long.valueOf(System.currentTimeMillis()));
      this.c58476 = true;
   }

   public void c40554() {
      this.c19157.addLast(Long.valueOf(System.currentTimeMillis()));
      this.c89496 = true;
   }

   @EventTarget
   public void c59953(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && mc.theWorld != null) {
         if (PacketSendEvent.c81894() instanceof C0APacketAnimation && (mc.thePlayer.inventory.getCurrentItem() == null || !(mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBlock))) {
            this.c15675();
         }

         if (PacketSendEvent.c81894() instanceof C08PacketPlayerBlockPlacement) {
            this.c40554();
         }

      }
   }

   @EventTarget
   public void c48420(AttackEntityEvent var1) {
      Value.c27574();
      KillAura var3 = (KillAura) ModuleManager.c25475(KillAura.class);
      if (var3.c24622() && KillAura.c79073() != null) {
         boolean var9 = true;
      } else {
         boolean var10000 = false;
      }

      EntityLivingBase var5 = KillAura.c79073();
      Vec3 var6 = mc.getRenderViewEntity().getPositionEyes(1.0F);
      double var7 = mc.objectMouseOver.hitVec.distanceTo(var6);
      this.c97689 = (new DecimalFormat("#.##")).format(var7) + " blocks";
      this.c4604 = System.currentTimeMillis();
   }

   private void c632(String var1, String var2) {
      Value.c27574();
      int var4 = Integer.MIN_VALUE;
      int var5 = 16777215;
      ScaledResolution var6 = new ScaledResolution(mc);
      if (var1.equals("LMB") && this.c58476 || var1.equals("RMB") && this.c89496) {
         var4 = Color.WHITE.getRGB();
         var5 = 0;
      }

      if (HUD.c27960.c1473().booleanValue()) {
         HUD.c34359.c17470(var1, (double)((float)var6.getScaledWidth() / 2.0F - 50.0F), (double)((float)var6.getScaledHeight() - ((float)var6.getScaledHeight() / 2.0F + 30.0F) - 10.0F), HUD.c64734.c41161().intValue());
         HUD.c34359.c17470(var2, (double)((float)var6.getScaledWidth() / 2.0F - (c45886 >= 10 ? 22.5F : 20.0F)), (double)((float)var6.getScaledHeight() - ((float)var6.getScaledHeight() / 2.0F - 10.5F)), HUD.c64734.c41161().intValue());
      }

      mc.fontRendererObj.drawStringWithShadow(var1, (float)var6.getScaledWidth() / 2.0F - 50.0F, (float)var6.getScaledHeight() - ((float)var6.getScaledHeight() / 2.0F + 30.0F) - 10.0F, HUD.c64734.c41161().intValue());
      mc.fontRendererObj.drawStringWithShadow(var2, (float)var6.getScaledWidth() / 2.0F - (c45886 >= 10 ? 22.5F : 20.0F), (float)var6.getScaledHeight() - ((float)var6.getScaledHeight() / 2.0F - 10.5F), HUD.c64734.c41161().intValue());
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
