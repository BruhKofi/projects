public class SymbolTableGraph
{
    private ST<String, Integer> map;
    private String[] keys;
    private MyGraph G;

    public SymbolTableGraph(int V) {
        G = new MyGraph(V);
        keys = new String[V];
        map = new ST<String, Integer>();
    }

    public SymbolTableGraph(String fileName, String delim) {
        map = new ST<String, Integer>();
        In in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            for (int i = 0; i<a.length; i++) {
                if (!map.contains(a[i])) {
                    map.put(a[i], map.size());//map each String vertex to an integer
                }
            }
        }
        //Construct a vertex-indexed array of strings using the map
        keys = new String[map.size()];
        for (String name : map.keys()) {
            keys[map.get(name)] = name;
        }

        G = new MyGraph(keys.length);
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            int v = map.get(a[0]);
            for (int i = 1; i<a.length; i++) {
                G.addEdge(v, map.get(a[i]));
            }
        }
    }

    //Does the graph contains vertex s
    public boolean contains(String s) {
        return map.get(s) != null;
    }

    //Returns integer associated with s
    //Throws NullPointerException if s in not mapped to an integer
    public int index(String s) {
        return map.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public MyGraph G() {
        return G;
    }

    public static void main(String[] args) {
        SymbolTableGraph stGraph = new SymbolTableGraph(args[0], args[1]);
        while (!StdIn.isEmpty()) {
            StdOut.println(stGraph.index(StdIn.readString()));
        }
    }
}
