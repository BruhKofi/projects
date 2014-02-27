public class WebCrawler
{
    public static void main(String[] args) {
        // String startPage = args[0];
        // String comparePage = args[1];
        // double tol = Double.parseDouble(args[2]);
        In in = new In("http://www.nytimes.com");
        String s = in.readAll();
        scan(s);
    }

    public static void scan(String s) {
        String start = "href=\"http://";
        String end = "\"";
        int i = s.indexOf(start);
        int j = s.indexOf(end, i+start.length());
        StdOut.println(s.substring(i+start.length(), j));
    }
}
