public class Harmonic
{

    public static final double gamma = 0.5772156649;
    
    public static double Hsmall(int N) {
        double sum = 0.0;
        for (int i = 0; i<N; i++) {
            sum += 1.0/(i+1);
        }
        return sum;
    }

    public static double Hlarge(int N) {
        return Math.log(N) + gamma + 1.0/(2.0*N) - 1.0/(12.0*N*N) + 1.0/(120.0*N*N*N*N);
    }

    public static double H(int N) {
        return N < 100 ? Hsmall(N) : Hlarge(N);
    }

    public static double recursiveH(int N) {
        if (N == 1) return 1.0;
        return recursiveH(N-1) + 1.0/N;
    }
    
}
        
