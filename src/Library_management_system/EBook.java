package Library_management_system;

public class EBook extends Book {
    private final String link;
    public EBook(String name, String author, int publication_year, String link) {
        super(name, author, publication_year);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    @Override
    void printBook() {
        super.printBook();
        System.out.println("Link: " + link);
    }
}
