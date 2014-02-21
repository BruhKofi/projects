public class Dice
{
    public static void main(String[] args) {
        int[] bins = new int[12];
        for (int i = 0; i<1000; i++) {
            int r1 = (int)(Math.random()*6) + 1;
            int r2 = (int)(Math.random()*6) + 1;
            bins[r1+r2-1]++;
        }
        for (int i = 0; i<12; i++) {
            System.out.print((double)bins[i]/1000 + " " );
            System.out.println();
        }
    }
}
