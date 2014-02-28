public class MyGenome
{
    private final String id;
    private final Vector profile;

    public MyGenome(String name, int k, int d) {
        id = name;
        String s = (new In(name)).readAll();
        int N = s.length();
        double[] freq = new double[d];
        for (int i = 0; i<N-k; i++) {
            int h = hash(s.substring(i, i+k));
            freq[Math.abs(h%d)]++;
        }
        profile = (new Vector(freq)).direction();
    }

    public double simTo(MyGenome gene) {
        return profile.dot(gene.profile);
    }

    public String name() {
        return id;
    }

    public int hash(String s) {
        int N = s.length();
        int hash = 0;
        for (int i = 0; i<N; i++) {
            int j = 0;
            if ('a' == Character.toLowerCase(s.charAt(i))) j = 0;
            if ('c' == Character.toLowerCase(s.charAt(i))) j = 1;
            if ('g' == Character.toLowerCase(s.charAt(i))) j = 2;
            if ('t' == Character.toLowerCase(s.charAt(i))) j = 3;
            hash = hash*4 + j;
        }
        return hash;
    }

    public String unhash(int hash) {
        StringBuilder sb = new StringBuilder();
        while (hash > 0) {
            int j = hash % 4;
            if (j == 0) sb.append('A');
            if (j == 1) sb.append('C');
            if (j == 2) sb.append('G');
            if (j == 3) sb.append('T');
            hash /= 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String name = args[0];
        int k = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);
        MyGenome gene = new MyGenome(name, k, d);
        StdOut.println(gene.profile);
    }
}
