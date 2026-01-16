package vincenzocalvaruso.entities;

//- Aggiunta di un elemento (non deve essere possibile inserire un elemento con lo stesso ID)
//        - Ricerca per ID
//        - Ricerca per prezzo, deve ritornare quindi una lista di giochi con prezzo inferiore al prezzo inserito
//        - Ricerca per numero di giocatori
//        - Rimozione di un elemento dato un codice ID
//        - Aggiornamento di un elemento esistente dato l'ID
//        - Statistiche della collezione: stampa il numero totale di videogiochi e giochi da tavolo presenti, il gioco con il prezzo più alto e la media dei prezzi di tutti gli elementi


import vincenzocalvaruso.exception.GiocoNonTrovatoException;
import vincenzocalvaruso.exception.IdGiaPresenteException;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> listaGiochi;

    public Collezione() {
        this.listaGiochi = new ArrayList<>();
    }

    public void aggiungiElemento(Gioco gioco) {
        boolean esiste = listaGiochi.stream().anyMatch(gioco1 -> gioco1.getId() == gioco.getId());
        if (esiste) throw new IdGiaPresenteException();
        else listaGiochi.add(gioco);
    }

    public List<Gioco> ricercaPrezzo(double prezzo) {
        List<Gioco> listaPerPrezzo = listaGiochi.stream().filter(gioco -> gioco.getPrezzo() <= prezzo).toList();
        return listaPerPrezzo;
    }

    public List<GiocoDaTavolo> ricercaPerGiocatori(int numGiocatori) {
        List<GiocoDaTavolo> giocoPerGiocatori = listaGiochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumGiocatori() == numGiocatori).toList();

        return giocoPerGiocatori;
    }

    public void rimuoviGioco(int id) {
        listaGiochi.removeIf(gioco -> gioco.getId() == id);
    }

    public void aggiornaElemento(int id, Gioco nuovoGioco) {
        boolean trovato = false;
        for (int i = 0; i < listaGiochi.size(); i++) {
            if (listaGiochi.get(i).getId() == id) {
                listaGiochi.set(i, nuovoGioco);
                trovato = true;
                break; // Esci dal ciclo, l'abbiamo trovato!
            }
        }
        if (!trovato) throw new GiocoNonTrovatoException();
    }

}
