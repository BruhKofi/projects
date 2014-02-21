public class FourCharges
{
    public static void main(String[] args) {
        double w = Double.parseDouble(args[0]);

        Charge c1 = new Charge(0.5 - w, 0.5, 1.0);
        Charge c2 = new Charge(0.5 + w, 0.5, 1.0);
        Charge c3 = new Charge(0.5, 0.5 - 1, 1.0);
        Charge c4 = new Charge(0.5, 0.5 + w, 1.0);

        double potential = c1.potentialAt(0.25, 0.5) + c2.potentialAt(0.25, 0.5) + c3.potentialAt(0.25, 0.5) + c4.potentialAt(0.25, 0.5);
        StdOut.println(potential);
    }
}
