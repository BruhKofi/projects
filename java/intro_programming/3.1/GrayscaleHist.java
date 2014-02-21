import java.awt.Color;

public class GrayscaleHist
{
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        int height = pic.height();
        int width = pic.width();

        int[] intensities = new int[256];

        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height; y++) {
                Color color = pic.get(x, y);
                intensities[color.getRed()]++;
            }
        }
        int total = StdStats.sum(intensities);
        double[] norm = new double[256];
        for (int i = 0; i<256; i++) {
            norm[i] = (double) intensities[i] / total;
        }
        StdDraw.setYscale(0, StdStats.max(norm));
        StdStats.plotBars(norm);
    }
}
