public class InvertConcordance
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        String[] words = StdIn.readAll().split("\n");
        BST<Integer, String> st = new BST<Integer, String>();

        for (String line : words) {
            String[] concordance = line.split("\\s+");
            String word = concordance[0].substring(0, concordance[0].length() - 1);
            for (int i = 1; i<concordance.length; i++) {
                int position = Integer.parseInt(concordance[i]);
                if (position > N) break;
                st.put(position, word);
            }
        }

        for (Integer a : st.keys()) {
            StdOut.print(st.get(a) + " ");
        }
    }
}
