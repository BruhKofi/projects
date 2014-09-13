public class KeyIndexedCount
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int offset = 'A';
    
    public static void sort(String[] a, int R) {
        int N = a.length;

        String[] aux = new String[N];
        int[] count = new int[R+1];

        //Frequency count
        for (int i = 0; i<N; i++) {
            count[a[i].charAt(0) - offset + 1]++;
        }

        //Index array
        for (int r = 0; r<R; r++) {
            count[r+1] += count[r];
        }

        //Copy to aux
        for (int i = 0; i<N; i++) {
            aux[count[a[i].charAt(0)-offset]++] = a[i];
        }

        for (int i = 0; i<N; i++) {
            a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] a = new String[N];
        for (int i = 0; i<N; i++) a[i] = String.valueOf(alphabet.charAt(StdRandom.uniform(26)));
        sort(a, 26);
        for (int i = 0; i<N; i++) StdOut.print(a[i]);
        StdOut.println();
    }
}
