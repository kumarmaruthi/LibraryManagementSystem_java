package Library;

import java.util.Scanner;

public class BorrowBook implements Menu {

    @Override
    public void menuList(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the book name:");
        String bookname = s.next();

        int i = database.getBook(bookname);
        if (i > -1) {
            Book book = database.getBook(i);
            if (book.getQty() > 0) {
                Borrowing borrowing = new Borrowing(book, user);
                book.setQty(book.getQty() - 1);
                database.BorrowBook(borrowing, book, i);
                System.out.println("Book borrowed for 14 days");
                System.out.println("Expiry date: " + borrowing.getfinish());
            } else {
                System.out.println("Book is not available");
            }
        } else {
            System.out.println("Book doesn't exist");
        }

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
