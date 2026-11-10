# MakLibrary

A simple Library Management System built with Java and the Swing framework.
Practical Exam Project for **CSC 1102: Structured and Object-Oriented Programming**,
Makerere University.

## Group 21
1. Atugonza Elizabeth - Reg. No. 26/U/03492/PS
2. Ochen Felix - Reg. No. 25/U/26621
3. Oseku Silas (Group leader) - Reg. No. 26/U/03632/PS
4. Sameina Koussi Exaucé - Reg. No. 26/X/26375/PS
5. Turyasingura Eron Esther - Reg. No. 26/U/03663/PS

## What it does
- Shows the list of books with their status (Available or Borrowed)
- Borrows and returns a book using its ID
- Adds a new book to the catalogue
- Refuses invalid actions (unknown ID, book already borrowed, duplicate ID, full shelf)

## Classes
| Class | Purpose |
|---|---|
| `Book` | One book: ID, title, author, availability |
| `Library` | Stores the books in an array and manages them |
| `LibraryGUI` | The Swing window |
| `Main` | Starts the program with six starting books |

## How to run
1. Clone or download this repository.
2. Open it in IntelliJ IDEA or Visual Studio Code with JDK 21.
3. Run the class `Main`. (All the .java files are in the src part)

Lecturer: Dr. Lillian Muyama
