public class Rumor
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int allGuestsKnowCount = 0;
        int rumorCount = 0;
        for (int t = 0; t<T; t++) {
            boolean[] guests = new boolean[N];
            guests[0] = true;
            rumorCount++;
            int currentPerson = 0;
            while (true) {
                int nextPerson = (int)(Math.random()*N);
                if (nextPerson == currentPerson) {
                    continue;
                }
                if (guests[nextPerson]) {
                    break;
                }
                guests[nextPerson] = true;
                rumorCount++;
                if (rumorCount == N) {
                    allGuestsKnowCount++;
                    break;
                }
                currentPerson = nextPerson;
            }
        }
        System.out.println((int)(100*(double)allGuestsKnowCount/T) + "% chance that all guests know the rumor");
        System.out.println(rumorCount/T + " people expected to hear the rumor before it stops propogating");
    }
}
