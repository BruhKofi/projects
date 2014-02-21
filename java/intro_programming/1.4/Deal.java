/*
 *Takes command line argument N and prints N poker hands
 */
public class Deal
{
    public static void main(String[] args) {
        final int CARDS_PER_HAND = 5;
        int N = Integer.parseInt(args[0]);

        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suit.length * rank.length];
        for (int i = 0; i<suit.length; i++) {
            for (int j = 0; j<rank.length; j++) {
                deck[rank.length*i + j] = rank[j] + " of " + suit[i];
            }
        }

        int[] a = new int[deck.length];
        for (int i = 0; i<a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i<N*CARDS_PER_HAND; i++) {
            int r = (int) (Math.random() * (a.length-i));
            int t = a[r];
            a[r] = a[i];
            a[i] = t;
        }
        for (int i = 0; i<N*CARDS_PER_HAND; i++) {
            if (i%5 == 0) {
                System.out.println();
            }
            System.out.println(deck[a[i]]);
        }
    }
}
