public class WhitespaceFilter
{
    public static void main(String[] args) {
        In input = new In(args[0]);
        Out output = new Out(args[1]);

        while (!input.isEmpty()) {
            String line = input.readLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            output.println(line);
        }
    }
}
