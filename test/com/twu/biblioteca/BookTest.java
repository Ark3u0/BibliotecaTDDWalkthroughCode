package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldWriteBookInformation() {
        Book book = new Book("Crazy Rich Asians", "Kevin Kwan", 2017);

        assertThat(book.toString(), is(String.join(", ",
                "Crazy Rich Asians",
                "Kevin Kwan",
                "2017")));
    }
}