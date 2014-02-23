import java.util.Arrays;

public class MyVector implements Comparable<MyVector>
{
    private final double[] coords;

    public MyVector(double[] a) {
        int N = a.length;
        coords = new double[N];
        for (int i = 0; i<N; i++) {
            coords[i] = a[i];
        }
    }

    public MyVector plus(MyVector b) {
        double[] c = new double[coords.length];
        for (int i = 0; i<coords.length; i++) {
            c[i] = coords[i]+b.coords[i];
        }
        return new MyVector(c);
    }

    public MyVector times(double t) {
        double[] c = new double[coords.length];
        for (int i = 0; i<coords.length; i++) {
            c[i] = coords[i] * t;
        }
        return new MyVector(c);
    }

    public double dot(MyVector b) {
        double sum = 0.0;
        for (int i = 0; i<coords.length; i++) {
            sum += coords[i] * b.coords[i];
        }
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(dot(this));
    }

    public MyVector direction() {
        return times(1.0/magnitude());
    }

    public double cartesian(int i) {
        return coords[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i<coords.length; i++) {
            sb.append(coords[i] + ", ");
        }
        return sb.substring(0, sb.length() - 2) + ")";
    }

    public int compareTo(MyVector other) {
        if (magnitude() > other.magnitude()) return 1;
        else if (magnitude() < other.magnitude()) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int M = StdIn.readInt();
        MyVector[] vectors = new MyVector[N];
        for (int i = 0; i<N; i++) {
            double[] a = new double[M];
            for (int j = 0; j<M; j++) {
                a[j] = StdIn.readDouble();
            }
            vectors[i] = new MyVector(a);
        }
        Arrays.sort(vectors);
        for (MyVector vector : vectors) {
            StdOut.println(vector);
        }
    }
}
        
