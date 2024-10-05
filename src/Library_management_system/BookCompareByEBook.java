package Library_management_system;

import java.util.Comparator;

public class BookCompareByEBook implements Comparator<Book>{
	@Override
	public int compare(Book o1, Book o2){
		int o1IsEbook;
		int o2IsEbook;
		if(o1 instanceof EBook){
			o1IsEbook = 1;
		} else {
			o1IsEbook = 0;
		}
		if(o2 instanceof  EBook){
			o2IsEbook = 1;
		} else {
			o2IsEbook = 0;
		}
		int ret = o1IsEbook - o2IsEbook;
		if(ret == 0){
			ret = o1.getName().compareTo(o2.getName());
		}
		return ret;
	}

}
