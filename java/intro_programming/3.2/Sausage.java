public class Sausage
{
    private Turtle turtle;
    private double size;
    
    public Sausage(int N) {
        size = 1.5 / Math.pow(4.0 / Math.sqrt(3), N + 1);
        turtle = new Turtle(90/512.0, 150/512.0, 0.0);

        sausage(N);
        turtle.turnLeft(90);
        sausage(N);
        turtle.turnLeft(90);
        sausage(N);
        turtle.turnLeft(90);
        sausage(N);
        turtle.turnLeft(90);
    }

    private void sausage(int n) {
        if (n == 0) {
            turtle.goForward(size);
            return;
        }
        turtle.turnLeft(-30);
        sausage(n-1);
        turtle.turnLeft(90);
        sausage(n-1);
        turtle.turnLeft(-90);
        sausage(n-1);
        turtle.turnLeft(30);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Sausage s = new Sausage(N);
    }
}
