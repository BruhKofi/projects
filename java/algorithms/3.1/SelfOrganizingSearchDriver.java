public class SelfOrganizingSearchDriver
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        double[] disc = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = i;
            disc[i] = 1.0/Math.pow(2, i+1);
        }
        StdRandom.shuffle(a);

        ArrayST<Integer, String> st = new ArrayST<Integer, String>();
        BinarySearchST<Integer, String> bst = new BinarySearchST<Integer, String>();
        for (int i = 0; i<N; i++) {
            st.put(a[i], "Hello");
            bst.put(a[i], "world");
        }

        Stopwatch sw = new Stopwatch();
        for (int i = 0; i<10*N; i++) {
            int k = StdRandom.discrete(disc);
            String s = st.get(k);
        }
        double stTime = sw.elapsedTime();

        sw = new Stopwatch();
        for (int i = 0; i<10*N; i++) {
            int k = StdRandom.discrete(disc);
            String s = bst.get(k);
        }
        double bstTime = sw.elapsedTime();

        StdOut.println("Binary search: " + bstTime);
        StdOut.println("Self organizing search: " + stTime);
    }
}
