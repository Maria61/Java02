package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/11 16:42
 */
public class SolutionDaily0309 {
    /**
     * 找满二叉树的任意两个节点的最近公共祖先编号，根节点编号为1
     * @param a
     * @param b
     * @return
     */
    public int getLCA(int a, int b) {
        // write code here
        while(a != b){//找到的父节点编号相同即为最近公共祖先
            if(a > b){
                a /= 2;//实际是找父节点的过程
            }else{
                b /= 2;
            }
        }
        return a;
    }

    //替换字符串中所有的空格为“%20”的测试：直接用replace方法搞定
    public static void main(String[] args) {
        char[] chars = {'1','2'};
        String s = "dsfaf  sadf   dd ";
        System.out.println(s.contains(" "));
        System.out.println(s.replace(" ","%20"));//√
    }
}
