import java.math.BigInteger;

public class BigFactorial
{
    public static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i<=n; i++) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }
        return factorial;
    }

    private static int longestRun(BigInteger b, int k) {
        String s = b.toString();
        int longestRun = 0;
        int seq = 0;
        for (int i = 0; i<s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) == k) seq++;
            if (seq > longestRun) longestRun = seq;
            if (Character.getNumericValue(s.charAt(i)) != k) seq = 0;
        }
        return longestRun;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        BigInteger b = factorial(N);
        StdOut.println(longestRun(b, 9));
    }
}
