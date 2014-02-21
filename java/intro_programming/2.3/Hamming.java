public class Hamming
{

    public static void comb(String s, int k) {
        comb(s, "", k);
    }

    public static void comb(String s, String prefix, int k) {
        if (s.length() < k) {
            return;
        } else if (k == 0) {
            StdOut.println(s);
        } else {
            comb(s.substring(1), prefix + s.charAt(0), k-1);
            comb(s.substring(1), prefix, k);
        }
    }
            
    public static void hamming(String s, int k) {
        int N = s.length();
        if (s.length() == 0) {
            return;
        }
        int flips = 0;
        boolean[] b = new boolean[s.length()];
        for (int i = 0; i<s.length(); i++) {
            while (flips < k) {
                b[i] = (s.charAt(i) == '0' ? false : true);
                continue;
            }
            b[i] = (s.charAt(i) == '0' ? true : false);
        }
        String t = "";
        for (int i = 0; i<b.length; i++) {
            t += b[i];
        }
        comb(t, t.length());
    }

    public static void main(String[] args) {
        String s = args[0];
        hamming(s, 2);
    }
}

        
