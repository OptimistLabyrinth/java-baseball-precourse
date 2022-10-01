package baseball.model.inputvalidator;

import baseball.constant.NumberBaseballConstant;

public class GuessInputValidator implements InputValidator {
    private Boolean validateResult;

    public GuessInputValidator() {
        this.validateResult = true;
    }

    @Override
    public Boolean validate(String guess) {
        if (guess == null || guess.length() != NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER) {
            return false;
        }
        for (int i = 0; i < NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            validateDigitInRangeOneToNine(guess.charAt(i));
        }
        return validateResult;
    }

    private void validateDigitInRangeOneToNine(Character c) {
        if (
                c < (char) (NumberBaseballConstant.MINIMUM_OF_EACH_DIGIT + '0') ||
                        (char) (NumberBaseballConstant.MAXIMUM_OF_EACH_DIGIT + '0') < c
        ) {
            validateResult = false;
        }
    }
}
