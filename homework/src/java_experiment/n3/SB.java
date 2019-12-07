package java_experiment.n3;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/7 15:21
 */
public class SB extends SA{
    @Override
    public int f(int a,int b){
        int num = maxDivisor(a,b);
        return (a*b)/num;
    }

    private int maxDivisor(int a, int b) {

        while(a%b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
