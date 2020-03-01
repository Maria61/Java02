package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/1 19:52
 */
public class SolutionDaily0301 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，
     * 句子中单词以单个空格符隔开，为简单起见，不带标点符号。
     * @param s
     * @return
     */
    public static String revers(String s){
        StringBuilder re = new StringBuilder();
        String[] stringArray = s.split(" ");
        for(int i = stringArray.length - 1; i >= 0; i--){
            re.append(stringArray[i]+" ");
        }
        String result = String.valueOf(re);
        return result.trim();
    }

    public static void  main1(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String re = revers(s);
        System.out.println(re);
    }

    /**
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 处理:
     * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；
     * (文件所在的目录不同，文件名和行号相同也要合并)
     * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * (如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
     * 3.输入的文件可能带路径，记录文件名称不能带路径
     * @param record
     * @return
     */
    public static String[] count(String[] record){
        HashMap<String,Integer> re = new HashMap<>();
        String[] result = null;
        for(int i = 0; i < record.length; i++){
            if(i >= 8){
                break;
            }
            String[] err = record[i].split(String.valueOf('\\'));
            String name = err[err.length - 1];
            String[] errs = name.split(" ");
            if(re.containsKey(name)){
                re.replace(name,re.get(name)+1);
            }else{
                re.put(name,1);
            }
        }
        result = new String[re.size()];
        int i = 0;
        for(Map.Entry<String,Integer> entry : re.entrySet()){
            String[] name = entry.getKey().split(" ");
            if(name[0].length() > 16){
                name[0] = name[0].substring(name[0].length() - 16);
            }
            String err = name[0]+name[1];
            result[i] = err + entry.getValue();
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] record = new String[8];
        int i = 0;
        while(sc.hasNext()){
            String s = sc.nextLine();
            record[i++] = s;
        }
        String[] result = count(record);
        for(String s : result){
            System.out.println(s);
        }
    }
}
