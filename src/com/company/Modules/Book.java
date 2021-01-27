package com.company.Modules;

import java.util.List;

public class Book {
    String title;
    String description;
    List <String> authors;
    int date;

    public Book(String title, String description, List<String> authors, int date) {
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
