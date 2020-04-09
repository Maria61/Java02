package review.winter;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/9 16:28
 */
public class Day04 {
    /**
     * 最后一个单词的长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if(s == null){
            return 0;
        }
        if(!s.contains(" ")){
            return s.length();
        }
        String[] ss = s.split(" ");
        if(ss.length != 0){
            return ss[ss.length - 1].length();
        }
        return 0;
    }

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    public static void main(String[] args) {
//        String s = null;
////        System.out.println(lengthOfLastWord(s));
//        System.out.println(lengthOfLastWord(" asdf "));


    }
}
