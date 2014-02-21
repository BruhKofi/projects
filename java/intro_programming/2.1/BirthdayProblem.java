public class BirthdayProblem
{
    public static int nextBirthday() {
        return (int)(Math.random()*365);
    }

    public static int countPeople() {
        boolean[] birthdays = new boolean[365];
        int cnt = 0;
        int ppl = 0;
        while (cnt<365) {
            ppl++;
            int bday = nextBirthday();
            if (!birthdays[bday]) {
                birthdays[bday] = true;
                cnt++;
            } else {
                break;
            }
        }
        return ppl;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int sum = 0;
        for (int t = 0; t<T; t++) {
            sum += countPeople();
        }
        StdOut.printf("Average people needed before two share a birthday: %d\n", sum/T);
    }
}
