import java.util.Comparator;

public class MyPoint2D
{
    private final double x;
    private final double y;

    public MyPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double r() {
        return Math.sqrt(x*x + y*y);
    }

    public double theta() {
        return Math.atan2(y,x);
    }

    public double distanceTo(MyPoint2D that) {
        return Math.sqrt((x - that.x) * (x - that.x) + (y - that.y) * (y - that.y));
    }

    public static void main(String[] args) {
        MyPoint2D p1 = new MyPoint2D(0.0, 1.0);
        MyPoint2D p2 = new MyPoint2D(1.0, 1.0);
        double d = p1.distanceTo(p2);
    }

    public static class xOrder implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D v, MyPoint2D w) {
            if (v.x() < w.x()) return -1;
            else if (v.x() > w.x()) return 1;
            else return 0;
        }
    }

    public static class yOrder implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D v, MyPoint2D w) {
            if (v.y() < w.y()) return -1;
            else if (v.y() > w.y()) return 1;
            else return 0;
        }
    }

    public static class rCompare implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D v, MyPoint2D w) {
            if (v.r() < w.r()) return -1;
            else if (v.r() > w.r()) return 1;
            else return 0;
        }
    }

    public class dCompare implements Comparator<MyPoint2D>
    {
        private MyPoint2D p;
        public dCompare(MyPoint2D p) {
            this.p = p;
        }
        public int compare(MyPoint2D v, MyPoint2D w) {
            double d1 = p.distanceTo(v);
            double d2 = p.distanceTo(w);
            if (d1 > d2) return 1;
            else if (d1 < d2) return -1;
            else return 0;
        }
    }

    public class aCompare implements Comparator<MyPoint2D>
    {
        private MyPoint2D p;
        public aCompare(MyPoint2D p) {
            this.p = p;
        }
        public int compare(MyPoint2D v, MyPoint2D w) {
            double a1 = Math.atan2(v.y() - p.y(), v.x() - p.x());
            double a2 = Math.atan2(w.y() - p.y(), w.x() - p.x());
            if (a1 > a2) return 1;
            else if (a1 < a2) return -1;
            else return 0;
        }
    }
}
