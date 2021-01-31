package com.company.Modules;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    String title;
    String description;
    String author;
    int year;

    public Book(String title, String description, String author, int year) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

}
