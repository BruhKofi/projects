import java.util.HashSet;

public class PasswordCheck
{
    public static boolean goodPassword(String s, HashSet<String> dictionary) {
       if (s.length() < 8) return false;
       if (dictionary.contains(s)) return false;
       if (s.matches(".*\\d+")) {
           if (dictionary.contains(s.replaceAll("[\\d]+$", ""))) return false;
       }
       String[] txt = s.split("\\d+");
       for (String p : txt) {
           if (dictionary.contains(p)) return false;
       }
       return true;
    }

    public static void main(String[] args) {
        String s = args[0];
        HashSet<String> dictionary = new HashSet<String>();
        while (!StdIn.isEmpty()) {
            dictionary.add(StdIn.readString());
        }
        if (goodPassword(s, dictionary)) {
            StdOut.println("Your password is OK");
        } else {
            StdOut.println("Choose a better password");
        }
    }
}
