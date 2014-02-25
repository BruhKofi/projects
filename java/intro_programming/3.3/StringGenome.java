public class StringGenome
{
    private String genome = "";

    public void addCodon(char c) { genome += c; }

    public char nucleotideAt(int i) { return genome.charAt(i); }

}
        
