package solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/11 20:25
 */
public class QiHu36020200911 {
    /**
     * 验证密码复杂度
     * @param
     */
    private static void contains(HashSet<Character> set) {
        char[] chars = {'_','!','@','#','$','%','^','&','*','(',')','?','-','+','=','<','>'};
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
        char[] cc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        boolean num = false;
        boolean c = false;
        boolean spical = false;
        boolean C = false;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                num = true;
                break;
            }
        }
        for(int i = 0; i < cc.length; i++){
            if(set.contains(cc[i])){
                c = true;
                break;
            }
        }
        for(int i = 0; i < cc.length; i++){
            if(set.contains(Character.toUpperCase(cc[i]))){
                C = true;
                break;
            }
        }
        for(int i = 0; i < chars.length; i++){
            if(set.contains(chars[i])){
                spical = true;
                break;
            }
        }
        if(num && c && C && spical){
            System.out.println("Ok");
        }else{
            System.out.println("Irregular password");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            if(s.length() < 8){
                System.out.println("Irregular password");
            }else{
                for(int i = 0; i < s.length(); i++){
                    set.add(s.charAt(i));
                }
                contains(set);
            }

        }
    }

}
