public class ShannonEntropy
{
    public static double entropy(String s) {
        int N = s.length();
        int M = 65534;
        int[] characters = new int[M];
        double entropy = 0.0;
        for (int i = 0; i<N; i++) {
            characters[(int)s.charAt(i)]++;
        }
        for (int i = 0; i<M; i++) {
            if (characters[i] > 0) {
                double p = (double) characters[i] / N;
                double log2p = Math.log(p)/Math.log(2);
                entropy += -p * log2p;
            }
        }
        return entropy;
    }

    public static void main(String[] args) {
        In webpage = new In(args[0]);
        String text = webpage.readAll();
        StdOut.println(entropy(text));
    }
}
