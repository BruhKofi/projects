public class Ruler
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String ruler = " ";
        for (int i = 0; i<N; i++) {
            ruler = ruler + i + ruler;
        }
        System.out.println(ruler);
    }
}
