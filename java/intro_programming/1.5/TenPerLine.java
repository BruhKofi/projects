public class TenPerLine
{
    public static void main(String[] args) {
        int i = 0;
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            StdOut.print(a + "\t");
            i++;
            if (i%10 == 0) {
                StdOut.println();
            }
        }
        StdOut.println();
    }
}
