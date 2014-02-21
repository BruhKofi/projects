public class BridgeHand
{
    public static void main(String[] args) {
        int HANDS = Integer.parseInt(args[0]);
        int hand1 = 0;
        int hand2 = 0;
        int hand3 = 0;
        for (int hands = 0; hands<HANDS; hands++) {
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            int[] deck = new int[52];
            for (int i = 0; i<deck.length; i++) {
                deck[i] = i;
            }
            for (int i = 0; i<deck.length; i++) {
                int r = i + (int)(Math.random() * (deck.length - i));
                int t = deck[i];
                deck[i] = deck[r];
                deck[r] = t;
            }

            for (int i = 0; i<13; i++) {
                if (deck[i] < 13) hearts++;
                else if (deck[i] < 26) diamonds++;
                else if (deck[i] < 39) spades++;
                else clubs++;
            }
            if (hearts == 5 || diamonds == 5 || spades == 5 || clubs == 5) {
                hand1++;
            } else if (hearts == 4 || diamonds == 4 || spades == 4 || clubs == 4) {
                if (hearts == 4 || diamonds == 4 || spades == 4 || clubs == 4) {
                    hand2++;
                }
            } else {
                hand3++;
            }
            
        }
        System.out.println((double)hand1/HANDS + " " + (double)hand2/HANDS + " " + (double)hand3/HANDS);
    }
}
