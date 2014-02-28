public class CompareAllGenomes
{
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int N = StdIn.readInt();
        MyGenome[] a = new MyGenome[N];

        for (int i = 0; i<N; i++) {
            a[i] = new MyGenome(StdIn.readString(), k, d);
        }

        StdOut.print("    ");
        for (int j = 0; j<N; j++) {
            StdOut.printf("    %.4s", a[j].name());
        }
        StdOut.println();

        for (int i = 0; i<N; i++) {
            StdOut.printf("%.4s", a[i].name());
            for (int j = 0; j<N; j++) {
                StdOut.printf("%8.2f", a[i].simTo(a[j]));
            }
            StdOut.println();
        }
    }
}
