package Library;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static Database database = new Database();

    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System");

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int num = s.nextInt();

        switch (num) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void Login() {
        System.out.print("Enter phone number: ");
        String phonenumbers = s.next();
        System.out.print("Enter email ID: ");
        String emailID = s.next();
        int index = database.Login(phonenumbers, emailID);
        if (index != -1) {
            User user = database.getUser(index);
            System.out.println("Login successful. Welcome " + user.getName());
            user.Menu(database, user);
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    private static void Register() {
        System.out.print("Enter name: ");
        String name = s.next();
        System.out.print("Enter email ID: ");
        String emailID = s.next();
        System.out.print("Enter phone number: ");
        String phonenumbers = s.next();

        System.out.println("1. Admin");
        System.out.println("2. NormalUser");
        int choice = s.nextInt();

        User user;
        if (choice == 1) {
            user = new Admin(name);
        } else {
            user = new NormalUser(name, emailID, phonenumbers);
        }

        database.AddUser(user);
        System.out.println("Registration successful.");
        user.Menu(database, user);
    }
}
