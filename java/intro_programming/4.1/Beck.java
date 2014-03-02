public class Beck
{
    public static String no2slash(char[] name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<name.length-1; i++) {
            if (name[i] == '/') {
                while (name[i+1] == '/' && i < name.length-2) {
                    i++;
                }
                sb.append('/');
            } else {
                sb.append(name[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/";
        char[] c = s.toCharArray();
        Stopwatch sw = new Stopwatch();
        String r = no2slash(c);
        double oldTime = sw.elapsedTime();
        for (int i = 0; i<100; i++) {
            s += s;
            c = s.toCharArray();
            sw = new Stopwatch();
            r = no2slash(c);
            double time = sw.elapsedTime();
            StdOut.println(s.length() + " " + time);
            oldTime = time;
        }
    }
}
