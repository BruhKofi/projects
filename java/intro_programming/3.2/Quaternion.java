public class Quaternion
{
    private final double a0;
    private final double a1;
    private final double a2;
    private final double a3;

    public Quaternion(double x0, double x1, double x2, double x3) {
        a0 = x0;
        a1 = x1;
        a2 = x2;
        a3 = x3;
    }

    public double magnitude() {
        return Math.sqrt(a0*a0 + a1*a1 + a2*a2 + a3*a3);
    }

    public Quaternion conjugate() {
        return new Quaternion(a0, -a1, -a2, -a3);
    }

    public Quaternion inverse() {
        double mag = magnitude();
        return new Quaternion(a0/mag, a1/mag, a2/mag, a3/mag);
    }

    public Quaternion sum(Quaternion other) {
        return new Quaternion(a0 + other.a0, a1 + other.a1, a2 + other.a2, a3 + other.a3);
    }

    public Quaternion product(Quaternion other) {
        return new Quaternion(a0*other.a0 - a1*other.a1 - a2*other.a2 - a3*other.a3, a0*other.a1 - a1*other.a0 + a2*other.a3 - a3*other.a2, a0*other.a2 - a1*other.a3 + a2*other.a0 + a3*other.a1, a0*other.a3 + a1*other.a2 - a2*other.a1 + a3*other.a0);
    }

    public Quaternion quotient(Quaternion other) {
        return this.product(other.inverse());
    }

    public String toString() {
        return "(" + a0 + ", " + a1 + ", " + a2 + ", " + a3 + ")";
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Quaternion[] q = new Quaternion[N];

        for (int i = 0; i<N; i++) {
            double a0 = StdIn.readDouble();
            double a1 = StdIn.readDouble();
            double a2 = StdIn.readDouble();
            double a3 = StdIn.readDouble();
            q[i] = new Quaternion(a0, a1, a2, a3);
        }

        for (int i = 0; i<N; i++) {
            StdOut.println(q[i] + " " + q[i].magnitude() + " " + q[i].conjugate());
        }

        for (int i = 0; i<N-1; i++) {
            StdOut.println(q[i].sum(q[i+1]) + " " + q[i].product(q[i+1]) + " " + q[i].quotient(q[i+1]));
        }
    }
}
