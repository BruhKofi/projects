public class Six
{
    public static void main(String[] args) {
        int sumSq = 0;
        int sqSum = 0;
        for (int i = 1; i<=100; i++) {
            sumSq += (i*i);
            sqSum += i;
        }
        sqSum *= sqSum;
        StdOut.println(sqSum - sumSq);
    }
}
        