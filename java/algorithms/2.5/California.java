import java.util.Arrays;
public class California
{
    public static void main(String[] args) {
        String[] names = StdIn.readAll().split("\\s+");
        Arrays.sort(names, new CaliforniaCompare());
        for (String name : names) {
            StdOut.println(name);
        }
    }
}
