public class WebFilter
{
    public static void main(String[] args) {
        In in = new In(args[0]);

        SET<String> set = new SET<String>();

        String[] blockedSites = in.readAll().split("\n");

        for (String site : blockedSites) {
            set.add(site);
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!set.contains(s)) StdOut.println(s);
        }
    }
}
