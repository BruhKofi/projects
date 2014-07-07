public class Two
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int f = 1;
        int g = 2;
        int sum = g;
        while (true) {
            g = f+g;
            if (g > N) break;
            if (g%2 == 0) sum += g;
            f = g-f;
        }
        StdOut.println("The sum of the even terms in the Fibonacci sequence less than " + N + " is " + sum);
    }
}