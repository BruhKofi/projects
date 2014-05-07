public class StequeWithStacks<Item>
{
    private Stack<Item> left = new Stack<Item>();
    private Stack<Item> right = new Stack<Item>();

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(Item item) {
        int N = right.size();
        for (int i = 0; i<N; i++) {
            left.push(right.pop());
        }
        left.push(item);
    }

    public void enqueue(Item item) {
        int N = left.size();
        for (int i = 0; i<N; i++) {
            right.push(left.pop());
        }
        right.push(item);
    }

    public Item pop() {
        int N = right.size();
        for (int i = 0; i<N; i++) {
            left.push(right.pop());
        }
        return left.pop();
    }

    public static void main(String[] args) {
        StequeWithStacks<String> s = new StequeWithStacks<String>();
        while (!StdIn.isEmpty()) {
            if ("+".equals(StdIn.readString())) {
                s.push(StdIn.readString());
            } else if ("-".equals(StdIn.readString())) {
                s.enqueue(StdIn.readString());
            }
        }
        int N = s.size();
        for (int i = 0; i<N; i++) {
            StdOut.println(s.pop());
        }
    }
}