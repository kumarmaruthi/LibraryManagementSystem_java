package Library;

public class User {
    protected String name;
    protected String emailID;
    protected String phonenumbers;
    protected Menu[] operations;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public User(String name, String emailID, String phonenumbers) {
        this.name = name;
        this.emailID = emailID;
        this.phonenumbers = phonenumbers;
    }

    public String getName() {
        return name;
    }

    public String getemailID() {
        return emailID;
    }

    public String getphonenumbers() {
        return phonenumbers;
    }

    public void Menu(Database database, User user) {
        // This method is meant to be overridden in Admin and NormalUser classes
    }
}
