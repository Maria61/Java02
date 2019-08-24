package tree;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-23 10:51
 */
public class Node {
    char val;
    Node left = null;
    Node right = null;

    Node(char val){
      this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +'}';
    }
}
