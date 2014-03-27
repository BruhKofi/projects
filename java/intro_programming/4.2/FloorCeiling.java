public class FloorCeiling
{
    public static int floor(Comparable[] a, Comparable key) {
        return floor(a, key, 0, a.length);
    }

    public static int floor(Comparable[] a, Comparable key, int lo, int hi) {
        if (hi <= lo) {
            if (key.compareTo(a[0]) > 0) return -1;
            else return 0;
        }
        int mid = lo + (hi - lo)/2;
        if (key.compareTo(a[mid]) < 0) return floor(a, key, lo, mid);
        else if (key.compareTo(a[mid]) > 0) return floor(a, key, mid+1, hi);
        else {
            while (key.compareTo(a[mid]) == 0 && mid > 0) mid--;
            return mid;
        }
    }

    public static int ceiling(Comparable[] a, Comparable key) {
        return ceiling(a, key, 0, a.length);
    }

    public static int ceiling(Comparable[] a, Comparable key, int lo, int hi) {
        if (hi <= lo) {
            if (key.compareTo(a[a.length-1]) > 0) return -1;
            else return a.length-1;
        }
        int mid = lo + (hi - lo)/2;
        if (key.compareTo(a[mid]) < 0) return ceiling(a, key, lo, mid);
        else if (key.compareTo(a[mid]) > 0) return ceiling(a, key, mid+1, hi);
        else {
            while (key.compareTo(a[mid]) == 0 && mid < a.length-1) mid++;
            return mid;
        }
    }

    public static void main(String[] args) {
        String[] test = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        StdOut.println(floor(test, "a"));
        StdOut.println(floor(test, "d"));
        StdOut.println(ceiling(test, "j"));
        StdOut.println(ceiling(test, "d"));
    }
}