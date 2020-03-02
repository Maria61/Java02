package java_experiment.n3.e12;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/7 15:06
 */
public class Test {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(1999,12,12);
        Staff s = new Staff("职工1","SUST" ,"12335435","4636@qq.com",
                "404",3000,myDate,myDate,"5","经理");
        System.out.println(s.toString());
        
    }
}
