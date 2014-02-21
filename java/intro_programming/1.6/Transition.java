public class Transition
{
    public static void main(String[] args) {
        double click = 0.0;
        double jump = 0.0;
        if (args.length == 0) {
            click = 0.9;
            jump = 0.1;
        } else {
            click = Double.parseDouble(args[0]);
            jump = Double.parseDouble(args[1]);
        }
        int N = StdIn.readInt();

        int[][] counts = new int[N][N];
        int[] outDegree = new int[N];

        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            outDegree[i]++;
            counts[i][j]++;
        }

        StdOut.println(N + " " + N);

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (counts[i][j] > 0) {
                    counts[i][j] = 1;
                }
                double p = click*counts[i][j]/outDegree[i] + jump/N;
                StdOut.printf("%8.5f", p);
            }
            StdOut.println();
        }
    }
}
                
