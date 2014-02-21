public class CubeSum
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 0; i<=N; i++) {
            for (int j = 0; j*j*j<i/2+1; j++) {
                for (int k = 0; k*k*k<i/2+1 && k != j; k++) {
                    for (int m = 0; m*m*m<i/2+1 && m != k && m != j; m++) {
                        for (int n = 0; n*n*n<i/2+1 && n != m && n != k && n != j; n++) {
                            System.out.println(i);
                            if (j*j*j + k*k*k == i) {
                                System.out.println(i + ": " + j + " " + k + " " + m + " " + n);
                            }
                        }
                    }
                }
            }
        }
    }
}
