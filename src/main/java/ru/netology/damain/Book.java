package ru.netology.damain;

public class Book extends Product {
    private String autor;
    private int pages;
    private int publishedYear;

    public Book(int id, String name, int price, String autor, int pages, int publishedYear) {
        super(id, name, price);
        this.autor = autor;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    public String getAutor() {
        return autor;
    }
}
