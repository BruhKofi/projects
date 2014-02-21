public class GraphProcessing
{
    public static void main(String[] args) {
        In in = new In("medium.txt");
        Out out = new Out("medium_from_23.txt");

        int N = in.readInt();

        while (!in.isEmpty()) {
            String line = in.readLine();
            StdOut.println(line);
            if (line != null && line.length() >= 2 && "23".equals(line.substring(0, 2))) {
                for (int i = 0; i<N; i++) {
                    out.print(23 + " " + i + "   ");
                }
                out.println();
            } else {
                out.println(line);
            }
        }
        out.close();
    }
}
