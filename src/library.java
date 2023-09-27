import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Kelas dasar untuk buku
class Book {
    private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // tampilkan data buku
    public void displayInfo() {
        System.out.println("ID\t: " + id);
        System.out.println("Title\t: " + title);
        System.out.println("Author\t: " + author);
        System.out.println("Year\t: " + year);
    }
}

// Kelas perpustakaan
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // fungsi untuk menambahkan buku
    public void addBook(Book book) {
        books.add(book);
    }

    // fungsi untuk menampilkan data buku
    public void displayBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("---------------------------");
        }
    }

    // fungsi untuk menghapus buku
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        saveBooks();
    }

    // fungsi untuk mengupdate data buku
    public void updateBook(int id, String newTitle, String newAuthor, int newYear) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setYear(newYear);
                saveBooks();
            }
        }
    }

    // fungsi untuk meng-load data buku
    void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    Book book = new Book(title, author, year);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // fungsi untuk meng-save data buku
    void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                String line = book.getTitle() + "," + book.getAuthor() + "," + book.getYear();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
