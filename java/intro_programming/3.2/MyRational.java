public class MyRational
{
    private final int numerator;
    private final int denominator;

    public MyRational(int num, int denom) {
        numerator = num;
        denominator = denom;
    }

    public MyRational plus(MyRational b) {
        MyRational sum = new MyRational(numerator*b.denominator + b.numerator*denominator, denominator*b.denominator);
        int gcd = gcd(sum.numerator, sum.denominator);
        if (gcd == 1) return sum;
        return new MyRational(sum.numerator/gcd, sum.denominator/gcd);
    }

    public MyRational minus(MyRational b) {
        MyRational other = new MyRational(-b.numerator, b.denominator);
        return this.plus(other);
    }

    public MyRational times(MyRational b) {
        MyRational product = new MyRational(numerator*b.numerator, denominator*b.denominator);
        int gcd = gcd(product.numerator, product.denominator);
        if (gcd == 1) return product;
        return new MyRational(product.numerator/gcd, product.denominator/gcd);
        
    }

    public MyRational over(MyRational b) {
        MyRational quotient = new MyRational(b.denominator, b.numerator);
        return this.times(quotient);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MyRational[] rationals = new MyRational[N];
        int i = 0;
        while (!StdIn.isEmpty()) {
            int numerator = StdIn.readInt();
            int denominator = StdIn.readInt();
            rationals[i++] = new MyRational(numerator, denominator);
        }
        for (i = 1; i<N; i++) {
            StdOut.printf("%s plus %s = %s\n", rationals[0], rationals[i], rationals[0].plus(rationals[i]));
        }
        for (i = 1; i<N; i++) {
            StdOut.printf("%s minus %s = %s\n", rationals[0], rationals[i], rationals[0].minus(rationals[i]));
        }
        for (i = 1; i<N; i++) {
            StdOut.printf("%s times %s = %s\n", rationals[0], rationals[i], rationals[0].times(rationals[i]));
        }
        for (i = 1; i<N; i++) {
            StdOut.printf("%s over %s = %s\n", rationals[0], rationals[i], rationals[0].over(rationals[i]));
        }
    }
}
