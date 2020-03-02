package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 15:11
 */
public class MyInteger {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven(){
        return (value%2 == 0);
    }

    public boolean isOdd(){
        return (value%2 != 0);
    }

    public boolean isPrime(){
        for(int  i = 2; i < Math.sqrt(value); i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }

    public boolean equals(int x){
        return value == x;
    }

    public int parseInt(String x){
        int n = 0;
        for(int i = 0; i < x.length(); i++) {

            n = n * 10 + (x.charAt(i)-'0');
//            System.out.println(x.charAt(i));
        }
        return n;
    }
}
