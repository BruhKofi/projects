public class LPT
{
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPQ<Integer> jobs = new MaxPQ<Integer>();
        while (!StdIn.isEmpty()) {
            jobs.insert(StdIn.readInt());
        }
        Integer[] keys = new Integer[M];
        for (int i = 0; i<M; i++) {
            keys[i] = 0;
        }
        MinPQ<Integer> processors = new MinPQ<Integer>(keys);
        while (!jobs.isEmpty()) {
            int m = processors.delMin();
            m += jobs.delMax();
            processors.insert(m);
        }
        while (!processors.isEmpty()) {
            StdOut.println(processors.delMin());
        }
    }
}
        
        
