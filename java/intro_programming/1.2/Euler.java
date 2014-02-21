public class Euler
{
    public static void main(String[] args) {
        for (long i = 0; i<Long.MAX_VALUE; i++) {
            for (long j = 0; j<Long.MAX_VALUE; j++) {
                for (long k = 0; k<Long.MAX_VALUE; k++) {
                    for (long l = 0; l<Long.MAX_VALUE; l++) {
                        for (long h = 0; h<Long.MAX_VALUE && !(h==i || h==j || h==k || h==l); h++) {
                            if (Math.pow(i,5) + Math.pow(j,5) + Math.pow(k,5) + Math.pow(l,5) == Math.pow(h,5)) {
                                System.out.println(i + " " + j + " " + k + " " + l + " " + h);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
