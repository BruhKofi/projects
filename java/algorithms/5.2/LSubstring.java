public class LSubstring
{
    public static void main(String[] args) {
        TST<Integer> tst = new TST<Integer>();
        int L = Integer.parseInt(args[0]);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (StdIn.hasNextChar()) {
            if (i < L-1) {
                sb.append(StdIn.readChar());
                i++;
            }
            String s = sb.toString();
            StdOut.println(s);
            if (!tst.contains(s)) tst.put(s, 1);
            else tst.put(s, tst.get(s)+1);
            if (i >= L-1) sb = new StringBuilder(s.substring(1, s.length()));
            sb.append(StdIn.readChar());
        }
        StdOut.println("The number of unique substrings of length " + L + " in StdIn is " + tst.size());
    }
}
