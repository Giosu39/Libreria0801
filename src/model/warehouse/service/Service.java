package model.warehouse.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import model.warehouse.Warehouse;
import model.people.Author;
import model.people.Person;
import model.enums.*;
import model.sellable.*;

public class Service {
    public static List<Person> bornRange(LocalDate date, LocalDate date2) {
        List<Person> authors = new ArrayList<>();
        for (Person a : Warehouse.getAuthors()) {
            if (a.getBirthDate().isAfter(date) && a.getBirthDate().isBefore(date2)) {
                authors.add(a);
            }
        }
        return authors;
    }

    public static boolean isTrulyAlive(Author a) {
        boolean verify = false;
        if (a.isAlive() == true)
            verify = true;
        else
            verify = false;
        return verify;
    }

    public static List<Person> getAuthorsByNationality(Nation n) {
        List<Person> authors = new ArrayList<>();
        for (Person a : Warehouse.getAuthors()) {
            if (n == a.getNationality())
                authors.add(a);
        }
        return authors;
    }

    public static List<Opera> getOperaByLanguage(Language language) {
        List<Opera> result = new ArrayList<>();

        List<Opera> productList = Warehouse.getProductList();

        for (int i = 0; i < productList.size(); i++) {
            Product currentProduct = (Product) productList.get(i);
            Language currentLanguage = currentProduct.getLanguage();
            if (currentLanguage == language) {
                result.add(currentProduct);
            }
        }
        return result;
    }

    public static List<Opera> getSubOperas() {
        List<Opera> operas = new ArrayList<>();
        List<Opera> result = new ArrayList<>();
        for (int i = 0; i < Warehouse.productList.size(); i++) {
            if (Warehouse.productList.get(i) instanceof DVD == true) {
                operas.add(Warehouse.productList.get(i));
            }
        }
        for (int i = 0; i < operas.size(); i++) {
            if (((DVD) operas.get(i)).getItaSubCheck() == true) {
                result.add(operas.get(i));
            }
        }
        return result;
    }

    public static List<Opera> currentPublishingHouse(PublishingHouse ph) {
        List<Opera> result = new ArrayList<>();

        List<Opera> productList = Warehouse.getProductList();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Book) {
                Book currentProduct = (Book) productList.get(i);
                if (currentProduct.getPublishingHouse() == ph) {
                    result.add(currentProduct);
                }
            }
        }
        return result;
    }
}