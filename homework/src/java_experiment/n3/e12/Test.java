package java_experiment.n3.e12;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/7 15:06
 */
public class Test {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(1999,12,12);
        Staff s = new Staff("404",2400,myDate,myDate,"10","经理");
        System.out.println(s.toString());
        
    }
}
