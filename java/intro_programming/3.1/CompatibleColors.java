import java.awt.Color;

public class CompatibleColors
{
    public static void main(String[] args) {
        Picture input = new Picture(args[0]);

        int x1 = Integer.parseInt(args[1]);
        int x2 = Integer.parseInt(args[2]);
        int y1 = Integer.parseInt(args[3]);
        int y2 = Integer.parseInt(args[4]);

        while (!StdIn.isEmpty()) {
            int r = StdIn.readInt();
            int g = StdIn.readInt();
            int b = StdIn.readInt();
            boolean valid = true;
            Color inputColor = new Color(r, g, b);
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    Color c = input.get(x, y);
                    if (!Luminance.compatible(c, inputColor)) {
                        valid = false;
                    }
                }
            }
            if (valid) {
                StdOut.println(inputColor);
            }
        }
    }
}
