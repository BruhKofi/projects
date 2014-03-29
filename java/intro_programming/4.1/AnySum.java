public class AnySum
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        long[] input = new long[N];
        for (int i = 0; i<N; i++) {
            input[i] = StdIn.readLong();
        }
        int zeroSum = gray(N, new boolean[N+1], input);
        StdOut.println(zeroSum);
    }

    public static int show(boolean[] a, long[] l) {
        int subsetSize = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i]) subsetSize++;
        long[] values = new long[subsetSize];
        int m = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]) {
                values[m++] = l[i-1];
            }
        }
        int count = 0;
        for (int i = 0; i<subsetSize; i++) {
            for (int j = i+1; j<subsetSize; j++) {
                for (int k = j+1; k<subsetSize; k++) {
                    if (values[i] + values[j] + values[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int yarg(int n, boolean[] a, long[] l) {
        int zeroSum = 0;
        if (n == 0) return show(a, l);
        else {
            a[n] = true;
            zeroSum = gray(n-1, a, l);
            a[n] = false;
            zeroSum = yarg(n-1, a, l);
        }
        return 0;
    }

    public static int gray(int n, boolean[] a, long[] l) {
        int zeroSum = 0;
        if (n == 0) return show(a, l);
        else {
            a[n] = false;
            zeroSum = gray(n-1, a, l);
            a[n] = true;
            zeroSum = yarg(n-1, a, l);
        }
        return 0;
    }
}
