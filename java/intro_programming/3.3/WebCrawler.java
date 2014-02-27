public class WebCrawler
{
    private static final int d = 10000;
    private static final int k = 5;
    
    public static void main(String[] args) {
        String startPage = args[0];
        String comparePage = args[1];
        double tol = Double.parseDouble(args[2]);
        Document start = new Document(startPage, k, d);
        Document fixedPoint = new Document(comparePage, k, d);
        crawl(fixedPoint, start, tol);
    }

    public static void crawl(Document d1, Document d2, double tol) {
        if (d1.simTo(d2) < 0.01) return;
        if (d1.simTo(d2) > tol) StdOut.println(d2.name());
        StdOut.println(d1.name() + " " + d2.name() + " " + d1.simTo(d2));
        String documentText = (new In(d2.name())).readAll();
        String start = "href=\"http://www";
        String end = "\"";
        int oldI = 0;
        int i = 0, j = 0;
        while (true) {
            i = documentText.indexOf(start, oldI);
            if (i == -1) break;
            j = documentText.indexOf(end, i+6);
            d2 = new Document(documentText.substring(i+6, j), k, d);
            oldI = i+1;
            crawl(d1, d2, tol);
        }
    }
}
