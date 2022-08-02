package model.warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.people.*;
import model.enums.Nation;
import model.enums.PublishingHouse;
import model.enums.Genre;
import model.enums.Language;
import model.sellable.Opera;
import model.sellable.DVD;
import model.sellable.Book;

public class Warehouse {
    public static List<Opera> productList = new ArrayList<>();

    public static Map<Author, List<Opera>> authorProductsMap = new HashMap<>();

    public static List<Person> authors = new ArrayList<>();

    public static List<Opera> getProductList() {
        return productList;
    }

    public static List<Person> getAuthors() {
        return authors;
    }

    public static void run() {

        // Create directors
        Director stanleyKubrick = new Director("Stanley", "Kubrick", createRandomDate(1900, 2000), false,
                Nation.USA, true);
        Director timBurton = new Director("Tim", "Burton", createRandomDate(1900, 2000), true, Nation.USA, false);
        Director federicoFellini = new Director("Federico", "Fellini", createRandomDate(1900, 2000), false,
                Nation.ITALY,
                true);
        Director spikeLee = new Director("Spike", "Lee", createRandomDate(1900, 2000), true, Nation.USA, true);
        Director stevenSpielberg = new Director("Steven", "Spielberg", createRandomDate(1900, 2000), true, Nation.USA,
                true);

        // Create writers
        Writer ernestHemingway = new Writer("Ernest", "Hemingway", createRandomDate(1900, 2000), false, Nation.USA,
                true);
        Writer stephenKing = new Writer("Stephen", "King", createRandomDate(1900, 2000), true, Nation.USA, false);
        Writer georgeOrwell = new Writer("George", "Orwell", createRandomDate(1900, 1950), false, Nation.ENGLAND,
                false);
        Writer jrrTolkien = new Writer("J.R.R.", "Tolkien", createRandomDate(1870, 1900), false, Nation.ENGLAND, false);
        Writer lewisCarroll = new Writer("Lewis", "Carroll", createRandomDate(1820, 1860), false, Nation.ENGLAND,
                false);

        // Create DVDs
        DVD dvd1 = new DVD("A Clockwork Orange", stanleyKubrick, Genre.SCIENCE_FICTION, 12.99, 12, Language.ITALIAN,
                true, 122);
        DVD dvd2 = new DVD("Full Metal Jacket", stanleyKubrick, Genre.ACTION, 8.49, 10, Language.ENGLISH, true,
                116);
        DVD dvd3 = new DVD("The Shining", stanleyKubrick, Genre.HORROR, 8.99, 9, Language.SPANISH, false, 134);
        DVD dvd4 = new DVD("Edward Mani di forbice", timBurton, Genre.FANTASY, 12.99, 12, Language.ITALIAN, true,
                105);
        DVD dvd5 = new DVD("Dumbo", timBurton, Genre.FANTASY, 4.99, 12, Language.ENGLISH, false, 101);
        DVD dvd6 = new DVD("Roma", federicoFellini, Genre.COMEDY, 8.99, 4, Language.ITALIAN, true, 119);
        DVD dvd7 = new DVD("La 25a ora", spikeLee, Genre.DRAMATIC, 8.99, 8, Language.ITALIAN, false, 112);
        DVD dvd8 = new DVD("Indiana Jones and the Last Crusade", stevenSpielberg, Genre.ADVENTURE, 8.99,
                10, Language.ITALIAN, true, 119);

        // Create books
        Book book1 = new Book("Death in the Afternoon", ernestHemingway, Genre.ADVENTURE, 8.99, 10, Language.ENGLISH,
                268, PublishingHouse.ADELPHI);
        Book book2 = new Book("The Sun also Rises Scribner's", ernestHemingway, Genre.ADVENTURE, 4.99, 8,
                Language.ITALIAN,
                312, PublishingHouse.BOMPIANI);
        Book book3 = new Book("The Eyes of the Dragon", stephenKing, Genre.FANTASY, 8.99, 12, Language.ENGLISH, 119,
                PublishingHouse.CAIRO);
        Book book4 = new Book("1984", georgeOrwell, Genre.FANTASY, 7.99, 10, Language.ITALIAN, 126,
                PublishingHouse.MONDADORI);
        Book book5 = new Book("The Lord of the Rings vol. 1", jrrTolkien, Genre.FANTASY, 24.99, 9, null, 348,
                PublishingHouse.MONDADORI);
        Book book6 = new Book("Alice's Adventures in Wonderland", lewisCarroll, Genre.FANTASY, 8.99, 10,
                Language.ITALIAN,
                112,
                PublishingHouse.BOMPIANI);
        // Add to authors
        authors.add(stanleyKubrick);
        authors.add(timBurton);
        authors.add(federicoFellini);
        authors.add(spikeLee);
        authors.add(stevenSpielberg);
        authors.add(ernestHemingway);
        authors.add(stephenKing);
        authors.add(georgeOrwell);
        authors.add(jrrTolkien);
        authors.add(lewisCarroll);

        // Add to product list
        productList.add(dvd1);
        productList.add(dvd2);
        productList.add(dvd3);
        productList.add(dvd4);
        productList.add(dvd5);
        productList.add(dvd6);
        productList.add(dvd7);
        productList.add(dvd8);

        productList.add(book1);
        productList.add(book2);
        productList.add(book2);
        productList.add(book3);
        productList.add(book4);
        productList.add(book5);
        productList.add(book6);

        // Add to map
        List<Opera> kubrickMovies = new ArrayList<>();
        kubrickMovies.add(dvd1);
        kubrickMovies.add(dvd2);
        kubrickMovies.add(dvd3);
        authorProductsMap.put(stanleyKubrick, kubrickMovies);

        List<Opera> burtonMovies = new ArrayList<>();
        burtonMovies.add(dvd4);
        burtonMovies.add(dvd5);
        authorProductsMap.put(timBurton, burtonMovies);

        List<Opera> felliniMovies = new ArrayList<>();
        felliniMovies.add(dvd6);
        authorProductsMap.put(federicoFellini, felliniMovies);

        List<Opera> leeMovies = new ArrayList<>();
        leeMovies.add(dvd7);
        authorProductsMap.put(spikeLee, leeMovies);

        List<Opera> spielbergMovies = new ArrayList<>();
        spielbergMovies.add(dvd8);
        authorProductsMap.put(stevenSpielberg, spielbergMovies);

        List<Opera> hemingwayBooks = new ArrayList<>();
        hemingwayBooks.add(book1);
        hemingwayBooks.add(book2);
        authorProductsMap.put(ernestHemingway, hemingwayBooks);

        List<Opera> kingBooks = new ArrayList<>();
        kingBooks.add(book3);
        authorProductsMap.put(stephenKing, kingBooks);

        List<Opera> orwellBooks = new ArrayList<>();
        orwellBooks.add(book4);
        authorProductsMap.put(georgeOrwell, orwellBooks);

        List<Opera> tolkienBooks = new ArrayList<>();
        tolkienBooks.add(book5);
        authorProductsMap.put(jrrTolkien, tolkienBooks);

        List<Opera> carrollBooks = new ArrayList<>();
        carrollBooks.add(book6);
        authorProductsMap.put(lewisCarroll, carrollBooks);

    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
