public class FibTest
{
    private static int f(int N) {
        if (N == 0) return 1;
        return f(N-1) + f(N-1);
    }

    private static double timeTest(int k) {
        Stopwatch sw = new Stopwatch();
        String s = "";
        for (int i = 0; i<k; i++) {
            s += (char)i;
        }
        String r = reverse2(s);
        return sw.elapsedTime();
    }

    public static void main(String[] args) {
        //  int k = 64;
        //  double firstTime = timeTest(k);
        //  for (k = 128; true; k*=2) {
        //      double currentTime = timeTest(k);
        //      StdOut.println(k + "\t" + currentTime/firstTime);
        //      firstTime = currentTime;
        // }
        byte[] a = new byte[5];
        
    }

    public static String method3(int N) {
        if (N == 0) return "";
        if (N == 1) return "x";
        return method3(N/2) + method3(N - N/2);
    }

    public static String reverse1(String s) {
        int N = s.length();
        String reverse = "";
        for (int i = 0; i<N; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    public static String reverse2(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String left = s.substring(0, N/2);
        String right = s.substring(N/2, N);
        return reverse2(right) + reverse2(left);
    }

}
