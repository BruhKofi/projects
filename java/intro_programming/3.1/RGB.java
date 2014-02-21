import java.awt.Color;
public class RGB
{
    public static void main(String[] args) {
        Picture input = new Picture(args[0]);
        int w = input.width();
        int h = input.height();
        
        Picture r = new Picture(w, h);
        Picture g = new Picture(w, h);
        Picture b = new Picture(w, h);

        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                r.set(x, y, new Color(input.get(x, y).getRed(), 0, 0));
                g.set(x, y, new Color(0, input.get(x, y).getGreen(), 0));
                b.set(x, y, new Color(0, 0, input.get(x, y).getBlue()));
            }
        }

        input.show();
        r.show();
        g.show();
        b.show();
    }
}
