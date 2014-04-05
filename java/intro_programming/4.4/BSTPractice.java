public class BSTPractice
{
    private Node root;

    private class Node
    {
        final double d;
        Node left;
        Node right;

        Node(double d) { this.d = d; }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public boolean heapOrdered() {
        return heapOrdered(root);
    }

    private boolean heapOrdered(Node x) {
        if (x == null) return true;
        if (x.isLeaf()) return true;
        return x.d > max(x, Double.NEGATIVE_INFINITY);
    }

    private double max(Node x, double max) {
        if (x == null) return max;
        if (x.isLeaf()) return Math.max(x.d, max);
        if (x.d > max) max = x.d;
        return Math.max(max(x.left, max), max(x.right, max));
    }
        
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public void put(double d) {
        root = put(root, d);
    }

    private Node put(Node x, double d) {
        if (x == null) return new Node(d);
        if (d < x.d) x.left = put(x.left, d);
        if (d > x.d) x.right = put(x.right, d);
        return x;
    }


    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        if (x.isLeaf()) return 1;
        return 1 + size(x.left) + size(x.right);
    }

    public int leaves() {
        return leaves(root);
    }

    private int leaves(Node x) {
        if (x == null) return 0;
        if (x.isLeaf()) return 1;
        return leaves(x.left) + leaves(x.right);
    }

    public double total() {
        return total(root);
    }

    private double total(Node x) {
        if (x == null) return 0;
        if (x.isLeaf()) return x.d;
        return x.d + total(x.left) + total(x.right);
    }

    public static void main(String[] args) {
        BSTPractice st = new BSTPractice();
        while (!StdIn.isEmpty()) {
            double d = StdIn.readDouble();
            st.put(d);
        }
        StdOut.println("size: " + st.size() + "\nleaves: " + st.leaves() + "\ntotal: " + st.total() +"\nheap ordered: " + st.heapOrdered());
         // Stopwatch sw = new Stopwatch();
         // for (int i = 100; true; i*=2) {
         //     BSTPractice st = new BSTPractice();
         //     for (int j = 0; j<i; j++) {
         //         st.put(StdRandom.uniform());
         //     }
         //     sw = new Stopwatch();
         //     int n = st.size();
         //     StdOut.println(i + ": " + sw.elapsedTime());
         //     sw = new Stopwatch();
         //     n = st.leaves();
         //     StdOut.println(i + ": " + sw.elapsedTime());
         //     sw = new Stopwatch();
         //     double d = st.total();
         //     StdOut.println(i + ": " + sw.elapsedTime());
         //     sw = new Stopwatch();
         //     n = st.height();
         //     StdOut.println(i + ": " + sw.elapsedTime());
         // }
    }
}
