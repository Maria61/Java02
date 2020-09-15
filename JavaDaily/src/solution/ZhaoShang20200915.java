package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/15 16:40
 */
public class ZhaoShang20200915 {
    /**
     * 二面试题：水仙花数
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 100; i < 999; i++){
            int n = i;
            int sum = 0;
            while(n != 0){
                int j = n % 10;
                sum += j*j*j;
                n /= 10;
            }
            if(sum == i){

                System.out.println(i);
            }
        }
    }
}
