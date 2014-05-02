public class DataGenerator
{
    public static int[] binary(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            if (i%2 == 0) a[i] = 0;
            else a[i] = 1;
        }
        StdRandom.shuffle(a);
        return a;
    }

    public static int[] geom(int N) {
        int[] a = new int[N];
        int half = N/2;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i<N; i++) {
            if (cnt++ < half) a[i] = j;
            else {
                half /= 2;
                cnt = 0;
                j++;
            }
        }
        return a;
    }

    public static int[] randZeros(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            if (i < N/2) a[i] = 0;
            else a[i] = StdRandom.uniform(N);
        }
        StdRandom.shuffle(a);
        return a;
    }

    private static void show(int[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        //show(binary(N));
        StdOut.println();
        show(geom(N));
        StdOut.println();
        //show(randZeros(N));
    }
}
