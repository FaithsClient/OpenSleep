//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import com.mojang.util.UUIDTypeAdapter;
import ft.sleep.Client;
import ft.sleep.alt.Account;
import ft.sleep.alt.AltCredential;
import ft.sleep.alt.Alts;
import ft.sleep.alt.auth.Auth3;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import ft.sleep.util.animation.Animation;
import ft.sleep.util.render.RenderUtil;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiAltManager extends GuiScreen {
   public Minecraft variety$ = Minecraft.getMinecraft();
   public float might$ = Float.MAX_VALUE;
   public float speaking$ = Float.intBitsToFloat(0);
   public float missions$;
   public Animation entered$ = new SmoothStepAnimation(0, Double.longBitsToDouble(0L), Direction.posted$);
   public float feeling$;
   public int mpegs$ = 65;
   public int contest$ = 70;
   public int fires$ = 0;
   public boolean dicke$;
   public boolean bolivia$;
   public boolean hobby$;
   public GuiTextField editions$;
   public PasswordTextField coffee$;
   public boolean suburban$;
   public boolean cohen$;
   public boolean employee$;
   public ArrayList grande$ = new ArrayList();
   public String adverse$;
   public long alabama$;

   public GuiAltManager() {
      Client.surround$.�?().loadConfig(Client.surround$.�?().altsConfig);
   }

   public void initGui() {
      Object ocidutag = new ScaledResolution(idugerar.variety$);
      idugerar.buttonList.add(new LoginButton(1, (int)((float)idugerar.mpegs$ * 1.3F), ocidutag.getScaledHeight() - 50, 10, 10, "Login"));
      idugerar.buttonList.add(new LoginButton(2, (int)((float)idugerar.mpegs$ * 1.3F) + 110 + 5, ocidutag.getScaledHeight() - 50, 10, 10, "Remove"));
      idugerar.buttonList.add(new LoginButton(3, (int)((float)idugerar.mpegs$ * 1.3F) + 235 + 5, ocidutag.getScaledHeight() - 50, 10, 10, "Add Alt"));
      idugerar.buttonList.add(new LoginButton(4, (int)((float)idugerar.mpegs$ * 1.3F) + 360 + 10, ocidutag.getScaledHeight() - 50, 10, 10, "Direct Login"));
      idugerar.buttonList.add(new LoginButton(5, (int)((float)idugerar.mpegs$ * 1.3F) + 510 + 10, ocidutag.getScaledHeight() - 50, 10, 10, "Microsoft Login", new ResourceLocation("sleep/alts/microsoft.png")));
      idugerar.buttonList.add(new LoginButton(6, (int)((float)idugerar.mpegs$ * 1.3F) + 695 + 15, ocidutag.getScaledHeight() - 50, 10, 10, "Cancel"));
      idugerar.editions$ = new TokenField(1, idugerar.variety$.fontRendererObj, ocidutag.getScaledWidth() / 2 - 65, ocidutag.getScaledHeight() / 2 - 86, 150, 20, "");
      idugerar.coffee$ = new PasswordTextField(2, idugerar.variety$.fontRendererObj, ocidutag.getScaledWidth() / 2 - 65, ocidutag.getScaledHeight() / 2 - 35 - 13, 150, 20, "");
      super.initGui();
   }

   public void actionPerformed(GuiButton bosnia) throws IOException {
      if (!pepper.dicke$ && !pepper.bolivia$) {
         if (((GuiButton)bosnia).id == 1 && pepper.�?() != null) {
            pepper.();
         }

         if (((GuiButton)bosnia).id == 2) {
            if (pepper.�?() != null) {
               pepper.grande$.add(new Logs("Remove Alt | name : " + pepper.�?().waiting$._modules(), "J", pepper.grande$.size()));
            }

            Client.surround$.�?().altsConfig.removeAccount(pepper.�?());
         }

         if (((GuiButton)bosnia).id == 3) {
            pepper.dicke$ = true;
         }

         if (((GuiButton)bosnia).id == 4) {
            pepper.bolivia$ = true;
         }

         if (((GuiButton)bosnia).id == 6) {
            pepper.variety$.displayGuiScreen((GuiScreen)null);
         }

         if (((GuiButton)bosnia).id == 5) {
            pepper.variety$.displayGuiScreen(new LoginScreen(pepper, "Microsoft Login", GuiAltManager::�?));
         }

      }
   }

   public void ___/* $FF was: �?*/(String necuzeva) {
      Desktop.getDesktop().browse(new URI((String)necuzeva));
   }

   public void updateScreen() {
      super.updateScreen();
   }

   public void drawScreen(int obazalaf, int moboluvi, float nipepema) {
      if (Client.surround$.�?().altsConfig.alts.size() != Client.surround$.�?().altsConfig.accounts.size()) {
         SharedIAS.negative$.warn("Bug size");
      }

      onaledar.();
      Object asupuzod = new ScaledResolution(onaledar.variety$);
      onaledar.drawBackground(0);
      FontLoaders.TahomaBold35.drawString("S" + EnumChatFormatting.WHITE + "leep", 10.0F, 10.0F, HUD.during$.getValue().intValue());
      RoundedUtil._ticket((float)(asupuzod.getScaledWidth() - 80), (float)(onaledar.contest$ - 59), (float)(FontLoaders.TahomaBold22.getStringWidth("Buy Tools") + 10), 20.0F, 1.0F, new Color(0, 0, 0, 100));
      FontLoaders.TahomaBold22.drawString("Buy Tools", (float)(asupuzod.getScaledWidth() - 75), (float)(onaledar.contest$ - 54), -1);
      GL11.glPushMatrix();
      RenderUtil._clone((double)onaledar.mpegs$, (double)onaledar.contest$, 825.0D, 320.0D);
      GL11.glEnable(3089);
      Object abicogiz = (double)onaledar.�?();

      for(Alts var8 : Client.surround$.�?().altsConfig.alts) {
         if (!onaledar.dicke$ && !onaledar.bolivia$) {
            var8._normally((int)obazalaf, (int)moboluvi);
            var8.garbage$ = (int) MathUtil._charms(abicogiz);
         }
      }

      onaledar.�?(120, (int)obazalaf, (int)moboluvi);
      onaledar.might$ = (float)Math.max(0, Client.surround$.�?().altsConfig.alts.size() < 4 ? 0 : ((Alts) Client.surround$.�?().altsConfig.alts.get(Client.surround$.�?().altsConfig.alts.size() - 1))._delivery() + 2);
      GL11.glDisable(3089);
      GL11.glPopMatrix();
      RoundedUtil._remote((float)(onaledar.mpegs$ - 60), (float)(onaledar.contest$ + 130), 40.0F, 40.0F, 1.0F, true, new Color(0, 0, 0, 100));
      FontLoaders.SF50.drawString("<", (float)(onaledar.mpegs$ - 47), (float)(onaledar.contest$ + 140), -1);
      RoundedUtil._remote((float)(asupuzod.getScaledWidth() - 50), (float)(onaledar.contest$ + 130), 40.0F, 40.0F, 1.0F, true, new Color(0, 0, 0, 100));
      onaledar.variety$.fontRendererObj.drawString("alts: (" + Client.surround$.�?().altsConfig.accounts.size() + ").", asupuzod.getScaledWidth() - 42 - onaledar.variety$.fontRendererObj.getStringWidth(Client.surround$.�?().altsConfig.accounts.size() + ""), onaledar.contest$ + 120, -1);
      FontLoaders.SF50.drawString(">", (float)(asupuzod.getScaledWidth() - 35), (float)(onaledar.contest$ + 140), -1);
      if (!onaledar.dicke$ && !onaledar.bolivia$) {
         onaledar.editions$.("");
         onaledar.coffee$.("");
      } else {
         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), 2.0F);
         RenderUtil._newman(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)asupuzod.getScaledWidth(), (double)asupuzod.getScaledHeight(), (new Color(0, 0, 0, 90)).getRGB());
         RoundedUtil._ticket((float)(asupuzod.getScaledWidth() / 2 - 70), (float)(asupuzod.getScaledHeight() / 2 - 140), 170.0F, 220.0F, 1.0F, new Color(0, 0, 0, 120));
         FontLoaders.TahomaBold24.drawString(onaledar.dicke$ && !onaledar.bolivia$ ? "Add Alt" : "Direct Login", (float)(asupuzod.getScaledWidth() / 2 - 65), (float)(asupuzod.getScaledHeight() / 2 - 135), -1);
         FontLoaders.TahomaBold22.drawString("Username / E-Mail", (float)(asupuzod.getScaledWidth() / 2 - 65), (float)(asupuzod.getScaledHeight() / 2 - 100), -1);
         onaledar.editions$.();
         FontLoaders.TahomaBold22.drawString("Password", (float)(asupuzod.getScaledWidth() / 2 - 65), (float)(asupuzod.getScaledHeight() / 2 - 62), -1);
         onaledar.coffee$.();
         RoundedUtil._ticket((float)(asupuzod.getScaledWidth() / 2 - 63), (float)(asupuzod.getScaledHeight() / 2 - 17), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontLoaders.TahomaBold22.drawString(onaledar.dicke$ && !onaledar.bolivia$ ? "Add" : "Login", onaledar.dicke$ && !onaledar.bolivia$ ? (float)(asupuzod.getScaledWidth() / 2 + 1) : (float)(asupuzod.getScaledWidth() / 2 - 3), (float)(asupuzod.getScaledHeight() / 2 - 11), -1);
         RoundedUtil._ticket((float)(asupuzod.getScaledWidth() / 2 - 63), (float)(asupuzod.getScaledHeight() / 2 + 22), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontLoaders.TahomaBold22.drawString("Import alt", (float)(asupuzod.getScaledWidth() / 2 - 13), (float)(asupuzod.getScaledHeight() / 2 + 28), -1);
         RoundedUtil._ticket((float)(asupuzod.getScaledWidth() / 2 - 63), (float)(asupuzod.getScaledHeight() / 2 + 47), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontLoaders.TahomaBold22.drawString("Back", (float)(asupuzod.getScaledWidth() / 2 - 2), (float)(asupuzod.getScaledHeight() / 2 + 53), -1);
         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), -2.0F);
      }

      RoundedUtil._ticket(100.0F, 5.0F, 180.0F, 55.0F, Float.intBitsToFloat(0), new Color(0, 0, 0, 100));
      FontLoaders.SF14.drawString("logs", 104.0F, 8.0F, -1);
      GL11.glPushMatrix();
      RenderUtil._clone(100.0D, 5.0D, 180.0D, 55.0D);
      GL11.glEnable(3089);

      for(Logs var14 : onaledar.grande$) {
         var14._sunrise();
      }

      GL11.glDisable(3089);
      GL11.glPopMatrix();
      if (onaledar.grande$.size() > 5) {
         onaledar.grande$.remove(onaledar.grande$.get(0));
         Object var11 = 0;

         for(Logs var9 : onaledar.grande$) {
            var9.supreme$ = var11++;
         }
      }

      for(Object var12 = 0; var12 < onaledar.buttonList.size(); ++var12) {
         if (!onaledar.dicke$ && !onaledar.bolivia$) {
            ((GuiButton)onaledar.buttonList.get(var12)).drawButton(onaledar.variety$, (int)obazalaf, (int)moboluvi);
         }
      }

      for(Object var13 = 0; var13 < onaledar.labelList.size(); ++var13) {
         if (!onaledar.dicke$ && !onaledar.bolivia$) {
            ((GuiLabel)onaledar.labelList.get(var13)).drawLabel(onaledar.variety$, (int)obazalaf, (int)moboluvi);
         }
      }

   }

   public void ____/* $FF was: */() {
      for(Object usepegac = 0; usepegac < Client.surround$.�?().altsConfig.alts.size(); ++usepegac) {
         if (!Client.surround$.�?().altsConfig.alts.isEmpty()) {
            ((Alts) Client.surround$.�?().altsConfig.alts.get(usepegac)).trail$ = usepegac;
         }
      }

   }

   public void _/* $FF was: �?*/(int abacaful, int falipuni, int lupilitu) {
      itatuzog.feeling$ = (float)((double)itatuzog.missions$ - itatuzog.entered$._bloggers());
      if (RenderUtil._become((float)itatuzog.mpegs$, (float)itatuzog.contest$, 825.0F, 320.0F, (int)falipuni, (int)lupilitu)) {
         itatuzog.missions$ += (float)Mouse.getDWheel() / 4.0F;
      }

      itatuzog.missions$ = Math.max(Math.min(itatuzog.speaking$, itatuzog.missions$), -itatuzog.might$);
      itatuzog.entered$ = new SmoothStepAnimation((int)abacaful, (double)(itatuzog.missions$ - itatuzog.feeling$), Direction.posted$);
   }

   public float ___/* $FF was: �?*/() {
      aduvaboc.feeling$ = (float)((double)aduvaboc.missions$ - aduvaboc.entered$._bloggers());
      return aduvaboc.feeling$;
   }

   public void mouseClicked(int isagoder, int tinabifi, int oyubafen) throws IOException {
      Object rerorula = new ScaledResolution(ipodigub.variety$);
      if (ipodigub.dicke$ || ipodigub.bolivia$) {
         if (RenderUtil._become((float)(rerorula.getScaledWidth() / 2 - 63), (float)(rerorula.getScaledHeight() / 2 + 47), 150.0F, 20.0F, (int)isagoder, (int)tinabifi)) {
            ipodigub.dicke$ = false;
            ipodigub.bolivia$ = false;
         }

         if (RenderUtil._become((float)(rerorula.getScaledWidth() / 2 - 63), (float)(rerorula.getScaledHeight() / 2 + 22), 150.0F, 20.0F, (int)isagoder, (int)tinabifi)) {
            Object dopaveci = ipodigub.�?();
            if (dopaveci == null) {
               return;
            }

            ipodigub.editions$.(dopaveci._annually());
            ipodigub.coffee$.(dopaveci._feeding());
         }

         if (RenderUtil._become((float)(rerorula.getScaledWidth() / 2 - 63), (float)(rerorula.getScaledHeight() / 2 - 17), 150.0F, 20.0F, (int)isagoder, (int)tinabifi)) {
            if (!ipodigub.bolivia$) {
               if (ipodigub.coffee$.�?().isEmpty()) {
                  Client.surround$.�?().altsConfig.addAccount(ipodigub.editions$.�?());
                  ipodigub.grande$.add(new Logs("Add Alt | Username: " + ipodigub.editions$.�?() + " - offline", "K", ipodigub.grande$.size()));
               }

               Client.surround$.�?().saveConfig(Client.surround$.�?().altsConfig);
               ipodigub.dicke$ = false;
            } else {
               Object var7 = new OfflineAccount(ipodigub.editions$.�?(), Auth3._palmer(ipodigub.editions$.�?()));
               var7._resident(ipodigub::�?).whenComplete(ipodigub::�?);
               Client.surround$.�?().saveConfig(Client.surround$.�?().altsConfig);
               ipodigub.bolivia$ = false;
            }
         }

         ipodigub.editions$.((int)isagoder, (int)tinabifi, (int)oyubafen);
         ipodigub.coffee$.((int)isagoder, (int)tinabifi, (int)oyubafen);
      }

      if (!Client.surround$.�?().altsConfig.accounts.isEmpty()) {
         if (RenderUtil._become((float)(ipodigub.mpegs$ - 60), (float)(ipodigub.contest$ + 130), 40.0F, 40.0F, (int)isagoder, (int)tinabifi)) {
            for(Object mecimace : Client.surround$.�?().altsConfig.alts) {
               ipodigub.entered$ = new SmoothStepAnimation(120, 35.0D, Direction.posted$);
               ipodigub.feeling$ = (float)((double)ipodigub.feeling$ - ipodigub.entered$._bloggers());
            }
         }

         if (RenderUtil._become((float)(rerorula.getScaledWidth() - 50), (float)(ipodigub.contest$ + 130), 40.0F, 40.0F, (int)isagoder, (int)tinabifi)) {
            for(Object var10 : Client.surround$.�?().altsConfig.alts) {
               ipodigub.entered$ = new SmoothStepAnimation(120, 35.0D, Direction.posted$);
               ipodigub.feeling$ = (float)((double)ipodigub.feeling$ + ipodigub.entered$._bloggers());
            }
         }
      }

      if (Minecraft.getSystemTime() - ipodigub.alabama$ < ((long)1587015777 ^ 1587015835L)) {
         if (ipodigub.�?() != null) {
            if (!ipodigub.�?()._origin((int)isagoder, (int)tinabifi)) {
               return;
            }

            ipodigub.();
         }
      } else {
         ipodigub.((int)isagoder, (int)tinabifi);
      }

      ipodigub.alabama$ = Minecraft.getSystemTime();
      super.mouseClicked((int)isagoder, (int)tinabifi, (int)oyubafen);
   }

   public void __/* $FF was: */(int lebanon, int thirty) {
      for(Object taiwan : Client.surround$.�?().altsConfig.alts) {
         if (taiwan._origin((int)lebanon, (int)thirty)) {
            for(Object bridal : Client.surround$.�?().altsConfig.alts) {
               bridal._battle(false);
            }

            taiwan._battle(true);
         }
      }

   }

   public void ____/* $FF was: */() {
      Object investor = cherry.�?();
      Object assumed = cherry.�?().waiting$;
      assumed._resident(cherry::�?).whenComplete(cherry::�?);
   }

   public AltCredential _/* $FF was: �?*/() {
      Object iletacel = null;
      Object sudasula = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
      if (sudasula != null && sudasula.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         iletacel = ((String)sudasula.getTransferData(DataFlavor.stringFlavor)).trim();
      }

      if (iletacel == null) {
         return null;
      } else {
         Object var3 = iletacel.indexOf(58);
         return var3 == -1 ? (iletacel.endsWith("@alt.com") ? new AltCredential(iletacel, (String)null) : null) : new AltCredential(iletacel.substring(0, var3), iletacel.substring(var3 + 1));
      }
   }

   public Alts _/* $FF was: �?*/(String coupon) {
      for(Object followed : Client.surround$.�?().altsConfig.alts) {
         if (followed.waiting$._modules().equalsIgnoreCase((String)coupon)) {
            return followed;
         }
      }

      return null;
   }

   public void keyTyped(char pirocoto, int siyofogo) throws IOException {
      ovayafef.editions$.�?((char)pirocoto, (int)siyofogo);
      ovayafef.coffee$.�?((char)pirocoto, (int)siyofogo);
      if (siyofogo == 1) {
         if (!ovayafef.dicke$ && !ovayafef.bolivia$) {
            ovayafef.variety$.displayGuiScreen((GuiScreen)null);
            Client.surround$.�?().saveConfig(Client.surround$.�?().altsConfig);
         } else {
            ovayafef.dicke$ = false;
            ovayafef.bolivia$ = false;
         }
      }

   }

   public Alts _/* $FF was: �?*/() {
      return (Alts) Client.surround$.�?().altsConfig.alts.stream().filter(Alts::_quarter).findAny().orElse((Object)null);
   }

   public void onGuiClosed() {
      Client.surround$.�?().saveConfig(Client.surround$.�?().altsConfig);
      super.onGuiClosed();
   }

   public void __/* $FF was: */(String ayafavoy, String niyovura) {
      bebaduyu.grande$.add(new Logs((String)ayafavoy, (String)niyovura, bebaduyu.grande$.size()));
   }

   public void ___/* $FF was: �?*/(boolean epucirec) {
      ozasutos.cohen$ = (boolean)epucirec;
   }

   public void ___/* $FF was: �?*/(boolean origides) {
      canaseba.suburban$ = (boolean)origides;
   }

   public void ___/* $FF was: �?*/(boolean utozunuy) {
      ivimefun.employee$ = (boolean)utozunuy;
   }

   public void _/* $FF was: �?*/(Alts enobinay, Account yutapedo, Throwable upozesuf) {
      uvarezor.adverse$ = null;
      if (upozesuf != null) {
         uvarezor.variety$.addScheduledTask(uvarezor::�?);
      } else {
         uvarezor.variety$.addScheduledTask(uvarezor::�?);
         Client.surround$.�?()._arabia().add(new Notification("Logged in! Username: " + ((Account)yutapedo)._angle(), (long)-6084437 ^ -6079709L));
         uvarezor.grande$.add(new Logs("Login Alt | Username : " + ((Account)yutapedo)._angle() + (((Account)yutapedo)._earliest().equalsIgnoreCase("legacy") ? " - Offline" : " - Microsoft"), "H", uvarezor.grande$.size()));
         if (((Alts)enobinay).waiting$ instanceof MicrosoftAccount) {
            Object leyusocu = JsonObtainer._opinions("https://api.sk1er.club/player/" + ((Alts)enobinay).waiting$._modules());
            if (!leyusocu.optBoolean("success")) {
               if (leyusocu.optString("cause").equals("non-player")) {
                  ((Alts)enobinay).bedding$ = "Never logged in";
               } else {
                  ((Alts)enobinay).bedding$ = "API DOWN";
               }

               ((Alts)enobinay).affects$ = 1.0D;
            } else {
               Object fuzogute = leyusocu.optJSONObject("player");
               ((Alts)enobinay).affects$ = fuzogute.optDouble("networkLevel");
               ((Alts)enobinay).bedding$ = fuzogute.optString("rank_for_mod");
            }
         }

      }
   }

   public void _/* $FF was: �?*/(Account totucipe) {
      nonusepu.variety$.session = new Session(((Account)totucipe)._angle(), UUIDTypeAdapter.fromUUID(((Account)totucipe)._insight()), ((Account)totucipe)._antenna(), ((Account)totucipe)._earliest());
   }

   public void _/* $FF was: �?*/(Throwable annoying) {
      attack.variety$.displayGuiScreen(new IASAlertScreen(attack::, EnumChatFormatting.RED + I18n.format("ias.error", new Object[0]), String.valueOf(annoying)));
   }

   public void ____/* $FF was: */() {
      escorts.variety$.displayGuiScreen(escorts);
   }

   public void _/* $FF was: �?*/(String ayozomom, Object[] agularey) {
      lidizope.adverse$ = String.format((String)ayozomom, (Object[])agularey);
   }

   public void _/* $FF was: �?*/(Account nuvosile, Throwable velifeto) {
      fusigica.adverse$ = null;
      if (velifeto != null) {
         fusigica.variety$.addScheduledTask(fusigica::�?);
      } else {
         fusigica.variety$.addScheduledTask(fusigica::�?);
         fusigica.grande$.add(new Logs("Login Alt | Username : " + fusigica.editions$.�?() + " - offline", "H", fusigica.grande$.size()));
      }
   }

   public void _/* $FF was: �?*/(Account showcase) {
      firewire.variety$.session = new Session(((Account)showcase)._angle(), UUIDTypeAdapter.fromUUID(((Account)showcase)._insight()), ((Account)showcase)._antenna(), ((Account)showcase)._earliest());
   }

   public void _/* $FF was: �?*/(Throwable geripuri) {
      ifusapol.variety$.displayGuiScreen(new IASAlertScreen(ifusapol::, EnumChatFormatting.RED + I18n.format("ias.error", new Object[0]), String.valueOf(geripuri)));
   }

   public void ____/* $FF was: */() {
      uvapimol.variety$.displayGuiScreen(uvapimol);
   }

   public void _/* $FF was: �?*/(String mozuveno, Object[] lerucovu) {
      ebuvubog.adverse$ = String.format((String)mozuveno, (Object[])lerucovu);
   }

   public static void _/* $FF was: �?*/(ft.sleep.api.Account dinner) {
      Object baker = (MicrosoftAccount)dinner;
      Client.surround$.�?().altsConfig.addAccount(baker._modules(), baker._cycle(), baker._phases(), baker._sport());
   }
}
