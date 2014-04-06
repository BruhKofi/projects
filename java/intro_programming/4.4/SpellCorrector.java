public class SpellCorrector
{
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] wordList = in.readAll().split("\n");

        BST<String, String> st = new BST<String, String>();

        for (int i = 1; i<wordList.length; i++) {
            String[] word = wordList[i].split(",");
            if (word.length == 2) {
                st.put(word[0], word[1]);
            }
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s)) StdOut.println("Did you mean " + st.get(s) + "?");
        }
    }
}
