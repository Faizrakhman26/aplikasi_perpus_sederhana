import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
