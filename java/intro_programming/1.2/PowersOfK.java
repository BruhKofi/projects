public class PowersOfK
{
    public static void main(String[] args) {
        long k = Long.parseLong(args[0]);

        while (k < Long.MAX_VALUE && k > 0) {
            System.out.println(k);
            k = k*k;
        }
    }
}
