public class LookupAndPut
{
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        String[] database = in.readAll().split("\n");
        StdRandom.shuffle(database);

        BST<String, String> st = new BST<String, String>();
        for (int i = 0; i<database.length; i++) {
            String[] tokens = database[i].split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("+".equals(s)) {
                String key = StdIn.readString();
                String value = StdIn.readString();
                st.put(key, value);
            } else if (st.contains(s)) {
                StdOut.println(st.get(s));
            } else {
                StdOut.println("Not found");
            }
        }
    }
}