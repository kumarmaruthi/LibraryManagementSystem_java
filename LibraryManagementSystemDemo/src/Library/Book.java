package Library;

public class Book {
    private String name;
    private String auther;
    private String publisher;
    private String address;
    private String status;
    private int qty;
    private double price;

    public Book() {}

    public Book(String name, String auther, String publisher, String address, String status, int qty, double price) {
        this.name = name;
        this.auther = auther;
        this.publisher = publisher;
        this.address = address;
        this.status = status;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Book Name: " + name + "\n" +
               "Author: " + auther + "\n" +
               "Publisher: " + publisher + "\n" +
               "Address: " + address + "\n" +
               "Quantity: " + qty + "\n" +
               "Price: " + price;
    }

    public String toString2() {
        return name + "<N/>" + auther + "<N/>" + publisher + "<N/>" +
               address + "<N/>" + qty + "<N/>" + price;
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

    public int indexOf(Book book) {
        return 0;
    }
}
