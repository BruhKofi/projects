public class Rescale
{
    public static void rescale(double[] a, double ymin, double ymax) {
        double max = StdStats.max(a);
        double min = StdStats.min(a);
        for (int i = 0; i<a.length; i++) {
            a[i] = (ymax-ymin)/max * a[i] + 
