package practice_project.database;

import practice_project.classes.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:34
 */
public class RecordShelf {
    private List<Record> recordList = new ArrayList<>();

    private static RecordShelf instance = new RecordShelf();

    public static RecordShelf getInstance() {
        return instance;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
