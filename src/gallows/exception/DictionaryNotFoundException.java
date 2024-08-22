package gallows.exception;

import gallows.Dictionary;

public class DictionaryNotFoundException extends RuntimeException {

    public DictionaryNotFoundException() {}

    public DictionaryNotFoundException(String message) {
        super(message);
    }
}
