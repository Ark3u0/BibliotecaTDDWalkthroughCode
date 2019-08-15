package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class BibliotecaApp {

    private PrintStream out;

    public BibliotecaApp(final PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(new PrintStream(System.out));
        app.start();
    }

    public void start() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell", 1961));
        books.add(new Book("Crazy Rich Asians", "Kevin Kwan", 2017));
        books.add(new Book("Who Fears Death", "Nnedi Okorafor", 2001));

        out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.");
        listBooks(books);
    }

    public void listBooks(final List<Book> books) {
        for (Book book : books) {
            out.println(String.join(", ", book.getTitle(), book.getAuthor(), Integer.toString(book.getYear())));
        }
    }
}
