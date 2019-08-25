package tree;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-25 10:56
 */
public class Solution {
    //LeetCode 110
    //平衡二叉树

    public static int high(Node root){
        if(root == null){
            return 0;
        }

        int left = high(root.left);
        int right = high(root.right);

        return left>right ? (left+1):(right+1);
    }
    public boolean isBalanced(Node root) {
        if(root == null){
            return true;
        }

        if(!isBalanced(root.left)){
            return false;
        }

        if(!isBalanced(root.right)){
            return false;
        }

        if((high(root.left) - high(root.right)) > 1 || (high(root.left) - high(root.right)) < -1){
            return false;
        }
        return true;

    }

    /**
     *
     * LeetCode 236
     * 二叉树的最近公共祖先
     */

    public static boolean search(Node root,Node p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }

        if(search(root.left,p)){
            return true;
        }

        return search(root.right,p);
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == p || root == q){
            return root;
        }
        boolean i = search(root.left,p);
        boolean j = search(root.left,q);
        if(i && j){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!i && !j){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}
