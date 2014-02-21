public class Centroid
{
    public static void main(String[] args) {
        double m = 0.0;
        double x = 0.0;
        double y = 0.0;
        while (!StdIn.isEmpty()) {
            double xi = StdIn.readDouble();
            double yi = StdIn.readDouble();
            double mi = StdIn.readDouble();
            m += mi;
            x += xi*mi;
            y += yi*mi;
        }
        x /= (double)m;
        y /= (double)m;
        StdOut.printf("The centroid of the masses is (%5.2f, %5.2f, %5.2f)", x, y, m);
        StdOut.println();
    }
}
