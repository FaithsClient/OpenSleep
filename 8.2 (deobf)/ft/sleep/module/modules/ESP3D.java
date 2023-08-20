//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IRenderManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.render.WorldRenderUtils;
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

public class ESP3D extends Module {
   public static Option setting$ = new Option("Invisible", false);
   public static Option slave$ = new Option("Player", true);
   public static Option vermont$ = new Option("Mob", false);
   public Map specify$ = new HashMap();

   public ESP3D() {
      super("ft.sleep.module.modules.ESP3D", new String[]{"ft.sleep.module.modules.ESP3D"}, ModuleType.ignored$);
   }

   public static int _wagner(Entity focus) {
      Object define = 16777215;
      if (focus instanceof EntityPlayer) {
         Object almost = (ScorePlayerTeam)((EntityPlayer)focus).getTeam();
         if (almost != null) {
            Object feeling = FontRenderer.getFormatFromString(almost.getColorPrefix());
            if (feeling.length() >= 2) {
               if (!"0123456789abcdef".contains(String.valueOf(feeling.charAt(1)))) {
                  return define;
               }

               define = Minecraft.getMinecraft().fontRendererObj.getColorCode(feeling.charAt(1));
            }
         }
      }

      return define;
   }

   @EventHandler
   public void _berkeley(EventRender3D inefabis) {
      for(Object gozacuge : sabiduye._request()) {
         if (sabiduye._circular(gozacuge)) {
            Object cudasoso = _wagner(gozacuge);
            Object megofazo = gozacuge.lastTickPosX + (gozacuge.posX - gozacuge.lastTickPosX) * (double)((EventRender3D)inefabis).getPartialTicks() - ((IRenderManager)sabiduye.mc.getRenderManager()).getRenderPosX();
            Object nasegazu = gozacuge.lastTickPosY + (gozacuge.posY - gozacuge.lastTickPosY) * (double)((EventRender3D)inefabis).getPartialTicks() - ((IRenderManager)sabiduye.mc.getRenderManager()).getRenderPosY();
            double var9 = gozacuge.lastTickPosZ + (gozacuge.posZ - gozacuge.lastTickPosZ) * (double)((EventRender3D)inefabis).getPartialTicks() - ((IRenderManager)sabiduye.mc.getRenderManager()).getRenderPosZ();
            WorldRenderUtils._revenues(megofazo, nasegazu, var9, 0.4D, gozacuge.getEntityBoundingBox().maxY - gozacuge.getEntityBoundingBox().minY + 0.3D, cudasoso);
         }
      }

   }

   public List _request() {
      return Arrays.asList(yebetito.mc.theWorld.loadedEntityList.stream().filter(ESP3D::_msgid).filter(yebetito::_theft).map(ESP3D::_loads).toArray(ESP3D::_succeed));
   }

   public boolean _circular(EntityLivingBase zibapica) {
      if (zibapica instanceof EntityPlayer && zibapica == eliluves.mc.thePlayer) {
         return false;
      } else if (zibapica == null) {
         return false;
      } else if (!(zibapica instanceof EntityWaterMob) && !(zibapica instanceof EntityCreature) && !(zibapica instanceof EntityAmbientCreature) && !(zibapica instanceof EntityArmorStand) && !(zibapica instanceof EntityGhast)) {
         if (((EntityLivingBase)zibapica).isInvisible()) {
            return setting$.getValue().booleanValue();
         } else if (zibapica instanceof EntityPlayer) {
            return slave$.getValue().booleanValue();
         } else if (AntiBot._remind((Entity)zibapica)) {
            return false;
         } else if (zibapica instanceof EntitySlime) {
            return false;
         } else {
            return !((EntityLivingBase)zibapica).isDead && !((EntityLivingBase)zibapica).noClip;
         }
      } else {
         return vermont$.getValue().booleanValue();
      }
   }

   public static EntityLivingBase[] _succeed(int advanced) {
      return new EntityLivingBase[advanced];
   }

   public static EntityLivingBase _loads(Entity osarover) {
      return (EntityLivingBase)osarover;
   }

   public boolean _theft(Entity reserves) {
      return reserves != justice.mc.thePlayer;
   }

   public static boolean _msgid(Entity realized) {
      return realized instanceof EntityLivingBase;
   }
}
