/*************************************************************************
 *  Compilation:  javac KochRainbow.java
 *  Execution:    java KochRainbow N
 *  Dependencies: StdDraw.java
 *  
 *  Plot an order N Koch snowflake, using the spectrum of colors.
 *
 *  % java Koch 5
 *
 *************************************************************************/

import java.awt.Color;

public class KochRainbow {
    private Turtle turtle;      // for turtle graphics
    private double size;        // size of each line segment
    private double color;       // current color
    private double increment;   // change in color

    public KochRainbow(int N) {
        int width = 512;
        int height = (int) (2 * width / Math.sqrt(3));
        size = width / Math.pow(3.0, N);
        turtle = new Turtle(0, width * Math.sqrt(3) / 2, 0.0);
        turtle.setCanvasSize(width, height);
        turtle.setXscale(0, width);
        turtle.setYscale(0, height);
        
        // rainbow of colors
        color = 0.0;
        increment = Math.pow(4.0, -N) / 3.0;


        // three Koch curves in the shape of an equilateral triangle
        antiKoch(N);
        turtle.turnLeft(-120);
        antiKoch(N);
        turtle.turnLeft(-120);
        antiKoch(N);
    }



    public void koch(int n) {
        if (n == 0) {
            turtle.setPenColor(Color.getHSBColor((float) color, 1.0f, 1.0f));
            color += increment;
            turtle.goForward(size);
        }
        else {
            koch(n-1);
            turtle.turnLeft(60);
            koch(n-1);
            turtle.turnLeft(-120);
            koch(n-1);
            turtle.turnLeft(60);
            koch(n-1);
        }
    }

    public void antiKoch(int n) {
        if (n == 0) {
            turtle.setPenColor(Color.getHSBColor((float) color, 1.0f, 1.0f));
            color += increment;
            turtle.goForward(size);
        }
        else {
            koch(n-1);
            turtle.turnLeft(-60);
            koch(n-1);
            turtle.turnLeft(120);
            koch(n-1);
            turtle.turnLeft(-60);
            koch(n-1);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        new KochRainbow(N);
    }
}
