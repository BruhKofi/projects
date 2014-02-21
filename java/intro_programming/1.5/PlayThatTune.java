public class PlayThatTune
{
    public static void main(String[] args) {
        int sps = 44100;
        double volume = Double.parseDouble(args[0]);
        double tempo = Double.parseDouble(args[1]);
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            duration *= tempo;
            
            double hz = 400 * Math.pow(2, pitch/12.0);
            int N = (int) (sps * duration);
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(-1, 1);
            double[] a = new double[N+1];
            for (int i = 0; i<=N; i++) {
                a[i] = volume*Math.sin(2*Math.PI*i*hz/sps);
            }
            StdAudio.play(a);
            for (int i = 0; i<=N; i++) {
                StdDraw.point(i, a[i]);
            }
        }
    }
}
