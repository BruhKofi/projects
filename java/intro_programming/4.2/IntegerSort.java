public class IntegerSort
{
    public static void main(String[] args) {
        int[] input = new int[100];
        while (!StdIn.isEmpty()) {
            input[StdIn.readInt()]++;
        }

        for (int i = 0; i<100; i++) {
            if (input[i] > 0) {
                for (int j = 0; j<input[i]; j++) {
                    StdOut.println(i);
                }
            }
        }
    }
}