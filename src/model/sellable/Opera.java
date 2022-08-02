package model.sellable;

import model.enums.Genre;
import model.enums.Language;
import model.people.Author;

public interface Opera {
    public String getTitle();

    public void setTitle(String title);

    public Author getAuthor();

    public void setAuthor(Author author);

    public Genre getGenre();

    public void setGenre(Genre genre);

    public int getLanguageNumber();

    public void setLanguageNumber(int languageNumber);

    public Language getLanguage();

    public void setLanguage(Language language);

    public int getId();

}
