public class CosSum
{
    public static void main(String[] args) {
        final int totalSums = 100;
        double x = Double.parseDouble(args[0]);
        double sum = 0.0;
        double num = 1.0;
        double denom = 1.0;
        int count = 1;
        for (int i = 0; i<totalSums; i++) {
            sum = (i%2 == 0) ? sum + num/denom : sum - num/denom;
            num = x*x*num;
            denom = (count)*(count+1)*denom;
            count+=2;
        }
        System.out.println(sum);
        System.out.println(Math.cos(x));
    }
}
