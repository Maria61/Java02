package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/18 8:46
 */
public class SolutionDaily0317 {

    /**
    *LeetCode 219 判断给定数组中，是否有两个相同的元素，且间距差小于等于k
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // if(nums.length == 1){
        //     return false;
        // }
        if(k < nums.length){
            for(int i = 0; i < nums.length; i++){
                for(int j = 1; j <= k; j++){
                    if((i + j) < nums.length && nums[i] == nums[i + j]){
                        return true;
                    }
                }

            }
        }else{
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] == nums[j]){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,9};
        System.out.println(containsNearbyDuplicate(nums,3));

    }
}
