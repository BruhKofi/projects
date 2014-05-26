import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
public class FileSorter
{
    public static void main(String[] args) {
        String dir = args[0];
        String sort = args[1].substring(1, args[1].length());
        
        File folder = new File(dir);
        ArrayList<File> fileList = new ArrayList<File>();

        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            }
        }

        for (int i = 0; i<sort.length(); i++) {
            char c = sort.charAt(i);
            if ('t' == c) Collections.sort(fileList, new FileComparators.modOrder());
            if ('n' == c) Collections.sort(fileList, new FileComparators.nameOrder());
            if ('s' == c) Collections.sort(fileList, new FileComparators.sizeOrder());
        }

        for (File file : fileList) {
            StdOut.println(file.getName());
        }
    }
}
