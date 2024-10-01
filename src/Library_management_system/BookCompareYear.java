package Library_management_system;

import java.util.Comparator;

public class BookCompareYear implements Comparator<Book>{
    @Override
    public int compare(Book b1, Book b2){
        return Integer.compare(b1.getPublication_year(), b2.getPublication_year());
    }
}
