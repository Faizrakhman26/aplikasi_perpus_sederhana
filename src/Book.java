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