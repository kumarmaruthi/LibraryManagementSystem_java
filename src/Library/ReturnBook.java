package Library;

import java.util.Scanner;

public class ReturnBook implements Menu {

    @Override
    public void menuList(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name:");
        String bookname = s.next();

        if (database.getBrws() != null) {
            for (Borrowing b : database.getBrws()) {
                if (b.getbook().getName().equals(bookname) && b.getUser().getName().equals(user.getName())) {
                    Book book = b.getbook();
                    int i = database.getALLbooks().indexOf(book);
                    if (b.getdaysLeft() > 0) {
                        System.out.println("You are late!");
                        System.out.println("You have to pay a fine of ₹" + Math.abs(b.getdaysLeft() * 50));
                    }
                    book.setQty(book.getQty() + 1);
                    database.returnBook(b, book, i);
                    System.out.println("Book returned successfully");
                    break;
                } else {
                    System.out.println("You did not borrow this book");
                }
            }
        } else {
            System.out.println("No borrowings found");
        }

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
