package solution;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/11 15:10
 */
public class YouZan0911 {
    /**
     * 将CSV文件里的（除第一行外的每行，第一行为key）值替换到字符串（如果不存在某个key，则被替换的字符串对应的key的值替换为空字符串）
     * @param csv string字符串一维数组 从CSV文件提取的字符串数组，其中数组的第一个元素为CSV文件的第一行（也就是key），其余元素为剩下的行（也就是value）
     * @param targetStr string字符串 被替换的字符串
     * @return string字符串一维数组
     */
    public static String[] replaceFromCSV (String[] csv, String targetStr) {
        // write code here
        String[] re = new String[csv.length - 1];
        String[] s = csv[0].split(",");
        boolean flag = false;
        String[] paramsA = new String[csv.length - 1];
        String[] paramsB = new String[csv.length - 1];
        if(s.length == 1){
            flag = true;
        }

        for(int i = 1,j = 0; i < csv.length; i++,j++){
            String ss = csv[i];
            if(flag == false){
                String[] pas = csv[i].split(",");
                paramsA[j] = pas[0];
                paramsB[j] = pas[1];
            }else{
                if(csv[0].equals("paramsA")){
                    paramsA[j] = csv[i];
                }else{
                    paramsB[j] = csv[i];
                }
            }
        }
        for(int i = 0; i < re.length; i++){
            if(flag == false){
                String r = targetStr.replace("${paramsA}",paramsA[i]);
                r = r.replace("${paramsB",paramsB[i]);
                re[i] = r;
            }else{
                if(csv[0].equals("paramsA")){
                    String r = targetStr.replace("${paramsA}",paramsA[i]);
                    r = r.replace("${paramsB}","");
                    re[i] = r;
                }else{
                    String r = targetStr.replace("${paramsB}",paramsB[i]);
                    r = r.replace("${paramsA}","");
                    re[i] = r;
                }
            }
        }
        return re;
    }
    public static void main(String[] args) {
        String[] ss = {"paramsA,paramsB", "value12","value22","value32"};
        String s  = "https://test.youzan.com/api?paramsA=${paramsA}&paramsB=${paramsB}";
        System.out.println(Arrays.toString(replaceFromCSV(ss,s)));
    }
}
