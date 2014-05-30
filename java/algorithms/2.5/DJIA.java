import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class DJIA implements Comparable<DJIA>
{
    private GregorianCalendar date;
    private String data;

    public DJIA(String input) {
        String[] s = input.split(",");
        String[] inputDate = s[0].split("-");
        if (inputDate.length != 3) throw new InputMismatchException();
        int day = Integer.parseInt(inputDate[0]);
        int month = getMonth(inputDate[1]);
        int year = Integer.parseInt(inputDate[2]);
        if (year < 10) year += 2000;
        else year+= 1900;
        date = new GregorianCalendar();
        date.set(year, month, day);
        data = input;
    }

    private int getMonth(String month) {
        if (month.equals("Jan")) return 1;
        else if (month.equals("Feb")) return 2;
        else if (month.equals("Mar")) return 3;
        else if (month.equals("Apr")) return 4;
        else if (month.equals("May")) return 5;
        else if (month.equals("Jun")) return 6;
        else if (month.equals("Jul")) return 7;
        else if (month.equals("Aug")) return 8;
        else if (month.equals("Sep")) return 9;
        else if (month.equals("Oct")) return 10;
        else if (month.equals("Nov")) return 11;
        else if (month.equals("Dec")) return 12;
        else return -1;
    }

    public int compareTo(DJIA that) {
        return this.date.compareTo(that.date);
    }

    public String toString() {
        return data.replaceAll(",", "\t");
    }
}
    

