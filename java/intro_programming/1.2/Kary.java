public class Kary
{
    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        assert(k>1 && k<17);

        String s = "";
        for (int j = i; j>0; j/=k) {
            int r = j%k;
            if (r>10) {
                switch(r) {
                case 11: s = 'A' + s; break;
                case 12: s = 'B' + s; break;
                case 13: s = 'C' + s; break;
                case 14: s = 'D' + s; break;
                case 15: s = 'E' + s; break;
                case 16: s = 'F' + s; break;
                }
                continue;
            }
            s = r + s;
        }
        System.out.println(s);
    }
}
                
