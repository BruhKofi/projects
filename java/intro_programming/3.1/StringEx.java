public class StringEx
{
    public static boolean isValidDNA(String s) {
        for (int i = 0; i<s.length(); i++) {
            if (!(s.charAt(i) == 'A' || s.charAt(i) == 'T' || s.charAt(i) == 'C' || s.charAt(i) == 'G')) {
                return false;
            }
        }
        return true;
    }

    public static String complementWC(String s) {
        StringBuilder sb = new StringBuilder();
        if (isValidDNA(s)) {
            for (int i = 0; i<s.length(); i++) {
                if (s.charAt(i) == 'A') sb.append('T');
                if (s.charAt(i) == 'T') sb.append('A');
                if (s.charAt(i) == 'C') sb.append('G');
                if (s.charAt(i) == 'G') sb.append('C');
            }
        }
        return sb.toString();
    }

    public static String reverse(String c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<c.length(); i++) {
            sb.append(c.charAt(c.length() - 1 - i));
        }
        return sb.toString();
    }

    public static boolean palindromeWC(String s) {
        String c = complementWC(s);
        String rev = reverse(c);
        return s.equals(rev);
    }

    public static boolean isISBN(String s) {
        String[] tokens = s.split("-");
        StringBuilder ISBN = new StringBuilder();
        for (String token : tokens) {
            ISBN.append(token);
        }
        int isbn = Integer.parseInt(ISBN.toString());
        int sum = 0;
        int div = 1000000000;
        for (int i = 0; i<10; i++) {
            int d = isbn / div;
            sum += (10 - i) * d;
            isbn = isbn % div;
            div /= 10;
        }
        if (sum %11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean circularShift(String s, String t) {
        return s.length() == t.length() && (s + s).indexOf(t) != -1;
    }

    public static String domain(String site) {
        String[] tokens = site.split("\\.");
        for (int i = 1; i<tokens.length; i++) {
            if (tokens[i].contains("/")) {
                String token = tokens[i];
                String[] split = token.split("/");
                return split[0];
            }
        }
        return tokens[tokens.length-1];
    }

    public static String reverseDomain(String domain) {
        String[] tokens = domain.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<tokens.length; i++) {
            sb.append(tokens[tokens.length - 1 - i]);
            sb.append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        StdOut.println(mystery(args[0]));
    }
}
