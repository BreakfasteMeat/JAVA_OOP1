package Library_management_system;

import java.util.Comparator;

class BookCompareAuthor implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2){
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}
