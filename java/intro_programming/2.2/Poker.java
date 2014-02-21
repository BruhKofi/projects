public class Poker
{
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int sf = 0;
        int fk = 0;
        int fh = 0;
        int f = 0;
        int s = 0;
        int th = 0;
        int tp = 0;
        int p = 0;
        for (int t = 0; t<T; t++) {
            int[] deck = new int[52];
            for (int i = 0; i<52; i++) {
                deck[i] = i;
            }
            int[] hand = deal(deck);
            int[][] handStat = hand(hand);
            String stats = cards(handStat);
            if (stats.equalsIgnoreCase("STRAIGHT FLUSH")) {
                sf++;
            } else if (stats.equalsIgnoreCase("FULL HOUSE")) {
                fh++;
            } else if (stats.equalsIgnoreCase("FLUSH")) {
                f++;
            } else if (stats.equalsIgnoreCase("STRAIGHT")) {
                s++;
            } else if (stats.equalsIgnoreCase("FOUR OF A KIND")) {
                fk++;
            } else if (stats.equalsIgnoreCase("THREE OF A KIND")) {
                th++;
            } else if (stats.equalsIgnoreCase("TWO PAIR")) {
                tp++;
            } else if (stats.equalsIgnoreCase("PAIR")) {
                p++;
            }
        }
        StdOut.printf("%8.5f stright flushes\n%8.5f four of a kinds\n%8.5f full houses\n%8.5f straights\n%8.5f flushes\n%8.5f three of a kind\n%8.5f two pair\n%8.5f pair\n", (double)sf/T, (double)fk/T, (double)fh/T, (double)s/T, (double)f/T, (double)th/T, (double)tp/T, (double)p/T);
    }

    
        
    public static int[] deal(int[] deck) {
        int[] hand = new int[5];
        StdRandom.shuffle(deck);
        for (int i = 0; i<5; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }

    public static int[][] hand(int[] deal) {
        int[][] hand = new int[5][2];
        for (int i = 0; i<5; i++) {
            hand[i][0] = deal[i]%13;
            if (deal[i] < 13) {
                hand[i][1] = 0;
            } else if (deal[i] < 26) {
                hand[i][1] = 1;
            } else if (deal[i] < 39) {
                hand[i][1] = 2;
            } else {
                hand[i][1] = 3;
            }
        }
        return hand;
    }

    public static String cards(int[][] hand) {
        int[] numbers = new int[13];
        for (int i = 0; i<5; i++) {
            numbers[hand[i][0]]++;
        }
        boolean straight = straight(numbers);
        boolean flush = flush(hand);
        if (straight && flush) {
            return "STRAIGHT FLUSH";
        } else if (flush) {
            return "FLUSH";
        } else if (straight) {
            return "STRAIGHT";
        } else if (fourOfAKind(numbers)) {
            return "FOUR OF A KIND";
        } else if (fullHouse(numbers)) {
            return "FULL HOUSE";
        } else if (threeOfAKind(numbers)) {
            return "THREE OF A KIND";
        } else if (twoPair(numbers)) {
            return "TWO PAIR";
        } else if (onePair(numbers)) {
            return "PAIR";
        }
        return "";
    }

    public static boolean straight(int[] a) {
        int cons = 0;
        for (int i = 0; i<a.length; i++) {
            if (a[i] != 0) {
                cons++;
            } else {
                cons = 0;
            }
            if (cons == 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean flush(int[][] hand) {
        int suit = hand[0][1];
        for (int i = 1; i<5; i++) {
            if (hand[i][1] != suit) {
                return false;
            }
        }
        return true;
    }

    public static boolean fourOfAKind(int[] numbers) {
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean fullHouse(int[] numbers) {
        boolean three = false;
        boolean two = false;
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 3) {
                three = true;
            }
            if (numbers[i] == 2) {
                two = true;
            }
        }
        return (three && two);
    }

    public static boolean threeOfAKind(int[] numbers) {
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean twoPair(int[] numbers) {
        int pairCount = 0;
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    public static boolean onePair(int[] numbers) {
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] == 2) {
                return true;
            }
        }
        return false;
    }
}
