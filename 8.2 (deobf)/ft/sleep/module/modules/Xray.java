//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import com.google.common.collect.Lists;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import ft.sleep.util.animation.AnimationUtils2;
import ft.sleep.util.render.RenderUtil5;
import ft.sleep.util.render.RenderUtils;
import ft.sleep.util.scaffold.ServerUtils;
import ft.sleep.util.timer.Timer2;
import ft.sleep.util.timer.XrayTimer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.init.Blocks;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class Xray extends Module {
   public static boolean panic$;
   public static List wings$ = new CopyOnWriteArrayList();
   public static List stress$ = new CopyOnWriteArrayList();
   public Map interim$ = new HashMap();
   public HashSet guides$ = new HashSet(Arrays.asList(Blocks.obsidian, Blocks.clay, Blocks.mossy_cobblestone, Blocks.diamond_ore, Blocks.redstone_ore, Blocks.iron_ore, Blocks.coal_ore, Blocks.gold_ore, Blocks.emerald_ore, Blocks.lapis_ore));
   public Timer2 spank$ = new Timer2();
   public XrayTimer entirely$ = new XrayTimer();
   public XrayTimer clinton$ = new XrayTimer();
   public static int across$;
   public static List operates$ = Lists.newArrayList(new Integer[]{Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(21), Integer.valueOf(41), Integer.valueOf(42), Integer.valueOf(46), Integer.valueOf(48), Integer.valueOf(52), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(84), Integer.valueOf(89), Integer.valueOf(103), Integer.valueOf(116), Integer.valueOf(117), Integer.valueOf(118), Integer.valueOf(120), Integer.valueOf(129), Integer.valueOf(133), Integer.valueOf(137), Integer.valueOf(145), Integer.valueOf(152), Integer.valueOf(153), Integer.valueOf(154)});
   public static Numbers propecia$ = new Numbers("Range", 50.0D, Double.longBitsToDouble(0L), 500.0D, 1.0D);
   public static Numbers thanks$ = new Numbers("Opacity", 160.0D, Double.longBitsToDouble(0L), 255.0D, 5.0D);
   public static Numbers spider$ = new Numbers("Render Range", 17.0D, Double.longBitsToDouble(0L), 28.0D, 1.0D);
   public static Numbers execute$ = new Numbers("World Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static Numbers mails$ = new Numbers("Extreme Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static Numbers carrier$ = new Numbers("Extreme XZ", 5.0D, Double.longBitsToDouble(0L), 8.0D, 1.0D);
   public static Numbers analyst$ = new Numbers("Extreme Y", 2.0D, Double.longBitsToDouble(0L), 8.0D, 1.0D);
   public static Numbers colombia$ = new Numbers("ClickBlock Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static Option nextel$ = new Option("Update", true);
   public static Option begin$ = new Option("Coal", false);
   public static Option crawford$ = new Option("Iron", true);
   public static Option guitar$ = new Option("Gold", true);
   public static Option brazil$ = new Option("LapisLazuli", false);
   public static Option shorter$ = new Option("Diamond", true);
   public static Option rates$ = new Option("RedStone", false);
   public static Option vacation$ = new Option("Emerald", false);
   public static Option sheep$ = new Option("Tracer", true);
   public static Option parcel$ = new Option("Cave", true);
   public static Option proper$ = new Option("Esp", true);
   public static Option czech$ = new Option("MW", true);
   public static Option shakira$ = new Option("UHC", true);
   public static Option biology$ = new Option("Extreme", true);
   public static Option bulgaria$ = new Option("World", false);
   public Block[] stanford$ = new Block[]{Blocks.diamond_ore, Blocks.gold_ore};

   public Xray() {
      super("ft.sleep.module.modules.Xray", new String[]{"ft.sleep.module.modules.Xray"}, ModuleType.Combat);
   }

   public void _regime() {
      yaragibu._tampa(true);
      Object tuvelozo = (int)yaragibu.mc.thePlayer.posX;
      Object dupicubi = (int)yaragibu.mc.thePlayer.posY;
      Object evevimem = (int)yaragibu.mc.thePlayer.posZ;
      yaragibu.mc.renderGlobal.markBlockRangeForRenderUpdate(tuvelozo - 900, dupicubi - 900, evevimem - 900, tuvelozo + 900, dupicubi + 900, evevimem + 900);
   }

   public void _discs() {
      acugozup._tampa(false);
   }

   public void _tampa(boolean odovayem) {
      enunuyem.mc.renderGlobal.loadRenderers();
      panic$ = (boolean)odovayem;
      enunuyem.clinton$._brush();
      enunuyem.entirely$._brush();
      enunuyem.spank$._diagram();
      enunuyem.interim$.clear();
      stress$.clear();
      wings$.clear();
   }

   @EventHandler
   public void _disease(EventPacketReceive rocecaso) {
      if (EventPacketReceive.getPacket() instanceof S07PacketRespawn || EventPacketReceive.getPacket() instanceof S02PacketLoginSuccess) {
         stress$.clear();
         zosoduya.interim$.clear();
         wings$.clear();
      }

      if (EventPacketReceive.getPacket() instanceof S23PacketBlockChange) {
         Object yosuriyu = (S23PacketBlockChange)EventPacketReceive.getPacket();
         Object cocumepe = yosuriyu.getBlockPosition();
         Object apapefep = yosuriyu.getBlockState();
         Object zivovinu = apapefep.getBlock();
         if ((zivovinu instanceof BlockOre || zivovinu instanceof BlockRedstoneOre) && !stress$.contains(cocumepe)) {
            stress$.add(cocumepe);
            zosoduya.interim$.put(cocumepe, zivovinu);
         }
      }

      if (EventPacketReceive.getPacket() instanceof S22PacketMultiBlockChange) {
         Object var9 = (S22PacketMultiBlockChange)EventPacketReceive.getPacket();

         for(Object tatoyeru : var9.getChangedBlocks()) {
            Object ivesegez = tatoyeru.getPos();
            Block var8 = tatoyeru.getBlockState().getBlock();
            if ((var8 instanceof BlockOre || var8 instanceof BlockRedstoneOre) && !stress$.contains(ivesegez)) {
               stress$.add(ivesegez);
               zosoduya.interim$.put(ivesegez, var8);
            }
         }
      }

   }

   @EventHandler
   public void _first(EventPreUpdate var1) {
      if (across$ != thanks$.getValue().intValue()) {
         across$ = thanks$.getValue().intValue();
      }

      if (cameras.clinton$._chamber(1000.0D * execute$.getValue().doubleValue()) && bulgaria$.getValue().booleanValue()) {
         cameras.mc.renderGlobal.loadRenderers();
         cameras.clinton$._brush();
      }

      if (!ServerUtils._comedy() && nextel$.getValue().booleanValue() && cameras.entirely$._chamber(1000.0D * (cameras.mc.playerController.getIsHittingBlock() ? colombia$.getValue().doubleValue() : mails$.getValue().doubleValue()))) {
         if (biology$.getValue().booleanValue() && cameras.mc.thePlayer.posY <= 25.0D) {
            cameras._consider();
         }

         cameras.entirely$._brush();
      }

   }

   public void _consider() {
      Object zedicofi = carrier$.getValue().intValue();
      Object inasomug = analyst$.getValue().intValue();

      for(Object ritilolo = -zedicofi; ritilolo <= zedicofi; ++ritilolo) {
         for(Object cezebuve = -inasomug; cezebuve <= inasomug; ++cezebuve) {
            for(Object tifuzeni = -zedicofi; tifuzeni <= zedicofi; ++tifuzeni) {
               Object iruzucor = teyocupo.mc.thePlayer;
               Object anubevuy = (int)iruzucor.posX + ritilolo;
               Object zomocisa = (int)iruzucor.posY + cezebuve;
               int var9 = (int)iruzucor.posZ + tifuzeni;
               if (teyocupo.mc.thePlayer.getDistanceSq(teyocupo.mc.thePlayer.posX + (double)ritilolo, teyocupo.mc.thePlayer.posY + (double)cezebuve, teyocupo.mc.thePlayer.posZ + (double)tifuzeni) <= spider$.getValue().doubleValue()) {
                  BlockPos var10 = new BlockPos(teyocupo.mc.thePlayer.posX + (double)ritilolo, teyocupo.mc.thePlayer.posY + (double)cezebuve, teyocupo.mc.thePlayer.posZ + (double)tifuzeni);
                  Block var11 = teyocupo.mc.theWorld.getBlockState(var10).getBlock();
                  if (var11 instanceof BlockOre || var11 instanceof BlockRedstoneOre) {
                     if (!wings$.contains(var10)) {
                        PacketUtils._gratis(new C07PacketPlayerDigging(Action.ABORT_DESTROY_BLOCK, var10, EnumFacing.UP));
                     }

                     if (!wings$.contains(var10) && !stress$.contains(var10) && teyocupo.guides$.contains(var11)) {
                        wings$.add(var10);
                     }

                     if (!wings$.contains(var10) && !stress$.contains(var10) && teyocupo.guides$.contains(var11) && teyocupo._observer(var11, var10)) {
                        stress$.add(var10);
                     }
                  }
               }
            }
         }
      }

   }

   public boolean _observer(Block bafafami, BlockPos cicetipo) {
      for(Object acacarev : EnumFacing.VALUES) {
         if (_arctic(izicovoz.mc.theWorld, ((BlockPos)cicetipo).offset(acacarev), acacarev, ((Block)bafafami).getBlockBoundsMinY(), ((Block)bafafami).getBlockBoundsMaxY(), ((Block)bafafami).getBlockBoundsMinZ(), ((Block)bafafami).getBlockBoundsMaxZ(), ((Block)bafafami).getBlockBoundsMinX(), ((Block)bafafami).getBlockBoundsMaxX())) {
            return false;
         }
      }

      return true;
   }

   @EventHandler
   public void _retro(EventRender2D tumor) {
      if (!ServerUtils._comedy() && shakira$.getValue().booleanValue() && stored.mc.thePlayer.posY <= 25.0D) {
         Object reading = ((EventRender2D)tumor).getSR().getScaledHeight_double();
         Object sealed = ((EventRender2D)tumor).getSR().getScaledWidth_double();
         Object referred = 100.0D;
         stored.spank$._giving(1000.0D * mails$.getValue().doubleValue(), true);
         Object hawaiian = (double)stored.spank$._student();
         double var10 = hawaiian / (1000.0D * mails$.getValue().doubleValue());
         double var12 = Double.longBitsToDouble(0L);
         RenderUtils._shipment((float)(sealed / 2.0D - referred / 2.0D + 50.0D), (float)(reading / 2.0D + 150.0D + 13.0D), Float.intBitsToFloat(0), 360.0F, 15.0F, (new Color(17, 17, 17, 70)).getRGB(), 2);
         RenderUtils._closest((float)(sealed / 2.0D - referred / 2.0D + 50.0D), (float)(reading / 2.0D + 150.0D + 13.0D), Float.intBitsToFloat(0), (float)(400.0D * var10), 15.0F, (new Color(HUD.during$.getValue().intValue())).getRGB(), 2);
         var12 = (double) AnimationUtils2._presents((float)var12, (float)var10, (float)(10.0D * RenderUtil5._weapon()));
         String var14 = String.format("%.2f", var10);
         FontLoaders.clickgui14.drawStringWithShadow("" + var14, (double)((float)(sealed / 2.0D) - (float)FontLoaders.clickgui14.getStringWidth("" + var14) / 2.0F) - 0.1D, (double)((float)(reading / 2.0D + 162.0D)), (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

   }

   public double _advisors(double ruzofuzu, double odusunez) {
      double var5 = rumalane.mc.thePlayer.posX - ruzofuzu;
      double var7 = rumalane.mc.thePlayer.posZ - odusunez;
      return (double)MathHelper.sqrt_double(var5 * var5 + var7 * var7);
   }

   @EventHandler
   public void _vienna(EventRender3D pagavala) {
      if (proper$.getValue().booleanValue()) {
         for(Object oruzevur : stress$) {
            if (stress$.contains(oruzevur) && iciyofid._advisors((double)oruzevur.getX(), (double)oruzevur.getZ()) <= propecia$.getValue().doubleValue()) {
               Block var4 = iciyofid.mc.theWorld.getBlockState(oruzevur).getBlock();
               if (var4 == Blocks.diamond_ore && shorter$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 0, 255, 255);
               } else if (var4 == Blocks.iron_ore && crawford$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 225, 225, 225);
               } else if (var4 == Blocks.lapis_ore && brazil$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 0, 0, 255);
               } else if (var4 == Blocks.redstone_ore && rates$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 255, 0, 0);
               } else if (var4 == Blocks.coal_ore && begin$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 0, 30, 30);
               } else if (var4 == Blocks.emerald_ore && vacation$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 0, 255, 0);
               } else if (var4 == Blocks.gold_ore && guitar$.getValue().booleanValue()) {
                  iciyofid._highland(oruzevur, 255, 255, 0);
               }
            }
         }
      }

   }

   public static boolean _unlikely() {
      return proper$.getValue().booleanValue();
   }

   public static int _disable() {
      return propecia$.getValue().intValue();
   }

   public void _highland(BlockPos cheaper, int seasons, int unlock, int stress) {
      if (proper$.getValue().booleanValue()) {
         RenderUtils._supplied((BlockPos)cheaper, ColorUtils2._despite((int)seasons, (int)unlock, (int)stress));
      }

      if (sheep$.getValue().booleanValue()) {
         RenderUtils._hitachi((BlockPos)cheaper, ColorUtils2._despite((int)seasons, (int)unlock, (int)stress));
      }

   }

   public static boolean _arctic(IBlockAccess warren, BlockPos mustang, EnumFacing prices, double markers, double triple, double victim, double var9, double var11, double var13) {
      return prices == EnumFacing.DOWN && markers > Double.longBitsToDouble(0L) || prices == EnumFacing.UP && triple < 1.0D || prices == EnumFacing.NORTH && victim > Double.longBitsToDouble(0L) || prices == EnumFacing.SOUTH && var9 < 1.0D || prices == EnumFacing.WEST && var11 > Double.longBitsToDouble(0L) || prices == EnumFacing.EAST && var13 < 1.0D || !((IBlockAccess)warren).getBlockState((BlockPos)mustang).getBlock().isOpaqueCube();
   }
}
