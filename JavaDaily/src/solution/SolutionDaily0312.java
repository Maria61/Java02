package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/13 19:40
 */
public class SolutionDaily0312 {
    /**
     * 坐标移动
     * @param s
     * @return
     */
    public static String move(String s){
        String[] sa = s.split(";");
        int x = 0;
        int y = 0;
        for(int i = 0; i < sa.length; i++){
            boolean flag = false;
            if(!(sa[i].length() > 3 || sa[i].length() < 2)){
                String sub = sa[i].substring(1);
                for(int j = 0; j < sub.length(); j++){
                    if(!(sub.charAt(j) >= '0' && sub.charAt(j) <= '9')){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    if(sa[i].charAt(0) == 'A'){
                        x -= Integer.valueOf(sub);
                    }else if(sa[i].charAt(0) == 'D'){
                        x += Integer.valueOf(sub);
                    }else if(sa[i].charAt(0) == 'S'){
                        y -= Integer.valueOf(sub);
                    }else if(sa[i].charAt(0) == 'W'){
                        y += Integer.valueOf(sub);
                    }
                }
            }
        }
        String re = String.valueOf(x)+","+String.valueOf(y);
        return re;
    }

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(move(s));
    }

    /**
     * 连续最大和(30%)
     * @param s
     * @return
     */
    public static int maxSum(String s){
        String[] sa = s.split(" ");
        int max = Integer.valueOf(sa[0]);
        int sum = 0;
        boolean flag = false;
        for(int i = 0; i < sa.length; i++){
            int j = Integer.valueOf(sa[i]);
            if(j >= 0){
                flag = true;
                sum += j;
            }else{
                max = Math.max(max,sum);
                sum = 0;
            }
        }
        if(flag == false){
            for(int i = 0; i < sa.length; i++) {
                int j = Integer.valueOf(sa[i]);
                sum = Math.max(j,sum);
            }
        }
        max = Math.max(max,sum);
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(maxSum(s));
        }
    }
}
