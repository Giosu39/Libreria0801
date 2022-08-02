package model.sellable;

import model.enums.Genre;
import model.enums.Language;
import model.enums.PublishingHouse;
import model.people.Author;

public class Book extends Product {
    // Attributes
    private int pageNumber;

    private PublishingHouse publishingHouse;

    // Constructor
    public Book(String title, Author author, Genre genre, double price, int languageNumber, Language language,
            int pageNumber,
            PublishingHouse publishingHouse) {
        super(title, author, genre, price, languageNumber, language);
        setPageNumber(pageNumber);
        setPublishingHouse(publishingHouse);
    }

    // Getters and setters
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}