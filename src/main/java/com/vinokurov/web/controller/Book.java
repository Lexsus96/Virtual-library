package com.mkyong.web.controller;

/**
 * Created by Alex on 06.07.2016.
 */
public class Book {
    private String title;
    private String year;
    private Author author;
    private String isbn;
    private String dicription;

    Book(String title, String year, Author author, String isbn) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.isbn = isbn;
        this.dicription = null;
    }
    public void setTitle(String title) {
         this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDicription() { return dicription; }

    public void setDicription(String dicription) { this.dicription = dicription; }

    @Override
    public String toString() {
        return getTitle();
    }
}
