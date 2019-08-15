package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(final String title, final String author, final int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.join(", ",
                title,
                author,
                Integer.toString(year));
    }
}
