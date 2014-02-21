public class Expf
{
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int max = 100;

        double sum = 0.0;
        double num = 1.0;
        double denom = 1.0;
        for (int i = 0; i<max; i++) {
            sum += num/denom;
            num*=x;
            denom*=(i+1);
        }
        System.out.println(sum);
        System.out.println(Math.pow(Math.E, x));
    }
}
