public class Binomial {
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

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        for (int k = 0; k<=N; k++) {
            StdOut.println(binomial(N, k, p));
        }
    }
}
        
