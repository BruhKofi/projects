public class LongestRun
{
    public static void main(String[] args) {
        int prev = 0;
        int current;
        int longestRun = 0;;
        int run = 0;;
        int myInt = Integer.MIN_VALUE;
        prev = StdIn.readInt();
        while (!StdIn.isEmpty()) {
            current = StdIn.readInt();
            if (current == prev) {
                run++;
            } else {
                if (run > longestRun) {
                    longestRun = run;
                    run = 0;
                    myInt = prev;
                }
            }
            prev = current;
        }
        StdOut.printf("Longest run: %d consecutive %ds", longestRun, myInt);
        StdOut.println();
    }
}
