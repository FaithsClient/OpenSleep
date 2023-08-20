
/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.render;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.value.ColorValue;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.TextValue;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.font.CFontRenderer;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.Helper;
import linxiu.utils.math.MathUtil;
import linxiu.utils.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import java.awt.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class HUD extends Module {
	public static Mode fontmode = new Mode("FontMode", new String[] { "SF", "Tahoma", "TahomaBOLD", "Lato", "Grey" },
			"SF");
	public static Mode mode = new Mode("ColorMode", new String[] { "Rainbow", "Fade", "Color" }, "Color");
	public final Mode mode2 = new Mode("Hud", new String[] { "Astolfo", "Normal" }, "Normal");
	public static Mode Tags = new Mode("Tags", new String[] { "Empty", "None", "Null", "Hyphen", "Box" }, "None");
	private final TextValue textValue = new TextValue("ClientName", "SleepClient");
	public static Option customfont = new Option("Font", false), wasLower = new Option("Lower", false),
			hidehide = new Option("Hide", false), hideVisuals = new Option("Visuals", false),
			Health = new Option("Health", true), hidename = new Option("Name", true), rect = new Option("Rect", true),
			wav = new Option("Wav", true), sortsuffixValue = new Option("Sort", true),
			hueInterpolation = new Option("Interpolate", false), shadow = new Option("Shadow", true),
			enableNotifications = new Option("Notifications", true);

	public static Numbers<Number> differenceValue = new Numbers("Difference", 10.0, 1.0, 20.0, 1.0),
			tick = new Numbers("Aura Tick", 8.0, 0.0, 10.0, 1.0),
			scale = new Numbers("Array Scale", 18.0, 16, 24.0, 1.0);

	public static String clientName = Client.name;
	private static int hudX = 0, hudY = 2;
	public static final ColorValue colorValue = new ColorValue("Color", Color.WHITE.getRGB());
	public static final ColorValue color2Value = new ColorValue("Color2", Color.PINK.getRGB());
	private final String[] directions = new String[] { "S", "SW", "W", "NW", "N", "NE", "E", "SE" };
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-ORX]");
	public int color2;

	public HUD() {
		super("HUD", new String[] { "gui" }, ModuleType.Render);
		this.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)).getRGB());
		this.setEnabled(true);
		this.setRemoved(true);
	}

	private static float getOffset() {
		return (System.currentTimeMillis() % 2000) / 1000f;
	}

	public static Color getAstolfoColor(int delay, float offset) {
		float speed = 4000f;
		float hue = (float) (System.currentTimeMillis() % delay) + (offset);
		while (hue > speed) {
			hue -= speed;
		}
		hue /= speed;
		if (hue > 0.5) {
			hue = 0.5F - (hue - 0.5f);
		}
		hue += 0.5F;
		return Color.getHSBColor(hue, 0.75F, 1F);
	}

	public static int getHudX() {
		return hudX;
	}

	public static void setHudX(int hudX1) {
		hudX = hudX1;
	}

	public static int getHudY() {
		return hudY;
	}

	public static void setHudY(int hudY1) {
		hudY = hudY1;
	}

	public static boolean isHover(int mouseX, int mouseY) {
		ScaledResolution res = new ScaledResolution(Helper.mc);
		return MathUtil.inRange(mouseX, mouseY, HUD.getHudX() + res.getScaledWidth() + 3,
				HUD.getHudY() + res.getScaledHeight() - 238, HUD.getHudX() + res.getScaledWidth() - 70,
				HUD.getHudY() - 15) && ModuleManager.getModuleByClass(HUD.class).isEnabled();
	}

	public static Color getCustomColor() {
		return new Color(colorValue.getValue());
	}

	public double getVelocity() {
		double xDiff = (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * 2;
		double zDiff = (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * 2;
		return MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
	}

	CFontRenderer font;

	@EventHandler
	private void renderHud(EventRender2D event) {
		ScaledResolution sr = new ScaledResolution(mc);
		if (scale.getValue().intValue() == 16) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF16;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui16;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma16;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold16;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona16;
			}
		} else if (scale.getValue().intValue() == 17) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF17;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui17;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma17;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold17;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona17;
			}
		} else if (scale.getValue().intValue() == 18) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF18;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui18;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma18;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold18;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona18;
			}
		} else if (scale.getValue().intValue() == 19) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF19;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui19;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma19;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold19;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona19;
			}
		} else if (scale.getValue().intValue() == 20) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF20;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui20;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma20;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold20;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona20;
			}
		} else if (scale.getValue().intValue() == 21) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF21;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui21;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma21;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold21;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona21;
			}
		} else if (scale.getValue().intValue() == 22) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF22;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui22;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma22;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold22;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona22;
			}
		} else if (scale.getValue().intValue() == 23) {
			if (Objects.equals(fontmode.getValue(), "SF")) {
				font = FontLoaders.SF23;
			} else if (Objects.equals(fontmode.getValue(), "Lato")) {
				font = FontLoaders.clickgui23;
			} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
				font = FontLoaders.Tahoma23;
			} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
				font = FontLoaders.TahomaBold23;
			} else if (Objects.equals(fontmode.getValue(), "Grey")) {
				font = FontLoaders.kiona23;
			}
		} else if (Objects.equals(fontmode.getValue(), "SF")) {
			font = FontLoaders.SF24;
		} else if (Objects.equals(fontmode.getValue(), "Lato")) {
			font = FontLoaders.clickgui24;
		} else if (Objects.equals(fontmode.getValue(), "Tahoma")) {
			font = FontLoaders.Tahoma24;
		} else if (Objects.equals(fontmode.getValue(), "TahomaBOLD")) {
			font = FontLoaders.TahomaBold24;
		} else if (Objects.equals(fontmode.getValue(), "Grey")) {
			font = FontLoaders.kiona24;
		}

		if (Health.getValue()) {
			final String health = EnumChatFormatting.BOLD + String.valueOf(MathUtil.round(mc.thePlayer.getHealth(), 1));

			final float x22 = mc.thePlayer.getHealth() < 10 ? sr.getScaledWidth() / 2F - 13 + 4

					: sr.getScaledWidth() / 2F - 13;
			final float y23 = sr.getScaledHeight() / 2F - 15;

			if (mc.thePlayer.getHealth() < 14 && mc.thePlayer.getHealth() >= 6) {
				mc.fontRendererObj.drawStringWithShadow(health, x22, y23, Colors.getColor(255, 255, 0, 200));
			} else if (mc.thePlayer.getHealth() < 6) {
				mc.fontRendererObj.drawStringWithShadow(health, x22, y23, Colors.getColor(255, 0, 0, 200));
			} else {
				mc.fontRendererObj.drawStringWithShadow(health, x22, y23, Colors.getColor(0, 255, 0, 200));
			}
		}

		String fps = Minecraft.getDebugFPS() + " FPS]";
		String titleString = textValue.getValue().equals("")
				? clientName.charAt(0) + ColorUtil.COLORRESET + EnumChatFormatting.WHITE + clientName.substring(1)
						+ " [" + fps
				: textValue.getValue().charAt(0) + ColorUtil.COLORRESET + textValue.getValue().substring(1)
						+ EnumChatFormatting.WHITE + " [" + fps;

		if (hidename.getValue()) {
			if (customfont.getValue()) {
				font.drawStringWithShadow(titleString.replace('&', '\u00a7'), 3.5f, 5.5f,
						new Color(colorValue.getValue()).getRGB());
			} else
				mc.fontRendererObj.drawStringWithShadow(titleString.replace('&', '\u00a7'), 3.5f, 5.5f,
						new Color(colorValue.getValue()).getRGB());
		}

		BigDecimal bg = new BigDecimal(getVelocity() * 10d);
		double curSpeed = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		if (customfont.getValue()) {
			font.drawStringWithShadow(
					EnumChatFormatting.GRAY + "XYZ: " + EnumChatFormatting.RESET + (int) mc.thePlayer.posX + ","
							+ (int) mc.thePlayer.posY + "," + (int) mc.thePlayer.posZ + " " + EnumChatFormatting.GRAY
							+ "B/s: " + EnumChatFormatting.RESET + curSpeed,
					2, sr.getScaledHeight() - 10, new Color(colorValue.getValue()).getRGB());

		} else {
			mc.fontRendererObj.drawStringWithShadow(
					EnumChatFormatting.GRAY + "XYZ: " + EnumChatFormatting.RESET + (int) mc.thePlayer.posX + ","
							+ (int) mc.thePlayer.posY + "," + (int) mc.thePlayer.posZ + " " + EnumChatFormatting.GRAY
							+ "B/s: " + EnumChatFormatting.RESET + curSpeed,
					2, sr.getScaledHeight() - 10, new Color(colorValue.getValue()).getRGB());

		}

		if (customfont.getValue()) {
			int ychat;
			int n = ychat = this.mc.ingameGUI.getChatGUI().getChatOpen() ? 24 : 10;
			font.drawStringWithShadow(
					EnumChatFormatting.GRAY + "Release Build - " + EnumChatFormatting.WHITE + "120722"
							+ EnumChatFormatting.GRAY + " - " + EnumChatFormatting.RESET
							+ Client.username.trim().replace('&', '\u00a7'),
					sr.getScaledWidth()
							- font.getStringWidth(
									EnumChatFormatting.GRAY + "Release Build - " + EnumChatFormatting.WHITE
											+ EnumChatFormatting.BOLD + "120722" + EnumChatFormatting.GRAY + " - "
											+ EnumChatFormatting.RESET + Client.username.trim().replace('&', '\u00a7'))
							- 1,
					sr.getScaledHeight() - 9, new Color(colorValue.getValue()).getRGB());
		} else {
			int ychat;
			int n = ychat = this.mc.ingameGUI.getChatGUI().getChatOpen() ? 25 : 10;
			mc.fontRendererObj.drawStringWithShadow(
					EnumChatFormatting.GRAY + "Release Build - " + EnumChatFormatting.WHITE + EnumChatFormatting.BOLD
							+ "120722" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.RESET
							+ Client.username.trim().replace('&', '\u00a7'),
					sr.getScaledWidth()
							- mc.fontRendererObj.getStringWidth(
									EnumChatFormatting.GRAY + "Release Build - " + EnumChatFormatting.WHITE
											+ EnumChatFormatting.BOLD + "120722" + EnumChatFormatting.GRAY + " - "
											+ EnumChatFormatting.RESET + Client.username.trim().replace('&', '\u00a7'))
							+ 3,
					sr.getScaledHeight() - 9, new Color(colorValue.getValue()).getRGB());
		}
		ArrayList<Module> sorted = new ArrayList<Module>();
		int count;
		count = 0;
		if (Objects.equals(mode2.getValue(), "Astolfo")) {
			String name;
			Color backdrop = new Color(0, 5, 0, 70);
			float y = 0f;
			double xOffset = 0;
			for (Module m : ModuleManager.getModules()) {
				if ((!m.isEnabled() && m.wasArrayRemoved() && m.getAnimx() == 0)
						|| (!hidehide.getValue() && m.wasRemoved())
						|| (!hideVisuals.getValue() && m.getType() == ModuleType.Render) && !m.isAnimating())
					continue;
				sorted.add(m);
			}
			if (sortsuffixValue.getValue()) {
				if (customfont.getValue()) {
					sorted.sort((o1,
							o2) -> font
									.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
											: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
									- font.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
											: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
				} else {
					sorted.sort((o1, o2) -> mc.fontRendererObj
							.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
									: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
							- mc.fontRendererObj.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
									: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
				}
			} else {

			}
			for (Module mod : sorted) {
				mod.updateRender();
				name = mod.getSuffix().isEmpty() ? Client.getModuleName(mod)
						: String.format("%s %s", Client.getModuleName(mod), mod.getSuffix());
				if (mod.isEnabled() && mod.animy == 0.0F) {
					mod.animy = y;
				} else if (mod.isEnabled() && mod.animy < y) {
					mod.animy += 0.5F;
				} else if (mod.isEnabled() && mod.animy > y) {
					mod.animy -= 0.5F;
				}
				if (customfont.getValue()) {
					if (mod.isEnabled()) {
						mod.setArrayRemoved(false);
						if (mc.thePlayer.ticksExisted >= 30) {
							mod.setAnimx(Math.min(mod.getAnimx() + font.getStringWidth(name) / 12,
									font.getStringWidth(name)));
						} else {
							mod.setAnimx(font.getStringWidth(name));
						}
					} else {
						if (mod.getAnimx() <= 0) {
							mod.setArrayRemoved(true);
						} else {
							if (mc.thePlayer.ticksExisted >= 30) {
								mod.setAnimx(Math.max(mod.getAnimx() - font.getStringWidth(name) / 12, 0));
							} else {
								mod.setAnimx(0);
							}
						}
					}
				} else {
					if (mod.isEnabled()) {
						mod.setArrayRemoved(false);
						if (mc.thePlayer.ticksExisted >= 30) {
							mod.setAnimx(Math.min(mod.getAnimx() + mc.fontRendererObj.getStringWidth(name) / 12,
									mc.fontRendererObj.getStringWidth(name)));
						} else {
							mod.setAnimx(mc.fontRendererObj.getStringWidth(name));
						}
					} else {
						if (mod.getAnimx() <= 0) {
							mod.setArrayRemoved(true);
						} else {
							if (mc.thePlayer.ticksExisted >= 30) {
								mod.setAnimx(
										Math.max(mod.getAnimx() - mc.fontRendererObj.getStringWidth(name) / 12, 0));
							} else {
								mod.setAnimx(0);
							}
						}
					}
				}

				double animValue = (customfont.getValue() ? font.getStringWidth(name)
						: mc.fontRendererObj.getStringWidth(name)) * 2f;
				double x1 = sr.getScaledWidth()
						- (customfont.getValue() ? font.getStringWidth(name) : mc.fontRendererObj.getStringWidth(name))
						- xOffset - 5;
				x1 += Animation.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue);
				double y1 = customfont.getValue() ? y + 2 : y + 1;
				double x2 = sr.getScaledWidth() - xOffset;
				x2 += Animation.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue);
				double y2 = customfont.getValue() ? y + 12 : y + 11;

				if (rect.getValue()) {
					RenderUtils.drawRect(x1, y1, x2, y2, backdrop.getRGB());
				}
				int color;
				if (Objects.equals(mode.getValue(), "Rainbow")) {
					color = ColorUtil.interpolateColorsBackAndForth(5, count * 20, Client.INSTANCE.getClientColor(),
							Client.INSTANCE.getAlternateClientColor(), hueInterpolation.getValue()).getRGB();
				} else if (Objects.equals(mode.getValue(), "Fade")) {
					color = ColorUtils.getFadeRainbow(new Color(colorValue.getValue()), (int) (y / 11),
							differenceValue.getValue().intValue()).getRGB();
				} else {
					color = new Color(colorValue.getValue()).getRGB();
				}

				if (customfont.getValue()) {
					if (shadow.getValue()) {
						font.drawStringWithShadow(name,
								(float) (sr.getScaledWidth() - mod.getAnimx() - xOffset) - 2 + Animation
										.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue),
								mod.getAnimY() + 4.5f, color);
					} else {
						font.drawString(name,
								(float) ((sr.getScaledWidth() - mod.getAnimx() - xOffset) - 2f + Animation
										.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue)),
								(float) (mod.getAnimY() + 4.5f), color);
					}
				} else {
					if (shadow.getValue()) {
						mc.fontRendererObj.drawStringWithShadow(name,
								(float) ((float) (sr.getScaledWidth() - mod.getAnimx() - xOffset) - 2.5 + Animation
										.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue)),
								(float) (mod.getAnimY() + 2.5), color);
					} else {
						mc.fontRendererObj.drawString(name,
								(float) ((float) (sr.getScaledWidth() - mod.getAnimx() - xOffset) - 2.5 + Animation
										.getDoubleFromPercentage(100 - mod.animation.getPercent(), animValue)),
								(float) (mod.getAnimY() + 2.5), color, false);
					}
				}
				if (rect.getValue()) {
					RenderUtils.drawRect(x2, y1, x2 - 1, y2, color);
				}
				y += 10f;
				count++;
			}
		}
		if (Objects.equals(mode2.getValue(), "Normal")) {
			if (!this.mc.gameSettings.showDebugInfo) {
				String name;

				for (Module m : ModuleManager.getModules()) {
					if ((!m.isEnabled() && m.wasArrayRemoved() && m.getAnimx() == 0)
							|| (!hidehide.getValue() && m.wasRemoved())
							|| (!hideVisuals.getValue() && m.getType() == ModuleType.Render) && !m.isAnimating())
						continue;
					sorted.add(m);
				}
				if (sortsuffixValue.getValue()) {
					if (customfont.getValue()) {
						sorted.sort((o1,
								o2) -> font
										.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
												: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
										- font.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
												: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
					} else {
						sorted.sort((o1, o2) -> mc.fontRendererObj
								.getStringWidth(o2.getSuffix().isEmpty() ? Client.getModuleName(o2)
										: String.format("%s %s", Client.getModuleName(o2), o2.getSuffix()))
								- mc.fontRendererObj.getStringWidth(o1.getSuffix().isEmpty() ? Client.getModuleName(o1)
										: String.format("%s %s", Client.getModuleName(o1), o1.getSuffix())));
					}
				} else {

				}
				int x2 = hudX;
				int y = hudY;
				if (customfont.getValue()) {
					for (Module mod : sorted) {
						mod.updateRender();
						name = mod.getSuffix().isEmpty() ? Client.getModuleName(mod)
								: String.format("%s %s", Client.getModuleName(mod), mod.getSuffix());
						if (mod.isEnabled() && mod.animy == 0.0F) {
							mod.animy = y;
						} else if (mod.isEnabled() && mod.animy < y) {
							mod.animy += 0.5F;
						} else if (mod.isEnabled() && mod.animy > y) {
							mod.animy -= 0.5F;
						}

						if (mod.isEnabled()) {
							mod.setArrayRemoved(false);
							if (mc.thePlayer.ticksExisted >= 30) {
								mod.setAnimx(Math.min(mod.getAnimx() + font.getStringWidth(name) / 12,
										font.getStringWidth(name)));
							} else {
								mod.setAnimx(font.getStringWidth(name));
							}
						} else {
							if (mod.getAnimx() <= 0) {
								mod.setArrayRemoved(true);
							} else {
								if (mc.thePlayer.ticksExisted >= 30) {
									mod.setAnimx(Math.max(mod.getAnimx() - font.getStringWidth(name) / 12, 0));
								} else {
									mod.setAnimx(0);
								}
							}
						}
						float x = hudX < -421 ? x2 - 60 + RenderUtil.width()
								: x2 + sr.getScaledWidth() - mod.getAnimx();
						int color;
						if (Objects.equals(mode.getValue(), "Rainbow")) {
							color = ColorUtil
									.interpolateColorsBackAndForth(5, count * 20, Client.INSTANCE.getClientColor(),
											Client.INSTANCE.getAlternateClientColor(), hueInterpolation.getValue())
									.getRGB();
						} else if (Objects.equals(mode.getValue(), "Fade")) {
							color = ColorUtils.getFadeRainbow(new Color(colorValue.getValue()), y / 11,
									differenceValue.getValue().intValue()).getRGB();
						} else {
							color = new Color(colorValue.getValue()).getRGB();
						}
						// RenderUtil.drawRect(x, y, x2, y2, backdrop.getRGB());
						if (shadow.getValue()) {
							font.drawStringWithShadow(name, x - 3.0f, mod.getAnimY() + 1, color);
						} else {
							font.drawString(name, x - 3.0f, mod.getAnimY() + 1, color);
						}
						count++;
						y += 9;
					}
				} else {
					for (Module m : sorted) {
						name = m.getSuffix().isEmpty() ? Client.getModuleName(m)
								: String.format("%s %s", Client.getModuleName(m), m.getSuffix());
						if (m.isEnabled() && m.animy == 0.0F) {
							m.animy = y;
						} else if (m.isEnabled() && m.animy < y) {
							m.animy += 0.5F;
						} else if (m.isEnabled() && m.animy > y) {
							m.animy -= 0.5F;
						}

						if (m.isEnabled()) {
							m.setArrayRemoved(false);
							if (mc.thePlayer.ticksExisted >= 30) {
								m.setAnimx(Math.min(m.getAnimx() + mc.fontRendererObj.getStringWidth(name) / 12,
										mc.fontRendererObj.getStringWidth(name)));
							} else {
								m.setAnimx(mc.fontRendererObj.getStringWidth(name));
							}
						} else {
							if (m.getAnimx() <= 0) {
								m.setArrayRemoved(true);
							} else {
								if (mc.thePlayer.ticksExisted >= 30) {
									m.setAnimx(
											Math.max(m.getAnimx() - mc.fontRendererObj.getStringWidth(name) / 12, 0));
								} else {
									m.setAnimx(0);
								}
							}
						}
						float x = hudX < -300 ? x2 - 60 + RenderUtil.width() : x2 + RenderUtil.width() - m.getAnimx();
						int color;
						if (Objects.equals(mode.getValue(), "Rainbow")) {
							color = ColorUtil
									.interpolateColorsBackAndForth(5, count * 20, Client.INSTANCE.getClientColor(),
											Client.INSTANCE.getAlternateClientColor(), hueInterpolation.getValue())
									.getRGB();
						} else if (Objects.equals(mode.getValue(), "Fade")) {
							color = ColorUtils.getFadeRainbow(new Color(colorValue.getValue()), y / 11,
									differenceValue.getValue().intValue()).getRGB();
						} else {
							color = new Color(colorValue.getValue()).getRGB();
						}
						if (shadow.getValue()) {
							this.mc.fontRendererObj.drawStringWithShadow(name, x - 4.0f, m.getAnimY() + 2.5f, color);
						} else {
							this.mc.fontRendererObj.drawString(name, x - 3.0f, m.getAnimY() + 2.5f, color, false);
						}
						count++;
						y += 11;
					}
				}
			}
		}
	}
}
