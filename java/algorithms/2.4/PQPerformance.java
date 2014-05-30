public class PQPerformance
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double time = 0.0;
        for (int t = 0; t<T; t++) {
            MaxPQ<Double> pq = new MaxPQ<Double>(N+1);
            for (int i = 0; i<N; i++) {
                pq.insert(StdRandom.uniform());
            }
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i<N/2; i++) {
                double d= pq.delMax();
            }
            for (int i = 0; i<N/2; i++) {
                pq.insert(StdRandom.uniform());
            }
            time += sw.elapsedTime();
        }
        StdOut.println("Average time to delete and insert into PQ of size " + N + " is " + time/(double)T);
    }
}
