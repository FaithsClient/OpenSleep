package linxiu.module.modules.render;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IRenderManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import org.lwjgl.opengl.GL11;

import java.util.regex.Pattern;

public class ItemTag extends Module {

	private final Numbers<Number> rangeValue = new Numbers<>("Range", 50.0, 5.0, 80.0, 1.0);
	public Option quantity = new Option("Quantity", true);
	public Option mega = new Option("MegaWalls", false);
	public Option throughWalls = new Option("ThroughWalls", true);

	public ItemTag() {
		super("ItemTag", new String[] { "ItemTag" }, ModuleType.Render);
	}

	@EventHandler
	public void Method802(EventRender3D a) {
		if (this.throughWalls.getValue()) {
			GL11.glEnable(32823);
			GL11.glPolygonOffset(1.0F, -1100000.0F);
		}
		for (Entity o : mc.theWorld.loadedEntityList) {
			if (o instanceof EntityItem) {
				EntityItem entityItem = (EntityItem) o;
				double var7 = a.getPartialTicks();
				double var9 = entityItem.lastTickPosX + (entityItem.posX - entityItem.lastTickPosX) * var7
						- ((IRenderManager) mc.getRenderManager()).getRenderPosX();
				double var11 = entityItem.lastTickPosY + (entityItem.posY - entityItem.lastTickPosY) * var7
						- ((IRenderManager) mc.getRenderManager()).getRenderPosY();
				double var13 = entityItem.lastTickPosZ + (entityItem.posZ - entityItem.lastTickPosZ) * var7
						- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
				String var15 = this.ItemNameCheck(entityItem.getEntityItem());
				String var16 = this.quantity.getValue() ? " §rx" + entityItem.getEntityItem().stackSize : "";
				if (this.MegaCheck(entityItem.getEntityItem())) {
					this.ItemNameTag(entityItem, var15 + var16, var9, var11, var13,
							this.rangeValue.getValue().intValue());
				}
			}
		}

		if (this.throughWalls.getValue()) {
			GL11.glDisable(32823);
			GL11.glPolygonOffset(1.0F, 1100000.0F);
		}
	}

	private boolean MegaCheck(ItemStack itemStack) {
		if (this.mega.getValue()) {
			Item var2 = itemStack.getItem();
			int var3 = Item.getIdFromItem(var2);
			return itemStack.hasDisplayName() || var3 == Item.getIdFromItem(Items.golden_apple)
					|| (var3 == Item.getIdFromItem(Items.skull) && itemStack.getItemDamage() == 3)
                    || var3 == Item.getIdFromItem(Items.enchanted_book)
                    || var3 == Item.getIdFromItem(Items.diamond_sword)
                    || var3 == Item.getIdFromItem(Items.diamond_helmet)
                    || var3 == Item.getIdFromItem(Items.diamond_chestplate)
                    || var3 == Item.getIdFromItem(Items.diamond_leggings)
                    || var3 == Item.getIdFromItem(Items.diamond_boots)
                    || var3 == Item.getIdFromItem(Items.tnt_minecart)
                    || var3 == Item.getIdFromItem(Items.potionitem)
                    || var3 == Item.getIdFromItem(Items.golden_carrot)
                    || var3 == Item.getIdFromItem(Items.diamond)
                    || var3 == Item.getIdFromItem(Items.gold_ingot)
                    || var3 == Item.getIdFromItem(Items.iron_ingot)
                    || var3 == 338 || var3 == 145 || var3 == 84 || var3 == 111;
		}

		return true;
	}

	private String ItemNameCheck(ItemStack itemStack) {
		Item var3 = itemStack.getItem();
		int var4 = Item.getIdFromItem(var3);
		String var5 = "";
		if (var4 == Item.getIdFromItem(Items.golden_apple) && itemStack.getRarity() == EnumRarity.EPIC) {
			return "§6§lNotch";
		} else {
			if (var4 == Item.getIdFromItem(Items.diamond) || var4 == Item.getIdFromItem(Items.diamond_sword)
					|| var4 == Item.getIdFromItem(Items.diamond_helmet)
					|| var4 == Item.getIdFromItem(Items.diamond_chestplate)
					|| var4 == Item.getIdFromItem(Items.diamond_leggings)
					|| var4 == Item.getIdFromItem(Items.diamond_boots)) {
				var5 = "§a§l";
			}

			if (var4 == Item.getIdFromItem(Items.potionitem)) {
				var5 = "§7§l";
			}

			int var7;
			int var8;
			if (itemStack.getItem() instanceof ItemEnchantedBook) {
				NBTTagList var6 = Items.enchanted_book.getEnchantments(itemStack);
				var7 = 0;
				if (var7 < var6.tagCount()) {
					var8 = var6.getCompoundTagAt(var7).getShort("id");
					short var9 = var6.getCompoundTagAt(var7).getShort("lvl");
					if (var8 == Enchantment.sharpness.effectId && var9 >= 1 || var8 == Enchantment.fireAspect.effectId
							|| var8 == Enchantment.efficiency.effectId && var9 >= 3
							|| var8 == Enchantment.fortune.effectId
							|| var8 == Enchantment.featherFalling.effectId && var9 >= 3
							|| var8 == Enchantment.protection.effectId || var8 == Enchantment.punch.effectId
							|| var8 == Enchantment.flame.effectId || var8 == Enchantment.infinity.effectId
							|| var8 == Enchantment.depthStrider.effectId) {
						var5 = "§9";
					}

					++var7;
				}
			}

			if (var4 == Item.getIdFromItem(Items.diamond_sword)) {
				int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, itemStack);
				var7 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, itemStack);
				var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, itemStack);
				if (var10 == 1) {
					var5 = "§7§l";
				}

				if (var10 == 2) {
					var5 = "§8§l";
				}

				if (var10 == 3) {
					var5 = "§e§l";
				}

				if (var10 >= 4) {
					var5 = "§c§l";
				}

				if (var7 >= 1) {
					var5 = "§4§l";
				}

				if (var7 >= 1 && var10 >= 3) {
					var5 = "§4§n";
				}
			}

			String var11 = Pattern.compile("(?i)§[0-9A-FK-OR]").matcher(itemStack.getDisplayName()).replaceAll("");
			return var5 + itemStack.getDisplayName();
		}
	}

	protected void ItemNameTag(EntityItem entityItem, String st, double a, double b, double c, int d) {
		double var11 = entityItem.getDistanceSqToEntity(mc.getRenderManager().livingPlayer);
		if (var11 <= (double) (d * d)) {
			FontRenderer var13 = mc.fontRendererObj;
			float var14 = 1.6F;
			float var15 = 0.016666668F * var14;
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) a + 0.0F, (float) b + entityItem.height + 0.5F, (float) c);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);

			GL11.glRotatef(-mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(mc.gameSettings.thirdPersonView == 2 ? -mc.getRenderManager().playerViewX
					: mc.getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
			GlStateManager.scale(-var15, -var15, var15);
			GlStateManager.depthMask(false);
			GlStateManager.disableDepth();
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			Tessellator var16 = Tessellator.getInstance();
			WorldRenderer var17 = var16.getWorldRenderer();
			byte var18 = -2;
			int var19 = var13.getStringWidth(st) / 2;
			GlStateManager.disableTexture2D();
			var17.begin(7, DefaultVertexFormats.POSITION_COLOR);
			var17.pos(-var19 - 1, -1 + var18, 0.0).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
			var17.pos(-var19 - 1, 8 + var18, 0.0).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
			var17.pos(var19 + 1, 8 + var18, 0.0).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
			var17.pos(var19 + 1, -1 + var18, 0.0).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
			var16.draw();
			GlStateManager.enableTexture2D();
			var13.drawString(st, -var13.getStringWidth(st) / 2, var18, 553648127);
			GlStateManager.enableDepth();
			GlStateManager.depthMask(true);
			var13.drawString(st, -var13.getStringWidth(st) / 2, var18, -1);
			GlStateManager.disableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.popMatrix();
		}

	}
}