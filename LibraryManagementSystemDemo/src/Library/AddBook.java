package Library;

import java.util.Scanner;

public class AddBook implements Menu {

    @Override
    public void menuList(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Please Enter Book Name:");
        String name = s.next();

        if (database.getBook(name) > -1) {
            System.out.println("There is already a book with this name!");
            user.Menu(database, user);
            return;
        }

        book.setName(name);

        System.out.println("Enter author:");
        book.setAuther(s.next());

        System.out.println("Enter publisher:");
        book.setPublisher(s.next());

        System.out.println("Enter address:");
        book.setAddress(s.next());

        System.out.println("Enter quantity:");
        book.setQty(s.nextInt());

        System.out.println("Enter price:");
        book.setPrice(s.nextDouble());

        database.Addbook(book);
        System.out.println("Book added successfully");

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
