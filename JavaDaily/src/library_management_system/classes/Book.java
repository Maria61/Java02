package library_management_system.classes;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:08
 */
public class Book {
    private String ISBN;
    private String name;
    private String author;
    private double price;
    /**
     * 图书总数
     */
    private int totalCount;
    /**
     * 当前数量
     */
    private int currentCount;
    /**
     * 借阅次数
     */
    private int borrowCount;

    public Book(String ISBN, String name, String author, double price, int count) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.price = price;
        this.totalCount = count;
        this.currentCount = count;
        this.borrowCount = 0;
    }

    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public String getISBN() {
        return ISBN;
    }



    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }



    public double getPrice() {
        return price;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int getBorrowCount() {
        return borrowCount;
    }


    public void increaseCount(int count) {
        currentCount += count;
        totalCount += count;
    }

    public void borrowBook() {
        currentCount--;
        borrowCount++;
    }

    public void returnBook() {
        currentCount++;
    }
}
