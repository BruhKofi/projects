import java.util.Arrays;

public class TwoSum
{
    public static boolean twoSum(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i<N; i++) {
            if (i < N-1 && a[i] == 0) {
                if (a[i+1] == 0) return true;
            } else if (Arrays.binarySearch(a, -a[i]) >= 0) return true;
        }
        return false;
    }

    public static boolean threeSum(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                int key = -(a[i] + a[j]);
                 if (j < N-1 && a[i] == 0 && a[j] == 0) {
                    if (a[j+1] == 0) return true;
                } else {
                    int t = Arrays.binarySearch(a, key);
                    if (t >= 0 && !(t == i || t == j)) return true;
                }
            }
        }
        return false;
    }

    private static int[] randomArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(2*N) - N;
        }
        return a;
    }

    public static void main(String[] args) {
        // for (int i = 100; true; i*=2) {
        //     int[] a = randomArray(i);
        //     Stopwatch sw = new Stopwatch();
        //     //StdOut.println(twoSum(a));
        //     StdOut.println(sw.elapsedTime());
        // }
        int[] a = {-1, 1, 2, 3};
        int[] b = {-1, 1, 2, 3, 4, 5, 0};
        StdOut.println(threeSum(a) + " " + threeSum(b));
    }
}