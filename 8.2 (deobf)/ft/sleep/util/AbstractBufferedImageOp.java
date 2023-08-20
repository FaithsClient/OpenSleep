package ft.sleep.util;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.util.Hashtable;

public abstract class AbstractBufferedImageOp implements BufferedImageOp, Cloneable {
   public BufferedImage createCompatibleDestImage(BufferedImage cuyoyode, ColorModel ufebabev) {
      if (ufebabev == null) {
         ufebabev = ((BufferedImage)cuyoyode).getColorModel();
      }

      return new BufferedImage((ColorModel)ufebabev, ((ColorModel)ufebabev).createCompatibleWritableRaster(((BufferedImage)cuyoyode).getWidth(), ((BufferedImage)cuyoyode).getHeight()), ((ColorModel)ufebabev).isAlphaPremultiplied(), (Hashtable)null);
   }

   public Rectangle2D getBounds2D(BufferedImage tesufeli) {
      return new Rectangle(0, 0, ((BufferedImage)tesufeli).getWidth(), ((BufferedImage)tesufeli).getHeight());
   }

   public Point2D getPoint2D(Point2D bride, Point2D badly) {
      if (badly == null) {
         badly = new Double();
      }

      ((Point2D)badly).setLocation(((Point2D)bride).getX(), ((Point2D)bride).getY());
      return (Point2D)badly;
   }

   public RenderingHints getRenderingHints() {
      return null;
   }

   public int[] _failing(BufferedImage latin, int sight, int madison, int archive, int pieces, int[] periodic) {
      Object voyuer = ((BufferedImage)latin).getType();
      return voyuer != 2 && voyuer != 1 ? ((BufferedImage)latin).getRGB((int)sight, (int)madison, (int)archive, (int)pieces, (int[])periodic, 0, (int)archive) : (int[])((int[])((BufferedImage)latin).getRaster().getDataElements((int)sight, (int)madison, (int)archive, (int)pieces, periodic));
   }

   public void _captain(BufferedImage pursuit, int scotia, int biggest, int director, int fraud, int[] flags) {
      Object butts = ((BufferedImage)pursuit).getType();
      if (butts != 2 && butts != 1) {
         ((BufferedImage)pursuit).setRGB((int)scotia, (int)biggest, (int)director, (int)fraud, (int[])flags, 0, (int)director);
      } else {
         ((BufferedImage)pursuit).getRaster().setDataElements((int)scotia, (int)biggest, (int)director, (int)fraud, flags);
      }

   }

   public Object clone() {
      return super.clone();
   }
}
