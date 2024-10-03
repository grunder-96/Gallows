package gallows.validator;

import java.util.Objects;

public class ExpectedValueValidator implements Validator<String> {

    private final String[] expectedValues;

    public ExpectedValueValidator(String... expectedValues) {
        this.expectedValues = Objects.requireNonNullElse(expectedValues, new String[0]);
    }

    @Override
    public boolean validate(String inputValue) {
        for (String expectedValue : expectedValues) {
            if (expectedValue.equalsIgnoreCase(inputValue)) {
                return true;
            }
        }
        return false;
    }
}
