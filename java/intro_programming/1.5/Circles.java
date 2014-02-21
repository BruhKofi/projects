public class Circles
{
    public static void main(String[] args) {
        int c = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double radMin = Double.parseDouble(args[2]);
        double radMax = Double.parseDouble(args[3]);
        double r;
        double x = Math.random();
        double y = Math.random();
        
        for (int i = 0; i<c; i++) {
            r = Math.random();
            while (r < radMin || r > radMax) {
                r = Math.random();
            }
            if (Math.random() < p) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(x, y, r);
            } else {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledCircle(x, y, r);
            }
            x = Math.random();
            y = Math.random();
        }
    }
}
            
