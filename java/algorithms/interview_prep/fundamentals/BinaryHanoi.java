public class BinaryHanoi
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        hanoi(N, true);
        StdOut.println();
    }

    public static void hanoi(int N, boolean left) {
        if (N == 0) return;
        hanoi(N-1, !left);
        if (left) StdOut.print(0);
        else StdOut.print(1);
        hanoi(N-1, !left);
    }
}
