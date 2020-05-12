package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/5/12 15:45
 */
public class WebTest2 {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] ss1 = s1.split(" ");
        int n = Integer.valueOf(ss1[0]);
        int m = Integer.valueOf(ss1[1]);
        String s2 = sc.nextLine();
        String[] ss2 = s2.split(" ");
        int[] as = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            as[i] = Integer.valueOf(ss2[i]);
        }
        Arrays.sort(as);
//        int[][] bcs = new int[];
        for(int i = 0; i < m; i++){
            String bc = sc.nextLine();
            String[] bc1 = bc.split(" ");
            for(int j = 0; j < n; j++){
                if(Integer.valueOf(bc1[0]) <= as[j]){
//                    res[j] = Math.max(res[j],Integer.valueOf(bc1[1]));
                    if(Integer.valueOf(bc1[1]) > res[j]){
                        if(j != n - 1){
                            res[j + 1] = res[j];
                        }
                        res[j] = Integer.valueOf(bc1[1]);
                    }
                    break;
                }
            }
        }
        int re = 0;
        for(int i = 0; i < n; i++){
            re += res[i];
        }
        System.out.println(re);
    }
}
