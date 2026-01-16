package vincenzocalvaruso.entities;

import vincenzocalvaruso.exception.NumeroGiocatoriException;

//- Numero di giocatori (range da 2 a 10)
//- Durata media di una partita (in minuti)


public class GiocoDaTavolo extends Gioco {
    private int numGiocatori;
    private double durataMinuti;

    public GiocoDaTavolo(int id, String titolo, double prezzo, int annoPubblicazione, int numGiocatori, double durataMinuti) {
        super(id, titolo, prezzo, annoPubblicazione);
        if (numGiocatori < 2 || numGiocatori > 10) throw new NumeroGiocatoriException();
        this.durataMinuti = durataMinuti;
        this.numGiocatori = numGiocatori;
    }

    public double getDurataMinuti() {
        return durataMinuti;
    }


    public int getNumGiocatori() {
        return numGiocatori;
    }
}
