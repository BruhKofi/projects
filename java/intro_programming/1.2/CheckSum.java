public class CheckSum
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int isb = N;
        int i = 0;
        int sum = 0;
        while (i<9) {
            int d = N%10;
            N/=10;
            i++;
            sum += d*(i+1);
        }
        int check = 11 - sum%11;
        System.out.println(isb + "" + check);
    }
}
