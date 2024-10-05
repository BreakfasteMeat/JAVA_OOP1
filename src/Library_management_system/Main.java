package Library_management_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library cebu_provincial_library = new Library("Cebu Provincial Library");

        char op,sort_choice,isEBook;
        Scanner sc = new Scanner(System.in);
        String name;
        String author;
        String link;
        int year, index_no, count;

        do{
            System.out.print("Op: ");
            op = sc.next().charAt(0);
            switch (op){
                case 'a':
                    sc.nextLine();
                    System.out.print("Enter book Title: ");
                    name = sc.nextLine();
                    System.out.print("Enter book author: ");
                    author = sc.nextLine();
                    System.out.print("Enter year of publication: ");
                    year = sc.nextInt();
                    System.out.print("Is EBook?[y/n]: ");
                    isEBook = sc.next().charAt(0);
                    sc.nextLine();
                    if(isEBook == 'y' || isEBook == 'Y') {
                        System.out.print("Enter EBook link: ");
                        link = sc.nextLine();
                        cebu_provincial_library.addEBook(name, author, year, link);
                    } else {
                        cebu_provincial_library.addBook(name,author,year);
                    }
                    break;
                case 'p':
                    cebu_provincial_library.listBooks();
                    break;
                case 'r':
                    sc.nextLine();
                    System.out.print("Enter book name to remove: ");
                    name = sc.nextLine();
                    index_no = cebu_provincial_library.removeBook(name);
                    if(index_no >= 0) System.out.println("Removed " + name);
                    else System.out.println(name + " is not found");
                    break;
                case 'R':
                    sc.nextLine();
                    System.out.println("Enter author name to remove: ");
                    author = sc.nextLine();
                    count = cebu_provincial_library.removeBooksWithAuthor(author);
                    if(count > 0) System.out.println("Removed " + (count) + " books");
                    else System.out.println("No books written by " + author);
                    break;
                case 's':
                    sc.nextLine();
                    System.out.print("Enter if sort by name, author, or year of publication [n,a,y]: ");
                    sort_choice = sc.next().charAt(0);
                    cebu_provincial_library.chooseSort(sort_choice);
                    break;
                case 'Y':
                    sc.nextLine();
                    System.out.print("Enter year to sort: ");
                    year = sc.nextInt();
                    cebu_provincial_library.sortYearWeird(year);
                    break;
                case 'h':
                    sc.nextLine();
                    cebu_provincial_library.sortByEBook();
                    break;

            }
        }while(op != 'x');
        sc.close();
    }
}