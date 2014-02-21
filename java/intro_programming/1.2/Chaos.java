public class Chaos
{
    public static void main(String[] args) {
        double pop = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);

        for (int i = 0; i<1000; i++) {
            pop = r*pop*(1-pop);
            System.out.println(pop + " " + (1.0-1.0/r));
            
        }
    }
}
