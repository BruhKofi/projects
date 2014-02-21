public class Gambler
{
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        double p = Double.parseDouble(args[3]);
        int maxBets = Integer.parseInt(args[4]);

        int wins = 0;
        int t = 0;
        int totalMoney = 0;
        while (t<T) {
            int cash = stake;
            int bets = 0;
            while (cash > 0 && cash < goal && bets < maxBets) {
                //                for (int k = 0; k<cash; k++) {
                //                    System.out.print("*");
                //                }
                //                System.out.println();
                bets++;
                if (Math.random() < p) cash++;
                else cash--;
            }
            if (cash == goal) wins++;
            totalMoney += cash;
            t++;
        }
        System.out.println(100*wins/T + "% wins");
        System.out.println("Expected money at end: " + totalMoney/T);
    }
}
