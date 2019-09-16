package string;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 20:37
 */
public class StringDemo {
    public static void main(String[] args) {
//        String p = "aaa";
//        String q = "aaa";
//        System.out.println(p == q);//true  同一对象，“aaa”在常量池里
//        System.out.println(p.equals(q));//true 值相等
//        String o = new String("aaa");
//        System.out.println(p == o);//false  不同对象,o的对象不在常量池中
//        System.out.println(p.equals(o));//true 值相等
////        o.intern();//手动加入到常量池中
        StringBuilder sb = new StringBuilder("bbb");
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        System.out.println(sb);


    }
}
