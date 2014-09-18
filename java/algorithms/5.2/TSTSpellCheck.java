public class TSTSpellCheck
{
    private MyTSTSet set;

    public TSTSpellCheck(String dictionary) {
        set = new MyTSTSet();
        In in = new In(dictionary);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
    }

    public boolean misspelled(String s) {
        return !set.contains(s);
    }

    public static void main(String[] args) {
        TSTSpellCheck checker = new TSTSpellCheck(args[0]);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (checker.misspelled(s)) StdOut.println(s + " is not in the dictionary");
        }
    }
}
        
