public class CardHand
{

    public static int uniform(int N) {
        return (int)(Math.random()*N);
    }

    public static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void shuffle(String[] a) {
        int N = a.length;
        for (int i = 0; i<N; i++) {
            exch(a, i, i + uniform(N-i));
        }
    }

    public static String[] createDeck() {
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suit.length * rank.length];
        for (int i = 0; i<suit.length; i++) {
            for (int j = 0; j<rank.length; j++) {
                deck[rank.length*i + j] = rank[j] + " of " + suit[i];
            }
        }
        return deck;
    }

    public static void deal(String[] deck, int index) {
        for (int i = index; i<index + 5; i++) {
            StdOut.println(deck[i]);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        String[] deck = createDeck();

        shuffle(deck);
        final int CARDS_PER_HAND = 5;
        for (int i = 0; i<N; i++) {
            deal(deck, i*CARDS_PER_HAND);
            StdOut.println("---------");
        }
    }
}
