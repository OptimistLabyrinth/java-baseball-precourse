package baseball.model.inputvalidator;

public class GuessInputValidator implements InputValidator {
    private Boolean validateResult;

    public GuessInputValidator() {
        this.validateResult = true;
    }

    @Override
    public Boolean validate(String guess) {
        if (guess == null || guess.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            validateDigitInRangeOneToNine(guess.charAt(i));
        }
        return validateResult;
    }

    private void validateDigitInRangeOneToNine(Character c) {
        if (c < '1' || '9' < c) {
            validateResult = false;
        }
    }
}
