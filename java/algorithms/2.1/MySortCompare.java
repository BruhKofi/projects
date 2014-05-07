public class MySortCompare
{
    public static Double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Topmerge")) MergeSortTester.topDown(a);
        if (alg.equals("Bottomup")) MergeSortTester.bottomUp(a);
        if (alg.equals("Merge3Way")) Merge3Way.sort(a);
        if (alg.equals("NaturalMerge")) NaturalMergesort.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static double timeSortedInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                a[i] = (double)i;
            }
            total += time(alg, a);
        }
        return total;
    }

    public static double timeReverseInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                a[i] = (double)(N - i);
            }
            total += time(alg, a);
        }
        return total;
    }

    public static double timeConstantInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                a[i] = 0.5;
            }
            total += time(alg, a);
        }
        return total;
    }

    public static double timeThreeKeysInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                if (i%3 == 0) a[i] = 0.0;
                if (i%3 == 1) a[i] = 0.5;
                else a[i] = 1.0;
            }
            StdRandom.shuffle(a);
            total += time(alg, a);
        }
        return total;
    }

    public static double timeTwoKeysInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        double d1 = StdRandom.uniform();
        double d2 = StdRandom.uniform();
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                if (i%2 == 0) a[i] = d1;
                else a[i] = d2;
            }
            StdRandom.shuffle(a);
            total += time(alg, a);
        }
        return total;
    }
    public static void doublingTest(String alg, int N, int T) {
        double prev = timeTwoKeysInput(alg, N, T);
        for (int n = 2*N; true; n*=2) {
            double next = timeTwoKeysInput(alg, n, T);
            StdOut.printf("%d %7.1f %5.1f\n", n, next, next/prev);
            prev = next;
        }
    }
    
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        for (int n = N; true; n *= 2) {
            double t1 = timeRandomInput(alg1, n, T);
            double t2 = timeRandomInput(alg2, n, T);
            StdOut.printf("For %d random doubles\n %s is ", n, alg1);
            StdOut.printf("%.1f times faster than %s\n", t2/t1, alg2);
        }
    }
}
