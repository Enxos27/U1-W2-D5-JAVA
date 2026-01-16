package vincenzocalvaruso.exception;

public class DataNonValidaException extends RuntimeException {
    public DataNonValidaException() {
        super("La data inserita non può essere nel futuro o prima dell'invenzione dei giochi");
    }
}
