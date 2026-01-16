package vincenzocalvaruso.exception;

public class IdGiaPresenteException extends RuntimeException {
    public IdGiaPresenteException() {
        super("Impossibile aggiungere il gioco, l'id è già presente");
    }
}
