import java.util.Arrays;

public class ThreeSumFaster
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];

        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(2*N) - N;
        }

        Arrays.sort(a);

        int z = 0;
        for (int i = 0; i<N; i++) {
            int value = -a[i];
            int j = i+1;
            int k = N-1;
            while (j < k) {
                if (a[j] + a[k] < value) j++;
                else if (a[j] + a[k] > value) k--;
                else {
                    z++;
                    j++;
                    k--;
                }
            }
        }
        StdOut.println(z + " triples sum to zero");
    }
}