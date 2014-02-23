public class Die
{
    private int value;

    public void roll() {
        value = StdRandom.uniform(6) + 1;
    }

    public int value() {
        return value;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Die d = new Die();
        for (int i = 0; i<N; i++) {
            d.roll();
            StdOut.println(d.value());
        }
    }
}
    
            
