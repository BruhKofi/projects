public class ImmutableDate implements Comparable<ImmutableDate>
{
    private final long time;

    public ImmutableDate() {
        time = System.currentTimeMillis();
    }

    public int compareTo(ImmutableDate other) {
        if (time > other.time) return 1;
        else if (time < other.time) return -1;
        else return 0;
    }

    public boolean after(ImmutableDate when) {
        return this.compareTo(when) > 0;
    }

    public boolean before(ImmutableDate when) {
        return !after(when);
    }

    public long getTime() {
        return time;
    }
}