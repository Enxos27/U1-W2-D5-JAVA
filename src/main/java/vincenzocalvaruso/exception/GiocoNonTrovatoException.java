package vincenzocalvaruso.exception;

public class GiocoNonTrovatoException extends RuntimeException {
    public GiocoNonTrovatoException() {
        super("Impossibile trovare il gioco");
    }
}
