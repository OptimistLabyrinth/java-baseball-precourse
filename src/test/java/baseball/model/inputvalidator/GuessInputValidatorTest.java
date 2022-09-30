package baseball.model.inputvalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GuessInputValidatorTest {
    @ParameterizedTest
    @DisplayName("사용자 추측한 숫자는 세 자리여야 한다")
    @CsvSource(value = {"123:true", "1234:false", "12:false", ":false"}, delimiter = ':')
    public void lengthShouldBeThree(String userInput, Boolean expectedResult) {
        GuessInputValidator guessInputValidator = new GuessInputValidator();
        Boolean validateResult = guessInputValidator.validate(userInput);
        assertThat(validateResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("각 자리의 숫자가 하나라도 1 ~ 9 가 아닌 경우")
    @CsvSource(value = {"159:true", "012:false", "abc:false"}, delimiter = ':')
    public void shouldBeEachDigitInRangeOneToNine(String userInput, Boolean expectedResult) {
        GuessInputValidator guessInputValidator = new GuessInputValidator();
        Boolean validateResult = guessInputValidator.validate(userInput);
        assertThat(validateResult).isEqualTo(expectedResult);
    }
}
