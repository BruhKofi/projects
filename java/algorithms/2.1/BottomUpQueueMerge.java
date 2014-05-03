public class BottomUpQueueMerge
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        Queue<Double> q = sort(a);
        for (Double d : q) {
            StdOut.println(d);
        }
    }
    
    public static Queue<Double> sort(double[] a) {
        int N = a.length;
        Queue<Queue<Double>> q = new Queue<Queue<Double>>();
        for (int i = 0; i<N; i++) {
            Queue<Double> m = new Queue<Double>();
            m.enqueue(a[i]);
            q.enqueue(m);
        }
        while (q.size() > 1) {
            Queue<Double> q1 = q.dequeue();
            Queue<Double> q2 = q.dequeue();
            Queue<Double> r = MergeQueue.merge(q1, q2);
            q.enqueue(r);
        }
        return q.dequeue();
    }
}
