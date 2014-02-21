public class Marsaglia
{
    public static void main(String[] args) {
        double a = 0.0;
        double b = 0.0;
        do {
            a = 2.0*Math.random() - 1;
            b = 2.0*Math.random() - 1;
        } while (Math.sqrt(a*a + b*b) > 1.0);
        double x = 2.0*a*Math.sqrt(1 - a*a - b*b);
        double y = 2.0*b*Math.sqrt(1 - a*a - b*b);
        double z = 1 - 2.0*(a*a + b*b);
    }
}
