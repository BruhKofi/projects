public class MyIndex
{
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);

        String[] words = StdIn.readAll().split("\\s+");

        BST<String, Queue<Integer>> st = new BST<String, Queue<Integer>>();

        for (int i = 0; i<words.length; i++) {
            String s = words[i];
            if (s.length() < minlen) continue;
            if (!st.contains(s)) st.put(s, new Queue<Integer>());
            Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }

        for (String s : st.keys()) {
            Queue<Integer> q = st.get(s);
            if (q.size() > minocc) {
                StdOut.println(s + ": " + q);
            }
        }
    }
}
