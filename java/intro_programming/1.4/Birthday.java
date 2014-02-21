public class Birthday
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int p = 0;
        for (int i = 0; i<N; i++) {
            boolean[] days = new boolean[365];
            while (true) {
                p++;
                int n = (int)(Math.random()*days.length);
                if (!days[n]) {
                    days[n] = true;
                } else {
                    break;
                }
            }
        }
        System.out.println((double)p/N);
    }
}
