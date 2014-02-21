import java.awt.Color;

public class PictureFilter
{
    public static void read() {
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        Picture pic = new Picture(w, h);
        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                int r = StdIn.readInt();
                int g = StdIn.readInt();
                int b = StdIn.readInt();
                pic.set(x, y, new Color(r, g, b));
            }
        }
        pic.show();
    }

    public static void write(Picture pic) {
        int w = pic.width();
        int h = pic.height();

        StdOut.println(w);
        StdOut.println(h);

        for (int x = 0; x<w; x++) {
            for (int y = 0; y<h; y++) {
                Color c = pic.get(x, y);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                StdOut.print(r + " " +  g + " " +  b + "\t");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        read();
    }
}
