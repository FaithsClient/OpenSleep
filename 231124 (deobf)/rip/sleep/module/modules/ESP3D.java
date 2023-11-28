package rip.sleep.module.modules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import rip.sleep.injection.in.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RenderUtilK;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class ESP3D extends Module {
   public static BooleanValue c61543 = new BooleanValue("Invisible", false);
   public static BooleanValue c36993 = new BooleanValue("Player", true);
   public static BooleanValue c78312 = new BooleanValue("Mob", false);
   private final Map<EntityLivingBase, double[]> c5073 = new HashMap();

   public ESP3D() {
      super("ESP 3D", new String[]{"ESP3D"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   public static int c32622(Entity var0) {
      Value.c27574();
      int var2 = 16777215;
      if (var0 instanceof EntityPlayer) {
         ScorePlayerTeam var3 = (ScorePlayerTeam)((EntityPlayer)var0).getTeam();
         if (var3 != null) {
            String var4 = FontRenderer.getFormatFromString(var3.getColorPrefix());
            if (var4.length() >= 2) {
               if (!"0123456789abcdef".contains(String.valueOf(var4.charAt(1)))) {
                  return var2;
               }

               var2 = Minecraft.getMinecraft().fontRendererObj.getColorCode(var4.charAt(1));
            }
         }
      }

      return var2;
   }

   @EventTarget
   void c69013(Render3DEvent var1) {
      Value.c27574();
      Iterator var3 = this.c41576().iterator();
      if (var3.hasNext()) {
         EntityLivingBase var4 = (EntityLivingBase)var3.next();
         if (!this.c84936(var4)) {
            ;
         }

         int var5 = c32622(var4);
         double var6 = var4.lastTickPosX + (var4.posX - var4.lastTickPosX) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
         double var8 = var4.lastTickPosY + (var4.posY - var4.lastTickPosY) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
         double var10 = var4.lastTickPosZ + (var4.posZ - var4.lastTickPosZ) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
         RenderUtilK.c32520(var6, var8, var10, 0.4D, var4.getEntityBoundingBox().maxY - var4.getEntityBoundingBox().minY + 0.3D, var5);
      }

   }

   public List<EntityLivingBase> c41576() {
      return Arrays.asList(mc.theWorld.loadedEntityList.stream().filter((var0) -> {
         return var0 instanceof EntityLivingBase;
      }).filter((var0) -> {
         return var0 != mc.thePlayer;
      }).map((var0) -> {
         return (EntityLivingBase)var0;
      }).toArray((var0) -> {
         return new EntityLivingBase[var0];
      }));
   }

   public boolean c84936(EntityLivingBase var1) {
      Module[] var2 = Value.c27574();
      if (var1 instanceof EntityPlayer && var1 == mc.thePlayer) {
         return false;
      } else if (var1 == null) {
         return false;
      } else if (!(var1 instanceof EntityWaterMob) && !(var1 instanceof EntityCreature) && !(var1 instanceof EntityAmbientCreature) && !(var1 instanceof EntityArmorStand) && !(var1 instanceof EntityGhast)) {
         if (var1.isInvisible()) {
            return c61543.c1473().booleanValue();
         } else if (var1 instanceof EntityPlayer) {
            return c36993.c1473().booleanValue();
         } else if (AntiBot.c13506(var1)) {
            return false;
         } else if (var1 instanceof EntitySlime) {
            return false;
         } else {
            return !var1.isDead && !var1.noClip;
         }
      } else {
         return c78312.c1473().booleanValue();
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
