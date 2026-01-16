package vincenzocalvaruso.entities;

//- ID Gioco (codice univoco)
//- Titolo
//- Anno Pubblicazione
//- prezzo (valore positivo)

import vincenzocalvaruso.exception.PrezzoNonValidoException;

import java.util.Date;

public abstract class Gioco {
    private String titolo;
    private double prezzo;
    private Date annoPubblicazione;
    private int id;

    public Gioco(int id, String titolo, double prezzo, Date annoPubblicazione) {
        if (prezzo <= 0) throw new PrezzoNonValidoException();
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public Date getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Date annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
