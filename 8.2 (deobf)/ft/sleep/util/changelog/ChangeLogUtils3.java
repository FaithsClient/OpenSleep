//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.changelog;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class ChangeLogUtils3 {
   public static List leslie$ = Arrays.asList(new ChangeLogUtils2("Sleep-5.9 Log <", ChangeLogUtils.estimate$), new ChangeLogUtils2("Fix Auto Tool", ChangeLogUtils.seafood$), new ChangeLogUtils2("Add Hit Delay Fix", ChangeLogUtils.strict$), new ChangeLogUtils2("Add Hurt Time ft.sleep.module.modules.NoSlow", ChangeLogUtils.strict$), new ChangeLogUtils2("Update ft.sleep.module.modules.KillAura Nice CPS", ChangeLogUtils.strict$), new ChangeLogUtils2("Update AntiVoid Need Test", ChangeLogUtils.seafood$), new ChangeLogUtils2("Update Astolfo ft.sleep.util.rotation.Rotation Pitch>", ChangeLogUtils.seafood$), new ChangeLogUtils2("Sleep-6.0 Log <", ChangeLogUtils.estimate$), new ChangeLogUtils2("Update ft.sleep.module.modules.Teams", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed AntiVoid", ChangeLogUtils.seafood$), new ChangeLogUtils2("Add ft.sleep.module.modules.NoSlow ft.sleep.module.modules.Blink", ChangeLogUtils.strict$), new ChangeLogUtils2("Update Hurt Time ft.sleep.module.modules.NoSlow", ChangeLogUtils.seafood$), new ChangeLogUtils2("Update ft.sleep.module.modules.LegitSpeed Bingus Mode>", ChangeLogUtils.seafood$), new ChangeLogUtils2("Sleep-6.1 Log <", ChangeLogUtils.strict$), new ChangeLogUtils2("Add ft.sleep.module.modules.NoSlow Bypass Full", ChangeLogUtils.estimate$), new ChangeLogUtils2("Sleep-7.1 Log <", ChangeLogUtils.estimate$), new ChangeLogUtils2("Add ft.sleep.module.modules.TargetHUD NeverLose", ChangeLogUtils.strict$), new ChangeLogUtils2("Add Inventory Move Packet", ChangeLogUtils.strict$), new ChangeLogUtils2("Add Bed Nuker", ChangeLogUtils.strict$), new ChangeLogUtils2("Fix ft.sleep.module.modules.ChestStealer", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fix ft.sleep.module.modules.Xray Packet FPS LOWWWWWWWWWW", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fix ft.sleep.module.modules.InvCleaner UHC", ChangeLogUtils.seafood$), new ChangeLogUtils2("Sleep-7.5 Log <", ChangeLogUtils.estimate$), new ChangeLogUtils2("Add ft.sleep.module.modules.UHCFind", ChangeLogUtils.strict$), new ChangeLogUtils2("Add ft.sleep.module.modules.HUD ft.sleep.util.other.Client Icon", ChangeLogUtils.strict$), new ChangeLogUtils2("Update ft.sleep.module.modules.KillAura", ChangeLogUtils.seafood$), new ChangeLogUtils2("Update ft.sleep.module.modules.HUD Display Name", ChangeLogUtils.seafood$), new ChangeLogUtils2("Add ft.sleep.module.modules.StaffAnalyser New Render", ChangeLogUtils.strict$), new ChangeLogUtils2("Add ft.sleep.module.modules.Xray Mine Block Delay", ChangeLogUtils.strict$), new ChangeLogUtils2("Add NameTags renderEnchantmentText", ChangeLogUtils.strict$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.HUD Astolfo Rect", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.Scaffold", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed 2DTags Remove Minecraft ft.sleep.module.modules.Tags", ChangeLogUtils.seafood$), new ChangeLogUtils2("Update ft.sleep.module.modules.TargetHUD Zeriy2", ChangeLogUtils.strict$), new ChangeLogUtils2("Update ft.sleep.module.modules.TargetHUD NeverLose", ChangeLogUtils.strict$), new ChangeLogUtils2("Add ft.sleep.util.angle.Velocity Hypixel (need test)", ChangeLogUtils.strict$), new ChangeLogUtils2("Add ft.sleep.module.modules.NoSlow Test", ChangeLogUtils.strict$), new ChangeLogUtils2("Add GuiMainMenu New Logo", ChangeLogUtils.strict$), new ChangeLogUtils2("Add Skywars Auto Queue", ChangeLogUtils.strict$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.WaterBucket", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.AimAssist Smooth!!!!!", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.AntiObbyTrap (Add Anti Sand Trap)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.Scaffold All (ft.sleep.module.modules.Sprint MoveTower)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.AutoClicker", ChangeLogUtils.seafood$), new ChangeLogUtils2("Sleep-8.1 Log <", ChangeLogUtils.estimate$), new ChangeLogUtils2("Update ft.sleep.module.modules.KillAura (Attack)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Recode ft.sleep.module.modules.Criticals (Watchdog)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Import ft.sleep.module.modules.KeepSprint (Tick Stop)", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.WaterBucket (Auto Pitch) Test", ChangeLogUtils.strict$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.AntiKB (Can SetValue)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.AntiObbyTrap (Obsidian)", ChangeLogUtils.seafood$), new ChangeLogUtils2("Import GhostHand (MWMOD Squad Pink)", ChangeLogUtils.strict$), new ChangeLogUtils2("Recode ft.sleep.module.modules.AntiFall (Watchdog) Test", ChangeLogUtils.seafood$), new ChangeLogUtils2("Recode ft.sleep.module.modules.LegitSpeed Bingus", ChangeLogUtils.seafood$), new ChangeLogUtils2("Import ft.sleep.module.modules.NoSlow (90Pitch Eat)", ChangeLogUtils.strict$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.NoSlow Watchdog Name Set Bingus", ChangeLogUtils.seafood$), new ChangeLogUtils2("Fixed ft.sleep.module.modules.NoSlow NCP Name Set Watchdog", ChangeLogUtils.seafood$), new ChangeLogUtils2("Import ft.sleep.module.modules.BedNuker (Need Test)", ChangeLogUtils.strict$), new ChangeLogUtils2("Recode ft.sleep.module.modules.InvCleaner CustomSlot", ChangeLogUtils.seafood$), new ChangeLogUtils2("Import ft.sleep.module.modules.Teams (Nick AutoTeam Only English)", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.AutoTool (AutoPick Stone Only switch StonePick)", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.AutoArmor (FakeInv Packet NoEvent)", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.Xray (5x5 ft.sleep.module.modules.Xray) need set Numbers", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.Nametags (Friends Render)", ChangeLogUtils.strict$), new ChangeLogUtils2("Import ft.sleep.module.modules.BowAimBot", ChangeLogUtils.strict$));

   public static void _adults() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("Changelog", 4.0F, 4.0F, (new Color(255, 255, 255, 200)).getRGB());
      GlStateManager.pushMatrix();
      GlStateManager.scale(0.5F, 0.5F, 0.5F);
      Minecraft.getMinecraft().fontRendererObj.drawString("Build #230501", 16.0F, 28.0F, (new Color(255, 255, 255, 180)).getRGB(), true);
      GlStateManager.popMatrix();
      Object website = 76;
      Object lloyd = 76;

      for(Object stays : leslie$) {
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5F, 0.5F, 0.5F);
         Minecraft.getMinecraft().fontRendererObj.drawString(stays.plugins$, 33.0F, (float)website * 0.5F + 1.0F, (new Color(0, 0, 0, 80)).getRGB(), false);
         Minecraft.getMinecraft().fontRendererObj.drawString(stays.plugins$, 32.0F, (float)website * 0.5F, (new Color(255, 255, 255, 180)).getRGB(), false);
         GlStateManager.popMatrix();
         website += 24;
      }

      for(Object var5 : leslie$) {
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5F, 0.5F, 0.5F);
         ft.sleep.ui.font.RenderUtil.drawRect(21.0D, (double)(((float)lloyd + 3.0F) * 0.5F), 26.0D, (double)(((float)lloyd + 4.0F) * 0.5F + 5.0F), var5.taxes$.warning$);
         GlStateManager.popMatrix();
         lloyd += 24;
      }

   }
}
