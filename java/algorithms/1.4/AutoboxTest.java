public class AutoboxTest
{
    public static void main(String[] args) {
        double prevInt = timeTrialInt(128);
        double prevInteger = timeTrialInteger(128);
        for (int N = 256; N<16777216; N+=N) {
            double timeInt = timeTrialInt(N);
            double timeInteger = timeTrialInteger(N);
            StdOut.printf("%6d %7.1f ", N, timeInt);
            StdOut.printf("%5.1f", timeInt/prevInt);
            StdOut.printf("%7.1f ", timeInteger);
            StdOut.printf("%5.1f", timeInteger/prevInteger);
            StdOut.printf("%5.1f\n", timeInteger/timeInt);
            prevInt = timeInt;
            prevInteger = timeInteger;
        }
    }

    public static double timeTrialInt(int size) {
        Stopwatch sw = new Stopwatch();
        FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(size);
        for (int j = 0; j<10000; j++) {
            for (int i = 0; i<size; i++) {
                stack.push(i);
            }
            for (int i = 0; i<size; i++) {
                stack.pop();
            }
        }
        return sw.elapsedTime();
    }

    public static double timeTrialInteger(int size) {
        Stopwatch sw = new Stopwatch();
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(size);
        for (int j = 0; j<10000; j++) {
            for (int i = 0; i<size; i++) {
                stack.push(i);
            }
            for (int i = 0; i<size; i++) {
                stack.pop();
            }
        }
        return sw.elapsedTime();
    }
}
