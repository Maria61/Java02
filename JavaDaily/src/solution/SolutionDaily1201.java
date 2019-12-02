package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/2 16:34
 */
public class SolutionDaily1201 {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int studentNums = sc.nextInt();
            int actionNums = sc.nextInt();
            int[] score = new int[studentNums];
            for (int i = 0; sc.hasNext() && i < studentNums; i++) {
                score[i] = sc.nextInt();

            }
            sc.nextLine();
            for (int j = 0; sc.hasNext() && j < actionNums; j++) {
                String action = sc.nextLine();
                int A = sc.nextInt();
                int B = sc.nextInt();
                if (action.equals("Q")) {
                    if (j == actionNums - 1) {
                        System.out.print(select(score, A, B));
                    } else {
                        System.out.println(select(score, A, B));
                    }
                }
                if (action.equals("U")) {
                    update(score, A, B);
                }
            }
        }

    }

    private static void update(int[] score, int i, int grade) {
        score[i - 1] = grade;
    }

    private static int select(int[] score, int x, int y) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        int[] re = new int[y - x + 1];
        for (int i = (x - 1), j = 0; i <= (y - 1); i++, j++) {
            re[j] = score[i];
        }
        Arrays.sort(re);
        return re[re.length - 1];

    }

    public static void main1(String[] args) {
        int M = 0, N = 0;
        int i;
        int A = 0, B = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();

            //          System.out.println (N + " " + M);

            int[] score = new int[N];
            for (i = 0; in.hasNext() && i < N; i++) {
                score[i] = in.nextInt();
                //          System.out.println (score[i] + " ");
            }

            String c = null;

            for (i = 0; in.hasNext() && i < M; i++) {
                c = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c, A, B, score);
            }
        }

    }

    private static void process(String c, int a, int b, int[] score) {
        int begin, end;

        if (c.equals("Q")) {
            end = Math.max(a, b);
            begin = Math.min(a, b) - 1;
            int max = score[begin];
            for (int i = begin; i < end; i++) {
                if (max < score[i]) {
                    max = score[i];
                }
            }
            System.out.println(max);
        } else if (c.equals("U")) {
            score[a - 1] = b;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] e = new int[n];
            for (int i = 0; i < n; i++) {
                e[i] = sc.nextInt();
            }
            System.out.println(killBoss(a, e));
        }

//        System.out.println(maxDivNum(98,63));
    }

    private static int killBoss(int a, int[] e) {
        int c = a;
        for (int i = 0; i < e.length; i++) {
            if (e[i] <= c) {
                c += e[i];
            } else {
                c += maxDivNum(c, e[i]);
            }
        }
        return c;
    }

    //最大公约数
    private static int maxDivNum(int m, int n) {
//        if(c == 0){
//            return d;
//        }
//        if(d == 0){
//            return c;
//        }
//        for(int i = c - 1; i > 0; i--){
//            if(c % i == 0){
//                if(d % i == 0){
//                    return i;
//                }
//            }
//        }
//        return 1;
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {// 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }



}
