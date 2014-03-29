public class TwentyQuestions
{
    public static int search(int lo, int hi) {
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo)/2;
        StdOut.print("Less than " + mid + "? ");
        if (StdIn.readBoolean()) return search(lo, mid);
        return search(mid, hi);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        StdOut.println("Think of a number between 0 and " + (N-1));
        int v = search(0, N);
        StdOut.println("Your number is " + v);
    }
}