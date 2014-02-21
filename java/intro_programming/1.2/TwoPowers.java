public class TwoPowers
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        if (N < 0) return;
        for (int i = 1; i<=N; i*=2) {
            System.out.println(i);
        }
    }
}
