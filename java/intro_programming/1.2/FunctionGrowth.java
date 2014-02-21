public class FunctionGrowth
{
    public static void main(String[] args) {
        for (int N = 16; N<=2048; N*=2) {
            System.out.println(Math.log(N) + "\t" + N + "\t" + N*Math.log(N) + "\t" + N*N + "\t" + N*N*N + "\t\t" + Math.pow(2,N));
        }
    }
}
