package model.warehouse.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.warehouse.Warehouse;
import model.warehouse.service.*;
import model.enums.Language;
import model.enums.Nation;
import model.enums.PublishingHouse;
import model.people.Author;
import model.people.Person;
import model.people.Director;
import model.sellable.*;

public class Menu {

    public static void start() {
        boolean loop = true;

        Scanner in = new Scanner(System.in);

        int input;

        while (loop) {

            System.out.println(
                    "Benvenuto nella Warehouse! Che servizio ti serve? \n 1) Autori vissuti intorno ad una certa data; \n 2) Se un certo autore e' ancora in vita; \n 3) Autori di una certa nazionalita'; \n 4) Opere scritte in una certa lingua; \n 5) Opere sottotitolate in italiano; \n 6) Ricerca di libri tramite casa editrice");
            input = in.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Inserisci l'anno di partenza per la ricerca: ");
                    int date = in.nextInt();
                    System.out.print("Inserisci l'anno di fine per la ricerca: ");
                    int date2 = in.nextInt();
                    LocalDate startDate = LocalDate.of(date, 1, 1);
                    LocalDate endDate = LocalDate.of(date2, 12, 31);
                    List<Person> result = Service.bornRange(startDate, endDate);
                    if (result.size() > 0) {
                        for (int i = 0; i < result.size(); i++) {
                            Author myAuthor = (Author) result.get(i);
                            System.out.println(myAuthor.getFirstName() + " " + myAuthor.getLastName());
                        }
                    } else {
                        System.out.println("Non sono stati trovati autori nati tra le date specificate");
                    }
                    break;

                case 2:
                    System.out.println("Inserisci il cognome dell'autore:");
                    in.nextLine();
                    String cognome = in.nextLine();
                    Pattern patternCognome = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
                    Matcher matcherCognome = patternCognome.matcher(cognome);
                    boolean matchFoundCognome = matcherCognome.find();
                    if (matchFoundCognome) {
                        System.out.println("Il cognome non può contenere numeri!");
                        break;
                    }
                    System.out.println("Inserisci il nome dell'autore:");

                    String nome = in.nextLine();

                    Pattern patternNome = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
                    Matcher matcherNome = patternNome.matcher(nome);
                    boolean matchFoundNome = matcherNome.find();
                    if (matchFoundNome) {
                        System.out.println("Il nome non può contenere numeri!");
                        break;
                    }
                    Author myAuthor = null;
                    List<Person> authors = Warehouse.getAuthors();
                    boolean found = false;
                    for (int i = 0; i < authors.size(); i++) {
                        if (authors.get(i).getLastName().equalsIgnoreCase(cognome)
                                && authors.get(i).getFirstName().equalsIgnoreCase(nome)) {
                            myAuthor = (Author) authors.get(i);
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("Non è stato trovato nessun autore con questo nome e cognome");
                        break;
                    }
                    boolean alive = Service.isTrulyAlive(myAuthor);
                    if (alive) {
                        System.out.println(
                                myAuthor.getFirstName() + " " + myAuthor.getLastName() + " è ancora in circolazione!");
                    } else {
                        System.out.println(myAuthor.getFirstName() + " " + myAuthor.getLastName()
                                + " non è più in circolazione! :(");
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il nome della nazione (in inglese): ");
                    in.nextLine();
                    String nationInput = in.nextLine();
                    Nation nation = Nation.ITALY;
                    Nation[] nations = Nation.values();

                    for (int i = 0; i < nations.length; i++) {
                        if (nations[i].name().equalsIgnoreCase(nationInput)) {
                            nation = nations[i];
                        }
                    }
                    List<Person> resultCase3 = Service.getAuthorsByNationality(nation);
                    if (resultCase3.size() > 0) {
                        for (int i = 0; i < resultCase3.size(); i++) {
                            Author myAuthorCase3 = (Author) resultCase3.get(i);
                            System.out.println(myAuthorCase3.getFirstName() + " " + myAuthorCase3.getLastName());
                        }
                    } else {
                        System.out.println("Non è stato trovato nessun autore con questa nazionalità");
                    }

                    break;
                case 4:
                    System.out.print("Inserisci il nome della lingua (in inglese): ");
                    in.nextLine();
                    String inputLanguage = in.nextLine();
                    Language selectedLanguage = null;
                    Language[] languages = Language.values();

                    for (int i = 0; i < languages.length; i++) {
                        if (languages[i].name().equalsIgnoreCase(inputLanguage)) {
                            selectedLanguage = languages[i];
                        }
                    }
                    List<Opera> resultCase4 = Service.getOperaByLanguage(selectedLanguage);
                    if (resultCase4.size() > 0) {
                        for (int i = 0; i < resultCase4.size(); i++) {
                            Product opera = (Product) resultCase4.get(i);
                            System.out.println(opera.getTitle());
                        }
                    } else {
                        System.out.println("Non è stata trovata nessuna opera con questa lingua");
                    }
                    break;

                case 5:
                    System.out.println("Le opere sottotitolate in italiano sono: ");
                    List<Opera> resultCase5 = Service.getSubOperas();
                    for (int i = 0; i < resultCase5.size(); i++) {
                        Product currentOpera = (Product) resultCase5.get(i);
                        System.out.println(currentOpera.getTitle());
                    }
                    break;
                case 6:
                    System.out.print(
                            "Inserisci la casa editrice necessaria per la ricerca: (es. Bompiani, Mondadori, Adelphi...)\n");
                    in.nextLine();
                    String publishingHouseInput = in.nextLine();
                    PublishingHouse publishingHouse = null;
                    PublishingHouse[] publishingHouses = PublishingHouse.values();

                    for (int i = 0; i < publishingHouses.length; i++) {
                        if (publishingHouses[i].name().equalsIgnoreCase(publishingHouseInput)) {
                            publishingHouse = publishingHouses[i];
                        }
                    }
                    List<Opera> resultCase6 = Service.currentPublishingHouse(publishingHouse);
                    if (resultCase6.size() > 0) {
                        for (int i = 0; i < resultCase6.size(); i++) {
                            Product myProductCase6 = (Product) resultCase6.get(i);
                            System.out.println(myProductCase6.getTitle());
                        }
                    } else {
                        System.out.println("Non è stato trovato nessun prodotto per questa casa editrice");
                    }
                    break;
                default:
                    System.out.println("L'input inserito non e' valido");
            }
            System.out.println("\nVuoi effettuare un'altra operazione?\n1) Si'\n2) No");
            input = in.nextInt();
            if (input == 2) {
                loop = false;
            }
        }
    }
}