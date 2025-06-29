package Library;

import java.util.ArrayList;

public class ViewBook implements Menu {

    @Override
    public void menuList(Database database, User user) {
        System.out.println("View Books");
        ArrayList<Book> books = database.getALLbooks();

        System.out.println("Name\tAuthor\tPublisher\tAddress\tStatus\tQty\tPrice");
        for (Book b : books) {
            System.out.println(
                b.getName() + "\t" +
                b.getAuther() + "\t" +
                b.getPublisher() + "\t" +
                b.getAddress() + "\t" +
                b.getStatus() + "\t" +
                b.getQty() + "\t" +
                b.getPrice()
            );
        }

        user.Menu(database, user);
    }

    @Override
    public void menuList() {}
}
