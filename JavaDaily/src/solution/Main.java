package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/11 17:22
 */
public class Main {
    /**
     * 牛客刷题输入输出练习
     *
     * @param args
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a + b);
//        }

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            int sum = 0;
//            String[] s = sc.nextLine().split(" ");
//            for(int j = 0; j < s.length; j ++){
//                sum = sum + Integer.parseInt(s[j]);
//            }
//            System.out.println(sum);
//        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[100];//?
        int i = 0;
        while (i < n) {
            s[i] = sc.next();
            i++;
        }

        for (i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 2; j++) {
                if (Integer.valueOf(s[j]) > Integer.valueOf(s[j + 1])) {
                    String temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
        for (i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }
}
