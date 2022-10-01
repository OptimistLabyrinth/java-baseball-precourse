package baseball.model;

import baseball.constant.NumberBaseballConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    private void setupBeforeEach() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @RepeatedTest(100)
    @DisplayName("숫자는 세 자리이다 - 100번")
    public void lengthShouldBeThree() {
        String randomNumberString = randomNumberGenerator.generate();
        assertThat(randomNumberString.length()).isEqualTo(3);
    }

    @RepeatedTest(100)
    @DisplayName("각 자리의 숫자는 모두 1 ~ 9 범위에 있다 - 100번")
    public void eachDigitShouldBeInRangeOneToNine() {
        String randomNumberString = randomNumberGenerator.generate();
        assertThat(validateEachDigitInRangeOneToNine(randomNumberString)).isEqualTo(true);
    }

    private Boolean validateEachDigitInRangeOneToNine(String str) {
        for (int i = 0; i < NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            if (
                    str.charAt(i) < (char) (NumberBaseballConstant.MINIMUM_OF_EACH_DIGIT + '0') &&
                            (char) (NumberBaseballConstant.MAXIMUM_OF_EACH_DIGIT + '0') < str.charAt(i)
            ) {
                return false;
            }
        }
        return true;
    }

    @RepeatedTest(100)
    @DisplayName("각 자리의 숫자는 다른 자리의 어떤 숫자와도 서로 중복되지 않는다 - 100번")
    public void shouldNotBeAnyDuplicateDigits() {
        String randomNumberString = randomNumberGenerator.generate();
        assertThat(validateNoDuplicateDigitInString(randomNumberString)).isEqualTo(true);
    }

    private Boolean validateNoDuplicateDigitInString(String str) {
        Set<Character> digitsInString = new HashSet<>();
        for (int i = 0; i < NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            digitsInString.add(str.charAt(i));
        }
        return digitsInString.size() == 3;
    }
}
