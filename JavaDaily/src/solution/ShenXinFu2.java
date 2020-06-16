package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/6/15 18:45
 */
public class ShenXinFu2 {
    /**
     * 将输入的字符串按从小到大的顺序输出
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ss = new String[n];
        for(int i = 0; i < n; i++){
            ss[i] = sc.nextLine();
        }
        Arrays.sort(ss);
        for(int i = 0; i < n; i++){
            System.out.println(ss[i]);
        }
    }

}
