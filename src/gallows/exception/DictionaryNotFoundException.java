package gallows.exception;

public class DictionaryNotFoundException extends RuntimeException {

    public DictionaryNotFoundException() {}

    public DictionaryNotFoundException(String message) {
        super(message);
    }
}
