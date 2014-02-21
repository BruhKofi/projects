public class MinPotential
{
    public static Charge min(Charge[] charges) {
        double deltax = 0.01;
        double deltay = 0.01;
        double min = Double.POSITIVE_INFINITY;
        double xmin = 0.0;
        double ymin = 0.0;
        
        for (double x = 0.0; x < 1.0; x += deltax) {
            for (double y = 0.0; y < 1.0; y += deltay) {
                if (potentialAt(charges, x, y) < min) {
                    min = potentialAt(charges, x, y);
                    xmin = x;
                    ymin = y;
                }
            }
        }
        return new Charge(xmin, ymin, min);
    }

    public static double potentialAt(Charge[] charges, double x, double y) {
        double potential = 0.0;
        for (int i = 0; i<charges.length; i++) {
            potential += charges[i].potentialAt(x, y);
        }
        return potential;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Charge[] charges = new Charge[N];
        for (int i = 0; i<N; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double c = StdIn.readDouble();
            charges[i] = new Charge(x, y, c);
        }
        StdOut.println(min(charges));
    }
}
