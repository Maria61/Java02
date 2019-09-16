package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 19:30
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }


            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;

    }
}
