public class TextBuffer
{
    private Stack<Character> left = new Stack<Character>();
    private Stack<Character> right = new Stack<Character>(); 

    public void insert(char c) {
        left.push(c);
    }

    public void left(int k) {
        if (k > left.size()) {
            StdOut.println("Only " + left.size() + " characters in left buffer");
            return;
        }
        for (int i = 0; i<k; i++) {
            right.push(left.pop());
        }
    }

    public void right(int k) {
        if (k > right.size()) {
            StdOut.println("Only " + right.size() + " characters in right buffer");
            return;
        }
        for (int i = 0; i<k; i++) {
            left.push(right.pop());
        }
    }

    public char get() {
        if (left.isEmpty()) StdOut.println("Move right");
        return left.peek();
    }

    public char delete() {
        if (left.isEmpty()) StdOut.println("Move right");
        return left.pop();
    }

    public int size() {
        return left.size() + right.size();
    }

    public static void main(String[] args) {
        TextBuffer tb = new TextBuffer();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            char c = s.charAt(0);
            if ('-' == c) tb.left(StdIn.readInt());
            else if ('+' == c) tb.right(StdIn.readInt());
            else if ('*' == c) StdOut.println(tb.get());
            else if ('$' == c) StdOut.println(tb.delete());
            else tb.insert(c);
        }
    }
}
