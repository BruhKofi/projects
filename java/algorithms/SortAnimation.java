public class SortAnimation
{
    public static void show(double[] a, int index, int min) {
        StdDraw.clear();
        StdDraw.setYscale(0, 1);
        StdDraw.setXscale(0, a.length);
        for (int i = 0; i<a.length; i++) {
            if (i < index) StdDraw.setPenColor(StdDraw.GRAY);
            if (i == min) StdDraw.setPenColor(StdDraw.RED);
            else if (i > index) StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(i+0.5, a[i]/2.0, 0.25, a[i]/2.0);
        }
        StdDraw.show(100);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        // for (int i = 0; i<N; i++) {
        //     a[i] = StdRandom.uniform();
        // }
        // mySelection(a);
        // for (int i = 0; i<N; i++) {
        //     a[i] = StdRandom.uniform();
        // }
        // myInsertion(a);
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        myShell(a);
    }

    public static void mySelection(double[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int min = i;
            for (int j = i+1; j<N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                    show(a, i, min);
                }
            }
            exch(a, i, min);
        }
    }

    public static void myInsertion(double[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            for (int j = i; j > 0 && a[j-1] > a[j]; j--) {
                show(a, i, j);
                exch(a, j, j-1);
            }
        }
    }

    public static void myShell(double[] a) {
        int N = a.length;
        int h = 1;
        while (h<N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = 0; i<N; i++) {
                for (int j = i; j>=h && a[j-h] > a[j]; j-=h) {
                    show(a, i, j);
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
        show(a, N-2, N-1);
    }

    public static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
