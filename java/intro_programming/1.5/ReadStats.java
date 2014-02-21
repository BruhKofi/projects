public class ReadStats
{
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] lines = line.split("\\s+");
            String name = lines[0];
            int n = Integer.parseInt(lines[1]);
            int m = Integer.parseInt(lines[2]);
            StdOut.printf("%s\t%d\t%d\t%5.2f", name, n, m, ((double)(n)/m));
            StdOut.println();
        }
    }
}
