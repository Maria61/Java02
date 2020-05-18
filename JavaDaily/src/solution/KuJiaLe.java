package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/5/18 19:13
 */
public class KuJiaLe {
    /**
     * 删除该目录及该目录下的所有文件
     * @param path
     * @return
     */
    public boolean isFile(String path){
        return false;
    }
    public String[] getChild(String path){
        return null;
    }
    public boolean deleteFile(String path){
        return false;
    }
    public boolean remove(String path){
        if(isFile(path) || getChild(path).length == 0){
            return deleteFile(path);
        }
        String[] children = getChild(path);
        boolean re = false;
        for(int i = 0; i < children.length; i++){
            re = remove(children[i]);
        }
        return re;
    }
    public static void main(String[] args) {

    }
}
