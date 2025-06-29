package Library;

import java.util.Scanner;

public class DeleteBook implements Menu {

    @Override
    public void menuList(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the book name:");
        String bookname = s.next();

        int i = database.getBook(bookname);
        if (i > -1) {
            database.DeleteBook(i);
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("Book doesn't exist");
        }

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
