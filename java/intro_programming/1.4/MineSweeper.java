public class MineSweeper
{
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        boolean[][] game = new boolean[M+2][N+2];

        for (int i = 0; i<game.length; i++) {
            for (int j = 0; j<game[i].length; j++) {
                if (Math.random() < p) {
                    game[i][j] = true;
                }
            }
        }

        for (int i = 1; i<=M; i++) {
            for (int j = 1; j<=N; j++) {
                if (game[i][j]) {
                    System.out.print("* ");
                } else {
                    int bombCount = 0;
                    if (game[i-1][j] && i>1) bombCount++;
                    if (game[i+1][j] && i<M) bombCount++;
                    if (game[i][j-1] && j>1) bombCount++;
                    if (game[i][j+1] && j<N) bombCount++;
                    System.out.print(bombCount + " ");
                }
            }
            System.out.println();
        }
    }
}
