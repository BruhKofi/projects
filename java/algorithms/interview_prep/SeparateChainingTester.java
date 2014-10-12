/*
  Compare performance of hashing with separate chaining as a function of list size
  Sample input:
  args[0] -- complete works of Charles Dickens
  args[1] -- translation of War and Peace
*/
import java.util.HashSet;
public class SeparateChainingTester
{
    private static final int[] tableSize = {997, 1283, 2111, 3881, 5261};
    public static void main(String[] args) {
        In fileA = new In(args[0]);
        HashSet<String> words = new HashSet<String>();
        // How many distinct strings are in the input file?
        while (!fileA.isEmpty()) {
            words.add(fileA.readString());
        }
        int N = words.size();
        // We will add N String keys to our separate chaining hash symbol table
        // If the table has M lists, the probability that the number of keys in
        // any given list is within a small constant of N/M is very close to 1
        for (int i = 0; i<tableSize.length; i++) {
            MySeparateChainingHashST<String, Integer> st = new MySeparateChainingHashST<String, Integer>(tableSize[i]);
            fileA = new In(args[0]);
            while (!fileA.isEmpty()) {
                String s = fileA.readString();
                if (st.contains(s)) st.put(s, st.get(s)+1);
                else st.put(s, 1);
            }
            In fileB = new In(args[1]);
            double time = 0.0;
            while (!fileB.isEmpty()) {
                String s = fileB.readString();
                Stopwatch sw = new Stopwatch();
                // How long does retrieval take for a table with tableSize[i] lists
                Integer p = st.get(s); // How many times does string s occur in fileA
                time += sw.elapsedTime();
            }
            StdOut.printf("Retrieval time from a table with %d lists containing %d keys (expect %5.2f keys per list) : %7.5f\n", tableSize[i], N, N/(double)tableSize[i], time);
        }
    }
}
