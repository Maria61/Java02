package task;

import java.io.File;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/14 11:53
 */
public interface ScanCallback {

    //对于文件夹的扫描任务进行回调：处理文件夹，将文件夹下一级的子文件夹及子文件存入数据库
    void callback(File dir);

}
