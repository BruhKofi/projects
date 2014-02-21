public class ThreeDRandomWalk
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int pathLength = 0;
        int deadEnds = 0;
        for (int t = 0; t<T; t++) {
            boolean[][][] grid = new boolean[N][N][N];
            int x, y, z;
            x = y = z = N/2;

            while (x>0 && x<N-1 && y>0 && y<N-1 && z>0 && z<N-1) {
                grid[x][y][z] = true;
                if (grid[x+1][y][z] && grid[x-1][y][z] && grid[x][y+1][z] && grid[x][y-1][z] && grid[x][y][z+1] && grid[x][y][z-1]) {
                    deadEnds++;
                    break;
                }

                double r = Math.random();

                if (r<1.0/6.0) {
                    if (!grid[x+1][y][z]) {
                        x++;
                        pathLength++;
                    }
                } else if (r<2.0*1.0/6) {
                    if (!grid[x-1][y][z]) {
                        x--;
                        pathLength++;
                    }
                } else if (r<3.0*1.0/6) {
                    if (!grid[x][y+1][z]) {
                        y++;
                        pathLength++;
                    }
                } else if (r<4.0*1.0/6) {
                    if (!grid[x][y-1][z]) {
                        y--;
                        pathLength++;
                    }
                } else if (r<5.0*1.0/6) {
                    if (!grid[x][y][z+1]) {
                        z++;
                        pathLength++;
                    }
                } else {
                    if (!grid[x][y][z-1]) {
                        z--;
                        pathLength++;
                    }
                }
            }
        }
        System.out.println((double)deadEnds/T + "% dead ends");
        System.out.println("Average walk length: " + (double)pathLength/T);
    }
}
