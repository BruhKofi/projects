public class RandomWeb
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        
        StdOut.println(N);
        StdOut.println();

        for (int i = 0; i<M; i++) {
            if (i<5) {
                
            int n1 = (int)(Math.random()*N);
            int n2 = (int)(Math.random()*N);
            StdOut.println(n1 + " " + n2);
        }
    }
}
