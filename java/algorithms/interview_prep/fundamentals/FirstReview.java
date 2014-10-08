public class FirstReview
{
    private static final double tol = 1e-6;

    private static final String[] suites = {"Clubs", "Hearts", "Diamonds", "Spades"};
    private static final String[] vals = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        StdOut.println(couponCollector(N, T));
        StdOut.println(N*harmonic(N));
    }
    
    public static boolean evenDivisor(int a, int b) {
        if (a%b == 0) return true;
        else if (b%a == 0) return true;
        return false;
    }

    public static int randomInt(int lo, int hi) {
        return lo + rand(hi-lo);
    }

    private static int rand(int N) {
        return (int)(Math.random()*(N));
    }

    public static int diceSum() {
        int r1 = rand(6)+1;
        int r2 = rand(6)+1;
        return r1+r2;
    }

    public static void dragon(int N) {
        if (N == 1) {
            StdOut.print("F");
            return;
        }
        dragon(N-1);
        StdOut.print("L");
        nogard(N-1);
    }

    public static void nogard(int N) {
        if (N == 1) {
            StdOut.print("F");
            return;
        }
        nogard(N-1);
        StdOut.print("R");
        dragon(N-1);
    }

    public static int powerOf2(int N) {
        int v = 1;
        while (v <= N/2) v *= 2;
        return v;
    }

    public static int sum(int N) {
        int sum = 0;
        for (int i = 1; i<=N; i++) sum += i;
        return sum;
    }

    public static long factorial(int N) {
        long total = 1;
        for (int i = 1; i<=N; i++) total *= i;
        return total;
    }

    public static double harmonic(int N) {
        double sum = 0.0;
        for (int i = 1; i<=N; i++) sum += 1.0/i;
        return sum;
    }

    public static double sqrt(double c) {
        double t = c;
        while (Math.abs(t - c/t) > tol * t) {
            t = (c/t + t)/2.0;
        }
        return t;
    }

    private static String reverse(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i<a.length/2; i++) {
            exch(a, i, a.length-1-i);
        }
        return new String(a);
    }

    private static void exch(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static String decToBin(int N) {
        if (N < 0) throw new IllegalArgumentException("Integer must be positive");
        else if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int r = N%2;
            N /= 2;
            sb.append(r);
        }
        return reverse(sb.toString());
    }

    public static int binToDec(String bin) {
        int N = bin.length();
        int dec = 0;
        for (int i = 0; i<N; i++) {
            if (bin.charAt(i) != '0') dec += Math.pow(2, N-i-1);
        }
        return dec;
    }

    public static String binToDecString(int N) {
        String s = "";
        for (int n = N; n>0; n /= 2) {
            s = (n%2) + s;
        }
        return s;
    }

    public static boolean gamblerRuin(int stake, int goal) {
        int cash = stake;
        while (cash > 0 && cash < goal) {
            if (Math.random() < 0.5) cash--;
            else cash++;
        }
        if (cash == goal) return true;
        else return false;
    }

    public static void primeFactors(long N) {
        for (long i = 2; i*i <= N; i++) {
            while (N%i == 0) {
                StdOut.print(i +" ");
                N /= i;
            }
        }
        if (N > 1) StdOut.print(N);
        StdOut.println();
    }

    public static void quadratic(double a, double b, double c) {
        double disc = b*b - 4*a*c;
        if (disc < 0.0) {
            StdOut.println("The discriminant cannot be negative");
            return;
        }
        double r1  = (-b + Math.sqrt(disc))/(2*a);
        double r2 = (-b - Math.sqrt(disc))/(2*a);
        StdOut.println(r1 + " " + r2);
    }

    public static void printInt(int lo, int hi) {
        int j = 0;
        for (int i = lo; i<= hi; i++) {
            j++;
            StdOut.print(i + " ");
            if (j % 5 == 0) StdOut.println();
        }
        StdOut.println();
    }

    public static int fibonacci(int N) {
        int a = 0, b = 1;
        while (a <= N) {
            a = a+b;
            b = a-b;
        }
        return a;
    }

    public static int gcd(int a, int b) {
        if (a%b == 0) return b;
        return gcd(b, a%b);
    }

    public static void unitDisc() {
        double x, y;
        do {
            x = 2.0*Math.random() - 1.0;
            y = 2.0*Math.random() - 1.0;
        } while (x*x + y*y > 1.0);
        StdOut.println(x + " " + y);
    }

    public static void unitSphere() {
        double a, b;
        do {
            a = 2.0*Math.random() - 1.0;
            b = 2.0*Math.random() - 1.0;
        } while (a*a + b*b > 1.0);
        double x = 2*a*Math.sqrt(1 - a*a - b*b);
        double y = 2*b*Math.sqrt(1 - a*a - b*b);
        double z = 1 - 2*(a*a + b*b);
        StdOut.println(x + " " + y + " " + z);
    }

    public static int primeCount(int N) {
        int cnt = 0;
        for (int i = 2; i<=N; i++) {
            if (isPrime(i)) cnt++;
        }
        return cnt;
    }

    private static boolean isPrime(int N) {
        if (N < 2) return false;
        else if (N == 2 || N == 3) return true;
        for (int i = 2; i*i<=N; i++) {
            if (N%i == 0) return false;
        }
        return true;
    }

    public static double randomWalk(int N) {
        int moves = 0;
        final int T = 10000;
        for (int t = 0; t<T; t++) {
            int x = 0;
            int y = 0;
            while (Math.abs(x) < N && Math.abs(y) < N) {
                moves++;
                double r = Math.random();
                if (r < 0.25) x--;
                else if (r < 0.5) x++;
                else if (r < 0.75) y--;
                else y++;
            }
        }
        return ((double)moves)/T;
    }

    public static double pow(double x) {
        final int T = 1000;
        double sum = 0.0;
        for (int k = 0; k<T; k++) {
            double term = 1.0;
            for (int i = 1; i<k; i++) term *= (x/i);
            sum += term;
        }
        return sum;
    }

    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i<a.length; i++) {
            int r = i + (int)(Math.random()*(N-i));
            exch(a, i, r);
        }
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //N coupons, sample with replacement
    public static int collect(int N) {
        int cnt = N;
        int draws = 0;
        boolean[] coupons = new boolean[N];
        while (cnt > 0) {
            draws++;
            int r = (int)(Math.random()*N);
            if (!coupons[r]) {
                coupons[r] = true;
                cnt--;
            }
        }
        return draws;
    }

    public static int primeCounter(int N) {
        int cnt = 0;
        boolean[] prime = new boolean[N+1];
        for (int i = 2; i<=N; i++) prime[i] = true;
        for (int i = 2; i*i <+N; i++) {
            if (prime[i]) {
                for (int j = i; j*i <=N; j++) prime[i*j] = false;
            }
        }
        for (int i = 2; i<N+1; i++) if (prime[i]) cnt++;
        return cnt;
    }

    public static double[][] prod(double[][] a, double[][] b) {
        int N = a.length;
        int M = a[0].length;
        int P = b[0].length;
        assert(M == b.length);
        double[][] c = new double[N][P];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<P; j++) {
                c[i][j] = 0.0;
                for (int k = 0; i<M; i++) c[i][j] += a[i][k]*b[k][j];
            }
        }
        return c;
    }

    public static double avoidingRandWalk(int N, int T) {
        int deadEnd = 0;
        for (int t = 0; t<T; t++) {
            boolean[][] marked = new boolean[N][N];
            int x = N/2, y = N/2;
            while (true) {
                marked[x][y] = true;
                if (x <= 0) break;
                else if (y <= 0) break;
                else if (x >=N-1) break;
                else if (y >=N-1) break;
                else if (marked[x-1][y] && marked[x][y-1] && marked[x+1][y] && marked[x][y+1]) {
                    deadEnd++;
                    break;
                }
                double r = Math.random();
                if (r < 0.25 && !marked[x-1][y]) x--;
                else if (r < 0.5 && !marked[x+1][y]) x++;
                else if (r < 0.75 && !marked[x][y-1]) y--;
                else if (!marked[x][y+1]) y++;
            }
        }
        return deadEnd/(double)T;
    }

    public static double dist(double[] a, double[] b) {
        assert(a.length == b.length);
        double dist = 0.0;
        for (int i = 0; i<a.length; i++) {
            dist += ((a[i]*- b[i]) * (a[i] - b[i]));
        }
        return Math.sqrt(dist);
    }

    public static void deal(int N) {
        if (5*N > 52) throw new IndexOutOfBoundsException("Not enough cards in the deck");
        String[] deck = new String[52];
        int index = 0;
        for (int i = 0; i<suites.length; i++) {
            for (int j = 0; j<vals.length; j++) {
                deck[index++] = vals[j] + " of " + suites[i];
            }
        }
        shuffle(deck);
        index = 0;
        for (int i = 0; i<N; i++) {
            StdOut.println("\nHand " + (i+1));
            for (int j = 0; j<5; j++) StdOut.println(deck[index++]);
        }
    }

    public static void transpose(double[][] a) {
        int N = a.length;
        int M = a[0].length;
        for (int i = 0; i<N; i++) {
            for (int j = i; j<M; j++) {
                double t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    public static void printArray(double[][] a) {
        for (int i = 0; i<a.length; i++) {
            StdOut.println();
            for (int j = 0; j<a[0].length; j++) {
                StdOut.print(a[i][j] + " ");
            }
        }
        StdOut.println();
    }

    public static double[][] randDouble(int N, int M) {
        double[][] a = new double[N][M];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                a[i][j] = StdRandom.uniform();
            }
        }
        return a;
    }

    //Return the start index of the longest plateau in a
    public static int longestPlateau(int[] a) {
        int N = a.length;
        int index = 0;
        int j = 0;
        int max = 0;
        for (int i = 1; i<N-1; i++) {
            if (a[i-1] < a[i]) {
                while (i<N-1 && a[i] == a[i+1]) {
                    j++;
                    i++;
                }
                if (j > max && a[i+1] < a[i]) {
                    max = j;
                    index = i-j;
                }
                j = 0;
            }
        }
        return index;
    }

    private static int[] randInts(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(5);
        return a;
    }

    // Alice has N guests at a party
    // Bob starts a rumor about Alice, telling one guest
    // The rumor propogates
    // Each guest tells another guest except for himself or the person he heard it from
    // The rumor stops propogating if
    // 1. it is told to a guest who already heard it
    // 2. all guests have heard the rumor
    // Estimate how many guests will hear the rumor before it stops propogating
    public static double rumors(int N, int T) {
        int totalCnt = 0;
        for (int t = 0; t<T; t++) {
            boolean[] heard = new boolean[N];
            int cnt = 1;
            heard[0] = true;
            int prev = 0;
            int current = 0;
            do {
                current = StdRandom.uniform(N);
            } while (current == prev);
        
            while (cnt < N) {
                heard[current] = true;
                cnt++;
                int next = current;
                do {
                    next = StdRandom.uniform(N);
                } while (next == current);
                if (heard[next]) break;
                prev = current;
                current = next;
            }
            totalCnt += cnt;
        }
        return totalCnt/(double)T;
    }

    // T trials of the coupon collector problem
    public static double couponCollector(int N, int T) {
        int draws = 0;
        for (int t = 0; t<T; t++) {
            boolean[] marked = new boolean[N];
            int cnt = 0;
            while (cnt < N) {
                int r = StdRandom.uniform(N);
                draws++;
                if (!marked[r]) {
                    cnt++;
                    marked[r] = true;
                }
            }
        }
        return draws/(double)T;
    }
}
