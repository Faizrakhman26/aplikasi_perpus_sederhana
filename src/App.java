import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // memuat(load) semua data buku
        library.loadBooks();

        boolean exit = false;
        while (!exit) {
            // Daftar menu pilihan
            System.out.println("Menu:");
            System.out.println("1. Lihat Data Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Tambah EBook");
            System.out.println("4. Update Buku/EBook");
            System.out.println("5. Hapus Buku/EBook");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu : ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            // fungsi dari menu
            switch (choice) {
                case 1:
                    // untuk menampilkan semua daftar buku
                    System.out.println("Daftar Buku di Perpustakaan: \n");
                    library.displayBooks();
                    System.out.println("\n");
                    break;

                case 2:
                    // untuk menginputkan data buku baru
                    System.out.print("Masukkan judul buku  : ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(title, author, year);
                    library.addBook(newBook);
                    System.out.println("Buku berhasil ditambahkan!");
                    System.out.println("\n");
                    break;

                case 3:
                    // Untuk menginputkan data buku elektronik baru
                    System.out.print("Masukkan judul EBook\t: ");
                    String ebookTitle = scanner.nextLine();
                    System.out.print("Masukkan nama penulis EBook\t: ");
                    String ebookAuthor = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit EBook\t: ");
                    int ebookYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan ukuran file EBook (MB)\t: ");
                    double fileSizeMB = scanner.nextDouble();
                    scanner.nextLine();

                    EBook newEBook = new EBook(ebookTitle, ebookAuthor, ebookYear, fileSizeMB);
                    library.addEBook(newEBook);
                    System.out.println("EBook berhasil ditambahkan!");
                    System.out.println("\n");
                    break;

                case 4:
                    // Mengupdate data buku
                    System.out.print("Masukkan ID buku yang ingin diupdate: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nMasukkan judul baru\t: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Masukkan nama penulis baru\t: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit baru\t: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();

                    Book bookToUpdate = library.findBookById(idToUpdate);
                    if (bookToUpdate != null) {
                        if (bookToUpdate instanceof EBook) {
                            System.out.print("Masukkan ukuran file EBook baru (MB)\t: ");
                            double newFileSizeMB = scanner.nextDouble();
                            scanner.nextLine();
                            library.updateEBook(idToUpdate, newTitle, newAuthor, newYear, newFileSizeMB);
                        } else {
                            library.updateBook(idToUpdate, newTitle, newAuthor, newYear);
                        }
                        System.out.println("\nBuku berhasil diupdate!\n");
                    } else {
                        System.out.println("Buku dengan ID tersebut tidak ditemukan.\n");
                    }
                    break;

                case 5:
                    // untuk menghapus data buku
                    System.out.print("Masukkan ID buku yang ingin dihapus: ");
                    int IdToRemove = scanner.nextInt();
                    library.removeBook(IdToRemove);
                    System.out.println("Buku berhasil dihapus!");
                    System.out.println("\n");
                    break;

                case 6:
                    // Keluar dari program
                    exit = true;
                    System.out.println("Terima kasih!\n");
                    break;

                default:
                    // Jika pilihan tidak valid
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.\n");
            }

        }
        // menyimpan semua data buku
        library.saveBooks();

        scanner.close();

    }
}
