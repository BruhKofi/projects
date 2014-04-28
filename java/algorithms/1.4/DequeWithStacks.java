import java.util.NoSuchElementException;

public class DequeWithStacks<Item>
{
    private Stack<Item> left = new Stack<Item>();
    private Stack<Item> middle = new Stack<Item>();
    private Stack<Item> right = new Stack<Item>();

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return left.size() + right.size() + middle.size();
    }

    public void pushLeft(Item item) {
        left.push(item);
    }

    public void pushRight(Item item) {
        right.push(item);
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException();
        if (left.isEmpty()) {
            if (middle.isEmpty()) {
                int N = right.size();
                for (int i = 0; i<N; i++) {
                    middle.push(right.pop());
                }
                return middle.pop();
            } else {
                int N = middle.size();
                for (int i = 0; i<N; i++) {
                    left.push(middle.pop());
                }
                return left.pop();
            }
        }
        return left.pop();
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException();
        if (right.isEmpty()) {
            if (middle.isEmpty()) {
                int N = left.size();
                for (int i = 0; i<N; i++) {
                    middle.push(left.pop());
                }
                return middle.pop();
            } else {
                int N = middle.size();
                for (int i = 0; i<N; i++) {
                    right.push(middle.pop());
                }
                return right.pop();
            }
        }
        return right.pop();
    }

    public static void main(String[] args) {
        DequeWithStacks<String> d = new DequeWithStacks<String>();
        while (!StdIn.isEmpty()) {
            if ("l".equalsIgnoreCase(StdIn.readString())) d.pushLeft(StdIn.readString());
            else if ("r".equalsIgnoreCase(StdIn.readString())) d.pushRight(StdIn.readString());
            else if ("-".equals(StdIn.readString())) StdOut.println(d.popLeft());
            else if ("+".equals(StdIn.readString())) StdOut.println(d.popRight());
            else {}
        }

        int N = d.size();
        for (int i = 0; i<N; i++) {
            StdOut.println(d.popLeft());
        }
    }
}
