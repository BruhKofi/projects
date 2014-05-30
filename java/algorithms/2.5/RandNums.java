public class RandNums
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 0; i<N; i++) {
            StdOut.println(StdRandom.uniform(N));
        }
    }
}
