package library_management_system.database;

import library_management_system.classes.Record;
import library_management_system.classes.User;
import library_management_system.exception.NoBorrowedException;

import java.util.ArrayList;
import java.util.Iterator;
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

    public boolean contains(User currentUser, String ISBN) {
        for (Record record : recordList) {
            if (record.is(currentUser, ISBN)) {
                return true;
            }
        }
        return false;
    }

    public void putRecord(User currentUser, String ISBN) {
        recordList.add(new Record(currentUser.getId(), ISBN));
    }

    public void remove(User currentUser, String ISBN) throws NoBorrowedException {
//        boolean flag = false;
//        int index = 0;
//        for(Record record:recordList){
//            if(record.is(currentUser,ISBN)){
//                flag = true;
//                break;
//            }
//            index++;
//        }
//
//        if(flag == true){
//            Record record = recordList.get(index);
//            recordList.remove(record);
//        }
//        throw new NoBorrowedException();
        Iterator<Record> iterator = recordList.iterator();
        while (iterator.hasNext()) {
            Record record = iterator.next();
            if (record.is(currentUser, ISBN)) {
                iterator.remove();
                return;
            }
        }
        throw new NoBorrowedException();
    }

    public List<Record> queryRecord() {
        return new ArrayList<>(recordList);
    }
}
