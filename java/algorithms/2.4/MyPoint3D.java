public class MyPoint3D implements Comparable<MyPoint3D>
{
    private long x;
    private long y;
    private long z;

    public MyPoint3D(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
         return "(" + x + ", " + y + ", " + z + ")";
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getX() {
        return x;
    }
    
    public void setY(long y) {
        this.y = y;
    }

    public long getY() {
        return y;
    }
    
    public void setZ(long z) {
        this.z = z;
    }

    public int compareTo(MyPoint3D that) {
        if (z < that.z) return -1;
        else if (z > that.z) return +1;
        return 0;
    }

    public boolean equals(MyPoint3D that) {
        return z == that.z;
    }
}