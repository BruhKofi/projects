public class Time implements Comparable<Time>
{
    private long secondsSinceMidnight;

    public Time() {
        secondsSinceMidnight = (System.currentTimeMillis() / 1000) % (60*60*24);
        StdOut.println("sec since midnight: " + secondsSinceMidnight);
    }
        
    public long hour() {
        return secondsSinceMidnight/(60*60*24);
    }

    public long min() {
        long sec = secondsSinceMidnight % hour();
        long min = sec / 60;
        return min;
    }

    public long sec() {
        long sec = secondsSinceMidnight % (hour() * min());
        return sec;
    }

    public int compareTo(Time other) {
        if (secondsSinceMidnight < other.secondsSinceMidnight) return -1;
        else if (secondsSinceMidnight > other.secondsSinceMidnight) return 1;
        else return 0;
    }

    public String toString() {
        return hour() + ":" + min() + ":" + sec();
    }

    public static void main(String[] args) {
        Time t = new Time();
        StdOut.println(t);
    }
}