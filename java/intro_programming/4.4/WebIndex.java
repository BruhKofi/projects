public class WebIndex
{
    public static void main(String[] args) {
        In in = new In(args[0]);

        String[] pages = in.readAll().split("\n");

        BST<String, SET<String>> st = new BST<String, SET<String>>();

        for (String page : pages) {
            String[] text = (new In(page)).readAll().split("\\s+");
            
            for (String word : text) {
                if (word.length() > 20) continue;
                if (!st.contains(word)) st.put(word, new SET<String>());
                SET<String> set = st.get(word);
                if (set.contains(page)) continue;
                set.add(page);
            }
        }

        StdOut.println("Ready ...");

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s)) StdOut.println(s + ": " + st.get(s));
        }
    }
}

        
