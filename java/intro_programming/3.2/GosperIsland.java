import java.awt.Color;

public class GosperIsland {
    private Turtle turtle;      // for turtle graphics
    private double size;        // size of each line segment
    private double color;       // current color
    private double increment;   // change in color

    public GosperIsland(int N) {
        int width = 512;
        int height = (int) (2 * width / Math.sqrt(3));
        size = width / Math.pow(3.0, N);
        turtle = new Turtle(0, 0, 0.0);
        turtle.setCanvasSize(width, height);
        turtle.setXscale(-512, 512);
        turtle.setYscale(-512, 512);
        
        // rainbow of colors
        color = 0.0;
        increment = Math.pow(4.0, -N) / 3.0;


        // three Gosper curves in the shape of an equilateral triangle
        turtle.turnLeft(60);
        gosper(N);
        turtle.turnLeft(60);
        gosper(N);
        turtle.turnLeft(60);
        gosper(N);
        turtle.turnLeft(60);
        gosper(N);
        turtle.turnLeft(60);
        gosper(N);
        turtle.turnLeft(60);
        gosper(N);
    }



    public void gosper(int n) {
        if (n == 0) {
            turtle.setPenColor(Color.getHSBColor((float) color, 1.0f, 1.0f));
            color += increment;
            turtle.goForward(size);
        }
        else {
            gosper(n-1);
            turtle.turnLeft(60);
            gosper(n-1);
            turtle.turnLeft(-120);
            gosper(n-1);
            turtle.turnLeft(60);
            gosper(n-1);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        new GosperIsland(N);
    }
}
