package linxiu.ui.menu;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import oh.yalan.NativeClass;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.ui.GuiMenuButton;
import linxiu.ui.font.FontLoaders;
import linxiu.ui.login.GuiPasswordField;
import linxiu.utils.timer.TimerUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NativeClass
public class GuiLogin extends GuiScreen {
	public static String status;
	private static final Integer TIME_OUT = 1000;
	static boolean login = false;
	public static GuiTextField usernameField;
	public static GuiPasswordField passwordField;
	static TimerUtil timer = null;
	private int panoramaTimer;
	private DynamicTexture viewportTexture;
	public ResourceLocation backgroundTexture;
	public static boolean open = false;
	private static final Pattern IPV4_PATTERN = Pattern
			.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	private static final String[] IPV4_SERVICES = { "http://checkip.amazonaws.com/", "https://ipv4.icanhazip.com/",
			"http://bot.whatismyipaddress.com/"
			// and so on ...
	};
	public static ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {
			new ResourceLocation("sleep/background/panorama_0.png"),
			new ResourceLocation("sleep/background/panorama_1.png"),
			new ResourceLocation("sleep/background/panorama_2.png"),
			new ResourceLocation("sleep/background/panorama_3.png"),
			new ResourceLocation("sleep/background/panorama_4.png"),
			new ResourceLocation("sleep/background/panorama_5.png") };

	public GuiLogin() {
		login = false;
	}

	public static boolean isLogin() {
		return login;
	}

	@Override
	public void updateScreen() {
		++this.panoramaTimer;
	}

	public static String stripColorCodes(String original) {
		return original.replaceAll("/\u00a7[0-9A-FK-OR]+/i", "");
	}

	private void drawPanorama(int p_73970_1_, int p_73970_2_, float p_73970_3_) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		GlStateManager.matrixMode(5889);
		GlStateManager.pushMatrix();
		GlStateManager.loadIdentity();
		Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
		GlStateManager.matrixMode(5888);
		GlStateManager.pushMatrix();
		GlStateManager.loadIdentity();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.disableCull();
		GlStateManager.depthMask(false);
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		int i = 8;

		for (int j = 0; j < i * i; ++j) {
			GlStateManager.pushMatrix();
			float f = ((float) (j % i) / (float) i - 0.5F) / 64.0F;
			float f1 = ((float) (j / i) / (float) i - 0.5F) / 64.0F;
			float f2 = 0.0F;
			GlStateManager.translate(f, f1, f2);
			GlStateManager.rotate(MathHelper.sin(((float) this.panoramaTimer + p_73970_3_) / 400.0F) * 25.0F + 20.0F,
					1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(-((float) this.panoramaTimer + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);

			for (int k = 0; k < 6; ++k) {
				GlStateManager.pushMatrix();

				if (k == 1) {
					GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
				}

				if (k == 2) {
					GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
				}

				if (k == 3) {
					GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
				}

				if (k == 4) {
					GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
				}

				if (k == 5) {
					GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
				}

				this.mc.getTextureManager().bindTexture(titlePanoramaPaths[k]);
				worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
				int l = 255 / (j + 1);
				float f3 = 0.0F;
				worldrenderer.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, l).endVertex();
				worldrenderer.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, l).endVertex();
				worldrenderer.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, l).endVertex();
				worldrenderer.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, l).endVertex();
				tessellator.draw();
				GlStateManager.popMatrix();
			}

			GlStateManager.popMatrix();
			GlStateManager.colorMask(true, true, true, false);
		}

		worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
		GlStateManager.colorMask(true, true, true, true);
		GlStateManager.matrixMode(5889);
		GlStateManager.popMatrix();
		GlStateManager.matrixMode(5888);
		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.enableCull();
		GlStateManager.enableDepth();
	}

	private void rotateAndBlurSkybox(float p_73968_1_) {
		this.mc.getTextureManager().bindTexture(this.backgroundTexture);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.colorMask(true, true, true, false);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
		GlStateManager.disableAlpha();
		int i = 3;

		for (int j = 0; j < i; ++j) {
			float f = 1.0F / (float) (j + 1);
			int k = this.width;
			int l = this.height;
			float f1 = (float) (j - i / 2) / 256.0F;
			worldrenderer.pos((double) k, (double) l, (double) this.zLevel).tex((double) (0.0F + f1), 1.0D)
					.color(1.0F, 1.0F, 1.0F, f).endVertex();
			worldrenderer.pos((double) k, 0.0D, (double) this.zLevel).tex((double) (1.0F + f1), 1.0D)
					.color(1.0F, 1.0F, 1.0F, f).endVertex();
			worldrenderer.pos(0.0D, 0.0D, (double) this.zLevel).tex((double) (1.0F + f1), 0.0D)
					.color(1.0F, 1.0F, 1.0F, f).endVertex();
			worldrenderer.pos(0.0D, (double) l, (double) this.zLevel).tex((double) (0.0F + f1), 0.0D)
					.color(1.0F, 1.0F, 1.0F, f).endVertex();
		}

		tessellator.draw();
		GlStateManager.enableAlpha();
		GlStateManager.colorMask(true, true, true, true);
	}

	private void renderSkybox(int p_73971_1_, int p_73971_2_, float p_73971_3_) {
		this.mc.getFramebuffer().unbindFramebuffer();
		GlStateManager.viewport(0, 0, 256, 256);
		this.drawPanorama(p_73971_1_, p_73971_2_, p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.rotateAndBlurSkybox(p_73971_3_);
		this.mc.getFramebuffer().bindFramebuffer(true);
		GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		float f = this.width > this.height ? 120.0F / (float) this.width : 120.0F / (float) this.height;
		float f1 = (float) this.height * f / 256.0F;
		float f2 = (float) this.width * f / 256.0F;
		int i = this.width;
		int j = this.height;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
		worldrenderer.pos(0.0D, (double) j, (double) this.zLevel).tex((double) (0.5F - f1), (double) (0.5F + f2))
				.color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
		worldrenderer.pos((double) i, (double) j, (double) this.zLevel).tex((double) (0.5F - f1), (double) (0.5F - f2))
				.color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
		worldrenderer.pos((double) i, 0.0D, (double) this.zLevel).tex((double) (0.5F + f1), (double) (0.5F - f2))
				.color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
		worldrenderer.pos(0.0D, 0.0D, (double) this.zLevel).tex((double) (0.5F + f1), (double) (0.5F + f2))
				.color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
		tessellator.draw();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		GlStateManager.disableAlpha();
		this.renderSkybox(mouseX, mouseY, partialTicks);
		GlStateManager.enableAlpha();
	//RenderUtil.drawBordRect(30, 30, sr.getScaledWidth()-30, sr.getScaledHeight()-30, 1f, new Color(18,18,18,150).getRGB(), new Color(0,0,0,100).getRGB());
		drawString(mc.fontRendererObj, status, width / 2 - fontRendererObj.getStringWidth(stripColorCodes(status)) / 2,
				height / 2 - 110, 0xAAAAAA);
    
		if (!login) {
			if(open) {
			drawString(mc.fontRendererObj, (EnumChatFormatting.BOLD + "Username: "), width / 2 - 250 / 2,
				height / 2 - 220 + 135, -1);
			drawString(mc.fontRendererObj, (EnumChatFormatting.BOLD + "Password: "), width / 2 - 250 / 2,
					height / 2 - 220 + 135 + 43, -1);
			usernameField.drawTextBox();
			passwordField.drawTextBox();
			}
		}

		if (timer != null) {
			if (timer.hasTimeElapsed(5000)) {
				String text = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Login Failed");
				status = text;
				timer.reset();
				timer = null;
			}
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
		 GlStateManager.pushMatrix();
         GlStateManager.scale(2,2,2);
		 FontLoaders.logo28.drawString("p",((width/2-120/4)-108)/2, open?(height / 2 - 220 + 150 + 60+60)/2:(height / 2 - 220 + 150 + 60)/2,-1);
		  GlStateManager.popMatrix();
				 GlStateManager.pushMatrix();
		         GlStateManager.scale(2,2,2);
				 FontLoaders.logo28.drawString("q",((width/2-120/4)+12)/2, open? (height / 2 - 220 + 150 + 60+60)/2:(height / 2 - 220 + 150 + 60)/2,-1);
				  GlStateManager.popMatrix();
					 GlStateManager.pushMatrix();
			         GlStateManager.scale(2,2,2);
					 FontLoaders.logo28.drawString("u",((width/2-120/4)+120+12+6)/2,open?(height / 2 - 220 + 150 + 60+60)/2: (height / 2 - 220 + 150 + 60)/2,-1);
					  GlStateManager.popMatrix();
						 GlStateManager.pushMatrix();
				         GlStateManager.scale(1,1,1);
						 FontLoaders.logo28.drawString(open?"h":"i",((width/2-120/4)+20),open?(height / 2 - 220 + 150+8+60): (height / 2 - 220 + 150+4),-1);
						  GlStateManager.popMatrix();
						  //RenderUtil.drawRect((width/2-120/4)+20, height / 2 - 220 + 150+8+40+12, ((width/2-120/4)+20) + 18, (height / 2 - 220 + 150+8+40)+18+12,-1);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			if (!login)
				login();
		}
		if (button.id == 2)
			mc.displayGuiScreen(new GuiRegister(this));
		//mc.displayGuiScreen(new GuiLoginMenu());

		if (button.id == 3) {
			try {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable trans = null;
				trans = new StringSelection(GuiRegister.getHWID());
				clipboard.setContents(trans, null);
				status = EnumChatFormatting.GREEN + (EnumChatFormatting.BOLD + "Copy HWID Success.");
			} catch (NoSuchAlgorithmException e) {
				status = EnumChatFormatting.RED + (EnumChatFormatting.BOLD + "Failed!");
			}
		}
		super.actionPerformed(button);
	}

	private void login() {
		status = EnumChatFormatting.BOLD + "wait";
		try {
			ADDXZ.Client_Login(usernameField.getText(), passwordField.getText(), GuiRegister.getHWID(), get());
			if (ADDXZ.logincheck) {
				login = true;
				Client.username = usernameField.getText();
				status = EnumChatFormatting.YELLOW + (EnumChatFormatting.BOLD + "Login Success. Please wait...");
				ADDXZ.logincheck = false;
			}
		} catch (Exception e) {
			status = EnumChatFormatting.BOLD + (EnumChatFormatting.BOLD + "Failed Get Failed!");
		}
		timer = new TimerUtil();
		timer.reset();
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Keyboard.KEY_RETURN) {
			mc.getSoundHandler()
					.playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
			login();
		} else if (keyCode == Keyboard.KEY_TAB) {
			if (usernameField.isFocused()) {
				usernameField.setFocused(false);
				passwordField.setFocused(true);
			} else if (passwordField.isFocused()) {
				passwordField.setFocused(false);
				usernameField.setFocused(true);
			}
		}
		usernameField.textboxKeyTyped(typedChar, keyCode);
		passwordField.textboxKeyTyped(typedChar, keyCode);
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		usernameField.mouseClicked(mouseX, mouseY, mouseButton);
		passwordField.mouseClicked(mouseX, mouseY, mouseButton);
		if(mouseButton==0&&open==false&& mouseX >= ((width/2-120/4)+20) && mouseY >= (height / 2 - 220 + 150+4) && mouseX < ((width/2-120/4)+20) + 18 && mouseY <(height / 2 - 220 + 150+4)+18) {
			
			open = true;
			mc.displayGuiScreen((this));
		}
		if(mouseButton==0&&open==true&& mouseX >= ((width/2-120/4)+20) && mouseY >= (height / 2 - 195 + 150+4+40)+12 && mouseX < ((width/2-120/4)+20) + 18 && mouseY <(height / 2 - 220 + 150+8+40)+18+12) {
			open = false;

			mc.displayGuiScreen((this));
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public void initGui() {
		this.viewportTexture = new DynamicTexture(256, 256);
		this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("background",
				this.viewportTexture);
		usernameField = new GuiTextField(0, mc.fontRendererObj, width / 2 - 250 / 2, height / 2 - 220 + 150, 250, 20);
		passwordField = new GuiPasswordField(mc.fontRendererObj, width / 2 - 250 / 2, height / 2 - 220 + 150 + 42, 250,
				20);

		usernameField.setMaxStringLength(64);
		passwordField.setMaxStringLength(64);
     	GuiButton zButton = new GuiMenuButton(1,(width/2-120/2)-120-4, open?height / 2 - 220 + 150 +20+60:height / 2 - 220 + 150 + 20, 120,100,
				  (EnumChatFormatting.BOLD + "Login"));
		GuiButton cButton = new GuiMenuButton(2,(width/2-120/2),open?height / 2 - 220 + 150 +20+60: height / 2 - 220 + 150 + 20, 120,100,
				  (EnumChatFormatting.BOLD + "Register"));
		GuiButton vButton = new GuiMenuButton(3,(width/2-120/2)+120+4, open?height / 2 - 220 + 150 +20+60:height / 2 - 220 + 150 +20, 120,100,
				 (EnumChatFormatting.BOLD + "Copy HWID"));
	/*	buttonList.add(hwidButton);
		buttonList.add(loginButton);
		buttonList.add(regButton);*/

		buttonList.add(zButton);
		buttonList.add(cButton);
		buttonList.add(vButton);
		status = (EnumChatFormatting.BOLD + "Please log in.");
		EventBus.getInstance().register(this);
		super.initGui();
	}

	public static String get() throws ExecutionException, InterruptedException {
		List<Callable<String>> callables = new ArrayList<>();
		for (String ipService : IPV4_SERVICES) {
			callables.add(() -> get(ipService));
		}

		ExecutorService executorService = Executors.newCachedThreadPool();
		try {
			// 杩斿洖绗竴涓垚鍔熻幏鍙栫殑 IP
			return executorService.invokeAny(callables);
		} finally {
			executorService.shutdown();
		}
	}

	private static String get(String url) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
			String ip = in.readLine();
			if (IPV4_PATTERN.matcher(ip).matches()) {
				return ip;
			} else {
				throw new IOException("invalid IPv4 address: " + ip);
			}
		}
	}
}
