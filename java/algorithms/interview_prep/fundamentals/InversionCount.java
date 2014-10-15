/*
  The number of inversions in an array is the
  number of exchanges performed by inserion sort
*/
public class InversionCount
{
    public static int inversionCount(Comparable[] a) {
        int cnt = 0;
        Comparable[] aux = new Comparable[a.length];
        for (int i = 0; i<aux.length; i++) aux[i] = a[i];
        for (int i = 0; i<a.length; i++) {
            for (int j = i; j>0 && less(aux[j], aux[j-1]); j--) {
                exch(aux, j-1, j);
                cnt++;
            }
        }
        return cnt;
    }

    public static int linearithmicInversions(Comparable[] a) {
        int N = a.length;
        Comparable[] copy = new Comparable[N];
        for (int i = 0; i<N; i++) copy[i] = a[i];// Defensive copy
        Comparable[] aux = new Comparable[N];
        return linearithmicInversions(copy, aux, 0, N-1);
    }

    private static int linearithmicInversions(Comparable[] a, Comparable[] aux, int lo, int hi) {
        int cnt = 0;
        if (hi <= lo) return cnt;
        int mid = lo + (hi - lo)/2;
        cnt += linearithmicInversions(a, aux, lo, mid);
        cnt += linearithmicInversions(a, aux, mid+1, hi);
        cnt += merge(a, aux, lo, mid, hi);
        return cnt;
    }

    private static int merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int cnt = 0;
        for (int k = lo; k<=hi; k++) aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else {
                a[k] = aux[j++];
                cnt += (mid-i+1);
            }
        }
        return cnt;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static Double[] doubles(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform();
        return a;
    }

    public static void main(String[] args) {
        Double[] a = doubles(Integer.parseInt(args[0]));
        StdOut.println(inversionCount(a));
        StdOut.println(linearithmicInversions(a));
    }
}
