import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private int stock;

    public Book(String title, String author, String ISBN, double price, int stock) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean borrowBook() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println();
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.print();
                return book;
            }
        }
        System.out.println("Book not found!");
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.print();
                return book;
            }
        }
        System.out.println("Book not found!");
        return null;
    }

    public void borrowBook(String title) {
        Book book = searchByTitle(title);
        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.borrowBook()) {
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println("Out of stock!");
        }
    }
}

public class LibrarySystemMain {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Java Basics", "John Smith", "111", 15.5, 3));
        lib.addBook(new Book("OOP Design", "Alice Brown", "222", 20.0, 2));
        lib.addBook(new Book("Java Basics", "David Lee", "333", 18.0, 1));
        System.out.println("Search by title:");
        lib.searchByTitle("Java Basics");
        System.out.println("Search by author:");
        lib.searchByAuthor("Alice Brown");
        lib.borrowBook("OOP Design");
        lib.borrowBook("OOP Design");
        lib.borrowBook("OOP Design");
    }
}
