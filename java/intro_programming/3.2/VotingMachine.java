public class VotingMachine
{
    private int rep;
    private int dem;
    private int ind;

    public void voteRep() {
        rep++;
    }

    public void voteDem() {
        dem++;
    }

    public void voteInd() {
        ind++;
    }

    public int getCount() {
        return ind + dem + rep;
    }
}
