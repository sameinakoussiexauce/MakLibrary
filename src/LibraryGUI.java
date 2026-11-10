import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame implements ActionListener {

    private Library library;
    private JTextField idField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextArea displayArea;
    private JLabel messageLabel;

    public LibraryGUI(Library library) {
        this.library = library;

        setTitle("MakLibrary - Makerere University");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top part: the text fields
        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        fieldsPanel.add(new JLabel("Book ID:"));
        idField = new JTextField();
        fieldsPanel.add(idField);
        fieldsPanel.add(new JLabel("Title (only to add a book):"));
        titleField = new JTextField();
        fieldsPanel.add(titleField);
        fieldsPanel.add(new JLabel("Author (only to add a book):"));
        authorField = new JTextField();
        fieldsPanel.add(authorField);

        // Buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(createButton("Borrow", "borrow"));
        buttonsPanel.add(createButton("Return", "return"));
        buttonsPanel.add(createButton("Add book", "add"));

        // Put fields and buttons together at the top of the window
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(fieldsPanel, BorderLayout.NORTH);
        topPanel.add(buttonsPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        // Center: the list of books
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Bottom: the message line
        messageLabel = new JLabel("Welcome to MakLibrary");
        messageLabel.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        add(messageLabel, BorderLayout.SOUTH);

        displayBooks();
    }

    // Creates a button that calls this window when clicked
    private JButton createButton(String text, String command) {
        JButton button = new JButton(text);
        button.setActionCommand(command);
        button.addActionListener(this);
        return button;
    }

    // Shows all the books in the big text area
    private void displayBooks() {
        String text = "";
        for (int i = 0; i < library.getCount(); i++) {
            Book b = library.getBookAt(i);
            String status;
            if (b.isAvailable()) {
                status = "Available";
            } else {
                status = "Borrowed";
            }
            text += b.getId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | " + status + "\n";
        }
        text += "\nAvailable books: " + library.countAvailable() + " / " + library.getCount();
        displayArea.setText(text);
    }

    // Called automatically each time a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String id = idField.getText().trim();

        switch (command) {
            case "borrow":
                if (library.borrowBook(id)) {
                    messageLabel.setText("Book " + id + " borrowed successfully.");
                } else {
                    messageLabel.setText("Cannot borrow: book not found or already borrowed.");
                }
                break;

            case "return":
                if (library.returnBook(id)) {
                    messageLabel.setText("Book " + id + " returned successfully.");
                } else {
                    messageLabel.setText("Cannot return: book not found or not borrowed.");
                }
                break;

            case "add":
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
                    messageLabel.setText("Please fill the ID, the title and the author.");
                } else if (library.addBook(new Book(id, title, author))) {
                    messageLabel.setText("Book " + id + " added.");
                    titleField.setText("");
                    authorField.setText("");
                } else {
                    messageLabel.setText("Cannot add: library full or ID already used.");
                }
                break;

            default:
                break;
        }

        displayBooks();
    }
}