package review;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/11 16:34
 */
public class Test {
    /**
     * 牛客答题测试
     * 编写方法，计算从0 到  n 中 2 出现的次数，eg: 输入10 ，输出 1
     *
     * @param n
     * @return
     */
    public int countNumberOf2s(int n) {
        // write code here
        int i = 0;
        if (n >= 2) {
            i = 1;
            for (int j = 3; j <= n; j++) {
                int f = j;
                while (f != 0) {
                    if (f % 10 == 2) {
                        i++;
                    }
                    f = f / 10;
                }

            }
        }
        return i;
    }

    public static void main(String[] args) {
        Test t = new Test();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(t.countNumberOf2s(n));

    }
}
