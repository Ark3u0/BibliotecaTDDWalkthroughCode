package com.twu.biblioteca;

import java.io.PrintStream;

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
        this.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.");
    }
}
