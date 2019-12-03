package io;

import org.junit.Test;

import java.io.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/3 19:08
 */
public class FileInputStreamTest {
    /**
     * FileInputStream
     */
    @Test
    public void test1() {
        try {
            //打印当前项目的绝对路径
            System.out.println(System.getProperty("user.dir"));
            //参数如果是相对路径，参照的是该项目下的相对路径
            File f = new File("src/io/file1.txt");
            System.out.println(f.exists());
            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileReader
     */
    @Test
    public void test2() {
        try {
            //???
            System.out.println(System.getProperty("user.dir"));
            //参数如果是相对路径，参照的是该项目下的相对路径
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileReader fileReader = new FileReader(f);
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fileReader.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BufferedInputStream
     */
    @Test
    public void test3() {
        try {
            System.out.println(System.getProperty("user.dir"));
            //参数如果是相对路径，参照的是该项目下的相对路径
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedInputStream bf = new BufferedInputStream(fileInputStream);

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bf.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
