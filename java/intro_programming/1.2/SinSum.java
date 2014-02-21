public class SinSum
{
    public static void main(String[] args) {
        final int totalSum = 100;
        
        double x = Double.parseDouble(args[0]);

        double sum = 0.0;
        double num = x;
        double denom = 1.0;
        double sign = 1.0;
        int count = 1;
        for (int i = 0; i<totalSum; i++) {
            sum = (i%2 == 0) ? sum + num/denom : sum - num/denom;
            num = num*x*x;
            denom = denom*(count+1)*(count+2);
            count+=2;
        }
        System.out.println(sum);
        System.out.println(Math.sin(x));
    }
}
