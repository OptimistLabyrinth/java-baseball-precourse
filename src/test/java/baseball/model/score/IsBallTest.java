package baseball.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class IsBallTest {
    @ParameterizedTest
    @DisplayName("특정한 숫자가 맞춰야 하는 숫자의 어떤 자리에든 존재하면 '볼' 이다")
    @CsvSource(value = {
            "123:1:true",
            "123:2:true",
            "123:3:true",
            "123:4:false",
            "123:5:false",
            "123:6:false",
            "123:7:false",
            "123:8:false",
            "123:9:false"
    },
            delimiter = ':'
    )
    public void shouldBeStrike(
            String target,
            Character guessCharacter,
            Boolean expectedResult
    ) {
        assertThat(IsBall.check(target, guessCharacter)).isEqualTo(expectedResult);
    }
}
