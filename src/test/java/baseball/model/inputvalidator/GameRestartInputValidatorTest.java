package baseball.model.inputvalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRestartInputValidatorTest {
    @ParameterizedTest
    @DisplayName("정확하게 1 과 2 를 입력했을 때만 true 이고 나머지 경우에는 false 이다")
    @CsvSource(value = {
            "1:true",
            "2:true",
            "0:false",
            "3:false",
            "a:false",
            "!:false",
            ":false"
    },
            delimiter = ':')
    public void onlyOneOrTwoReturnsTrue(String userInput, Boolean expectedResult) {
        GameRestartInputValidator gameRestartInputValidator = new GameRestartInputValidator(userInput);
        Boolean validateResult = gameRestartInputValidator.validate();
        assertThat(validateResult).isEqualTo(expectedResult);
    }
}
