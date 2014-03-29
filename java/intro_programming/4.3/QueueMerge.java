public class QueueMerge
{
    public static void main(String[] args) {
        
        Queue<String> left = new Queue<String>();
        Queue<String> right = new Queue<String>();
        String[] a = {"a", "c", "d", "f"};
        String[] b = {"b", "c", "e", "j"};
        for (int i = 0; i<a.length; i++) {
            left.enqueue(a[i]);
            right.enqueue(b[i]);
        }
        Queue<String> merge = merge(left, right);
        for (String s : merge) {
            StdOut.println(s);
        }
    }

    public static Queue<String> merge(Queue<String> q1, Queue<String> q2) {
        Queue<String> q = new Queue<String>();
        for (String s : q1) {
            StdOut.println(s);
        }
        StdOut.println();
        for (String s : q2) {
            StdOut.println(s);
        }
        StdOut.println();
        
        int N = q1.size();
        int M = q2.size();
        int i = 0;
        int j = 0;
        while (i <N && j < M) {
            i++; j++;
            String s1 = q1.dequeue();
            String s2 = q2.dequeue();
            if (s1.compareTo(s2) < 0) {
                while (s1.compareTo(s2) < 0 && j<M) {
                    j++;
                    q.enqueue(s2);
                    s2 = q2.dequeue();
                }
                q.enqueue(s1);
            }
            if (s2.compareTo(s1) < 0) {
                while (s2.compareTo(s1) < 0 && i<N) {
                    i++;
                    q.enqueue(s1);
                    s1 = q1.dequeue();
                }
                q.enqueue(s2);
            }
        }
        if (i == N) {
            for (String s : q2) {
                q.enqueue(s);
            }
        } else {
            for (String s : q1) {
                q.enqueue(s);
            }
        }
        return q;
    }
}
