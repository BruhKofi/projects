public class Vector2D
{
    private final double d1;
    private final double d2;

    public Vector2D(double m, double n) {
        d1 = m;
        d2 = n;
    }

    public Vector2D plus(Vector2D b) {
        return new Vector2D(d1 + b.d1, d2 + b.d2);
    }
    public Vector2D times(double t) {
        return new Vector2D(t*d1, t*d2);
    }

    public double dot(Vector2D b) {
        return d1*b.d1 + d2*b.d2;
    }

    public double magnitude(Vector2D b) {
        return Math.sqrt(dot(this));
    }

    public Vector2D direction() {
        return times(1.0/magnitude(this));
    }
}
        
