public class JosephusProblem
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        Queue<Integer> q = new Queue<Integer>();
        int current = M;
        for (int i = 0; i<N; i++) {
            int h = current%N;
            if (h == 0) h = N;
            q.enqueue(h-1);
            current+=M;
        }
        
        for (Integer j : q) {
            StdOut.println(q.dequeue() + " ");
        }
    }
}
