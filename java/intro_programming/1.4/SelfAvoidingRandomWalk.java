public class SelfAvoidingRandomWalk
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int deadEnds = 0;
        int escapePathLength = 0;
        int totalLength = 0;
        int deadEndLength = 0;
        for (int t = 0; t<T; t++) {
            int pathLength = 0;
            boolean[][] a = new boolean[N][N];
            int x = N/2;
            int y = N/2;
            while (x>0 && x<N-1 && y>0 && y<N-1) {
                a[x][y] = true;
                if (a[x-1][y] && a[x+1][y] && a[x][y-1] && a[x][y+1]) {
                    deadEnds++;
                    deadEndLength+=pathLength;
                    break;
                }
                double r = Math.random();
                if (r<0.25) {
                    if (!a[x+1][y]) {
                        x++;
                        pathLength++;
                        totalLength++;
                    }
                } else if (r<0.5) {
                    if (!a[x-1][y]) {
                        x--;
                        pathLength++;
                        totalLength++;
                    }
                } else if (r<0.75) {
                    if (!a[x][y+1]) {
                        y++;
                        pathLength++;
                        totalLength++;
                    }
                } else if (r<1.00) {
                    if (!a[x][y-1]) {
                        y--;
                        pathLength++;
                        totalLength++;
                    }
                }
            }
        }
        escapePathLength = totalLength - deadEndLength;
        System.out.println(100*deadEnds/T + "% dead ends");
        System.out.println("Average length of dead end path: " + 100*deadEndLength/deadEnds);
        if (T-deadEnds>0) {
            System.out.println("Average length of escape path: " + 100*escapePathLength/(T-deadEnds));
        }
    }
}
