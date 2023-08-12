package linxiu.module.modules.player;


import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.*;

import java.awt.*;


public class ChestStealer extends Module {
	private final Numbers<Number> delay = new Numbers<Number>("Delay", "Delay", 1.0, 0.0, 5.0, 0.1);
	public static Option menucheck = new Option("MenuCheck", "MenuCheck", true);
	public static Option slient = new Option("Slient", "Slient", false);
	private final TimerUtil timer = new TimerUtil();

	public ChestStealer() {
		super("ChestStealer", new String[] { "cheststeal", "chests", "stealer" }, ModuleType.Player);
		this.setColor(new Color(218, 97, 127).getRGB());
	}
	
	@EventHandler
	public void onRender2D(EventRender2D e) {
		if (this.mc.thePlayer.openContainer != null && this.mc.thePlayer.openContainer instanceof ContainerChest) {
			//mc.fontRendererObj.drawStringWithShadow("OPEN Chest",(float) (SuIcFuNcE.getres().getScaledWidth_double() / 2) - mc.fontRendererObj.getStringWidth("OPEN Chest"),SuIcFuNcE.getres().getScaledHeight() / 2 - 20,new Color(255,255,255).getRGB());
		}
	}

	@EventHandler
	private void onUpdate(EventPreUpdate event) {
		 if (mc.thePlayer.openContainer != null) {
             if (mc.thePlayer.openContainer instanceof ContainerChest) {
                 ContainerChest container = (ContainerChest) mc.thePlayer.openContainer;
                 if (menucheck.getValue()) {
                
                     String name = container.getLowerChestInventory().getDisplayName().getUnformattedText().toLowerCase();
                     String[] list = new String[]{"menu", "selector", "game", "gui", "server", "inventory", "play", "teleporter", "shop", "melee", "armor",
                             "block", "castle", "mini", "warp", "teleport", "user", "team", "tool", "sure", "trade", "cancel", "accept", "soul", "book", "recipe",
                             "profile", "tele", "port", "map", "kit", "select", "lobby", "vault", "lock", "anticheat", "travel", "settings", "user", "preference",
                             "compass", "cake", "wars", "buy", "upgrade", "ranged", "potions", "utility"};
                     for (String str : list) {
                         if (name.contains(str))
                             return;
                     }
                 }

                 for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); ++i) {
                     if (container.getLowerChestInventory().getStackInSlot(i) != null && timer.hasTimeElapsed(delay.getValue().longValue() * 100L) && (!(container.getLowerChestInventory().getStackInSlot(i).getItem() instanceof ItemArmor) || betterCheck(container, container.getLowerChestInventory().getStackInSlot(i), i)) && (!(container.getLowerChestInventory().getStackInSlot(i).getItem() instanceof ItemSword) || (double) this.getDamage(container.getLowerChestInventory().getStackInSlot(i)) >= this.bestDamage(container, i))) {
                         mc.playerController.windowClick(container.windowId, i, 0, 1, mc.thePlayer);
                         timer.reset();
                     }
                 }
                 if (isEmpty()) mc.thePlayer.closeScreen();
             }
         }
	}

	 private boolean isEmpty() {
	        if (mc.thePlayer.openContainer != null) {
	            if (mc.thePlayer.openContainer instanceof ContainerChest) {
	                ContainerChest container = (ContainerChest) mc.thePlayer.openContainer;
	                for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); ++i) {
	                    ItemStack itemStack = container.getLowerChestInventory().getStackInSlot(i);
	                    if (itemStack != null && itemStack.getItem() != null
	                            && (!(itemStack.getItem() instanceof ItemArmor)
	                            || betterCheck(container, itemStack, i))
	                            && (!(itemStack.getItem() instanceof ItemSword)
	                            || (double) getDamage(itemStack) >= bestDamage(container, i))) {
	                        return false;
	                    }
	                }
	            }
	        }
	        return true;
	    }

	    private boolean betterCheck(ContainerChest c, ItemStack item, int slot) {
	        double item1 = (double) ((ItemArmor) item.getItem()).damageReduceAmount + getProtectionValue(item);
	        double item2 = 0.0D;
	        int bestslot = 0;
	        int i;
	        double temp;
	        double var12;
	        if (item.getUnlocalizedName().contains("helmet")) {
	            for (i = 0; i < 45; ++i) {
	                if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
	                    if (mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem().getUnlocalizedName()
	                            .contains("helmet")) {
	                        var12 = ((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(i).getStack()
	                                .getItem()).damageReduceAmount;
	                        temp = var12 + getProtectionValue(mc.thePlayer.inventoryContainer.getSlot(i).getStack());
	                        if (temp > item2) {
	                            item2 = temp;
	                            bestslot = i;
	                        }
	                    }
	                }
	            }

	            for (i = 0; i < c.getLowerChestInventory().getSizeInventory(); ++i) {
	                if (c.getLowerChestInventory().getStackInSlot(i) != null
	                        && c.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().contains("helmet")) {
	                    temp = (double) ((ItemArmor) c.getLowerChestInventory().getStackInSlot(i)
	                            .getItem()).damageReduceAmount
	                            + getProtectionValue(c.getLowerChestInventory().getStackInSlot(i));
	                    if (temp > item2) {
	                        item2 = temp;
	                        bestslot = i;
	                    }
	                }
	            }
	        }

	        if (item.getUnlocalizedName().contains("chestplate")) {
	            for (i = 0; i < 45; ++i) {
	                if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
	                    if (mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem().getUnlocalizedName()
	                            .contains("chestplate")) {
	                        var12 = ((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(i).getStack()
	                                .getItem()).damageReduceAmount;
	                        temp = var12 + getProtectionValue(mc.thePlayer.inventoryContainer.getSlot(i).getStack());
	                        if (temp > item2) {
	                            item2 = temp;
	                            bestslot = i;
	                        }
	                    }
	                }
	            }

	            for (i = 0; i < c.getLowerChestInventory().getSizeInventory(); ++i) {
	                if (c.getLowerChestInventory().getStackInSlot(i) != null
	                        && c.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().contains("chestplate")) {
	                    temp = (double) ((ItemArmor) c.getLowerChestInventory().getStackInSlot(i)
	                            .getItem()).damageReduceAmount
	                            + getProtectionValue(c.getLowerChestInventory().getStackInSlot(i));
	                    if (temp > item2) {
	                        item2 = temp;
	                        bestslot = i;
	                    }
	                }
	            }
	        }

	        if (item.getUnlocalizedName().contains("leggings")) {
	            for (i = 0; i < 45; ++i) {
	                if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
	                    if (mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem().getUnlocalizedName()
	                            .contains("leggings")) {
	                        var12 = ((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(i).getStack()
	                                .getItem()).damageReduceAmount;
	                        temp = var12 + getProtectionValue(mc.thePlayer.inventoryContainer.getSlot(i).getStack());
	                        if (temp > item2) {
	                            item2 = temp;
	                            bestslot = i;
	                        }
	                    }
	                }
	            }

	            for (i = 0; i < c.getLowerChestInventory().getSizeInventory(); ++i) {
	                if (c.getLowerChestInventory().getStackInSlot(i) != null
	                        && c.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().contains("leggings")) {
	                    temp = (double) ((ItemArmor) c.getLowerChestInventory().getStackInSlot(i)
	                            .getItem()).damageReduceAmount
	                            + getProtectionValue(c.getLowerChestInventory().getStackInSlot(i));
	                    if (temp > item2) {
	                        item2 = temp;
	                        bestslot = i;
	                    }
	                }
	            }
	        }

	        if (item.getUnlocalizedName().contains("boots")) {
	            for (i = 0; i < 45; ++i) {
	                if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
	                    if (mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem().getUnlocalizedName()
	                            .contains("boots")) {
	                        var12 = ((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(i).getStack()
	                                .getItem()).damageReduceAmount;
	                        temp = var12 + getProtectionValue(mc.thePlayer.inventoryContainer.getSlot(i).getStack());
	                        if (temp > item2) {
	                            item2 = temp;
	                            bestslot = i;
	                        }
	                    }
	                }
	            }

	            for (i = 0; i < c.getLowerChestInventory().getSizeInventory(); ++i) {
	                if (c.getLowerChestInventory().getStackInSlot(i) != null
	                        && c.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().contains("boots")) {
	                    temp = (double) ((ItemArmor) c.getLowerChestInventory().getStackInSlot(i)
	                            .getItem()).damageReduceAmount
	                            + getProtectionValue(c.getLowerChestInventory().getStackInSlot(i));
	                    if (temp > item2) {
	                        item2 = temp;
	                        bestslot = i;
	                    }
	                }
	            }
	        }

	        return item1 >= item2 && c.getLowerChestInventory().getStackInSlot(bestslot) == item;
	    }

	    private double getProtectionValue(ItemStack stack) {
	        return stack.getItem() instanceof ItemArmor ? (double) ((ItemArmor) stack.getItem()).damageReduceAmount
	                + (double) ((100 - ((ItemArmor) stack.getItem()).damageReduceAmount)
	                * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack)) * 0.0075D
	                : 0.0D;
	    }

	    private double bestDamage(ContainerChest container, int slot) {
	        double bestDamage = 0.0D;

	        int i;
	        ItemStack is;
	        for (i = 0; i < 45; ++i) {
	            if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
	                is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
	                if (is.getItem() instanceof ItemSword && (double) getDamage(is) > bestDamage) {
	                    bestDamage = getDamage(is);
	                }
	            }
	        }

	        for (i = 0; i < container.getLowerChestInventory().getSizeInventory(); ++i) {
	            if (container.getLowerChestInventory().getStackInSlot(i) != null) {
	                is = container.getLowerChestInventory().getStackInSlot(i);
	                if (i != slot && is.getItem() instanceof ItemSword && (double) getDamage(is) > bestDamage) {
	                    bestDamage = getDamage(is);
	                }
	            }
	        }

	        return bestDamage;
	    }

	    private float getDamage(ItemStack stack) {
	        float damage = 0.0F;
	        Item item = stack.getItem();
	        if (item instanceof ItemTool) {
	            damage += getSpeed(stack);
	        }

	        if (item instanceof ItemSword) {
	            damage += getAttackDamage(stack);
	        } else {
	            ++damage;
	        }

	        return damage;
	    }

	    private float getAttackDamage(ItemStack itemStack) {
	        float damage = ((ItemSword) itemStack.getItem()).getDamageVsEntity();
	        damage += (float) EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, itemStack) * 1.25F;
	        damage += (float) EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, itemStack) * 0.01F;
	        return damage;
	    }

	    private float getSpeed(ItemStack stack) {
	        return ((ItemTool) stack.getItem()).getToolMaterial().getEfficiencyOnProperMaterial();
	    }
	
    
    
    
}
