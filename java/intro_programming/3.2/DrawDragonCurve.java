public class DrawDragonCurve
{
    public static void main(String[] args) {
        int N = StdIn.readInt();
        String curve = StdIn.readString();
        int steps = curve.length();
        int[] left  = { 0, 0, 0, 2, 4, 5, 5,  5,  5,  5, 10, 42, 74, 81,  85,  85 };
        int[] right = { 1, 1, 1, 1, 1, 1, 2, 10, 18, 21, 21, 21, 21, 21,  57, 170 };
        int[] up    = { 0, 1, 2, 2, 2, 2, 2,  2,  5, 21, 37, 42, 42, 42,  42,  42 };
        int[] down  = { 0, 0, 0, 0, 1, 5, 9, 10, 10, 10, 10, 10, 23, 85, 149, 165 };
        double size = Math.max(left[N] + right[N], up[N] + down[N]);
        double x = (right[N] - left[N]) / 2.0;
        double y = (up[N]    - down[N]) / 2.0;
        Turtle turtle = new Turtle(0.0, 0.0, 0.0);
        turtle.setXscale(x - size/2, x + size/2);
        turtle.setYscale(y - size/2, y + size/2);
        for (int i = 0; i<steps; i++) {
            if ('F' == curve.charAt(i)) {
                turtle.goForward(1.0);
            } else if ('L' == curve.charAt(i)) {
                turtle.turnLeft(90);
            } else if ('R' == curve.charAt(i)) {
                turtle.turnLeft(-90);

            }
        }
    }
}
