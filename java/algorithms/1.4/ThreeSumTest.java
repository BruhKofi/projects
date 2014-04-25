public class ThreeSumTest
{
    public static void main(String[] args) {
        for (int N = 256; N<16777216; N+=N) {
            int[] a = randomArray(N);
            double threeSumTime = timeTrial(a);
            double threeSumNaiveTime = timeTrialNaive(a);
            StdOut.printf("%6d %7.1f %7.1f %5.1f\n", N, threeSumTime, threeSumNaiveTime, threeSumNaiveTime/threeSumTime);
        }
    }

    public static int[] randomArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(2*N) - N;
        }
        return a;
    }

    public static double timeTrial(int[] a) {
        int N = a.length;
        Stopwatch sw = new Stopwatch();

        int cnt = 0;
        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                for (int k = j+1; k<N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return sw.elapsedTime();
    }

    public static double timeTrialNaive(int[] a) {
        int N = a.length;
        Stopwatch sw = new Stopwatch();

        int cnt = 0;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                for (int k = 0; k<N; k++) {
                    if (i < j && j < k) {
                        if (a[i] + a[j] + a[k] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return sw.elapsedTime();
    }
}
        
        