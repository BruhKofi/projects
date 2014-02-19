public class MyStopwatch
{
    private long start;
    private long stopTime;

    public MyStopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        double elapsedTime = 0.0;
        if (stopTime > 0) {
            elapsedTime = stopTime / 1000.0;
        } else {
            long now = System.currentTimeMillis();
            elapsedTime = (now - start) / 1000.0;
        }
        return elapsedTime;
    }

    public void stop() {
        long now = System.currentTimeMillis();
        stopTime = now - start;
    }

    public void start() {
        start = System.currentTimeMillis();
        stopTime = 0;
    }
}
