public class PermutationMinima
{
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int totalMinima = 0;
        for (int j = 0; j<M; j++) {
            int[] a = new int[N];
            for (int i = 0; i<N; i++) {
                a[i] = i;
            }
            for (int i = 0; i<N; i++) {
                int r = i + (int)(Math.random()*(N-i));
                int t = a[r];
                a[r] = a[i];
                a[i] = t;
            }
            int leftToRightMinima = 1;
            int min = a[0];
            for (int i = 0; i<N; i++) {
                if (a[i] < min) {
                    min = a[i];
                    leftToRightMinima++;
                }
            }
            totalMinima+=leftToRightMinima;
        }
        System.out.println("Average number of left-to-right minima: " + (double)totalMinima/M);
    }
}
