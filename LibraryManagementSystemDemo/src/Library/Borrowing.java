package Library;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Borrowing {
    LocalDate start;
    LocalDate finish;
    int daysleft;
    Book book;
    User user;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Borrowing(Book book, User user) {
        start = LocalDate.now();
        finish = start.plusDays(14);
        daysleft = Period.between(start, finish).getDays();
        this.book = book;
        this.user = user;
    }

    public Borrowing(LocalDate start, LocalDate finish, int daysleft, Book book, User user) {
        this.start = start;
        this.finish = finish;
        this.daysleft = Period.between(finish, LocalDate.now()).getDays();
        this.book = book;
        this.user = user;
    }

    public String getStart() {
        return formatter.format(start);
    }

    public String getfinish() {
        return formatter.format(finish);
    }

    public int getdaysLeft() {
        return Period.between(finish, LocalDate.now()).getDays();
    }

    public Book getbook() {
        return book;
    }

    public void setbook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public String toString() {
        return "Borrowing time: " + start + "\n" +
               "Expiry date: " + finish + "\n" +
               "Days left: " + daysleft;
    }

    public String getStart2() {
        return getStart() + "<N/>" +
               getfinish() + "<N/>" +
               getdaysLeft() + "<N/>" +
               book.getName() + "<N/>" +
               user.getName() + "<N/>";
    }
}
