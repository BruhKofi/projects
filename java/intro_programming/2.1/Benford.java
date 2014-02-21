import java.util.InputMismatchException;
public class Benford
{

    public static int leadingDigit(int n) {
        if (n<10) {
            return n;
        }
        int m = 10;
        while (m < n) {
            m*=10;
        }
        m/=10;
        return n/m;
    }

    public static void printArray(double[] a) {
        for (int i = 0; i<a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] leadingDigitCount = new int[10];
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            cnt++;
            int n = 0;
            try {
                n = StdIn.readInt();
            } catch (InputMismatchException e) {
                continue;
            }
            int l = leadingDigit(n);
            leadingDigitCount[l]++;
        }
        double[] hist = new double[10];
        for (int i = 0; i<10; i++) {
            hist[i] = ((double)(leadingDigitCount[i]))/cnt;
        }
        printArray(hist);
    }
}
        
