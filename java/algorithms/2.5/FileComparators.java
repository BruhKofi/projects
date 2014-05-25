import java.util.Comparator;
import java.io.File;
public class FileComparators
{
    public static class sizeOrder implements Comparator<File>
    {
        public int compare(File v, File w) {
            if (v.length() > w.length()) return 1;
            else if (v.length() < w.length()) return -1;
            else return 0;
        }
    }

    public static class nameOrder implements Comparator<File>
    {
        public int compare(File v, File w) {
            return v.getName().compareTo(w.getName());
        }
    }

    public static class modOrder implements Comparator<File>
    {
        public int compare(File v, File w) {
            if (v.lastModified() > w.lastModified()) return 1;
            else if (v.lastModified() < w.lastModified()) return -1;
            else return 0;
        }
    }
}
