import java.util.Arrays;

public class TwoSumFaster
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(2*N) - N;
        }

        Arrays.sort(a);

        int i = 0;
        int j = N-1;
        int zeroPairs = 0;
        while (i < j) {
            if (a[i] > 0 && a[j] > 0 || a[i] < 0 && a[j] < 0) {
                StdOut.println("Number of pairs that sum to zero: " + zeroPairs);
                System.exit(0);
            }
            if (Math.abs(a[i]) > Math.abs(a[j])) i++;
            else if (Math.abs(a[i]) < Math.abs(a[j])) j--;
            else {
                zeroPairs++;
                i++;
                j--;
            }
        }
        StdOut.println("Number of pairs that sum to zero: " + zeroPairs);
    }
}
