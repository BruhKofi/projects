public class Histogram
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, 1.0);
        double deltax = (r-l)/N;
        int[] bins = new int[N];

        int count = 0;
        while (!StdIn.isEmpty()) {
            double d = StdIn.readDouble();
            count++;
            for (int i = 0; i<N; i++) {
                if (d < l + i*deltax) {
                    bins[i]++;
                    break;
                }
            }
        }
        for (int i = 0; i<N; i++) {
            StdOut.println(((double)bins[i])/count);
            StdDraw.rectangle(l + i*deltax, 0.0, deltax/2.0, ((double)bins[i])/count);
        }
    }
}
