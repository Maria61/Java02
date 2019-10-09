package practice_project.classes;

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

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
