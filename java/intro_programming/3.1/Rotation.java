import java.awt.Color;

public class Rotation
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

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        double theta = Double.parseDouble(args[1]);
        rotate(pic, theta);
        swirl(pic, theta);
    }
}
