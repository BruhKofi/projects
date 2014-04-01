public class IndexByKeyword
{
    private static int binarySearch(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    private static int search(String key, String[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) return search(key, a, lo, mid);
        else if (cmp < 0) return search(key, a, mid+1, hi);
        else {
            int i = mid; int j = mid;
            while (a[i].compareTo(key) == 0 && i > 0) i--;
            while (a[j].compareTo(key) == 0  && j < a.length-1) j++;
            return j - (i+1);
        }
    }
        
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);
        
        String fileName = args[2];
        In input = new In(fileName);
        String[] dictionary = input.readAll().split("\\s+");

        String[] words = StdIn.readAll().split("\\s+");

        Merge.sort(words);
        Merge.sort(dictionary);

        BST<String, Queue<Integer>> st = new BST<String, Queue<Integer>>();

        for (int i = 0; i<dictionary.length; i++) {
            String s = dictionary[i];
            if (s.length() < minlen) continue;
            if (binarySearch(s, words) < minocc) continue;
            if (!st.contains(s)) {
                st.put(s, new Queue<Integer>());
                Queue<Integer> q = st.get(s);
                for (int j = 0; j<words.length; j++) {
                    if (s.equals(words[j])) {
                        q.enqueue(j);
                    }
                }
            }
        }

        for (String s : st.keys()) {
            Queue<Integer> q = st.get(s);
            StdOut.println(s + ": " + q);
        }
    }
}