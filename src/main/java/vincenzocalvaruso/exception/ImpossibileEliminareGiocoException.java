package vincenzocalvaruso.exception;

public class ImpossibileEliminareGiocoException extends RuntimeException {
    public ImpossibileEliminareGiocoException(int id) {
        super("Impossibile rimuovere: il gioco con ID " + id + " non esiste nella collezione.");
    }
}
