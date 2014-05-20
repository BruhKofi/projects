public class Cubes
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MinPQ<MyPoint3D> minPQ = new MinPQ<MyPoint3D>(N);
        SET<MyPoint3D> set = new SET<MyPoint3D>();
        for (int i = 0; i<N; i++) {
            int j = 0;
            MyPoint3D p = new MyPoint3D(i, j, i*i*i + j*j*j);
            minPQ.insert(p);
        }
        int j = 0;
        while (!minPQ.isEmpty() && j<N) {
            MyPoint3D d = minPQ.delMin();
            long i = d.getX();
            if (set.contains(d)) set.add(d);
            MyPoint3D p = new MyPoint3D(i, j++, i*i*i + j*j*j);
            minPQ.insert(p);
        }
        for (MyPoint3D p : set) {
            StdOut.println(p);
        }
    }
}
            