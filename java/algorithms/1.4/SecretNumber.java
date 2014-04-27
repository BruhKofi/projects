public class SecretNumber
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        final int trials = 1000;
        int totalGuesses = 0;
        for (int i = 0; i<trials; i++) {
            int r = StdRandom.uniform(N) + 1;
            totalGuesses += guess(N, r);
        }
        double aveGuesses = (double)totalGuesses/trials;
        StdOut.println("It took an average of  " + aveGuesses + " guesses to find the secret number in an array of size " + N);
    }

    public static int guess(int N, int r) {
        int lo = 0;
        int hi = N;
        int length = N;
        int guesses = 2;
        int first = N/4;
        int second = 3*N/4;
        while (first != r && second != r && guesses < 20) {
            guesses += 2;
            length /= 2;
            if (Math.abs(first - r) < Math.abs(second - r)) {
                hi = hi - length;
            } else {
                lo = lo + length;
            }
            first = lo + (hi - lo)/4;
            second = lo + 3*(hi - lo)/4;
        }
        return guesses;
    }
}
