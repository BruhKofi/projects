public class MyGraph
{
    private ST<String, SET<String>> st;
    private int edges;
    
    public MyGraph() {
        st = new ST<String, SET<String>>();
    }

    public MyGraph(In in, String delim) {
        st = new ST<String, SET<String>>();
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] names = line.split(delim);
            for (int i = 1; i<names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

    public MyGraph(MyGraph G) {
        st = new ST<String, SET<String>>();
        for (String v : G.vertices()) {
            for (String w : G.adjacentTo(v)) {
                addEdge(v, w);
            }
        }
    }

    public MyGraph subgraph(SET<String> vertices) {
        MyGraph subgraph = new MyGraph();
        for (String vertex : vertices) {
            for (String w : adjacentTo(vertex)) {
                if (vertices.contains(w)) subgraph.addEdge(vertex, w);
            }
        }
        return subgraph;
    }

    public void addEdge(String v, String w) {
        edges++;
        if (!st.contains(v)) st.put(v, new SET<String>());
        if (!st.contains(w)) st.put(w, new SET<String>());
        st.get(v).add(w);
        st.get(w).add(v);
    }

    public Iterable<String> adjacentTo(String v) {
        return st.get(v);
    }

    public Iterable<String> vertices() {
        return st.keys();
    }

    public int V() {
        return st.size();
    }

    public int E() {
        return edges;
    }

    public int degree(String v) {
        if (st.contains(v)) {
            return st.get(v).size();
        }
        else return 0;
    }

    public boolean hasVertex(String v) {
        if (st.contains(v)) return true;
        return false;
    }

    public boolean hasEdge(String v, String w) {
        if (st.contains(v) && st.get(v).contains(w)) return true;
        return false;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String delim = args[1];
        MyGraph G = new MyGraph(in, delim);
        int maxDegree = 0;
        String vertex = null;
        for (String v : G.vertices()) {
             if (G.degree(v) > maxDegree) {
                 maxDegree = G.degree(v);
                 vertex = v;
             }
        }
        StdOut.println(maxDegree + " " + vertex);


        
        // while (!StdIn.isEmpty()) G.addEdge(StdIn.readString(), StdIn.readString());
        // StdOut.println("vertices " + G.V() + " edges " + G.E());
        // for (String vertex : G.vertices()) {
        //     StdOut.print(vertex + ": ");
        //     for (String adj : G.adjacentTo(vertex)) {
        //         StdOut.print(adj + " ");
        //     }
        //     StdOut.println();
        // }
    }
}
