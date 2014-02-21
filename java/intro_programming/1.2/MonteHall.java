public class MonteHall
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int wins = 0;
        for (int i = 0; i<N; i++) {
            if (Math.random() < 0.333333333) {
                wins++;
            }
        }
        System.out.println((double)wins/N + " chances of winning without switching");
        wins = 0;
        for (int i = 0; i<N; i++) {
            if (Math.random() < 0.3333333) {
                continue;
            } else {
                wins++;
            }
        }
        System.out.println((double)wins/N + " chances of winning with switching");
    }
}
