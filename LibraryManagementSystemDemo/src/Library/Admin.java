package Library;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        this.operations = new Menu[] {
            new AddBook(),
            new ViewBook(),
            new DeleteBook()
        };
    }

    public Admin(String name, String emailID, String phonenumbers) {
        super(name, emailID, phonenumbers);
        this.operations = new Menu[] {
            new AddBook(),
            new ViewBook(),
            new DeleteBook()
        };
    }

    @Override
    public void Menu(Database database, User user) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add books");
            System.out.println("2. View books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int n = s.nextInt();

            if (n >= 1 && n <= operations.length) {
                operations[n - 1].menuList(database, user);
            } else if (n == 4) {
                System.out.println("Exiting Admin menu...");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    public String toString() {
        return name + "<N/>" + emailID + "<N/>" + phonenumbers + "<N/>" + "Admin";
    }
}
