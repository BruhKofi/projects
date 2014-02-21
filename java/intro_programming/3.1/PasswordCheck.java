public class PasswordCheck
{
    public static boolean valid(String s) {
        if (s.length() < 8 ) return false;
        int digits = 0;
        int upperCase = 0;
        int lowerCase = 0;
        int specialChar = 0;
        for (int i = 0; i<s.length(); i++) {
            int n = (int)s.charAt(i);
            if (n >= 48 && n <= 57) digits++;
            if (n >= 45 && n <= 90) upperCase++;
            if (n >= 97 && n <= 122) lowerCase++;
            if ((n >= 123 && n <= 126) || (n >= 91 && n <= 96) || (n >= 58 && n <= 64) || (n >= 33 && n <= 47)) specialChar++;
        }
        return digits > 0 && upperCase > 0 && lowerCase > 0 && specialChar > 0;
    }

    public static void main(String[] args) {
        StdOut.println(valid(args[0]));
    }
}
