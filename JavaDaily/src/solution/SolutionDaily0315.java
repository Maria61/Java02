package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/16 18:06
 */
public class SolutionDaily0315 {
    /**
     * 一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计
     * 成与自己公司名字相对应。例如公司的Help Desk号码是4357，因为4对应H、3对应E、
     * 5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
     *
     * @param array
     * 每组数据第一行包含一个正整数n（1≤n≤1024）。
     * 紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
     * 没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。
     * @return 对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。
     * 每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
     */
    public static ArrayList<String> trueNum(ArrayList<String> array){
        String[] nineGrids = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        ArrayList<String> res = new ArrayList<>();
        for(String s : array){
            String re = new String();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    re += String.valueOf(s.charAt(i));
                }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    for(int j = 0; j < nineGrids.length; j++){
                        if(nineGrids[j].contains(String.valueOf(s.charAt(i)))){
                            re += String.valueOf(j+2);
                        }
                    }
                }
            }
            re = re.substring(0,3)+"-"+re.substring(3);
            if(!res.contains(re)){
                res.add(re);
            }

        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            ArrayList<String> array = new ArrayList<>();
            int n = sc.nextInt();
            sc.nextLine();
            while(n > 0){
                String s = sc.nextLine();
                array.add(s);
                n--;
            }
            ArrayList<String> re = trueNum(array);
            for(String sa : re){
                System.out.println(sa);
            }
            System.out.println();
        }
    }
}
