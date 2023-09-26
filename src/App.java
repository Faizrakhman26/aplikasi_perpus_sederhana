import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        library.loadBooks();

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Update Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu : ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");

            switch (choice) {
                case 1:
                    System.out.println("Daftar Buku di Perpustakaan: \n");
                    library.displayBooks();
                    System.out.println("\n");
                    break;
                case 2:
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
                    System.out.print("Masukkan ID buku yang ingin dihapus: ");
                    int IdToRemove = scanner.nextInt();
                    library.removeBook(IdToRemove);
                    System.out.println("Buku berhasil dihapus!");
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.print("Masukkan ID buku yang ingin diupdate: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan judul baru: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Masukkan nama penulis baru: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit baru: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();

                    library.updateBook(idToUpdate, newTitle, newAuthor, newYear);
                    System.out.println("Buku berhasil diupdate!");
                    System.out.println("\n");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Terima kasih!");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    System.out.println("\n");
            }
        }
        library.saveBooks();

        scanner.close();

    }
}