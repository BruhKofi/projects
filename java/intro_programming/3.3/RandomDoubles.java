public class RandomDoubles
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Out out = new Out("doubles.txt");

        for (int i = 0; i<N; i++) {
            out.println(StdRandom.uniform());
        }
    }
}