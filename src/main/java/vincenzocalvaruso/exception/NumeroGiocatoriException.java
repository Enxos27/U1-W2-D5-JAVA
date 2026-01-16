package vincenzocalvaruso.exception;

public class NumeroGiocatoriException extends RuntimeException {
    public NumeroGiocatoriException() {
        super("Il numero di giocatori deve essere compreso tra 2 e 10.");
    }
}
