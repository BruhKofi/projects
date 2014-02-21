public class Cards
{
    public static void main(String[] args) {
        String input = args[0];

        if ("HEARTS".equalsIgnoreCase(input)) {
            StdDraw.setPenColor(StdDraw.RED);
            double[] x = {0.5, 0.25, 0.5, 0.75};
            double[] y = {0.0, 0.25, 0.5, 0.25};
            StdDraw.filledPolygon(x, y);
            double r = Math.sqrt(2)/4.0;
            StdDraw.filledCircle(0.375, 0.375, r);
            StdDraw.filledCircle(0.375, 0.625, r);
        } else if ("DIAMONDS".equalsIgnoreCase(input)) {
            StdDraw.setPenColor(StdDraw.RED);
            double[] x = {0.0, 0.5, 0.1, 0.5};
            double[] y = {0.5, 0.1, 0.5, 0.0};
            StdDraw.filledPolygon(x, y);
        } else if ("CLUBS".equalsIgnoreCase(input)) {
            StdDraw.setPenColor(StdDraw.BLACK);
            double r = 1.0/3.0;
            StdDraw.filledCircle(1.0/3.0, 1.0/3.0, r);
            StdDraw.filledCircle(1.0/3.0, 2.0/3.0, r);
            StdDraw.filledCircle(1.0/3.0 + Math.sqrt(2)/6.0, 1.0/3.0 + Math.sqrt(2)/6.0, r);
            StdDraw.filledRectangle(0.5, 0.25, 0.25, 0.25); 
        } else if ("SPADES".equalsIgnoreCase(input)) {
            StdDraw.setPenColor(StdDraw.BLACK);
            double[] x = {0.5, 0.25, 0.5, 0.75};
            double[] y = {0.0, 0.25, 0.5, 0.25};
            StdDraw.filledPolygon(x, y);
            double r = Math.sqrt(2)/4.0;
            StdDraw.filledCircle(0.375, 0.375, r);
            StdDraw.filledCircle(0.375, 0.625, r);
            StdDraw.filledRectangle(0.5, 0.75, 0.125, 0.25);
        } else {
            StdOut.println("Input must be one of DIAMONDS, HEARTS, SPADES, CLUBS");
        }
    }
}
