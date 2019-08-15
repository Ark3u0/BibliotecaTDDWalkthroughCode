package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void shouldShowWelcomeMessageWhenIStartTheApp() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        BibliotecaApp app = new BibliotecaApp(out);

        app.start();

        String expected = "Welcome to Biblioteca. Your one-stop shop for great book titles in Stevensville.\n";
        assertThat(expected, is(outputStream.toString()));

    }
}