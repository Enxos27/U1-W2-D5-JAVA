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
import vincenzocalvaruso.exception.ImpossibileEliminareGiocoException;

import java.util.*;

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
        if (listaPerPrezzo.isEmpty()) {
            System.out.println("Nessun gioco trovato a questo prezzo o inferiore : " + prezzo + "€");
        }
        return listaPerPrezzo;
    }

    public List<GiocoDaTavolo> ricercaPerGiocatori(int numGiocatori) {
        List<GiocoDaTavolo> giocoPerGiocatori = listaGiochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco) // Converto (cast) il riferimento da Gioco a GiocoDaTavolo.
                // Così posso "vedere" i metodi che non esistono nella classe padre.
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumGiocatori() == numGiocatori).toList();

        if (giocoPerGiocatori.isEmpty()) {
            System.out.println("Nessun gioco da tavolo trovato per " + numGiocatori + " giocatori.");
        }

        return giocoPerGiocatori;
    }

    public void rimuoviGioco(int id) {
        boolean rimosso = listaGiochi.removeIf(gioco -> gioco.getId() == id);

        if (rimosso) {
            System.out.println("Gioco con ID " + id + " rimosso con successo!");
        } else {
            throw new ImpossibileEliminareGiocoException(id);
        }
    }

    public void aggiornaElemento(int id, Gioco nuovoGioco) {
        boolean trovato = false;
        for (int i = 0; i < listaGiochi.size(); i++) {
            if (listaGiochi.get(i).getId() == id) {
                listaGiochi.set(i, nuovoGioco);
                System.out.println("Gioco aggiornato con successo!");
                trovato = true;
                break;
            }
        }
        if (!trovato) throw new GiocoNonTrovatoException(id);
    }

    public void stampaStatistiche() {
        int numVideogiochi = Math.toIntExact(listaGiochi.stream() //Converto ad int perchè count() ha come valore di ritorno un long
                .filter(gioco -> gioco instanceof Videogioco)
                .count());
        int numGiochiDaTavolo = Math.toIntExact(listaGiochi.stream() //Converto ad int perchè count() ha come valore di ritorno un long
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .count());
        Optional<Gioco> giocoPiuCostoso = listaGiochi.stream()
                .max(Comparator.comparingDouble(gioco -> gioco.getPrezzo()));

        OptionalDouble mediaPrezzi = listaGiochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .average();

        System.out.println("\n********** STATISTICHE **********");
        System.out.println("Il totale di giochi presenti nella libreria sono: " + (numVideogiochi + numGiochiDaTavolo) + "\n Giochi da tavolo presenti: " + numGiochiDaTavolo + "\n Videogiochi presenti:" + numVideogiochi);
        System.out.println("Il gioco più costoso è: " +
                giocoPiuCostoso.map(Gioco::getTitolo).orElse("Nessun gioco presente"));
        System.out.println("La media di tutti i prezzi è: " + mediaPrezzi.orElse(0.0) + "€");
    }


}
