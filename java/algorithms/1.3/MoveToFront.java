public class MoveToFront
{
    public static void main(String[] args) {
        MyLinkedList<String> buffer = new MyLinkedList<String>();

        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            if (buffer.contains(c)) {
                buffer.remove(c);
            }
            buffer.push(c);
        }
        StdOut.println();
        for (String c : buffer) {
            StdOut.println(c);
        }
    }
}