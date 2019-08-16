package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private PrintStream out;
    private ScannerWrapper scanner;
    private List<Book> books;

    public BibliotecaApp(final PrintStream out, final ScannerWrapper scanner, final List<Book> books) {
        this.out = out;
        this.scanner = scanner;
        this.books = books;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell", 1961));
        books.add(new Book("Crazy Rich Asians", "Kevin Kwan", 2017));
        books.add(new Book("Who Fears Death", "Nnedi Okorafor", 2001));

        BibliotecaApp app = new BibliotecaApp(
                new PrintStream(System.out),
                new ScannerWrapper(),
                books);
        app.start();
    }

    public void start() {
        out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.");
        if (!scanner.nextLine().equals("2")) {
            listBooks(books);
        }
    }

    public void listBooks(final List<Book> books) {
        for (Book book : books) {
            out.println(book.toString());
        }
    }
}
