// A simple project of a Library Management System App using the Java Swing Framework
// Groupe 21

// Members:
// 1. Atugonza Elizabeth - Reg. No. 26/U/03492/PS
// 2. Ochen Felix - Reg. No. 25/U/26621
// 3. Oseku Silas (Group leader) - Reg. No. 26/U/03632/PS
// 4. Sameina Koussi Exaucé - Reg. No. 26/X/26375/PS
// 5. Turyasingura Eron Esther - Reg. No. 26/U/03663/PS

public class Main {
    public static void main(String[] args) {
        Library lib = new Library(10);

        lib.addBook(new Book("B001", "Java Programming", "Naomi"));
        lib.addBook(new Book("B002", "Python Basics", "Elena"));
        lib.addBook(new Book("B003", "Data Structures", "Adrian"));
        lib.addBook(new Book("B004", "Databases", "Okello"));
        lib.addBook(new Book("B005", "Web Development", "Nakato"));
        lib.addBook(new Book("B006", "Networks", "Mukasa"));

        lib.borrowBook("B002");   // already borrowed at the start

        LibraryGUI window = new LibraryGUI(lib);
        window.setVisible(true);
    }
}