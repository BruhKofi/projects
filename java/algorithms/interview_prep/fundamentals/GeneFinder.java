public class GeneFinder
{
    private static final String START_CODON = "ATG";
    private static final String STOP_CODON_1 = "TAG";
    private static final String STOP_CODON_2 = "TAA";
    private static final String STOP_CODON_3 = "TGA";
    private static final int CODON_LENGTH = 3;
        
    public static void main(String[] args) {
        String code = StdIn.readAll();
        int start = -1;
        for (int i = 0; i<code.length()-CODON_LENGTH+1; i++) {
            String codon = code.substring(i, i+3);
            if (START_CODON.equals(codon)) start = i;
            if ((STOP_CODON_1.equals(codon) || STOP_CODON_2.equals(codon) || STOP_CODON_3.equals(codon)) && start != -1) {
                String gene = code.substring(start+3, i);
                if (gene.length() % 3 == 0) {
                    StdOut.println(gene);
                    start = -1;
                }
            }
        }
    }
}
