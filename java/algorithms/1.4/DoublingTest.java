public class MyDoublingTest
{
    public static double timeTrial(int N, int T) {
        int MAX = 1000000;
        int[] a = new int[N];
        double time = 0.0;
        for (int j = 0; j<T; j++) {
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform(-MAX, MAX);
            }
            Stopwatch timer = new Stopwatch();
            int cnt = ThreeSum.count(a);
            time += timer.elapsedTime();
        }
        return time/T;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        double prev = timeTrial(250, T);
        for (int N = 250; true; N+=N) {
            double time = timeTrial(N, T);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
        