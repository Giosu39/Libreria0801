package model.people;

import java.time.LocalDate;

import model.enums.Nation;

public class Director extends Author {
    // Attributes
    private boolean oscarWinner;

    // Constructor
    public Director(String firstName, String lastName, LocalDate birthDate, boolean alive, Nation nationality,
            boolean oscarWinner) {
        super(firstName, lastName, birthDate, alive, nationality);
        setOscarWinner(oscarWinner);
    }

    // Getters and setters
    public boolean isOscarWinner() {
        return oscarWinner;
    }

    public void setOscarWinner(boolean oscarWinner) {
        this.oscarWinner = oscarWinner;
    }
}
