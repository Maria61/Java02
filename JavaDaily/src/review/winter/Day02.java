package review.winter;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/2/8 21:18
 */
public class Day02 {

    public static int removeElement(int[] nums, int val){
        int flag = -1;
        int count = nums.length;
        for(int  i = 0,j = -1; i < nums.length;i++){
            if(nums[i] == val && j == -1){
                j = i;
            }
            if(nums[i] != val && j != -1){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }
}
