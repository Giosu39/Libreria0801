package model.sellable;

import model.enums.Genre;
import model.enums.Language;
import model.people.Author;

public class DVD extends Product {
    // Attributes
    private boolean itaSubCheck;
    private int duration;

    // Constructor
    public DVD(String title, Author author, Genre genre, double price, int languageNumber, Language language,
            boolean itaSubCheck,
            int duration) {
        super(title, author, genre, price, languageNumber, language);
        setItaSubCheck(itaSubCheck);
        setDuration(duration);
    }

    // Getters and setters
    public void setItaSubCheck(boolean itaSubCheck) {
        this.itaSubCheck = itaSubCheck;
    }

    public boolean getItaSubCheck() {
        return itaSubCheck;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

}
