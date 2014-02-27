public class Document
{
    private final String id;
    private final Vector profile;

    public Document(String name, int k, int d) {
        id = name;
        String doc = (new In(name)).readAll();
        int N = doc.length();
        double[] freq = new double[d];
        for (int i = 0; i < N-k; i++) {
            int h = doc.substring(i, i+k).hashCode();
            freq[Math.abs(h%d)]++;
        }
        profile = (new Vector(freq)).direction();
    }

    public double simTo(Document other) {
        return profile.dot(other.profile);
    }

    public String name() {
        return id;
    }
}