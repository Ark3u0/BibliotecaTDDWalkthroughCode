package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() 
    {
        outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        app = new BibliotecaApp(out);
    }

    @Test
    public void shouldShowWelcomeMessageWhenIStartTheApp() {
        app.start();

        String expected = "Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.\n";
        assertThat(outputStream.toString(), containsString(expected));
    }

    @Test
    public void shouldPrintABookTitleWhenIStartTheApp() throws IOException {
        app.start();

        String expected = "1984";
        assertThat(outputStream.toString(), containsString(expected));
    }

}