public class RandomExp
{
    public static double exp(double lambda) {
        double r = Math.random();
        return -Math.log(r/lambda);
    }

    public static void main(String[] args) {
        for (int i = 0; i<100; i++) {
            StdOut.println(exp(1.0));
        }
    }
}
