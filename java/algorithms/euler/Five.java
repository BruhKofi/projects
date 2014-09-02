public class Five
{
    private static boolean divisibleBy1To20(int N) {
        if (N < 20) return false;
        for (int i = 20; i>1; i--) {
            if (N%i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int k = 20;
        while (!divisibleBy1To20(k)) k += 20;
        StdOut.println(k);
    }
}
    