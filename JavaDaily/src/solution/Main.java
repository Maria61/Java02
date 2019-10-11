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
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
