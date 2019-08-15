package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        app = new BibliotecaApp(out);
    }

    @Test
    public void shouldShowWelcomeMessageWhenIStartTheApp() {
        app.start();

        String expected = "Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.";

        String output = outputStream.toString();
        String[] lines = output.split("\n");

        assertThat(lines[0], is(expected));
    }

    @Test
    public void shouldPrintTwoBookTitlesWhenIStartTheApp() {
        List<Book> books = new ArrayList<>();
        List<String> titles = new ArrayList<String>();

        Book book = new Book("Crazy Rich Asians", "Kevin Kwan", 2017);
        Book book2 = new Book("Who Fears Death", "Nnedi Okorafor", 2001);
        String expected = "Crazy Rich Asians";
        String expected2 = "Who Fears Death";

        books.add(book);
        books.add(book2);
        titles.add(expected);
        titles.add(expected2);

        app.listBooks(books);

        String output = outputStream.toString();
        List<String> writtenBooks = asList(output.split("\n"));

        assertThat(writtenBooks, is(
                asList(
                        String.join(", ",
                                book.getTitle(),
                                book.getAuthor(),
                                Integer.toString(book.getYear())),
                        String.join(", ",
                                book2.getTitle(),
                                book2.getAuthor(),
                                Integer.toString(book2.getYear()))
                        )
        ));
    }

    @Test
    public void shouldPrintBookWithTitleAuthorAndYearWhenIListBooks() {
        List<Book> books = new ArrayList<Book>();

        Book expectedBook = new Book("1984", "George Orwell", 1961);

        books.add(expectedBook);

        app.listBooks(books);

        String output = outputStream.toString();
        List<String> booksWritten = asList(output.split("\n"));

        assertThat(booksWritten, is(
                singletonList(
                        String.join(", ",
                                expectedBook.getTitle(),
                                expectedBook.getAuthor(),
                                Integer.toString(expectedBook.getYear())))
        ));
    }
}