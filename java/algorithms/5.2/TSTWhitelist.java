public class TSTWhitelist
{
    public static void main(String[] args) {
        MyTSTSet set = new MyTSTSet();
        In in = new In(args[0]);
        while (!in.isEmpty()) set.add(in.readString());
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (set.contains(s)) StdOut.println(s);
        }
    }
}
