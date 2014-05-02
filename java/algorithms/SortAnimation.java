public class SortAnimation
{
    public static void show(double[] a, int index, int min) {
        StdDraw.clear();
        StdDraw.setYscale(0, 1);
        StdDraw.setXscale(0, a.length);
        for (int i = 0; i<a.length; i++) {
            if (i < index) StdDraw.setPenColor(StdDraw.GRAY);
            if (i == min) StdDraw.setPenColor(StdDraw.RED);
            else if (i > index) StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(i+0.5, a[i]/2.0, 0.25, a[i]/2.0);
        }
        StdDraw.show(100);
    }

    public static void main(String[] args) {
        String alg = args[0];
        int N = Integer.parseInt(args[1]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        if (alg.equals("Insertion")) myInsertion(a);
        if (alg.equals("Selection")) mySelection(a);
        if (alg.equals("Shell")) myShell(a);
        if (alg.equals("Merge")) myMerge(a);
        if (alg.equals("recursiveMerge")) myRecursiveMerge(a);
        assert(isSorted(a));
    }

    public static void mySelection(double[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int min = i;
            for (int j = i+1; j<N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                    show(a, i, min);
                }
            }
            exch(a, i, min);
        }
    }

    public static void myInsertion(double[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            for (int j = i; j > 0 && a[j-1] > a[j]; j--) {
                show(a, i, j);
                exch(a, j, j-1);
            }
        }
    }

    public static void myShell(double[] a) {
        int N = a.length;
        int h = 1;
        while (h<N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = 0; i<N; i++) {
                for (int j = i; j>=h && a[j-h] > a[j]; j-=h) {
                    show(a, i, j);
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
        show(a, N-2, N-1);
    }

    public static void myMerge(double[] a) {
        int N = a.length;
        double[] aux = new double[N];
        for (int sz = 1; sz<N; sz = sz+sz) {
            for (int lo = 0; lo<N-sz; lo += sz+sz) {
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public static void myRecursiveMerge(double[] a) {
        int N = a.length;
        double[] aux = new double[N];
        myRecursiveMerge(a, aux, 0, N-1);
    }

    public static void myRecursiveMerge(double[] a, double[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        myRecursiveMerge(a, aux, lo, mid);
        myRecursiveMerge(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
        show(a, hi, lo);
    }
    
    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(double[] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }
}
