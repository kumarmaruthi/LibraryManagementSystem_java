package Library;

import java.util.Scanner;

public class PlaceOrder implements Menu {

    @Override
    public void menuList(Database database, User user) {
        Order order = new Order();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the book name:");
        String bookname = s.next();

        int i = database.getBook(bookname);
        if (i <= -1) {
            System.out.println("Book doesn't exist");
        } else {
            Book book = database.getBook(i);
            order.setBook(book);
            order.setUser(user);

            System.out.println("Enter quantity:");
            int qty = s.nextInt();
            order.setQty(qty);
            order.setPrice(book.getPrice() * qty);

            int bookindex = database.getBook(book.getName());
            book.setQty(book.getQty() - qty);

            database.addOrders(order, book, bookindex);
            System.out.println("Order placed successfully");
        }

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
