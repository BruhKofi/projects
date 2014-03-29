public class ModifiedBinarySearch
{
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int lo, int hi) {
        if (hi <= lo) return -hi;
        int mid = lo + (hi-lo)/2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) return search(key, a, lo, mid);
        if (cmp < 0) return search(key, a, mid+1, hi);
        else {
            while (key.equals(a[mid])) mid--;
            return mid+1;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAll().split("\\s+");
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, a) < 0) StdOut.println(search(key, a));
        }
    }
}