package practice_project.classes;

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
    private int count;
    private int records;

    public Book(String ISBN, String name, String author, double price, int count) {
        this.ISBN = ISBN;
        this.author = author;
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public static boolean is(String ISBN) {
        return ISBN.equals(ISBN);
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public void increaseCount(int count) {
        this.count += count;
    }
}
