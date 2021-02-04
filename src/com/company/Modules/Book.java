package com.company.Modules;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    String title;
    String description;
    String author;
    String currentLender;
    private static final long serialVersionUID =3998998041799324022L;
    int year;

    public Book() {

    }
    public Book title(String title){
         this.title = title;
         return this;
    }
    public Book description(String description){
        this.description = description;
        return this;
    }
    public Book author (String author){
        this.author = author;
        return this;
    }
    public Book year(int year){
        this.year = year;
        return this;
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

    public String getCurrentLender() {
        return currentLender;
    }

    public void setCurrentLender(String currentLender) {
        this.currentLender = currentLender;
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
