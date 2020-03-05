package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/5 16:23
 */
public class SolutionDaily0304 {


    /**
     * 找出坏的键盘键
     * @param p
     * @param r
     * @return
     */
    public static String judge(String p,String r){
        String re = new String();

        p = p.toUpperCase();
        r = r.toUpperCase();
        char[] pc = p.toCharArray();
        char[] rc = r.toCharArray();
        HashSet<Character> ps = new HashSet<>();
        for(int i = 0; i < rc.length; i++){
            if(!ps.contains(rc[i])){
                ps.add(rc[i]);
            }
        }
        for(int  i = 0; i < pc.length; i++){
            if(!ps.contains(pc[i])){
                if(!re.contains(String.valueOf(pc[i]))){
                    re += String.valueOf(pc[i]);
                }
            }
        }

        return re;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String r = sc.nextLine();
        System.out.println(judge(p,r));
    }
}
