package Library_management_system;

import java.util.ArrayList;


public class User {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
