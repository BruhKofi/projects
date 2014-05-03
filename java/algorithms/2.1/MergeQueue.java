import java.util.Iterator;
public class MergeQueue
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Queue<Double> q1 = new Queue<Double>();
        Queue<Double> q2 = new Queue<Double>();
        for (int i = 0; i<N; i++) {
            q1.enqueue((double)i);
            q2.enqueue((double)(i+1));
        }
        
        Queue<Double> q = merge(q1, q2);
        for (Double d : q) {
            StdOut.println(d);
        }
    }
    
    public static Queue<Double> merge(Queue<Double> q1, Queue<Double> q2) {
        if (q1.isEmpty()) return q2;
        if (q2.isEmpty()) return q1;
        Queue<Double> q = new Queue<Double>();
        int N = q1.size();
        int M = q2.size();
        Double[] d1 = new Double[N];
        Double[] d2 = new Double[M];
        for (int i = 0; i<d1.length; i++) {
            d1[i] = q1.dequeue();
        }
        for (int i = 0; i<d2.length; i++) {
            d2[i] = q2.dequeue();
        }
        int i = 0;
        int j = 0;
        while (i < N || j < M) {
            if (i >= N) q.enqueue(d2[j++]);
            else if (j >= M) q.enqueue(d1[i++]);
            else if (d1[i] < d2[j]) q.enqueue(d1[i++]);
            else q.enqueue(d2[j++]);
        }
        return q;
    }
}
