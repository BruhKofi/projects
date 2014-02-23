import java.awt.Color;

public class Equipotential
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Charge[] charges = new Charge[N];
        int sz = 512;
        Picture pic = new Picture(sz, sz);
        for (int i = 0; i<N; i++) {
            charges[i] = new Charge(StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform(1.0, 5.0));
            StdOut.println(StdRandom.uniform(1.0, 5.0));
        }

        double cx = 0.5;
        double cy = 0.5;

        for (int i = 0; i<sz; i++) {
            for (int j = 0; j<sz; j++) {
                double x = cx - sz/2 + sz*i/N;
                double y = cy - sz/2 + sz*j/N;
                double potential = 0.0;
                for (int k = 0; k<N; k++) {
                    potential += charges[k].potentialAt(x, y);
                }
                if ((int)Math.round(potential) % 5 == 1) {
                    pic.set(i, j, Color.BLACK);
                } else {
                    pic.set(i, j, Color.WHITE);
                }
            }
        }
        pic.show();
    }
}
