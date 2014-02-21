public class Gaussian
{
    public static double phi(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }

    public static double phi(double x, double mu, double sigma) {
        return phi((x-mu)/sigma)/sigma;
    }

    public static double Phi(double z, double mu, double sigma) {
        return Phi((z-mu)/sigma);
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

    public static double phiInverse(double y) {
        double tol = 1e-5;
        double interval = 4.0;
        double x = y;
        while (Math.abs(Phi(x) - y) > tol) {
            if (Phi(x) > y) {
                x -= interval;
            
            } else {
                x += interval;
            }
            interval/=2.0;
            StdOut.println(x);
        }
        return x;
    }

    public static void main(String[] args) {
        StdOut.println(Phi(2.0));
        StdOut.println(phiInverse(2.0));
        StdOut.println(Phi(phiInverse(2.0)));
    }
}
