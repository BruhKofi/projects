public class SomeSorts
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        bMergeSort(a);
    }

    public static void timeTrial(int N, int T) {
        double qt = 0.0;
        double q3t = 0.0;
        for (int j = 0; j<T; j++) {
            Integer[] a = new Integer[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform(N/2);
            }
            Stopwatch sw = new Stopwatch();
            quickSort(a);
            qt += sw.elapsedTime();
            a = new Integer[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform(N/2);
            }
            sw = new Stopwatch();
            quick3Way(a);
            q3t += sw.elapsedTime();
        }
        StdOut.printf("Quicksort: %5.5f\n3 Way Quicksort: %5.5f\n", qt, q3t);
    }
            
    
    public static void selectionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int min = i;
            for (int j = i+1; j<N; j++) {
                draw(a, j, min);
                if (less(a, j, min)) min = j;
            }
            exch(a, i, min);
            draw(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) {
            for (int j = i; j > 0 && less(a, j, j-1); j--) {
                draw(a, j-1, j);
                exch(a, j-1, j);
                draw(a, j-1, j);
            }
            draw(a, i);
        }
    }

    public static void mergeSort(Comparable[] a) {
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a, new Comparable[a.length], lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux, i, j)) a[k] = aux[i++];
            else a[k] = aux[j++];
            draw(a, k);
        }
    }

    public static void bMergeSort(Comparable[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz *= 2) {
            for (int i = 0; i<N-sz; i = i+sz+sz) {
                merge(a, new Comparable[a.length], i, i + sz - 1, Math.min(i+sz+sz-1, N-1));
            }
        }
    }

    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi+1;
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void quick3Way(Comparable[] a) {
        StdRandom.shuffle(a);
        quick3Way(a, 0, a.length-1);
    }

    private static void quick3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        Comparable v = a[lo];
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) exch(a, lt++, i++);
            else if (cmp < 0) exch(a, i, gt--);
            else i++;
        }
        quick3Way(a, lo, lt-1);
        quick3Way(a, gt+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i<a.length; i++) {
            if (less(a, i, i-1)) return false;
        }
        return true;
    }

    private static void draw(Comparable[] a) {
        if (!(a[0] instanceof Double)) return;
        draw(a, -1, -1);
    }
    
    private static void draw(Comparable[] a, int i) {
        if (!(a[0] instanceof Double)) return;
        draw(a, i, -1);
    }
    
    private static void draw(Comparable[] a, int i, int j) {
        StdDraw.clear();
        if (!(a[0] instanceof Double)) return;
        int N = a.length;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, 1);
        for (int k = 0; k<N; k++) {
            Double d = (Double)a[k];
            if (k == i) {
                StdDraw.setPenColor(StdDraw.RED);
            } else if (k == j) {
                StdDraw.setPenColor(StdDraw.BLUE);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            StdDraw.filledRectangle(k + 0.5, d/2.0, 0.25, d/2.0);
        }
        StdDraw.show(100);
    }
}