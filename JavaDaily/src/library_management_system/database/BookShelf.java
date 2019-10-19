package library_management_system.database;

import library_management_system.classes.Book;
import library_management_system.exception.NoSuchBookException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:34
 */
public class BookShelf {
    private List<Book> bookList = new ArrayList<>();

    //饿汉模式
    private static BookShelf instance = new BookShelf();

    public static BookShelf getInstance() {
        return instance;
    }

    public Book search(String ISBN) throws NoSuchBookException {
        for (Book book : bookList) {
            if (book.is(ISBN)) {
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }


    public void putBook(Book book) {
        bookList.add(book);
    }

    public List<Book> queryBooks(Where<Book> Where) {
        List<Book> ret = new ArrayList<>();
        for (Book book : bookList) {
            if (Where == null || Where.test(book)) {
                ret.add(book);
            }
        }
        return ret;
    }
}
