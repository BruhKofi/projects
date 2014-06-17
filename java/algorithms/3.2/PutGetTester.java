public class PutGetTester
{
    public static void main(String[] args) {
        BST<Integer, Integer> st = new BST<Integer, Integer>();
        double putTime = 0.0;
        double getTime = 0.0;
        
        while (!StdIn.isEmpty()) {
            int k = StdIn.readInt();
            if (!st.contains(k)) {
                Stopwatch put = new Stopwatch();
                st.put(k, 1);
                putTime += put.elapsedTime();
            }
            else {
                Stopwatch get = new Stopwatch();
                int m = st.get(k);
                getTime += get.elapsedTime();
                Stopwatch put = new Stopwatch();
                st.put(k, m + 1);
                putTime += put.elapsedTime();
            }
        }
        StdOut.printf("put: %5.5f\tget: %5.5f\tput/get: %5.5f\n", putTime, getTime, putTime/getTime);
    }
}

        