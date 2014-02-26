public class Histogram
{
    private final int[] freq;
    private double max;

    public Histogram(int N) {
        freq = new int[N];
    }

    public void addDataPoint(int i) {
        freq[i]++;
        if (freq[i] > max) max = freq[i];
    }

    public void addUniformRandomNumber(double d) {
        double step = 1.0 / freq.length;
        double value = 0.0;
        int i = -1;
        while (value < d) {
            value += step;
            i++;
        }
        addDataPoint(i);
    }

    public void draw() {
        Draw draw = new Draw();
        draw.setYscale(0, max);
        draw.setXscale(0, freq.length-1);
        for (int i = 0; i<freq.length; i++) {
            draw.filledRectangle(i, freq[i]/2, 0.25, freq[i]/2);
        }
        

        // double stddev = StdStats.stddev(freq);
        // StdOut.println(mean + " " + stddev);
        
        // draw.setPenColor(Draw.RED);
        // draw.line(mean, 0.0, mean, max);
        // draw.setPenColor(Draw.BLUE);
        // double stddevLow = mean - 2.0*stddev;
        // double stddevHigh = mean + 2.0*stddev;
        // draw.line(stddevLow, 0.0, stddevLow, max);
        // draw.line(stddevHigh, 0.0, stddevHigh, max);
    }

    public static void main(String[] args) {
        // int N = Integer.parseInt(args[0]);
        // int T = Integer.parseInt(args[1]);

        // for (double p = 0.2; p<1.0; p += 0.2) {
        //     Histogram h = new Histogram(N+1);
        //     for (int t = 0; t<T; t++) {
        //         h.addDataPoint(Bernoulli.binomial(N, p));
        //     }
        //     h.draw();
        // }
        Histogram h = new Histogram(1001);
        for (int i = 0; i<10000; i++) {
            h.addUniformRandomNumber(StdRandom.uniform());
        }
        h.draw();
    }
}

    
