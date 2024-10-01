package Library_management_system;

public class Book implements Comparable<Book>{
    private final String name;
    private final String author;
    private final int publication_year;

    public Book(String name, String author, int publication_year) {
        this.name = name;
        this.author = author;
        this.publication_year = publication_year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    void printBook(){
        System.out.print(name + " by " + author);
        System.out.println(" Published: " + publication_year);
    }

    @Override
    public int compareTo(Book b){
        return this.name.compareTo(b.name);
    }
}
