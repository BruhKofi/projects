/*
  Compare the efficiency of various sort implementations
  Use primitive data types for efficiency
*/
public class ComparingSorts
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = randArray(N);
        // quicksort(a);
        // assert(isSorted(a));
        // printArray(a);
        // a = randArray(N);
        // quicksort3Way(a);
        // assert(isSorted(a));
        // printArray(a);
        insertionSort(a);
        assert(isSorted(a));
        printArray(a);
        // quicksortMedianOf3(a);
        // assert(isSorted(a));
    }

    private static void printArray(int[] a) {
        for (int i = 0; i<a.length; i++) System.out.println(a[i]);
    }
    
    private static boolean isSorted(int[] a) {
        for (int i = 1; i<a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    private static int[] randArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(N);
        return a;
    }
    
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int uniform(int N) {
        return (int)(Math.random() * N);
    }

    private static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int r = i + uniform(N-i);
            exch(a, i, r);
        }
    }

    public static void quicksort(int[] a) {
        shuffle(a);
        quicksort(a, 0, a.length-1);
    }

    private static void quicksort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quicksort(a, lo, j-1);
        quicksort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int t = a[lo];
        while (true) {
            while (a[++i] < t) if (i == hi) break;
            while (t < a[--j]) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void quicksort3Way(int[] a) {
        shuffle(a);
        quicksort3Way(a, 0, a.length-1);
    }

    private static void quicksort3Way(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int i = lo;
        int t = a[lo];
        while (i <= gt) {
            if (a[i] < t) exch(a, i++, lt++);
            else if (a[i] > t) exch(a, i, gt--);
            else i++;
        }
        quicksort3Way(a, lo, lt-1);
        quicksort3Way(a, gt+1, hi);
    }

    public static void quicksortMedianOf3(int[] a) {
        shuffle(a);
        quicksortMedianOf3(a, 0, a.length-1);
    }

    private static void quicksortMedianOf3(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitionMedianOf3(a, lo, hi);
        quicksortMedianOf3(a, lo, j-1);
        quicksortMedianOf3(a, j+1, hi);
    }

    private static int partitionMedianOf3(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int t = sample(a, lo, hi);//partitioning element
        StdOut.println(lo + " " + t + " " + hi);
        while (true) {
            while (a[++i] < t) if (i == hi) break;
            while (t < a[--j]) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    //Median of 3
    private static int sample(int[] a, int lo, int hi) {
        int[] sample = new int[3];
        int sz = hi-lo;
        sample[0] = a[lo + uniform(sz)];
        sample[1] = a[lo + uniform(sz)];
        sample[2] = a[lo + uniform(sz)];
        insertionSort(a);
        return a[1];
    }

    private static void insertionSort(int[] a) {
        for (int i = 1; i<a.length; i++) {
            for (int j = i; j>0 && a[j-1] > a[j]; j--) exch(a, j-1, j);
        }
    }
}
