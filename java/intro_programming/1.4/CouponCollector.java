public class CouponCollector
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int couponCount = 0;
        for (int i = 0; i<100; i++) {
            boolean[] coupons = new boolean[N];
            int newCoupons = 0;
            while (newCoupons<N) {
                couponCount++;
                int r = (int)(Math.random()*N);
                if (!coupons[r]) {
                    coupons[r] = true;
                    newCoupons++;
                }
            }
        }
        System.out.println("Calculated " + (double)couponCount/100);
        double Hn = 0.0;
        for (int i = 1; i<=N; i++) {
            Hn += 1.0/i;
        }
        System.out.println("Exact " + N*Hn);
    }
}
