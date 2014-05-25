public class Domain implements Comparable<Domain>
{
    private final String[] dName;
    private final int N;

    public Domain(String s) {
        dName = s.split("\\.");
        N = dName.length;
    }

    public String[] getDName() {
        return dName;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i<N; i++) {
            s = dName[i] + "." + s;
        }
        return s.substring(0, s.length() - 1);
    }

    public int compareTo(Domain that) {
        for (int i = 0; i<Math.min(this.N, that.N); i++) {
            String thisName = dName[this.N - i - 1];
            String thatName = that.dName[that.N - i - 1];
            int c = thisName.compareTo(thatName);
            if (c < 0) return -1;
            else if (c > 0) return +1;
        }
        return this.N - that.N;
    }

    public static void main(String[] args) {
        String[] names = StdIn.readAll().split("\\s+");
        Domain[] d = new Domain[names.length];
        for (int i = 0; i<names.length; i++) {
            d[i] = new Domain(names[i]);
        }
        Quick.sort(d);
        for (int i = 0; i<d.length; i++) {
            StdOut.println(d[i]);
        }
    }
}
