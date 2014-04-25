public class CouponCollectorProblem
{
    public static int collect(int N) {
        boolean[] a = new boolean[N];
        int cnt = 0;
        int draws = 0;
        while (cnt < N) {
            draws++;
            int r = StdRandom.uniform(N);
            if (!a[r]) {
                a[r] = true;
                cnt++;
            }
        }
        return draws;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        int totalDraws = 0;
        for (int i = 0; i<T; i++) {
            totalDraws += collect(N);
        }
        double aveDraws = (double) totalDraws/T;
        StdOut.println("Average time to collect all " + N + " coupons: " + aveDraws);
    }
}