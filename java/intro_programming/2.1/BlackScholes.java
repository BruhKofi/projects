public class BlackScholes
{
    public static double blackScholes(double s, double x, double r, double sigma, int t) {
        double a = (Math.log(s/x) + (r + (sigma*sigma))/2 * t);
        double b = a- sigma*Math.sqrt(t);

        return s*Phi(a) - x*Math.exp(-r*t)*Phi(b);
    }

    public static double phi(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }

    public static double Phi(double z) {
        if (z < -8.0) return 0.0;
        if (z > 8.0) return 1;
        double sum = 0.0;
        double term = z;
        for (int i = 3; sum != sum+term; i+=2) {
            sum += term;
            term = term*z*z/i;
        }
        return 0.5+phi(z)*sum;
    }

    public static void main(String[] args) {
        double s = Double.parseDouble(args[0]);
        double x = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double sigma = Double.parseDouble(args[3]);
        int t = Integer.parseInt(args[4]);
        StdOut.println(blackScholes(s, x, r, sigma, t));
    }

}
