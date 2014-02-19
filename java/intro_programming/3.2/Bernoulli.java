public class Bernoulli
{
    public static int binomial(int N, double p) {
        int heads = 0;
        for (int i = 0; i<N; i++) {
            if (StdRandom.bernoulli(p)) heads++;
        }
        return heads;
    }
}
