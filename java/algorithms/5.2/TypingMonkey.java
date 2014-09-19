public class TypingMonkey
{
    private static final String alphabet = "abcedefghijklmnopqrstuvwxyz";
    
    public static void main(String[] args) {
        assert(alphabet.length() == 26);
        int N = Integer.parseInt(args[0]);//Number of trials
        int W = Integer.parseInt(args[1]);//Number of words

        MyTSTSet set = new MyTSTSet();
        for (int n = 0; n<N; n++) {
            int w = 0;
            do {
                String word = typeWord();
                if (!set.contains(word)) {
                    set.add(word);
                    w++;
                }
            } while (i < W);
        }

        int[] freq 
    }
}
