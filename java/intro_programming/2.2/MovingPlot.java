public class MovingPlot {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        boolean first = true;
        while (!StdIn.isEmpty()) {
            StdDraw.clear();
            if (first) {
                for (int i = 0; i<M; i++) {
                    StdDraw.
