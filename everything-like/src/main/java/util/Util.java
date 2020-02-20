package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/12 23:30
 */
public class Util {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String parseSize(Long size) {
        String[] danweis = {"B","KB","MB","GB","PB","TB"};
        int index = 0;
        while(size > 1024 && index < danweis.length - 1){
            size /= 1024;
            index++;
        }
        return size +danweis[index];
    }

    public static String parseDate(Date lastModified) {
        return new SimpleDateFormat(DATE_PATTERN).format(lastModified);
    }


    public static void main(String[] args) {

    }
}
