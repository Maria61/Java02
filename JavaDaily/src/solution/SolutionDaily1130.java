package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/2 14:16
 */

public class SolutionDaily1130 {
    static boolean[] flag = new boolean[5];

    //判断是否是平衡二叉树
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    public static double[] judge(String s) {
        int f = 0;
        double[] re = new double[5];
        String[] s1 = s.split(" ");
        int[] nums = new int[Integer.parseInt(s1[0])];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] % 5 == 0) {
                if (nums[j] % 2 == 0) {
                    flag[0] = true;
                    re[0] += nums[j];
                }
            }
            if (nums[j] % 5 == 1) {
                flag[1] = true;
                re[1] += (Math.pow(-1, f) * nums[j]);
                f++;
            }
            if (nums[j] % 5 == 2) {
                flag[2] = true;
                re[2] += 1;
            }
            if (nums[j] % 5 == 3) {
                flag[3] = true;
                count++;
                re[3] += nums[j];
            }
            if (nums[j] % 5 == 4) {
                flag[4] = true;
                re[4] = Math.max(re[4], nums[j]);
            }

        }
        re[3] = re[3] / count;
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        double[] re = judge(s);
        for (int i = 0; i < re.length; i++) {
            if (flag[i] == false) {
                if (i == re.length - 1) {
                    System.out.print("N");
                } else {
                    System.out.print("N ");
                }
            } else if (i == re.length - 1) {
                System.out.printf("%.0f", re[i]);
            } else {
                if (i == 3) {
                    System.out.printf("%.1f ", re[i]);
                } else {

                    System.out.printf("%.0f ", re[i]);
                }
            }

        }
    }

}
