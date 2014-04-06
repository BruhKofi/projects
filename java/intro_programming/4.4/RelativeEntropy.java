public class RelativeEntropy
{
    private static double lg(double N) {
        return Math.log(N)/Math.log(2);
    }

    public static void main(String[] args) {
        String[] text = (new In(args[0])).readAll().split("\\s++");
        BST<String, Integer> st = new BST<String, Integer>();

        int wordCount = 0;
        for (String word : text) {
            if (!word.matches("\\P{Alpha}++")) continue;
            wordCount++;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        int N = wordCount;
        int k = st.size();

        double E = 0.0;
        for (String s : st.keys()) {
            E += ((double)st.get(s))*lg(k/(double)st.get(s));
        }
        E *= 1.0/(N*lg(N));

        StdOut.println(E);
    }
}
