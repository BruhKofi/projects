import java.util.Comparator;

public class CaliforniaCompare implements Comparator<String>
{
    private final String ORDER ="RWQOJMVAHBSGZXNTCIEKUPDYFL";

    public int compare(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i<Math.min(s1.length(), s2.length()) && p1 == p2; i++) {
            p1 = ORDER.indexOf(s1.charAt(i));
            p2 = ORDER.indexOf(s2.charAt(i));
        }
        if (p1 == p2 && s1.length() != s2.length()) return s1.length() - s2.length();
        return p1 - p2;
    }
}
            
