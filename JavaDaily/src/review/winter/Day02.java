package review.winter;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/2/8 21:18
 */
public class Day02 {

    public static int removeElement(int[] nums, int val){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                count++;
            }
        }
        for(int  i = 0,j = 0; i < nums.length;i++){
            if(nums[i] != val && nums[j] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            if(nums[i] != val){
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums[nums.length - 1]  < target){
            return nums.length;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(nums[i] > target){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] nums = {2,2,2,2,3,0,4,2};
//        System.out.println(removeElement(nums,2));

//        int[] nums = {1,3,5,6};
//        System.out.println(searchInsert(nums,2));

        String s = "hello"+" "+"world";
        String p = "hello world";
        System.out.println(s==p);
        System.out.println(s.equals(p));
        String a = new String(s);
        System.out.println(a.equals(s));
    }
}
