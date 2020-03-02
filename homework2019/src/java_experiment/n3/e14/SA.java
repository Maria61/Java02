package java_experiment.n3.e14;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/27 21:40
 */

public class SA {
    public int f(int l,int b){
        return Math.max(l,b);
    }


}
class SB extends SA{
    @Override
    public int f(int l,int b){
        int x = g(l,b);
        return (l*b)/x;
    }


    public int g(int l,int b){
        if(l<b){
            int t = l;
            l = b;
            b = t;
        }
        if(l%b != 0){
            return g(b,l%b);
        }

        return b;
    }
}

