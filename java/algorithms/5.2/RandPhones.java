import java.lang.NumberFormatException;
public class RandPhones
{
    private static final String AREA_CODE_FILE = "phone-na.csv";

    private static String rand(int k) {
        StringBuilder sb = new StringBuilder(k);
        for (int i = 0; i<k; i++) sb.append(StdRandom.uniform(10));
        return sb.toString();
    }

    private static boolean isInteger(String s) {
        if (s == null) return false;
        int N = s.length();
        if (N == 0) return false;
        char c = s.charAt(0);
        if (N == 1 && !Character.isDigit(c)) return false;
        if (!(Character.isDigit(c) || c == '-')) return false;
        for (int i = 1; i<N; i++) if (!Character.isDigit(s.charAt(i))) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MyTrie<Integer> trie = new MyTrie<Integer>();
        In in = new In(AREA_CODE_FILE);
        RandBag<String> areaCodes = new RandBag<String>();
        while (in.hasNextLine()) {
            String[] line = in.readLine().split(",");
            if (isInteger(line[0])) areaCodes.add(line[0]);
        }
        
        int i = 0;
        do {
            String code = areaCodes.peek();
            String p1 = rand(3);
            String p2 = rand(4);
            String s = code + p1 + p2;
            if (trie.contains(s)) continue;
            else {
                trie.put(s, 1);
                StdOut.println("("+code+")"+p1+"-"+p2);
                i++;
            }
        } while (i < N);
    }
}
