public class Rand
{
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        double r = Math.random();
        System.out.println((int)(r*(b-a)) + a);
    }
}
