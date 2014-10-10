/*
  Compare the efficiency of various sort implementations
  Use primitive data types for efficiency
*/
public class ComparingSorts
{
    private static final int CUTOFF = 7; //cutoff to insertion sort for small arrays
    
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        compareSort(N, T);
        // int[] a = randArray(N);
        // quicksort(a);
        // assert(isSorted(a));
        // a = randArray(N);
        // quicksort3Way(a);
        // assert(isSorted(a));
        // insertionSort(a);
        // assert(isSorted(a));
        // a = randArray(N);
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

    private static int[] randRepeatedArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(100);
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
        if (hi <= lo+CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
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
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
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
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
        int j = partitionMedianOf3(a, lo, hi);
        quicksortMedianOf3(a, lo, j-1);
        quicksortMedianOf3(a, j+1, hi);
    }

    private static int partitionMedianOf3(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int v = sample(a, lo, hi);//partitioning element
        int t = a[v];
        while (true) {
            while (a[++i] < t) if (i == hi) break;
            while (t < a[--j]) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, v, j);
        return j;
    }

    //Median of 3
    private static int sample(int[] arr, int lo, int hi) {
        int sz = hi-lo;
        int r1 = lo + uniform(sz);
        int r2 = lo + uniform(sz);
        int r3 = lo + uniform(sz);
        int a = arr[r1];
        int b = arr[r2];
        int c = arr[r3];
        if ((a - b) * (c - a) >= 0) return r1;
        else if ((b - a) * (c - b) >= 0) return r2;
        else return r3;
    }

    private static void insertionSort(int[] a) {
        insertionSort(a, 0, a.length-1);
    }

    private static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i<=hi; i++) {
            for (int j = i; j>lo && a[j-1] > a[j]; j--) exch(a, j-1, j);
        }
    }

    private static void compareSort(int N, int T) {
        double time1 = 0.0;
        double time2 = 0.0;
        for (int t = 0; t<T; t++) {
            int[] a = randArray(N);
            Stopwatch sw = new Stopwatch();
            quicksort(a);
            time1 += sw.elapsedTime();
        }
        for (int t = 0; t<T; t++) {
            int[] a = randArray(N);
            Stopwatch sw = new Stopwatch();
            quicksort3Way(a);
            time2 += sw.elapsedTime();
        }
        System.out.println("Time to sort " + N + " integers uniformly selected in 0 ... N-1 " + T + " times");
        System.out.println("Quicksort: " + time1);
        System.out.println("Quicksort3Way: " + time2);

        time1 = 0.0;
        time2 = 0.0;
        for (int t = 0; t<T; t++) {
            int[] a = randArray(N);
            Stopwatch sw = new Stopwatch();
            quicksort(a);
            time1 += sw.elapsedTime();
        }
        for (int t = 0; t<T; t++) {
            int[] a = randArray(N);
            Stopwatch sw = new Stopwatch();
            quicksort3Way(a);
            time2 += sw.elapsedTime();
        }
        System.out.println("Time to sort " + N + " integers uniformly selected in 0 ... 99 " + T + " times");
        System.out.println("Quicksort: " + time1);
        System.out.println("Quicksort3Way: " + time2);
    }
}
