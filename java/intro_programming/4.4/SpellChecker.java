public class SpellChecker
{
    public static void main(String[] args) {
        SET<String> set = new SET<String>();
        In in = new In(args[0]);
        String[] words = in.readAll().split("\n");
        for (String word : words) {
            set.add(word);
        }
        
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!set.contains(s)) StdOut.println("Not in dictionary: " + s);
        }
    }
}
