package linxiu.ui.menu;

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
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@NativeClass
public class GuiRegister extends GuiScreen {
	public static String state = EnumChatFormatting.BOLD + "Waiting...";
	private final GuiScreen previousScreen;
	private GuiTextField password;
	private GuiTextField username;
	private GuiTextField code;
	private int panoramaTimer;
	private DynamicTexture viewportTexture;
	public ResourceLocation backgroundTexture;
	public static ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {
			new ResourceLocation("sleep/background/panorama_0.png"),
			new ResourceLocation("sleep/background/panorama_1.png"),
			new ResourceLocation("sleep/background/panorama_2.png"),
			new ResourceLocation("sleep/background/panorama_3.png"),
			new ResourceLocation("sleep/background/panorama_4.png"),
			new ResourceLocation("sleep/background/panorama_5.png") };

	public GuiRegister(GuiScreen previousScreen) {
		this.previousScreen = previousScreen;
	}

	public static String getHWID() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuilder s = new StringBuilder();
		String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("COMPUTERNAME");
		byte[] bytes = main.getBytes("UTF-8");
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] md5 = messageDigest.digest(bytes);
		int i = 0;
		for (byte b : md5) {
			s.append(Integer.toHexString((b & 0xFF) | 0x300), 0, 3);
			if (i != md5.length - 1) {
				s.append("-");
			}
			i++;
		}
		return s.toString();
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
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 1: {
			this.mc.displayGuiScreen(this.previousScreen);
			break;
		}
		case 0: {
			if (username.getText().isEmpty() || password.getText().isEmpty() || code.getText().isEmpty()) {
				state = EnumChatFormatting.BOLD + "Some Field is empty!";
			} else {
				state = EnumChatFormatting.RED
						+ (EnumChatFormatting.BOLD + "Registration failed, please check your registration code.");

				try {
					ADDXZ.Client_Register(username.getText(), password.getText(), code.getText(), getHWID());
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
		}
	}

	@Override
	public void drawScreen(int x, int y, float z) {
		ScaledResolution sr = new ScaledResolution(mc);
		GlStateManager.disableAlpha();
		this.renderSkybox(x, y, z);
		GlStateManager.enableAlpha();
		this.username.drawTextBox();
		this.password.drawTextBox();
		this.code.drawTextBox();
		drawCenteredString(mc.fontRendererObj, (EnumChatFormatting.BOLD + "Register"), width / 2, 20, -1);
		drawCenteredString(mc.fontRendererObj, state, width / 2, 35, -1);
		if (this.username.getText().isEmpty()) {
			mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.BOLD + "Username", width / 2 - 96, 66.0f,
					-7829368);
		}
		if (this.password.getText().isEmpty()) {
			mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.BOLD + "Password", width / 2 - 96, 106.0f,
					-7829368);
		}
		if (this.code.getText().isEmpty()) {
			mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.BOLD + "Activation Key", width / 2 - 96, 146.0f,
					-7829368);
		}
		super.drawScreen(x, y, z);
	}

	@Override
	public void initGui() {
		this.viewportTexture = new DynamicTexture(256, 256);
		this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("background",
				this.viewportTexture);
		int var3 = height / 4 + 24;
		this.buttonList.add(new GuiButton(0, width / 2 - 100, var3 + 72 + 12, EnumChatFormatting.BOLD + "Register"));
		this.buttonList.add(new GuiButton(1, width / 2 - 100, var3 + 72 + 12 + 24, EnumChatFormatting.BOLD + "Back"));
		this.username = new GuiTextField(1, mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
		this.password = new GuiTextField(2, mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
		this.code = new GuiTextField(var3, mc.fontRendererObj, width / 2 - 100, 140, 200, 20);
		this.username.setFocused(true);
		this.username.setMaxStringLength(200);
		this.password.setMaxStringLength(200);
		this.code.setMaxStringLength(200);
		Keyboard.enableRepeatEvents(true);
	}

	@Override
	protected void keyTyped(char character, int key) {
		try {
			super.keyTyped(character, key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (character == '\t') {
			if (username.isFocused()) {
				password.setFocused(true);
				username.setFocused(false);
			} else if (password.isFocused()) {
				code.setFocused(true);
				password.setFocused(false);
			} else if (code.isFocused()) {
				code.setFocused(false);
				username.setFocused(true);
			}
		}
		if (character == '\r') {
			this.actionPerformed(this.buttonList.get(0));
		}
		this.username.textboxKeyTyped(character, key);
		this.password.textboxKeyTyped(character, key);
		this.code.textboxKeyTyped(character, key);
	}

	@Override
	protected void mouseClicked(int x, int y, int button) {
		try {
			super.mouseClicked(x, y, button);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.username.mouseClicked(x, y, button);
		this.password.mouseClicked(x, y, button);
		this.code.mouseClicked(x, y, button);
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {
		this.username.updateCursorCounter();
		this.password.updateCursorCounter();
		this.code.updateCursorCounter();
	}
}
