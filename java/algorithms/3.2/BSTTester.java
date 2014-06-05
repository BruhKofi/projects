public class BSTTester
{
    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            st.put(StdIn.readString(), i);
        }

        StdOut.println(st.min() + " " + st.max());
        st.deleteMin();
        st.deleteMax();
        StdOut.println(st.min() + " " + st.max());

        StdOut.println();

        StdOut.println(st.rank("youve"));
        StdOut.println(st.select(5));
        st.delete(st.select(5));
        StdOut.println(st.select(5));
        StdOut.println(st.floor("bobby"));
        StdOut.println(st.ceiling("emerson"));
        // for (String s : st.keys()) {
        //     StdOut.println(s + " " + st.get(s));
        // }
    }
}