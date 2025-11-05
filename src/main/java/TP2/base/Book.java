package TP2.base;

import static GL.GL.CYAN;
import static GL.GL.GREEN;
import static GL.GL.MAGENTA;
import static GL.GL.RESET;
import static GL.GL.YELLOW;

public class Book {
    private String title;
    private String author;
    private String iSBN;
    private int availableCopies;

    public Book() {
    }

    public Book(String title, String author, String iSBN, int availableCopies) {
        this.title = title;
        this.author = author;
        this.iSBN = iSBN;
        this.availableCopies = availableCopies;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String getiSBN() {
        return iSBN;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%-30s%s | Author: %s%-20s%s | ISBN: %s%-15s%s | Copies Available: %s%d%s",
                YELLOW, title, RESET,
                CYAN, author, RESET,
                GREEN, iSBN, RESET,
                MAGENTA, availableCopies, RESET);
    }

}
