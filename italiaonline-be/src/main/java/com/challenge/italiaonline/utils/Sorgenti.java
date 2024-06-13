package com.challenge.italiaonline.utils;

public enum Sorgenti {
    HACKER("Hacker"),
    NYTIMES("NyTimes"),
    BBC("Bbc");

    private String descrizione;

    private Sorgenti(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    static public Sorgenti getSorgenteFromDescrizione(String descrizione) {
        for(Sorgenti sorgente: Sorgenti.values()) {
            if(sorgente.getDescrizione().equals(descrizione)) {
                return sorgente;
            }
        }

        return null;
    }
}
