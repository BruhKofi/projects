public class HarmonicTest
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MyStopwatch sw = new MyStopwatch();
        for (int i = 1; i<N; i++) {
            double hn = Harmonic.H(i);
        }
        sw.stop();
        StdOut.printf("The iterative method took %8.5f seconds to compute H(%d)\n", sw.elapsedTime(), N);
        sw.start();
        for (int i = 1; i<N; i++) {
            double rhn = Harmonic.recursiveH(i);
        }
        sw.stop();
        StdOut.printf("The recursive method took %8.5f seconds to compute H(%d)\n", sw.elapsedTime(), N);
    }
}
