public class RandomWalkers
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int steps = 0;

        for (int T = 1; T<=512; T*=2) {
            for (int t = 0; t<T; t++) {
                
            int cellsTouched = 1;
                boolean[][] grid = new boolean[N][N];

                int[][] walkers = new int[N][2];
                for (int i = 0; i<N; i++) {
                    for (int j = 0; j<2; j++) {
                        walkers[i][j] = N/2;
                    }
                }

                while(cellsTouched<=N*N) {
                    for (int i = 0; i<N; i++) {
                        if (!grid[walkers[i][0]][walkers[i][1]]) {
                            grid[walkers[i][0]][walkers[i][1]] = true;
                            cellsTouched++;
                        }
                    }

                    for (int i = 0; i<N; i++) {
                        double r = Math.random();
                        if (r<0.25 && walkers[i][0] - 1 >= 0) {
                            walkers[i][0]--;
                            steps++;
                        } else if (r<0.5 && walkers[i][0] +1 < N) {
                            walkers[i][0]++;
                            steps++;
                        } else if (r<0.75 && walkers[i][1] -1 >= 0) {
                            walkers[i][1]--;
                            steps++;
                        } else if (walkers[i][1]+1 < N) {
                            walkers[i][1]++;
                            steps++;
                        }
                    }
                }
            }
            System.out.println(T + "\t" + steps);
        }
    }
}
