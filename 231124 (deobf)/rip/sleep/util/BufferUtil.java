package rip.sleep.util;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.util.Hashtable;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public abstract class BufferUtil implements BufferedImageOp, Cloneable {
   public BufferedImage createCompatibleDestImage(BufferedImage var1, ColorModel var2) {
      Module[] var3 = Value.c27574();
      if (var2 == null) {
         var2 = var1.getColorModel();
      }

      return new BufferedImage(var2, var2.createCompatibleWritableRaster(var1.getWidth(), var1.getHeight()), var2.isAlphaPremultiplied(), (Hashtable)null);
   }

   public Rectangle2D getBounds2D(BufferedImage var1) {
      return new Rectangle(0, 0, var1.getWidth(), var1.getHeight());
   }

   public Point2D getPoint2D(Point2D var1, Point2D var2) {
      Module[] var3 = Value.c27574();
      if (var2 == null) {
         var2 = new Double();
      }

      ((Point2D)var2).setLocation(var1.getX(), var1.getY());
      return (Point2D)var2;
   }

   public RenderingHints getRenderingHints() {
      return null;
   }

   public int[] c56747(BufferedImage var1, int var2, int var3, int var4, int var5, int[] var6) {
      Value.c27574();
      int var8 = var1.getType();
      return var8 != 2 && var8 != 1 ? var1.getRGB(var2, var3, var4, var5, var6, 0, var4) : (int[])((int[])var1.getRaster().getDataElements(var2, var3, var4, var5, var6));
   }

   public void c76621(BufferedImage var1, int var2, int var3, int var4, int var5, int[] var6) {
      Value.c27574();
      int var8 = var1.getType();
      if (var8 == 2 || var8 == 1) {
         var1.getRaster().setDataElements(var2, var3, var4, var5, var6);
      }

      var1.setRGB(var2, var3, var4, var5, var6, 0, var4);
   }

   public Object clone() {
      BufferUtil var10000 = this;

      try {
         return var10000.clone();
      } catch (CloneNotSupportedException var2) {
         return null;
      }
   }

   private static JSONException c44737(JSONException var0) {
      return var0;
   }
}
