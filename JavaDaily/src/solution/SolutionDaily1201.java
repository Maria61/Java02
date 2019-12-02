package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/2 16:34
 */
public class SolutionDaily1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNums = sc.nextInt();
        int actionNums = sc.nextInt();
        int[] score = new int[studentNums];
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();

        }
        sc.nextLine();
        for (int j = 0; j < actionNums; j++) {
            String action = sc.nextLine();
            String[] ac = action.split(" ");
            if (ac[0].equals("Q")) {
                if (j == actionNums - 1) {
                    System.out.print(select(score, Integer.parseInt(ac[1]),
                            Integer.parseInt(ac[2])));
                } else {
                    System.out.println(select(score, Integer.parseInt(ac[1]),
                            Integer.parseInt(ac[2])));
                }
            }
            if (ac[0].equals("U")) {
                update(score, Integer.parseInt(ac[1]), Integer.parseInt(ac[2]));
            }
        }
    }

    private static void update(int[] score, int i, int grade) {
        score[i - 1] = grade;
    }

    private static int select(int[] score, int x, int y) {
        int[] re = new int[y - x + 1];
        for (int i = (x - 1), j = 0; i <= (y - 1); i++, j++) {
            re[j] = score[i];
        }
        Arrays.sort(re);
        return re[re.length - 1];
    }

//    public static void main(String[] args) {
//        System.out.println(10);
//    }
}
