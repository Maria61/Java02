package task;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/12 16:03
 */

import java.io.File;
import java.net.URL;

/**
 * 1.初始化数据库
 * 2.并读取sql文件
 * 3.执行sql语句来初始化表
 */
public class DBInit {

    //获取target编译文件夹的路径
    //通过classLoader.getResource()/classLoader.getResourceAsStream()这样的方法

    public static void init(){
        //获取target编译文件夹的路径
        URL classUrl = DBInit.class.getClassLoader().getResource("./");
        String dir = new File(classUrl.getPath()).getParent();
        String url = "jdbc:sqlite://" + dir + File.separator + "everything-like.db";
        System.out.println(url);
    }

    public static void main(String[] args) {
        init();
    }
}
