public class Majority
{
    public static String majority(String[] s) {
        int N = s.length;
        int index = 0;
        int count = 1;
        for (int i = 1; i<N; i++) {
            if (s[i].equals(s[index])) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                index = i;
                count = 1;
            }
        }
        String candidate = s[index];
        int total = 0;
        for (int i = 0; i<N; i++) {
            if (s[i].equals(candidate)) {
                total++;
            }
        }
        if (total > N/2) {
            return candidate;
        } else {
            return new String();
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] s = new String[N];
        for (int i = 0; i<N; i++) {
            s[i] = StdIn.readString();
        }
         StdOut.println(majority(s));
    }
}
