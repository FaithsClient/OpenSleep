package rip.sleep.module.modules;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
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
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.RenderUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class ItemESP extends Module {
   private final IntBuffer c81907 = GLAllocation.createDirectIntBuffer(16);
   private final FloatBuffer c85773 = GLAllocation.createDirectFloatBuffer(16);
   private final FloatBuffer c62838 = GLAllocation.createDirectFloatBuffer(16);
   private final FloatBuffer c55753 = GLAllocation.createDirectFloatBuffer(4);
   public BooleanValue c70496 = new BooleanValue("ESP", true);
   public BooleanValue c41084 = new BooleanValue("Font", false);
   public BooleanValue c71455 = new BooleanValue("Names", true);
   public BooleanValue c1270 = new BooleanValue("MegaWalls", false);
   public BooleanValue c76932 = new BooleanValue("neededOnly", false);

   public ItemESP() {
      super("Item ESP", new String[]{"ItemESP"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   private boolean c70012(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      int var4 = Item.getIdFromItem(var3);
      return var1.hasDisplayName() || var4 == Item.getIdFromItem(Items.diamond_sword) || var4 == Item.getIdFromItem(Items.diamond_helmet) || var4 == Item.getIdFromItem(Items.diamond_chestplate) || var4 == Item.getIdFromItem(Items.diamond) || var4 == Item.getIdFromItem(Items.diamond_leggings) || var4 == Item.getIdFromItem(Items.diamond_boots);
   }

   private boolean c1983(ItemStack var1) {
      Module[] var2 = Value.c27574();
      if (!this.c1270.c1473().booleanValue()) {
         return true;
      } else {
         Item var3 = var1.getItem();
         int var4 = Item.getIdFromItem(var3);
         return var1.hasDisplayName() || var4 == Item.getIdFromItem(Items.golden_apple) || var4 == Item.getIdFromItem(Items.skull) && var1.getItemDamage() == 3 || var4 == Item.getIdFromItem(Items.enchanted_book) || var4 == Item.getIdFromItem(Items.diamond_sword) || var4 == Item.getIdFromItem(Items.diamond_helmet) || var4 == Item.getIdFromItem(Items.diamond_chestplate) || var4 == Item.getIdFromItem(Items.milk_bucket) || var4 == Item.getIdFromItem(Items.diamond) || var4 == Item.getIdFromItem(Items.diamond_leggings) || var4 == Item.getIdFromItem(Items.diamond_boots) || var4 == Item.getIdFromItem(Items.potionitem) || var4 == Item.getIdFromItem(Items.golden_carrot);
      }
   }

   @EventTarget
   public void c44340(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      Iterator var3 = mc.theWorld.getLoadedEntityList().iterator();
      if (var3.hasNext()) {
         Entity var4 = (Entity)var3.next();
         if (var4 instanceof EntityItem) {
            EntityItem var5 = (EntityItem)var4;
            if (this.c1983(var5.getEntityItem())) {
               IBakedModel var6 = mc.getRenderItem().getItemModelMesher().getItemModel(((EntityItem)var4).getEntityItem());
               float var7 = MathHelper.sin(((float)((EntityItem)var4).getAge() + var1.c36064()) / 10.0F + ((EntityItem)var4).hoverStart) * 0.1F - 0.1F;
               float var8 = var6.getItemCameraTransforms().getTransform(TransformType.GROUND).scale.y;
               double var9 = RenderUtilD.c86345(var4.posX, var4.lastTickPosX, var1.c36064());
               double var11 = RenderUtilD.c86345(var4.posY + (double)var7, var4.lastTickPosY + (double)var7, var1.c36064());
               double var13 = RenderUtilD.c86345(var4.posZ, var4.lastTickPosZ, var1.c36064());
               double var15 = (double)var4.width / 0.5D;
               double var17 = (double)var4.height + 0.7D;
               AxisAlignedBB var19 = new AxisAlignedBB(var9 - var15, var11, var13 - var15, var9 + var15, var11 + var17, var13 + var15);
               List var20 = Arrays.asList(new Vector3d(var19.minX, var19.minY, var19.minZ), new Vector3d(var19.minX, var19.maxY, var19.minZ), new Vector3d(var19.maxX, var19.minY, var19.minZ), new Vector3d(var19.maxX, var19.maxY, var19.minZ), new Vector3d(var19.minX, var19.minY, var19.maxZ), new Vector3d(var19.minX, var19.maxY, var19.maxZ), new Vector3d(var19.maxX, var19.minY, var19.maxZ), new Vector3d(var19.maxX, var19.maxY, var19.maxZ));
               mc.entityRenderer.setupCameraTransform(var1.c36064(), 0);
               Vector4d var21 = null;
               Iterator var22 = var20.iterator();
               if (var22.hasNext()) {
                  Vector3d var23 = (Vector3d)var22.next();
                  var23 = this.c98041(var1.c26056(), var23.x - mc.getRenderManager().viewerPosX, var23.y - mc.getRenderManager().viewerPosY, var23.z - mc.getRenderManager().viewerPosZ);
                  if (var23 != null && var23.z >= 0.0D && var23.z < 1.0D) {
                     if (var21 == null) {
                        var21 = new Vector4d(var23.x, var23.y, var23.z, 0.0D);
                     }

                     var21.x = Math.min(var23.x, var21.x);
                     var21.y = Math.min(var23.y, var21.y);
                     var21.z = Math.max(var23.x, var21.z);
                     var21.w = Math.max(var23.y, var21.w);
                  }
               }

               mc.entityRenderer.setupOverlayRendering();
               if (!this.c76932.c1473().booleanValue() || this.c33164((EntityItem)var4)) {
                  double var38 = var21.x;
                  double var24 = var21.y;
                  double var26 = var21.z;
                  double var28 = var21.w;
                  if (this.c70496.c1473().booleanValue()) {
                     RenderUtilD.c90797(var38, var24, var26, var28, this.c33164((EntityItem)var4) ? 4.0D : 3.0D, Color.BLACK);
                     RenderUtilD.c90797(var38, var24, var26, var28, this.c33164((EntityItem)var4) ? 2.0D : 1.0D, this.c17405((EntityItem)var4));
                  }

                  if (this.c71455.c1473().booleanValue()) {
                     float var30 = 1.0F;
                     switch(mc.gameSettings.guiScale) {
                     case 0:
                        var30 = 0.5F;
                     case 1:
                        var30 = 2.0F;
                     case 3:
                        var30 = 0.6666667F;
                     case 2:
                     default:
                        double[] var31 = c8243(mc, var38, var24);
                        double[] var32 = c8243(mc, var26, var28);
                        double[] var33 = new double[]{var31[0] * 2.0D, var31[1] * 2.0D, var32[0] * 2.0D, var32[1] * 2.0D};
                        GL11.glPushMatrix();
                        GL11.glScalef(0.5F * var30, 0.5F * var30, 0.5F * var30);
                        double var34 = Math.abs(var33[2] - var33[0]);
                        boolean var36 = true;
                        if (!this.c41084.c1473().booleanValue()) {
                           float var37 = (float)(mc.fontRendererObj.FONT_HEIGHT * (this.c70496.c1473().booleanValue() ? 2 : 0)) - (float)(mc.fontRendererObj.FONT_HEIGHT / 2);
                        }

                        float var42 = (float)(FontManager.c37683.c5657() * (this.c70496.c1473().booleanValue() ? 2 : 0)) - (float)(FontManager.c37683.c5657() / 2);
                        if (!this.c41084.c1473().booleanValue()) {
                           mc.fontRendererObj.drawStringWithShadow(((EntityItem)var4).getEntityItem().getDisplayName(), (float)(var33[0] + var34 / 2.0D - (double)(mc.fontRendererObj.getStringWidth(((EntityItem)var4).getEntityItem().getDisplayName()) / 2)), (float)var32[1] * 2.0F + var42, this.c17405((EntityItem)var4).brighter().getRGB());
                        }

                        FontManager.c37683.c17470(((EntityItem)var4).getEntityItem().getDisplayName(), (double)((float)(var33[0] + var34 / 2.0D + 1.0D - (double)(FontManager.c37683.c65036(((EntityItem)var4).getEntityItem().getDisplayName()) / 2))), (double)((float)var32[1] * 2.0F + var42), this.c17405((EntityItem)var4).brighter().getRGB());
                        GL11.glPopMatrix();
                     }
                  }
               }
            }
         }
      }

   }

   public static double[] c8243(Minecraft var0, double var1, double var3) {
      double var6 = var1;
      Value.c27574();
      double var8 = var3;
      switch(var0.gameSettings.guiScale) {
      case 0:
         var6 = var1 * 2.0D;
         var8 = var3 * 2.0D;
      case 1:
         var6 *= 0.5D;
         var8 *= 0.5D;
      case 3:
         var6 *= 1.5D;
         var8 *= 1.5D;
      case 2:
      default:
         return new double[]{var6, var8};
      }
   }

   private boolean c33164(EntityItem var1) {
      Module[] var2 = Value.c27574();
      boolean var3 = var1.getEntityItem().getItem() instanceof ItemArmor || var1.getEntityItem().getItem() == Items.skull && !var1.getEntityItem().getDisplayName().equalsIgnoreCase("Zombie Head") && !var1.getEntityItem().getDisplayName().equalsIgnoreCase("Creeper Head") && !var1.getEntityItem().getDisplayName().equalsIgnoreCase("Skeleton Skull") && !var1.getEntityItem().getDisplayName().equalsIgnoreCase("Wither Skeleton Skull") && !var1.getEntityItem().getDisplayName().equalsIgnoreCase(EnumChatFormatting.GREEN + "Frog's Hat") || var1.getEntityItem().getItem() instanceof ItemAppleGold;
      if (var1.getEntityItem().getItem() instanceof ItemArmor) {
         int var15 = 1;
         if (var15 < 5) {
            String var17 = "";
            switch(var15) {
            case 1:
               var17 = "helmet";
            case 2:
               var17 = "chestplate";
            case 3:
               var17 = "leggings";
            case 4:
               var17 = "boots";
            default:
               if (this.c51674(4 + var15).getHasStack()) {
                  ItemStack var6 = this.c51674(4 + var15).getStack();
                  if (var6.getItem().getUnlocalizedName().contains(var17) && var1.getEntityItem().getItem().getUnlocalizedName().contains(var17)) {
                     return this.c86386(var1.getEntityItem()) > this.c86386(this.c51674(4 + var15).getStack());
                  }
               }

               ++var15;
            }
         }

         return !this.c26216(var1.getEntityItem());
      } else if (var1.getEntityItem().getItem() instanceof ItemSword) {
         int var13 = 9;
         if (var13 < 45) {
            if (this.c51674(var13).getHasStack() && this.c51674(var13).getStack().getItem() instanceof ItemSword) {
               return this.c19874(var1.getEntityItem()) > this.c19874(this.c51674(var13).getStack());
            }

            ++var13;
         }

         return !this.c26216(var1.getEntityItem());
      } else if (var1.getEntityItem().getItem() instanceof ItemPickaxe) {
         int var11 = 9;
         if (var11 < 45) {
            if (this.c51674(var11).getHasStack() && this.c51674(var11).getStack().getItem() instanceof ItemPickaxe) {
               return this.c5832(var1.getEntityItem()) > this.c5832(this.c51674(var11).getStack());
            }

            ++var11;
         }

         return !this.c26216(var1.getEntityItem());
      } else if (var1.getEntityItem().getItem() instanceof ItemSpade) {
         int var9 = 9;
         if (var9 < 45) {
            if (this.c51674(var9).getHasStack() && this.c51674(var9).getStack().getItem() instanceof ItemSpade) {
               return this.c5832(var1.getEntityItem()) > this.c5832(this.c51674(var9).getStack());
            }

            ++var9;
         }

         return !this.c26216(var1.getEntityItem());
      } else if (var1.getEntityItem().getItem() instanceof ItemAxe) {
         int var7 = 9;
         if (var7 < 45) {
            if (this.c51674(var7).getHasStack() && this.c51674(var7).getStack().getItem() instanceof ItemAxe) {
               return this.c5832(var1.getEntityItem()) > this.c5832(this.c51674(var7).getStack());
            }

            ++var7;
         }

         return !this.c26216(var1.getEntityItem());
      } else if (!this.c1270.c1473().booleanValue()) {
         return var3;
      } else {
         Item var4 = var1.getEntityItem().getItem();
         int var5 = Item.getIdFromItem(var4);
         return var1.getEntityItem().hasDisplayName() || var5 == Item.getIdFromItem(Items.golden_apple) || var5 == Item.getIdFromItem(Items.skull) && var1.getEntityItem().getItemDamage() == 3 || var5 == Item.getIdFromItem(Items.enchanted_book) || var5 == Item.getIdFromItem(Items.diamond_sword) || var5 == Item.getIdFromItem(Items.diamond_helmet) || var5 == Item.getIdFromItem(Items.diamond_chestplate) || var5 == Item.getIdFromItem(Items.milk_bucket) || var5 == Item.getIdFromItem(Items.diamond) || var5 == Item.getIdFromItem(Items.diamond_leggings) || var5 == Item.getIdFromItem(Items.diamond_boots) || var5 == Item.getIdFromItem(Items.potionitem) || var5 == Item.getIdFromItem(Items.golden_carrot);
      }
   }

   private float c86386(ItemStack var1) {
      Value.c27574();
      float var3 = 0.0F;
      if (var1.getItem() instanceof ItemArmor) {
         ItemArmor var4 = (ItemArmor)var1.getItem();
         var3 = (float)((double)var3 + (double)var4.damageReduceAmount + (double)((100 - var4.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var1)) * 0.0075D);
         var3 = (float)((double)var3 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, var1) / 100.0D);
         var3 = (float)((double)var3 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, var1) / 100.0D);
         var3 = (float)((double)var3 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, var1) / 100.0D);
         var3 = (float)((double)var3 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1) / 50.0D);
         var3 = (float)((double)var3 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, var1) / 100.0D);
      }

      return var3;
   }

   private float c19874(ItemStack var1) {
      Value.c27574();
      float var3 = 0.0F;
      Item var4 = var1.getItem();
      if (var4 instanceof ItemTool) {
         var3 += (float)((ItemTool)var4).func_77612_l();
      }

      if (var4 instanceof ItemSword) {
         var3 += ((ItemSword)var4).getDamageVsEntity();
      }

      var3 = var3 + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var1) * 1.25F + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var1) * 0.01F;
      return var3;
   }

   private float c5832(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemTool)) {
         return 0.0F;
      } else {
         float var6;
         label36: {
            String var4 = var3.getUnlocalizedName();
            ItemTool var5 = (ItemTool)var3;
            if (var3 instanceof ItemPickaxe) {
               var6 = var5.getStrVsBlock(var1, Blocks.stone);
               if (!var4.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (var3 instanceof ItemSpade) {
               var6 = var5.getStrVsBlock(var1, Blocks.dirt);
               if (!var4.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (!(var3 instanceof ItemAxe)) {
               return 1.0F;
            }

            var6 = var5.getStrVsBlock(var1, Blocks.log);
            if (var4.toLowerCase().contains("gold")) {
               var6 = var6 - 5.0F;
               return 1.0F;
            }
         }

         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1) * 0.0075D);
         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1) / 100.0D);
         return var6;
      }
   }

   private boolean c26216(ItemStack var1) {
      Value.c27574();
      int var3 = 0;
      if (var3 < 3) {
         if (mc.thePlayer.inventory.armorInventory[var3] != null && mc.thePlayer.inventory.armorInventory[var3].getItem() == var1.getItem()) {
            return true;
         }

         ++var3;
      }

      var3 = 9;
      if (var3 < 45) {
         if (this.c51674(var3).getHasStack()) {
            ItemStack var4 = this.c51674(var3).getStack();
            if (var1.getItem() == var4.getItem()) {
               return true;
            }
         }

         ++var3;
      }

      return false;
   }

   public Slot c51674(int var1) {
      return mc.thePlayer.inventoryContainer.getSlot(var1);
   }

   private Color c17405(EntityItem var1) {
      Value.c27574();
      String var3 = var1.getEntityItem().getDisplayName();
      if (!var3.equalsIgnoreCase(EnumChatFormatting.GOLD + "Excalibur") && !var3.equalsIgnoreCase("aDragon Sword") && !var3.equalsIgnoreCase(EnumChatFormatting.GREEN + "Cornucopia") && !var3.equalsIgnoreCase(EnumChatFormatting.RED + "Bloodlust") && !var3.equalsIgnoreCase(EnumChatFormatting.RED + "Artemis' Bow") && !var3.equalsIgnoreCase(EnumChatFormatting.GREEN + "Miner's Blessing") && !var3.equalsIgnoreCase(EnumChatFormatting.GOLD + "Axe of Perun") && !var3.equalsIgnoreCase(EnumChatFormatting.GOLD + "Cornucopia")) {
         if (this.c70012(var1.getEntityItem())) {
            return new Color(75, 189, 193);
         } else if (!this.c33164(var1)) {
            return new Color(255, 255, 255);
         } else {
            if (this.c1270.c1473().booleanValue()) {
               Item var6 = var1.getEntityItem().getItem();
               int var5 = Item.getIdFromItem(var6);
               if (var5 == Item.getIdFromItem(Items.potionitem)) {
                  return new Color(20, 180, 120);
               }
            }

            if (var1.getEntityItem().getItem() instanceof ItemArmor) {
               return new Color(75, 189, 193);
            } else if (var1.getEntityItem().getItem() instanceof ItemAppleGold) {
               return new Color(255, 199, 71);
            } else if (var1.getEntityItem().getItem() instanceof ItemSkull && this.c33164(var1)) {
               return new Color(255, 199, 71);
            } else if (var1.getEntityItem().getItem() instanceof ItemSword) {
               return new Color(255, 117, 117);
            } else if (var1.getEntityItem().getItem() instanceof ItemPickaxe) {
               return new Color(130, 219, 82);
            } else if (var1.getEntityItem().getItem() instanceof ItemSpade) {
               return new Color(130, 219, 82);
            } else {
               return var1.getEntityItem().getItem() instanceof ItemAxe ? new Color(130, 219, 82) : new Color(255, 255, 255);
            }
         }
      } else {
         Sleep.getInstance();
         Sleep.c33759();
         HUD var4 = (HUD) ModuleManager.c25475(HUD.class);
         return new Color(HUD.c79151((int)(System.currentTimeMillis() / 100000L)));
      }
   }

   private Vector3d c98041(ScaledResolution var1, double var2, double var4, double var6) {
      GL11.glGetFloat(2982, this.c85773);
      GL11.glGetFloat(2983, this.c62838);
      GL11.glGetInteger(2978, this.c81907);
      return GLU.gluProject((float)var2, (float)var4, (float)var6, this.c85773, this.c62838, this.c81907, this.c55753) ? new Vector3d((double)(this.c55753.get(0) / (float)var1.getScaleFactor()), (double)(((float)Display.getHeight() - this.c55753.get(1)) / (float)var1.getScaleFactor()), (double)this.c55753.get(2)) : null;
   }

   private String c6120(ItemStack var1) {
      Item var3 = var1.getItem();
      Value.c27574();
      int var4 = Item.getIdFromItem(var3);
      String var5 = "";
      if (var4 == Item.getIdFromItem(Items.golden_apple) && var1.getRarity() == EnumRarity.EPIC) {
         return "§6§lNotch";
      } else {
         if (var4 == Item.getIdFromItem(Items.diamond) || var4 == Item.getIdFromItem(Items.diamond_sword) || var4 == Item.getIdFromItem(Items.diamond_helmet) || var4 == Item.getIdFromItem(Items.diamond_chestplate) || var4 == Item.getIdFromItem(Items.diamond_leggings) || var4 == Item.getIdFromItem(Items.diamond_boots)) {
            var5 = "§a§l";
         }

         if (var4 == Item.getIdFromItem(Items.potionitem)) {
            var5 = "§7§l";
         }

         if (var1.getItem() instanceof ItemEnchantedBook) {
            NBTTagList var8 = Items.enchanted_book.getEnchantments(var1);
            int var6 = 0;
            if (var6 < var8.tagCount()) {
               short var7 = var8.getCompoundTagAt(var6).getShort("id");
               short var9 = var8.getCompoundTagAt(var6).getShort("lvl");
               if (var7 == Enchantment.sharpness.effectId && var9 >= 1 || var7 == Enchantment.fireAspect.effectId || var7 == Enchantment.efficiency.effectId && var9 >= 3 || var7 == Enchantment.fortune.effectId || var7 == Enchantment.featherFalling.effectId && var9 >= 3 || var7 == Enchantment.protection.effectId || var7 == Enchantment.punch.effectId || var7 == Enchantment.flame.effectId || var7 == Enchantment.infinity.effectId || var7 == Enchantment.depthStrider.effectId) {
                  var5 = "§9";
               }

               ++var6;
            }
         }

         if (var4 == Item.getIdFromItem(Items.diamond_sword)) {
            int var13 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var1);
            int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var1);
            int var12 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, var1);
            if (var13 == 1) {
               var5 = "§7§l";
            }

            if (var13 == 2) {
               var5 = "§8§l";
            }

            if (var13 == 3) {
               var5 = "§e§l";
            }

            if (var13 >= 4) {
               var5 = "§c§l";
            }

            if (var11 >= 1) {
               var5 = "§4§l";
            }

            if (var11 >= 1 && var13 >= 3) {
               var5 = "§4§n";
            }
         }

         String var14 = Pattern.compile("(?i)§[0-9A-FK-OR]").matcher(var1.getDisplayName()).replaceAll("");
         return var5 + var1.getDisplayName();
      }
   }

   protected void c91362(EntityItem var1, String var2, double var3, double var5, double var7, int var9) {
      Value.c27574();
      double var11 = var1.func_70068_e(mc.getRenderManager().livingPlayer);
      if (var11 <= (double)(var9 * var9)) {
         FontRenderer var13 = mc.fontRendererObj;
         float var14 = 1.6F;
         float var15 = 0.016666668F * var14;
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)var3 + 0.0F, (float)var5 + var1.field_70131_O + 0.5F, (float)var7);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(mc.gameSettings.thirdPersonView == 2 ? -mc.getRenderManager().playerViewX : mc.getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
         GlStateManager.scale(-var15, -var15, var15);
         GlStateManager.depthMask(false);
         GlStateManager.disableDepth();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         Tessellator var16 = Tessellator.getInstance();
         WorldRenderer var17 = var16.getWorldRenderer();
         byte var18 = -2;
         int var19 = var13.getStringWidth(var2) / 2;
         GlStateManager.disableTexture2D();
         var17.begin(7, DefaultVertexFormats.POSITION_COLOR);
         var17.pos((double)(-var19 - 1), (double)(-1 + var18), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var17.pos((double)(-var19 - 1), (double)(8 + var18), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var17.pos((double)(var19 + 1), (double)(8 + var18), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var17.pos((double)(var19 + 1), (double)(-1 + var18), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var16.draw();
         GlStateManager.enableTexture2D();
         var13.drawString(var2, -var13.getStringWidth(var2) / 2, var18, 553648127);
         GlStateManager.enableDepth();
         GlStateManager.depthMask(true);
         var13.drawString(var2, -var13.getStringWidth(var2) / 2, var18, -1);
         GlStateManager.disableBlend();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
