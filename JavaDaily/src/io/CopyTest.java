package io;

import org.junit.Test;

import java.io.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/3 20:36
 */
public class CopyTest {
    //图片压缩包之类的用字节流
    //文本类型的用字符流
    @Test
    public void test1() {
        try {
            FileInputStream fileInputStream = null;
            BufferedInputStream bfi = null;
            FileOutputStream fileOutputStream = null;
            BufferedOutputStream bfo = null;
            try {
                fileInputStream = new FileInputStream("E:/miaosha.zip");
                bfi = new BufferedInputStream(fileInputStream);
                File dest = new File("E:\\learningcode\\Java02\\JavaDaily/src/io/mioashaCopy.zip");
                fileOutputStream = new FileOutputStream(dest);
                bfo = new BufferedOutputStream(fileOutputStream);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = bfi.read(bytes)) != -1) {
                    bfo.write(bytes, 0, len);
                }
            } finally {
                if (bfi != null) {
                    bfi.close();
                }
                if (bfo != null) {
                    bfo.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
