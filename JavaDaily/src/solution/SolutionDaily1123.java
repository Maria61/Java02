package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/25 19:26
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class SolutionDaily1123 {
    private boolean count;

    public static void main1(String[] args) {
        SolutionDaily1123 s = new SolutionDaily1123();
        System.out.println(s.count);
    }

    //给定二叉树，将其变成原二叉树的镜像
    public void mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        mirror(root.left);
        mirror(root.right);
    }

}
