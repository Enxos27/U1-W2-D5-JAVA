package vincenzocalvaruso.exception;

public class PrezzoNonValidoException extends RuntimeException {

    public PrezzoNonValidoException() {
        super("Il prezzo non può essere negativo!");
    }
}