package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/6/21 20:53
 */
public class HengSheng {
    /**
     * 将只含有数字和大写字母的字符串转换为只含有大写字母的字符串，要求转换后的字符串可以再转换回来
     * @param s
     * @return
     */
    public static String change(String s){
        char[] ss = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                ss[i] = (char)('A'+i);
            }
        }
        String re = String.valueOf(ss);
        return re;
    }
    public static void main(String[] args){
        String s = change("A1SD3Q");
        System.out.println(s);
    }




}
