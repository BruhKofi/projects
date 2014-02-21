import java.awt.Color;

public class RGBPic
{
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        Color c = new Color(r, g, b);

        Picture pic = new Picture(256, 256);

        for (int i = 0; i<256; i++) {
            for (int j = 0; j<256; j++) {
                pic.set(i, j, c);
            }
        }
        pic.show();
    }
}
