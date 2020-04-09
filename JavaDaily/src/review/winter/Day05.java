package review.winter;

import java.util.HashSet;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/9 16:28
 */
public class Day05 {
    /**
     * 存在重复元素
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * 长按键入
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {
        String re = new String();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < typed.length(); i++){
            if(!set.contains(typed.charAt(i))){
                re += String.valueOf(typed.charAt(i));
                set.add(typed.charAt(i));
            }
        }
        if(re.equals(name)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleex"));
    }
}
