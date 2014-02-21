public class BinomialCoeff
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        double[][] bin = new double[N][0];
        bin[0][0] = 1.0;
        for (int i = 1; i<N; i++) {
            bin[i] = new double[i+1];
            for (int k = 0; k<i; k++) {
                bin[i][k] = (bin[i-1][k] + bin[i-1][k-1])/2;
            }
            for (int k = 0; k<i; k++) {
                bin[i][k] /= (double)(i+1);
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<bin[i].length; j++) {
                System.out.print(bin[i][j] + " ");
            }
            System.out.println();
        }
    }
}
