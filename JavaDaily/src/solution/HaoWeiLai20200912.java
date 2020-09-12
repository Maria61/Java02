package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/12 13:30
 */
public class HaoWeiLai20200912 {
    /**
     * 上台阶基础版
     * @param n
     * @return
     */
    public int climbStairs (int n) {
        // write code here
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1)+climbStairs(n - 2);
    }
    public static void main(String[] args) {

    }
}
