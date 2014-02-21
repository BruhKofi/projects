public class Sample
{
    public static void main(String[] args) {
        String fileName = args[0];
        double r = Double.parseDouble(args[1]);
        double[] b;
        double[] a = StdAudio.read(fileName);
        if (r < 1) {
            b = new double[(int)(r*a.length)];
            for (int i = 0; i<b.length; i++) {
                b[i] = a[(int)(1.0/r * i)];
            }
        } else if (r > 1) {
            b = new double[(int)(r*a.length)];
            for (int i = 0; i<b.length; i++) {
                b[i] = a[(int)(1.0/r * i)];
            }
        } else {
            StdOut.println("line");
            b = a;
        }
        StdAudio.play(b);
    }
}
