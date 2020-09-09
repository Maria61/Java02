import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maria
 * @program compilation_principle_experiment
 * @date 2020/9/9 9:20
 */
public class WorldAnalyse {

    //存储单词符号和种别编码
    public Map<String,String> map1;

    //构造函数初始化
    WorldAnalyse() {
        map1=new HashMap<String,String>();
        map1.put("if","1");
        map1.put("then","2");
        map1.put("begin","3");
        map1.put("end","4");
        map1.put("do","5");
        map1.put("while","6");
        map1.put("标识符","7");
        map1.put("常数","8");
        map1.put("+","9");
        map1.put("-","10");
        map1.put("*","11");
        map1.put("/","12");
        map1.put("=","13");
        map1.put(">","20");
        map1.put("<","21");
        map1.put(",","14");
        map1.put(";","15");
        map1.put("(","16");
        map1.put(")","17");
        map1.put("{","18");
        map1.put("}","19");
    }
    public static void main(String[] args) throws Exception {
        int i =0,j=0;
        String strToken ="";//存储从strTest分离出来的关键字、标识符、常数、运算符、界符
        String strTest ="";//存储从文件里面读来的一行代码
        char ch ;//用来存储从strTest中分离出来的单个字符
        WorldAnalyse worldAnalyse = new WorldAnalyse();
        File file = new File("E:\\2020class\\编译原理\\ex1.txt");//创建要访问的文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((strTest = bufferedReader.readLine()) != null)//读取文件的一行
        {
            System.out.println("第"+(++j)+"行分析结果：");
            strToken="";
            ch=' ';
            //找到该行中第一个不是空的字符的位置
            for (i = 0; i < strTest.length(); i++) {
                if (strTest.charAt(i) != ' ') {
                    ch = strTest.charAt(i);
                    break;
                }
            }
            //标识符和关键字的判断
            while (i < strTest.length()) {
                //判断该字符是否为字母
                if (Character.isLetter(ch)) {
                    //该循环用于分离第一个字符为字母后续若干字母或者数字的字符串
                    while (Character.isLetter(ch) || Character.isDigit(ch)) {
                        strToken += Character.toString(ch);
                        //判断该行是否还有字符
                        if ((++i) < strTest.length()) {
                            ch = strTest.charAt(i);
                        } else {
                            //该行没有下一个字符的话终止循环进行下一行的分析
                            i = strTest.length();
                            break;
                        }
                    }
                    //判断为关键字
                    if (worldAnalyse.map1.containsKey(strToken)) {
                        System.out.println("("+worldAnalyse.map1.get(strToken)+","+strToken+")");
                    }
                    else//判断为标识符
                    {
                        System.out.println("("+worldAnalyse.map1.get("标识符")+","+strToken+")");
                    }
                    ch = ' ';
                    strToken = "";
                }
                //常数的判断
                else if (Character.isDigit(ch)) {//判断该字符是否为数字
                    while (Character.isDigit(ch)) {//连续读取若干数字
                        strToken += Character.toString(ch);
                        //判断该行是否结束
                        if (++i < strTest.length()) {
                            ch = strTest.charAt(i);
                        } else {
                            //该行结束的话终止循环进行下一行的分析
                            i = strTest.length();
                            break;
                        }
                    }
                    System.out.println("("+worldAnalyse.map1.get("常数")+","+strToken+")");
                    strToken = "";
                    ch = ' ';
                }
                //运算符和界符的判断
                else if (worldAnalyse.map1.containsKey(Character.toString(ch))) {
                    strToken=Character.toString(ch);
                    System.out.println("("+worldAnalyse.map1.get(strToken)+","+strToken+")");
                    strToken = "";
                    ch = ' ';
                    //判断该行是否结束
                    if (++i < strTest.length()) {
                        ch = strTest.charAt(i);
                    } else {
                        //该行结束的话终止循环进行下一行的分析
                        i = strTest.length();
                        break;
                    }
                }
                //不合法输入
                else {
                    System.out.println("("+"不合法符号"+","+ch+")");
                    strToken="";
                    ch=' ';
                    //判断该行是否结束
                    if (++i < strTest.length()) {
                        ch = strTest.charAt(i);
                    } else {
                        //该行结束的话终止循环进行下一行的分析
                        i = strTest.length();
                        break;
                    }
                }
                //找到下一个不为空的字符的位置
                for (; i < strTest.length(); i++) {
                    if (strTest.charAt(i) != ' ') {
                        ch = strTest.charAt(i);
                        break;
                    }
                }
            }
        }
        //关闭文件读取
        bufferedReader.close();
    }
}
