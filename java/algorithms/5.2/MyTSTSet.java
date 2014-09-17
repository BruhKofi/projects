public class MyTSTSet
{
    private Node root;
    private int N;

    private class Node
    {
        private Node left, mid, right;
        private char c;
    }

    public void add(String key) {
        if (!contains(key)) {
            N++;
            root = add(root, key, 0);
        }
    }

    private Node add(Node x, String key, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        else if (c < x.c) x.left = add(x.left, key, d);
        else if (c > x.c) x.right = add(x.right, key, d);
        else if (c == x.c) x.mid = add(x.mid, key, d+1);
        return x;
    }

    public void delete(String key) {
        if (!contains(key)) {
            N--;
            root = delete(root, key, 0);
        }
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == d+1) {
            if (x.mid == null && x.right == null && x.left == null) {
                return null;
            }
            
        char c = key.charAt(d);
        if (c < x.c) x.left = delete(x.left, key, d);
        else if (c > x.c) x.right = delete(x.right, key, d);
        else if (c == x.c) x.mid = delete(x.mid, key, d+1);
    }

    public boolean contains(String key) {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (isEmpty()) return 0;
        return root.N;
    }
}
    
