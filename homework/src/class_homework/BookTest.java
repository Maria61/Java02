package class_homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 21:45
 */
public class BookTest {
    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter("book.txt"));
//        String str0 = "0,Java基础入门,传智播客高教产品研发部,清华大学出版社,44.5,425";
//        String str1 = "1,计算机操作系统,汤小丹,西安电子科技大学出版社,39,408";
//        String str2 = "2,人工智能导论,王万良,高等教育出版社,31,315";
//        String str3 = "3,计算机算法与设计,王晓东,电子工业出版社,38,306";
//        String str4 = "4,云计算,刘鹏,电子工业出版社,59,409";
//        String str5 = "5,离散数学,屈婉玲,清华大学出版社,39.9,344";
//        String str6 = "6,C和指针,徐波,人民邮电出版社,65,448";
//        String str7 = "7,冷场,李诞,四川文艺出版社,42,309";
//        String str8 = "8,人生,路遥,北京十月文艺出版社,20,225";
//        String str9 = "9,活着,余华,作家出版社,20,191";
//        String[] book = {str0,str1,str2,str3,str4,str5,str6,str7,str8,str9};
//        for(int i = 0; i < book.length; i++){
//            bw.write(book[i]);
//            bw.newLine();
//        }
//        bw.close();
//
//        System.out.println(Arrays.toString(Book.getNumByPress("电子工业出版社")));
//        System.out.println(Arrays.toString(Book.getInfoByISBN("1")));
        System.out.println(Book.statisticsBook(309));
    }
}
