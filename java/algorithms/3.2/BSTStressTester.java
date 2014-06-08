public class BSTStressTester
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double recTime = 0.0;
        double itTime = 0.0;
        for (int t = 0; t<T; t++) {
            recTime += testRecursive(N);
            itTime += testIterative(N);
        }
        StdOut.printf("Recursive implementation %5.5f\n", recTime);
        StdOut.printf("Iterative implementation %5.5f\n", itTime);
    }


    public static double testRecursive(int N) {
        Stopwatch sw = new Stopwatch();
        NoCntBST<Integer, String> recBST = new NoCntBST<Integer, String>();
        for (int i = 0; i<N; i++) {
            int r = StdRandom.uniform(N);
            if (!recBST.contains(r)) recBST.put(r, "Hello World");
        }
        return sw.elapsedTime();
    }

    public static double testIterative(int N) {
        Stopwatch sw = new Stopwatch();
        IterativeBST<Integer, String> itBST = new IterativeBST<Integer, String>();
        for (int i = 0; i<N; i++) {
            int r = StdRandom.uniform(N);
            if (!itBST.contains(r)) itBST.put(r, "Hello World");
        }
        return sw.elapsedTime();
    }
}
