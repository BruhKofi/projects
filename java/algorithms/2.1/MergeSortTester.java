public class MergeSortTester
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = rand(N);
        int top = topDown(a);
        assert(isSorted(a));
        a = rand(N);
        int bot = bottomUp(a);
        assert(isSorted(a));
        StdOut.println("Compares for top down for N = " + N);
        StdOut.println(": " + top);
        StdOut.println("Compares for bottom up for N = " + N);
        StdOut.println(": " + bot);
        StdOut.println("6*" + N + "*lg(" + N + ")");
        StdOut.println(6*N*Math.log(N)/Math.log(2));
    }

    private static double[] rand(int N) {
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }
    
    public static int merge(double[] a, double[] aux, int lo, int mid, int hi) {
        int cnt = 0;
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            cnt += 2;
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                cnt += 2;
            }
            else if (j > hi) {
                a[k] = aux[i++];
                cnt += 2;
            }
            else if (aux[i] < aux[j]) {
                cnt += 2;
                a[k] = aux[i++];
                cnt += 2;
            }
            else {
                a[k] = aux[j++];
                cnt += 2;
            }
        }
        return cnt;
    }

    public static int mergeFaster(double[] a, double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=mid; k++) {
            cnt += 2;
            aux[k] = a[k];
        }
        for (int k = mid+1; k<=hi; k++) {
            
        for (int k = lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            }
            else {
                a[k] = aux[j++];
            }
        }
        return cnt;
    }

    public static int topDown(double[] a) {
        int cnt = 0;
        double[] aux = new double[a.length];
        int lo = 0;
        int hi = a.length - 1;
        cnt += topDown(a, aux, lo, hi);
        return cnt;
    }

    private static int topDown(double[] a, double[] aux, int lo, int hi) {
        int cnt = 0;
        if (hi <= lo) return cnt;
        int mid = lo + (hi - lo)/2;
        topDown(a, aux, lo, mid);
        topDown(a, aux, mid+1, hi);
        if (a[mid] < a[mid+1]) return 0;
        cnt += merge(a, aux, lo, mid, hi);
        return cnt;
    }

    public static int bottomUp(double[] a) {
        int cnt = 0;
        int N = a.length;
        double[] aux = new double[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N-sz; lo += 2*sz) {
                cnt += merge(a, aux, lo, lo + sz - 1, Math.min(N-1, lo + sz + sz - 1));
            }
        }
        return cnt;
    }
}
