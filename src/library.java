import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Kelas Library
class Library {
    // field buku
    private List<Book> books;

    // kostruktor library
    public Library() {
        books = new ArrayList<>();
    }

    // method untuk menambah buku
    public void addBook(Book book) {
        books.add(book);
    }

    // method untuk menambah EBook
    public void addEBook(EBook ebook) {
        books.add(ebook);
    }

    // method untuk menampilkan EBook
    public void displayEBooks() {
        for (Book book : books) {
            if (book instanceof EBook) {
                book.displayInfo();
                System.out.println("---------------------------");
            }
        }
    }

    // method untuk menampilak buku
    public void displayBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("---------------------------");
        }
    }

    // method untuk menghapus buku
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        saveBooks();
    }

    // method untuk mencari untuk id buku
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(int idToUpdate, String newTitle, String newAuthor, int newYear) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == idToUpdate) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setYear(newYear);

                saveBooks();
                return;
            }
        }
    }

    public void updateEBook(int idToUpdate, String newTitle, String newAuthor, int newYear, double newFileSizeMB) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book instanceof EBook && book.getId() == idToUpdate) {
                EBook ebook = (EBook) book;
                ebook.setTitle(newTitle);
                ebook.setAuthor(newAuthor);
                ebook.setYear(newYear);
                ebook.setFileSizeMB(newFileSizeMB);

                saveBooks();
                return;
            }
        }
    }

    // method untuk memuat (load) data semua buku
    void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String type = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    int year = Integer.parseInt(parts[3]);

                    if ("Cetak".equals(type)) {
                        Book book = new Book(title, author, year);
                        books.add(book);
                    } else if ("EBook".equals(type) && parts.length == 5) {
                        double fileSizeMB = Double.parseDouble(parts[4]);
                        EBook ebook = new EBook(title, author, year, fileSizeMB);
                        books.add(ebook);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method untuk menyimpan (save) data semua buku
    void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                if (book instanceof EBook) {
                    EBook ebook = (EBook) book;
                    writer.write("EBook," + ebook.getTitle() + "," + ebook.getAuthor() + "," + ebook.getYear() + ","
                            + ebook.getFileSizeMB());
                } else if (book instanceof Book) {
                    writer.write("Cetak," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
