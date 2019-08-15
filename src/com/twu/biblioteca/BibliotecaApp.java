package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

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
        out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.");
    }

    public void listBooks(final List<String> titles) {
        for (String title : titles) {
            out.println(title);
        }
    }
}
