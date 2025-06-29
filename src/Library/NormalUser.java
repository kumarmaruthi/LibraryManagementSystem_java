package Library;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        this.operations = new Menu[] {
            new PlaceOrder(),
            new BorrowBook(),
            new ReturnBook()
        };
    }

    public NormalUser(String name, String emailID, String phonenumbers) {
        super(name, emailID, phonenumbers);
        this.operations = new Menu[] {
            new PlaceOrder(),
            new BorrowBook(),
            new ReturnBook()
        };
    }

    @Override
    public void Menu(Database database, User user) {
        System.out.println("1. Place Order");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n >= 1 && n <= operations.length) {
            this.operations[n - 1].menuList(database, user);
        } else {
            System.out.println("Invalid option");
        }
    }

    public String toString() {
        return name + "<N/>" + emailID + "<N/>" + phonenumbers + "<N/>" + "NormalUser";
    }
}
