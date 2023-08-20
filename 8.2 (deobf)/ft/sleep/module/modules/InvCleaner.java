//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.ChestStealer;
import ft.sleep.module.modules.Scaffold;
import ft.sleep.module.modules.AutoArmor;
import ft.sleep.util.timer.TimeHelper;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;

public class InvCleaner extends Module {
   public Option death$ = new Option("Open Inventory", true);
   public Numbers spirits$ = new Numbers("Delay", 5.0D, Double.longBitsToDouble(0L), 10.0D, 1.0D);
   public Numbers pakistan$ = new Numbers("Arrows", 128.0D, 64.0D, 512.0D, 64.0D);
   public Numbers resolve$ = new Numbers("Blocks", 128.0D, 64.0D, 512.0D, 64.0D);
   public Option friend$ = new Option("Sword", true);
   public Numbers tracked$ = new Numbers("Sword Slot", 1.0D, 1.0D, 9.0D, 1.0D);
   public Option juice$ = new Option("Pickaxe", true);
   public Numbers seating$ = new Numbers("Pickaxe Slot", 2.0D, 1.0D, 9.0D, 1.0D);
   public Option those$ = new Option("Axe", true);
   public Numbers athens$ = new Numbers("Axe Slot", 3.0D, 1.0D, 9.0D, 1.0D);
   public Option database$ = new Option("Shovel", true);
   public Numbers pendant$ = new Numbers("Shovel Slot", 4.0D, 1.0D, 9.0D, 1.0D);
   public Option verizon$ = new Option("Bow", true);
   public Numbers salary$ = new Numbers("Bow Slot", 5.0D, 1.0D, 9.0D, 1.0D);
   public Option islands$ = new Option("Head", true);
   public Numbers inner$ = new Numbers("Head Slot", 6.0D, 1.0D, 9.0D, 1.0D);
   public Option theories$ = new Option("Golden Apple", true);
   public Numbers accounts$ = new Numbers("Golden Apple Slot", 7.0D, 1.0D, 9.0D, 1.0D);
   public Option delays$ = new Option("Sticks", true);
   public Option gadgets$ = new Option("Ores", true);
   public Option thread$ = new Option("Buckets", true);
   public TimeHelper premiere$ = new TimeHelper();

   public InvCleaner() {
      super("InvManager", new String[]{"InvManager"}, ModuleType.Player);
   }

   public boolean _sheet(ItemStack swiss) {
      Object place = luxury._columbus((ItemStack)swiss);

      for(Object floors = 9; floors < 45; ++floors) {
         if (luxury.mc.thePlayer.inventoryContainer.getSlot(floors).getHasStack()) {
            Object unusual = luxury.mc.thePlayer.inventoryContainer.getSlot(floors).getStack();
            if (luxury._columbus(unusual) > place && unusual.getItem() instanceof ItemSword) {
               return false;
            }
         }
      }

      return ((ItemStack)swiss).getItem() instanceof ItemSword;
   }

   public boolean _micro(ItemStack volenoye) {
      return ((ItemStack)volenoye).getItem() instanceof ItemSkull && ((ItemStack)volenoye).getDisplayName().contains("Head") && !((ItemStack)volenoye).getDisplayName().equalsIgnoreCase("Wither Skeleton Skull") && !((ItemStack)volenoye).getDisplayName().equalsIgnoreCase("Zombie Head") && !((ItemStack)volenoye).getDisplayName().equalsIgnoreCase("Creeper Head") && !((ItemStack)volenoye).getDisplayName().equalsIgnoreCase("Skeleton Skull");
   }

   public boolean _mounts(ItemStack ogureyep) {
      return ((ItemStack)ogureyep).getItem() instanceof ItemAppleGold;
   }

   @EventHandler
   public void _topics(EventPreUpdate metallic) {
      Object places = (AutoArmor)ModuleManager._herbs(AutoArmor.class);
      Object floral = (ChestStealer) ModuleManager._herbs(ChestStealer.class);
      if (socks.mc.currentScreen instanceof GuiInventory || !socks.death$.getValue().booleanValue()) {
         if (socks.mc.currentScreen == null || socks.mc.currentScreen instanceof GuiInventory || socks.mc.currentScreen instanceof GuiChat) {
            Object includes = socks.tracked$.getValue().intValue() - 1;
            Object fence = socks.seating$.getValue().intValue() - 1;
            Object degrees = socks.salary$.getValue().intValue() - 1;
            Object exceed = socks.pendant$.getValue().intValue() - 1;
            Object graph = socks.athens$.getValue().intValue() - 1;
            Object copied = socks.inner$.getValue().intValue() - 1;
            Object writes = socks.accounts$.getValue().intValue() - 1;
            Object median = socks.juice$.getValue().booleanValue();
            Object drops = socks.database$.getValue().booleanValue();
            Object walker = socks.those$.getValue().booleanValue();
            Object steal = socks.friend$.getValue().booleanValue();
            Object mounting = socks.verizon$.getValue().booleanValue();
            Object growing = socks.islands$.getValue().booleanValue();
            Object dealers = socks.theories$.getValue().booleanValue();
            int var18 = socks.spirits$.getValue().intValue() * 50;

            for(int var19 = 9; var19 < 45; ++var19) {
               ItemStack var20 = socks.mc.thePlayer.inventoryContainer.getSlot(var19).getStack();
               if (var20 != null && socks.premiere$._threaded((float)var18)) {
                  if (socks._sheet(var20) && steal && socks._lenders(includes)[0]) {
                     socks._diesel(var19, includes);
                     socks.premiere$._silent();
                  } else if (socks._texts(var20) && median && socks._lenders(fence)[2]) {
                     socks._diesel(var19, fence);
                     socks.premiere$._silent();
                  } else if (socks._mayor(var20) && walker && socks._lenders(graph)[1]) {
                     socks._diesel(var19, graph);
                     socks.premiere$._silent();
                  } else if (socks._rapid(var20) && mounting && socks._lenders(degrees)[5] && !var20.getDisplayName().toLowerCase().contains("kit selector")) {
                     socks._diesel(var19, degrees);
                     socks.premiere$._silent();
                  } else if (socks._micro(var20) && growing && socks._lenders(copied)[4]) {
                     socks._diesel(var19, copied);
                     socks.premiere$._silent();
                  } else if (socks._output(var20) && drops && socks._lenders(exceed)[3]) {
                     socks._diesel(var19, exceed);
                     socks.premiere$._silent();
                  } else if (socks._mounts(var20) && dealers && socks._lenders(writes)[6]) {
                     socks._diesel(var19, writes);
                     socks.premiere$._silent();
                  }
               }
            }

            for(int var21 = 9; var21 < 45; ++var21) {
               if (socks.mc.thePlayer.inventoryContainer.getSlot(var21).getHasStack()) {
                  ItemStack var22 = socks.mc.thePlayer.inventoryContainer.getSlot(var21).getStack();
                  if (var22 != null && socks._chambers(var22) && socks.premiere$._updated((float)var18)) {
                     socks._clock(var21);
                     socks.premiere$._silent();
                  }
               }
            }
         }

      }
   }

   public void _clock(int geology) {
      mason.mc.playerController.windowClick(mason.mc.thePlayer.inventoryContainer.windowId, (int)geology, 1, 4, mason.mc.thePlayer);
   }

   public void _diesel(int safari, int console) {
      holmes.mc.playerController.windowClick(holmes.mc.thePlayer.inventoryContainer.windowId, (int)safari, (int)console, 2, holmes.mc.thePlayer);
   }

   public boolean[] _lenders(int employee) {
      return new boolean[]{!ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._sheet(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._mayor(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._texts(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._output(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._micro(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._rapid(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack()), !ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getHasStack() || !ceramic._mounts(ceramic.mc.thePlayer.inventoryContainer.getSlot(employee + 36).getStack())};
   }

   public boolean _increase() {
      return !fovegope.premiere$._threaded(fovegope.spirits$.getValue().floatValue() * 150.0F);
   }

   public float _columbus(ItemStack andreas) {
      Object nerve = Float.intBitsToFloat(0);
      Object heavily = ((ItemStack)andreas).getItem();
      if (heavily instanceof ItemTool) {
         nerve += ruling._italia((ItemStack)andreas);
      }

      if (heavily instanceof ItemSword) {
         nerve += ruling._journals((ItemStack)andreas);
      } else {
         ++nerve;
      }

      return nerve;
   }

   public float _journals(ItemStack subject) {
      Object speaker = ((ItemSword)((ItemStack)subject).getItem()).getDamageVsEntity();
      speaker = speaker + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)subject) * 1.25F;
      speaker = speaker + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)subject) * 0.01F;
      return speaker;
   }

   public float _italia(ItemStack nafagafa) {
      return ((ItemTool)((ItemStack)nafagafa).getItem()).getToolMaterial().getEfficiencyOnProperMaterial();
   }

   public int _painting() {
      Object vecucore = 0;

      for(Object royafosi = 0; royafosi < 45; ++royafosi) {
         if (dufudica.mc.thePlayer.inventoryContainer.getSlot(royafosi).getHasStack()) {
            Object deseraso = dufudica.mc.thePlayer.inventoryContainer.getSlot(royafosi).getStack();
            Object upibepem = deseraso.getItem();
            if (deseraso.getItem() instanceof ItemBlock && !Scaffold.football$.contains(((ItemBlock)upibepem).getBlock())) {
               vecucore += deseraso.stackSize;
            }
         }
      }

      return vecucore;
   }

   public int _healing() {
      Object terrain = 0;

      for(Object poison = 0; poison < 45; ++poison) {
         if (blowing.mc.thePlayer.inventoryContainer.getSlot(poison).getHasStack()) {
            Object skills = blowing.mc.thePlayer.inventoryContainer.getSlot(poison).getStack();
            if (skills.getItem() == Items.arrow) {
               terrain += skills.stackSize;
            }
         }
      }

      return terrain;
   }

   public int _letters() {
      Object cabayimo = 0;

      for(Object licebeci = 0; licebeci < 45; ++licebeci) {
         if (ibusapag.mc.thePlayer.inventoryContainer.getSlot(licebeci).getHasStack()) {
            Object yeyiluzo = ibusapag.mc.thePlayer.inventoryContainer.getSlot(licebeci).getStack();
            if (yeyiluzo.getItem() == Items.iron_ingot) {
               cabayimo += yeyiluzo.stackSize;
            }
         }
      }

      return cabayimo;
   }

   public int _visited() {
      Object hidden = 0;

      for(Object trust = 0; trust < 45; ++trust) {
         if (attract.mc.thePlayer.inventoryContainer.getSlot(trust).getHasStack()) {
            Object capital = attract.mc.thePlayer.inventoryContainer.getSlot(trust).getStack();
            if (capital.getItem() == Items.coal) {
               hidden += capital.stackSize;
            }
         }
      }

      return hidden;
   }

   public int _marie() {
      Object idapoyav = 0;

      for(Object sefaface = 0; sefaface < 45; ++sefaface) {
         if (erurezuy.mc.thePlayer.inventoryContainer.getSlot(sefaface).getHasStack()) {
            Object zalifeca = erurezuy.mc.thePlayer.inventoryContainer.getSlot(sefaface).getStack();
            if (zalifeca.getItem() instanceof ItemSword && erurezuy._sheet(zalifeca)) {
               idapoyav += zalifeca.stackSize;
            }
         }
      }

      return idapoyav;
   }

   public int _georgia() {
      Object bociyisa = 0;

      for(Object yiyubabu = 0; yiyubabu < 45; ++yiyubabu) {
         if (ofofizom.mc.thePlayer.inventoryContainer.getSlot(yiyubabu).getHasStack()) {
            Object udeyonez = ofofizom.mc.thePlayer.inventoryContainer.getSlot(yiyubabu).getStack();
            if (udeyonez.getItem() instanceof ItemBow && ofofizom._rapid(udeyonez)) {
               bociyisa += udeyonez.stackSize;
            }
         }
      }

      return bociyisa;
   }

   public int _green() {
      Object lidigobe = 0;

      for(Object somutomo = 0; somutomo < 45; ++somutomo) {
         if (agosorep.mc.thePlayer.inventoryContainer.getSlot(somutomo).getHasStack()) {
            Object madezufu = agosorep.mc.thePlayer.inventoryContainer.getSlot(somutomo).getStack();
            if (madezufu.getItem() instanceof ItemPickaxe && agosorep._texts(madezufu)) {
               lidigobe += madezufu.stackSize;
            }
         }
      }

      return lidigobe;
   }

   public int _faster() {
      Object zegavefu = 0;

      for(Object ficogile = 0; ficogile < 45; ++ficogile) {
         if (alibelir.mc.thePlayer.inventoryContainer.getSlot(ficogile).getHasStack()) {
            Object ganavivu = alibelir.mc.thePlayer.inventoryContainer.getSlot(ficogile).getStack();
            if (ganavivu.getItem() instanceof ItemAxe && alibelir._mayor(ganavivu)) {
               zegavefu += ganavivu.stackSize;
            }
         }
      }

      return zegavefu;
   }

   public int _sought() {
      Object iculubiy = 0;

      for(Object lafesedu = 0; lafesedu < 45; ++lafesedu) {
         if (nipupugi.mc.thePlayer.inventoryContainer.getSlot(lafesedu).getHasStack()) {
            Object begilaro = nipupugi.mc.thePlayer.inventoryContainer.getSlot(lafesedu).getStack();
            if (begilaro.getItem() instanceof ItemSkull && nipupugi._output(begilaro)) {
               iculubiy += begilaro.stackSize;
            }
         }
      }

      return iculubiy;
   }

   public int _cargo() {
      Object isayedip = 0;

      for(Object ezepizes = 0; ezepizes < 45; ++ezepizes) {
         if (layarusa.mc.thePlayer.inventoryContainer.getSlot(ezepizes).getHasStack()) {
            Object ovayopom = layarusa.mc.thePlayer.inventoryContainer.getSlot(ezepizes).getStack();
            if (ovayopom.getItem() instanceof ItemSpade && layarusa._output(ovayopom)) {
               isayedip += ovayopom.stackSize;
            }
         }
      }

      return isayedip;
   }

   public boolean _texts(ItemStack ritasoba) {
      Object ifupacaf = ((ItemStack)ritasoba).getItem();
      if (!(ifupacaf instanceof ItemPickaxe)) {
         return false;
      } else {
         Object bufepase = ezegateg._earlier((ItemStack)ritasoba);

         for(Object bisobofi = 9; bisobofi < 45; ++bisobofi) {
            if (ezegateg.mc.thePlayer.inventoryContainer.getSlot(bisobofi).getHasStack()) {
               Object itilabis = ezegateg.mc.thePlayer.inventoryContainer.getSlot(bisobofi).getStack();
               if (ezegateg._earlier(itilabis) > bufepase && itilabis.getItem() instanceof ItemPickaxe) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public boolean _chambers(ItemStack tunoruva) {
      Object upanidad = ((ItemStack)tunoruva).getItem();
      Object sadopuco = ((ItemStack)tunoruva).getDisplayName();
      Object nomusicu = Item.getIdFromItem(upanidad);
      if (nomusicu != 58 && !sadopuco.toLowerCase().contains(EnumChatFormatting.OBFUSCATED + "||") && !sadopuco.contains(EnumChatFormatting.GREEN + "Game Menu " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "Spectator Settings " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "Play Again " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD + "Teleporter " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "SkyWars Challenges " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Collectibles " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Kit Selector " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Kill Effect Selector " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.WHITE + "Players: " + EnumChatFormatting.RED + "ft.sleep.command.commands.Hidden " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Shop " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.WHITE + "Players: " + EnumChatFormatting.RED + "Visible " + EnumChatFormatting.GRAY + "(Right Click)") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GOLD + "Excalibur") && !sadopuco.equalsIgnoreCase("aDragon Sword") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Cornucopia") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.RED + "Bloodlust") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.RED + "Artemis' Bow") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GREEN + "Miner's Blessing") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GOLD + "Axe of Perun") && !sadopuco.equalsIgnoreCase(EnumChatFormatting.GOLD + "Cornucopia") && nomusicu != 116 && nomusicu != 145 && (nomusicu != 15 && nomusicu != 14 || !arurosiy.gadgets$.getValue().booleanValue()) && !sadopuco.equalsIgnoreCase("§aAndúril") && nomusicu != 259 && nomusicu != 46) {
         Object mafifoge = arurosiy.tracked$.getValue().intValue() - 1;
         Object vapodayo = arurosiy.seating$.getValue().intValue() - 1;
         Object gisebesi = arurosiy.salary$.getValue().intValue() - 1;
         Object emapufig = arurosiy.pendant$.getValue().intValue() - 1;
         Object meyocobo = arurosiy.athens$.getValue().intValue() - 1;
         Object osulotem = arurosiy.inner$.getValue().intValue() - 1;
         Object uvesefoc = arurosiy.juice$.getValue().booleanValue();
         Object urimudif = arurosiy.database$.getValue().booleanValue();
         Object misopala = arurosiy.those$.getValue().booleanValue();
         Object oconoriv = arurosiy.friend$.getValue().booleanValue();
         Object avulinut = arurosiy.verizon$.getValue().booleanValue();
         Object ucuyivoz = arurosiy.islands$.getValue().booleanValue();
         if (((!arurosiy._output((ItemStack)tunoruva) || arurosiy._cargo() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemSpade) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(emapufig)) || !urimudif) && ((!arurosiy._rapid((ItemStack)tunoruva) || arurosiy._georgia() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemBow) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(gisebesi)) || !avulinut) && ((!arurosiy._micro((ItemStack)tunoruva) || arurosiy._sought() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemSkull) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(osulotem)) || !ucuyivoz) && ((!arurosiy._mayor((ItemStack)tunoruva) || arurosiy._faster() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemAxe) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(meyocobo)) || !misopala) && ((!arurosiy._texts((ItemStack)tunoruva) || arurosiy._green() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemPickaxe) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(vapodayo)) || !uvesefoc) && ((!arurosiy._sheet((ItemStack)tunoruva) || arurosiy._marie() >= 2) && (!(((ItemStack)tunoruva).getItem() instanceof ItemSword) || tunoruva != arurosiy.mc.thePlayer.inventory.getStackInSlot(mafifoge)) || !oconoriv)) {
            if (upanidad instanceof ItemArmor) {
               for(Object umolayen = 1; umolayen < 5; ++umolayen) {
                  if (arurosiy.mc.thePlayer.inventoryContainer.getSlot(4 + umolayen).getHasStack()) {
                     Object zuleleyi = arurosiy.mc.thePlayer.inventoryContainer.getSlot(4 + umolayen).getStack();
                     if (AutoArmor._tunnel(zuleleyi, umolayen)) {
                        continue;
                     }
                  }

                  if (AutoArmor._tunnel((ItemStack)tunoruva, umolayen)) {
                     return false;
                  }
               }
            }

            if ((!(upanidad instanceof ItemBlock) || arurosiy._painting() <= arurosiy.resolve$.getValue().intValue() && !Scaffold.football$.contains(((ItemBlock)upanidad).getBlock())) && (!(upanidad instanceof ItemPotion) || !arurosiy._systems((ItemStack)tunoruva)) && (!(upanidad instanceof ItemFood) || upanidad instanceof ItemAppleGold || upanidad == Items.bread || upanidad == Items.pumpkin_pie || upanidad == Items.baked_potato || upanidad == Items.cooked_chicken || upanidad == Items.carrot || upanidad == Items.apple || upanidad == Items.beef || upanidad == Items.cooked_beef || upanidad == Items.porkchop || upanidad == Items.cooked_porkchop || upanidad == Items.mushroom_stew || upanidad == Items.cooked_fish || upanidad == Items.melon) && !(upanidad instanceof ItemHoe) && !(upanidad instanceof ItemTool) && !(upanidad instanceof ItemSword) && !(upanidad instanceof ItemArmor)) {
               Object var19 = upanidad.getUnlocalizedName();
               return !arurosiy.delays$.getValue().booleanValue() && var19.contains("stick") || var19.contains("egg") || arurosiy._letters() > 64 && upanidad == Items.iron_ingot || arurosiy._visited() > 64 && upanidad == Items.coal || var19.contains("string") || var19.contains("flint") || var19.contains("compass") || var19.contains("dyePowder") || var19.contains("feather") || var19.contains("chest") && !sadopuco.toLowerCase().contains("collect") || var19.contains("snow") || var19.contains("torch") || var19.contains("seeds") || var19.contains("leather") || var19.contains("reeds") || var19.contains("record") || var19.contains("snowball") || upanidad instanceof ItemGlassBottle || upanidad instanceof ItemSlab || nomusicu == 113 || nomusicu == 106 || nomusicu == 325 || nomusicu == 326 && !arurosiy.thread$.getValue().booleanValue() || nomusicu == 327 || nomusicu == 111 || nomusicu == 85 || nomusicu == 188 || nomusicu == 189 || nomusicu == 190 || nomusicu == 191 || nomusicu == 401 || nomusicu == 192 || nomusicu == 81 || nomusicu == 32 || var19.contains("gravel") || var19.contains("flower") || var19.contains("tallgrass") || upanidad instanceof ItemBow || upanidad == Items.arrow && arurosiy._healing() > (arurosiy.verizon$.getValue().booleanValue() ? arurosiy.pakistan$.getValue().intValue() : 0) || nomusicu == 175 || nomusicu == 340 || nomusicu == 339 || nomusicu == 160 || nomusicu == 101 || nomusicu == 102 || nomusicu == 321 || nomusicu == 323 || nomusicu == 389 || nomusicu == 416 || nomusicu == 171 || nomusicu == 139 || nomusicu == 23 || nomusicu == 25 || nomusicu == 69 || nomusicu == 70 || nomusicu == 72 || nomusicu == 77 || nomusicu == 96 || nomusicu == 107 || nomusicu == 123 || nomusicu == 131 || nomusicu == 143 || nomusicu == 147 || nomusicu == 148 || nomusicu == 151 || nomusicu == 152 || nomusicu == 154 || nomusicu == 158 || nomusicu == 167 || nomusicu == 403 || nomusicu == 183 || nomusicu == 184 || nomusicu == 185 || nomusicu == 186 || nomusicu == 187 || nomusicu == 331 || nomusicu == 356 || nomusicu == 404 || nomusicu == 27 || nomusicu == 28 || nomusicu == 66 || nomusicu == 76 || nomusicu == 157 || nomusicu == 328 || nomusicu == 342 || nomusicu == 343 || nomusicu == 398 || nomusicu == 407 || nomusicu == 408 || nomusicu == 138 || nomusicu == 352 || nomusicu == 385 || nomusicu == 386 || nomusicu == 395 || nomusicu == 402 || nomusicu == 418 || nomusicu == 419 || nomusicu == 281 || nomusicu == 289 || nomusicu == 337 || nomusicu == 336 || nomusicu == 348 || nomusicu == 353 || nomusicu == 369 || nomusicu == 372 || nomusicu == 405 || nomusicu == 406 || nomusicu == 409 || nomusicu == 410 || nomusicu == 415 || nomusicu == 370 || nomusicu == 376 || nomusicu == 377 || nomusicu == 378 || nomusicu == 379 || nomusicu == 380 || nomusicu == 382 || nomusicu == 414 || nomusicu == 346 || nomusicu == 347 || nomusicu == 420 || nomusicu == 397 || nomusicu == 421 || nomusicu == 341 || var19.contains("sapling") || var19.contains("stairs") || var19.contains("door") || var19.contains("monster_egg") || var19.contains("sand") || var19.contains("piston");
            } else {
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean _output(ItemStack retro) {
      Object wires = ((ItemStack)retro).getItem();
      if (!(wires instanceof ItemSpade)) {
         return false;
      } else {
         Object reach = fantasy._earlier((ItemStack)retro);

         for(Object toward = 9; toward < 45; ++toward) {
            if (fantasy.mc.thePlayer.inventoryContainer.getSlot(toward).getHasStack()) {
               Object payable = fantasy.mc.thePlayer.inventoryContainer.getSlot(toward).getStack();
               if (fantasy._earlier(payable) > reach && payable.getItem() instanceof ItemSpade) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public boolean _mayor(ItemStack grades) {
      Object setting = ((ItemStack)grades).getItem();
      if (!(setting instanceof ItemAxe)) {
         return false;
      } else {
         Object guyana = defects._earlier((ItemStack)grades);

         for(Object amended = 9; amended < 45; ++amended) {
            if (defects.mc.thePlayer.inventoryContainer.getSlot(amended).getHasStack()) {
               Object horrible = defects.mc.thePlayer.inventoryContainer.getSlot(amended).getStack();
               if (defects._earlier(horrible) > guyana && horrible.getItem() instanceof ItemAxe && !defects._sheet((ItemStack)grades)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public float _earlier(ItemStack zifirado) {
      Object fucenico = ((ItemStack)zifirado).getItem();
      if (!(fucenico instanceof ItemTool)) {
         return Float.intBitsToFloat(0);
      } else {
         Object fulameze = fucenico.getUnlocalizedName();
         Object zesigipe = (ItemTool)fucenico;
         float nozufazi;
         if (fucenico instanceof ItemPickaxe) {
            nozufazi = zesigipe.getStrVsBlock((ItemStack)zifirado, Blocks.stone);
            if (fulameze.toLowerCase().contains("gold")) {
               nozufazi -= 5.0F;
            }
         } else if (fucenico instanceof ItemSpade) {
            nozufazi = zesigipe.getStrVsBlock((ItemStack)zifirado, Blocks.dirt);
            if (fulameze.toLowerCase().contains("gold")) {
               nozufazi -= 5.0F;
            }
         } else {
            if (!(fucenico instanceof ItemAxe)) {
               return 1.0F;
            }

            nozufazi = zesigipe.getStrVsBlock((ItemStack)zifirado, Blocks.log);
            if (fulameze.toLowerCase().contains("gold")) {
               nozufazi -= 5.0F;
            }
         }

         nozufazi = (float)((double)nozufazi + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, (ItemStack)zifirado) * 0.0075D);
         nozufazi = (float)((double)nozufazi + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)zifirado) / 100.0D);
         return nozufazi;
      }
   }

   public float _calvin(ItemStack jonathan) {
      return (float)(1 + EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, (ItemStack)jonathan) + EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, (ItemStack)jonathan) + EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, (ItemStack)jonathan));
   }

   public boolean _systems(ItemStack alocinuc) {
      if (alocinuc != null && ((ItemStack)alocinuc).getItem() instanceof ItemPotion) {
         Object osodiyis = (ItemPotion)((ItemStack)alocinuc).getItem();
         return osodiyis.getEffects((ItemStack)alocinuc) == null || bucotepu._there((ItemStack)alocinuc, osodiyis);
      } else {
         return false;
      }
   }

   public boolean _there(ItemStack nafocasa, ItemPotion fuyecoya) {
      for(Object daranode : ((ItemPotion)fuyecoya).getEffects((ItemStack)nafocasa)) {
         Object uyenapiy = Potion.potionTypes[daranode.getPotionID()];
         if (uyenapiy.isBadEffect()) {
            return true;
         }
      }

      return false;
   }

   public boolean _rapid(ItemStack vision) {
      Object temporal = ((ItemStack)vision).getItem();
      if (!(temporal instanceof ItemBow)) {
         return false;
      } else {
         Object taken = ideas._calvin((ItemStack)vision);

         for(Object below = 9; below < 45; ++below) {
            if (ideas.mc.thePlayer.inventoryContainer.getSlot(below).getHasStack()) {
               Object rebates = ideas.mc.thePlayer.inventoryContainer.getSlot(below).getStack();
               if (ideas._calvin(rebates) > taken && rebates.getItem() instanceof ItemBow) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public void _discs() {
      ayubagiv.premiere$._silent();
   }
}
