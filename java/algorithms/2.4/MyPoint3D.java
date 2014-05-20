public class MyPoint3D implements Comparable<MyPoint3D>
{
    private int x;
    private int y;
    private int z;

    public MyPoint3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
         return "(" + x + ", " + y + ", " + z + ")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
    
    public void setZ(int z) {
        this.z = z;
    }

    public int compareTo(MyPoint3D that) {
        if (z < that.z) return -1;
        else if (z > that.z) return +1;
        return 0;
    }
}