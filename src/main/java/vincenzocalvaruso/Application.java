package vincenzocalvaruso;

import vincenzocalvaruso.entities.Collezione;
import vincenzocalvaruso.entities.GiocoDaTavolo;
import vincenzocalvaruso.entities.Videogioco;
import vincenzocalvaruso.exception.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        try {
            collezione.aggiungiElemento(new Videogioco(1, "Elden Ring", 60.0, 2022, "PS5", 120, Videogioco.Genere.ACTION));
            collezione.aggiungiElemento(new Videogioco(2, "Cyberpunk 2077", 40.0, 2020, "PC", 60, Videogioco.Genere.RPG));

            collezione.aggiungiElemento(new GiocoDaTavolo(3, "Monopoly", 25.0, 1935, 4, 180));
            collezione.aggiungiElemento(new GiocoDaTavolo(4, "Cruedo", 30.0, 1949, 5, 45));

            //Rimuovere la riga commentata per lanciare l'exception incaso di id già esistente
            //collezione.aggiungiElemento(new Videogioco(2, "FC 25", 69.90, 2024, "Xbox", 500, Videogioco.Genere.SPORT));

            //Rimuovere la riga commentata per lanciare l'exception incaso di prezzo <=0
            //collezione.aggiungiElemento(new Videogioco(6, "Stardew Valley", 0, 2016, "PC", 200, Videogioco.Genere.SIMULATION));

            //Rimuovere la riga commentata per lanciare l'exception incaso di numero giocatori <2 o >10
            //collezione.aggiungiElemento(new GiocoDaTavolo(5, "What Do You Meme?", 19.90, 2016, 20, 15));


            collezione.stampaStatistiche();

            // Provo una ricerca per prezzo
            System.out.println("\nInserisci un prezzo per trovare i giochi con lo stesso prezzo o inferiore");
            double prezzo = Double.parseDouble(scanner.nextLine());
            collezione.ricercaPrezzo(prezzo).forEach(g -> System.out.println(g.getTitolo()));
            //Nella riga di sopra il metodo ricercaPrezzo() ritorna una List quindi uso un forEach per stampare il risultato
            //senza doverlo salvare in una variabile

            // Provo una ricerca per numero giocatori
            System.out.println("Inserisci un numero di giocatori compreso tra 2 e 10 per trovare un gioco");
            int numGiocatori = Integer.parseInt(scanner.nextLine());
            collezione.ricercaPerGiocatori(numGiocatori).forEach(g -> System.out.println(g.getTitolo()));
            //Nella riga di sopra il metodo ricercaPerGiocatori() ritorna una List quindi uso un forEach per stampare il risultato
            //senza doverlo salvare in una variabile

            // Provo a modificare un gioco e stampo le statistiche
            System.out.println("Inserisci l'id di un gioco specifico per cambiarlo con un nuovo gioco");
            // Se l'utente inserisce un id non presente nella lista, si lancierà un exception (esempio: inserisci 10)
            int modificaGioco = Integer.parseInt(scanner.nextLine());
            Videogioco nuovoGioco = new Videogioco(modificaGioco, "God of War Ragnarok", 75.50, 2022, "PS5", 40, Videogioco.Genere.ACTION);
            collezione.aggiornaElemento(modificaGioco, nuovoGioco);
            collezione.stampaStatistiche();

            // Provo a rimuovere un elemento e stampo statistiche
            System.out.println("\nInserisci un id per rimuovere il gioco specifico");
            // Se l'utente inserisce un id non presente nella lista, si lancierà un exception (esempio: inserisci 10)
            int id = Integer.parseInt(scanner.nextLine());
            collezione.rimuoviGioco(id);
            collezione.stampaStatistiche();

        } catch (PrezzoNonValidoException | NumeroGiocatoriException | IdGiaPresenteException |
                 GiocoNonTrovatoException | ImpossibileEliminareGiocoException | DataNonValidaException e) {
            System.err.println("ERRORE DI VALIDAZIONE: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERRORE GENERICO: " + e.getMessage());
        }
    }

}

