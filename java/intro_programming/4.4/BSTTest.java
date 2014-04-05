public class BSTTest
{
    public static void main(String[] args) {
        BST<Integer, Integer> st = new BST<Integer, Integer>();
        int iOld = 0;
        for (int i = 100; true; i*=2) {
            for (int j = iOld; j<i; j++) {
                st.put(j, StdRandom.uniform(i));
            }
            iOld = i;
            Stopwatch getTime = new Stopwatch();
            int a = st.get(StdRandom.uniform(iOld));
            StdOut.println(iOld + ": " + getTime.elapsedTime());
        }
    }
}
