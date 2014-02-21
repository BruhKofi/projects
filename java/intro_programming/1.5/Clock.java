public class Clock
{
    public static void main(String[] args) {
        int hour = Integer.parseInt(args[0]);
        int minute = Integer.parseInt(args[1]);
        
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);

        double deltaSecHand = 2.0*Math.PI/60.0;
        double deltaMinHand = 2.0*Math.PI/60.0;
        double deltaHrHand = 2.0*Math.PI/12;

        long seconds = 0;
        long minutes = minute;
        long hours = hour;
        double x1 = 0.0;
        double y1 = 0.0;
        double hrx = 0.0;
        double hry = 0.5;
        double minx = 0.0;
        double miny = 0.75;
        double secx = 0.0;
        double secy = 1.0;
        double thetasec = Math.PI/2.0;
        double thetamin = Math.PI/2.0 - (2.0*Math.PI/60.0)*minute;
        double thetahr = Math.PI/2.0 - (2.0*Math.PI/12.0)*hour;
        double rhr = 0.5;
        double rmin = 0.75;
        double rsec = 1.0;
        
        while(true) {
            hrx = rhr*Math.cos(thetahr);
            hry = rhr*Math.sin(thetahr);
            minx = rmin*Math.cos(thetamin);
            miny = rmin*Math.sin(thetamin);
            secx = rsec*Math.cos(thetasec);
            secy = rsec*Math.sin(thetasec);
            StdDraw.clear();

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.setPenRadius(0.005);
            double thetaDot = 2.0*Math.PI;
            for (int i = 0; i<12; i++) {
                StdDraw.point(Math.cos(thetaDot), Math.sin(thetaDot));
                thetaDot += 2.0*Math.PI/12;
            }
            StdDraw.setPenRadius(0.02);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(x1, y1, hrx, hry);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(x1, y1, minx, miny);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x1, y1, secx, secy);
            StdDraw.show(1000);
            if (seconds > 0 && seconds%60 == 0) {
                thetamin -= deltaMinHand;
                minutes++;
                seconds = 0;
                thetasec = Math.PI/2.0;
            }
            if (minutes>0 && minutes%60 == 0) {
                thetahr -= deltaHrHand;
                minutes = 0;
            }
            seconds++;
            thetasec -= deltaSecHand;
        }
    }
}
