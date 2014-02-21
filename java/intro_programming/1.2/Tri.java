public class Tri
{
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if (a + b <= c) {
            System.out.println(true);
        } else if (a + c <= b) {
            System.out.println(true);
        } else if (b + c <= a) {
            System.out.println(false);
        } else {
            System.out.println(false);
        }
    }
}
