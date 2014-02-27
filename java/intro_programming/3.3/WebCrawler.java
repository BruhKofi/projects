public class WebCrawler
{
    private static final int d = 10000;
    private static final int k = 5;
    
    public static void main(String[] args) {
        // String startPage = args[0];
        // String comparePage = args[1];
        // double tol = Double.parseDouble(args[2]);
        // Document start = new Document(startPage, k, d);
        // Document fixedPoint = new Document(comparePage, k, d);
        // WebCrawler wb = new WebCrawler();
        // wb.crawl(fixedPoint, start, tol, 0);

        //test nextURL method
        WebCrawler wc = new WebCrawler();
        Document doc = new Document("http://www.nytimes.com", k, d);
        int i = 0;
        while (true) {
            URLReader r = wc.nextURL(doc, i);
            if (r.indexOfURL == -1) break;
            i = r.indexOfURL + 6;
            StdOut.println(r.URL);
        }
    }

    public void crawl(Document d1, Document d2, double tol, int i) {
        if (d1.simTo(d2) < 0.01) return;
        if (d1.simTo(d2) > tol) StdOut.println(d2.name());
        StdOut.println(d1.name() + " " + d2.name() + " " + d1.simTo(d2));
        while (true) {
            URLReader urlReader = nextURL(d2, i);
            if (urlReader == null) return;
            i = urlReader.indexOfURL + 6;
            StdOut.println("URLReader name: " + urlReader.URL);
            d2 = new Document(urlReader.URL, k, d);
            crawl(d1, d2, tol, i);
        }
    }

    private URLReader nextURL(Document d, int i) {
        String documentText = (new In(d.name())).readAll();
        String start = "href=\"http://www";
        String end = "html\"";
        i = documentText.indexOf(start, i);
        if (i == -1) return new URLReader("", -1);
        int j = documentText.indexOf(end, i);
        String URL = documentText.substring(i+6, j+4);
        URLReader urlReader = new URLReader();
        urlReader.URL = URL;
        urlReader.indexOfURL = i;
        return urlReader;
    }

    private class URLReader {
        String URL;
        int indexOfURL;
        private URLReader() {};
        private URLReader(String url, int index) {
            URL = url;
            indexOfURL = index;
        }
    }
}
