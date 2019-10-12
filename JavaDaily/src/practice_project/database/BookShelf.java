package practice_project.database;

import practice_project.classes.Book;
import practice_project.exception.NoSuchBookException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:34
 */
public class BookShelf {
    private List<Book> bookList = new ArrayList<>();

    //单例模式
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
        throw new NoSuchBookException("该书不存在");
    }


    public void putbook(Book book) {
        bookList.add(book);
    }
}
