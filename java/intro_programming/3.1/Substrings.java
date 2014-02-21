public class Substrings
{
    public static void main(String[] args) {
        String start = args[0];
        String end = args[1];
        int startLength = start.length();
        int endLength = end.length();
        
        String data = StdIn.readAll();
        int beg = -1;
        for (int i = 0; i<data.length() - startLength + 1; i++) {
            String startCode = data.substring(i, i+startLength);

            String endCode = data.substring(i, i+endLength);

            if (startCode.equals(start)) beg = i;

            if (endCode.equals(end) && beg != -1 && beg + startLength < i) {
                String output = data.substring(beg + startLength, i);
                beg = -1;
                StdOut.println(output);
            }
        }
    }
}
