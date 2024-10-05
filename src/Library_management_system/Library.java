package Library_management_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Library {
    private final String name;
    private final ArrayList<Book> bookList;

    public Library(String name) {
        this.name = name;
        this.bookList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void addBook(String name, String author, int publication_year){
        Book book = new Book(name,author,publication_year);
        bookList.add(book);
    }
    public void addEBook(String name, String author, int publication_year, String link){
        Book book = new EBook(name,author,publication_year,link);
        bookList.add(book);

    }
    public void listBooks(){
        System.out.println(name+" Catalogue");
        for(Book i : bookList){
            System.out.println("|==============================================|");
            i.printBook();
            System.out.println("|==============================================|");
        }
    }
    public int removeBook(String name){
        int index = -1;
        int counter = 0;
        for(Book i : bookList){
            //System.out.println("Comparing: " + name + i.getName());
            if(i.getName().equals(name)){
                index = counter;
                bookList.remove(i);
                break;
            }
            counter++;
        }
        return index;
    }
    public int removeBooksWithAuthor(String author){
        int counter = 0;
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()){
            Book i = it.next();
            if(i.getAuthor().equals(author)){
                counter++;
                it.remove();
            }
        }
        return counter;
    }

    public void chooseSort(char choice){
        switch(choice){
            case 'n':
                Collections.sort(bookList);
                break;
            case 'a':
                BookCompareAuthor AuthorSort = new BookCompareAuthor();
                bookList.sort(AuthorSort);
                break;
            case 'y':
                BookCompareYear YearSort = new BookCompareYear();
                bookList.sort(YearSort);
                break;
        }
    }
    public void sortYearWeird(int year){
        BookCompareWithYear BY = new BookCompareWithYear(year);
        bookList.sort(BY);
    }
    public void sortByEBook(){
        BookCompareByEBook BY = new BookCompareByEBook();
        bookList.sort(BY);
    }

}
