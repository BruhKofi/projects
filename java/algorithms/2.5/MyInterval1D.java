import java.util.Comparator;
public class MyInterval1D
{
    private final double left;
    private final double right;

    public MyInterval1D(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double left() {
        return left;
    }

    public double right() {
        return right;
    }

    public double length() {
        return right - left;
    }

    public boolean contains(double x) {
        return x < right && x > left;
    }

    public boolean insersects(MyInterval1D that) {
        return this.right > that.left || this.left > that.right;
    }

    public static class leftOrder implements Comparator<MyInterval1D>
    {
        public int compare(MyInterval1D v, MyInterval1D w) {
            if (v.left() < w.left()) return -1;
            else if (v.left() > w.left()) return 1;
            else return 0;
        }
    }

    public static class rightOrder implements Comparator<MyInterval1D>
    {
        public int compare(MyInterval1D v, MyInterval1D w) {
            if (v.right() < w.right()) return -1;
            else if (v.right() > w.right()) return 1;
            else return 0;
        }
    }

    public static class lengthOrder implements Comparator<MyInterval1D>
    {
        public int compare(MyInterval1D v, MyInterval1D w) {
            if (v.length() < w.length()) return -1;
            else if (v.length() > w.length()) return 1;
            else return 0;
        }
    }
}
