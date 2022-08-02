package model.people;

import java.time.LocalDate;
import model.enums.Nation;

public abstract class Author implements Person {
    // Attributes
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private static int classId = 0;
    private int id;
    private boolean alive;
    private Nation nationality;

    // Constructor
    public Author(String firstName, String lastName, LocalDate birthDate, boolean alive, Nation nationality) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        this.id = ++classId;
        setAlive(alive);
        setNationality(nationality);
    }

    // Getters and setters
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            System.out.println("La data di nascita non può essere successiva alla data attuale");
        } else {
            this.birthDate = birthDate;
        }
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;

    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    public void setNationality(Nation nationality) {
        this.nationality = nationality;
    }
    public Nation getNationality() {
        return nationality;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Author [alive=" + alive + ", birthDate=" + birthDate + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", nationality=" + nationality + "]";
    }
}
