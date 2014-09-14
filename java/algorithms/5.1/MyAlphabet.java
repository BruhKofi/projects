public class MyAlphabet
{
    public static final MyAlphabet BINARY = new MyAlphabet("01");
    public static final MyAlphabet OCTAL = new MyAlphabet("01234567");
    public static final MyAlphabet DECIMAL = new MyAlphabet("0123456789");
    public static final MyAlphabet HEXIDECIMAL = new MyAlphabet("0123456789ABCDEF");
    public static final MyAlphabet LOWERCASE = new MyAlphabet("abcdefghijklmnopqrstuvwxyz");
    public static final MyAlphabet UPPERCASE = new MyAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    public static final MyAlphabet DNA = new MyAlphabet("ACTG");
    public static final MyAlphabet BASE64 = new MyAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXZYabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final MyAlphabet ASCII = new MyAlphabet(128);
    public static final MyAlphabet EXTENDED_ASCII = new MyAlphabet(256);
    public static final MyAlphabet UNICODE = new MyAlphabet(65536);
    
    private char[] alphabet;
    private int[] inverse;
    private final int R;

    
    
    public MyAlphabet(String s) {
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (unicode[c]) throw new IllegalArgumentException("Alphabet contains repeated character " + c);
            unicode[c] = true;
        }
        alphabet = s.toCharArray();
        R = alphabet.length;
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i<inverse.length; i++) inverse[i] = -1;

        for (int c = 0; c<R; c++) inverse[alphabet[c]] = c;
    }

    private MyAlphabet(int R) {
        this.R = R;
        alphabet = new char[R];
        inverse = new int[R];
        for (int i = 0; i<R; i++) {
            alphabet[i] = (char) i;
            inverse[i] = i;
        }
    }

    public MyAlphabet() {
        this(256);
    }


    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    public char toChar(int index) {
        if (index < 0 || index >= R) throw new IndexOutOfBoundsException("Index must be between 0 and " + (R-1));
        return alphabet[index];
    }

    public int toIndex(char c) {
        if (c < 0 || c >= inverse.length || inverse[c] == -1) throw new IllegalArgumentException("Character " + c + " not in alphabet");
        return inverse[c];
    }

    public int R() {
        return R;
    }

    public int lgR() {
        int l = 0;
        for (int k = R-1; k>=1; k /= 2) l++;
        return l;
    }

    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] indices = new int[s.length()];
        for (int i = 0; i<s.length(); i++) indices[i] = toIndex(source[i]);
        return indices;
    }

    public String toChars(int[] indices) {
        StringBuilder sb = new StringBuilder(indices.length);
        for (int i = 0; i<indices.length; i++) {
            sb.append(toChar(indices[i]));
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String s = args[0];
        MyAlphabet a = new MyAlphabet(s);
        StdOut.println("R: " + a.R());
        StdOut.println("lgR: " + a.lgR());
        StdOut.println(a.toChar(5));
        StdOut.println(a.toIndex('a'));
        int[] indices = a.toIndices("hello");
        for (int i = 0; i<indices.length; i++) StdOut.print(indices[i]);
        StdOut.println();
        StdOut.println(a.toChars(indices));
    }
}
