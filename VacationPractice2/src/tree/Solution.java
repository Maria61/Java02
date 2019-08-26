package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-25 10:56
 */
public class Solution {
    /**
     * LeetCode 110
     * 判断是否是平衡二叉树
     */

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

    /**
     * LeetCode 102
     * 层序遍历并层序返回
     */

    private  class Element{
        Node node;
        int level;
    }

    public List<List<Character>> levelOrder(Node root) {

        List<List<Character>> retList = new ArrayList<>();

        if(root == null){
            return retList;
        }

        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        queue.add(e);

        while(!queue.isEmpty()){
            Element front = queue.poll();

            if(retList.size() == front.level){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);

            if(front.node.left != null){
                Element l = new Element();
                l.node = front.node;
                l.level = front.level + 1;
                queue.add(l);
            }

            if(front.node.right != null){
                Element l = new Element();
                l.node = front.node;
                l.level = front.level + 1;
                queue.add(l);
            }
        }

        return retList;
    }


}
