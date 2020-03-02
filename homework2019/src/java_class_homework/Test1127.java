package java_class_homework;

import java.io.*;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/27 15:42
 */
public class Test1127 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\learningcode\\Java02\\homework\\src\\java_class_homework\\java1127\\student.txt"),
                "UTF-8");
        BufferedReader read = new BufferedReader(isr);
        System.out.println(read.readLine());
    }
}
