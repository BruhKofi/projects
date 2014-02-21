public class InversePermutation
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            a[i] = i;
        }

        for (int i = 0; i<N; i++) {
            int r = i + (int)(Math.random()*(N-i));
            int t = a[i];
            a[i] = a[r];
            a[r] = t;
        }

        int[] b = new int[N];
        for (int i = 0; i<N; i++) {
            b[a[i]] = i;
        }

        for (int i = 0; i<N; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i<N; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i<N; i++) {
            System.out.print(b[a[i]] + " ");
        }
        System.out.println();
    }
}
