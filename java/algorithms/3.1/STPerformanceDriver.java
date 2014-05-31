public class STPerformanceDriver
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        for (int t = 0; t<T; t++) {
            for (int i = 0; i<N; i++) {
                String r = rand();
                if (!st.contains(r)) st.put(r, 1);
                else st.put(r, st.get(r) + 1);
            }
        }
    }

    private static String rand() {
        StringBuilder sb = new StringBuilder();
        int r = StdRandom.uniform(50);
        for (int k = 0; k<r; k++) {
            char c = (char)(StdRandom.uniform(26) + 'a');
            sb.append(String.valueOf(c));
        }
        return sb.toString();
    }
}
        
