public class StackEfficiencyTest
{
    public static void main(String[] args) {
        double prevArr = timeTrialArray(128);
        double prevList = timeTrialList(128);
        for (int N = 256; N<16777216; N+=N) {
            double timeArr = timeTrialArray(N);
            double timeList = timeTrialList(N);
            StdOut.printf("%6d %7.1f ", N, timeArr);
            StdOut.printf("%5.1f", timeArr/prevArr);
            StdOut.printf("%7.1f ", timeList);
            StdOut.printf("%5.1f", timeList/prevList);
            StdOut.printf("%5.1f\n", timeList/timeArr);
            prevArr = timeArr;
            prevList = timeList;
        }
    }

    public static double timeTrialArray(int size) {
        Stopwatch sw = new Stopwatch();
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
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

    public static double timeTrialList(int size) {
        Stopwatch sw = new Stopwatch();
        Stack<Integer> stack = new Stack<Integer>();
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
