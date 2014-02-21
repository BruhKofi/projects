public class Life
{
    public static boolean[][] ex1() {
        boolean[][] a = new boolean[6][6];
        for (int i = 0; i<6; i++) {
            for (int j = 0; j<6; j++) {
                a[i][j] = true;
            }
        }
        a[1][2] = false;
        a[2][3] = false;
        a[3][1] = false;
        a[3][2] = false;
        a[3][3] = false;
        return a;
    }
        
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                a[i][j] = StdRandom.bernoulli(p);
            }
        }
        return a;
    }

    public static boolean equals(boolean[][] a, boolean[][] b) {
        if (a.length != b.length) return false;
        if (a[0].length != b[0].length) return false;
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    public static boolean[][] copy(boolean[][] a) {
        boolean[][] b = new boolean[a.length][a[0].length];
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }

    public static boolean alive(boolean[][] a, int i, int j) {
        if (i < 0 || i >= a.length) return false;
        if (j < 0 || j >= a[0].length) return false;
        return a[i][j];
    }

    public static int liveCount(boolean[][] a, int i, int j) {
        if (i < 0 || i >= a.length) return -1;
        if (j < 0 || j >= a[0].length) return -1;
        int liveCount = 0;
        if (alive(a, i-1, j)) liveCount++;
        if (alive(a, i+1, j)) liveCount++;
        if (alive(a, i, j-1)) liveCount++;
        if (alive(a, i, j+1)) liveCount++;
        return liveCount;
    }

    public static boolean comesAlive(boolean[][] a, int i, int j) {
        return liveCount(a, i, j) == 3;
    }

    public static boolean dies(boolean[][] a, int i, int j) {
        int cnt = liveCount(a, i, j);
        return cnt == 1 || cnt > 3;
    }

    public static void update(boolean[][] a) {
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[0].length; j++) {
                if (alive(a, i, j) && dies(a, i, j)) {
                    a[i][j] = false;
                }
                if (!alive(a, i, j) && comesAlive(a, i, j)) {
                    a[i][j] = true;
                }
            }
        }
    }

    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, N-i-1, .5);
    }

    public static void play(int N, double p) {
        boolean[][] a = random(N, p);
        boolean[][] copy = new boolean[N][N];
        while (!equals(a, copy)) {
            StdDraw.clear();
            show(a, true);
            StdDraw.show(1000);
            copy = copy(a);
            update(a);
        }
    }
            

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        play(N, p);
    }
}
