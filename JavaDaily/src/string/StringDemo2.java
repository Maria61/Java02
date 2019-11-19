package string;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/19 19:13
 */
public class StringDemo2 {
    /**
     * String 的不可变特性！！！
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hel";
        String s3 = "lo";
        String s4 = s2 + s3;//jvm不会自动优化
        String s5 = "hel" + "lo";//jvm自动优化
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);


    }
}
