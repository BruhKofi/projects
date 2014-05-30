public class SPT
{
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<Integer>();
        while (!StdIn.isEmpty()) {
            pq.insert(StdIn.readInt());
        }
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin());
        }
    }
}
