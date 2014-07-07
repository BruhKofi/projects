public class Four
{
    private static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i<N/2; i++) {
            if (s.charAt(i) != s.charAt(N-1-i)) return false;
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        return isPalindrome(Integer.toString(n));
    }

    public static void main(String[] args) {
        int max = 1;
        for (int i = 1; i<1000; i++) {
            for (int j = 1; j<1000; j++) {
                int k = i*j;
                if (k > max && isPalindrome(k)) max = k;
            }
        }
        StdOut.println(max);
    }
}