package baseball.model.inputvalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GuessInputValidatorTest {
    @ParameterizedTest
    @DisplayName("사용자 추측한 숫자는 세 자리여야 한다.")
    @CsvSource(value = {"123:true", "1234:false", "12:false", ":false"}, delimiter = ':')
    public void lengthShouldBeThree(String userInput, Boolean expectedResult) {
        GuessInputValidator guessInputValidator = new GuessInputValidator(userInput);
        Boolean validateResult = guessInputValidator.validate();
        assertThat(validateResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("각 자리의 숫자는 전부 다 1 ~ 9 중에 하나여야 한다.")
    @CsvSource(value = {"159:true", "012:false", "abc:false"}, delimiter = ':')
    public void shouldBeEachDigitInRangeOneToNine(String userInput, Boolean expectedResult) {
        GuessInputValidator guessInputValidator = new GuessInputValidator(userInput);
        Boolean validateResult = guessInputValidator.validate();
        assertThat(validateResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("세 자리 숫자는 전부 다 다른 숫자여야 한다.")
    @CsvSource(value = {"123:true", "121:false", "111:false"}, delimiter = ':')
    public void shouldAllDigitsUniqueNumber(String userInput, Boolean expectedResult) {
        GuessInputValidator guessInputValidator = new GuessInputValidator(userInput);
        Boolean validateResult = guessInputValidator.validate();
        assertThat(validateResult).isEqualTo(expectedResult);
    }
}
