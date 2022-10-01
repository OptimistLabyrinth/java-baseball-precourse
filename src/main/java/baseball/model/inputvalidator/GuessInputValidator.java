package baseball.model.inputvalidator;

import baseball.constant.NumberBaseballGameConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GuessInputValidator implements InputValidator {
    private Boolean validateResult;

    public GuessInputValidator() {
        this.validateResult = true;
    }

    @Override
    public Boolean validate(String guess) {
        if (guess == null || guess.length() != NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER) {
            return false;
        }
        for (int i = 0; i < NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            validateDigitInRangeOneToNine(guess.charAt(i));
        }
        validateAllDigitsUniqueNumber(guess);
        return validateResult;
    }

    private void validateDigitInRangeOneToNine(Character c) {
        if (
                c < (char) (NumberBaseballGameConstant.MINIMUM_OF_EACH_DIGIT + '0') ||
                        (char) (NumberBaseballGameConstant.MAXIMUM_OF_EACH_DIGIT + '0') < c
        ) {
            validateResult = false;
        }
    }

    private void validateAllDigitsUniqueNumber(String guess) {
        Set<String> digits = new HashSet<>(Arrays.asList(guess.split("")));
        if (digits.size() != 3) {
            validateResult = false;
        }
    }
}
