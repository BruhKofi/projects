public class Eight
{
    public static int[] parseNumber(String s) {
        int N = s.length();
        int[] num = new int[N];
        for (int i = 0; i<N; i++) {
            num[i] = Character.getNumericValue(s.charAt(i));
        }
        return num;
    }

    public static void main(String[] args) {
        String s = StdIn.readAll();
        int[] n = parseNumber(s);
        int max = 0;
        for (int i = 0; i<n.length-13; i++) {
            int prod = prod(n, i, i+13);
            if (prod > max) max = prod;
        }
        StdOut.println(max);
        
    }

    private static int prod(int[] a, int k, int j) {
        int prod = 1;
        int m = 0;
        for (int i = k; i<j; i++) {
            prod *= a[i];
            m++;
        }
        StdOut.println(m);
        return prod;
    }
}