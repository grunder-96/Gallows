package gallows.validator;

public class LetterInputValidator implements Validator<String> {

    @Override
    public boolean validate(String input) {
        return input.length() == 1 && input.matches("[а-яА-яёЁ]");
    }
}
