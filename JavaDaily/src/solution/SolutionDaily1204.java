package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/5 16:45
 */
public class SolutionDaily1204 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int re1 = square(n);
            int re2 = square((int) Math.pow(n, 2));
            System.out.println(re1 + " " + re2);
        }
    }

    private static int square(int n) {
        int x = n;
        int re = 0;
        while (x != 0) {
            re += x % 10;
            x = x / 10;
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] candidate = new String[n];
        String s = sc.nextLine();
        addCandidate(s, candidate);
        int v = sc.nextInt();
        sc.nextLine();
        String[] vote = new String[v];
        s = sc.nextLine();
        Vote(s, vote);
        printResult(candidate, vote);
    }

    private static void printResult(String[] candidate, String[] vote) {
        int invalid = vote.length;
        int[] v = new int[candidate.length];
        for (int i = 0; i < vote.length; i++) {
            for (int j = 0; j < candidate.length; j++) {
                if (vote[i].equals(candidate[j])) {
                    v[j]++;
                    invalid--;
                    break;
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            System.out.println(candidate[i] + " : " + v[i]);
        }
        System.out.println("Invalid : " + invalid);

    }

    private static void Vote(String s, String[] vote) {
        String[] c = s.split(" ");
        for (int i = 0; i < vote.length; i++) {
            vote[i] = c[i];
        }
    }

    private static void addCandidate(String s, String[] candidate) {
        String[] c = s.split(" ");
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = c[i];
        }
    }


}
