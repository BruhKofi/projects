public class CornerCases
{
    public static void main(String[] args) {
        String alg = args[0];
        String input = args[1];
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        doublingTest(alg, input, N, T);
        
        if (input.equals("sorted")) timeSortedInput(alg, N, T);
        if (input.equals("reverse")) timeReverseInput(alg, N, T);
        if (input.equals("constant")) timeConstantInput(alg, N, T);
        if (input.equals("twoKeys")) timeTwoKeysInput(alg, N, T);
    }

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

    public static void doublingTest(String alg, String input, int N, int T) {
        double prev = 0.0;
        if (input.equals("sorted")) prev = timeSortedInput(alg, N, T);
        if (input.equals("reverse")) prev = timeReverseInput(alg, N, T);
        if (input.equals("constant")) prev = timeConstantInput(alg, N, T);
        if (input.equals("twoKeys")) prev = timeTwoKeysInput(alg, N, T);
        for (int n = 2*N; true; n*=2) {
            double next = 0.0;
            if (input.equals("sorted")) next = timeSortedInput(alg, N, T);
            if (input.equals("reverse")) next = timeReverseInput(alg, N, T);
            if (input.equals("constant")) next = timeConstantInput(alg, N, T);
            if (input.equals("twoKeys")) next = timeTwoKeysInput(alg, N, T);
            StdOut.printf("%d %7.1f %5.1f\n", n, next, next/prev);
            prev = next;
        }
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
}
