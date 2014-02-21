public class WordCount
{
    public static void main(String[] args) {
        int words = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            words++;
        }
        StdOut.printf("There are %d words in the input text", words);
        StdOut.println();
    }
}
