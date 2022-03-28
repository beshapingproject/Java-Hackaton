package it.be.codingRace.utils;

public enum Constants {

    UTENTE_SESSION ("UTENTE_SESSION"),
    NEW ("NEW"),
    IN_PROGRESS ("IN PROGRESS"),
    CLOSED ("CLOSED");


    private final String value;

     Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
