public class RelativelyPrime
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        for (int i = 1; i<=N; i++) {
            for (int j = 1; j<=N; j++) {
                int a = i;
                int b = j;
                while (b>0) {
                    int t = b;
                    b = a%t;
                    a = t;
                }
                if (a == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
                
