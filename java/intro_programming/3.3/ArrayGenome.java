public class ArrayGenome
{
    int i;
    private char[] genome = new char[2];

    public void addCodon(char c) {
        if (i == genome.length) {
            char[] genomeCopy = new char[genome.length*2];
            for (int k = 0; i<genome.length; k++) {
                genomeCopy[k] = genome[k];
            }
            genome = genomeCopy;
        }
        genome[i++] = c;
    }

    public char nucleotideAt(int j) { return genome[j]; }

}
    
