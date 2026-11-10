// Library Management System - MakLibrary

public class Book   {

    //  Attributes
    private String id;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(String id, String title, String author)     {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters for all attributes

    public String getId()   {
        return id;
    }
    public String getTitle()    {
        return title;
    }
    public String getAuthor()   {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Methods
    public boolean borrowBook() {
        if ( !available)    {
            System.out.println("The book is not available");
            return false;
        }
        System.out.println("Book borrowed");
        available = false;
        return true;
    }

    public boolean returnBook()     {
        if (available)      {
            System.out.println("This book was not borrowed");
            return false;
        }
        System.out.println("Book returned");
        available = true;
        return true;
    }
}