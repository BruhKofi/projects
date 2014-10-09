/*
  Compare the efficiency of various sort implementations
  Use primitive data types for efficiency
*/
public class ComparingSorts
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = randArray(N);
        quicksort(a);
        assert(isSorted(a));
        printArray(a);
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
}
