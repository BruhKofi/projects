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
        Iterator<Double> itr1 = q1.iterator();
        Iterator<Double> itr2 = q2.iterator();
        Double item1 = itr1.next();
        Double item2 = itr2.next();
        while (itr1.hasNext() || itr2.hasNext()) {
            if (!itr1.hasNext()) {
                while (itr2.hasNext()) {
                    q.enqueue(itr2.next());
                }
                return q;
            } else if (!itr2.hasNext()) {
                while (itr1.hasNext()) {
                    q.enqueue(itr1.next());
                }
                return q;
            }
            else if (item1 <= item2) {
                q.enqueue(item1);
                item1 = itr1.next();
            } else if (item2 < item1) {
                q.enqueue(item2);
                item2 = itr2.next();
            }
        }
        return q;
    }
}
