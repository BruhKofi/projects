public class Hyperbolic
{
    public static double sinh(double x) {
        return (Math.exp(x) - Math.exp(-x))/2;
    }

    public static double cosh(double x) {
        return (Math.exp(x) + Math.exp(-x))/2;
    }

    public static double tanh(double x) {
        return sinh(x)/cosh(x);
    }

    public static double coth(double x) {
        return cosh(x)/sinh(x);
    }

    public static double sech(double x) {
        return 1.0/cosh(x);
    }

    public static double csch(double x) {
        return 1.0/sinh(x);
    }
}
