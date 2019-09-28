package review;

import java.util.Stack;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/27 20:34
 */
class MyNode {
    int value;
    MyNode left;
    MyNode right;
}

public class Tree {
    public boolean isSameTree(MyNode root1, MyNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1.value == root2.value) {
            isSameTree(root1.left, root1.right);
            isSameTree(root1.right, root2.right);
        } else {
            return false;
        }
        return false;
    }

    public void postOrder(MyNode root) {

    }

    public void levelOrder(MyNode root) {

    }


}



