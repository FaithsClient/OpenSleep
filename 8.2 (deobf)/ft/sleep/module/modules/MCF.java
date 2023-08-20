//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.color.ColorUtil;
import ft.sleep.util.player.PlayerUtils;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Mouse;

public class MCF extends Module {
   public boolean wanting$;
   public TextValue players$ = new TextValue("Add Name", "");
   public static Option amongst$ = new Option("Add", false);
   public static Option lists$ = new Option("Del", false);

   public MCF() {
      super("Friends", new String[]{"middleclickfriends", "middleclick"}, ModuleType.Player);
      floyd._piece((new Color(241, 175, 67)).getRGB());
   }

   @EventHandler
   public void _grounds(EventPreUpdate ecilazef) {
      if (lists$.getValue().booleanValue() && betozepe.players$.getValue() != null && Client.surround$.î ?().friendsConfig.isFriend((String)betozepe.players$.getValue())) {
         Client.surround$.î ?().friendsConfig.removeFriend((String)betozepe.players$.getValue());
         PlayerUtils._snake("del " + (String)betozepe.players$.getValue());
         Client.surround$.î ?().saveConfig(Client.surround$.î ?().friendsConfig);
         betozepe.players$.setValue("");
         lists$.setValue(Boolean.valueOf(false));
      }

      if (amongst$.getValue().booleanValue() && betozepe.players$.getValue() != null && !Client.surround$.î ?().friendsConfig.isFriend((String)betozepe.players$.getValue())) {
         Client.surround$.î ?().friendsConfig.addFriend((String)betozepe.players$.getValue());
         PlayerUtils._snake("add " + (String)betozepe.players$.getValue());
         Client.surround$.î ?().saveConfig(Client.surround$.î ?().friendsConfig);
         betozepe.players$.setValue("");
         amongst$.setValue(Boolean.valueOf(false));
      }

      if (betozepe.mc.currentScreen == null) {
         if (!betozepe.wanting$ && Mouse.isButtonDown(2)) {
            Object sepigina = betozepe.mc.objectMouseOver.entityHit;
            EntityPlayer var3 = (EntityPlayer)betozepe.mc.objectMouseOver.entityHit;
            String var4 = ColorUtil._attacked(var3.getName());
            if (Client.surround$.î ?().friendsConfig.isFriend(var4)) {
               Client.surround$.î ?().friendsConfig.removeFriend(var4);
               PlayerUtils._snake("remove " + var4);
               Client.surround$.î ?().saveConfig(Client.surround$.î ?().friendsConfig);
            } else {
               Client.surround$.î ?().friendsConfig.addFriend(var4);
               PlayerUtils._snake("add " + var4);
               Client.surround$.î ?().saveConfig(Client.surround$.î ?().friendsConfig);
            }
         }

         betozepe.wanting$ = Mouse.isButtonDown(2);
      }
   }
}
