package Library_management_system;

import java.util.Comparator;

public class BookCompareWithYear implements Comparator<Book> {
	int year;

	public BookCompareWithYear(int year){
		this.year = year;
	}

	@Override
	public int compare(Book b1, Book b2){
		int b1_difference = year - b1.getPublication_year();
		int b2_difference = year - b2.getPublication_year();
		int ret = Integer.compare(Math.abs(b1_difference),Math.abs(b2_difference));
		if(ret == 0){
			ret = Integer.compare(b1.getPublication_year(),b2.getPublication_year());
		}
		return ret;
	}
}
