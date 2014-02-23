public class MakeVectors
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Out out = new Out("vectors.txt");

        out.println(N);
        out.println(M);

        for (int i = 0; i<N*M; i++) {
            out.println(StdRandom.uniform());
        }
    }
}
