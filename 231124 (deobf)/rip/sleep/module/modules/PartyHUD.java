package rip.sleep.module.modules;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.module.Module;
import rip.sleep.util.MathUtilB;
import rip.sleep.util.ServerUtilA;
import rip.sleep.value.Value;
import rip.sleep.module.ModuleType;

public class PartyHUD extends Module {
   private static final HashMap<String, String> c24594 = new HashMap();
   private static final String c26526 = "The game starts in 1 second!";

   public PartyHUD() {
      super("Party HUD", new String[]{"PartyHUD"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   public void c71897() {
      super.c83205();
      c94996();
   }

   @SubscribeEvent
   public void c81874(NameFormat var1) {
      String var2 = (String)c24594.get(var1.username);
      var1.displayname = EnumChatFormatting.LIGHT_PURPLE + var2;
   }

   @SubscribeEvent
   public void c63177(ClientChatReceivedEvent var1) {
      Module[] var2 = Value.c27574();
      if (var1.type == 0) {
         String var3 = EnumChatFormatting.getTextWithoutFormattingCodes(var1.message.getUnformattedText());
         String var4 = var1.message.getFormattedText();
         if (var3.equals("The game starts in 1 second!")) {
            c6710();
         }
      }

   }

   @EventTarget
   public void c64612(Render2DEventA var1) {
      Value.c27574();
      ScaledResolution var3 = new ScaledResolution(mc);
      float var4 = (float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F + 245.0F);
      int var5 = HUD.c27960.c1473().booleanValue() ? HUD.c34359.c5657() + 3 : mc.fontRendererObj.FONT_HEIGHT + 3;
      ArrayList var6 = new ArrayList();
      Iterator var7 = mc.theWorld.getLoadedEntityList().iterator();
      if (var7.hasNext()) {
         Entity var8 = (Entity)var7.next();
         if (var8 instanceof EntityPlayer) {
            EntityPlayer var9 = (EntityPlayer)var8;
            if (!var9.isDead && !c24594.isEmpty()) {
               String var10 = c24594.keySet().toString();
               var10 = var10.substring(1, var10.length() - 1);
               String[] var11 = var10.split(",");
               int var13 = var11.length;
               int var14 = 0;
               if (var14 < var13) {
                  String var15 = var11[var14];
                  var15 = var15.trim();
                  if (var8.getName().contains(var15)) {
                     var6.add(var9);
                  }

                  ++var14;
               }
            }
         }
      }

      var6.sort(Comparator.comparingDouble((var0) -> {
         double var1 = var0.posX - mc.thePlayer.posX;
         double var3 = var0.posZ - mc.thePlayer.posZ;
         return var1 * var1 + var3 * var3;
      }));
      var7 = var6.iterator();
      if (var7.hasNext()) {
         EntityPlayer var43 = (EntityPlayer)var7.next();
         double var44 = var43.posX;
         double var46 = var43.posZ;
         double var47 = var44 - mc.thePlayer.posX;
         double var50 = var46 - mc.thePlayer.posZ;
         double var17 = Math.sqrt(var47 * var47 + var50 * var50);
         double var19 = mc.thePlayer.posY;
         double var21 = var43.posY;
         int var23 = (int)Math.round(var21 - var19);
         if (var23 > 0) {
            (new StringBuilder()).append("+").append(var23).toString();
         }

         if (var23 < 0) {
            (new StringBuilder()).append("-").append(Math.abs(var23)).toString();
         }

         String var24 = "0";
         String var25 = String.format(" %.1f m", var17);
         String var26 = var43.getDisplayName().getFormattedText();
         String var27 = " " + EnumChatFormatting.RED + MathUtilB.c98725((double)var43.getHealth(), 1) + EnumChatFormatting.LIGHT_PURPLE + var25 + EnumChatFormatting.RESET + EnumChatFormatting.GRAY + " " + var24;
         if (HUD.c27960.c1473().booleanValue()) {
            HUD.c34359.c17470(var26 + var27, (double)((float)var3.getScaledWidth() / 2.0F - 280.5F), (double)var4, -1);
         }

         mc.fontRendererObj.drawStringWithShadow(var26 + var27, (float)var3.getScaledWidth() / 2.0F - 280.5F, var4, -1);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var28 = (int)((float)var3.getScaledWidth() / 2.0F - 293.5F);
         int var29 = (int)var4;
         boolean var30 = true;
         GameProfile var31 = var43.getGameProfile();
         AbstractClientPlayer var32 = new AbstractClientPlayer(mc.theWorld, var31) {
         };
         ResourceLocation var33 = var32.getLocationSkin();
         mc.getTextureManager().bindTexture(var33);
         Gui.drawScaledCustomSizeModalRect(var28, var29, 8.0F, 8.0F, 8, 8, 9, 9, 64.0F, 64.0F);
         double var34 = Math.atan2(var50, var47);
         double var36 = Math.toDegrees(var34);
         var36 = (var36 + 360.0D) % 360.0D;
         var36 = var36 - (double) mc.thePlayer.rotationYaw;
         if (var36 < 0.0D) {
            var36 += 360.0D;
         }

         byte var38 = 10;
         int var39 = (int)((float)var3.getScaledWidth() / 2.0F - 280.5F + (float)(HUD.c27960.c1473().booleanValue() ? HUD.c34359.c65036(var26 + var27) + 4 : mc.fontRendererObj.getStringWidth(var26 + var27) + 4));
         float var40 = var4 + (float)(HUD.c27960.c1473().booleanValue() ? HUD.c34359.c5657() / 2 - var38 / 2 : mc.fontRendererObj.FONT_HEIGHT / 2 - var38 / 2);
         GL11.glPushMatrix();
         GL11.glBlendFunc(770, 771);
         GL11.glTranslatef((float)(var39 + var38 / 2), var40 + (float)(var38 / 2), 0.0F);
         GL11.glRotatef((float)var36 - 90.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef((float)(-var38 / 2), (float)(-var38 / 2), 0.0F);
         ResourceLocation var41 = new ResourceLocation("sleep/arroww.png");
         Minecraft.getMinecraft().getTextureManager().bindTexture(var41);
         Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var38, var38, (float)var38, (float)var38);
         GL11.glPopMatrix();
         float var10000 = var4 + (float)var5;
      }

   }

   public static void c63365(String var0) {
      c9430(var0, var0);
   }

   public static void c9430(String var0, String var1) {
      c24594.put(var0, var1);
   }

   public static void c15222(String var0) {
      c27243(var0, var0);
   }

   public static void c27243(String var0, String var1) {
      c24594.remove(var0, var1);
   }

   public static HashMap<String, String> c18878() {
      return c24594;
   }

   public static void c94996() {
      c24594.clear();
   }

   public static void c6710() {
      Module[] var0 = Value.c27574();
      if (ServerUtilA.c92750()) {
         List var1 = c11960();
         if (!var1.isEmpty()) {
            boolean var2 = false;
            HashMap var3 = new HashMap();
            Iterator var4 = var1.iterator();
            if (var4.hasNext()) {
               label37: {
                  String var5 = (String)var4.next();
                  if (var2) {
                     if (var5.contains("www.hypixel.net") || var5.contains("HAPPY HOUR!")) {
                        break label37;
                     }

                     if (var5.equals("")) {
                        ;
                     }

                     String var6 = var5.replace(" ", "");
                     String var7 = (String)c24594.get(var6);
                     if (var7 == null) {
                        var3.put(var6, var6);
                     }

                     var3.put(var6, var7);
                  }

                  if (var5.contains("Teammates:")) {
                     var2 = true;
                  }
               }
            }

            String var9 = Minecraft.getMinecraft().thePlayer.getName();
            String var10 = (String)c24594.get(var9);
            c24594.clear();
            c24594.putAll(var3);
            c9430(var9, var10);
            if (!c24594.isEmpty() && var10 == null) {
               c63365(var9);
            }

         }
      }
   }

   public static List<String> c11960() {
      return c3062(c46196());
   }

   public static List<String> c3062(List<String> var0) {
      Value.c27574();
      ArrayList var2 = new ArrayList();
      int var3 = 0;
      if (var3 < var0.size()) {
         var2.add(var3, EnumChatFormatting.getTextWithoutFormattingCodes((String)var0.get(var3)));
         ++var3;
      }

      return var2;
   }

   public static List<String> c46196() {
      Value.c27574();
      ArrayList var1 = new ArrayList();
      if (mc.theWorld == null) {
         return var1;
      } else {
         Scoreboard var2 = mc.theWorld.getScoreboard();
         return (List<String>)(var2 == null ? var1 : c39522(var2));
      }
   }

   public static List<String> c39522(Scoreboard var0) {
      Value.c27574();
      ArrayList var2 = new ArrayList();
      ScoreObjective var3 = var0.getObjectiveInDisplaySlot(1);
      return var2;
   }

   // $FF: synthetic method
   private static boolean c291(Score var0) {
      Module[] var1 = Value.c27574();
      return var0 != null && var0.getPlayerName() != null && !var0.getPlayerName().startsWith("#");
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
