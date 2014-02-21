public class Poll
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] voters = new String[N];
        for (int i = 0; i<N; i++) {
            voters[i] = StdIn.readString();
        }
        for (int i = 0; i<M; i++) {
            int r = i + (int)(Math.random()*(N-i));
            String t = voters[r];
            voters[r] = voters[i];
            voters[i] = t;
        }
        for (int i = 0; i<M; i++) {
            StdOut.println(voters[i]);
        }
    }
}
