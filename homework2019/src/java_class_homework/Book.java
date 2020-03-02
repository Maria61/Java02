package java_class_homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 21:28
 */
public class Book {
    /**
     * 根据出版社查找书籍数量和总价
     * @param press
     * @return
     * @throws IOException
     */
    static double[] getNumByPress(String press) throws IOException {
        double[] result = new double[2];
        BufferedReader br = new BufferedReader(new FileReader("book.txt"));
        String str;
        int n = 0;
        double p = 0;
        while((str=br.readLine()) != null){
            String[] info = str.split(",");
            if(info[3].equals(press)){
                n++;
                p += Double.valueOf(info[4]);
            }
        }
        result[0] = n;
        result[1] = p;
        br.close();
        return result;
    }

    /**
     * 根据书号查找书名，作者，出版社
     * @param ISBN
     * @return
     * @throws IOException
     */
    static String[] getInfoByISBN(String ISBN) throws IOException {
        String[] result = new String[3];
        BufferedReader br = new BufferedReader(new FileReader("book.txt"));
        String str;
        while((str=br.readLine()) != null){
            String[] info = str.split(",");
            if(info[0].equals(ISBN)){
                result[0] = info[1];
                result[1] = info[2];
                result[2] = info[3];
                break;
            }
        }
        br.close();
        return result;
    }

    static int statisticsBook(int page) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("book.txt"));
        String str;
        int result = 0;
        while((str=br.readLine()) != null){
            String[] info = str.split(",");
            if(Integer.valueOf(info[5]) >= page){
                result++;
            }
        }
        br.close();
        return result;
    }

}
