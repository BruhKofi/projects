import java.awt.Color;

public class Filters
{
    public static void rotate(Picture pic, double theta) {
        int h = pic.height();
        int w = pic.width();
        int cx = w/2;
        int cy = h/2;
        Picture rotation = new Picture(w, h);
        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                Color c = pic.get(x, y);
                int tx = (int)((x - cx)*Math.cos(theta) - (y - cy)*Math.sin(theta) + cx);
                int ty = (int)((x - cx)*Math.sin(theta) + (y - cy)*Math.cos(theta) + cy);
                if (tx >= 0 && tx < w && ty >= 0 && ty < h) {
                    rotation.set(tx, ty, c);
                }
            }
        }
        rotation.show();
    }

    public static void swirl(Picture pic, double theta) {
        int h = pic.height();
        int w = pic.width();
        int cx = w/2;
        int cy = h/2;
        Picture swirl = new Picture(w, h);
        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                double r = Math.sqrt((x - cx)*(x - cx) + (y - cy) * (y - cy));
                Color c = pic.get(x, y);
                theta = Math.PI/256.0 * r;
                int tx = (int)((x - cx)*Math.cos(theta) - (y - cy)*Math.sin(theta) + cx);
                int ty = (int)((x - cx)*Math.sin(theta) + (y - cy)*Math.cos(theta) + cy);
                if (tx >= 0 && tx < w && ty >= 0 && ty < h) {
                    swirl.set(tx, ty, c);
                }
            }
        }
        swirl.show();
    }

    public static void wave(Picture pic, int amp, int freq) {
        int h = pic.height();
        int w = pic.width();
        int cx = w/2;
        int cy = h/2;
        Picture wave = new Picture(w, h);
        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                double r = Math.sqrt((x - cx)*(x - cx) + (y - cy) * (y - cy));
                Color c = pic.get(x, y);
                int tx = x;
                int ty = y + (int)(amp*Math.sin(2*Math.PI*y/freq));
                if (tx >= 0 && tx < w && ty >= 0 && ty < h) {
                    wave.set(tx, ty, c);
                }
            }
        }
        wave.show();
    }

    public static void glass(Picture pic) {
        int h = pic.height();
        int w = pic.width();
        Picture glass = new Picture(w, h);
        int rx = 0;
        int ry = 0;
        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                do {
                    rx = StdRandom.uniform(x - 5, x + 5);
                    ry = StdRandom.uniform(y - 5, y + 5);
                } while (rx < 0 || rx >= w || ry < 0 || ry >= h);
                Color c = pic.get(rx, ry);
                glass.set(x, y, c);
            }
        }
        glass.show();
    }

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        double theta = Double.parseDouble(args[1]);
        int amp = Integer.parseInt(args[2]);
        int freq = Integer.parseInt(args[3]);
        rotate(pic, theta);
        swirl(pic, theta);
        wave(pic, amp, freq);
        glass(pic);
    }
}
