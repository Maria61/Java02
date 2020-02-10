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



    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }
}
