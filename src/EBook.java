public class EBook extends Book {
    private double fileSizeMB;

    public EBook(String title, String author, int year, double fileSizeMB) {
        super(title, author, year);
        this.fileSizeMB = fileSizeMB;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

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
