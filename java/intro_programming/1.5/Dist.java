public class Dist
{
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);
        double minDist = Double.MAX_VALUE;
        while (!StdIn.isEmpty()) {
            int xi = StdIn.readInt();
            int yi = StdIn.readInt();
            int zi = StdIn.readInt();

            double distSquared = (x - xi)*(x - xi) + (y - yi)*(y - yi) + (z - zi)*(z - zi);

            if (distSquared < minDist) {
                minDist = distSquared;
            }
        }
        StdOut.println(minDist);
    }
}
