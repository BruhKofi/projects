public class Banner
{
    public static void main(String[] args) {
        String s = args[0];
        int t = Integer.parseInt(args[1]);
        double y = 0.5;
        double x = 1.0;
        double deltax = 0.01;

        while (true) {
            StdDraw.clear();
            StdDraw.textLeft(x, y, s);
            StdDraw.show(t);
            x -= deltax;
            if (x < -0.5) {
                x = 1.0;
            }
        }
    }
}
            
