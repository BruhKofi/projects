public class BirthdayProblem
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(test(N));
        StdOut.println(Math.sqrt(Math.PI*N/2));
    }

    public static double test(int N) {
        int totalCount = 0;
        final int trials = 1000000;
        for (int i = 0; i<trials; i++) {
            boolean[] a = new boolean[N];
            int cnt = 0;
            while (true) {
                cnt++;
                int r = StdRandom.uniform(N);
                if (!a[r]) a[r] = true;
                else break;
            }
            totalCount+=cnt;
        }
        return (double)totalCount/trials;
    }
}