public class ArrayInversions
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        for (int i = 0; i<N; i++) {
            StdOut.println(a[i]);
        }
        StdOut.println();
        StdOut.println(testInversions(a));
        StdOut.println(insertionInversions(a));
        StdOut.println(inversions(a));
    }

    public static int testInversions(double[] a) {
        int cnt = 0;
        for (int i = 0; i<a.length-1; i++) {
            for (int j = i+1; j<a.length; j++) {
                if (a[i] > a[j]) {
                    cnt++;
                }
            }
        }
        StdOut.println();
        return cnt;
    }

    public static int insertionInversions(double[] a) {
        double[] aux = new double[a.length];
        for (int i = 0; i<a.length; i++) {
            aux[i] = a[i];
        }
        int cnt = 0;
        for (int i = 1; i<a.length; i++) {
            for (int j = i; j>0 && aux[j-1] > aux[j]; j--) {
                exch(aux, j, j-1);
                cnt++;
            }
        }
        return cnt;
    }

     public static int inversions(double[] a) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i<N; i++) {
            b[i] = a[i];
        }
        double[] aux = new double[N];
        return inversions(b, aux, 0, a.length - 1);
    }

    private static int inversions(double[] a, double[] aux, int lo, int hi) {
        int cnt = 0;
        if (hi <= lo) return cnt;
        int mid = lo + (hi - lo)/2;
        cnt += inversions(a, aux, lo, mid);
        cnt += inversions(a, aux, mid+1, hi);
        return merge(a, aux, lo, mid, hi);
    }

    private static int merge(double[] a, double[] aux, int lo, int mid, int hi) {
        int cnt = 0;
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
                cnt++;
            }
            else {
                a[k] = aux[j++];
                cnt++;
            }
        }
        return cnt;
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
