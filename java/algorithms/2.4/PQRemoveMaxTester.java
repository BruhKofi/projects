public class PQRemoveMaxTester
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int cnt = 0;
        MaxPQ<Double> pq = new MaxPQ<Double>(N+1);
        for (int i = 0; i<N; i++) {
            pq.insert(StdRandom.uniform());
        }
        for (int t = 0; t<T; t++) {
            Stopwatch sw = new Stopwatch();
            while (sw.elapsedTime() < 1.0) {
                cnt++;
                double max = pq.delMax();
                pq.insert(StdRandom.uniform());
            }
        }
        StdOut.println("Average remove the maximum operations in one second for a PQ of size " + N + " is " + (double)cnt/(double)T);
    }
}
