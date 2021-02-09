package com.company.Modules;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    String title;
    String description;
    String author;
    String currentLender;
    int year;
    LocalDate borrowDate;
    LocalDate returnDate;
    @Serial
    private static final long serialVersionUID = 3998998041799324022L;
    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    //----
    public Book() {

    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public Book description(String description) {
        this.description = description;
        return this;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public Book year(int year) {
        this.year = year;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrentLender() {
        return currentLender;
    }

    public void setCurrentLender(String currentLender) {
        this.currentLender = currentLender;
    }


    @Override
    public String toString() {
        return  YELLOW + "Title: '" + RESET + title + '\'' +
                YELLOW + ", Author: '" + RESET + author + '\'' +
                YELLOW + ", Year: '" + RESET + year;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
        setReturnDate();
    }

    public void setReturnDate() {
        this.returnDate = borrowDate.plusDays(14);
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
