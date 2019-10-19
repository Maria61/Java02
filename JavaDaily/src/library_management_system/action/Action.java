package library_management_system.action;

import library_management_system.classes.Book;
import library_management_system.classes.Record;
import library_management_system.classes.User;
import library_management_system.database.BookShelf;
import library_management_system.database.RecordShelf;
import library_management_system.database.Where;
import library_management_system.exception.BorrowOutException;
import library_management_system.exception.NoBorrowedException;
import library_management_system.exception.NoSuchBookException;
import library_management_system.exception.YetBorrowedException;

import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 20:42
 */
public class Action {
    /**
     * 图书上架
     * @param ISBN
     * @param name
     * @param author
     * @param price
     * @param count
     * @return
     */
    public static Book putBook(String ISBN, String name, String author, double price, int count) {
        //单例模式
        BookShelf bookShelf = BookShelf.getInstance();
        try {
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;

        } catch (NoSuchBookException exc) {
            Book book = new Book(ISBN, name, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }
    /**
     * 查询图书
     */
    public static List<Book> queryBooks() {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(null);
    }

    public static List<Book> queryBooksByWhere(Where<Book> where) {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(where);
    }

    public static List<Book> queryBooksByName(Where<Book> where) {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(where);
    }
    /**
     * 借阅图书
     * @param currentUser
     * @param ISBN
     * @return
     */
    public static Book borrowBook(User currentUser, String ISBN) throws NoSuchBookException, BorrowOutException, YetBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        if(book.getCurrentCount() <= 0){
            throw new BorrowOutException();
        }
        if(recordShelf.contains(currentUser,ISBN)){
            throw new YetBorrowedException();
        }
        book.borrowBook();
        recordShelf.putRecord(currentUser, ISBN);
        return book;
    }

    public static Book returnBook(User currentUser, String ISBN) throws NoSuchBookException, NoBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        recordShelf.remove(currentUser, ISBN);
        book.returnBook();
        return book;
    }

    /**
     * 查询借阅记录
     *
     * @return
     */
    public static List<Record> queryRecords() {
        RecordShelf recordShelf = RecordShelf.getInstance();
        return recordShelf.queryRecord();
    }



}
