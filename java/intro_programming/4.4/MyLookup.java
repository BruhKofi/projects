public class LookupMultiple
{
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        String[] database = in.readAll().split("\n");
        StdRandom.shuffle(database);

        BST<String, Queue<String>> st = new BST<String, Queue<String>>();
        for (int i = 0; i<database.length; i++) {
            String[] tokens = database[i].split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            if (!st.contains(key)) {
                st.put(key, new Queue<String>());
            }
            Queue<String> q = st.get(key);
            q.enqueue(val);
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s)) {
                Queue<String> q = st.get(s);
                StdOut.print(s + " ");
                for (String t : q) { StdOut.print(t + " "); }
            } else {
                StdOut.println("Not found");
            }
        }
    }
}