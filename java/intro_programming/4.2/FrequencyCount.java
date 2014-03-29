public class FrequencyCount
{
    public static void main(String[] args) {
        String s = StdIn.readAll();
        String[] words = s.split("\\s+");
        Merge.sort(words);
        Counter[] zipf = new Counter[words.length];
        int M = 0;
        for (int i = 0; i<words.length; i++) {
            if (i == 0 || !words[i].equals(words[i-1])) {
                zipf[M++] = new Counter(words[i]);
            }
            zipf[M-1].increment();
        }
        Merge.sort(zipf, 0, M);
        for (int j = M-1; j>=0; j--) {
            StdOut.println(zipf[j]);
        }
    }
}