package gallows.exception;

public class NoMoreWordsException extends RuntimeException{

    public NoMoreWordsException() {}

    public NoMoreWordsException(String message) {
        super(message);
    }
}
