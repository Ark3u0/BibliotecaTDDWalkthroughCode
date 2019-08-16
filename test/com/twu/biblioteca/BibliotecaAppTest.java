package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ByteArrayOutputStream outputStream;
    private PrintStream mockPrintStream;
    private ScannerWrapper mockScannerWrapper;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        mockPrintStream = mock(PrintStream.class);
        mockScannerWrapper = mock(ScannerWrapper.class);

        when(mockScannerWrapper.nextLine()).thenReturn("2");

    }

    @Test
    public void shouldShowWelcomeMessageWhenIStartTheApp() {
        app = new BibliotecaApp(mockPrintStream, mockScannerWrapper, emptyList());

        when(mockScannerWrapper.nextLine()).thenReturn("2");

        app.start();

        String expected = "Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.";

        verify(mockPrintStream).println(expected);
    }

    @Test
    public void shouldPrintTwoBookTitlesWhenIStartTheApp() {
        List<Book> books = new ArrayList<>();

        Book book = new Book("Crazy Rich Asians", "Kevin Kwan", 2017);
        Book book2 = new Book("Who Fears Death", "Nnedi Okorafor", 2001);

        books.add(book);
        books.add(book2);

        app = new BibliotecaApp(mockPrintStream, mockScannerWrapper, books);

        app.listBooks(books);

        verify(mockPrintStream).println(book.toString());
        verify(mockPrintStream).println(book2.toString());
    }

    @Test
    public void shouldPrintBookWithTitleAuthorAndYearWhenIListBooks() {
        List<Book> books = new ArrayList<Book>();

        Book expectedBook = new Book("1984", "George Orwell", 1961);

        books.add(expectedBook);

        app = new BibliotecaApp(mockPrintStream, mockScannerWrapper, books);

        app.listBooks(books);

        verify(mockPrintStream).println(expectedBook.toString());
    }

    @Test
    public void shouldNotListBooksWhen2IsEnteredAsInput() {
        when(mockScannerWrapper.nextLine()).thenReturn("2");

        List<Book> books = new ArrayList<Book>();

        Book expectedBook = new Book("1984", "George Orwell", 1961);

        books.add(expectedBook);

        app = new BibliotecaApp(mockPrintStream, mockScannerWrapper, books);

        app.start();

        verify(mockPrintStream, never()).println(expectedBook.toString());

    }

    @Test
    public void shouldNotListBooksWhen1IsEnteredAsInput() {
        when(mockScannerWrapper.nextLine()).thenReturn("1");

        List<Book> books = new ArrayList<Book>();

        Book expectedBook = new Book("1984", "George Orwell", 1961);

        books.add(expectedBook);

        app = new BibliotecaApp(mockPrintStream, mockScannerWrapper, books);

        app.start();

        verify(mockPrintStream).println(expectedBook.toString());

    }
}