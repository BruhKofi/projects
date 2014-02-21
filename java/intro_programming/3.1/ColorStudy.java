import java.awt.Color;

public class ColorStudy
{
    public static void main(String[] args) {
        double step = 1.0/16;
        double big = 1.0/32;
        double small = 1.0/64;
        int i = 0, j = 0;
        for (double x = 0.0; x < 1.0; x+=step) {
            j = 0;
            for (double y = 0.0; y < 1.0; y+=step) {
                Color outer = new Color(0, 0, i*j);
                Color inner = new Color(i*j, i*j, i*j);
                StdDraw.setPenColor(outer);
                StdDraw.filledSquare(x, y, big);
                StdDraw.setPenColor(inner);
                StdDraw.filledSquare(x, y, small);
                j++;
            }
            i++;
        }
    }
}        
