public class LoanTable
{
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        int P = Integer.parseInt(args[1]);
        double r = Double.parseDouble(args[2]);

        int months = t*12;
        double total = P*Math.exp(r*t);
        StdOut.println(total/months);
    }
}
