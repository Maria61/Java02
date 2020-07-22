package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/7/22 21:28
 */
public class ShenXinFu3 {

    /**
     * 平行四边形最大面积
     * @param re
     * @return
     */
    public static int method(int[] re){
        Arrays.sort(re);
        boolean flaga = false;
        boolean flagb = false;
        int a = 0;
        int b = 0;
        for(int i = re.length - 1; i > 0; i --){
            if(re[i] == re[i - 1]){
                if(flaga == false){
                    a = re[i];
                    flaga = true;
                    i--;
                }else if(flagb == false){
                    b = re[i];
                    flagb = true;
                }
            }
            if(flaga == true && flagb == true){
                break;
            }
        }
        if(flaga == true && flagb == true){
            return a*b;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] arr = new int[n];
        String[] ss = s.split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(ss[i]);
        }
        int re = method(arr);
        System.out.println(re);
    }
}
