import java.awt.Color;

public class Edges
{
    public static double maxLum(Picture pic, int x, int y) {
        int w = pic.width();
        int h = pic.height();
        double lum = Luminance.lum(pic.get(x, y));
        double lumTop = 0.0;
        double lumBottom = 0.0;
        double lumLeft = 0.0;
        double lumRight = 0.0;
        if (x > 0) {
            lumLeft = Luminance.lum(pic.get(x-1, y));
        }
        if (y > 0) {
            lumBottom = Luminance.lum(pic.get(x, y-1));
        }
        if (x < w-1) {
            lumRight = Luminance.lum(pic.get(x+1, y));
        }
        if (y < h-1) {
            lumTop = Luminance.lum(pic.get(x, y+1));
        }
        return max(Math.abs(lum - lumLeft), Math.abs(lum - lumBottom), Math.abs(lum - lumTop), Math.abs(lum - lumRight));
    }

    public static double max(double n1, double n2, double n3, double n4) {
        double max = n1;
        if (n2 > max) {
            max = n2;
        }
        if (n3 > max) {
            max = n3;
        }
        if (n4 > max) {
            max = n4;
        }
        return max;
    }
            
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        int w = pic.width();
        int h = pic.height();

        Picture edges = new Picture(w, h);

        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                int lum = 255 - (int)Math.round(maxLum(pic, x, y));
                edges.set(x, y, new Color(lum, lum, lum));
            }
        }
        edges.show();
    }
}
                
