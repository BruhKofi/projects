import java.util.Date;

public class DateRange
{
    private SET<Date> set = new SET<Date>();

    public void insert(Date date) {
        set.add(date);
    }

    public Date find(Date date) {
        if (set.contains(date)) return date;
        return null;
    }

    public int rangeCount(Date d1, Date d2) {
        int count = 0;
        for (Date d : set) {
            if (d.compareTo(d1) > 0 && d.compareTo(d2) < 0) count++;
        }
        return count;
    }
}
