public class Beckett
{
    public static void moves(int n, boolean enter) {
        if (n == 0) return;
        moves(n-1, true);
        if (enter) StdOut.println("enter " + n);
        else StdOut.println("exit " + n);
        moves(n-1, false);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        moves(N, true);
    }
}
