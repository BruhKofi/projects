public class MinMax
{
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            if (a<0) {
                StdOut.println("Input must be a positive integer");
                continue;
            }
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
        }
        StdOut.printf("The minimum value is %d and the maximum value is %d", min, max);
        StdOut.println();
    }
}
