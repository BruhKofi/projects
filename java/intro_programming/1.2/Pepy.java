public class Pepy
{
    public static void main(String[] args) {
        final int trials = 100000;

        int rolls = 0;
        int wins = 0;
        int ones;
        for (int i = 0; i<trials; i++) {
            ones = 0;
            for (int j = 0; j<6; j++) {
                int roll = (int)(Math.random()*6) + 1;
                if (roll == 1) {
                    ones++;
                }
            }
            if (ones > 0) {
                wins++;
            }
        }
        System.out.println("With " + trials + " tries to roll at least one 1 in six die rolls, you succeeded " +
                           (double)wins/trials + " percent of the time");
        wins = 0;
        for (int i = 0; i<trials; i++) {
            ones = 0;
            for (int j = 0; j<12; j++) {
                int roll = (int)(Math.random()*6) + 1;
                if (roll == 1) {
                    ones++;
                }
            }
            if (ones > 1) {
                wins++;
            }
        }
        System.out.println("With " + trials + " tries to roll at least two 1s in twelve die rolls, you succeeded " +
                           (double)wins/trials + " percent of the time");
    }
}
