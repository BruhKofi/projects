/*
  Compare performance of Trie ST with java.util.HashMap
*/
import java.util.HashMap;
public class TriePerformance
{
    private static final String LICENSE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PLATE_LENGTH = 7;
    
    private static String caLicensePlate() {
        StringBuilder sb = new StringBuilder(PLATE_LENGTH);
        for (int i = 0; i<PLATE_LENGTH; i++) sb.append(LICENSE.charAt(StdRandom.uniform(LICENSE.length())));
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // Number of license plates to add to symbol table
        Alphabet alpha = new Alphabet(LICENSE);
        
        TrieST<Integer> trie = new TrieST<Integer>();
        AlphabetTrie<Integer> alphaTrie = new AlphabetTrie<Integer>(alpha);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        
        double trieTime = 0.0;
        double alphaTrieTime = 0.0;
        double hashTime = 0.0;
        for (int i = 0; i<N; i++) {
            String plate = caLicensePlate();
            Stopwatch sw = new Stopwatch();
            
            // if (!trie.contains(plate)) trie.put(plate, 1);
            // else trie.put(plate, trie.get(plate) + 1);
            // trieTime += sw.elapsedTime();

            sw = new Stopwatch();
            if (!hashMap.containsKey(plate)) hashMap.put(plate, 1);
            else hashMap.put(plate, hashMap.get(plate) + 1);
            hashTime += sw.elapsedTime();

            sw = new Stopwatch();
            if (!alphaTrie.contains(plate)) alphaTrie.put(plate, 1);
            else alphaTrie.put(plate, alphaTrie.get(plate) + 1);
            alphaTrieTime += sw.elapsedTime();
        }
        StdOut.printf("Trie took %5.2f\n", trieTime);
        StdOut.printf("HashMap took %5.2f\n", hashTime);
        StdOut.printf("Trie with specific alphabet took %5.2f\n", alphaTrieTime);
    }
}
