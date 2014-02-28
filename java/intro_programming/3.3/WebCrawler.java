public class WebCrawler
{
    private static final int d = 10000;
    private static final int k = 5;
    
    public static void main(String[] args) {
        // test crawl method
        Document d1 = new Document(args[0], k, d);
        Document d2 = new Document(args[1], k, d);
        double tol = Double.parseDouble(args[2]);
        crawl(d1, d2, tol);
    }

    public static void crawl(Document d1, Document d2, double tol) {
        if (d1.simTo(d2) < 0.01) return;
        //        if (d1.simTo(d2) > tol) StdOut.println(d1.name() + " " + d2.name() + " " + d1.simTo(d2));
        String webText = (new In(d2.name())).readAll();
        int N = webText.length();
        String start = "href=\"http://www";
        int S = start.length();;
        String end = "\"";
        int E = end.length();;

        int beg = -1;
        for (int i = 0; i<N-S; i++) {
            String startCodon = webText.substring(i, i+S);
            String endCodon = webText.substring(i, i+E);
            if (start.equals(startCodon)) beg = i;
            if (end.equals(endCodon) && beg != -1 && i - beg > 6) {
                String URL = webText.substring(beg+6, i);
                if (!d2.name().equals(URL)) {
                    StdOut.println(URL);
                    d2 = new Document(URL, k, d);
                    crawl(d1, d2, tol);
                }
                beg = -1;
            }
        }
    }
}
