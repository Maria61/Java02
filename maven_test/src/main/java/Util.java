package maven_test.src.main.java;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

/**
 * @author Maria
 * @program maven_test
 * @date 2019/12/27 10:02
 */
public class Util {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
//        PinyinHelper.toHanyuPinyinStringArray('a',null);
//        //在target下找指定文件
//        System.out.println(Util.class.getClassLoader().getResource(
//                "test.txt").getPath());


        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] pinyins = PinyinHelper.toHanyuPinyinStringArray('a',format);
        String[] pinyins2 = PinyinHelper.toHanyuPinyinStringArray('只',format);
        String[] pinyins3 = PinyinHelper.toHanyuPinyinStringArray('和',format);
        System.out.println(Arrays.toString(pinyins));
        System.out.println(Arrays.toString(pinyins2));
        System.out.println(Arrays.toString(pinyins3));

        char[] inputs = "中华人名共和国".toCharArray();
        for(char input:inputs){

        }

        //inputs  char[] --> String[][]
        //String[][] 转换为拼音的排列组合，Set<String>
    }
}
