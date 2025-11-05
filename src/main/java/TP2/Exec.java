package TP2;

import static GL.GL.*;
import java.util.Scanner;
import TP2.base.Book;
import TP2.base.Library;
import UTILS.EXEC;
import UTILS.TP;

public class Exec implements EXEC {

 
    private void pause(Scanner scanner) {
        System.out.println(BLUE + "\n\tPress " + YELLOW + "[Enter]" + BLUE + " to continue..." + RESET);
        scanner.nextLine();
    }


    private void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {

        clearScreen();
        TP tp2 = new TP(2, "Software Engineering – Practical Work", () -> {

            System.out.println();
            System.out.println(BOLD + "\t\tTopic: Library Management System" + RESET);
            System.out.println();
            System.out.println(GREEN + "\t[1] Objective:" + RESET);
            System.out.println("\t\tCreate a Java program for managing a library's book inventory.");
            System.out.println("\t\tThe system allows adding, removing, displaying, checking out, and returning books.");
            System.out.println();

            System.out.println(GREEN + "\t[2] Class Design:" + RESET);
            System.out.println("\t\tWe define a class named " + YELLOW + "Book" + RESET + " that represents each book with:");
            System.out.println("\t\t- Title");
            System.out.println("\t\t- Author");
            System.out.println("\t\t- ISBN");
            System.out.println("\t\t- Available copies");
            System.out.println();

            System.out.println(GREEN + "\t[3] Library Management:" + RESET);
            System.out.println("\t\tA class named " + YELLOW + "Library" + RESET + " manages a collection of books and includes methods to:");
            System.out.println("\t\t\t1. Add a new book");
            System.out.println("\t\t\t2. Remove a book by ISBN");
            System.out.println("\t\t\t3. Display all books");
            System.out.println("\t\t\t4. Check out a book (decrease copies)");
            System.out.println("\t\t\t5. Return a book (increase copies)");
            System.out.println();

            System.out.println(GREEN + "\t[4] User Interface:" + RESET);
            System.out.println("\t\tWe create a simple text-based menu allowing users to:");
            System.out.println("\t\t\t1. Add new books");
            System.out.println("\t\t\t2. Remove existing books");
            System.out.println("\t\t\t3. Check out a book");
            System.out.println("\t\t\t4. Return a book");
            System.out.println("\t\t\t5. View all available books");
            System.out.println();

            System.out.println(GREEN + "\t[5] Error Handling:" + RESET);
            System.out.println("\t\tThe program handles invalid inputs or unavailable books safely.");
            System.out.println("\t\tFor example, it prevents checking out a book with no available copies.");
            System.out.println();

            System.out.println(GREEN + "\t[6] Testing Phase:" + RESET);
            System.out.println("\t\tTo ensure correctness, we test the program by adding, removing, and checking out books.");
            System.out.println("\t\tThis confirms that all library operations function properly.");
            System.out.println();

            System.out.println(MAGENTA + "\t\tNow let's run the interactive console program to simulate library management."
                    + RESET);

            pause(new Scanner(System.in));
            clearScreen();

            // 🧩 تشغيل النظام التفاعلي
            Library library = new Library();
            Scanner scanner = new Scanner(System.in);
            int choice;

            try {
                do {
                    System.out.println(BOLD + CYAN + "\n\t--- Library Menu ---\n" + RESET);
                    System.out.println(YELLOW + "\t1." + RESET + " Add Book");
                    System.out.println(YELLOW + "\t2." + RESET + " Remove Book");
                    System.out.println(YELLOW + "\t3." + RESET + " Check Out Book");
                    System.out.println(YELLOW + "\t4." + RESET + " Return Book");
                    System.out.println(YELLOW + "\t5." + RESET + " Display Books");
                    System.out.println(YELLOW + "\t0." + RESET + " Exit");
                    System.out.print(BLUE + "\n\tEnter your choice: " + RESET);

                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            clearScreen();
                            System.out.println(GREEN + "\n\t[ Add New Book ]" + RESET);
                            System.out.print("\n\tTitle: ");
                            String title = scanner.nextLine();
                            System.out.print("\tAuthor: ");
                            String author = scanner.nextLine();
                            System.out.print("\tISBN: ");
                            String ISBN = scanner.nextLine();
                            System.out.print("\tAvailable copies: ");
                            int copies = scanner.nextInt();
                            scanner.nextLine();

                            library.addBook(new Book(title, author, ISBN, copies));

                            delay(600);
                            pause(scanner);
                            clearScreen();
                            break;

                        case 2:
                            clearScreen();
                            System.out.println(GREEN + "\n\t[ Remove Book ]\n" + RESET);
                            System.out.print("\tEnter ISBN to remove: ");
                            ISBN = scanner.nextLine();
                            library.removeBook(ISBN);

                            delay(600);
                            pause(scanner);
                            clearScreen();
                            break;

                        case 3:
                            clearScreen();
                            System.out.println(GREEN + "\n\t[ Check Out Book ]\n" + RESET);
                            System.out.print("\tEnter ISBN to check out: ");
                            ISBN = scanner.nextLine();
                            library.checkOutBook(ISBN);

                            delay(600);
                            pause(scanner);
                            clearScreen();
                            break;

                        case 4:
                            clearScreen();
                            System.out.println(GREEN + "\n\t[ Return Book ]\n" + RESET);
                            System.out.print("\tEnter ISBN to return: ");
                            ISBN = scanner.nextLine();
                            library.returnBook(ISBN);

                            delay(600);
                            pause(scanner);
                            clearScreen();
                            break;

                        case 5:
                            clearScreen();
                            System.out.println(CYAN + "\n\t[ Library Inventory ]\n" + RESET);
                            library.displayBooks();

                            pause(scanner);
                            clearScreen();
                            break;

                        case 0:
                            clearScreen();
                            System.out.println(MAGENTA + "\tThank you for using the Library Management System!" + RESET);
                            delay(1000);
                            break;

                        default:
                            clearScreen();
                            System.out.println(YELLOW + "\tInvalid choice. Please try again." + RESET);
                            delay(800);
                            pause(scanner);
                            clearScreen();
                    }

                } while (choice != 0);
            } catch (Exception e) {
                System.out.println(RED + "\n\tAn error occurred: " + e.getMessage() + RESET);
            }

            System.out.println(BOLD + GREEN
                    + "\n\t[ End of Practical Work 2 ] – All requirements implemented successfully."
                    + RESET);
            System.out.println(MAGENTA
                    + "\tThis exercise demonstrates good practice in object-oriented design, modularity, and user interaction."
                    + RESET);

        });

        tp2.run();
    }
}
