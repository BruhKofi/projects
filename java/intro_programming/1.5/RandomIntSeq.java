public class RandomIntSeq
{
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[0]);

        for (int i = 0; i<N; i++) {
            StdOut.println((int)(Math.random()*M));
        }
    }
}
