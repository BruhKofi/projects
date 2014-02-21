public class Shuffler
{
    public static int uniform(int N) {
        return (int)(Math.random()*N);
    }
            
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int r = i + uniform(N-i);
            int t = a[i];
            a[i] = a[r];
            a[r] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i<100; i++) {
            a[i] = i;
        }
        int[] b = new int[100];
        for (int i = 0; i<10; i++) {
            shuffle(a);
            for (int j = 0; j<100; j++) {
                b[a[j]]++;
                StdOut.println(a[j]);
            }
        }
        for (int i = 0; i<100; i++) {
            StdOut.println(b[i]);
        }
    }
}
