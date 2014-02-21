public class Patterns
{
    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.GRAY); 
        StdDraw.filledSquare(0.125, 0.875, 0.125);
        StdDraw.filledSquare(0.125, 0.125, 0.125);
        StdDraw.filledSquare(0.875, 0.875, 0.125);
        StdDraw.filledSquare(0.875, 0.125, 0.125);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(new double[] {0.0, 0.0, 0.25}, new double[] {.75, .25, .5});
        StdDraw.filledPolygon(new double[] {.25, .5, .75}, new double[] {0.0, .25, 0.0});
        StdDraw.filledPolygon(new double[] {.75, 1.0, 1.0}, new double[] {.5, .75, .25,});
        StdDraw.filledPolygon(new double[] {.25, .5, .75}, new double[] {1.0, .75, 1.0});
        
        double[] x = {0.0, 0.5, 1.0, 0.5};
        double[] y = {0.5, 0.0, 0.5, 1.0};
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledPolygon(x, y);
    }
}
