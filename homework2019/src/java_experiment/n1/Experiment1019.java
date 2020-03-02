package java_experiment.n1;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/19 13:40
 */
public class Experiment1019 {
    public static void primeNumber(int n){
        for(int i = 2; i <= n;i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                System.out.printf(" %d" ,i);
            }

        }
        System.out.println();
    }


    public static void perfectNumber(int n){
        for(int  i = 1; i <= n ; i++){
            int sum = 0;
            for(int j = 1; j < i; j++){
                if( i % j == 0){
                    sum += j;
                }
            }
            if(sum == i){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void factorial(int n){
        int sum = 0;
        int i = 0;
        for(i = 1; i <= n; i++){
            sum += factorialInternal(i);
            if(sum > n){
                break;
            }
        }
        System.out.println(i-1);
    }

    private static int factorialInternal(int n) {
        if(n == 0){
            return 1;
        }
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static void narciNum(){
        for(int  i = 100; i <= 999; i++){
            int sum = 0;
            int  j = i;
            while(j != 0){
                sum += Math.pow(j%10,3);
                j /= 10;
            }
            if(sum == i){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {
//        System.out.println("HelloWorld!");
//        System.out.println("1000以内的素数为：");
//        primeNumber(1000);
//        System.out.println("1000以内的完数为：");
//        perfectNumber(1000);
//        System.out.println("1！+2！+3！+ …+n!≤9999,解得n为：");
//        factorial(9999);
        System.out.println("所有水仙花数为：");
        narciNum();
    }
}
