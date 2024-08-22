package gallows.validator;

public class LetterValidator {

    public boolean validate(String letter) {
        return letter.matches("\\d");
    }
}
