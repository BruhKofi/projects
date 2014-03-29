public class MyMoveToFront
{
    
    public static void main(String[] args) {
        MoveToFrontList<Character> q = new MoveToFrontList<Character>();
        while (!StdIn.isEmpty()) {
            Character c = StdIn.readChar();
            int i = q.contains(c);
            if (i > 0) {
                q.delete(i);
            }
            q.push(c);
        }
        for (Character c : q) {
            StdOut.println(c);
        }
    }
}
