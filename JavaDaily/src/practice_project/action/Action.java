package practice_project.action;

import practice_project.classes.Book;
import practice_project.classes.User;
import practice_project.database.BookShelf;
import practice_project.database.RecordShelf;
import practice_project.exception.BorrowOutException;
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
            bookShelf.putbook(book);
            return book;
        }
    }
    /**
     * 查询图书
     */
    public static List<Book> qurryBook(){
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.qurryBook();
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
        recordShelf.putRecord();
        return book;
    }
}
