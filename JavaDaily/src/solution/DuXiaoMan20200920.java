package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/20 20:22
 */
public class DuXiaoMan20200920 {
    /**
     * 输入包含两个字符串，都仅包含大写字母，每一种字母代表一种颜色。
     * 第一个字符串S代表小A手上的颜料，第二个字符串T代表画需要的颜料。
     * 输出包含一个数，即最多能涂多少个色块。
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i = 0; i < s2.length(); i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        int re = 0;
        for(Map.Entry<Character,Integer> e : map2.entrySet()){
            Character c = e.getKey();
            int n = e.getValue();
            int m = map1.getOrDefault(c,0);
            if(n > m){
                re += m;
            }else{
                re += n;
            }
        }
        System.out.println(re);
    }

    /**
     * 判断是否是周期为3的类似字符串
     * 周期字符串：将字符串按照给定的值分为相同长度的子串，
     *            条件：所有子串同一位置的字符必须相同
     *            符合条件的位置必须大于等于2
     * @param s
     * @return
     */
    public static String method(String s){
        String re = "Yes";
        if(s.length() == 3){
            return "No";
        }
        if(s.length() % 3 != 0){
            return "No";
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i += 3){
            list.add(s.substring(i,i + 3));
        }
        Character[] c = new Character[3];
        c[0] = list.get(0).charAt(0);
        c[1] = list.get(0).charAt(1);
        c[2] = list.get(0).charAt(2);
        boolean[] flag = new boolean[3];
        boolean[] flag1 = new boolean[3];
        for(int i = 1; i < list.size(); i++){
            for(int j = 0; j < 3; j++){
                if(list.get(i).charAt(j) == c[j]){
                    flag[j] = true;
                }else{
                    flag[j] = false;
                }
            }
            if(i == 1){
                flag1[0] = flag[0];
                flag1[1] = flag[1];
                flag1[2] = flag[2];
            }
            if((flag[0] && flag[1] && flag[2]) == false){
                int count = 0;
                if(flag[0] == false){
                    count++;
                }
                if(flag[1] == false){
                    count++;
                }
                if(flag[2] == false){
                    count++;
                }
                if(count >= 2){
                    re = "No";
                    break;
                }else{
                    for(int j = 0; j < 3; j++){
                        if(flag[j] != flag1[j]){
                            re = "No";
                            break;
                        }
                    }
                    if(re.equals("No")){
                        break;
                    }
                }
            }
        }
        return re;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < n; i++){
            String s = sc.nextLine();
            System.out.println(method(s));
        }
    }
}
