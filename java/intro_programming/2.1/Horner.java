public class Horner
{
    public static double eval(double x, double[] p) {
        double value = p[p.length-1];
        for (int i = 0; i<p.length-1; i++) {
            value = p[p.length-2-i] + x*value;
        }
        return value;
    }

    public static void main(String[] args) {
        double[] p = new double[args.length-1];
        double x = Double.parseDouble(args[0]);
        for (int i = 0; i<args.length-1; i++) {
            p[i] = Double.parseDouble(args[i+1]);
        }
        StdOut.println(eval(x, p));
    }
}

    
