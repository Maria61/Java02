package practice_project.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:09
 */
public class Record {
    private String userId;
    private String bookISBN;
    private Date recordTime;

    public Record(String userId, String bookISBN) {
        this.bookISBN = bookISBN;
        this.userId = userId;
        this.recordTime = new Date();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getRecordTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return sdf.format(recordTime);
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public boolean is(User currentUser, String ISBN) {
        return userId.equals(currentUser.getId()) && bookISBN.equals(ISBN);
    }
}
