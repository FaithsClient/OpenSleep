package linxiu.module.modules.render.targethud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public final class TargetHudUtil {
	private static final Minecraft mc = Minecraft.getMinecraft();
    private static final Frustum frustrum = new Frustum();

    public long last2DFrame = System.currentTimeMillis();
    public long last3DFrame = System.currentTimeMillis();

    public float delta2DFrameTime;
    public float delta3DFrameTime;

    public void push() {
        GL11.glPushMatrix();
    }

    public void pop() {
        GL11.glPopMatrix();
    }

    public static void enable(final int glTarget) {
        GL11.glEnable(glTarget);
    }

    public static void disable(final int glTarget) {
        GL11.glDisable(glTarget);
    }

    public static void start() {
        enable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        disable(GL11.GL_TEXTURE_2D);
        disable(GL11.GL_CULL_FACE);
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
    }

    public static void stop() {
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        enable(GL11.GL_CULL_FACE);
        enable(GL11.GL_TEXTURE_2D);
        disable(GL11.GL_BLEND);
        color(Color.white);
    }

    public void startSmooth() {
        enable(GL11.GL_POLYGON_SMOOTH);
        enable(GL11.GL_LINE_SMOOTH);
        enable(GL11.GL_POINT_SMOOTH);
    }

    public void endSmooth() {
        disable(GL11.GL_POINT_SMOOTH);
        disable(GL11.GL_LINE_SMOOTH);
        disable(GL11.GL_POLYGON_SMOOTH);
    }

    public static void begin(final int glMode) {
        GL11.glBegin(glMode);
    }

    public static void end() {
        GL11.glEnd();
    }

    public static void vertex(final double x, final double y) {
        GL11.glVertex2d(x, y);
    }

    public void translate(final double x, final double y) {
        GL11.glTranslated(x, y, 0);
    }

    public void scale(final double x, final double y) {
        GL11.glScaled(x, y, 1);
    }

    public void rotate(final double x, final double y, final double z, final double angle) {
        GL11.glRotated(angle, x, y, z);
    }

    public static void color(final double red, final double green, final double blue, final double alpha) {
        GL11.glColor4d(red, green, blue, alpha);
    }

    public void color(final double red, final double green, final double blue) {
        color(red, green, blue, 1);
    }

    public static void color(Color color) {
        if (color == null)
            color = Color.white;
        color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
    }

    public void color(Color color, final int alpha) {
        if (color == null)
            color = Color.white;
        color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, 0.5);
    }

    public void lineWidth(final double width) {
        GL11.glLineWidth((float) width);
    }

    public static void rect(final double x, final double y, final double width, final double height, final boolean filled, final Color color) {
        start();
        if (color != null)
            color(color);
        begin(filled ? GL11.GL_TRIANGLE_FAN : GL11.GL_LINES);

        {
            vertex(x, y);
            vertex(x + width, y);
            vertex(x + width, y + height);
            vertex(x, y + height);
            if (!filled) {
                vertex(x, y);
                vertex(x, y + height);
                vertex(x + width, y);
                vertex(x + width, y + height);
            }
        }
        end();
        stop();
    }

    public void rect(final double x, final double y, final double width, final double height, final boolean filled) {
        rect(x, y, width, height, filled, null);
    }

    public static void rect(final double x, final double y, final double width, final double height, final Color color) {
        rect(x, y, width, height, true, color);
    }

    public void rect(final double x, final double y, final double width, final double height) {
        rect(x, y, width, height, true, null);
    }

    public void rectCentered(double x, double y, final double width, final double height, final boolean filled, final Color color) {
        x -= width / 2;
        y -= height / 2;
        rect(x, y, width, height, filled, color);
    }

    public void rectCentered(double x, double y, final double width, final double height, final boolean filled) {
        x -= width / 2;
        y -= height / 2;
        rect(x, y, width, height, filled, null);
    }

    public void rectCentered(double x, double y, final double width, final double height, final Color color) {
        x -= width / 2;
        y -= height / 2;
        rect(x, y, width, height, true, color);
    }

    public void rectCentered(double x, double y, final double width, final double height) {
        x -= width / 2;
        y -= height / 2;
        rect(x, y, width, height, true, null);
    }

    public void gradient(final double x, final double y, final double width, final double height, final boolean filled, final Color color1, final Color color2) {
        start();
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GlStateManager.enableAlpha();
        GL11.glAlphaFunc(GL_GREATER, 0);
        if (color1 != null)
            color(color1);
        begin(filled ? GL11.GL_QUADS : GL11.GL_LINES);
        {
            vertex(x, y);
            vertex(x + width, y);
            if (color2 != null)
                color(color2);
            vertex(x + width, y + height);
            vertex(x, y + height);
            if (!filled) {
                vertex(x, y);
                vertex(x, y + height);
                vertex(x + width, y);
                vertex(x + width, y + height);
            }
        }
        end();
        GL11.glAlphaFunc(GL_GREATER, 0.1f);
        GlStateManager.disableAlpha();
        GL11.glShadeModel(GL11.GL_FLAT);
        stop();
    }

    public void gradient(final double x, final double y, final double width, final double height, final Color color1, final Color color2) {
        gradient(x, y, width, height, true, color1, color2);
    }

    public void gradientCentered(double x, double y, final double width, final double height, final Color color1, final Color color2) {
        x -= width / 2;
        y -= height / 2;
        gradient(x, y, width, height, true, color1, color2);
    }

    public void gradientSideways(final double x, final double y, final double width, final double height, final boolean filled, final Color color1, final Color color2) {
        start();
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GlStateManager.disableAlpha();
        if (color1 != null)
            color(color1);
        begin(filled ? GL11.GL_TRIANGLE_FAN : GL11.GL_LINES);
        {
            vertex(x, y);
            vertex(x, y + height);
            if (color2 != null)
                color(color2);
            vertex(x + width, y + height);
            vertex(x + width, y);
        }
        end();
        GlStateManager.enableAlpha();
        GL11.glShadeModel(GL11.GL_FLAT);
        stop();
    }

    public void gradientSideways(final double x, final double y, final double width, final double height, final Color color1, final Color color2) {
        gradientSideways(x, y, width, height, true, color1, color2);
    }

    public void gradientSidewaysCentered(double x, double y, final double width, final double height, final Color color1, final Color color2) {
        x -= width / 2;
        y -= height / 2;
        gradientSideways(x, y, width, height, true, color1, color2);
    }

    public static void polygon(final double x, final double y, double sideLength, final double amountOfSides, final boolean filled, final Color color) {
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        if (!filled) GL11.glLineWidth(2);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(filled ? GL11.GL_TRIANGLE_FAN : GL11.GL_LINE_STRIP);
        {
            for (double i = 0; i <= amountOfSides / 4; i++) {
                final double angle = i * 4 * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + (sideLength * Math.sin(angle)) + sideLength);
            }
        }
        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();
    }

    public void polygon(final double x, final double y, final double sideLength, final int amountOfSides, final boolean filled) {
        polygon(x, y, sideLength, amountOfSides, filled, null);
    }

    public static void polygon(final double x, final double y, final double sideLength, final int amountOfSides, final Color color) {
        polygon(x, y, sideLength, amountOfSides, true, color);
    }

    public void polygon(final double x, final double y, final double sideLength, final int amountOfSides) {
        polygon(x, y, sideLength, amountOfSides, true, null);
    }

    public void polygonCentered(double x, double y, final double sideLength, final int amountOfSides, final boolean filled, final Color color) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, amountOfSides, filled, color);
    }

    public void polygonCentered(double x, double y, final double sideLength, final int amountOfSides, final boolean filled) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, amountOfSides, filled, null);
    }

    public void polygonCentered(double x, double y, final double sideLength, final int amountOfSides, final Color color) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, amountOfSides, true, color);
    }

    public void polygonCentered(double x, double y, final double sideLength, final int amountOfSides) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, amountOfSides, true, null);
    }

    public void circle(final double x, final double y, final double radius, final boolean filled, final Color color) {
        polygon(x, y, radius, 360, filled, color);
    }

    public void circle(final double x, final double y, final double radius, final boolean filled) {
        polygon(x, y, radius, 360, filled);
    }

    public static void circle(final double x, final double y, final double radius, final Color color) {
        polygon(x, y, radius, 360, color);
    }

    public void circle(final double x, final double y, final double radius) {
        polygon(x, y, radius, 360);
    }

    public void circleCentered(double x, double y, final double radius, final boolean filled, final Color color) {
        x -= radius / 2;
        y -= radius / 2;
        polygon(x, y, radius, 360, filled, color);
    }

    public void circleCentered(double x, double y, final double radius, final boolean filled) {
        x -= radius / 2;
        y -= radius / 2;
        polygon(x, y, radius, 360, filled);
    }

    public void circleCentered(double x, double y, final double radius, final boolean filled, final int sides) {
        x -= radius / 2;
        y -= radius / 2;
        polygon(x, y, radius, sides, filled);
    }

    public void circleCentered(double x, double y, final double radius, final Color color) {
        x -= radius / 2;
        y -= radius / 2;
        polygon(x, y, radius, 360, color);
    }

    public void circleCentered(double x, double y, final double radius) {
        x -= radius / 2;
        y -= radius / 2;
        polygon(x, y, radius, 360);
    }

    public void triangle(final double x, final double y, final double sideLength, final boolean filled, final Color color) {
        polygon(x, y, sideLength, 3, filled, color);
    }

    public void triangle(final double x, final double y, final double sideLength, final boolean filled) {
        polygon(x, y, sideLength, 3, filled);
    }

    public void triangle(final double x, final double y, final double sideLength, final Color color) {
        polygon(x, y, sideLength, 3, color);
    }

    public void triangle(final double x, final double y, final double sideLength) {
        polygon(x, y, sideLength, 3);
    }

    public void triangleCentered(double x, double y, final double sideLength, final boolean filled, final Color color) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, 3, filled, color);
    }

    public void triangleCentered(double x, double y, final double sideLength, final boolean filled) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, 3, filled);
    }

    public void triangleCentered(double x, double y, final double sideLength, final Color color) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, 3, color);
    }

    public void triangleCentered(double x, double y, final double sideLength) {
        x -= sideLength / 2;
        y -= sideLength / 2;
        polygon(x, y, sideLength, 3);
    }

    public void lineNoGl(final double firstX, final double firstY, final double secondX, final double secondY, final Color color) {

        start();
        if (color != null)
            color(color);
        lineWidth(1);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_LINES);
        {
            vertex(firstX, firstY);
            vertex(secondX, secondY);
        }
        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();
    }

    public void line(final double firstX, final double firstY, final double secondX, final double secondY, final double lineWidth, final Color color) {
        start();
        if (color != null)
            color(color);
        lineWidth(lineWidth);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_LINES);
        {
            vertex(firstX, firstY);
            vertex(secondX, secondY);
        }
        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();
    }

    public void line(final double firstX, final double firstY, final double secondX, final double secondY, final double lineWidth) {
        line(firstX, firstY, secondX, secondY, lineWidth, null);
    }

    public void line(final double firstX, final double firstY, final double secondX, final double secondY, final Color color) {
        line(firstX, firstY, secondX, secondY, 0, color);
    }

    public void line(final double firstX, final double firstY, final double secondX, final double secondY) {
        line(firstX, firstY, secondX, secondY, 0, null);
    }

    public static void scissor(double x, double y, double width, double height) {
        final ScaledResolution sr = new ScaledResolution(mc);
        final double scale = sr.getScaleFactor();

        y = sr.getScaledHeight() - y;

        x *= scale;
        y *= scale;
        width *= scale;
        height *= scale;

        GL11.glScissor((int) x, (int) (y - height), (int) width, (int) height);
    }

    public void outlineInlinedGradientRect(final double x, final double y, final double width, final double height, final double inlineOffset, final Color color1, final Color color2) {
        gradient(x, y, width, inlineOffset, color1, color2);
        gradient(x, y + height - inlineOffset, width, inlineOffset, color2, color1);
        gradientSideways(x, y, inlineOffset, height, color1, color2);
        gradientSideways(x + width - inlineOffset, y, inlineOffset, height, color2, color1);
    }

    /**
     * ClickGui shit
     */

    public static void roundedRect(final double x, final double y, double width, double height, final double edgeRadius, final Color color) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        float sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        begin(GL11.GL_TRIANGLE_FAN);

        {
            for (double i = 180; i <= 270; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + sideLength, y + sideLength);
        }

        end();
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_TRIANGLE_FAN);

        {
            for (double i = 0; i <= 90; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + width, y + height);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_TRIANGLE_FAN);

        {
            for (double i = 270; i <= 360; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + width, y + sideLength);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_TRIANGLE_FAN);

        {
            for (double i = 90; i <= 180; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + sideLength, y + height);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        // Main block
        rect(x + halfRadius, y + halfRadius, width - halfRadius, height - halfRadius, color);

        // Horizontal bars
        rect(x, y + halfRadius, edgeRadius / 2, height - halfRadius, color);
        rect(x + width, y + halfRadius, edgeRadius / 2, height - halfRadius, color);

        // Vertical bars
        rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
        rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public void roundedOutLine(final double x, final double y, double width, double height, final double thickness, final double edgeRadius, final Color color) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        float sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_LINES);

        {
            for (double i = 180; i <= 270; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + sideLength, y + sideLength);
        }

        end();
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL11.GL_LINES);

        {
            for (double i = 0; i <= 90; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + width, y + height);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL_LINES);

        {
            for (double i = 270; i <= 360; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + width, y + sideLength);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        begin(GL_LINES);

        {
            for (double i = 90; i <= 180; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + sideLength, y + height);
        }

        end();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        stop();

        // Main block
        //rect(x + halfRadius, y + halfRadius, width - halfRadius, height - halfRadius, color);

        // Horizontal bars
        /*outline(x, y + halfRadius, edgeRadius / 2, height - halfRadius, thickness, color);
        outline(x + width, y + halfRadius, edgeRadius / 2, height - halfRadius, thickness, color);

        // Vertical bars
        outline(x + halfRadius, y, width - halfRadius, halfRadius, thickness, color);
        outline(x + halfRadius, y + height, width - halfRadius, halfRadius, thickness, color);*/
    }

    public void roundedRectCustom(final double x, final double y, double width, double height, final double edgeRadius, final Color color, final boolean topLeft, final boolean topRight, final boolean bottomLeft, final boolean bottomRight) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        float sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);

        if (topLeft) {

            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            begin(GL11.GL_TRIANGLE_FAN);

            for (double i = 180; i <= 270; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + sideLength, y + sideLength);


            end();
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            stop();

        } else {

            rect(x, y, sideLength, sideLength, color);

        }

        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);


        if (bottomRight) {
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            begin(GL11.GL_TRIANGLE_FAN);
            for (double i = 0; i <= 90; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + width, y + height);
            end();
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            stop();
        } else {
            rect(x + width, y + height, sideLength, sideLength, color);
        }


        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);


        if (topRight) {
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            begin(GL11.GL_TRIANGLE_FAN);
            for (double i = 270; i <= 360; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + width + (sideLength * Math.cos(angle)), y + (sideLength * Math.sin(angle)) + sideLength);
            }
            vertex(x + width, y + sideLength);
            end();
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            stop();
        } else {
            rect(x + width, y, sideLength, sideLength, color);
        }


        sideLength = (float) edgeRadius;
        sideLength /= 2;
        start();
        if (color != null)
            color(color);


        if (bottomLeft) {
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            begin(GL11.GL_TRIANGLE_FAN);
            for (double i = 90; i <= 180; i++) {
                final double angle = i * (Math.PI * 2) / 360;
                vertex(x + (sideLength * Math.cos(angle)) + sideLength, y + height + (sideLength * Math.sin(angle)));
            }
            vertex(x + sideLength, y + height);
            end();
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            stop();
        } else {
            rect(x, y + height, sideLength, sideLength, color);
        }


        // Main block
        rect(x + halfRadius, y + halfRadius, width - halfRadius, height - halfRadius, color);

        // Horizontal bars
        rect(x, y + halfRadius, edgeRadius / 2, height - halfRadius, color);
        rect(x + width, y + halfRadius, edgeRadius / 2, height - halfRadius, color);

        // Vertical bars
        rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
        rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public void roundedRectTop(final double x, final double y, double width, double height, final double edgeRadius, final Color color) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        // Top left and right circles
        circle(x, y, edgeRadius, color);
        circle(x + width - edgeRadius / 2, y, edgeRadius, color);
        // Main block
        rect(x, y + halfRadius, width + halfRadius, height, color);

        // Vertical bar
        rect(x + halfRadius, y, width - halfRadius, halfRadius, color);
    }

    public void roundedRectBottom(final double x, final double y, double width, double height, final double edgeRadius, final Color color) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        // Bottom left and right circles
        circle(x + width - edgeRadius / 2, y + height - edgeRadius / 2, edgeRadius, color);
        circle(x, y + height - edgeRadius / 2, edgeRadius, color);

        // Main block
        rect(x, y, width + halfRadius, height, color);

        // Vertical bar
        rect(x + halfRadius, y + height, width - halfRadius, halfRadius, color);
    }

    public void roundedRectRight(final double x, final double y, double width, double height, final double edgeRadius, final Color color1, final Color color2) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        // Top left and right circles
        circle(x + width - edgeRadius / 2, y, edgeRadius, color2);
        circle(x + width - edgeRadius / 2, y + height - edgeRadius / 2, edgeRadius, color2);

        // Main block
        gradientSideways(x, y, width, height + halfRadius, color1, color2);

        // Vertical bar
        rect(x + width, y + halfRadius, 5, height - halfRadius, color2);
    }

    public void roundedRectRightTop(final double x, final double y, double width, double height, final double edgeRadius, final Color color1, final Color color2) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        // Top left and right circles
        circle(x + width - edgeRadius / 2, y, edgeRadius, color2);

        // Main block
        gradientSideways(x, y, width, height + halfRadius, color1, color2);

        // Vertical bar
        rect(x + width, y + halfRadius, 5, height, color2);
    }

    public void roundedRectRightBottom(final double x, final double y, double width, double height, final double edgeRadius, final Color color1, final Color color2) {
        final double halfRadius = edgeRadius / 2;
        width -= halfRadius;
        height -= halfRadius;

        // Bottom left and right circles
        circle(x + width - edgeRadius / 2, y + height - edgeRadius / 2, edgeRadius, color2);

        // Main block
        gradientSideways(x, y, width, height + halfRadius, color1, color2);
        // Vertical bar
        rect(x + width, y, 5, height, color2);
    }

    public void drawBorder(final float x, final float y, final float x2, final float y2, final float width, final int color1) {
        glEnable(GL_BLEND);
        glDisable(GL_TEXTURE_2D);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_LINE_SMOOTH);

        color(new Color(color1));
        glLineWidth(width);

        glBegin(GL_LINE_LOOP);

        glVertex2d(x2, y);
        glVertex2d(x, y);
        glVertex2d(x, y2);
        glVertex2d(x2, y2);

        glEnd();

        glEnable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glDisable(GL_LINE_SMOOTH);
    }

    public static void drawTracerLine(final double x, final double y, final double z, final float red, final float green, final float blue, final float alpha, final float lineWdith) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(lineWdith);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(2);
        GL11.glVertex3d(0.0D, 0.0D + Minecraft.getMinecraft().thePlayer.getEyeHeight(), 0.0D);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }
}
