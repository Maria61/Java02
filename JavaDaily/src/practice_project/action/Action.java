package practice_project.action;

import practice_project.classes.Book;
import practice_project.database.BookShelf;
import practice_project.exception.NoSuchBookException;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 20:42
 */
public class Action {
    public static Book putBook(String ISBN, String name, String author, double price, int count) {
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

}
