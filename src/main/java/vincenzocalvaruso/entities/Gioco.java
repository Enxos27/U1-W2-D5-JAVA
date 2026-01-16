package vincenzocalvaruso.entities;

//- ID Gioco (codice univoco)
//- Titolo
//- Anno Pubblicazione
//- prezzo (valore positivo)

import vincenzocalvaruso.exception.DataNonValidaException;
import vincenzocalvaruso.exception.PrezzoNonValidoException;

public abstract class Gioco {
    private String titolo;
    private double prezzo;
    private int annoPubblicazione;
    private int id;

    public Gioco(int id, String titolo, double prezzo, int annoPubblicazione) {
        if (prezzo <= 0)
            throw new PrezzoNonValidoException();
        if (annoPubblicazione > 2026 || annoPubblicazione < 1900)
            throw new DataNonValidaException();
        //Messo qua il controllo perchè gli oggetti non vengono creati dall'utente
        //Nel caso in cui l'utent crei gli oggetti, se provasse a cambiare il prezzo (o l'anno) tramite setter l'applicazione si romperebbe
        //Per suvviare il problema il controllo dovrà essere inserito anche nel setter, o ancora meglio, inserire il controllo nel setter
        // e inserire il setter dentro il costruttore (esempio: setAnnoPubblicazione(annoPubblicazione) dentro al costruttore.
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        if (annoPubblicazione > 2026 || annoPubblicazione < 1900)
            throw new DataNonValidaException();
        else this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo <= 0)
            throw new PrezzoNonValidoException();
        else this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
