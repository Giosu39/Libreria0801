package model.sellable;

import model.enums.Genre;
import model.enums.Language;
import model.people.Author;

public abstract class Product implements Opera {
    // Attributes
    private String title;
    private Author author;
    private Genre genre;
    private double price;
    private int languageNumber;
    private static int classId = 0;
    private int id;
    private Language language;

    // Constructor
    public Product(String title, Author author, Genre genre, double price, int languageNumber, Language language) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setPrice(price);
        setLanguageNumber(languageNumber);
        setLanguage(language);
        this.id = ++classId;
    }

    @Override
    public String toString() {
        return "Product [author=" + author + ", genre=" + genre + ", id=" + id + ", language=" + language
                + ", languageNumber=" + languageNumber + ", price=" + price + ", title=" + title + "]";
    }

    // Getters and setter
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(Author author) {
        this.author = author;
    };

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getLanguageNumber() {
        return languageNumber;
    }

    @Override
    public void setLanguageNumber(int languageNumber) {
        this.languageNumber = languageNumber;
    }

    @Override
    public Language getLanguage() {
        return language;
    };

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    };

    @Override
    public int getId() {
        return id;
    }
}