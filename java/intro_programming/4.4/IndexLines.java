public class IndexLines
{
    public static void main(String[] args) {
        
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);
    
        String[] lines = StdIn.readAll().split("\n");

        BST<String, Queue<Integer>> st = new BST<String, Queue<Integer>>();

        for (int i = 0; i<lines.length; i++) {
            String[] tokens = lines[i].split("\\s+");
            for (String s : tokens) {
                if (s.length() < minlen) continue;
                String[] words = s.split("\\P{Alpha}+");
                for (String word : words) {
                    if (word.length() < minlen) continue;
                    if (!st.contains(word)) {
                        st.put(word, new Queue<Integer>());
                    }
                    Queue<Integer> q = st.get(word);
                    q.enqueue(i);
                }
            }
        }

        for (String s : st.keys()) {
            Queue<Integer> q = st.get(s);
            if (q.size() >= minocc) {
                StdOut.println(s + ": " + q);
            }
        }
    }
}