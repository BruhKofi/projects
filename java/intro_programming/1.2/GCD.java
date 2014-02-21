public class GCD
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        while (m>0) {
            int t = m;
            m = n%t;
            n = t;
        }
        System.out.println(n);
    }
}
