import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
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

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println();
    }
}

class EBook extends Book {
    private double fileSizeMB;

    public EBook(String title, String author, String ISBN, double fileSizeMB) {
        super(title, author, ISBN);
        this.fileSizeMB = fileSizeMB;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public void display() {
        System.out.println("EBook Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("File Size: " + fileSizeMB);
        System.out.println();
    }
}

class PrintedBook extends Book {
    private int numPages;

    public PrintedBook(String title, String author, String ISBN, int numPages) {
        super(title, author, ISBN);
        this.numPages = numPages;
    }

    public int getNumPages() {
        return numPages;
    }

    @Override
    public void display() {
        System.out.println("Printed Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Number of Pages: " + numPages);
        System.out.println();
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    
    public void addBook(Book b) {
        books.add(b);
    }

    public void printAllBooks() {
        for (Book b : books) {
            b.display();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new EBook("Java Basics", "Alice", "111", 5.2));
        lib.addBook(new PrintedBook("OOP Design", "Bob", "222", 350));
        lib.addBook(new Book("Algorithms", "Charlie", "333"));
        lib.printAllBooks();
    }
}
