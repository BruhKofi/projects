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
        WebCrawler wb = new WebCrawler();
        wb.crawl(fixedPoint, start, tol);
    }

    public void crawl(Document d1, Document d2, double tol) {
        if (d1.simTo(d2) < 0.01) return;
        if (d1.simTo(d2) > tol) StdOut.println(d2.name());
        StdOut.println(d1.name() + " " + d2.name() + " " + d1.simTo(d2));
        int i = 0;
        while (true) {
            URLReader urlReader = nextURL(d2, i);
            if (urlReader == null) return;
            i = urlReader.indexOfURL + 1;
            if (urlReader.URL.equals(d2.name())) continue;
            StdOut.println(d2.name() + " " + i);
            d2 = new Document(urlReader.URL, k, d);
            crawl(d1, d2, tol);
        }
    }

    private URLReader nextURL(Document d, int i) {
        String documentText = (new In(d.name())).readAll();
        String start = "href=\"http://www";
        String end = "\"";
        i = documentText.indexOf(start, i);
        if (i == -1) return null;
        int j = documentText.indexOf(end, i+6);
        String URL = documentText.substring(i+6, j);
        URLReader urlReader = new URLReader();
        urlReader.URL = URL;
        urlReader.indexOfURL = i;
        return urlReader;
    }

    private class URLReader {
        String URL;
        int indexOfURL;
    }
}
