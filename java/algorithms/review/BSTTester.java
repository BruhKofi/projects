public class BSTTester
{
    private static final String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

    public static void main(String[] args) {
        RBBST<String, Integer> st = new RBBST<String, Integer>();
        buildST(st);
        for (String s : st.keys()) StdOut.println(s + " " + st.get(s));
        testGet(st);
        testDelete(st);
        testOrderedOps(st);
    }

    public static void buildST(RBBST<String, Integer> st) {
        String[] keys = alphabet.split("\\s+");
        for (int i = 0; i<keys.length; i++) {
            st.put(keys[i], i);
        }
        assert(st.size() == keys.length);
    }

    public static void testGet(RBBST<String, Integer> st) {
        assert(st.get("A") == 0);
        assert(st.get("Z") == 25);
        assert(st.get("a") == null);
    }

    public static void testDelete(RBBST<String, Integer> st) {
        assert(st.contains("A"));
        assert("A".equals(st.min()));
        st.delMin();
        assert(!st.contains("A"));
        assert("B".equals(st.min()));
        assert("Z".equals(st.max()));
        st.delMax();
        assert("Y".equals(st.max()));
        assert(st.contains("K"));
        st.delete("K");
        assert(!st.contains("K"));
    }

    public static void testOrderedOps(RBBST<String, Integer> st) {
        assert("J".equals(st.select(st.rank("J"))));
        assert(5 == st.rank(st.select(5)));
        assert("J".equals(st.floor("K")));
        assert("L".equals(st.ceiling("K")));
    }
}
