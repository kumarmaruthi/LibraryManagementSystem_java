package Library;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> booknames = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Borrowing> borrowings = new ArrayList<>();

    private File usersfile = new File("data/Users");
    private File booksfile = new File("data/Books");
    private File ordersfile = new File("data/Order");
    private File borrowingsfile = new File("data/borrowings");

    public Database() {
        if (!usersfile.exists()) usersfile.mkdirs();
        if (!booksfile.exists()) booksfile.mkdirs();
        if (!ordersfile.exists()) ordersfile.mkdirs();
        if (!borrowingsfile.exists()) borrowingsfile.mkdirs();
        getUser();
        getBook();
        getOrder();
        getBorrowing();
    }

    private void getUser() {
        String text = readFile(usersfile);
        if (!text.isEmpty()) {
            String[] entries = text.split("<NewUser/>");
            for (String entry : entries) {
                String[] data = entry.split("<N/>");
                if (data.length >= 4) {
                    User user = data[3].equals("Admin") ?
                        new Admin(data[0], data[1], data[2]) :
                        new NormalUser(data[0], data[1], data[2]);
                    AddUser(user);
                }
            }
        }
    }

    private void saveUser() {
        StringBuilder text = new StringBuilder();
        for (User user : users) {
            text.append(user.toString()).append("<NewUser/>\n");
        }
        writeFile(usersfile, text.toString());
    }

    private void getBook() {
        String text = readFile(booksfile);
        if (!text.isEmpty()) {
            String[] entries = text.split("<NewBook/>");
            for (String entry : entries) {
                Book book = parseBook(entry);
                books.add(book);
                booknames.add(book.getName());
            }
        }
    }

    private void saveBooks() {
        StringBuilder text = new StringBuilder();
        for (Book book : books) {
            text.append(book.toString2()).append("<NewBook/>\n");
        }
        writeFile(booksfile, text.toString());
    }

    private void getOrder() {
        String text = readFile(ordersfile);
        if (!text.isEmpty()) {
            String[] entries = text.split("<NewOrders/>");
            for (String entry : entries) {
                orders.add(parseOrder(entry));
            }
        }
    }

    private void saveOrder() {
        StringBuilder text = new StringBuilder();
        for (Order order : orders) {
            text.append(order.toString2()).append("<NewOrders/>\n");
        }
        writeFile(ordersfile, text.toString());
    }

    private void getBorrowing() {
        String text = readFile(borrowingsfile);
        if (!text.isEmpty()) {
            String[] entries = text.split("<NewBorrowing/>");
            for (String entry : entries) {
                borrowings.add(parseBorrowing(entry));
            }
        }
    }

    private void saveBorrowing() {
        StringBuilder text = new StringBuilder();
        for (Borrowing b : borrowings) {
            text.append(b.getStart2()).append("<NewBorrowing/>\n");
        }
        writeFile(borrowingsfile, text.toString());
    }

    private String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return sb.toString();
    }

    private void writeFile(File file, String content) {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print(content);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public void AddUser(User user) {
        users.add(user);
        usernames.add(user.getName());
        saveUser();
    }

    public int Login(String phonenumbers, String emailID) {
        for (User u : users) {
            if (u.getphonenumbers().equals(phonenumbers) && u.getemailID().equals(emailID)) {
                return users.indexOf(u);
            }
        }
        return -1;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public ArrayList<Book> getALLbooks() {
        return books;
    }

    public int getBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public Book parseBook(String s) {
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setName(a[0]);
        book.setAuther(a[1]);
        book.setPublisher(a[2]);
        book.setAddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        return book;
    }

    public void Addbook(Book book) {
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }

    public void DeleteBook(int i) {
        books.remove(i);
        booknames.remove(i);
        saveBooks();
    }

    public void addOrders(Order order, Book book, int bookindex) {
        orders.add(order);
        books.set(bookindex, book);
        saveOrder();
        saveBooks();
    }

    public Order parseOrder(String s) {
        String[] a = s.split("<N/>");
        return new Order(books.get(getBook(a[0])), getUserByName(a[1]), Double.parseDouble(a[2]), Integer.parseInt(a[3]));
    }

    private User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) return user;
        }
        return new NormalUser("");
    }

    public void BorrowBook(Borrowing b, Book book, int bookindex) {
        borrowings.add(b);
        books.set(bookindex, book);
        saveBorrowing();
        saveBooks();
    }

    public Borrowing parseBorrowing(String s) {
        String[] a = s.split("<N/>");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(a[0], formatter);
        LocalDate finish = LocalDate.parse(a[1], formatter);
        Book book = books.get(getBook(a[3]));
        User user = getUserByName(a[4]);
        return new Borrowing(start, finish, 0, book, user);
    }

    public ArrayList<Borrowing> getBrws() {
        return borrowings;
    }

    public void returnBook(Borrowing b, Book book, int bookindex) {
        borrowings.remove(b);
        books.set(bookindex, book);
        saveBorrowing();
        saveBooks();
    }
}
