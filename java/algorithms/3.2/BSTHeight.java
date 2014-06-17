public class BSTHeight
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = 100;
        int h = 0;
        for (int t = 0; t<T; t++) {
            BST<Integer, Integer> st = new BST<Integer, Integer>();
            for (int i = 0; i<N; i++) {
                st.put(StdRandom.uniform(N), StdRandom.uniform(N));
            }
            h += st.height();
        }
        double p = 2.99*Math.log(N)/Math.log(2);
        StdOut.printf("Average height for tree of size %d: %5.5f\n", N, h/(double)T);
        StdOut.printf("Predicted height for tree of size %d: %5.5f\n", N, p);
    }
}