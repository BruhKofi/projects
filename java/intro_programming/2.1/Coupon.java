public class Coupon
{
    public static int uniform(int N) {
        return (int)(Math.random()*N);
    }

    public static int next(int N, int rare) {
        double r = Math.random();
        if (r < N/1000000.0) {
            return rare;
        } else {
            int next = uniform(N);
            while (next == rare) {
                next = uniform(N);
            }
            return next;
        }
    }

    public static int collect(int N, int rare) {
        boolean[] found = new boolean[N];
        int cardcnt = 0;
        int valcnt = 0;
        while (valcnt<N) {
            int n = next(N, rare);
            if (!found[n]) {
                found[n] = true;
                valcnt++;
            }
            cardcnt++;
        }
        return cardcnt;
    }

    public static int binomialNumber(int N) {
        double r = Math.random();
        double sum = 0.0;
        int k = 0;
        while (sum < r) {
            sum += binomial(N, k++, 0.5);
        }
        return k-1;
    }

    public static double binomial(int N, int k, double p) {
        double sum = Math.log(Math.pow(p, k)*Math.pow(1-p, N-k));
        for (int i = 1; i<=N; i++) {
            sum += Math.log(i);
        }
        for (int i = 1; i<=k; i++) {
            sum -= Math.log(i);
        }
        for (int i = 1; i<=N-k; i++) {
            sum -= Math.log(i);
        }
        return Math.exp(sum);
    }
    
    public static int collectBinomial(int N) {
        boolean[] found = new boolean[N];
        int cardcnt = 0;
        int valcnt = 0;
        while (valcnt < N) {
            cardcnt++;
            int r = binomialNumber(N);
            StdOut.println(r);
            if (!found[r]) {
                valcnt++;
                found[r] = true;
            }
        }
        return cardcnt;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int rare = Integer.parseInt(args[1]);
        int sum = 0;
        for (int i = 0; i<1000; i++) {
            sum += collectBinomial(N);
        }
        
        StdOut.println(((double)(sum))/1000);
    }
}
