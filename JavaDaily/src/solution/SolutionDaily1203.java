package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/3 22:54
 */
public class SolutionDaily1203 {
    public static double calculateGPA(int n, int[] credits, int[] grade) {
        double GPA;
        double cre = 0.0;
        double gra = 0.0;
        double pro = 0.0;
        for (int i = 0; i < n; i++) {
            if (grade[i] >= 90 && grade[i] <= 100) {
                pro = 4.0 * credits[i];
            }
            if (grade[i] >= 85 && grade[i] <= 89) {
                pro = 3.7 * credits[i];
            }
            if (grade[i] >= 82 && grade[i] <= 84) {
                pro = 3.3 * credits[i];
            }
            if (grade[i] >= 78 && grade[i] <= 81) {
                pro = 3.0 * credits[i];
            }
            if (grade[i] >= 75 && grade[i] <= 77) {
                pro = 2.7 * credits[i];
            }
            if (grade[i] >= 72 && grade[i] <= 74) {
                pro = 2.3 * credits[i];
            }
            if (grade[i] >= 68 && grade[i] <= 71) {
                pro = 2.0 * credits[i];
            }
            if (grade[i] >= 64 && grade[i] <= 67) {
                pro = 1.5 * credits[i];
            }
            if (grade[i] >= 60 && grade[i] <= 63) {
                pro = 1.0 * credits[i];
            }
            if (grade[i] < 60) {
                pro = 0.0 * credits[i];
            }
            cre += credits[i];
            gra += pro;
        }
        GPA = gra / cre;
        return (double) GPA;
    }

    public static String RMB(double money) {
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] credits = new int[n];
        int[] grade = new int[n];
        for (int i = 0; i < n; i++) {
            credits[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            grade[j] = sc.nextInt();
        }
        System.out.printf("%.2f", calculateGPA(n, credits, grade));
    }
}
