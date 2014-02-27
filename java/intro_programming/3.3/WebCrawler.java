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

    public static void compareDocs(Document fixedPoint, Document variable, double tol) {
        if (fixedPoint.simTo(variable) > tol) StdOut.println(variable.name());
    }

    public static void scan(String s) {
        String start = "href=\"http://www";
        String end = "\"";
        int oldI = 0;
        int i = 0, j = 0;
        while (true) {
            i = s.indexOf(start, oldI);
            if (i == -1) break;
            j = s.indexOf(end, i+6);
            StdOut.println(s.substring(i+6, j));
            oldI = i+1;
        }
    }
}
