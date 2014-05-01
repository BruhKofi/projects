public class MySortDoublingTest
{
    public static Double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static void doublingTest(String alg, int N, int T) {
        double prev = timeRandomInput(alg, N, T);
        double predTime = 0.0;
        StdOut.printf("Algorithm\t|\tArray size\t|\tPredicted Time\t|\tTime\t|\tTime/Prev\t|\tPredicted Next Time\n\n");
        for (int n = 2*N; true; n*=2) {
            double next = timeRandomInput(alg, n, T);
            StdOut.printf("%s\t\t%d\t\t\t%5.1f\t\t\t%5.1f\t\t%5.1f\t\t\t%5.1f\n", alg, n, predTime, next, next/prev, next/prev*next);
            predTime = next/prev*next;
            prev = next;
        }
    }

    public static double[][] runtimeData(String alg, int N, int T, int maxIts) {
        double[][] times = new double[maxIts][2];
        int i = 0;
        double prev = timeRandomInput(alg, N, T);
        times[i][0] = N;
        times[i++][1] = prev;
        double predTime = 0.0;
        for (int n = 2*N; i<maxIts; n*=2) {
            double next = timeRandomInput(alg, n, T);
            times[i][0] = n;
            times[i++][1] = next;
        }
        return times;
    }

    public static void plotRuntimeData(double[][] runtime) {
        int N = runtime.length;
        StdDraw.setXscale(0, runtime[N-1][0]);
        StdDraw.setYscale(0, runtime[N-1][1]);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i<N; i++) {
            StdDraw.point(runtime[i][0], runtime[i][1]);
        }
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

    public static void main(String[] args) {
        String alg = args[0];
        int N = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        int maxIts = Integer.parseInt(args[3]);
        String alg2 = args[4];
        double[][] insertion = runtimeData(alg, N, T, maxIts);
        double[][] shell = runtimeData(alg2, N, T, maxIts);
        plotRuntimeData(insertion);
        plotRuntimeData(shell);
    }
}