public class BitonicSearch
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int r = StdRandom.uniform(N);

        int[] a = new int[N];

        for (int i = 0; i<N; i++) {
            if (i <= r) {
                a[i] = i-r;
            } else {
                a[i] = r-i;
            }
        }
        for (int i = 0; i<N; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
        int k = search(0, a);
        StdOut.println(0 + " " + k);
        if (k >= 0) {
            StdOut.println(a[k]);
        }
    }

    public static int search(int key, int[] a) {
        int lo = 0;
        int hi = a.length-1;
        boolean increasing = false;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (a[mid] == key) return mid;
            if (mid < a.length-1 && a[mid] < a[mid+1]) increasing = true;
            else increasing = false;

            if (increasing) {
                if (key < a[mid]) hi = mid-1;
                else lo = mid+1;
            } else {
                if (key < a[mid]) lo = mid+1;
                else hi = mid-1;
            }
        }
        return -1;
    }
}
            
        
        