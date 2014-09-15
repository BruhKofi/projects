public class SublinearSort
{
    private static int[] aux;

    private static boolean isSorted(int[] a) {
        for (int i = 1; i<a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }
    
    private static void quickSort(int[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo;
        int j = hi+1;
        while (true) {
            while (v > a[++i]) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private static int intAt(int k, int d) {
        int retVal = -1;
        if (d == 0) {
            int m = k/10;
            retVal = k - 10*m;
        } else if (d == 1) {
            int m = k/10;
            int n = m/10;
            retVal = m - n*10;
        }
        return retVal;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void sort(int[] a) {
        int N = a.length;
        aux = new int[N];
        sort(a, 0);
    }

    private static void sort(int[] a, int d) {
        int N = a.length;
        if (d > 1) {
            insertionSort(a);
            return;
        }

        int[] cnt = new int[11];

        for (int i = 0; i<N; i++) cnt[intAt(a[i], d)+1]++;
        for (int r = 0; r<10; r++) cnt[r+1] += cnt[r];
        for (int i = 0; i<N; i++) aux[cnt[intAt(a[i], d)]++] = a[i];
        for (int i = 0; i<N; i++) a[i] = aux[i];

        sort(a, d+1);
    }

    private static void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) {
            for (int j = i; j>0 && (a[j-1] > a[j]); j--) exch(a, j, j-1);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(N);
        }
        Stopwatch sw = new Stopwatch();
        sort(a);
        StdOut.println(sw.elapsedTime());
        a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform(N);
        }
        sw = new Stopwatch();
        quickSort(a);
        StdOut.println(sw.elapsedTime());
    }
}
        
