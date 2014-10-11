/*
  Compare the performance of my implementations
  hashing with linear probing vs hashing with separate chaining
*/
public class HashTester
{
    public static void main(String[] args) {
        In fileA = new In(args[0]);
        In fileB = new In(args[1]);
        int T = Integer.parseInt(args[2]);

        MySeparateChainingHashST<String, Integer> separateChain = new MySeparateChainingHashST<String, Integer>(5843);
        MyLinearProbingHashST<String, Integer> linearProb = new MyLinearProbingHashST<String, Integer>();

        //Count frequency of strings in fileA and store in hash table
        while (!fileA.isEmpty()) {
            String s = fileA.readString();
            if (separateChain.contains(s)) {
                separateChain.put(s, separateChain.get(s) + 1);
                linearProb.put(s, linearProb.get(s)+1);
            }
            else {
                separateChain.put(s, 1);
                linearProb.put(s, 1);
            }
        }

        // For each string in fileB, see if it is contains in each hash table and compare performance

        double sepChainTime = 0.0;
        double linearProbTime = 0.0;
        
        while (!fileB.isEmpty()) {
            String s = fileB.readString();
            Stopwatch sw = new Stopwatch();
            for (int t = 0; t<T; t++) {
                Integer p = separateChain.get(s);
            }
            sepChainTime += sw.elapsedTime();

            sw = new Stopwatch();
            for (int t = 0; t<T; t++) {
                Integer p = linearProb.get(s);
            }
            linearProbTime += sw.elapsedTime();
        }

        StdOut.printf("Hashing with linear probing: %7.5f\n", linearProbTime);
        StdOut.printf("Hashing with separate chaining : %7.5f\n", sepChainTime);
    }
}
