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

    public static void main1(String[] args) {
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

    public static String RMB(double money) {
        String s = String.valueOf(money);
        char[] c = s.toCharArray();
        int flag = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '.') {
                flag = i;
                break;
            }
        }
        int f = flag;
        char[] r = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
        String[] w = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
        char[] y = {'角', '分'};
        String re = new String();
        boolean b = false;
        for (int i = 0; flag > 0 && i < c.length; i++) {
            if (c[i] != '0') {
                //处理十位为0，个位不为0的情况
                if (i != 0 && c[i - 1] == '0') {
                    re += r[0];
                }
                re += r[c[i] - '0'];
                re += w[flag - 1];
            } else if (i == (f - 1)) {//处理个位为0的情况
                re += w[0];
            }
            flag--;
        }
        for (int j = f + 1, i = 0; j < c.length && j < (f + 3); j++, i++) {
            if (c[j] != '0') {
                if (j != f + 1 && c[j - 1] == '0') {
                    re += r[0];
                }
                re += r[c[j] - '0'];
                re += y[i];
            }
        }
        if (f + 2 == c.length) {
            if (c[f + 1] == '0') {
                re += "整";
            }
        }
        return re;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double y = sc.nextDouble();
        System.out.println("人名币" + RMB(y));
    }
}
