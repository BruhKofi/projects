public class Voter
{
    public static int vote(double[] a) {
        int n = StdRandom.discrete(a);
        if (StdRandom.uniform() < 0.05) {
            int temp = StdRandom.uniform(a.length);
            while (temp == n) {
                temp = StdRandom.uniform(a.length);
            }
            n = temp;
            
        }
        return n;
    }

    public static double[] normalize(int[] a) {
        int sum = 0;
        for (int i = 0; i<a.length; i++) {
            sum += a[i];
        }
        double[] arr = new double[a.length];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = (double) a[i] / sum;
        }
        return arr;
    }

    public static void main(String[] args) {
        int pop = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        double[] candidates = new double[N];

        for (int i = 0; i<N; i++) {
            candidates[i] = StdIn.readDouble();
        }
        int[] votes = new int[N];
        
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<pop; i++) {
                int n = vote(candidates);
                votes[n]++;
            }
        }
        double[] norm = normalize(votes);
        for (int i = 0; i<norm.length; i++) {
            StdOut.println(norm[i]);
        }
        StdStats.plotBars(norm);
    }
}
