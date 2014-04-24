public class StackWithQueue<Item>
{
    private Queue<Item> q = new Queue<Item>();

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void push(Item item) {
        q.enqueue(item);
    }

    public Item pop() {
        int N = q.size();
        for (int i = 0; i<N-1; i++) {
            q.enqueue(q.dequeue());
        }
        return q.dequeue();
    }

    public static void main(String[] args) {
        StackWithQueue<String> s = new StackWithQueue<String>();
        while (!StdIn.isEmpty()) {
            s.push(StdIn.readString());
        }

        int N = s.size();
        for (int i = 0; i<N; i++) {
            StdOut.println(s.pop());
        }
    }
}