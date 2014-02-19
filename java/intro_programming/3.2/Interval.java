public class Interval
{
    private final double left;
    private final double right;
    private final boolean empty;

    public Interval(double left, double right) {
        if (right < left) {
            empty = true;
        } else {empty = false;}
        this.left = left;
        this.right = right;
    }

    public boolean contains(double x) {
        if (empty) return false;
        return x > left && x < right;
    }

    public boolean intersects(Interval b) {
        if (empty || b.empty) return false;
        return left < b.right || right > b.left;
    }

    public String toString() {
        return "(" + left + ", " + right + ")";
    }

    public static void main(String[] args) {
        // double x = Double.parseDouble(args[0]);
        // while (!StdIn.isEmpty()) {
        //     double left = StdIn.readDouble();
        //     double right = StdIn.readDouble();
        //     Interval i = new Interval(left, right);
        //     if (i.contains(x)) {
        //         StdOut.println(i);
        //     }
        // }

        int N = Integer.parseInt(args[0]);
        Interval[] intervals = new Interval[N];
        for (int i = 0; i<N; i++) {
            intervals[i] = new Interval(StdIn.readDouble(), StdIn.readDouble());
        }
        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + "\t" + intervals[j]);
                }
            }
        }
    }
}
