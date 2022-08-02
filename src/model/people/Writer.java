package model.people;

import java.time.LocalDate;
import model.enums.Nation;

public class Writer extends Author {
    // Attributes
    private boolean nobelWinner;

    // Constructor
    public Writer(String firstName, String lastName, LocalDate birthDate, boolean alive, Nation nationality,
            boolean nobelWinner) {
        super(firstName, lastName, birthDate, alive, nationality);
        setNobelWinner(nobelWinner);
    }

    // Getters and setters
    public boolean isNobelWinner() {
        return nobelWinner;
    }

    public void setNobelWinner(boolean nobelWinner) {
        this.nobelWinner = nobelWinner;
    }
}
