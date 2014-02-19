public class Rectangle
{
    private final double x;
    private final double y;

    private final double width;
    private final double height;

    public Rectangle(double x0, double y0, double w, double h) {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }

    public double area() {
        return width*height;
    }

    public double perimeter() {
        return 2.0*(width + height);
    }

    public boolean intersects(Rectangle b) {
        Interval x1 = new Interval(x - width/2, x + width/2);
        Interval y1 = new Interval(y - height/2, y + height/2);
        Interval bx = new Interval(b.x - b.width/2, b.x + b.width/2);
        Interval by = new Interval(b.y - b.height/2, b.y + b.height/2);
        return x1.intersects(bx) && y1.intersects(by);
    }

    public boolean contains(Rectangle b) {
        if (!this.intersects(b)) return false;
        Interval x1 = new Interval(x - width/2, x + width/2);
        Interval y1 = new Interval(y - height/2, y + height/2);
        return x1.contains(b.x - b.width/2) && x1.contains(b.x + b.width/2) && y1.contains(b.y - b.height/2) && y1.contains(b.y + b.height/2);
    }
}
