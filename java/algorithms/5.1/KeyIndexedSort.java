public class KeyIndexedSort
{
    public static void sort(String[] a) {
        int N = a.length;

        //Frequency count
        ST<String, Integer> st = new ST<String, Integer>();
        for (String s : a) {
            if (!st.contains(s)) st.put(s, 1);
            else st.put(s, st.get(s) +1);
        }

        //Transform counts to indices and copy back to st
        int[] index = new int[st.size() + 1];
        int k = 0;
        for (String key : st.keys()) {
            index[k+1] = index[k++] + st.get(key);
        }
        k = 0;
        for (String key: st.keys()) {
            st.put(key, index[k++]);
        }

        //Copy sorted array to aux
        String[] aux = new String[N];
        for (int i = 0; i<N; i++) {
            aux[st.get(a[i])] = a[i];
            st.put(a[i], st.get(a[i]) +1);
        }

        //Copy back to a
        for (int i = 0; i<N; i++) a[i] = aux[i];
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        sort(a);
        for (String s : a) StdOut.println(s);
    }
}
