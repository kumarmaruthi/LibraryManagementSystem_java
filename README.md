# LibraryManagementSystem_java
java
# 📚 Library Management System (Java)

This is a **Java-based Library Management System** that simulates basic library operations for both Admin and Normal Users.

---

## 🔧 How to Install Java (Windows / Linux / macOS)

### 📦 Step 1: Download Java
- Go to: https://www.oracle.com/java/technologies/javase-downloads.html  
- Download **Java SE Development Kit (JDK)** version 8 or above.

### 💻 Step 2: Install Java
- Run the installer and follow the instructions.
- Set JAVA_HOME environment variable (Optional but recommended)

### ✅ Step 3: Verify Java Installation
Open Command Prompt or Terminal and run:
```bash
java -version
```
You should see something like:
```
java version "1.8.0_281"
```

---

## 📁 Project Structure

```
LibraryManagementSystem/
├── src/
│   └── Library/
│       ├── Main.java
│       ├── Database.java
│       ├── Books.java
│       ├── User.java
│       ├── Admin.java
│       ├── NormalUser.java
│       ├── Menu.java
│       ├── AddBook.java
│       ├── ViewBook.java
│       ├── DeleteBook.java
├── data/
│   ├── Users        # User data saved here
│   ├── Books        # Book data saved here
├── README.md
```

---

## 🚀 Features

- 👤 **User Registration & Login**
- 🔐 Role-based access:
  - **Admin:** Add / View / Delete books
  - **Normal User:** Place Order, Borrow, Return books
- 📁 **Data Storage** using local text files
- 🧠 Object-Oriented Design (Inheritance, Abstraction, Encapsulation)

---

## 📦 How to Run This Project

### 1. Clone this Repository
```bash
git clone https://github.com/your-username/LibraryManagementSystem.git
cd LibraryManagementSystem
```

### 2. Open in IDE (Eclipse / IntelliJ IDEA)
- File > Open Project > Select this folder
- Make sure JDK is installed and configured

### 3. Compile & Run
- Run `Main.java` as Java Application
- Follow on-screen menu

---

## ✍ Sample Console Output

```
Welcome to Library Management System

1] Login
2] Register
3] Exit
> 2

Enter name: Alice
Enter email ID: alice@gmail.com
Enter phone number: 9876543210
1. Admin
2. NormalUser
> 1

Registration successful!
Admin Menu
1. Add books
2. View books
3. Delete Book
```

---

## 🧱 Technologies Used

- Java (Core Java)
- Java File I/O (BufferedReader, PrintWriter)
- Eclipse or IntelliJ IDEA
- Git & GitHub

---

## 🔮 Future Enhancements

- ✅ GUI using Swing / JavaFX
- ✅ Due dates & fine calculation
- ✅ Integration with database (MySQL, SQLite)
- ✅ Export reports to CSV/PDF

---

## 🙋‍♂️ Author

- Developed by: **Your Name**
- GitHub: [https://github.com/your-username](https://github.com/your-username)

---

## 📄 License

This project is licensed under the **MIT License**.
