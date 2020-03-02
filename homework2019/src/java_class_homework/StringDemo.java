package java_class_homework;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/18 18:19
 */
public class StringDemo {
    public static String judgeIDNumber(String s){
        String year = s.substring(6,10);
        int month = Integer.valueOf(s.substring(10,12));
        int day = Integer.valueOf(s.substring(12,14));
        String sex = null;
        if(Integer.valueOf(s.substring(16,17)) % 2 == 0){
            sex = "女";
        }else{
            sex = "男";
        }
        return "此人是"+year+"年"+month+"月"+day+"日"+"出生,是"+sex+"性。";
    }
    public static void main(String[] args) {
        System.out.println(judgeIDNumber("632566199906216621"));
    }
}
