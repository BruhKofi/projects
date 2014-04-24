public class QueueWithStacks<Item>
{
    private Stack<Item> left = new Stack<Item>();
    private Stack<Item> right = new Stack<Item>();

    public void enqueue(Item item) {
        int N = right.size();
        for (int i = 0; i<N; i++) {
            left.push(right.pop());
        }
        left.push(item);
    }

    public Item dequeue() {
        int N = left.size();
        for (int i = 0; i<N; i++) {
            right.push(left.pop());
        }
        return right.pop();
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        QueueWithStacks<String> q = new QueueWithStacks<String>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        int N = q.size();
        for (int i = 0; i<N; i++) {
            StdOut.println(q.dequeue());
        }
    }
}