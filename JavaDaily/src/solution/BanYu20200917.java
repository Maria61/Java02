package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/17 15:33
 */
public class BanYu20200917 {
    /**
     * 负二进制转换，将一个数转换为负二进制表示形式
     * @param N
     * @return
     */
    public static String baseNeg2 (int N) {
        // write code here
        String re = "";
        int sum = N;
        while(true){
            int y = sum % (-2);
            if(y < 0){
                y = 1;
                sum = sum - 1;
            }
            sum = sum / (-2);
            re += y;
            if(sum == 0){
                break;
            }
        }
        String re1 = "";
        for(int i = re.length() - 1; i >= 0 ; i--){
            re1 += re.charAt(i);
        }
        return re1;
    }
    public static void main1(String[] args) {
        System.out.println(baseNeg2(3));
//        System.out.println((-1)%(-2));
    }

    /**
     * 机器人移动，可以移动的坐标的各位数之和小于等于k，求可以移动的方格有多少个？
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount (int m, int n, int k) {
        // write code here
        if(k < 0){
            return 0;
        }
        int re = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                int x = i;
                int y = j;
                while(x != 0){
                    sum += x % 10;
                    x /= 10;
                }
                while(y != 0){
                    sum += y % 10;
                    y /= 10;
                }
                if(sum <= k){
                    re++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
    }
}
