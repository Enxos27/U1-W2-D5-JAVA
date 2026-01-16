package vincenzocalvaruso.exception;

public class GiocoNonTrovatoException extends RuntimeException {
    public GiocoNonTrovatoException(int id) {
        super("Impossibile trovare il gioco con l'id: " + id);
    }
}
