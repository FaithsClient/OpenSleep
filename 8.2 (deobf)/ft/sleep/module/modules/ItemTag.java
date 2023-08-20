//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.HUD;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ItemTag extends Module {
   public IntBuffer batch$ = GLAllocation.createDirectIntBuffer(16);
   public FloatBuffer jewish$ = GLAllocation.createDirectFloatBuffer(16);
   public FloatBuffer guidance$ = GLAllocation.createDirectFloatBuffer(16);
   public FloatBuffer runtime$ = GLAllocation.createDirectFloatBuffer(4);
   public Option clarity$ = new Option("Names", true);
   public Option managed$ = new Option("neededOnly", false);
   public Option dirty$ = new Option("MegaWalls", false);

   public ItemTag() {
      super("Item ESP", new String[]{"ItemESP"}, ModuleType.ignored$);
   }

   public boolean _update(ItemStack malofale) {
      Object moparola = ((ItemStack)malofale).getItem();
      Object esuzased = Item.getIdFromItem(moparola);
      return ((ItemStack)malofale).hasDisplayName() || esuzased == Item.getIdFromItem(Items.diamond_sword) || esuzased == Item.getIdFromItem(Items.diamond_helmet) || esuzased == Item.getIdFromItem(Items.diamond_chestplate) || esuzased == Item.getIdFromItem(Items.diamond) || esuzased == Item.getIdFromItem(Items.diamond_leggings) || esuzased == Item.getIdFromItem(Items.diamond_boots);
   }

   public boolean _limits(ItemStack ozugodis) {
      if (!oyebagim.dirty$.getValue().booleanValue()) {
         return true;
      } else {
         Object cezenima = ((ItemStack)ozugodis).getItem();
         Object valutoni = Item.getIdFromItem(cezenima);
         return ((ItemStack)ozugodis).hasDisplayName() || valutoni == Item.getIdFromItem(Items.golden_apple) || valutoni == Item.getIdFromItem(Items.skull) && ((ItemStack)ozugodis).getItemDamage() == 3 || valutoni == Item.getIdFromItem(Items.enchanted_book) || valutoni == Item.getIdFromItem(Items.diamond_sword) || valutoni == Item.getIdFromItem(Items.diamond_helmet) || valutoni == Item.getIdFromItem(Items.diamond_chestplate) || valutoni == Item.getIdFromItem(Items.milk_bucket) || valutoni == Item.getIdFromItem(Items.diamond) || valutoni == Item.getIdFromItem(Items.diamond_leggings) || valutoni == Item.getIdFromItem(Items.diamond_boots) || valutoni == Item.getIdFromItem(Items.potionitem) || valutoni == Item.getIdFromItem(Items.golden_carrot);
      }
   }

   @EventHandler
   public void _sterling(EventRender2D oyapimir) {
      for(Object tayurule : anazasel.mc.theWorld.getLoadedEntityList()) {
         if (tayurule instanceof EntityItem) {
            Object odamolar = (EntityItem)tayurule;
            if (anazasel._limits(odamolar.getEntityItem())) {
               Object ayumigac = anazasel.mc.getRenderItem().getItemModelMesher().getItemModel(((EntityItem)tayurule).getEntityItem());
               Object udododuz = MathHelper.sin(((float)((EntityItem)tayurule).getAge() + ((EventRender2D)oyapimir).getPartialTicks()) / 10.0F + ((EntityItem)tayurule).hoverStart) * 0.1F - 0.1F;
               Object tivamosu = ayumigac.getItemCameraTransforms().getTransform(TransformType.GROUND).scale.y;
               Object tuzulalo = RenderUtils._kijiji(tayurule.posX, tayurule.lastTickPosX, ((EventRender2D)oyapimir).getPartialTicks());
               Object riyipafo = RenderUtils._kijiji(tayurule.posY + (double)udododuz, tayurule.lastTickPosY + (double)udododuz, ((EventRender2D)oyapimir).getPartialTicks());
               Object opubagey = RenderUtils._kijiji(tayurule.posZ, tayurule.lastTickPosZ, ((EventRender2D)oyapimir).getPartialTicks());
               Object icivazuf = (double)tayurule.width / 0.5D;
               Object cazetifa = (double)tayurule.height + 0.7D;
               Object rabiyafa = new AxisAlignedBB(tuzulalo - icivazuf, riyipafo, opubagey - icivazuf, tuzulalo + icivazuf, riyipafo + cazetifa, opubagey + icivazuf);
               Object oyegazem = Arrays.asList(new Vector3d(rabiyafa.minX, rabiyafa.minY, rabiyafa.minZ), new Vector3d(rabiyafa.minX, rabiyafa.maxY, rabiyafa.minZ), new Vector3d(rabiyafa.maxX, rabiyafa.minY, rabiyafa.minZ), new Vector3d(rabiyafa.maxX, rabiyafa.maxY, rabiyafa.minZ), new Vector3d(rabiyafa.minX, rabiyafa.minY, rabiyafa.maxZ), new Vector3d(rabiyafa.minX, rabiyafa.maxY, rabiyafa.maxZ), new Vector3d(rabiyafa.maxX, rabiyafa.minY, rabiyafa.maxZ), new Vector3d(rabiyafa.maxX, rabiyafa.maxY, rabiyafa.maxZ));
               anazasel.mc.entityRenderer.setupCameraTransform(((EventRender2D)oyapimir).getPartialTicks(), 0);
               Object febufaco = null;

               for(Object ravugico : oyegazem) {
                  ravugico = anazasel._browsers(((EventRender2D)oyapimir).getSR(), ravugico.x - anazasel.mc.getRenderManager().viewerPosX, ravugico.y - anazasel.mc.getRenderManager().viewerPosY, ravugico.z - anazasel.mc.getRenderManager().viewerPosZ);
                  if (ravugico != null && ravugico.z >= Double.longBitsToDouble(0L) && ravugico.z < 1.0D) {
                     if (febufaco == null) {
                        febufaco = new Vector4d(ravugico.x, ravugico.y, ravugico.z, Double.longBitsToDouble(0L));
                     }

                     febufaco.x = Math.min(ravugico.x, febufaco.x);
                     febufaco.y = Math.min(ravugico.y, febufaco.y);
                     febufaco.z = Math.max(ravugico.x, febufaco.z);
                     febufaco.w = Math.max(ravugico.y, febufaco.w);
                  }
               }

               anazasel.mc.entityRenderer.setupOverlayRendering();
               if (febufaco != null && (!anazasel.managed$.getValue().booleanValue() || anazasel._harvest((EntityItem)tayurule))) {
                  Object var37 = febufaco.x;
                  Object volalifa = febufaco.y;
                  Object diruruna = febufaco.z;
                  double var27 = febufaco.w;
                  RenderUtils._titanium(var37, volalifa, diruruna, var27, anazasel._harvest((EntityItem)tayurule) ? 4.0D : 3.0D, Color.BLACK);
                  RenderUtils._titanium(var37, volalifa, diruruna, var27, anazasel._harvest((EntityItem)tayurule) ? 2.0D : 1.0D, anazasel._whose((EntityItem)tayurule));
                  if (anazasel.clarity$.getValue().booleanValue()) {
                     float var29 = 1.0F;
                     switch(anazasel.mc.gameSettings.guiScale) {
                     case 0:
                        var29 = 0.5F;
                        break;
                     case 1:
                        var29 = 2.0F;
                     case 2:
                     default:
                        break;
                     case 3:
                        var29 = 0.6666667F;
                     }

                     double[] var30 = _sparc(anazasel.mc, var37, volalifa);
                     double[] var31 = _sparc(anazasel.mc, diruruna, var27);
                     double[] var32 = new double[]{var30[0] * 2.0D, var30[1] * 2.0D, var31[0] * 2.0D, var31[1] * 2.0D};
                     GL11.glPushMatrix();
                     GL11.glScalef(0.5F * var29, 0.5F * var29, 0.5F * var29);
                     double var33 = Math.abs(var32[2] - var32[0]);
                     boolean var35 = true;
                     float var36 = (float)(anazasel.mc.fontRendererObj.FONT_HEIGHT * 2) - (float)(anazasel.mc.fontRendererObj.FONT_HEIGHT / 2);
                     anazasel.mc.fontRendererObj.drawStringWithShadow(((EntityItem)tayurule).getEntityItem().getDisplayName(), (float)(var32[0] + var33 / 2.0D - (double)(anazasel.mc.fontRendererObj.getStringWidth(((EntityItem)tayurule).getEntityItem().getDisplayName()) / 2)), (float)var31[1] * 2.0F + var36, anazasel._whose((EntityItem)tayurule).brighter().getRGB());
                     GL11.glPopMatrix();
                  }
               }
            }
         }
      }

   }

   public static double[] _sparc(Minecraft atozurel, double posamibu, double ozuvebez) {
      double var5 = (double)posamibu;
      double var7 = (double)ozuvebez;
      switch(((Minecraft)atozurel).gameSettings.guiScale) {
      case 0:
         var5 = posamibu * 2.0D;
         var7 = ozuvebez * 2.0D;
         break;
      case 1:
         var5 = posamibu * 0.5D;
         var7 = ozuvebez * 0.5D;
      case 2:
      default:
         break;
      case 3:
         var5 = posamibu * 1.5D;
         var7 = ozuvebez * 1.5D;
      }

      return new double[]{var5, var7};
   }

   public boolean _harvest(EntityItem ozaceruc) {
      Object pubazafi = ((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemArmor || ((EntityItem)ozaceruc).getEntityItem().getItem() == Items.skull && !((EntityItem)ozaceruc).getEntityItem().getDisplayName().equalsIgnoreCase("Zombie Head") && !((EntityItem)ozaceruc).getEntityItem().getDisplayName().equalsIgnoreCase("Creeper Head") && !((EntityItem)ozaceruc).getEntityItem().getDisplayName().equalsIgnoreCase("Skeleton Skull") && !((EntityItem)ozaceruc).getEntityItem().getDisplayName().equalsIgnoreCase("Wither Skeleton Skull") && !((EntityItem)ozaceruc).getEntityItem().getDisplayName().equalsIgnoreCase(EnumChatFormatting.GREEN + "Frog's Hat") || ((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemAppleGold;
      if (((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemArmor) {
         for(Object var9 = 1; var9 < 5; ++var9) {
            Object farizoso = "";
            switch(var9) {
            case 1:
               farizoso = "helmet";
               break;
            case 2:
               farizoso = "chestplate";
               break;
            case 3:
               farizoso = "leggings";
               break;
            case 4:
               farizoso = "boots";
            }

            if (lovafibo._theme(4 + var9).getHasStack()) {
               Object noyeyuci = lovafibo._theme(4 + var9).getStack();
               if (noyeyuci.getItem().getUnlocalizedName().contains(farizoso) && ((EntityItem)ozaceruc).getEntityItem().getItem().getUnlocalizedName().contains(farizoso)) {
                  return lovafibo._annual(((EntityItem)ozaceruc).getEntityItem()) > lovafibo._annual(lovafibo._theme(4 + var9).getStack());
               }
            }
         }

         return !lovafibo._deserve(((EntityItem)ozaceruc).getEntityItem());
      } else if (((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemSword) {
         for(Object var8 = 9; var8 < 45; ++var8) {
            if (lovafibo._theme(var8).getHasStack() && lovafibo._theme(var8).getStack().getItem() instanceof ItemSword) {
               return lovafibo._reserved(((EntityItem)ozaceruc).getEntityItem()) > lovafibo._reserved(lovafibo._theme(var8).getStack());
            }
         }

         return !lovafibo._deserve(((EntityItem)ozaceruc).getEntityItem());
      } else if (((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemPickaxe) {
         for(Object var7 = 9; var7 < 45; ++var7) {
            if (lovafibo._theme(var7).getHasStack() && lovafibo._theme(var7).getStack().getItem() instanceof ItemPickaxe) {
               return lovafibo._baseball(((EntityItem)ozaceruc).getEntityItem()) > lovafibo._baseball(lovafibo._theme(var7).getStack());
            }
         }

         return !lovafibo._deserve(((EntityItem)ozaceruc).getEntityItem());
      } else if (((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemSpade) {
         for(Object var6 = 9; var6 < 45; ++var6) {
            if (lovafibo._theme(var6).getHasStack() && lovafibo._theme(var6).getStack().getItem() instanceof ItemSpade) {
               return lovafibo._baseball(((EntityItem)ozaceruc).getEntityItem()) > lovafibo._baseball(lovafibo._theme(var6).getStack());
            }
         }

         return !lovafibo._deserve(((EntityItem)ozaceruc).getEntityItem());
      } else if (((EntityItem)ozaceruc).getEntityItem().getItem() instanceof ItemAxe) {
         for(Object imabusov = 9; imabusov < 45; ++imabusov) {
            if (lovafibo._theme(imabusov).getHasStack() && lovafibo._theme(imabusov).getStack().getItem() instanceof ItemAxe) {
               return lovafibo._baseball(((EntityItem)ozaceruc).getEntityItem()) > lovafibo._baseball(lovafibo._theme(imabusov).getStack());
            }
         }

         return !lovafibo._deserve(((EntityItem)ozaceruc).getEntityItem());
      } else {
         return pubazafi;
      }
   }

   public float _annual(ItemStack ecupezor) {
      Object upomuvin = Float.intBitsToFloat(0);
      if (((ItemStack)ecupezor).getItem() instanceof ItemArmor) {
         Object tenagubo = (ItemArmor)((ItemStack)ecupezor).getItem();
         upomuvin = (float)((double)upomuvin + (double)tenagubo.damageReduceAmount + (double)((100 - tenagubo.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)ecupezor)) * 0.0075D);
         upomuvin = (float)((double)upomuvin + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, (ItemStack)ecupezor) / 100.0D);
         upomuvin = (float)((double)upomuvin + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, (ItemStack)ecupezor) / 100.0D);
         upomuvin = (float)((double)upomuvin + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, (ItemStack)ecupezor) / 100.0D);
         upomuvin = (float)((double)upomuvin + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)ecupezor) / 50.0D);
         upomuvin = (float)((double)upomuvin + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, (ItemStack)ecupezor) / 100.0D);
      }

      return upomuvin;
   }

   public float _reserved(ItemStack wrist) {
      Object yearly = Float.intBitsToFloat(0);
      Object baths = ((ItemStack)wrist).getItem();
      if (baths instanceof ItemTool) {
         yearly += (float)((ItemTool)baths).getMaxDamage();
      } else if (baths instanceof ItemSword) {
         yearly += ((ItemSword)baths).getDamageVsEntity();
      }

      yearly = yearly + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)wrist) * 1.25F + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)wrist) * 0.01F;
      return yearly;
   }

   public float _baseball(ItemStack swedish) {
      Object hours = ((ItemStack)swedish).getItem();
      if (!(hours instanceof ItemTool)) {
         return Float.intBitsToFloat(0);
      } else {
         Object harmful = hours.getUnlocalizedName();
         Object mistake = (ItemTool)hours;
         float holders;
         if (hours instanceof ItemPickaxe) {
            holders = mistake.getStrVsBlock((ItemStack)swedish, Blocks.stone);
            if (harmful.toLowerCase().contains("gold")) {
               holders -= 5.0F;
            }
         } else if (hours instanceof ItemSpade) {
            holders = mistake.getStrVsBlock((ItemStack)swedish, Blocks.dirt);
            if (harmful.toLowerCase().contains("gold")) {
               holders -= 5.0F;
            }
         } else {
            if (!(hours instanceof ItemAxe)) {
               return 1.0F;
            }

            holders = mistake.getStrVsBlock((ItemStack)swedish, Blocks.log);
            if (harmful.toLowerCase().contains("gold")) {
               holders -= 5.0F;
            }
         }

         holders = (float)((double)holders + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, (ItemStack)swedish) * 0.0075D);
         holders = (float)((double)holders + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)swedish) / 100.0D);
         return holders;
      }
   }

   public boolean _deserve(ItemStack ayizetuz) {
      for(Object vimelepe = 0; vimelepe < 3; ++vimelepe) {
         if (esilefof.mc.thePlayer.inventory.armorInventory[vimelepe] != null && esilefof.mc.thePlayer.inventory.armorInventory[vimelepe].getItem() == ((ItemStack)ayizetuz).getItem()) {
            return true;
         }
      }

      for(Object var4 = 9; var4 < 45; ++var4) {
         if (esilefof._theme(var4).getHasStack()) {
            Object rofitigi = esilefof._theme(var4).getStack();
            if (((ItemStack)ayizetuz).getItem() == rofitigi.getItem()) {
               return true;
            }
         }
      }

      return false;
   }

   public Slot _theme(int literacy) {
      return cingular.mc.thePlayer.inventoryContainer.getSlot((int)literacy);
   }

   public Color _whose(EntityItem madrid) {
      Object garbage = ((EntityItem)madrid).getEntityItem().getDisplayName();
      if (!garbage.equalsIgnoreCase(EnumChatFormatting.GOLD + "Excalibur") && !garbage.equalsIgnoreCase("aDragon Sword") && !garbage.equalsIgnoreCase(EnumChatFormatting.GREEN + "Cornucopia") && !garbage.equalsIgnoreCase(EnumChatFormatting.RED + "Bloodlust") && !garbage.equalsIgnoreCase(EnumChatFormatting.RED + "Artemis' Bow") && !garbage.equalsIgnoreCase(EnumChatFormatting.GREEN + "Miner's Blessing") && !garbage.equalsIgnoreCase(EnumChatFormatting.GOLD + "Axe of Perun") && !garbage.equalsIgnoreCase(EnumChatFormatting.GOLD + "Cornucopia")) {
         if (folding._update(((EntityItem)madrid).getEntityItem())) {
            return new Color(75, 189, 193);
         } else if (!folding._harvest((EntityItem)madrid)) {
            return new Color(255, 255, 255);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemArmor) {
            return new Color(75, 189, 193);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemAppleGold) {
            return new Color(255, 199, 71);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemSkull && folding._harvest((EntityItem)madrid)) {
            return new Color(255, 199, 71);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemSword) {
            return new Color(255, 117, 117);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemPickaxe) {
            return new Color(130, 219, 82);
         } else if (((EntityItem)madrid).getEntityItem().getItem() instanceof ItemSpade) {
            return new Color(130, 219, 82);
         } else {
            return ((EntityItem)madrid).getEntityItem().getItem() instanceof ItemAxe ? new Color(130, 219, 82) : new Color(255, 255, 255);
         }
      } else {
         Client.�?();
         Client.�?();
         HUD var3 = (HUD) ModuleManager._herbs(HUD.class);
         return new Color(HUD._cedar((int)(System.currentTimeMillis() / ((long)525601976 ^ 525699608L))));
      }
   }

   public Vector3d _browsers(ScaledResolution pepufafi, double netosiza, double nanezili, double var6) {
      GL11.glGetFloat(2982, adatadic.jewish$);
      GL11.glGetFloat(2983, adatadic.guidance$);
      GL11.glGetInteger(2978, adatadic.batch$);
      return GLU.gluProject((float)netosiza, (float)nanezili, (float)var6, adatadic.jewish$, adatadic.guidance$, adatadic.batch$, adatadic.runtime$) ? new Vector3d((double)(adatadic.runtime$.get(0) / (float)((ScaledResolution)pepufafi).getScaleFactor()), (double)(((float)Display.getHeight() - adatadic.runtime$.get(1)) / (float)((ScaledResolution)pepufafi).getScaleFactor()), (double)adatadic.runtime$.get(2)) : null;
   }

   public String _messages(ItemStack umacabof) {
      Object boyisife = ((ItemStack)umacabof).getItem();
      Object apamepev = Item.getIdFromItem(boyisife);
      Object ubesopod = "";
      if (apamepev == Item.getIdFromItem(Items.golden_apple) && ((ItemStack)umacabof).getRarity() == EnumRarity.EPIC) {
         return "§6§lNotch";
      } else {
         if (apamepev == Item.getIdFromItem(Items.diamond) || apamepev == Item.getIdFromItem(Items.diamond_sword) || apamepev == Item.getIdFromItem(Items.diamond_helmet) || apamepev == Item.getIdFromItem(Items.diamond_chestplate) || apamepev == Item.getIdFromItem(Items.diamond_leggings) || apamepev == Item.getIdFromItem(Items.diamond_boots)) {
            ubesopod = "§a§l";
         }

         if (apamepev == Item.getIdFromItem(Items.potionitem)) {
            ubesopod = "§7§l";
         }

         if (((ItemStack)umacabof).getItem() instanceof ItemEnchantedBook) {
            Object oralisag = Items.enchanted_book.getEnchantments((ItemStack)umacabof);
            Object desanibo = 0;
            if (desanibo < oralisag.tagCount()) {
               Object ricebepu = oralisag.getCompoundTagAt(desanibo).getShort("id");
               Object efogipeg = oralisag.getCompoundTagAt(desanibo).getShort("lvl");
               if (ricebepu == Enchantment.sharpness.effectId && efogipeg >= 1 || ricebepu == Enchantment.fireAspect.effectId || ricebepu == Enchantment.efficiency.effectId && efogipeg >= 3 || ricebepu == Enchantment.fortune.effectId || ricebepu == Enchantment.featherFalling.effectId && efogipeg >= 3 || ricebepu == Enchantment.protection.effectId || ricebepu == Enchantment.punch.effectId || ricebepu == Enchantment.flame.effectId || ricebepu == Enchantment.infinity.effectId || ricebepu == Enchantment.depthStrider.effectId) {
                  ubesopod = "§9";
               }

               ++desanibo;
            }
         }

         if (apamepev == Item.getIdFromItem(Items.diamond_sword)) {
            Object var12 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)umacabof);
            Object var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)umacabof);
            Object var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, (ItemStack)umacabof);
            if (var12 == 1) {
               ubesopod = "§7§l";
            }

            if (var12 == 2) {
               ubesopod = "§8§l";
            }

            if (var12 == 3) {
               ubesopod = "§e§l";
            }

            if (var12 >= 4) {
               ubesopod = "§c§l";
            }

            if (var10 >= 1) {
               ubesopod = "§4§l";
            }

            if (var10 >= 1 && var12 >= 3) {
               ubesopod = "§4§n";
            }
         }

         Object var13 = Pattern.compile("(?i)§[0-9A-FK-OR]").matcher(((ItemStack)umacabof).getDisplayName()).replaceAll("");
         return ubesopod + ((ItemStack)umacabof).getDisplayName();
      }
   }

   public void _trials(EntityItem session, String worldcat, double ordinary, double tells, double member, int anderson) {
      Object hydrogen = ((EntityItem)session).getDistanceSqToEntity(fabrics.mc.getRenderManager().livingPlayer);
      if (hydrogen <= (double)(anderson * anderson)) {
         Object facts = fabrics.mc.fontRendererObj;
         Object promo = 1.6F;
         Object lance = 0.016666668F * promo;
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)ordinary + Float.intBitsToFloat(0), (float)tells + ((EntityItem)session).height + 0.5F, (float)member);
         GL11.glNormal3f(Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
         GL11.glRotatef(-fabrics.mc.getRenderManager().playerViewY, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
         GL11.glRotatef(fabrics.mc.gameSettings.thirdPersonView == 2 ? -fabrics.mc.getRenderManager().playerViewX : fabrics.mc.getRenderManager().playerViewX, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
         GlStateManager.scale(-lance, -lance, lance);
         GlStateManager.depthMask(false);
         GlStateManager.disableDepth();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         Tessellator var15 = Tessellator.getInstance();
         WorldRenderer var16 = var15.getWorldRenderer();
         byte var17 = -2;
         int var18 = facts.getStringWidth((String)worldcat) / 2;
         GlStateManager.disableTexture2D();
         var16.begin(7, DefaultVertexFormats.POSITION_COLOR);
         var16.pos((double)(-var18 - 1), (double)(-1 + var17), Double.longBitsToDouble(0L)).color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 0.25F).endVertex();
         var16.pos((double)(-var18 - 1), (double)(8 + var17), Double.longBitsToDouble(0L)).color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 0.25F).endVertex();
         var16.pos((double)(var18 + 1), (double)(8 + var17), Double.longBitsToDouble(0L)).color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 0.25F).endVertex();
         var16.pos((double)(var18 + 1), (double)(-1 + var17), Double.longBitsToDouble(0L)).color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 0.25F).endVertex();
         var15.draw();
         GlStateManager.enableTexture2D();
         facts.drawString((String)worldcat, -facts.getStringWidth((String)worldcat) / 2, var17, 553648127);
         GlStateManager.enableDepth();
         GlStateManager.depthMask(true);
         facts.drawString((String)worldcat, -facts.getStringWidth((String)worldcat) / 2, var17, -1);
         GlStateManager.disableBlend();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }

   }
}
