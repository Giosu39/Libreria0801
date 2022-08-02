package model.people;

import model.enums.Nation;

import java.time.LocalDate;

public interface Person {
    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public LocalDate getBirthDate();

    public void setBirthDate(LocalDate birthDate);

    public void setAlive(boolean alive);

    public int getId();

    public boolean isAlive();

    public void setNationality(Nation nationality);

    public Nation getNationality();
}
