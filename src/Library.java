public class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Method 1 - Adding a book (refuses if full or if the ID already exists)
    public boolean addBook(Book book) {
        if (count == books.length) {
            System.out.println("The library is full");
            return false;
        }
        if (findBook(book.getId()) != null) {
            System.out.println("A book with this ID already exists");
            return false;
        }
        books[count] = book;
        count++;
        return true;
    }

    // Method 2 - Finding a book with its ID (returns null if not found)
    public Book findBook(String id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId().equals(id)) {
                return books[i];
            }
        }
        return null;
    }

    // Method 3 - Borrowing a book with its ID
    public boolean borrowBook(String id) {
        Book book = findBook(id);
        if (book == null) {
            System.out.println("Book not found");
            return false;
        }
        return book.borrowBook();
    }

    // Method 4 - Returning a book with its ID
    public boolean returnBook(String id) {
        Book book = findBook(id);
        if (book == null) {
            System.out.println("Book not found");
            return false;
        }
        return book.returnBook();
    }

    // Method 5 - Number of books currently stored
    public int getCount() {
        return count;
    }

    // Method 6 - Getting the book stored at a given position
    public Book getBookAt(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        return books[index];
    }

    // Method 7 - Counting the available books (uses a while loop)
    public int countAvailable() {
        int total = 0;
        int i = 0;
        while (i < count) {
            if (books[i].isAvailable()) {
                total++;
            }
            i++;
        }
        return total;
    }
}