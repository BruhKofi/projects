public class RandomLib
{

    private final long a = 31415921;
    private final long b = 2718281829L;
    private long seed;

    public RandomLib(long seed) {
        this.seed = seed;
    }

    private long rand() {
        long next = a*seed+b;
        seed = next;
        return next;
    }

    public double uniform() {
        long value = rand();
        double intermediary = (double) (value) / (Long.MAX_VALUE);
        return (intermediary + 1.0) / 2.0;
    }

    public int uniform(int N) {
        return (int) (uniform() * N);
    }

    public double uniform(double m, double n) {
        return (n - m) * uniform() + m;
    }

    public boolean bernoulli(double p) {
        return uniform() < p;
    }

    public boolean bernoulli() {
        return uniform() < 0.5;
    }

    public void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int r = uniform(N - i) + i;
            double t = a[r];
            a[r] = a[i];
            a[i] = t;
        }
    }

    public void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int r = uniform(N - i) + i;
            int t = a[r];
            a[r] = a[i];
            a[i] = t;
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        RandomLib r = new RandomLib(M);
        Histogram h = new Histogram(100);
        for (int i = 0; i<N; i++) {
            h.addDataPoint(r.uniform(100));
        }
        h.draw();
    }
}
        
