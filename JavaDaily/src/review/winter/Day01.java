package review.winter;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/1/7 12:46
 */
public class Day01 {
    public static void mystery (int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
    public static String toLowerCase(String str) {
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] >= 'A' && c[i] <='Z'){
                c[i] = (char)(c[i] + 32);
            }
        }
        String re = new String(c);
        return re;
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * @param nums
     * @param k
     */
    public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        for(int i = 0; i < k; i++){
            int last = nums[nums.length - 1];
            for(int j = nums.length - 2; j >= 0; j--){
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
        return nums;
    }
    public static void main(String[] args) {
//        int x = 20;
//        int y = 5;
//        System.out.println(x+y+""+(x+y)+y);
//        System.out.println(x+""+y);//""将x+y表达式分割为x与y的连接
//        mystery(1234);
//        System.out.println(toLowerCase("HellO"));

        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(rotate(array,2)));
    }
}
