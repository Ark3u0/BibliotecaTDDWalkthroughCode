package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void shouldPrintABookTitleWhenIStartTheApp() {
        List<String> titles = new ArrayList<String>();

        String expected = "1984";

        titles.add(expected);

        app.listBooks(titles);

        String output = outputStream.toString();
        List<String> books = Arrays.asList(output.split("\n"));

        assertThat(books, is(titles));
    }

    @Test
    public void shouldPrintTwoBookTitlesWhenIStartTheApp() {
        List<String> titles = new ArrayList<String>();

        String expected = "Crazy Rich Asians";
        String expected2 = "Who Fears Death";

        titles.add(expected);
        titles.add(expected2);

        app.listBooks(titles);

        String output = outputStream.toString();
        List<String> books = Arrays.asList(output.split("\n"));

        assertThat(books, is(titles));
    }
}