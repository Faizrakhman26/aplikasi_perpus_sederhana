class Book {

    // field buku
    private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private int year;

    // konstruktor buku
    public Book(String title, String author, int year) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(int id2, String newTitle, String newAuthor, int newYear) {
    }

    // method untuk mengambil nilai dari Id
    public int getId() {
        return id;
    }

    // method untuk mengambil data dari Title
    public String getTitle() {
        return title;
    }

    // Method untuk Mengambil data dari Author
    public String getAuthor() {
        return author;
    }

    // method untuk mengambil data dari Year
    public int getYear() {
        return year;
    }

    // method untuk mengatur nilai(data) dari Title
    public void setTitle(String title) {
        this.title = title;
    }

    // method untuk mengatur nilai(data) dari Author
    public void setAuthor(String author) {
        this.author = author;
    }

    // method untuk mengatur nilai(data) dari Year
    public void setYear(int year) {
        this.year = year;
    }

    // Method untuk menampilkan data buku
    public void displayInfo() {
        System.out.println("ID\t: " + id);
        System.out.println("Title\t: " + title);
        System.out.println("Author\t: " + author);
        System.out.println("Year\t: " + year);
    }
}