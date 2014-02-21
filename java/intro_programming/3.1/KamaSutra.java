public class KamaSutra
{
    public static void encode(String s1, String s2) {
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            StringBuffer code = new StringBuffer();
            for (int i = 0; i<input.length(); i++) {
                char c = input.charAt(i);
                int index1 = s1.indexOf(c);
                int index2 = s2.indexOf(c);
                if (index1 != -1) {
                    int index = s1.indexOf(c);
                    code.append(s2.charAt(index));
                } else if (index2 != -1) {
                    int index = s2.indexOf(c);
                    code.append(s1.charAt(index));
                } else {
                    break;
                }
            }
            StdOut.println(code);
        }
    }

    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        encode(s1, s2);
    }
}
