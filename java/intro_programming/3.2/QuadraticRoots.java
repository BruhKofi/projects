public class QuadraticRoots
{
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double disc = b*b - 4*a*c;

        if (disc > 0.0) {
            double r1 = (-b + Math.sqrt(disc))/(2.0*a);
            double r2 = (-b - Math.sqrt(disc))/(2.0*a);
            StdOut.println(r1 + " " + r2);
        } else if (disc < 0.0) {
            double re = -b/(2.0*a);
            double im = Math.sqrt(-disc)/(2.0*a);
            Complex c1 = new Complex(re, im);
            Complex c2 = new Complex(re, -im);
            StdOut.println(c1 + " " + c2);
        } else {
            StdOut.println(-b/(2.0*a));
        }
    }
}
