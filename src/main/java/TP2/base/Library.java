package TP2.base;

import java.util.ArrayList;
import static GL.GL.*; // ✅ لإتاحة الألوان

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.print(GREEN + "\n\t Book added successfully : " + RESET);
        System.out.println(YELLOW + book.getTitle() + RESET + " by " + CYAN + book.getAuthor() + RESET);
    }

    public void removeBook(String ISBN) {
        boolean removed = books.removeIf(book -> book.getiSBN().equals(ISBN));
        if (removed) {
            System.out.println(RED + "\n\t Book removed successfully." + RESET);
        } else {
            System.out.println(RED + "\n\t Book with ISBN " + YELLOW + ISBN + RESET + " not found." + RESET);
        }
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(RED + "\t\tNo books available in the library." + RESET);
        } else {
            for (Book book : books) {
                System.out.println("\t\t" + book);
            }
        }
    }

    public void checkOutBook(String ISBN) {
        for (Book book : books) {
            if (book.getiSBN().equals(ISBN)) {
                int copies = book.getAvailableCopies();
                if (copies > 0) {
                    book.setAvailableCopies(copies - 1);
                    System.out.println(GREEN + "\n\t Book checked out successfully!" + RESET);
                    System.out.println("\t\tRemaining copies: " + YELLOW + book.getAvailableCopies() + RESET);
                } else {
                    System.out.println(RED + "\n\t No copies available for this book." + RESET);
                }
                return;
            }
        }
        System.out.println(RED + "\n\t Book with ISBN " + YELLOW + ISBN + RESET + " not found!" + RESET);
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getiSBN().equals(ISBN)) {
                int copies = book.getAvailableCopies();
                book.setAvailableCopies(copies + 1);
                System.out.println(GREEN + "\n\t Book returned successfully!" + RESET);
                System.out.println("\t\tTotal copies: " + YELLOW + book.getAvailableCopies() + RESET);
                return;
            }
        }
        System.out.println(RED + "\n\tBook with ISBN " + YELLOW + ISBN + RESET + " not found!" + RESET);
    }
}
