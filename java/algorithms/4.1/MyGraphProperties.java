import java.util.InputMismatchException;
public class MyGraphProperties
{
    private int[] eccentricity;
    MyConnectedComponents cc;
    private int diameter;
    private int radius;
    private int center;
    private int wienerIndex;

    public MyGraphProperties(MyGraph G) {
        cc = new MyConnectedComponents(G);
        if (cc.count() != 1) throw new InputMismatchException("Graph must be connected");
        eccentricity = new int[G.V()];
        eccentricities(G);
        findDiameter();
        findRadius();
        findCenter();
    }

    private void eccentricities(MyGraph G) {
        for (int v = 0; v<G.V(); v++) {
            MyBreadthFirstPaths bfs = new MyBreadthFirstPaths(G, v);
            int eccen = Integer.MIN_VALUE;
            for (int w = 0; w<G.V(); w++) {
                wienerIndex += bfs.distTo(w);
                if (bfs.distTo(w) > eccen) eccen = bfs.distTo(w);
            }
            eccentricity[v] = eccen;
        }
        wienerIndex /= 2;
    }

    private void findDiameter() {
        diameter = StdStats.max(eccentricity);
    }

    private void findRadius() {
        radius = StdStats.min(eccentricity);
    }

    private void findCenter() {
        for (int i = 0; i<eccentricity.length; i++) {
            if (eccentricity[i] == radius) {
                center = i;
                return;
            }
        }
        center = -1;
    }

    public int radius() {
        return radius;
    }

    public int diameter() {
        return diameter;
    }

    public int center() {
        return center;
    }

    public int wiener() {
        return wienerIndex;
    }

    public int components() {
        return cc.count();
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyGraphProperties gp = new MyGraphProperties(G);
        StdOut.println("Diameter: " + gp.diameter());
        StdOut.println("Radius: " + gp.radius());
        StdOut.println("Center: " + gp.center());
        StdOut.println("Wiener Index: " + gp.wiener());
    }
}
    
