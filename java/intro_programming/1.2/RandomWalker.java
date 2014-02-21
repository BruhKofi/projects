public class RandomWalker
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        
        int moves = 0;
        int trials = 1000;
        for (int i = 0; i<trials; i++) {
            int x = 0;
            int y = 0;
            while (Math.abs(x) < N && Math.abs(y) < N) {
                double r = Math.random();
                if (r<0.25) x--;
                else if (r<0.5) x++;
                else if (r<0.75) y--;
                else y++;
                moves++;
            }
        }
        System.out.println("The average number of moves to reach the boundary of an " + N + "x" + N + " grid is " + (double)(moves)/trials);
    }
}
