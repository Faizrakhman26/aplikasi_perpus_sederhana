public class EBook extends Book {

    // field ukuran(size) Ebook
    private double fileSizeMB;

    // konstruktor EBook
    public EBook(String title, String author, int year, double fileSizeMB) {
        super(title, author, year);
        this.fileSizeMB = fileSizeMB;
    }

    // method untuk mengambil nilai darifileSizeMB
    public double getFileSizeMB() {
        return fileSizeMB;
    }

    // method untuk mengatur nilai dari fileSizeMB
    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    // Override metode displayInfo untuk menampilkan informasi khusus EBook
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil metode displayInfo dari kelas Book
        System.out.println("File Size (MB)\t: " + fileSizeMB);
    }
}
