public class PostalCode
{
    public static void half(double x) {
        StdDraw.setPenRadius(0.01);
        StdDraw.line(x, 0.0, x, 0.5);
    }

    public static void full(double x) {
        StdDraw.setPenRadius(0.01);
        StdDraw.line(x, 0.0, x, 1.0);
    }

    public static void drawDigit(int d) {
        if (d>10) {
            return;
        }
        if (d == 0) {
            full(0.0);
            full(0.2);
            half(0.4);
            half(0.6);
            half(0.8);
        } else if (d == 1) {
            half(0.0);
            half(0.2);
            half(0.4);
            full(0.6);
            full(0.8);
        } else if (d == 2) {
            half(0.0);
            half(0.2);
            full(0.4);
            half(0.6);
            full(0.8);
        } else if (d == 3) {
            
            

    public static void code(int d) {
        String s = d.toString();
        char[] chars = new char[s.length()];
        for (int i = 0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        
