package practice_project.action;

import practice_project.classes.Book;
import practice_project.classes.Record;
import practice_project.classes.User;
import practice_project.database.BookShelf;
import practice_project.database.RecordShelf;
import practice_project.database.Where;
import practice_project.exception.BorrowOutException;
import practice_project.exception.NoBorrowedException;
import practice_project.exception.NoSuchBookException;
import practice_project.exception.YetBorrowedException;

import java.util.ArrayList;
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
