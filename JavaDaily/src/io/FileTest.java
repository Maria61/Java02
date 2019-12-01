package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/1 16:20
 */
public class FileTest {
    @Test
    public void test1() throws IOException {
        File file = new File("E:/learningcode/Java02/JavaDaily/src/io/file1.txt");
        System.out.println(file.exists());
        File file1 = new File("E:/learningcode/Java02/JavaDaily/src/io/file1.txt");
        file1.createNewFile();

//        File d = new File("E:/learningcode/Java02/JavaDaily/src");
//        for(File f : d.listFiles()){
//            System.out.println(f.getPath());
//        }
        File f = new File("E:/learningcode/Java02/JavaDaily/src");
        List<File> l = listFiles(f);
//        l.stream().forEach(System.out::println);
        l.stream().forEach((file2) -> {
            System.out.println(f);
        });
    }

    public List<File> listFiles(File file) {
        List<File> list = new ArrayList<>();
        list.add(file);
//        System.out.println(file.getPath());
        if (file.isDirectory()) {
            //listFiles
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    list.addAll(listFiles(f));
                } else {
                    list.add(f);
//                    System.out.println(f.getPath());
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {

        test3();
    }

    public static void test3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            System.out.println(i);
        }
    }
}
