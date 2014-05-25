public class VersionNumber implements Comparable<VersionNumber>
{
    private final String vNumber;

    public VersionNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public String getVNumber() {
        return vNumber;
    }

    public int compareTo(VersionNumber that) {
        String[] thisNums = getVNumber().split("\\.");
        String[] thatNums = that.getVNumber().split("\\.");
        for (int i = 0; i<3; i++) {
            if (Integer.parseInt(thisNums[i]) > Integer.parseInt(thatNums[i])) return 1;
            else if (Integer.parseInt(thisNums[i]) < Integer.parseInt(thatNums[i])) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        VersionNumber v1 = new VersionNumber("115.1.1");
        VersionNumber v2 = new VersionNumber("115.10.1");
        VersionNumber v3 = new VersionNumber("115.1.1");
        StdOut.println(v1.compareTo(v2) > 0);
        StdOut.println(v1.compareTo(v3) == 0);
    }
}
