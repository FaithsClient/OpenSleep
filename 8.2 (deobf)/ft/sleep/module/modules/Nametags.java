//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IRenderManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Nametags extends Module {
   public Mode society$ = new Mode("Font Mode", new String[]{"ft.sleep.util.other.Client", "Vanilla"}, "Vanilla");
   public Mode worker$ = new Mode("Health Mode", new String[]{"Bar", "Value"}, "Value");
   public static Numbers widely$ = new Numbers("Scale", 2.0D, Double.longBitsToDouble(0L), 5.0D, 0.1D);
   public static Numbers hobbies$ = new Numbers("Alpha", 70.0D, Double.longBitsToDouble(0L), 255.0D, 1.0D);
   public static Numbers settled$ = new Numbers("Distance", 256.0D, 4.0D, 256.0D, 1.0D);
   public static Option thunder$ = new Option("Range", true);
   public static Option afraid$ = new Option("Armor", true);
   public static Option pants$ = new Option("Background", true);
   public static Option unlock$ = new Option("Head", true);
   public static Option examined$ = new Option("Outline", false);
   public static Option scoring$ = new Option("Health", true);
   public static Option alerts$ = new Option("Low ft.sleep.module.modules.Teams", true);
   public static Option scout$ = new Option("Low ft.sleep.module.modules.Target", true);
   public List tried$ = new CopyOnWriteArrayList();
   public Pattern writers$ = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public Nametags() {
      super("NameTags", new String[]{"tags"}, ModuleType.ignored$);
   }

   public void _discs() {
      icoyebob.tried$.clear();
   }

   public Nametags2 _focused(EntityLivingBase gudebato) {
      return (Nametags2)etazisiz.tried$.stream().filter(Nametags::_costumes).findFirst().orElse((Object)null);
   }

   @EventHandler
   public void _other(EventRender2D var1) {
      donors.tried$.forEach(Nametags2::_coding);
   }

   @EventHandler
   public void _avoiding(EventRender3D reason) {
      Stream var10000 = Minecraft.getMinecraft().theWorld.getLoadedEntityList().stream();
      EntityPlayer.class.getClass();
      var10000 = var10000.filter(EntityPlayer.class::isInstance).filter(Nametags::_boxes).filter(Entity::isEntityAlive);
      EntityLivingBase.class.getClass();
      var10000.map(EntityLivingBase.class::cast).filter(checkout::_submit).forEach(checkout::_field);
      checkout.tried$.forEach(checkout::_puzzle);
   }

   public List _styles() {
      return porocinu.tried$;
   }

   public String _resume(String idosugaf) {
      return irobumod.writers$.matcher((CharSequence)idosugaf).replaceAll("");
   }

   public void _lebanon(String traveler, float sullivan, float prepaid, int pressure) {
      sandwich.mc.fontRendererObj.drawString(sandwich._resume((String)traveler), sullivan - 0.5F, (float)prepaid, 0, false);
      sandwich.mc.fontRendererObj.drawString(sandwich._resume((String)traveler), sullivan + 0.5F, (float)prepaid, 0, false);
      sandwich.mc.fontRendererObj.drawString(sandwich._resume((String)traveler), (float)sullivan, prepaid - 0.5F, 0, false);
      sandwich.mc.fontRendererObj.drawString(sandwich._resume((String)traveler), (float)sullivan, prepaid + 0.5F, 0, false);
      sandwich.mc.fontRendererObj.drawString((String)traveler, (float)sullivan, (float)prepaid, (int)pressure, false);
   }

   public void _puzzle(EventRender3D bibamuli, Nametags2 otelalev) {
      if (!Nametags2._nvidia((Nametags2)otelalev).isEntityAlive() || Minecraft.getMinecraft().thePlayer.getDistanceToEntity(Nametags2._nvidia((Nametags2)otelalev)) > (float)settled$.getValue().intValue()) {
         azideric.tried$.remove(otelalev);
      }

      if (!Minecraft.getMinecraft().theWorld.getLoadedEntityList().contains(Nametags2._nvidia((Nametags2)otelalev)) || Nametags2._nvidia((Nametags2)otelalev).getDisplayName().getFormattedText().contains("NPC") || Nametags2._nvidia((Nametags2)otelalev).getDisplayName().getUnformattedText().equalsIgnoreCase(Nametags2._nvidia((Nametags2)otelalev).getName())) {
         azideric.tried$.remove(otelalev);
      }

      Object obofufuf = (float)(Nametags2._nvidia((Nametags2)otelalev).lastTickPosX + (Nametags2._nvidia((Nametags2)otelalev).posX - Nametags2._nvidia((Nametags2)otelalev).lastTickPosX) * (double)((EventRender3D)bibamuli).getPartialTicks() - ((IRenderManager)azideric.mc.getRenderManager()).getRenderPosX());
      Object rimibiso = (float)(Nametags2._nvidia((Nametags2)otelalev).lastTickPosY + 2.3D + (Nametags2._nvidia((Nametags2)otelalev).posY + 2.3D - (Nametags2._nvidia((Nametags2)otelalev).lastTickPosY + 2.3D)) * (double)((EventRender3D)bibamuli).getPartialTicks() - ((IRenderManager)azideric.mc.getRenderManager()).getRenderPosY());
      Object iridepoz = (float)(Nametags2._nvidia((Nametags2)otelalev).lastTickPosZ + (Nametags2._nvidia((Nametags2)otelalev).posZ - Nametags2._nvidia((Nametags2)otelalev).lastTickPosZ) * (double)((EventRender3D)bibamuli).getPartialTicks() - ((IRenderManager)azideric.mc.getRenderManager()).getRenderPosZ());
      Nametags2._weeks((Nametags2)otelalev, Nametags2._events((Nametags2)otelalev, (double)obofufuf, (double)rimibiso, (double)iridepoz));
   }

   public void _field(EntityLivingBase epubabal) {
      bifubuco.tried$.add(new Nametags2(bifubuco, (EntityLivingBase)epubabal));
   }

   public boolean _submit(EntityLivingBase deteregi) {
      return !eneyemul.tried$.contains(eneyemul._focused((EntityLivingBase)deteregi));
   }

   public static boolean _boxes(Entity nayameli) {
      return !((Entity)nayameli).isInvisible();
   }

   public static boolean _costumes(EntityLivingBase ivory, Nametags2 movers) {
      return Nametags2._nvidia((Nametags2)movers).equals(ivory);
   }

   public static Mode _bishop(Nametags steps) {
      return ((Nametags)steps).worker$;
   }

   public static Mode _applies(Nametags uvenuviv) {
      return ((Nametags)uvenuviv).society$;
   }
}
