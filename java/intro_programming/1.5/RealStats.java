public class RealStats
{
    public static void main(String[] args) {
        int zeroCrossings = 0;
        double mag = 0.0;
        double pow = 0.0;
        int count = 1;
        double current = StdIn.readDouble();
        double next = 0.0;
        while (!StdIn.isEmpty()) {
            next = StdIn.readDouble();
            mag += Math.abs(current);
            pow += current*current;
            if (next < 0 && current > 0) {
                zeroCrossings++;
            }
            if (next > 0 && current < 0) {
                zeroCrossings++;
            }
            count++;
            current = next;
        }
        mag += Math.abs(current);
        pow += current*current;
        if (next < 0 && current > 0) {
                zeroCrossings++;
        }
        if (next > 0 && current < 0) {
                zeroCrossings++;
        }
        StdOut.printf("The average magnitude is %5.2f, the average power is %5.2f, and the number of zero crossings is %d", mag/count, pow/count, zeroCrossings);
        StdOut.println();
    }
}
