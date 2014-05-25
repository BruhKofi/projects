public class MySortableVector implements Comparable<MySortableVector>
{
    private int[] coords;
    private int N;

    public MySortableVector(int N) {
        this.N = N;
        coords = new int[N];
    }

    public MySortableVector(int[] coords) {
        this.coords = coords;
        this.N = coords.length;
    }

    public int compareTo(MySortableVector that) {
        for (int i = 0; i<Math.min(this.N, that.N); i++) {
            if (this.coords[i] < that.coords[i]) return -1;
            else if (this.coords[i] > that.coords[i]) return 1;
        }
        if (this.N == that.N) return 0;
        else return this.N - that.N;
    }
}
