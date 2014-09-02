public class One
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 1; i<N; i++) {
            if (i%5 == 0 || i%3 == 0) sum += i;
        }
        StdOut.println("The sum of all multiples of three or five below " + N + " is " + sum);
    }
}